package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Queues {
    private Queues() {
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <E> int drain(BlockingQueue<E> r10, Collection<? super E> r11, int r12, long r13, TimeUnit r14) throws InterruptedException {
        Preconditions.checkNotNull(r11);
        long r15 = System.nanoTime() + r14.toNanos(r13);
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L10;
        r16 = r16 + r10.drainTo(r11, r12 - r16);
        if (r16 >= r12) goto L3;
        E r17 = r10.poll(r15 - System.nanoTime(), TimeUnit.NANOSECONDS);
        if (r17 == null) goto L10;
        r11.add(r17);
        r16 = r16 + 1;
    L10:
        return r16;
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static <E> int drainUninterruptibly(BlockingQueue<E> r10, Collection<? super E> r11, int r12, long r13, TimeUnit r14) {
        Preconditions.checkNotNull(r11);
        long r15 = System.nanoTime() + r14.toNanos(r13);
        int r16 = 0;
        boolean r17 = false;
    L3:
        if (r16 >= r12) goto L19;
    L13:
        th = move-exception;
        if (r17 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L6:
        r16 = r16 + r10.drainTo(r11, r12 - r16);
        if (r16 >= r12) goto L3;
    L22:
        E r18 = r10.poll(r15 - System.nanoTime(), TimeUnit.NANOSECONDS);     // Catch: Throwable -> L13 InterruptedException -> L15
        if (r18 == null) goto L19;
        r11.add(r18);     // Catch: Throwable -> L13
        r16 = r16 + 1;
    L15:
        r17 = true;
    L19:
        if (r17 == false) goto L21;
        Thread.currentThread().interrupt();
    L21:
        return r16;
    }

    @GwtIncompatible
    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int r10) {
        return new ArrayBlockingQueue(r10);
    }

    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque();
    }

    @GwtIncompatible
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue();
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque();
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue();
    }

    @GwtIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue();
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue();
    }

    @GwtIncompatible
    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue();
    }

    public static <E> Deque<E> synchronizedDeque(Deque<E> r10) {
        return Synchronized.deque(r10, null);
    }

    public static <E> Queue<E> synchronizedQueue(Queue<E> r10) {
        return Synchronized.queue(r10, null);
    }

    public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        ArrayDeque<E> r11 = new ArrayDeque();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new ArrayDeque(Collections2.cast(r10));
    }

    @GwtIncompatible
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        ConcurrentLinkedQueue<E> r11 = new ConcurrentLinkedQueue();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new ConcurrentLinkedQueue(Collections2.cast(r10));
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int r10) {
        return new LinkedBlockingDeque(r10);
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int r10) {
        return new LinkedBlockingQueue(r10);
    }

    @GwtIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        PriorityBlockingQueue<E> r11 = new PriorityBlockingQueue();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new PriorityBlockingQueue(Collections2.cast(r10));
    }

    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        PriorityQueue<E> r11 = new PriorityQueue();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new PriorityQueue(Collections2.cast(r10));
    }

    @GwtIncompatible
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        LinkedBlockingDeque<E> r11 = new LinkedBlockingDeque();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new LinkedBlockingDeque(Collections2.cast(r10));
    }

    @GwtIncompatible
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        LinkedBlockingQueue<E> r11 = new LinkedBlockingQueue();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new LinkedBlockingQueue(Collections2.cast(r10));
    }
}
