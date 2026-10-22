package com.android.server.wm;

import android.os.Process;
import com.android.server.AnimationThread;
import com.android.server.ThreadPriorityBooster;

/* JADX INFO: loaded from: classes3.dex */
class WindowManagerThreadPriorityBooster extends ThreadPriorityBooster {
    private final int mAnimationThreadId;
    private boolean mAppTransitionRunning;
    private boolean mBoundsAnimationRunning;
    private final Object mLock;
    private final int mSurfaceAnimationThreadId;

    WindowManagerThreadPriorityBooster() {
        super(-4, 5);
        this.mLock = new Object();
        this.mAnimationThreadId = AnimationThread.get().getThreadId();
        this.mSurfaceAnimationThreadId = SurfaceAnimationThread.get().getThreadId();
    }

    @Override // com.android.server.ThreadPriorityBooster
    public void boost() {
        int myTid = Process.myTid();
        if (myTid != this.mAnimationThreadId) goto L5;
        return;
    L5:
        if (myTid == this.mSurfaceAnimationThreadId) goto L10;
        super.boost();
        return;
    }

    @Override // com.android.server.ThreadPriorityBooster
    public void reset() {
        int myTid = Process.myTid();
        if (myTid != this.mAnimationThreadId) goto L5;
        return;
    L5:
        if (myTid == this.mSurfaceAnimationThreadId) goto L10;
        super.reset();
        return;
    }

    void setAppTransitionRunning(boolean running) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppTransitionRunning == running) goto L9;
        this.mAppTransitionRunning = running;     // Catch: Throwable -> L7
        updatePriorityLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void setBoundsAnimationRunning(boolean running) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mBoundsAnimationRunning == running) goto L9;
        this.mBoundsAnimationRunning = running;     // Catch: Throwable -> L7
        updatePriorityLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void updatePriorityLocked() {
        if (this.mAppTransitionRunning == false) goto L5;
    L8:
        int priority = -10;
    L9:
        setBoostToPriority(priority);
        Process.setThreadPriority(this.mAnimationThreadId, priority);
        Process.setThreadPriority(this.mSurfaceAnimationThreadId, priority);
        return;
    L5:
        if (this.mBoundsAnimationRunning == true) goto L8;
        priority = -4;
        goto L9
    }
}
