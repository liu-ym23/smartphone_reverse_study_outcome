package com.android.server.pm;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerTracedLock implements AutoCloseable {
    private static final boolean DEBUG = false;
    private static final String TAG = "PackageManagerTracedLock";
    private final RawLock mLock;

    public static class RawLock extends ReentrantLock {
        private final String mLockName;

        RawLock(String lockName) {
            this.mLockName = lockName;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            super.lock();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();
        }
    }

    public PackageManagerTracedLock(String lockName) {
        this.mLock = new RawLock(lockName);
    }

    public PackageManagerTracedLock() {
        this(null);
    }

    public PackageManagerTracedLock acquireLock() {
        this.mLock.lock();
        return this;
    }

    public RawLock getRawLock() {
        return this.mLock;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mLock.unlock();
    }
}
