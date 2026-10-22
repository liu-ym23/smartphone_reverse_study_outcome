package com.android.server.notification;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RankingReconsideration implements Runnable {
    private static final int CANCELLED = 3;
    private static final int DONE = 2;
    private static final long IMMEDIATE = 0;
    private static final int RUNNING = 1;
    private static final int START = 0;
    private long mDelay;
    protected String mKey;
    private int mState;

    public abstract void applyChangesLocked(NotificationRecord r1);

    public abstract void work();

    public RankingReconsideration(String key) {
        this(key, 0);
    }

    public RankingReconsideration(String key, long delay) {
        this.mDelay = delay;
        this.mKey = key;
        this.mState = 0;
    }

    public String getKey() {
        return this.mKey;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mState != 0) goto L12;
        this.mState = 1;
        work();
        this.mState = 2;
        monitor-enter(this);
        notifyAll();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(this.mDelay, TimeUnit.MILLISECONDS);
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (this.mState != 0) goto L6;
        this.mState = 3;
        return true;
    L6:
        return false;
    }

    public boolean isCancelled() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDone() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
