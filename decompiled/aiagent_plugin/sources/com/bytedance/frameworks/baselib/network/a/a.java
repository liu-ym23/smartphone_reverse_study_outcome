package com.bytedance.frameworks.baselib.network.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: NetworkAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {
    private long mInitialDelay;
    private long mLoopInterval;
    private c mTaskType;
    private TimeUnit mTimeUnit;

    public a() {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
    }

    public a(long r3) {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
        this.mLoopInterval = r3;
    }

    public a(long r1, long r3) {
        this(r3);
        this.mInitialDelay = r1;
    }

    public a(long r1, long r3, TimeUnit r5) {
        this(r1, r3);
        this.mTimeUnit = r5;
    }

    public boolean isLoop() {
        if (this.mLoopInterval <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public TimeUnit getTimeUnit() {
        return this.mTimeUnit;
    }

    public void setTaskType(c r1) {
        this.mTaskType = r1;
    }

    public c getTaskType() {
        return this.mTaskType;
    }
}
