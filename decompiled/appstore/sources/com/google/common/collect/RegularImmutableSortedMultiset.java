package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = null;
    private static final long[] ZERO_CUMULATIVE_COUNTS = null;
    private final transient long[] cumulativeCounts;

    @VisibleForTesting
    final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    static {
        ZERO_CUMULATIVE_COUNTS = new long[]{0};
        NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    }

    public RegularImmutableSortedMultiset(Comparator<? super E> r10) {
        this.elementSet = ImmutableSortedSet.emptySet(r10);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int r10) {
        long[] r11 = this.cumulativeCounts;
        int r12 = this.offset;
        return (int) (r11[(r12 + r10) + 1] - r11[r12 + r10]);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object r10) {
        int r11 = this.elementSet.indexOf(r10);
        if (r11 >= 0) goto L7;
        return 0;
    L7:
        return getCount(r11);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> getEntry(int r10) {
        return Multisets.immutableEntry(this.elementSet.asList().get(r10), getCount(r10));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int r10, int r11) {
        Preconditions.checkPositionIndexes(r10, r11, this.length);
        if (r10 == r11) goto L5;
        if (r10 != 0) goto L11;
        if (r11 != this.length) goto L11;
        return this;
    L11:
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(r10, r11), this.cumulativeCounts, this.offset + r10, r11 - r10);
    L5:
        return ImmutableSortedMultiset.emptyMultiset(comparator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object r10, BoundType r11) {
        return headMultiset(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        if (this.offset <= 0) goto L5;
        return true;
    L5:
        if (this.length < (this.cumulativeCounts.length - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] r10 = this.cumulativeCounts;
        int r11 = this.offset;
        return Ints.saturatedCast(r10[this.length + r11] - r10[r11]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object r10, BoundType r11) {
        return tailMultiset(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E r10, BoundType r11) {
        RegularImmutableSortedSet<E> r12 = this.elementSet;
        if (Preconditions.checkNotNull(r11) != BoundType.CLOSED) goto L5;
        boolean r13 = true;
    L7:
        return getSubMultiset(0, r12.headIndex(r10, r13));
    L5:
        r13 = false;
        goto L7
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E r10, BoundType r11) {
        RegularImmutableSortedSet<E> r12 = this.elementSet;
        if (Preconditions.checkNotNull(r11) != BoundType.CLOSED) goto L5;
        boolean r13 = true;
    L7:
        return getSubMultiset(r12.tailIndex(r10, r13), this.length);
    L5:
        r13 = false;
        goto L7
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> r10, long[] r11, int r12, int r13) {
        this.elementSet = r10;
        this.cumulativeCounts = r11;
        this.offset = r12;
        this.length = r13;
    }
}
