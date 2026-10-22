package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient int[] counts;
    private final transient long[] cumulativeCounts;
    private final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object r1, BoundType r2) {
        return headMultiset(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object r1, BoundType r2) {
        return tailMultiset(r1, r2);
    }

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> r1, int[] r2, long[] r3, int r4, int r5) {
        this.elementSet = r1;
        this.counts = r2;
        this.cumulativeCounts = r3;
        this.offset = r4;
        this.length = r5;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int r3) {
        return Multisets.immutableEntry(this.elementSet.asList().get(r3), this.counts[this.offset + r3]);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return getEntry(0);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return getEntry(this.length - 1);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object r2) {
        int r3 = this.elementSet.indexOf(r2);
        if (r3 != (-1)) goto L6;
        return 0;
    L6:
        return this.counts[r3 + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long[] r0 = this.cumulativeCounts;
        int r1 = this.offset;
        return Ints.saturatedCast(r0[this.length + r1] - r0[r1]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E r4, BoundType r5) {
        RegularImmutableSortedSet<E> r0 = this.elementSet;
        if (Preconditions.checkNotNull(r5) != BoundType.CLOSED) goto L5;
        boolean r6 = true;
    L7:
        return getSubMultiset(0, r0.headIndex(r4, r6));
    L5:
        r6 = false;
        goto L7
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E r3, BoundType r4) {
        RegularImmutableSortedSet<E> r0 = this.elementSet;
        if (Preconditions.checkNotNull(r4) != BoundType.CLOSED) goto L5;
        boolean r5 = true;
    L7:
        return getSubMultiset(r0.tailIndex(r3, r5), this.length);
    L5:
        r5 = false;
        goto L7
    }

    ImmutableSortedMultiset<E> getSubMultiset(int r8, int r9) {
        Preconditions.checkPositionIndexes(r8, r9, this.length);
        if (r8 == r9) goto L5;
        if (r8 != 0) goto L11;
        if (r9 != this.length) goto L11;
        return this;
    L11:
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) this.elementSet.getSubSet(r8, r9), this.counts, this.cumulativeCounts, this.offset + r8, r9 - r8);
    L5:
        return emptyMultiset(comparator());
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        if (this.offset <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.length < this.counts.length) goto L8;
        return false;
    }
}
