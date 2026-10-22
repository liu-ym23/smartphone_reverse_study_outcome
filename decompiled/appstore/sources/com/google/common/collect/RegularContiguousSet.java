package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    @GwtIncompatible
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        public /* synthetic */ SerializedForm(Range r10, DiscreteDomain r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }

        private SerializedForm(Range<C> r10, DiscreteDomain<C> r11) {
            this.range = r10;
            this.domain = r11;
        }
    }

    public RegularContiguousSet(Range<C> r10, DiscreteDomain<C> r11) {
        super(r11);
        this.range = r10;
    }

    public static /* synthetic */ boolean access$000(Comparable r10, Comparable r11) {
        return equalsOrThrow(r10, r11);
    }

    private static boolean equalsOrThrow(Comparable<?> r10, @NullableDecl Comparable<?> r11) {
        if (r11 != null) goto L4;
    L6:
        return false;
    L4:
        if (Range.compareOrThrow(r10, r11) != 0) goto L6;
        return true;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> r10) {
        if (this.range.isConnected(r10) == false) goto L6;
        return ContiguousSet.create(this.range.intersection(r10), this.domain);
    L6:
        return new EmptyContiguousSet(this.domain);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object r10) {
        if (r10 != null) goto L8;
        return false;
    L8:
        return this.range.contains((Comparable) r10);
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r10) {
        return Collections2.containsAllImpl(this, r10);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        if (this.domain.supportsFastOffset == false) goto L7;
        return new AnonymousClass3(this);
    L7:
        return super.createAsList();
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
        if ((r10 instanceof RegularContiguousSet) == false) goto L17;
        RegularContiguousSet r11 = (RegularContiguousSet) r10;
        if (this.domain.equals(r11.domain) == false) goto L17;
        if (first().equals(r11.first()) == true) goto L12;
    L14:
        return false;
    L12:
        if (last().equals(r11.last()) == false) goto L14;
        return true;
    L17:
        return super.equals(r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object first() {
        return first();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r10, boolean r11) {
        return headSetImpl((Comparable) r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public int indexOf(Object r10) {
        if (contains(r10) == true) goto L7;
        return -1;
    L7:
        return (int) this.domain.distance(first(), (Comparable) r10);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> r10) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkArgument(this.domain.equals(r10.domain));
        if (r10.isEmpty() == false) goto L5;
        return r10;
    L5:
        Comparable r11 = (Comparable) Ordering.natural().max(first(), r10.first());
        Comparable r12 = (Comparable) Ordering.natural().min(last(), r10.last());
        if (r11.compareTo(r12) > 0) goto L9;
        return ContiguousSet.create(Range.closed(r11, r12), this.domain);
    L9:
        return new EmptyContiguousSet(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object last() {
        return last();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType r10 = BoundType.CLOSED;
        return range(r10, r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long r10 = this.domain.distance(first(), last());
        if (r10 < 2147483647L) goto L6;
        return Channel.UNLIMITED;
    L6:
        return ((int) r10) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r10, boolean r11, Object r12, boolean r13) {
        return subSetImpl((Comparable) r10, r11, (Comparable) r12, r13);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r10, boolean r11) {
        return tailSetImpl((Comparable) r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public UnmodifiableIterator<C> descendingIterator() {
        final Comparable r10 = last();
        return new AnonymousClass2(this, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        return (C) this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> headSetImpl(C r10, boolean r11) {
        return intersectionInCurrentDomain(Range.upTo(r10, BoundType.forBoolean(r11)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<C> iterator() {
        final Comparable r10 = first();
        return new AnonymousClass1(this, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        return (C) this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType r10, BoundType r11) {
        return Range.create(this.range.lowerBound.withLowerBoundType(r10, this.domain), this.range.upperBound.withUpperBoundType(r11, this.domain));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> subSetImpl(C r10, boolean r11, C r12, boolean r13) {
        if (r10.compareTo(r12) != 0) goto L9;
        if (r11 == true) goto L9;
        if (r13 == true) goto L9;
        return new EmptyContiguousSet(this.domain);
    L9:
        return intersectionInCurrentDomain(Range.range(r10, BoundType.forBoolean(r11), r12, BoundType.forBoolean(r13)));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> tailSetImpl(C r10, boolean r11) {
        return intersectionInCurrentDomain(Range.downTo(r10, BoundType.forBoolean(r11)));
    }
}
