package com.android.contacts.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsDatabaseHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE_SQL;

    public ContactsDatabaseHelper(Context r3, String r4, int r5) {
        super(r3, "/sdcard/" + r4, null, r5);
        this.CREATE_TABLE_SQL = "create table dict(_id integer primary key autoincrement , num , city,isp)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL("create table dict(_id integer primary key autoincrement , num , city,isp)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
        System.out.println("--------onUpdate Called--------" + r3 + "--->" + r4);
    }
}
