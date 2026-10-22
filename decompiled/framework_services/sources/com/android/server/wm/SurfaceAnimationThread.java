package com.android.server.wm;

import android.os.Handler;
import android.os.Process;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes3.dex */
public final class SurfaceAnimationThread extends ServiceThread {
    private static Handler sHandler;
    private static SurfaceAnimationThread sInstance;

    public static /* synthetic */ void $r8$lambda$3GJotUG5Wimi4udmr0Ve48BcasQ() {
        lambda$dispose$0();
    }

    private SurfaceAnimationThread() {
        super("android.anim.lf", -4, false);
    }

    private static void ensureThreadLocked() {
        if (sInstance != null) goto L6;
        sInstance = new SurfaceAnimationThread();
        sInstance.start();
        sInstance.getLooper().setTraceTag(32);
        sHandler = ServiceThread.makeSharedHandler(sInstance.getLooper());
        Process.setUIFirstSchedEventTrack(Process.myPid(), get().getThreadId(), 2, "system_server", false, 0);
        SysOptBridge.getFactory().getSvpCgroupManager().addSvpBackgroundCgroupThread(Process.myPid(), get().getThreadId());
        return;
    }

    public static SurfaceAnimationThread get() {
        monitor-enter(SurfaceAnimationThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        SurfaceAnimationThread r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(SurfaceAnimationThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler getHandler() {
        monitor-enter(SurfaceAnimationThread.class);
        ensureThreadLocked();     // Catch: Throwable -> L7
        Handler r1 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(SurfaceAnimationThread.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void dispose() {
        monitor-enter(SurfaceAnimationThread.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L10;
        monitor-exit(SurfaceAnimationThread.class);     // Catch: Throwable -> L8
        return;
    L10:
        getHandler().runWithScissors(new SurfaceAnimationThread$$ExternalSyntheticLambda0(), 0);     // Catch: Throwable -> L8
        sInstance = null;     // Catch: Throwable -> L8
        monitor-exit(SurfaceAnimationThread.class);     // Catch: Throwable -> L8
    }

    private static /* synthetic */ void lambda$dispose$0() {
        sInstance.quit();
    }
}
