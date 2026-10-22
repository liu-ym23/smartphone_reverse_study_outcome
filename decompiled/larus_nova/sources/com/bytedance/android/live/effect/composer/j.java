package com.bytedance.android.live.effect.composer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends SQLiteOpenHelper {

    public static final class a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("live_composer_mode.db", "dbName");
        super(r100, "live_composer_mode.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        System.currentTimeMillis();
        if (r100 == null) goto L5;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_composer_node_by_mode (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mode TEXT, panel TEXT,effect_id TEXT,resource_id TEXT,path TEXT,update_time INTEGER,use INTEGER,is_high_cost INTEGER)");
    L5:
        if (r100 == null) goto L8;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_composer_tag_node_by_mode(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tag TEXT,value REAL,node_id INTEGER)");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.execSQL("Drop Table if exists live_composer_node_by_mode");
        r100.execSQL("Drop Table if exists live_composer_tag_node_by_mode");
        onCreate(r100);
    }
}
