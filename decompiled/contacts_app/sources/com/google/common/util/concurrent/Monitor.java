package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class Monitor {
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;
        Guard next;
        int waiterCount;

        public abstract boolean isSatisfied();

        protected Guard(Monitor r2) {
            this.waiterCount = 0;
            this.monitor = (Monitor) Preconditions.checkNotNull(r2, "monitor");
            this.condition = Monitor.access$000(r2).newCondition();
        }
    }

    static /* synthetic */ ReentrantLock access$000(Monitor r0) {
        return r0.lock;
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean r2) {
        this.activeGuards = null;
        this.fair = r2;
        this.lock = new ReentrantLock(r2);
    }

    public void enter() {
        this.lock.lock();
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enter(long r5, TimeUnit r7) {
        long r6 = r7.toNanos(r5);
        ReentrantLock r8 = this.lock;
        boolean r0 = true;
        if (this.fair == false) goto L5;
    L7:
        long r1 = System.nanoTime() + r6;
        boolean r4 = Thread.interrupted();
    L20:
        boolean r9 = r8.tryLock(r6, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L12 InterruptedException -> L14
    L9:
        if (r4 == false) goto L11;
        Thread.currentThread().interrupt();
    L11:
        return r9;
    L14:
        r6 = r1 - System.nanoTime();
        r4 = true;
    L12:
        th = th;
        r0 = r4;
    L17:
        if (r0 == false) goto L19;
        Thread.currentThread().interrupt();
    L19:
        throw th;
    L16:
        th = th;
        goto L17
    L5:
        if (r8.tryLock() == false) goto L7;
        return true;
    }

    public boolean enterInterruptibly(long r1, TimeUnit r3) throws InterruptedException {
        return this.lock.tryLock(r1, r3);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public void enterWhen(Guard r3) throws InterruptedException {
        if (r3.monitor != this) goto L13;
        ReentrantLock r0 = this.lock;
        boolean r1 = r0.isHeldByCurrentThread();
        r0.lockInterruptibly();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r3.isSatisfied() == true) goto L16;
        await(r3, r1);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L13:
        throw new IllegalMonitorStateException();
    }

    public void enterWhenUninterruptibly(Guard r3) {
        if (r3.monitor != this) goto L13;
        ReentrantLock r0 = this.lock;
        boolean r1 = r0.isHeldByCurrentThread();
        r0.lock();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r3.isSatisfied() == true) goto L16;
        awaitUninterruptibly(r3, r1);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhen(Guard r9, long r10, TimeUnit r12) throws InterruptedException {
        long r0 = r12.toNanos(r10);
        if (r9.monitor != this) goto L30;
        ReentrantLock r2 = this.lock;
        boolean r3 = r2.isHeldByCurrentThread();
        boolean r5 = false;
        if (this.fair == false) goto L7;
    L8:
        long r6 = System.nanoTime() + r0;
        if (r2.tryLock(r10, r12) == true) goto L11;
        return false;
    L11:
        r0 = r6 - System.nanoTime();
    L33:
    L20:
        th = move-exception;
        if (r3 == false) goto L31;
    L27:
        r2.unlock();
        throw th;
    L31:
        signalNextWaiter();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r2.unlock();
        throw th;
    L13:
        if (r9.isSatisfied() == true) goto L16;
        if (awaitNanos(r9, r0, r3) == true) goto L16;
    L17:
        if (r5 == true) goto L19;
        r2.unlock();
    L19:
        return r5;
    L16:
        r5 = true;
        goto L17
    L7:
        if (r2.tryLock() == true) goto L33;
    L30:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhenUninterruptibly(Guard r9, long r10, TimeUnit r12) {
        long r11 = r12.toNanos(r10);
        if (r9.monitor != this) goto L43;
        ReentrantLock r13 = this.lock;
        long r0 = System.nanoTime() + r11;
        boolean r2 = r13.isHeldByCurrentThread();
        boolean r3 = Thread.interrupted();
        boolean r5 = true;
        if (this.fair == false) goto L8;
    L9:
        boolean r4 = false;
    L44:
        r4 = r13.tryLock(r11, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L15 Throwable -> L38
        if (r4 == false) goto L12;
    L17:
        r11 = r0 - System.nanoTime();
        if (r4 == false) goto L44;
    L47:
    L32:
        r11 = r0 - System.nanoTime();
        r3 = true;
        r2 = false;
    L30:
        th = th;
    L36:
        r13.unlock();     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L34:
        th = th;
        goto L36
    L20:
        if (r9.isSatisfied() == true) goto L25;
    L22:
        if (this.awaitNanos(r9, r11, r2) == true) goto L25;
        r5 = false;
    L25:
        if (r5 == true) goto L27;
        r13.unlock();     // Catch: Throwable -> L38
    L27:
        if (r3 == false) goto L29;
        Thread.currentThread().interrupt();
    L29:
        return r5;
    L12:
        if (r3 == false) goto L14;
        Thread.currentThread().interrupt();
    L14:
        return false;
    L15:
        r3 = true;
        goto L17
    L8:
        if (r13.tryLock() == true) goto L47;
    L38:
        th = move-exception;
        if (r3 == false) goto L41;
        Thread.currentThread().interrupt();
    L41:
        throw th;
    L43:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIf(Guard r2) {
        if (r2.monitor != this) goto L13;
        ReentrantLock r1 = this.lock;
        r1.lock();
        boolean r3 = r2.isSatisfied();     // Catch: Throwable -> L9
        if (r3 == true) goto L8;
        r1.unlock();
    L8:
        return r3;
    L9:
        th = move-exception;
        r1.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r2) throws InterruptedException {
        if (r2.monitor != this) goto L13;
        ReentrantLock r1 = this.lock;
        r1.lockInterruptibly();
        boolean r3 = r2.isSatisfied();     // Catch: Throwable -> L9
        if (r3 == true) goto L8;
        r1.unlock();
    L8:
        return r3;
    L9:
        th = move-exception;
        r1.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIf(Guard r2, long r3, TimeUnit r5) {
        if (r2.monitor != this) goto L16;
        if (enter(r3, r5) == true) goto L17;
        return false;
    L17:
        boolean r4 = r2.isSatisfied();     // Catch: Throwable -> L12
        if (r4 == true) goto L11;
        this.lock.unlock();
    L11:
        return r4;
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r2, long r3, TimeUnit r5) throws InterruptedException {
        if (r2.monitor != this) goto L16;
        ReentrantLock r1 = this.lock;
        if (r1.tryLock(r3, r5) == true) goto L17;
        return false;
    L17:
        boolean r4 = r2.isSatisfied();     // Catch: Throwable -> L12
        if (r4 == true) goto L11;
        r1.unlock();
    L11:
        return r4;
    L12:
        th = move-exception;
        r1.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean tryEnterIf(Guard r2) {
        if (r2.monitor != this) goto L16;
        ReentrantLock r1 = this.lock;
        if (r1.tryLock() == true) goto L17;
        return false;
    L17:
        boolean r3 = r2.isSatisfied();     // Catch: Throwable -> L12
        if (r3 == true) goto L11;
        r1.unlock();
    L11:
        return r3;
    L12:
        th = move-exception;
        r1.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public void waitFor(Guard r4) throws InterruptedException {
        if (r4.monitor != this) goto L5;
        boolean r0 = true;
    L7:
        if ((r0 & this.lock.isHeldByCurrentThread()) == false) goto L13;
        if (r4.isSatisfied() == true) goto L14;
        await(r4, true);
        return;
    L14:
        return;
    L13:
        throw new IllegalMonitorStateException();
    L5:
        r0 = false;
        goto L7
    }

    public void waitForUninterruptibly(Guard r4) {
        if (r4.monitor != this) goto L5;
        boolean r0 = true;
    L7:
        if ((r0 & this.lock.isHeldByCurrentThread()) == false) goto L13;
        if (r4.isSatisfied() == true) goto L14;
        awaitUninterruptibly(r4, true);
        return;
    L14:
        return;
    L13:
        throw new IllegalMonitorStateException();
    L5:
        r0 = false;
        goto L7
    }

    public boolean waitFor(Guard r4, long r5, TimeUnit r7) throws InterruptedException {
        long r6 = r7.toNanos(r5);
        if (r4.monitor != this) goto L5;
        boolean r8 = true;
    L7:
        if ((r8 & this.lock.isHeldByCurrentThread()) == false) goto L15;
        if (r4.isSatisfied() == true) goto L13;
        if (awaitNanos(r4, r6, true) == true) goto L13;
        return false;
    L13:
        return true;
    L15:
        throw new IllegalMonitorStateException();
    L5:
        r8 = false;
        goto L7
    }

    public boolean waitForUninterruptibly(Guard r6, long r7, TimeUnit r9) {
        long r8 = r9.toNanos(r7);
        boolean r1 = true;
        if (r6.monitor != this) goto L5;
        boolean r10 = true;
    L7:
        if ((r10 & this.lock.isHeldByCurrentThread()) == false) goto L29;
        if (r6.isSatisfied() == false) goto L11;
        return true;
    L11:
        long r2 = System.nanoTime() + r8;
        boolean r11 = Thread.interrupted();
        boolean r4 = true;
    L30:
        boolean r5 = this.awaitNanos(r6, r8, r4);     // Catch: Throwable -> L16 InterruptedException -> L18
        goto L19
    L13:
        if (r11 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        return r5;
    L16:
        th = th;
        r1 = r11;
    L25:
        if (r1 == false) goto L27;
        Thread.currentThread().interrupt();
    L27:
        throw th;
    L24:
        th = th;
    L19:
        if (r6.isSatisfied() == true) goto L20;
        r8 = r2 - System.nanoTime();
        r4 = false;
        r11 = true;
        goto L30
    L20:
        Thread.currentThread().interrupt();
        return true;
    L29:
        throw new IllegalMonitorStateException();
    L5:
        r10 = false;
        goto L7
    }

    public void leave() {
        ReentrantLock r0 = this.lock;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (r0.getHoldCount() != 1) goto L6;
        signalNextWaiter();     // Catch: Throwable -> L8
    L6:
        r0.unlock();
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

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasQueuedThread(Thread r1) {
        return this.lock.hasQueuedThread(r1);
    }

    public boolean hasWaiters(Guard r1) {
        if (getWaitQueueLength(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getWaitQueueLength(Guard r2) {
        if (r2.monitor != this) goto L12;
        this.lock.lock();
        int r3 = r2.waiterCount;     // Catch: Throwable -> L8
        this.lock.unlock();
        return r3;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L12:
        throw new IllegalMonitorStateException();
    }

    private void signalNextWaiter() {
        Guard r0 = this.activeGuards;
    L3:
        if (r0 == null) goto L11;
        if (isSatisfied(r0) == true) goto L6;
        r0 = r0.next;
        goto L3
    L6:
        r0.condition.signal();
        return;
    }

    private boolean isSatisfied(Guard r1) {
        return r1.isSatisfied();
    L4:
        th = move-exception;
        signalAllWaiters();
        throw Throwables.propagate(th);
    }

    private void signalAllWaiters() {
        Guard r1 = this.activeGuards;
    L3:
        if (r1 == null) goto L5;
        r1.condition.signalAll();
        r1 = r1.next;
        goto L3
    }

    private void beginWaitingFor(Guard r3) {
        int r0 = r3.waiterCount;
        r3.waiterCount = r0 + 1;
        if (r0 != 0) goto L6;
        r3.next = this.activeGuards;
        this.activeGuards = r3;
        return;
    }

    private void endWaitingFor(Guard r5) {
        int r0 = r5.waiterCount - 1;
        r5.waiterCount = r0;
        if (r0 != 0) goto L11;
        Guard r1 = this.activeGuards;
        Guard r2 = null;
    L5:
        if (r1 == r5) goto L6;
        r2 = r1;
        r1 = r1.next;
        goto L5
    L6:
        if (r2 != null) goto L8;
        this.activeGuards = r1.next;
    L9:
        r1.next = null;
        return;
    L8:
        r2.next = r1.next;
        goto L9
    }

    private void await(Guard r1, boolean r2) throws InterruptedException {
        if (r2 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r1);
    L12:
        r1.condition.await();     // Catch: Throwable -> L9
        if (r1.isSatisfied() == false) goto L12;
        endWaitingFor(r1);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r1);
        throw th;
    }

    private void awaitUninterruptibly(Guard r1, boolean r2) {
        if (r2 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r1);
    L12:
        r1.condition.awaitUninterruptibly();     // Catch: Throwable -> L9
        if (r1.isSatisfied() == false) goto L12;
        endWaitingFor(r1);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r1);
        throw th;
    }

    private boolean awaitNanos(Guard r3, long r4, boolean r6) throws InterruptedException {
        if (r6 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r3);
    L6:
        if (r4 < 0) goto L7;
        r4 = r3.condition.awaitNanos(r4);     // Catch: Throwable -> L13
        if (r3.isSatisfied() == false) goto L6;
        endWaitingFor(r3);
        return true;
    L13:
        th = move-exception;
        endWaitingFor(r3);
        throw th;
    L7:
        endWaitingFor(r3);
        return false;
    }
}
