package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.autonavi.aps.amapapi.utils.CoreUtil;

/* loaded from: classes.dex */
public class SdCardDbCreator {
    public static final String FIELD_LASTLOC_ID = "a1";
    public static final String FIELD_LASTLOC_INFO = "a2";
    public static final String FIELD_LASTLOC_NB = "a4";
    public static final String FIELD_LASTLOC_TIME = "a3";
    public static final String TABLE_LASTLOC = "c";

    public String getDBName() {
        return "alsn20170807.db";
    }

    public int getVersion() {
        return 1;
    }

    public void initDataBase(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS c");
            onCreate(sQLiteDatabase);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SdCardDbCreator", "initDataBase");
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            CoreUtil.reportError(th, "SdCardDbCreator", "onCreate");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
