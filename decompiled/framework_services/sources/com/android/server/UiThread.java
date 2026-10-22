package com.android.server;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class UiThread extends ServiceThread {
    private static final long SLOW_DELIVERY_THRESHOLD_MS = 200;
    private static final long SLOW_DISPATCH_THRESHOLD_MS = 100;
    private static Handler sHandler;
    private static UiThread sInstance;

    private UiThread() {
        super("android.ui", -2, false);
    }

    public void run() {
        Process.setThreadGroup(Process.myTid(), 5);
        super.run();
    }

    private static void ensureThreadLocked() {
        if (sInstance != null) goto L6;
        sInstance = new UiThread();
        sInstance.start();
        Looper looper = sInstance.getLooper();
        looper.setTraceTag(524288);
        looper.setSlowLogThresholdMs(SLOW_DISPATCH_THRESHOLD_MS, SLOW_DELIVERY_THRESHOLD_MS);
        sHandler = ServiceThread.makeSharedHandler(sInstance.getLooper());
        return;
    }

    public static UiThread get() {
        monitor-enter(UiThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        UiThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(UiThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        monitor-enter(UiThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(UiThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void dispose() {
        monitor-enter(UiThread.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L10;
        monitor-exit(UiThread.class);     // Catch: Throwable -> L8
        return;
    L10:
        Handler r1 = getHandler();     // Catch: Throwable -> L8
        final UiThread r2 = sInstance;     // Catch: Throwable -> L8
        r2.getClass();     // Catch: Throwable -> L8
        r1.runWithScissors(new UiThread$$ExternalSyntheticLambda0(r2), 0);     // Catch: Throwable -> L8
        sInstance = null;     // Catch: Throwable -> L8
        monitor-exit(UiThread.class);     // Catch: Throwable -> L8
    }
}
