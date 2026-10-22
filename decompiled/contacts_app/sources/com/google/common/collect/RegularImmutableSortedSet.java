package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final transient ImmutableList<E> elements;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    RegularImmutableSortedSet(ImmutableList<E> r1, Comparator<? super E> r2) {
        super(r2);
        this.elements = r1;
        Preconditions.checkArgument(!r1.isEmpty());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r2) {
        if (r2 == null) goto L11;
        if (unsafeBinarySearch(r2) < 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r6) {
        if ((r6 instanceof Multiset) == false) goto L6;
        r6 = ((Multiset) r6).elementSet();
    L6:
        if (SortedIterables.hasSameComparator(comparator(), r6) == false) goto L26;
        if (r6.size() <= 1) goto L26;
        PeekingIterator r0 = Iterators.peekingIterator(iterator());
        Iterator<?> r7 = r6.iterator();
        Object r2 = r7.next();
    L28:
        if (r0.hasNext() == false) goto L24;
        int r4 = unsafeCompare(r0.peek(), r2);     // Catch: Throwable -> L27
        if (r4 < 0) goto L16;
        if (r4 == 0) goto L19;
        if (r4 <= 0) goto L28;
    L19:
        if (r7.hasNext() == false) goto L20;
        r2 = r7.next();     // Catch: Throwable -> L27
        goto L28
    L20:
        return true;
    L16:
        r0.next();     // Catch: Throwable -> L27
    L24:
        return false;
    L26:
        return super.containsAll(r6);
    }

    private int unsafeBinarySearch(Object r2) throws ClassCastException {
        return Collections.binarySearch(this.elements, r2, unsafeComparator());
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        return this.elements.copyIntoArray(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof Set) == true) goto L8;
        return false;
    L8:
        Set r7 = (Set) r6;
        if (size() == r7.size()) goto L12;
        return false;
    L12:
        if (SortedIterables.hasSameComparator(this.comparator, r7) == false) goto L25;
        Iterator<E> r8 = r7.iterator();
        UnmodifiableIterator<E> r1 = iterator();     // Catch: Throwable -> L23
    L16:
        if (r1.hasNext() == false) goto L22;
        E r3 = r1.next();     // Catch: Throwable -> L23
        E r4 = r8.next();     // Catch: Throwable -> L23
        if (r4 == null) goto L21;
        if (unsafeCompare(r3, r4) == 0) goto L16;
    L21:
        return false;
    L22:
        return true;
    L23:
        return false;
    L25:
        return containsAll(r7);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        return this.elements.get(0);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        return this.elements.get(size() - 1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E r2) {
        int r3 = headIndex(r2, false) - 1;
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E r2) {
        int r3 = headIndex(r2, true) - 1;
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E r2) {
        int r3 = tailIndex(r2, true);
        if (r3 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E r2) {
        int r3 = tailIndex(r2, false);
        if (r3 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> headSetImpl(E r2, boolean r3) {
        return getSubSet(0, headIndex(r2, r3));
    }

    int headIndex(E r3, boolean r4) {
        ImmutableList<E> r0 = this.elements;
        Object r5 = Preconditions.checkNotNull(r3);
        Comparator<? super E> r2 = comparator();
        if (r4 == false) goto L5;
        SortedLists.KeyPresentBehavior r6 = SortedLists.KeyPresentBehavior.FIRST_AFTER;
    L7:
        return SortedLists.binarySearch(r0, r5, r2, r6, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L5:
        r6 = SortedLists.KeyPresentBehavior.FIRST_PRESENT;
        goto L7
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E r1, boolean r2, E r3, boolean r4) {
        return tailSetImpl(r1, r2).headSetImpl(r3, r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E r1, boolean r2) {
        return getSubSet(tailIndex(r1, r2), size());
    }

    int tailIndex(E r3, boolean r4) {
        ImmutableList<E> r0 = this.elements;
        Object r5 = Preconditions.checkNotNull(r3);
        Comparator<? super E> r2 = comparator();
        if (r4 == false) goto L5;
        SortedLists.KeyPresentBehavior r6 = SortedLists.KeyPresentBehavior.FIRST_PRESENT;
    L7:
        return SortedLists.binarySearch(r0, r5, r2, r6, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L5:
        r6 = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        goto L7
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    ImmutableSortedSet<E> getSubSet(int r3, int r4) {
        if (r3 == 0) goto L4;
    L6:
        if (r3 >= r4) goto L10;
        return new RegularImmutableSortedSet(this.elements.subList(r3, r4), this.comparator);
    L10:
        return emptySet(this.comparator);
    L4:
        if (r4 != size()) goto L6;
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    int indexOf(@Nullable Object r5) {
        if (r5 != null) goto L10;
        return -1;
    L10:
        int r4 = SortedLists.binarySearch(this.elements, r5, unsafeComparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);     // Catch: ClassCastException -> L9
        if (r4 >= 0) goto L8;
        return -1;
    L8:
        return r4;
    L13:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return new ImmutableSortedAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        return new RegularImmutableSortedSet(this.elements.reverse(), Ordering.from(this.comparator).reverse());
    }
}
