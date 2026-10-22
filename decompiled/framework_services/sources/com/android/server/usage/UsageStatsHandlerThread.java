package com.android.server.usage;

import android.os.Looper;
import com.android.server.ServiceThread;

/* JADX INFO: loaded from: classes3.dex */
public class UsageStatsHandlerThread extends ServiceThread {
    private static final long SLOW_DELIVERY_THRESHOLD_MS = 30000;
    private static final long SLOW_DISPATCH_THRESHOLD_MS = 10000;
    private static UsageStatsHandlerThread sInstance;
    private static final Object sLock = null;

    static {
        sLock = new Object();
    }

    private UsageStatsHandlerThread() {
        super("android.usagestats", 0, true);
    }

    private static void ensureThreadLocked() {
        if (sInstance == null) goto L5;
        return;
    L5:
        sInstance = new UsageStatsHandlerThread();
        sInstance.start();
        Looper looper = sInstance.getLooper();
        looper.setTraceTag(524288);
        looper.setSlowLogThresholdMs(10000, 30000);
    }

    public static UsageStatsHandlerThread get() {
        Object r0 = sLock;
        monitor-enter(r0);
        ensureThreadLocked();     // Catch: Throwable -> L7
        UsageStatsHandlerThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
