package com.bytedance.bdturing.localstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DbHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DbHelper extends SQLiteOpenHelper {
    public static final String COL_CONTENT = "content";
    public static final String COL_ID = "id";
    public static final String COL_KEY = "primary_key";
    public static final String COL_TIME_STAMP = "time_stamp";
    public static final a Companion = null;
    public static final String DATABASE_NAME = "verifystorage.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_H5_STORAGE = "h5_storage";

    /* JADX INFO: compiled from: DbHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        o.d(r1, MonitorConstants.DB);
    }

    public DbHelper(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), DATABASE_NAME, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        o.d(r1, MonitorConstants.DB);
        r1.execSQL("CREATE TABLE IF NOT EXISTS h5_storage (\n    id INTEGER PRIMARY KEY AUTOINCREMENT,\n    primary_key TEXT,\n    time_stamp LONG, \n    content TEXT\n    )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        o.d(r1, MonitorConstants.DB);
        r1.execSQL("DROP TABLE h5_storage");
        onCreate(r1);
    }
}
