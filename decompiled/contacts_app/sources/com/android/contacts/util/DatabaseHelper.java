package com.android.contacts.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE_SQL;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
    }

    public DatabaseHelper(Context r2, String r3, int r4) {
        super(r2, r3, null, r4);
        this.CREATE_TABLE_SQL = "create table dict(_id integer primary key autoincrement , num , city,isp)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
        System.out.println("--------onUpdate Called--------" + r3 + "--->" + r4);
    }
}
