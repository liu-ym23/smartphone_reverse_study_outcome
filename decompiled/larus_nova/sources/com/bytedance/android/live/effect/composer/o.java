package com.bytedance.android.live.effect.composer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o extends SQLiteOpenHelper {

    public static final class a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        System.currentTimeMillis();
        if (r100 == null) goto L5;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_composer_node (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,panel TEXT,effect_id TEXT,resource_id TEXT,path TEXT,update_time INTEGER,use INTEGER,is_high_cost INTEGER)");
    L5:
        if (r100 == null) goto L8;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_composer_tag_node(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tag TEXT,value REAL,node_id INTEGER)");
        return;
    }

    public o(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dbName");
        super(r100, r101, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.execSQL("Drop Table if exists live_composer_node");
        r100.execSQL("Drop Table if exists live_composer_tag_node");
        onCreate(r100);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        if (r101 >= 2) goto L7;
        if (r100 == null) goto L7;
        r100.execSQL("ALTER TABLE live_composer_node ADD COLUMN resource_id TEXT DEFAULT \"\" NOT NULL;");
    L7:
        if (r101 >= 3) goto L11;
        if (r100 == null) goto L12;
        r100.execSQL("ALTER TABLE live_composer_node ADD COLUMN is_high_cost INTEGER DEFAULT 0 NOT NULL;");
        return;
    L12:
        return;
    }
}
