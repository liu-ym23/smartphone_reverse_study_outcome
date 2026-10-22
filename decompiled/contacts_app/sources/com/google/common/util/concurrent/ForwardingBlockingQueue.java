package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract BlockingQueue<E> delegate();

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }

    protected ForwardingBlockingQueue() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r1, int r2) {
        return delegate().drainTo(r1, r2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> r1) {
        return delegate().drainTo(r1);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E r1, long r2, TimeUnit r4) throws InterruptedException {
        return delegate().offer(r1, r2, r4);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long r1, TimeUnit r3) throws InterruptedException {
        return delegate().poll(r1, r3);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E r1) throws InterruptedException {
        delegate().put(r1);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }
}
