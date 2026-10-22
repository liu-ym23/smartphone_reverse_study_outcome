package com.android.server.backup.restore;

import android.content.pm.IPackageDeleteObserver;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class RestoreDeleteObserver extends IPackageDeleteObserver.Stub {
    private final AtomicBoolean mDone;

    public RestoreDeleteObserver() {
        this.mDone = new AtomicBoolean();
    }

    public void reset() {
        AtomicBoolean r0 = this.mDone;
        monitor-enter(r0);
        this.mDone.set(false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void waitForCompletion() {
        AtomicBoolean r0 = this.mDone;
        monitor-enter(r0);
    L16:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDone.get() == true) goto L12;
        this.mDone.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
        goto L16
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void packageDeleted(String packageName, int returnCode) throws RemoteException {
        AtomicBoolean r0 = this.mDone;
        monitor-enter(r0);
        this.mDone.set(true);     // Catch: Throwable -> L7
        this.mDone.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
