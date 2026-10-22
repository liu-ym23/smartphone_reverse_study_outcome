package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        final /* synthetic */ ForwardingNavigableSet this$0;

        public StandardDescendingSet(ForwardingNavigableSet r10) {
            this.this$0 = r10;
            super(r10);
        }
    }

    public ForwardingNavigableSet() {
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r10) {
        return delegate().ceiling(r10);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E r10) {
        return delegate().floor(r10);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r10, boolean r11) {
        return delegate().headSet(r10, r11);
    }

    @Override // java.util.NavigableSet
    public E higher(E r10) {
        return delegate().higher(r10);
    }

    @Override // java.util.NavigableSet
    public E lower(E r10) {
        return delegate().lower(r10);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return delegate().pollLast();
    }

    public E standardCeiling(E r10) {
        return (E) Iterators.getNext(tailSet(r10, true).iterator(), null);
    }

    public E standardFirst() {
        return iterator().next();
    }

    public E standardFloor(E r10) {
        return (E) Iterators.getNext(headSet(r10, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(E r10) {
        return headSet(r10, false);
    }

    public E standardHigher(E r10) {
        return (E) Iterators.getNext(tailSet(r10, false).iterator(), null);
    }

    public E standardLast() {
        return descendingIterator().next();
    }

    public E standardLower(E r10) {
        return (E) Iterators.getNext(headSet(r10, false).descendingIterator(), null);
    }

    public E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    public E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(E r10, boolean r11, E r12, boolean r13) {
        return tailSet(r10, r11).headSet(r12, r13);
    }

    public SortedSet<E> standardTailSet(E r10) {
        return tailSet(r10, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
        return delegate().subSet(r10, r11, r12, r13);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r10, boolean r11) {
        return delegate().tailSet(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    public SortedSet<E> standardSubSet(E r10, E r11) {
        return subSet(r10, true, r11, false);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ SortedSet delegate() {
        return delegate();
    }
}
