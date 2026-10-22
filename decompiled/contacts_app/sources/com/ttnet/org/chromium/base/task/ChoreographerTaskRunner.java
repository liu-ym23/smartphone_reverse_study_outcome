package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes4.dex */
final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    ChoreographerTaskRunner(Choreographer r1) {
        this.mChoreographer = r1;
    }

    @Override // com.ttnet.org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        if (this.mChoreographer != Choreographer.getInstance()) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(final Runnable r3) {
        this.mChoreographer.postFrameCallback(new AnonymousClass1(this, r3));
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(final Runnable r3, long r4) {
        this.mChoreographer.postFrameCallbackDelayed(new AnonymousClass2(this, r3), r4);
    }
}
