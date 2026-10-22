package com.jeffmony.async;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes3.dex */
class ThreadQueue extends LinkedList<Runnable> {
    private static final WeakHashMap<Thread, ThreadQueue> mThreadQueues = null;
    Semaphore queueSemaphore;
    a waiter;

    static {
        mThreadQueues = new WeakHashMap();
    }

    public ThreadQueue() {
        this.queueSemaphore = new Semaphore(0);
    }

    public static ThreadQueue getOrCreateThreadQueue(Thread r10) {
        WeakHashMap<Thread, ThreadQueue> r11 = mThreadQueues;
        monitor-enter(r11);
        ThreadQueue r12 = r11.get(r10);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = new ThreadQueue();     // Catch: Throwable -> L7
        r11.put(r10, r12);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static void release(a r10) {
        WeakHashMap<Thread, ThreadQueue> r11 = mThreadQueues;
        monitor-enter(r11);
        Iterator<ThreadQueue> r12 = r11.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L12;
        ThreadQueue r13 = r12.next();     // Catch: Throwable -> L10
        if (r13.waiter != r10) goto L6;
        r13.queueSemaphore.release();     // Catch: Throwable -> L10
        goto L6
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public /* bridge */ /* synthetic */ boolean add(Object r10) {
        return add((Runnable) r10);
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public /* bridge */ /* synthetic */ Object remove() {
        return remove();
    }

    public boolean add(Runnable r10) {
        monitor-enter(this);
        boolean r11 = super.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object r10) {
        monitor-enter(this);
        boolean r11 = super.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Runnable remove() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isEmpty() == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        Runnable r10 = (Runnable) super.remove();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r10;
    }
}
