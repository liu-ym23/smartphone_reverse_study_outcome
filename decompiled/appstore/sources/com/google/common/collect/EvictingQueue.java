package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;

    @VisibleForTesting
    final int maxSize;

    private EvictingQueue(int r10) {
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "maxSize (%s) must >= 0", r10);
        this.delegate = new ArrayDeque(r10);
        this.maxSize = r10;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static <E> EvictingQueue<E> create(int r10) {
        return new EvictingQueue(r10);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E r10) {
        Preconditions.checkNotNull(r10);
        if (this.maxSize != 0) goto L6;
        return true;
    L6:
        if (size() != this.maxSize) goto L8;
        this.delegate.remove();
    L8:
        this.delegate.add(r10);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> r10) {
        int r11 = r10.size();
        if (r11 < this.maxSize) goto L7;
        clear();
        return Iterables.addAll(this, Iterables.skip(r10, r11 - this.maxSize));
    L7:
        return standardAddAll(r10);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        return delegate().contains(Preconditions.checkNotNull(r10));
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingQueue, java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E r10) {
        return add(r10);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(Object r10) {
        return delegate().remove(Preconditions.checkNotNull(r10));
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Queue<E> delegate() {
        return this.delegate;
    }
}
