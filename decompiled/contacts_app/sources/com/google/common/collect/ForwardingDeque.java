package com.google.common.collect;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract Deque<E> delegate();

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

    protected ForwardingDeque() {
    }

    @Override // java.util.Deque
    public void addFirst(E r1) {
        delegate().addFirst(r1);
    }

    @Override // java.util.Deque
    public void addLast(E r1) {
        delegate().addLast(r1);
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.Deque
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        return delegate().getLast();
    }

    @Override // java.util.Deque
    public boolean offerFirst(E r1) {
        return delegate().offerFirst(r1);
    }

    @Override // java.util.Deque
    public boolean offerLast(E r1) {
        return delegate().offerLast(r1);
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    public void push(E r1) {
        delegate().push(r1);
    }

    @Override // java.util.Deque
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    public E removeLast() {
        return delegate().removeLast();
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object r1) {
        return delegate().removeFirstOccurrence(r1);
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object r1) {
        return delegate().removeLastOccurrence(r1);
    }
}
