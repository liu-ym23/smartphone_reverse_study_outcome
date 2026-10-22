package com.android.server.hdmi;

import android.os.Binder;

/* JADX INFO: loaded from: classes2.dex */
public class WorkSourceUidPreservingRunnable implements Runnable {
    private Runnable mRunnable;
    private int mUid;

    public WorkSourceUidPreservingRunnable(Runnable runnable) {
        this.mRunnable = runnable;
        this.mUid = Binder.getCallingWorkSourceUid();
    }

    @Override // java.lang.Runnable
    public void run() {
        long token = Binder.setCallingWorkSourceUid(this.mUid);
        this.mRunnable.run();     // Catch: Throwable -> L6
        Binder.restoreCallingWorkSource(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingWorkSource(token);
        throw th;
    }
}
