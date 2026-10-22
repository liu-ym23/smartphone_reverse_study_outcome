package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        final /* synthetic */ ForwardingNavigableSet this$0;

        public StandardDescendingSet(ForwardingNavigableSet r1) {
            this.this$0 = r1;
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract NavigableSet<E> delegate();

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ SortedSet delegate() {
        return delegate();
    }

    protected ForwardingNavigableSet() {
    }

    @Override // java.util.NavigableSet
    public E lower(E r1) {
        return delegate().lower(r1);
    }

    protected E standardLower(E r2) {
        return (E) Iterators.getNext(headSet(r2, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public E floor(E r1) {
        return delegate().floor(r1);
    }

    protected E standardFloor(E r2) {
        return (E) Iterators.getNext(headSet(r2, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r1) {
        return delegate().ceiling(r1);
    }

    protected E standardCeiling(E r2) {
        return (E) Iterators.getNext(tailSet(r2, true).iterator(), null);
    }

    @Override // java.util.NavigableSet
    public E higher(E r1) {
        return delegate().higher(r1);
    }

    protected E standardHigher(E r2) {
        return (E) Iterators.getNext(tailSet(r2, false).iterator(), null);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return delegate().pollFirst();
    }

    protected E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return delegate().pollLast();
    }

    protected E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    protected E standardFirst() {
        return iterator().next();
    }

    protected E standardLast() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E r1, boolean r2, E r3, boolean r4) {
        return delegate().subSet(r1, r2, r3, r4);
    }

    protected NavigableSet<E> standardSubSet(E r1, boolean r2, E r3, boolean r4) {
        return tailSet(r1, r2).headSet(r3, r4);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    protected SortedSet<E> standardSubSet(E r3, E r4) {
        return subSet(r3, true, r4, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r1, boolean r2) {
        return delegate().headSet(r1, r2);
    }

    protected SortedSet<E> standardHeadSet(E r2) {
        return headSet(r2, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r1, boolean r2) {
        return delegate().tailSet(r1, r2);
    }

    protected SortedSet<E> standardTailSet(E r2) {
        return tailSet(r2, true);
    }
}
