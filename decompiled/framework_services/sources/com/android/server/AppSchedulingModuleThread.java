package com.android.server;

import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class AppSchedulingModuleThread extends HandlerThread {
    private static final long SLOW_DELIVERY_THRESHOLD_MS = 30000;
    private static final long SLOW_DISPATCH_THRESHOLD_MS = 10000;
    private static Handler sHandler;
    private static Executor sHandlerExecutor;
    private static AppSchedulingModuleThread sInstance;

    private AppSchedulingModuleThread() {
        super("appscheduling.default", 0);
    }

    private static void ensureThreadLocked() {
        if (sInstance != null) goto L6;
        sInstance = new AppSchedulingModuleThread();
        sInstance.start();
        Looper looper = sInstance.getLooper();
        looper.setTraceTag(524288);
        looper.setSlowLogThresholdMs(10000, 30000);
        sHandler = new Handler(sInstance.getLooper());
        sHandlerExecutor = new HandlerExecutor(sHandler);
        return;
    }

    public static AppSchedulingModuleThread get() {
        monitor-enter(AppSchedulingModuleThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        AppSchedulingModuleThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(AppSchedulingModuleThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        monitor-enter(AppSchedulingModuleThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(AppSchedulingModuleThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Executor getExecutor() {
        monitor-enter(AppSchedulingModuleThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Executor r1 = sHandlerExecutor;     // Catch: Throwable -> L7
        monitor-exit(AppSchedulingModuleThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
