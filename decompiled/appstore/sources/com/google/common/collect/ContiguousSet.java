package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> r10) {
        super(Ordering.natural());
        this.domain = r10;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Beta
    public static ContiguousSet<Integer> closed(int r10, int r11) {
        return create(Range.closed(Integer.valueOf(r10), Integer.valueOf(r11)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Integer> closedOpen(int r10, int r11) {
        return create(Range.closedOpen(Integer.valueOf(r10), Integer.valueOf(r11)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> r10, DiscreteDomain<C> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L4:
        if (r10.hasLowerBound() == true) goto L8;
        Range<C> r12 = r10.intersection(Range.atLeast(r11.minValue()));     // Catch: NoSuchElementException -> L6
    L10:
        if (r10.hasUpperBound() == true) goto L13;
        r12 = r12.intersection(Range.atMost(r11.maxValue()));     // Catch: NoSuchElementException -> L6
    L13:
        if (r12.isEmpty() == true) goto L19;
        if (Range.compareOrThrow(r10.lowerBound.leastValueAbove(r11), r10.upperBound.greatestValueBelow(r11)) > 0) goto L19;
        return new RegularContiguousSet(r12, r11);
    L19:
        return new EmptyContiguousSet(r11);
    L8:
        r12 = r10;
        goto L10
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object r10) {
        return headSet((Comparable) r10);
    }

    public abstract ContiguousSet<C> headSetImpl(C r10, boolean r11);

    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r10, boolean r11) {
        return headSetImpl((Comparable) r10, r11);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> r10);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType r10, BoundType r11);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object r10, Object r11) {
        return subSet((Comparable) r10, (Comparable) r11);
    }

    public abstract ContiguousSet<C> subSetImpl(C r10, boolean r11, C r12, boolean r13);

    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r10, boolean r11, Object r12, boolean r13) {
        return subSetImpl((Comparable) r10, r11, (Comparable) r12, r13);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object r10) {
        return tailSet((Comparable) r10);
    }

    public abstract ContiguousSet<C> tailSetImpl(C r10, boolean r11);

    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r10, boolean r11) {
        return tailSetImpl((Comparable) r10, r11);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    @Beta
    public static ContiguousSet<Long> closed(long r10, long r11) {
        return create(Range.closed(Long.valueOf(r10), Long.valueOf(r11)), DiscreteDomain.longs());
    }

    @Beta
    public static ContiguousSet<Long> closedOpen(long r10, long r11) {
        return create(Range.closedOpen(Long.valueOf(r10), Long.valueOf(r11)), DiscreteDomain.longs());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object r10, boolean r11) {
        return headSet((Comparable) r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object r10, boolean r11, Object r12, boolean r13) {
        return subSet((Comparable) r10, r11, (Comparable) r12, r13);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object r10, boolean r11) {
        return tailSet((Comparable) r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r10, boolean r11) {
        return headSet((Comparable) r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r10, boolean r11, Object r12, boolean r13) {
        return subSet((Comparable) r10, r11, (Comparable) r12, r13);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r10, boolean r11) {
        return tailSet((Comparable) r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r10) {
        return headSet((Comparable) r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r10, Object r11) {
        return subSet((Comparable) r10, (Comparable) r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r10) {
        return tailSet((Comparable) r10);
    }

    public ContiguousSet<C> headSet(C r10) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(r10), false);
    }

    public ContiguousSet<C> subSet(C r10, C r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (comparator().compare(r10, r11) > 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        return subSetImpl(r10, true, r11, false);
    L5:
        r12 = false;
        goto L6
    }

    public ContiguousSet<C> tailSet(C r10) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(r10), true);
    }

    @GwtIncompatible
    public ContiguousSet<C> headSet(C r10, boolean r11) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(r10), r11);
    }

    @GwtIncompatible
    public ContiguousSet<C> tailSet(C r10, boolean r11) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(r10), r11);
    }

    @GwtIncompatible
    public ContiguousSet<C> subSet(C r10, boolean r11, C r12, boolean r13) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        if (comparator().compare(r10, r12) > 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14);
        return subSetImpl(r10, r11, r12, r13);
    L5:
        r14 = false;
        goto L6
    }
}
