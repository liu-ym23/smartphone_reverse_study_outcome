package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    @GwtIncompatible
    public static void awaitUninterruptibly(CountDownLatch r10) {
        boolean r11 = false;
    L12:
        r10.await();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r11 == false) goto L15;
        Thread.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r11 = true;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @CanIgnoreReturnValue
    public static <V> V getUninterruptibly(Future<V> r10) throws ExecutionException {
        boolean r11 = false;
    L12:
        V r12 = r10.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r11 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r12;
    L11:
        r11 = true;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread r10) {
        boolean r11 = false;
    L12:
        r10.join();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r11 == false) goto L15;
        Thread.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r11 = true;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @GwtIncompatible
    public static <E> void putUninterruptibly(BlockingQueue<E> r10, E r11) {
        boolean r12 = false;
    L12:
        r10.put(r11);     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r12 == false) goto L15;
        Thread.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r12 = true;
    L7:
        th = move-exception;
        if (r12 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @GwtIncompatible
    public static void sleepUninterruptibly(long r10, TimeUnit r11) {
        boolean r12 = false;
        long r13 = r11.toNanos(r10);     // Catch: Throwable -> L9
        long r14 = System.nanoTime() + r13;
    L19:
        TimeUnit.NANOSECONDS.sleep(r13);     // Catch: Throwable -> L9 InterruptedException -> L11
    L6:
        if (r12 == false) goto L22;
        Thread.currentThread().interrupt();
        return;
    L22:
        return;
    L11:
        r12 = true;
        r13 = r14 - System.nanoTime();
    L9:
        th = move-exception;
        if (r12 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    }

    @GwtIncompatible
    public static <E> E takeUninterruptibly(BlockingQueue<E> r10) {
        boolean r11 = false;
    L12:
        E r12 = r10.take();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r11 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r12;
    L11:
        r11 = true;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore r10, long r11, TimeUnit r12) {
        return tryAcquireUninterruptibly(r10, 1, r11, r12);
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore r10, int r11, long r12, TimeUnit r13) {
        boolean r14 = false;
        long r15 = r13.toNanos(r12);     // Catch: Throwable -> L9
        long r16 = System.nanoTime() + r15;
    L17:
        boolean r17 = r10.tryAcquire(r11, r15, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9 InterruptedException -> L11
    L6:
        if (r14 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r17;
    L11:
        r14 = true;
        r15 = r16 - System.nanoTime();
    L9:
        th = move-exception;
        if (r14 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public static boolean awaitUninterruptibly(CountDownLatch r10, long r11, TimeUnit r12) {
        boolean r13 = false;
        long r14 = r12.toNanos(r11);     // Catch: Throwable -> L9
        long r15 = System.nanoTime() + r14;
    L17:
        boolean r16 = r10.await(r14, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9 InterruptedException -> L11
    L6:
        if (r13 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r16;
    L11:
        r13 = true;
        r14 = r15 - System.nanoTime();
    L9:
        th = move-exception;
        if (r13 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public static <V> V getUninterruptibly(Future<V> r10, long r11, TimeUnit r12) throws ExecutionException, TimeoutException {
        boolean r13 = false;
        long r14 = r12.toNanos(r11);     // Catch: Throwable -> L9
        long r15 = System.nanoTime() + r14;
    L17:
        V r16 = r10.get(r14, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9 InterruptedException -> L11
    L6:
        if (r13 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r16;
    L11:
        r13 = true;
        r14 = r15 - System.nanoTime();
    L9:
        th = move-exception;
        if (r13 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread r10, long r11, TimeUnit r12) {
        Preconditions.checkNotNull(r10);
        boolean r13 = false;
        long r14 = r12.toNanos(r11);     // Catch: Throwable -> L9
        long r15 = System.nanoTime() + r14;
    L17:
        TimeUnit.NANOSECONDS.timedJoin(r10, r14);     // Catch: Throwable -> L9 InterruptedException -> L11
    L6:
        if (r13 == false) goto L22;
        Thread.currentThread().interrupt();
        return;
    L22:
        return;
    L11:
        r13 = true;
        r14 = r15 - System.nanoTime();
    L9:
        th = move-exception;
        if (r13 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    }

    @GwtIncompatible
    public static boolean awaitUninterruptibly(Condition r10, long r11, TimeUnit r12) {
        boolean r13 = false;
        long r14 = r12.toNanos(r11);     // Catch: Throwable -> L9
        long r15 = System.nanoTime() + r14;
    L17:
        boolean r16 = r10.await(r14, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9 InterruptedException -> L11
    L6:
        if (r13 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r16;
    L11:
        r13 = true;
        r14 = r15 - System.nanoTime();
    L9:
        th = move-exception;
        if (r13 == false) goto L16;
        Thread.currentThread().interrupt();
    L16:
        throw th;
    }
}
