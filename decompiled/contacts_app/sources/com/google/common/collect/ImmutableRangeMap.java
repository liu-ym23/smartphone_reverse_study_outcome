package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V> {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = null;
    private final ImmutableList<Range<K>> ranges;
    private final ImmutableList<V> values;

    public static final class Builder<K extends Comparable<?>, V> {
        private final RangeSet<K> keyRanges;
        private final RangeMap<K, V> rangeMap;

        public Builder() {
            this.keyRanges = TreeRangeSet.create();
            this.rangeMap = TreeRangeMap.create();
        }

        public Builder<K, V> put(Range<K> r5, V r6) {
            Preconditions.checkNotNull(r5);
            Preconditions.checkNotNull(r6);
            Preconditions.checkArgument(!r5.isEmpty(), "Range must not be empty, but was %s", new Object[]{r5});
            if (this.keyRanges.complement().encloses(r5) == true) goto L14;
            Iterator r0 = this.rangeMap.asMapOfRanges().entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L14;
            Map.Entry r1 = (Map.Entry) r0.next();
            Range r2 = (Range) r1.getKey();
            if (r2.isConnected(r5) == false) goto L6;
            if (r2.intersection(r5).isEmpty() == true) goto L6;
            throw new IllegalArgumentException("Overlapping ranges: range " + r5 + " overlaps with entry " + r1);
        L14:
            this.keyRanges.add(r5);
            this.rangeMap.put(r5, r6);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V> putAll(RangeMap<K, ? extends V> r3) {
            Iterator r4 = r3.asMapOfRanges().entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) r4.next();
            put((Range) r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        public ImmutableRangeMap<K, V> build() {
            Map<Range<K>, V> r4 = this.rangeMap.asMapOfRanges();
            ImmutableList.Builder r0 = new ImmutableList.Builder(r4.size());
            ImmutableList.Builder r1 = new ImmutableList.Builder(r4.size());
            Iterator r5 = r4.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L7;
            Map.Entry r2 = (Map.Entry) r5.next();
            r0.add(r2.getKey());
            r1.add(r2.getValue());
            goto L4
        L7:
            return new ImmutableRangeMap(r0.build(), r1.build());
        }
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ Map asMapOfRanges() {
        return asMapOfRanges();
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ RangeMap subRangeMap(Range r1) {
        return subRangeMap(r1);
    }

    static /* synthetic */ ImmutableList access$000(ImmutableRangeMap r0) {
        return r0.ranges;
    }

    static {
        EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> r1, V r2) {
        return new ImmutableRangeMap(ImmutableList.of(r1), ImmutableList.of(r2));
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> r4) {
        if ((r4 instanceof ImmutableRangeMap) == true) goto L5;
        Map<Range<K>, ? extends V> r5 = r4.asMapOfRanges();
        ImmutableList.Builder r0 = new ImmutableList.Builder(r5.size());
        ImmutableList.Builder r1 = new ImmutableList.Builder(r5.size());
        Iterator r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r6.next();
        r0.add(r2.getKey());
        r1.add(r2.getValue());
        goto L8
    L11:
        return new ImmutableRangeMap(r0.build(), r1.build());
    L5:
        return (ImmutableRangeMap) r4;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder();
    }

    ImmutableRangeMap(ImmutableList<Range<K>> r1, ImmutableList<V> r2) {
        this.ranges = r1;
        this.values = r2;
    }

    @Override // com.google.common.collect.RangeMap
    @Nullable
    public V get(K r6) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r6), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        if (this.ranges.get(r0).contains(r6) == true) goto L8;
        return null;
    L8:
        return this.values.get(r0);
    }

    @Override // com.google.common.collect.RangeMap
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K r6) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r6), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        Range<K> r1 = this.ranges.get(r0);
        if (r1.contains(r6) == true) goto L8;
        return null;
    L8:
        return Maps.immutableEntry(r1, this.values.get(r0));
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Range<K> r0 = this.ranges.get(0);
        ImmutableList<Range<K>> r2 = this.ranges;
        return Range.create(r0.lowerBound, r2.get(r2.size() - 1).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new RegularImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING), this.values);
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> r10) {
        if (((Range) Preconditions.checkNotNull(r10)).isEmpty() == false) goto L7;
        return of();
    L7:
        if (this.ranges.isEmpty() == false) goto L9;
    L17:
        return this;
    L9:
        if (r10.encloses(span()) == true) goto L17;
        final int r0 = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), r10.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        int r1 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r10.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (r0 >= r1) goto L14;
        final int r2 = r1 - r0;
        final ImmutableList<Range<K>> r5 = new AnonymousClass1(this, r2, r0, r10);
        final ImmutableList<V> r6 = this.values.subList(r0, r1);
        return (ImmutableRangeMap<K, V>) new AnonymousClass2(this, r5, r6, r10, this);
    L14:
        return of();
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof RangeMap) == true) goto L5;
        return false;
    L5:
        return asMapOfRanges().equals(((RangeMap) r2).asMapOfRanges());
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return asMapOfRanges().toString();
    }
}
