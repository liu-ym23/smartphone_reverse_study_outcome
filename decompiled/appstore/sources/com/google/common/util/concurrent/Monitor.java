package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Monitor {

    @GuardedBy("lock")
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    @Beta
    public static abstract class Guard {
        final Condition condition;

        @Weak
        final Monitor monitor;

        @NullableDecl
        @GuardedBy("monitor.lock")
        Guard next;

        @GuardedBy("monitor.lock")
        int waiterCount;

        public Guard(Monitor r10) {
            this.waiterCount = 0;
            this.monitor = (Monitor) Preconditions.checkNotNull(r10, "monitor");
            this.condition = Monitor.access$000(r10).newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    public static /* synthetic */ ReentrantLock access$000(Monitor r10) {
        return r10.lock;
    }

    @GuardedBy("lock")
    private void await(Guard r10, boolean r11) throws InterruptedException {
        if (r11 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r10);
    L12:
        r10.condition.await();     // Catch: Throwable -> L9
        if (r10.isSatisfied() == false) goto L12;
        endWaitingFor(r10);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r10);
        throw th;
    }

    @GuardedBy("lock")
    private boolean awaitNanos(Guard r10, long r11, boolean r12) throws InterruptedException {
        boolean r13 = true;
    L4:
        if (r11 <= 0) goto L5;
        if (r13 == false) goto L14;
        if (r12 == true) goto L22;
    L13:
        beginWaitingFor(r10);     // Catch: Throwable -> L11
        r13 = false;
        goto L14
    L22:
        signalNextWaiter();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r13 == true) goto L21;
        endWaitingFor(r10);
    L21:
        throw th;
    L14:
        r11 = r10.condition.awaitNanos(r11);     // Catch: Throwable -> L11
        if (r10.isSatisfied() == false) goto L4;
        if (r13 == true) goto L18;
        endWaitingFor(r10);
    L18:
        return true;
    L5:
        if (r13 == true) goto L7;
        endWaitingFor(r10);
    L7:
        return false;
    }

    @GuardedBy("lock")
    private void awaitUninterruptibly(Guard r10, boolean r11) {
        if (r11 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r10);
    L12:
        r10.condition.awaitUninterruptibly();     // Catch: Throwable -> L9
        if (r10.isSatisfied() == false) goto L12;
        endWaitingFor(r10);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r10);
        throw th;
    }

    @GuardedBy("lock")
    private void beginWaitingFor(Guard r10) {
        int r11 = r10.waiterCount;
        r10.waiterCount = r11 + 1;
        if (r11 != 0) goto L6;
        r10.next = this.activeGuards;
        this.activeGuards = r10;
        return;
    }

    @GuardedBy("lock")
    private void endWaitingFor(Guard r10) {
        int r11 = r10.waiterCount - 1;
        r10.waiterCount = r11;
        if (r11 != 0) goto L11;
        Guard r12 = this.activeGuards;
        Guard r13 = null;
    L5:
        if (r12 == r10) goto L6;
        r13 = r12;
        r12 = r12.next;
        goto L5
    L6:
        if (r13 != null) goto L8;
        this.activeGuards = r12.next;
    L9:
        r12.next = null;
        return;
    L8:
        r13.next = r12.next;
        goto L9
    }

    private static long initNanoTime(long r10) {
        if (r10 > 0) goto L5;
        return 0;
    L5:
        long r11 = System.nanoTime();
        if (r11 != 0) goto L9;
        return 1;
    L9:
        return r11;
    }

    @GuardedBy("lock")
    private boolean isSatisfied(Guard r10) {
        return r10.isSatisfied();
    L4:
        th = move-exception;
        signalAllWaiters();
        throw th;
    }

    private static long remainingNanos(long r10, long r11) {
        if (r11 > 0) goto L6;
        return 0;
    L6:
        return r11 - (System.nanoTime() - r10);
    }

    @GuardedBy("lock")
    private void signalAllWaiters() {
        Guard r10 = this.activeGuards;
    L3:
        if (r10 == null) goto L5;
        r10.condition.signalAll();
        r10 = r10.next;
        goto L3
    }

    @GuardedBy("lock")
    private void signalNextWaiter() {
        Guard r10 = this.activeGuards;
    L3:
        if (r10 == null) goto L11;
        if (isSatisfied(r10) == true) goto L6;
        r10 = r10.next;
        goto L3
    L6:
        r10.condition.signal();
        return;
    }

    private static long toSafeNanos(long r10, TimeUnit r11) {
        long r12 = r11.toNanos(r10);
        long r13 = 0;
        if (r12 <= 0) goto L8;
        r13 = 6917529027641081853L;
        if (r12 > 6917529027641081853L) goto L8;
        return r12;
    L8:
        return r13;
    }

    public void enter() {
        this.lock.lock();
    }

    public boolean enterIf(Guard r10) {
        if (r10.monitor != this) goto L13;
        ReentrantLock r11 = this.lock;
        r11.lock();
        boolean r12 = r10.isSatisfied();     // Catch: Throwable -> L9
        if (r12 == true) goto L8;
        r11.unlock();
    L8:
        return r12;
    L9:
        th = move-exception;
        r11.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r10) throws InterruptedException {
        if (r10.monitor != this) goto L13;
        ReentrantLock r11 = this.lock;
        r11.lockInterruptibly();
        boolean r12 = r10.isSatisfied();     // Catch: Throwable -> L9
        if (r12 == true) goto L8;
        r11.unlock();
    L8:
        return r12;
    L9:
        th = move-exception;
        r11.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public void enterWhen(Guard r10) throws InterruptedException {
        if (r10.monitor != this) goto L15;
        ReentrantLock r11 = this.lock;
        boolean r12 = r11.isHeldByCurrentThread();
        r11.lockInterruptibly();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r10.isSatisfied() == true) goto L11;
        await(r10, r12);     // Catch: Throwable -> L9
        return;
    L11:
        return;
    L15:
        throw new IllegalMonitorStateException();
    }

    public void enterWhenUninterruptibly(Guard r10) {
        if (r10.monitor != this) goto L15;
        ReentrantLock r11 = this.lock;
        boolean r12 = r11.isHeldByCurrentThread();
        r11.lock();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r10.isSatisfied() == true) goto L11;
        awaitUninterruptibly(r10, r12);     // Catch: Throwable -> L9
        return;
    L11:
        return;
    L15:
        throw new IllegalMonitorStateException();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public int getWaitQueueLength(Guard r10) {
        if (r10.monitor != this) goto L12;
        this.lock.lock();
        int r11 = r10.waiterCount;     // Catch: Throwable -> L8
        this.lock.unlock();
        return r11;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L12:
        throw new IllegalMonitorStateException();
    }

    public boolean hasQueuedThread(Thread r10) {
        return this.lock.hasQueuedThread(r10);
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard r10) {
        if (getWaitQueueLength(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock r10 = this.lock;
    L7:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if (r10.getHoldCount() != 1) goto L9;
        signalNextWaiter();     // Catch: Throwable -> L7
    L9:
        r10.unlock();
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public boolean tryEnterIf(Guard r10) {
        if (r10.monitor != this) goto L16;
        ReentrantLock r11 = this.lock;
        if (r11.tryLock() == true) goto L17;
        return false;
    L17:
        boolean r12 = r10.isSatisfied();     // Catch: Throwable -> L12
        if (r12 == true) goto L11;
        r11.unlock();
    L11:
        return r12;
    L12:
        th = move-exception;
        r11.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public void waitFor(Guard r10) throws InterruptedException {
        if (r10.monitor != this) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 & this.lock.isHeldByCurrentThread()) == false) goto L13;
        if (r10.isSatisfied() == true) goto L14;
        await(r10, true);
        return;
    L14:
        return;
    L13:
        throw new IllegalMonitorStateException();
    L5:
        r11 = false;
        goto L7
    }

    public void waitForUninterruptibly(Guard r10) {
        if (r10.monitor != this) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 & this.lock.isHeldByCurrentThread()) == false) goto L13;
        if (r10.isSatisfied() == true) goto L14;
        awaitUninterruptibly(r10, true);
        return;
    L14:
        return;
    L13:
        throw new IllegalMonitorStateException();
    L5:
        r11 = false;
        goto L7
    }

    public Monitor(boolean r10) {
        this.activeGuards = null;
        this.fair = r10;
        this.lock = new ReentrantLock(r10);
    }

    public boolean enter(long r10, TimeUnit r11) {
        long r12 = toSafeNanos(r10, r11);
        ReentrantLock r13 = this.lock;
        boolean r14 = true;
        if (this.fair == false) goto L5;
    L7:
        boolean r15 = Thread.interrupted();
        long r16 = System.nanoTime();     // Catch: Throwable -> L14
        long r17 = r12;
    L22:
        boolean r18 = r13.tryLock(r17, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L14 InterruptedException -> L16
    L11:
        if (r15 == false) goto L13;
        Thread.currentThread().interrupt();
    L13:
        return r18;
    L16:
        r17 = remainingNanos(r16, r12);     // Catch: Throwable -> L18
        r15 = true;
    L18:
        th = th;
    L19:
        if (r14 == false) goto L21;
        Thread.currentThread().interrupt();
    L21:
        throw th;
    L14:
        th = th;
        r14 = r15;
        goto L19
    L5:
        if (r13.tryLock() == false) goto L7;
        return true;
    }

    public boolean enterInterruptibly(long r10, TimeUnit r11) throws InterruptedException {
        return this.lock.tryLock(r10, r11);
    }

    public boolean waitFor(Guard r10, long r11, TimeUnit r12) throws InterruptedException {
        long r13 = toSafeNanos(r11, r12);
        if (r10.monitor != this) goto L5;
        boolean r14 = true;
    L7:
        if ((r14 & this.lock.isHeldByCurrentThread()) == false) goto L18;
        if (r10.isSatisfied() == false) goto L12;
        return true;
    L12:
        if (Thread.interrupted() == true) goto L16;
        return awaitNanos(r10, r13, true);
    L16:
        throw new InterruptedException();
    L18:
        throw new IllegalMonitorStateException();
    L5:
        r14 = false;
        goto L7
    }

    public boolean waitForUninterruptibly(Guard r10, long r11, TimeUnit r12) {
        long r13 = toSafeNanos(r11, r12);
        boolean r14 = true;
        if (r10.monitor != this) goto L5;
        boolean r15 = true;
    L7:
        if ((r15 & this.lock.isHeldByCurrentThread()) == false) goto L29;
        if (r10.isSatisfied() == false) goto L11;
        return true;
    L11:
        long r16 = initNanoTime(r13);
        boolean r17 = Thread.interrupted();
        long r18 = r13;
        boolean r19 = true;
    L30:
        boolean r20 = this.awaitNanos(r10, r18, r19);     // Catch: Throwable -> L16 InterruptedException -> L18
        goto L19
    L13:
        if (r17 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        return r20;
    L16:
        th = th;
        r14 = r17;
    L25:
        if (r14 == false) goto L27;
        Thread.currentThread().interrupt();
    L27:
        throw th;
    L24:
        th = th;
    L19:
        if (r10.isSatisfied() == true) goto L20;
        r18 = remainingNanos(r16, r13);     // Catch: Throwable -> L24
        r19 = false;
        r17 = true;
        goto L30
    L20:
        Thread.currentThread().interrupt();
        return true;
    L29:
        throw new IllegalMonitorStateException();
    L5:
        r15 = false;
        goto L7
    }

    public boolean enterIf(Guard r10, long r11, TimeUnit r12) {
        if (r10.monitor != this) goto L16;
        if (enter(r11, r12) == true) goto L17;
        return false;
    L17:
        boolean r13 = r10.isSatisfied();     // Catch: Throwable -> L12
        if (r13 == true) goto L11;
        this.lock.unlock();
    L11:
        return r13;
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r10, long r11, TimeUnit r12) throws InterruptedException {
        if (r10.monitor != this) goto L16;
        ReentrantLock r13 = this.lock;
        if (r13.tryLock(r11, r12) == true) goto L17;
        return false;
    L17:
        boolean r14 = r10.isSatisfied();     // Catch: Throwable -> L12
        if (r14 == true) goto L11;
        r13.unlock();
    L11:
        return r14;
    L12:
        th = move-exception;
        r13.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhen(Guard r11, long r12, TimeUnit r14) throws InterruptedException {
        long r10 = toSafeNanos(r12, r14);
        if (r11.monitor != this) goto L40;
        ReentrantLock r13 = this.lock;
        boolean r15 = r13.isHeldByCurrentThread();
        boolean r16 = false;
        if (this.fair == false) goto L7;
    L13:
        long r17 = initNanoTime(r10);
        if (r13.tryLock(r12, r14) == true) goto L43;
        return false;
    L43:
    L25:
        th = move-exception;
        if (r15 == false) goto L41;
    L37:
        r13.unlock();
        throw th;
    L41:
        signalNextWaiter();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r13.unlock();
        throw th;
    L17:
        if (r11.isSatisfied() == false) goto L19;
    L27:
        r16 = true;
    L28:
        if (r16 == true) goto L30;
        r13.unlock();
    L30:
        return r16;
    L19:
        if (r17 == 0) goto L22;
        r10 = remainingNanos(r17, r10);     // Catch: Throwable -> L25
    L22:
        if (awaitNanos(r11, r10, r15) == false) goto L28;
    L7:
        if (Thread.interrupted() == true) goto L12;
        if (r13.tryLock() == false) goto L13;
        r17 = 0;
        goto L43
    L12:
        throw new InterruptedException();
    L40:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhenUninterruptibly(Guard r12, long r13, TimeUnit r15) {
        long r14 = toSafeNanos(r13, r15);
        if (r12.monitor != this) goto L46;
        ReentrantLock r16 = this.lock;
        boolean r10 = r16.isHeldByCurrentThread();
        boolean r11 = Thread.interrupted();
        boolean r17 = true;
        if (this.fair == false) goto L8;
    L13:
        long r18 = initNanoTime(r14);     // Catch: Throwable -> L11
        long r19 = r14;
    L48:
        if (r16.tryLock(r19, TimeUnit.NANOSECONDS) == true) goto L50;
        if (r11 == false) goto L37;
        Thread.currentThread().interrupt();
    L37:
        return false;
    L50:
    L34:
        r10 = false;
        r11 = r17;
    L23:
        th = move-exception;
        r16.unlock();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L18:
        if (r12.isSatisfied() == true) goto L27;
        if (r18 != 0) goto L25;
        r18 = initNanoTime(r14);     // Catch: Throwable -> L23 InterruptedException -> L34
        long r20 = r14;
    L26:
        r17 = awaitNanos(r12, r20, r10);     // Catch: Throwable -> L23 InterruptedException -> L34
    L25:
        r20 = remainingNanos(r18, r14);     // Catch: Throwable -> L23 InterruptedException -> L34
    L27:
        if (r17 == true) goto L29;
        r16.unlock();     // Catch: Throwable -> L11
    L29:
        if (r11 == false) goto L31;
        Thread.currentThread().interrupt();
    L31:
        return r17;
    L38:
        r19 = remainingNanos(r18, r14);     // Catch: Throwable -> L40
        r11 = true;
    L40:
        th = th;
        r11 = true;
    L42:
        if (r11 == false) goto L44;
        Thread.currentThread().interrupt();
    L44:
        throw th;
    L8:
        if (r16.tryLock() == false) goto L13;
        r18 = 0;
    L11:
        th = th;
        goto L42
    L46:
        throw new IllegalMonitorStateException();
    }
}
