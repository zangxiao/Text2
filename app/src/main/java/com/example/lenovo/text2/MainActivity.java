package com.example.lenovo.text2;



import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Button tipsBut;
    private Button loginBut;
    private EditText userId;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipsBut = (Button)findViewById(R.id.TipsBut);
        loginBut = (Button)findViewById(R.id.LoginBut);
        tipsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("请输入账号密码");
        builder.setTitle("提示");
        builder.create().show();
    }

    protected void login_dialog(){
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.login_dialog,(ViewGroup)findViewById(R.id.dialog));
        new AlertDialog.Builder(this).setTitle("自定义布局").setView(layout).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                passWord = (EditText)layout.findViewById(R.id.Passwd);
                userId = (EditText)layout.findViewById(R.id.userID);
                if(userId.getText().toString().equals("abc")&&passWord.getText().toString().equals("123")){
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
                }
            }
        }).setNegativeButton("取消",null).show();
    }
}

