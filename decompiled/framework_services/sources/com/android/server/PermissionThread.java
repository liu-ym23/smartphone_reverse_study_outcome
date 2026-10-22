package com.android.server;

import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionThread extends ServiceThread {
    private static final long SLOW_DELIVERY_THRESHOLD_MS = 200;
    private static final long SLOW_DISPATCH_THRESHOLD_MS = 100;
    private static Handler sHandler;
    private static HandlerExecutor sHandlerExecutor;
    private static PermissionThread sInstance;
    private static final Object sLock = null;

    static {
        sLock = new Object();
    }

    private PermissionThread() {
        super("android.perm", 0, true);
    }

    private static void ensureThreadLocked() {
        if (sInstance == null) goto L5;
        return;
    L5:
        sInstance = new PermissionThread();
        sInstance.start();
        Looper looper = sInstance.getLooper();
        looper.setTraceTag(524288);
        looper.setSlowLogThresholdMs(SLOW_DISPATCH_THRESHOLD_MS, SLOW_DELIVERY_THRESHOLD_MS);
        sHandler = new Handler(sInstance.getLooper());
        sHandlerExecutor = new HandlerExecutor(sHandler);
    }

    public static PermissionThread get() {
        Object r0 = sLock;
        monitor-enter(r0);
        ensureThreadLocked();     // Catch: Throwable -> L7
        PermissionThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        Object r0 = sLock;
        monitor-enter(r0);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Executor getExecutor() {
        Object r0 = sLock;
        monitor-enter(r0);
        ensureThreadLocked();     // Catch: Throwable -> L7
        HandlerExecutor r1 = sHandlerExecutor;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
