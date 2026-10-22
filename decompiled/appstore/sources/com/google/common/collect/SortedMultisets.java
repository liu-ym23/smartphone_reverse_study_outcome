package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
final class SortedMultisets {

    public static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {

        @Weak
        private final SortedMultiset<E> multiset;

        public ElementSet(SortedMultiset<E> r10) {
            this.multiset = r10;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) SortedMultisets.access$000(multiset().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E r10) {
            return multiset().headMultiset(r10, BoundType.OPEN).elementSet();
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) SortedMultisets.access$000(multiset().lastEntry());
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public /* bridge */ /* synthetic */ Multiset multiset() {
            return multiset();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E r10, E r11) {
            return multiset().subMultiset(r10, BoundType.CLOSED, r11, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E r10) {
            return multiset().tailMultiset(r10, BoundType.CLOSED).elementSet();
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public final SortedMultiset<E> multiset() {
            return this.multiset;
        }
    }

    @GwtIncompatible
    public static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        public NavigableElementSet(SortedMultiset<E> r10) {
            super(r10);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r10) {
            return (E) SortedMultisets.access$100(multiset().tailMultiset(r10, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E r10) {
            return (E) SortedMultisets.access$100(multiset().headMultiset(r10, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r10, boolean r11) {
            return new NavigableElementSet(multiset().headMultiset(r10, BoundType.forBoolean(r11)));
        }

        @Override // java.util.NavigableSet
        public E higher(E r10) {
            return (E) SortedMultisets.access$100(multiset().tailMultiset(r10, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E r10) {
            return (E) SortedMultisets.access$100(multiset().headMultiset(r10, BoundType.OPEN).lastEntry());
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
        public NavigableSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
            return new NavigableElementSet(multiset().subMultiset(r10, BoundType.forBoolean(r11), r12, BoundType.forBoolean(r13)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r10, boolean r11) {
            return new NavigableElementSet(multiset().tailMultiset(r10, BoundType.forBoolean(r11)));
        }
    }

    private SortedMultisets() {
    }

    public static /* synthetic */ Object access$000(Multiset.Entry r10) {
        return getElementOrThrow(r10);
    }

    public static /* synthetic */ Object access$100(Multiset.Entry r10) {
        return getElementOrNull(r10);
    }

    private static <E> E getElementOrNull(@NullableDecl Multiset.Entry<E> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getElement();
    }

    private static <E> E getElementOrThrow(Multiset.Entry<E> r10) {
        if (r10 == null) goto L6;
        return r10.getElement();
    L6:
        throw new NoSuchElementException();
    }
}
