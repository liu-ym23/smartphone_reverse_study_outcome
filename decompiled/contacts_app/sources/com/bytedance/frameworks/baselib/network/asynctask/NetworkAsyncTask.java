package com.bytedance.frameworks.baselib.network.asynctask;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NetworkAsyncTask implements Runnable {
    private long mInitialDelay;
    private long mLoopInterval;
    private NetworkAsyncTaskType mTaskType;
    private TimeUnit mTimeUnit;

    public NetworkAsyncTask() {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
    }

    public NetworkAsyncTask(long r3) {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
        this.mLoopInterval = r3;
    }

    public NetworkAsyncTask(long r1, long r3) {
        this(r3);
        this.mInitialDelay = r1;
    }

    public NetworkAsyncTask(long r1, long r3, TimeUnit r5) {
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

    public void setTaskType(NetworkAsyncTaskType r1) {
        this.mTaskType = r1;
    }

    public NetworkAsyncTaskType getTaskType() {
        return this.mTaskType;
    }
}
