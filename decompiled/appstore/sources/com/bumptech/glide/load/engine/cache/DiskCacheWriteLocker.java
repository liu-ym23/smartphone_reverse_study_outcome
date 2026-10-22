package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
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

        public WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public WriteLock obtain() {
            Queue<WriteLock> r10 = this.pool;
            monitor-enter(r10);
            WriteLock r11 = this.pool.poll();     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            if (r11 == null) goto L8;
            return r11;
        L8:
            return new WriteLock();
        L9:
            th = move-exception;
            throw th;
        }

        public void offer(WriteLock r10) {
            Queue<WriteLock> r11 = this.pool;
            monitor-enter(r11);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.pool.size() >= 10) goto L9;
            this.pool.offer(r10);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r11);     // Catch: Throwable -> L7
        }
    }

    public DiskCacheWriteLocker() {
        this.locks = new HashMap();
        this.writeLockPool = new WriteLockPool();
    }

    public void acquire(String r10) {
        monitor-enter(this);
        WriteLock r11 = this.locks.get(r10);     // Catch: Throwable -> L6
        if (r11 != null) goto L8;
        r11 = this.writeLockPool.obtain();     // Catch: Throwable -> L6
        this.locks.put(r10, r11);     // Catch: Throwable -> L6
    L8:
        r11.interestedThreads++;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        r11.lock.lock();
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void release(String r10) {
        monitor-enter(this);
        WriteLock r11 = (WriteLock) Preconditions.checkNotNull(this.locks.get(r10));     // Catch: Throwable -> L10
        int r12 = r11.interestedThreads;     // Catch: Throwable -> L10
        if (r12 < 1) goto L18;
        int r13 = r12 - 1;     // Catch: Throwable -> L10
        r11.interestedThreads = r13;     // Catch: Throwable -> L10
        if (r13 != 0) goto L14;
        WriteLock r14 = this.locks.remove(r10);     // Catch: Throwable -> L10
        if (r14.equals(r11) == false) goto L13;
        this.writeLockPool.offer(r14);     // Catch: Throwable -> L10
        goto L14
    L13:
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + r11 + ", but actually removed: " + r14 + ", safeKey: " + r10);     // Catch: Throwable -> L10
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
        r11.lock.unlock();
        return;
    L18:
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + r10 + ", interestedThreads: " + r11.interestedThreads);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
