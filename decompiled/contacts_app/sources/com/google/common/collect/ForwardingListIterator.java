package com.google.common.collect;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    protected abstract ListIterator<E> delegate();

    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Iterator delegate() {
        return delegate();
    }

    protected ForwardingListIterator() {
    }

    public void add(E r1) {
        delegate().add(r1);
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return delegate().hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return delegate().nextIndex();
    }

    @Override // java.util.ListIterator
    public E previous() {
        return delegate().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return delegate().previousIndex();
    }

    public void set(E r1) {
        delegate().set(r1);
    }
}
