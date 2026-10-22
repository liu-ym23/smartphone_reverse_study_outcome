package com.bytedance.android.live.effect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f68028a;

    public static final class a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, "live_effect.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        this.f68028a = System.currentTimeMillis();
        if (r100 == null) goto L5;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_effect_count (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,effect_id TEXT,count INTEGER)");
    L5:
        ALogger.d("LiveUxTracer", new i(this, WidgetCostModule.TYPE_ON_CREATE));
    }
}
