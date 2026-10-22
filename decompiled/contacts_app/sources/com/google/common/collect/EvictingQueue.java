package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    private EvictingQueue(int r5) {
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "maxSize (%s) must >= 0", new Object[]{Integer.valueOf(r5)});
        this.delegate = new ArrayDeque(r5);
        this.maxSize = r5;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static <E> EvictingQueue<E> create(int r1) {
        return new EvictingQueue(r1);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected Queue<E> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingQueue, java.util.Queue
    public boolean offer(E r1) {
        return add(r1);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean add(E r4) {
        Preconditions.checkNotNull(r4);
        if (this.maxSize != 0) goto L6;
        return true;
    L6:
        if (size() != this.maxSize) goto L8;
        this.delegate.remove();
    L8:
        this.delegate.add(r4);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> r1) {
        return standardAddAll(r1);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        return delegate().contains(Preconditions.checkNotNull(r1));
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r1) {
        return delegate().remove(Preconditions.checkNotNull(r1));
    }
}
