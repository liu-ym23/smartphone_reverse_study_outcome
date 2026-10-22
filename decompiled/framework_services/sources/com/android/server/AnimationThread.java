package com.android.server;

import android.os.Handler;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class AnimationThread extends ServiceThread {
    private static Handler sHandler;
    private static AnimationThread sInstance;

    /* JADX INFO: renamed from: $r8$lambda$bIi1i5SyvmJy_CfN-rhIyT2RejM, reason: not valid java name */
    public static /* synthetic */ void m48$r8$lambda$bIi1i5SyvmJy_CfNrhIyT2RejM() {
        lambda$dispose$0();
    }

    private AnimationThread() {
        super("android.anim", -4, false);
    }

    private static void ensureThreadLocked() {
        if (sInstance != null) goto L6;
        sInstance = new AnimationThread();
        sInstance.start();
        sInstance.getLooper().setTraceTag(32);
        sHandler = ServiceThread.makeSharedHandler(sInstance.getLooper());
        Process.setUIFirstSchedEventTrack(Process.myPid(), get().getThreadId(), 2, "system_server", false, 0);
        SysOptBridge.getFactory().getSvpCgroupManager().addSvpBackgroundCgroupThread(Process.myPid(), get().getThreadId());
        return;
    }

    public static AnimationThread get() {
        monitor-enter(AnimationThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        AnimationThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(AnimationThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        monitor-enter(AnimationThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(AnimationThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void dispose() {
        monitor-enter(AnimationThread.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L10;
        monitor-exit(AnimationThread.class);     // Catch: Throwable -> L8
        return;
    L10:
        getHandler().runWithScissors(new AnimationThread$$ExternalSyntheticLambda0(), 0);     // Catch: Throwable -> L8
        sInstance = null;     // Catch: Throwable -> L8
        monitor-exit(AnimationThread.class);     // Catch: Throwable -> L8
    }

    private static /* synthetic */ void lambda$dispose$0() {
        sInstance.quit();
    }
}
