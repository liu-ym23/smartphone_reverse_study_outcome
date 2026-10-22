package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes39.dex */
final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks;
    private final WriteLockPool writeLockPool;

    public static class WriteLock {
        int interestedThreads;
        final Lock lock;

        public WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;

        public WriteLock obtain() {
            Queue<WriteLock> r100 = this.pool;
            monitor-enter(r100);
            WriteLock r101 = this.pool.poll();     // Catch: Throwable -> L9
            monitor-exit(r100);     // Catch: Throwable -> L9
            if (r101 == null) goto L8;
            return r101;
        L8:
            return new WriteLock();
        L9:
            th = move-exception;
            throw th;
        }

        public WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public void offer(WriteLock r100) {
            Queue<WriteLock> r101 = this.pool;
            monitor-enter(r101);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.pool.size() >= 10) goto L7;
            this.pool.offer(r100);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
        }
    }

    public DiskCacheWriteLocker() {
        this.locks = new HashMap();
        this.writeLockPool = new WriteLockPool();
    }

    public void acquire(String r100) {
        monitor-enter(this);
        WriteLock r101 = this.locks.get(r100);     // Catch: Throwable -> L10
        if (r101 != null) goto L6;
        r101 = this.writeLockPool.obtain();     // Catch: Throwable -> L10
        this.locks.put(r100, r101);     // Catch: Throwable -> L10
    L6:
        r101.interestedThreads++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r101.lock.lock();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void release(String r100) {
        monitor-enter(this);
        WriteLock r101 = (WriteLock) Preconditions.checkNotNull(this.locks.get(r100));     // Catch: Throwable -> L18
        int r102 = r101.interestedThreads;     // Catch: Throwable -> L18
        if (r102 < 1) goto L17;
        int r103 = r102 - 1;     // Catch: Throwable -> L18
        r101.interestedThreads = r103;     // Catch: Throwable -> L18
        if (r103 != 0) goto L13;
        WriteLock r104 = this.locks.remove(r100);     // Catch: Throwable -> L18
        if (r104.equals(r101) == false) goto L12;
        this.writeLockPool.offer(r104);     // Catch: Throwable -> L18
        goto L13
    L12:
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + r101 + ", but actually removed: " + r104 + ", safeKey: " + r100);     // Catch: Throwable -> L18
    L13:
        monitor-exit(this);     // Catch: Throwable -> L18
        r101.lock.unlock();
        return;
    L17:
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + r100 + ", interestedThreads: " + r101.interestedThreads);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
