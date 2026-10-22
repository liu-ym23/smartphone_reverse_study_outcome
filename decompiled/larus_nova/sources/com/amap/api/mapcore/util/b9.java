package com.amap.api.mapcore.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public final class b9<E> implements BlockingQueue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingDeque<E> f27083a;

    @Override // java.util.Collection
    public final void clear() {
        this.f27083a.clear();
    }

    @Override // java.util.Queue
    public final E element() {
        return this.f27083a.element();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f27083a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.f27083a.iterator();
    }

    @Override // java.util.Queue
    public final E peek() {
        return this.f27083a.peek();
    }

    @Override // java.util.Queue
    public final E poll() {
        return this.f27083a.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return this.f27083a.remainingCapacity();
    }

    @Override // java.util.Queue
    public final E remove() {
        return this.f27083a.remove();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f27083a.size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() throws InterruptedException {
        return this.f27083a.take();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return this.f27083a.toArray();
    }

    public b9() {
        this.f27083a = new LinkedBlockingDeque(256);
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public final boolean add(E r100) {
        this.f27083a.addFirst(r100);
        return true;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        add(r101.next());
        goto L4
    L7:
        if (r100.isEmpty() == true) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public final boolean contains(Object r100) {
        return this.f27083a.contains(r100);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<?> r100) {
        return this.f27083a.containsAll(r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r100) {
        return this.f27083a.drainTo(r100);
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public final boolean offer(E r100) {
        return this.f27083a.offerFirst(r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(E r100) throws InterruptedException {
        this.f27083a.putFirst(r100);
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public final boolean remove(Object r100) {
        return this.f27083a.remove(r100);
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<?> r100) {
        return this.f27083a.removeAll(r100);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<?> r100) {
        return this.f27083a.retainAll(r100);
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) this.f27083a.toArray(r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r100, int r101) {
        return this.f27083a.drainTo(r100, r101);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E poll(long r100, TimeUnit r101) throws InterruptedException {
        return this.f27083a.poll(r100, r101);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(E r100, long r101, TimeUnit r102) throws InterruptedException {
        return this.f27083a.offerFirst(r100, r101, r102);
    }
}
