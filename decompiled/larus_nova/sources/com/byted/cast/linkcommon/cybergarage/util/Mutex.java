package com.byted.cast.linkcommon.cybergarage.util;

/* JADX INFO: loaded from: classes28.dex */
public class Mutex {
    private boolean syncLock;

    public synchronized void lock() {
        monitor-enter(this);
    L16:
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.syncLock != true) goto L10;
        wait();     // Catch: Exception -> L8 Throwable -> L13
    L8:
        e = move-exception;
        Debug.warning(e);     // Catch: Throwable -> L13
        goto L16
    L10:
        this.syncLock = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public synchronized void unlock() {
        monitor-enter(this);
        this.syncLock = false;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Mutex() {
        this.syncLock = false;
    }
}
