package com.jeffmony.async.util;

import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public interface Deque<E> extends Queue<E> {
    @Override // java.util.Collection, com.jeffmony.async.util.Deque, java.util.Queue
    boolean add(E r10);

    void addFirst(E r10);

    void addLast(E r10);

    boolean contains(Object r10);

    Iterator<E> descendingIterator();

    @Override // java.util.Queue
    E element();

    E getFirst();

    E getLast();

    Iterator<E> iterator();

    @Override // java.util.Queue
    boolean offer(E r10);

    boolean offerFirst(E r10);

    boolean offerLast(E r10);

    @Override // java.util.Queue
    E peek();

    E peekFirst();

    E peekLast();

    @Override // java.util.Queue
    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E r10);

    @Override // java.util.Queue
    E remove();

    boolean remove(Object r10);

    E removeFirst();

    boolean removeFirstOccurrence(Object r10);

    E removeLast();

    boolean removeLastOccurrence(Object r10);

    int size();
}
