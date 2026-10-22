package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = null;
    private static final Runnable INTERRUPTING = null;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = null;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.InterruptibleTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public /* synthetic */ DoNothingRunnable(AnonymousClass1 r10) {
            this();
        }
    }

    static {
        AnonymousClass1 r10 = null;
        DONE = new DoNothingRunnable(r10);
        INTERRUPTING = new DoNothingRunnable(r10);
        PARKED = new DoNothingRunnable(r10);
    }

    public InterruptibleTask() {
    }

    public abstract void afterRanInterruptibly(@NullableDecl T r10, @NullableDecl Throwable r11);

    public final void interruptTask() {
        Runnable r10 = get();
        if ((r10 instanceof Thread) == true) goto L5;
        return;
    L5:
        if (compareAndSet(r10, INTERRUPTING) == false) goto L18;
        ((Thread) r10).interrupt();     // Catch: Throwable -> L10
        if (getAndSet(DONE) != PARKED) goto L19;
        LockSupport.unpark((Thread) r10);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        if (getAndSet(DONE) != PARKED) goto L14;
        LockSupport.unpark((Thread) r10);
    L14:
        throw th;
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        Thread r10 = Thread.currentThread();
        if (compareAndSet(null, r10) == true) goto L5;
        return;
    L5:
        boolean r11 = isDone();
        if (r11 == false) goto L66;
        T r12 = null;
    L39:
        if (compareAndSet(r10, DONE) == true) goto L63;
        Runnable r13 = get();
        boolean r14 = false;
        int r15 = 0;
    L41:
        Runnable r16 = INTERRUPTING;
        if (r13 != r16) goto L44;
    L48:
        r15 = r15 + 1;
        if (r15 <= 1000) goto L61;
        Runnable r17 = PARKED;
        if (r13 == r17) goto L55;
        if (compareAndSet(r16, r17) == true) goto L55;
    L62:
        r13 = get();
    L55:
        if (Thread.interrupted() == true) goto L59;
        if (r14 == true) goto L59;
        r14 = false;
    L60:
        LockSupport.park(this);
    L59:
        r14 = true;
        goto L60
    L61:
        Thread.yield();
        goto L62
    L44:
        if (r13 == PARKED) goto L48;
        if (r14 == false) goto L63;
        r10.interrupt();
    L63:
        if (r11 == true) goto L78;
        afterRanInterruptibly(r12, null);
        return;
    L78:
        return;
    L66:
        r12 = runInterruptibly();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (compareAndSet(r10, DONE) == true) goto L35;
        Runnable r18 = get();
        boolean r19 = false;
        int r20 = 0;
    L13:
        Runnable r110 = INTERRUPTING;
        if (r18 != r110) goto L16;
    L20:
        r20 = r20 + 1;
        if (r20 <= 1000) goto L33;
        Runnable r111 = PARKED;
        if (r18 == r111) goto L27;
        if (compareAndSet(r110, r111) == true) goto L27;
    L34:
        r18 = get();
    L27:
        if (Thread.interrupted() == true) goto L31;
        if (r19 == true) goto L31;
        r19 = false;
    L32:
        LockSupport.park(this);
    L31:
        r19 = true;
        goto L32
    L33:
        Thread.yield();
        goto L34
    L16:
        if (r18 == PARKED) goto L20;
        if (r19 == false) goto L35;
        r10.interrupt();
    L35:
        if (r11 == true) goto L76;
        afterRanInterruptibly(null, th);
        return;
    }

    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable r10 = get();
        if (r10 != DONE) goto L6;
        String r11 = "running=[DONE]";
    L13:
        return r11 + ", " + toPendingString();
    L6:
        if (r10 != INTERRUPTING) goto L9;
        r11 = "running=[INTERRUPTED]";
        goto L13
    L9:
        if ((r10 instanceof Thread) == false) goto L11;
        r11 = "running=[RUNNING ON " + ((Thread) r10).getName() + "]";
        goto L13
    L11:
        r11 = "running=[NOT STARTED YET]";
        goto L13
    }
}
