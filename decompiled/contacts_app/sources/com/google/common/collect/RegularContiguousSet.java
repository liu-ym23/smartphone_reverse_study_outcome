package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    private static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        /* synthetic */ SerializedForm(Range r1, DiscreteDomain r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private SerializedForm(Range<C> r1, DiscreteDomain<C> r2) {
            this.range = r1;
            this.domain = r2;
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object first() {
        return first();
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r1, boolean r2) {
        return headSetImpl((Comparable) r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object last() {
        return last();
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r1, boolean r2, Object r3, boolean r4) {
        return subSetImpl((Comparable) r1, r2, (Comparable) r3, r4);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r1, boolean r2) {
        return tailSetImpl((Comparable) r1, r2);
    }

    static /* synthetic */ boolean access$000(Comparable r0, Comparable r1) {
        return equalsOrThrow(r0, r1);
    }

    RegularContiguousSet(Range<C> r1, DiscreteDomain<C> r2) {
        super(r2);
        this.range = r1;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> r2) {
        if (this.range.isConnected(r2) == false) goto L6;
        return ContiguousSet.create(this.range.intersection(r2), this.domain);
    L6:
        return new EmptyContiguousSet(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> headSetImpl(C r1, boolean r2) {
        return intersectionInCurrentDomain(Range.upTo(r1, BoundType.forBoolean(r2)));
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> subSetImpl(C r2, boolean r3, C r4, boolean r5) {
        if (r2.compareTo(r4) != 0) goto L9;
        if (r3 == true) goto L9;
        if (r5 == true) goto L9;
        return new EmptyContiguousSet(this.domain);
    L9:
        return intersectionInCurrentDomain(Range.range(r2, BoundType.forBoolean(r3), r4, BoundType.forBoolean(r5)));
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> tailSetImpl(C r1, boolean r2) {
        return intersectionInCurrentDomain(Range.downTo(r1, BoundType.forBoolean(r2)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    int indexOf(Object r2) {
        if (contains(r2) == true) goto L7;
        return -1;
    L7:
        return (int) this.domain.distance(first(), (Comparable) r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<C> iterator() {
        final Comparable r1 = first();
        return new AnonymousClass1(this, r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public UnmodifiableIterator<C> descendingIterator() {
        final Comparable r1 = last();
        return new AnonymousClass2(this, r1);
    }

    private static boolean equalsOrThrow(Comparable<?> r0, @Nullable Comparable<?> r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (Range.compareOrThrow(r0, r1) != 0) goto L6;
        return true;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        return (C) this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        return (C) this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long r0 = this.domain.distance(first(), last());
        if (r0 < 2147483647L) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return ((int) r0) + 1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r2) {
        if (r2 != null) goto L8;
        return false;
    L8:
        return this.range.contains((Comparable) r2);
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r1) {
        return Collections2.containsAllImpl(this, r1);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> r4) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkArgument(this.domain.equals(r4.domain));
        if (r4.isEmpty() == false) goto L5;
        return r4;
    L5:
        Comparable r0 = (Comparable) Ordering.natural().max(first(), r4.first());
        Comparable r5 = (Comparable) Ordering.natural().min(last(), r4.last());
        if (r0.compareTo(r5) >= 0) goto L9;
        return ContiguousSet.create(Range.closed(r0, r5), this.domain);
    L9:
        return new EmptyContiguousSet(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        return range(BoundType.CLOSED, BoundType.CLOSED);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType r3, BoundType r4) {
        return Range.create(this.range.lowerBound.withLowerBoundType(r3, this.domain), this.range.upperBound.withUpperBoundType(r4, this.domain));
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RegularContiguousSet) == false) goto L17;
        RegularContiguousSet r1 = (RegularContiguousSet) r5;
        if (this.domain.equals(r1.domain) == false) goto L17;
        if (first().equals(r1.first()) == true) goto L12;
    L14:
        return false;
    L12:
        if (last().equals(r1.last()) == false) goto L14;
        return true;
    L17:
        return super.equals(r5);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }
}
