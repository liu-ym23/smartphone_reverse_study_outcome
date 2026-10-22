package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = null;

    @VisibleForTesting
    final transient ImmutableList<E> elements;

    static {
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), Ordering.natural());
    }

    public RegularImmutableSortedSet(ImmutableList<E> r10, Comparator<? super E> r11) {
        super(r11);
        this.elements = r10;
    }

    private int unsafeBinarySearch(Object r10) throws ClassCastException {
        return Collections.binarySearch(this.elements, r10, unsafeComparator());
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E r10) {
        int r11 = tailIndex(r10, true);
        if (r11 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r11);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object r10) {
        if (r10 == null) goto L11;
        if (unsafeBinarySearch(r10) < 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r10) {
        if ((r10 instanceof Multiset) == false) goto L6;
        r10 = ((Multiset) r10).elementSet();
    L6:
        if (SortedIterables.hasSameComparator(comparator(), r10) == false) goto L29;
        if (r10.size() <= 1) goto L29;
        UnmodifiableIterator<E> r11 = iterator();
        Iterator<?> r12 = r10.iterator();
        if (r11.hasNext() == true) goto L13;
        return false;
    L13:
        Object r13 = r12.next();
        E r14 = r11.next();
    L31:
        int r15 = unsafeCompare(r14, r13);     // Catch: Throwable -> L30
        if (r15 < 0) goto L17;
        if (r15 == 0) goto L22;
        if (r15 <= 0) goto L31;
    L22:
        if (r12.hasNext() == false) goto L23;
        r13 = r12.next();     // Catch: Throwable -> L30
        goto L31
    L23:
        return true;
    L17:
        if (r11.hasNext() == false) goto L18;
        r14 = r11.next();     // Catch: Throwable -> L30
        goto L31
    L18:
        return false;
    L27:
        return false;
    L29:
        return super.containsAll(r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r10, int r11) {
        return this.elements.copyIntoArray(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> createDescendingSet() {
        Comparator r10 = Collections.reverseOrder(this.comparator);
        if (isEmpty() == false) goto L6;
        return ImmutableSortedSet.emptySet(r10);
    L6:
        return new RegularImmutableSortedSet(this.elements.reverse(), r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == true) goto L8;
        return false;
    L8:
        Set r11 = (Set) r10;
        if (size() == r11.size()) goto L12;
        return false;
    L12:
        if (isEmpty() == false) goto L15;
        return true;
    L15:
        if (SortedIterables.hasSameComparator(this.comparator, r11) == false) goto L28;
        Iterator<E> r12 = r11.iterator();
        UnmodifiableIterator<E> r13 = iterator();     // Catch: Throwable -> L26
    L19:
        if (r13.hasNext() == false) goto L25;
        E r14 = r13.next();     // Catch: Throwable -> L26
        E r15 = r12.next();     // Catch: Throwable -> L26
        if (r15 == null) goto L24;
        if (unsafeCompare(r14, r15) == 0) goto L19;
    L24:
        return false;
    L25:
        return true;
    L26:
        return false;
    L28:
        return containsAll(r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (isEmpty() == true) goto L7;
        return this.elements.get(0);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E r10) {
        int r11 = headIndex(r10, true) - 1;
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r11);
    }

    public RegularImmutableSortedSet<E> getSubSet(int r10, int r11) {
        if (r10 == 0) goto L4;
    L6:
        if (r10 >= r11) goto L10;
        return new RegularImmutableSortedSet(this.elements.subList(r10, r11), this.comparator);
    L10:
        return ImmutableSortedSet.emptySet(this.comparator);
    L4:
        if (r11 != size()) goto L6;
        return this;
    }

    public int headIndex(E r10, boolean r11) {
        int r12 = Collections.binarySearch(this.elements, Preconditions.checkNotNull(r10), comparator());
        if (r12 < 0) goto L8;
        if (r11 == true) goto L6;
        return r12;
    L6:
        return r12 + 1;
    L8:
        return ~r12;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E r10, boolean r11) {
        return getSubSet(0, headIndex(r10, r11));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E r10) {
        int r11 = tailIndex(r10, false);
        if (r11 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(@NullableDecl Object r10) {
        if (r10 != null) goto L10;
        return -1;
    L10:
        int r11 = Collections.binarySearch(this.elements, r10, unsafeComparator());     // Catch: ClassCastException -> L9
        if (r11 >= 0) goto L8;
        return -1;
    L8:
        return r11;
    L13:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (isEmpty() == true) goto L7;
        return this.elements.get(size() - 1);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E r10) {
        int r11 = headIndex(r10, false) - 1;
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> subSetImpl(E r10, boolean r11, E r12, boolean r13) {
        return tailSetImpl(r10, r11).headSetImpl(r12, r13);
    }

    public int tailIndex(E r10, boolean r11) {
        int r12 = Collections.binarySearch(this.elements, Preconditions.checkNotNull(r10), comparator());
        if (r12 < 0) goto L9;
        if (r11 == false) goto L7;
        return r12;
    L7:
        return r12 + 1;
    L9:
        return ~r12;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> tailSetImpl(E r10, boolean r11) {
        return getSubSet(tailIndex(r10, r11), size());
    }

    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }
}
