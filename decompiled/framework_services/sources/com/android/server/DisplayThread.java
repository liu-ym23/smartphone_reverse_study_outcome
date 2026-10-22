package com.android.server;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayThread extends ServiceThread {
    private static Handler sHandler;
    private static DisplayThread sInstance;

    /* JADX INFO: renamed from: $r8$lambda$OmO09J-Etm9NvT4ZjAGhlVFYtqs, reason: not valid java name */
    public static /* synthetic */ void m203$r8$lambda$OmO09JEtm9NvT4ZjAGhlVFYtqs() {
        lambda$dispose$0();
    }

    private DisplayThread() {
        super("android.display", -3, false);
    }

    private static void ensureThreadLocked() {
        if (sInstance != null) goto L6;
        sInstance = new DisplayThread();
        sInstance.start();
        sInstance.getLooper().setTraceTag(524288);
        sHandler = ServiceThread.makeSharedHandler(sInstance.getLooper());
        return;
    }

    public static DisplayThread get() {
        monitor-enter(DisplayThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        DisplayThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(DisplayThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        monitor-enter(DisplayThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(DisplayThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void dispose() {
        monitor-enter(DisplayThread.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L10;
        monitor-exit(DisplayThread.class);     // Catch: Throwable -> L8
        return;
    L10:
        getHandler().runWithScissors(new DisplayThread$$ExternalSyntheticLambda0(), 0);     // Catch: Throwable -> L8
        sInstance = null;     // Catch: Throwable -> L8
        monitor-exit(DisplayThread.class);     // Catch: Throwable -> L8
    }

    private static /* synthetic */ void lambda$dispose$0() {
        sInstance.quit();
    }
}
