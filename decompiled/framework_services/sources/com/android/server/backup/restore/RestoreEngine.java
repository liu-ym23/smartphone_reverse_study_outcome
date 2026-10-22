package com.android.server.backup.restore;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class RestoreEngine {
    public static final int SUCCESS = 0;
    private static final String TAG = "RestoreEngine";
    public static final int TARGET_FAILURE = -2;
    public static final int TRANSPORT_FAILURE = -3;
    private final AtomicInteger mResult;
    private final AtomicBoolean mRunning;

    public RestoreEngine() {
        this.mRunning = new AtomicBoolean(false);
        this.mResult = new AtomicInteger(0);
    }

    public boolean isRunning() {
        return this.mRunning.get();
    }

    public void setRunning(boolean stillRunning) {
        AtomicBoolean r0 = this.mRunning;
        monitor-enter(r0);
        this.mRunning.set(stillRunning);     // Catch: Throwable -> L7
        this.mRunning.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int waitForResult() {
        AtomicBoolean r0 = this.mRunning;
        monitor-enter(r0);
    L19:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isRunning() == false) goto L12;
        this.mRunning.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
        goto L19
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return getResult();
    }

    public int getResult() {
        return this.mResult.get();
    }

    public void setResult(int result) {
        this.mResult.set(result);
    }
}
