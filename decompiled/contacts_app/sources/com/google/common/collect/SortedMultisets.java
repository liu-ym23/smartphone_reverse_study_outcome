package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class SortedMultisets {

    static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
        private final SortedMultiset<E> multiset;

        @Override // com.google.common.collect.Multisets.ElementSet
        /* bridge */ /* synthetic */ Multiset multiset() {
            return multiset();
        }

        ElementSet(SortedMultiset<E> r1) {
            this.multiset = r1;
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        final SortedMultiset<E> multiset() {
            return this.multiset;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E r3, E r4) {
            return multiset().subMultiset(r3, BoundType.CLOSED, r4, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E r2) {
            return multiset().headMultiset(r2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E r2) {
            return multiset().tailMultiset(r2, BoundType.CLOSED).elementSet();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) SortedMultisets.access$000(multiset().firstEntry());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) SortedMultisets.access$000(multiset().lastEntry());
        }
    }

    static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        NavigableElementSet(SortedMultiset<E> r1) {
            super(r1);
        }

        @Override // java.util.NavigableSet
        public E lower(E r2) {
            return (E) SortedMultisets.access$100(multiset().headMultiset(r2, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E floor(E r2) {
            return (E) SortedMultisets.access$100(multiset().headMultiset(r2, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r2) {
            return (E) SortedMultisets.access$100(multiset().tailMultiset(r2, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E higher(E r2) {
            return (E) SortedMultisets.access$100(multiset().tailMultiset(r2, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) SortedMultisets.access$100(multiset().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) SortedMultisets.access$100(multiset().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r2, boolean r3, E r4, boolean r5) {
            return new NavigableElementSet(multiset().subMultiset(r2, BoundType.forBoolean(r3), r4, BoundType.forBoolean(r5)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r2, boolean r3) {
            return new NavigableElementSet(multiset().headMultiset(r2, BoundType.forBoolean(r3)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r2, boolean r3) {
            return new NavigableElementSet(multiset().tailMultiset(r2, BoundType.forBoolean(r3)));
        }
    }

    static /* synthetic */ Object access$000(Multiset.Entry r0) {
        return getElementOrThrow(r0);
    }

    static /* synthetic */ Object access$100(Multiset.Entry r0) {
        return getElementOrNull(r0);
    }

    private SortedMultisets() {
    }

    private static <E> E getElementOrThrow(Multiset.Entry<E> r0) {
        if (r0 == null) goto L6;
        return r0.getElement();
    L6:
        throw new NoSuchElementException();
    }

    private static <E> E getElementOrNull(@Nullable Multiset.Entry<E> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getElement();
    }
}
