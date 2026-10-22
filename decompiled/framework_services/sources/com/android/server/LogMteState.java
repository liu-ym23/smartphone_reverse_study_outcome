package com.android.server;

import android.app.StatsManager;
import android.content.Context;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes.dex */
public class LogMteState {
    public LogMteState() {
    }

    public static void register(Context context) {
        ((StatsManager) context.getSystemService(StatsManager.class)).setPullAtomCallback(FrameworkStatsLog.MTE_STATE, null, ConcurrentUtils.DIRECT_EXECUTOR, new AnonymousClass1());
    }
}
