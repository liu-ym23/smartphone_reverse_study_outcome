package com.android.server;

import android.os.Handler;
import android.os.HandlerExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class IoThread extends ServiceThread {
    private static Handler sHandler;
    private static HandlerExecutor sHandlerExecutor;
    private static IoThread sInstance;

    private IoThread() {
        super("android.io", 0, true);
    }

    private static void ensureThreadLocked() {
        if (sInstance != null) goto L6;
        sInstance = new IoThread();
        sInstance.start();
        sInstance.getLooper().setTraceTag(524288);
        sHandler = ServiceThread.makeSharedHandler(sInstance.getLooper());
        sHandlerExecutor = new HandlerExecutor(sHandler);
        return;
    }

    public static IoThread get() {
        monitor-enter(IoThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        IoThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(IoThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        monitor-enter(IoThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(IoThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Executor getExecutor() {
        monitor-enter(IoThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        HandlerExecutor r1 = sHandlerExecutor;     // Catch: Throwable -> L7
        monitor-exit(IoThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
