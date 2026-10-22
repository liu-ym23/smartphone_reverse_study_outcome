package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
@Deprecated
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    public ForwardingBlockingDeque() {
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingDeque<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r10) {
        return delegate().drainTo(r10);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E r10, long r11, TimeUnit r12) throws InterruptedException {
        return delegate().offer(r10, r11, r12);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E r10, long r11, TimeUnit r12) throws InterruptedException {
        return delegate().offerFirst(r10, r11, r12);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E r10, long r11, TimeUnit r12) throws InterruptedException {
        return delegate().offerLast(r10, r11, r12);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long r10, TimeUnit r11) throws InterruptedException {
        return delegate().poll(r10, r11);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollFirst(long r10, TimeUnit r11) throws InterruptedException {
        return delegate().pollFirst(r10, r11);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollLast(long r10, TimeUnit r11) throws InterruptedException {
        return delegate().pollLast(r10, r11);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E r10) throws InterruptedException {
        delegate().put(r10);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E r10) throws InterruptedException {
        delegate().putFirst(r10);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E r10) throws InterruptedException {
        delegate().putLast(r10);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r10, int r11) {
        return delegate().drainTo(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Deque delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }
}
