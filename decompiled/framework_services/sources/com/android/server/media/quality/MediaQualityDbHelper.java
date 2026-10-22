package com.android.server.media.quality;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class MediaQualityDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "media_quality.db";
    static final int DATABASE_VERSION_1 = 1;
    public static final String PICTURE_QUALITY_TABLE_NAME = "picture_quality";
    public static final String SETTINGS = "settings";
    public static final String SOUND_QUALITY_TABLE_NAME = "sound_quality";
    private static final String TAG = "MediaQualityDbHelper";

    MediaQualityDbHelper(Context context) {
        super(context, DATABASE_NAME, null, getDbVersion());
    }

    private static int getDbVersion() {
        return 1;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getTableCreateStatement(PICTURE_QUALITY_TABLE_NAME));
        db.execSQL(getTableCreateStatement(SOUND_QUALITY_TABLE_NAME));
    }

    private String getTableCreateStatement(String tableName) {
        return "CREATE TABLE " + tableName + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,_type INTEGER,_name STRING,_package STRING,_input_id STRING,settings TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
