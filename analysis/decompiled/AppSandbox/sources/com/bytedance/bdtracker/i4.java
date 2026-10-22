package com.bytedance.bdtracker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;

/* loaded from: classes.dex */
public class i4 extends SQLiteOpenHelper {
    public final e0 a;

    public i4(e0 e0Var, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(e0Var.b(), str, cursorFactory, i);
        this.a = e0Var;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<e4> it = e4.j().values().iterator();
            while (it.hasNext()) {
                String strA = it.next().a();
                if (strA != null) {
                    sQLiteDatabase.execSQL(strA);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.d.D.debug(5, "Database upgrade from:{} to:{}", Integer.valueOf(i), Integer.valueOf(i2));
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<e4> it = e4.j().values().iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().f());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
                r.a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
            }
        }
        r.a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }
}
