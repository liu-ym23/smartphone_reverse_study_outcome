package com.google.common.collect;

import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract Queue<E> delegate();

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    protected ForwardingQueue() {
    }

    public boolean offer(E r1) {
        return delegate().offer(r1);
    }

    @Override // java.util.Queue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return delegate().remove();
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    protected boolean standardOffer(E r1) {
        return add(r1);
    L4:
        return false;
    }

    protected E standardPeek() {
        return element();
    L4:
        return null;
    }

    protected E standardPoll() {
        return remove();
    L4:
        return null;
    }
}
