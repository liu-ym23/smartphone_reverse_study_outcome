package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0014J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/ReentrantLockEmptyImpl;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "newCondition", "", "lock", "lockInterruptibly", "", "tryLock", "", "timeout", "Ljava/util/concurrent/TimeUnit;", Scraps.INNER_UNIT, "unlock", "", "getHoldCount", "isHeldByCurrentThread", "isLocked", "Ljava/lang/Thread;", "getOwner", "", "getQueuedThreads", "condition", "hasWaiters", "getWaitQueueLength", "getWaitingThreads", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReentrantLockEmptyImpl extends ReentrantLock {

    public static final class a implements Condition {
        public a() {
        }

        @Override // java.util.concurrent.locks.Condition
        public final void await() {
        }

        @Override // java.util.concurrent.locks.Condition
        public final boolean await(long r100, TimeUnit r101) {
            return false;
        }

        @Override // java.util.concurrent.locks.Condition
        public final long awaitNanos(long r100) {
            return 0;
        }

        @Override // java.util.concurrent.locks.Condition
        public final void awaitUninterruptibly() {
        }

        @Override // java.util.concurrent.locks.Condition
        public final boolean awaitUntil(Date r100) {
            return false;
        }

        @Override // java.util.concurrent.locks.Condition
        public final void signal() {
        }

        @Override // java.util.concurrent.locks.Condition
        public final void signalAll() {
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public int getHoldCount() {
        return 0;
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public boolean isHeldByCurrentThread() {
        return false;
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public boolean isLocked() {
        return false;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void lock() {
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void lockInterruptibly() {
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return false;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public boolean tryLock(long r100, TimeUnit r101) {
        return false;
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void unlock() {
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public Condition newCondition() {
        return new a();
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public Thread getOwner() {
        return super.getOwner();
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public Collection<Thread> getQueuedThreads() {
        return super.getQueuedThreads();
    }

    public ReentrantLockEmptyImpl() {
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public int getWaitQueueLength(Condition r100) {
        return super.getWaitQueueLength(r100);
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public Collection<Thread> getWaitingThreads(Condition r100) {
        return super.getWaitingThreads(r100);
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public boolean hasWaiters(Condition r100) {
        return super.hasWaiters(r100);
    }
}
