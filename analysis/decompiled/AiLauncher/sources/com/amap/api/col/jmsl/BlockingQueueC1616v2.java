package com.amap.api.col.jmsl;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.jmsl.v2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BlockingQueueC1616v2<E> implements BlockingQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingDeque<E> f16994a = new LinkedBlockingDeque<>(256);

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public final boolean add(E e10) {
        this.f16994a.addFirst(e10);
        return true;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return !collection.isEmpty();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f16994a.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f16994a.contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.f16994a.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection) {
        return this.f16994a.drainTo(collection);
    }

    @Override // java.util.Queue
    public final E element() {
        return this.f16994a.element();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f16994a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.f16994a.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public final boolean offer(E e10) {
        return this.f16994a.offerFirst(e10);
    }

    @Override // java.util.Queue
    public final E peek() {
        return this.f16994a.peek();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f16994a.poll(j10, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(E e10) throws InterruptedException {
        this.f16994a.putFirst(e10);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return this.f16994a.remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f16994a.remove(obj);
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return this.f16994a.removeAll(collection);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return this.f16994a.retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f16994a.size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() throws InterruptedException {
        return this.f16994a.take();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return this.f16994a.toArray();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection, int i10) {
        return this.f16994a.drainTo(collection, i10);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(E e10, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f16994a.offerFirst(e10, j10, timeUnit);
    }

    @Override // java.util.Queue
    public final E poll() {
        return this.f16994a.poll();
    }

    @Override // java.util.Queue
    public final E remove() {
        return this.f16994a.remove();
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.f16994a.toArray(tArr);
    }
}
