package com.bytedance.compression.zstd;

import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Closeable {
    private static final int SHARED_LOCK_CLOSED = -1;
    private static final AtomicIntegerFieldUpdater<a> SHARED_LOCK_UPDATER = null;
    private volatile int sharedLock;

    static {
        SHARED_LOCK_UPDATER = AtomicIntegerFieldUpdater.newUpdater(a.class, "sharedLock");
    }

    public a() {
    }

    public void acquireSharedLock() {
    L2:
        int r10 = this.sharedLock;
        if (r10 < 0) goto L12;
        if (r10 == Integer.MAX_VALUE) goto L10;
        if (SHARED_LOCK_UPDATER.compareAndSet(this, r10, r10 + 1) == false) goto L2;
        return;
    L10:
        throw new IllegalStateException("Shared lock overflow");
    L12:
        throw new IllegalStateException("Closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.sharedLock != (-1)) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L10:
        if (SHARED_LOCK_UPDATER.compareAndSet(this, 0, -1) == false) goto L15;
        doClose();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L15:
        throw new IllegalStateException("Attempt to close while in use");     // Catch: Throwable -> L7
    }

    public abstract void doClose();

    public void releaseSharedLock() {
    L2:
        int r10 = this.sharedLock;
        if (r10 < 0) goto L11;
        if (r10 == 0) goto L9;
        if (SHARED_LOCK_UPDATER.compareAndSet(this, r10, r10 - 1) == false) goto L2;
        return;
    L9:
        throw new IllegalStateException("Shared lock underflow");
    L11:
        throw new IllegalStateException("Closed");
    }

    public void storeFence() {
        this.sharedLock = 0;
    }
}
