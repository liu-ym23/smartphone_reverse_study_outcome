package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
final class AppErrorResult {
    boolean mHasResult;
    int mResult;

    AppErrorResult() {
        this.mHasResult = false;
    }

    public void set(int res) {
        monitor-enter(this);
        this.mHasResult = true;     // Catch: Throwable -> L7
        this.mResult = res;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int get() {
        monitor-enter(this);
    L16:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasResult == true) goto L11;
        wait();     // Catch: Throwable -> L7 InterruptedException -> L9
        goto L16
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
        return this.mResult;
    }
}
