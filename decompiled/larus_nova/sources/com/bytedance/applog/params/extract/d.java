package com.bytedance.applog.params.extract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends SQLiteOpenHelper {
    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, "applog_params_extract.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        super.onConfigure(r100);
        r100.enableWriteAheadLogging();     // Catch: Exception -> L5
        r100.execSQL("PRAGMA synchronous=NORMAL");     // Catch: Exception -> L5
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("CREATE TABLE IF NOT EXISTS cp_entries (\n    cp_id TEXT PRIMARY KEY,\n    session_id TEXT NOT NULL,\n    json TEXT NOT NULL,\n    created_at INTEGER NOT NULL\n)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("DROP INDEX IF EXISTS idx_cp_entries_session_id");
        onCreate(r100);
    }
}
