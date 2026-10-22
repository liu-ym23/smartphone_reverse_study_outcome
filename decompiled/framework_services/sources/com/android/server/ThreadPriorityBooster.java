package com.android.server;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class ThreadPriorityBooster {
    private static final boolean ENABLE_LOCK_GUARD = false;
    private static final int PRIORITY_NOT_ADJUSTED = Integer.MAX_VALUE;
    private volatile int mBoostToPriority;
    private final int mLockGuardIndex;
    private final ThreadLocal<PriorityState> mThreadState;

    private static class PriorityState {
        int prevPriority;
        int regionCounter;
        final int tid;

        /* synthetic */ PriorityState(ThreadPriorityBoosterIA r1) {
            this();
        }

        private PriorityState() {
            this.tid = Process.myTid();
            this.prevPriority = Integer.MAX_VALUE;
        }
    }

    public ThreadPriorityBooster(int boostToPriority, int lockGuardIndex) {
        this.mThreadState = new AnonymousClass1(this);
        this.mBoostToPriority = boostToPriority;
        this.mLockGuardIndex = lockGuardIndex;
    }

    public void boost() {
        PriorityState state = this.mThreadState.get();
        if (state.regionCounter != 0) goto L7;
        int prevPriority = Process.getThreadPriority(state.tid);
        if (prevPriority <= this.mBoostToPriority) goto L7;
        Process.setThreadPriority(state.tid, this.mBoostToPriority);
        state.prevPriority = prevPriority;
    L7:
        state.regionCounter++;
    }

    public void reset() {
        PriorityState state = this.mThreadState.get();
        state.regionCounter--;
        if (state.regionCounter == 0) goto L5;
        return;
    L5:
        if (state.prevPriority == Integer.MAX_VALUE) goto L9;
        Process.setThreadPriority(state.tid, state.prevPriority);
        state.prevPriority = Integer.MAX_VALUE;
        return;
    }

    protected void setBoostToPriority(int priority) {
        this.mBoostToPriority = priority;
        PriorityState state = this.mThreadState.get();
        if (state.regionCounter == 0) goto L8;
        int prevPriority = Process.getThreadPriority(state.tid);
        if (prevPriority == priority) goto L9;
        Process.setThreadPriority(state.tid, priority);
        return;
    L9:
        return;
    }
}
