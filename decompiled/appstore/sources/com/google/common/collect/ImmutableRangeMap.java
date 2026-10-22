package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = null;
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    public static final class Builder<K extends Comparable<?>, V> {
        private final List<Map.Entry<Range<K>, V>> entries;

        public Builder() {
            this.entries = Lists.newArrayList();
        }

        public ImmutableRangeMap<K, V> build() {
            Collections.sort(this.entries, Range.rangeLexOrdering().onKeys());
            ImmutableList.Builder r10 = new ImmutableList.Builder(this.entries.size());
            ImmutableList.Builder r11 = new ImmutableList.Builder(this.entries.size());
            int r12 = 0;
        L4:
            if (r12 >= this.entries.size()) goto L16;
            Range<K> r13 = this.entries.get(r12).getKey();
            if (r12 <= 0) goto L14;
            Range<K> r14 = this.entries.get(r12 - 1).getKey();
            if (r13.isConnected(r14) == false) goto L14;
            if (r13.intersection(r14).isEmpty() == true) goto L14;
            throw new IllegalArgumentException("Overlapping ranges: range " + r14 + " overlaps with entry " + r13);
        L14:
            r10.add(r13);
            r11.add(this.entries.get(r12).getValue());
            r12 = r12 + 1;
            goto L4
        L16:
            return new ImmutableRangeMap(r10.build(), r11.build());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Range<K> r10, V r11) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            Preconditions.checkArgument(!r10.isEmpty(), "Range must not be empty, but was %s", r10);
            this.entries.add(Maps.immutableEntry(r10, r11));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(RangeMap<K, ? extends V> r10) {
            Iterator r11 = r10.asMapOfRanges().entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry r12 = (Map.Entry) r11.next();
            put((Range) r12.getKey(), r12.getValue());
            goto L4
        L6:
            return this;
        }
    }

    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> r10) {
            this.mapOfRanges = r10;
        }

        public Object createRangeMap() {
            Builder r10 = new Builder();
            UnmodifiableIterator<Map.Entry<Range<K>, V>> r11 = this.mapOfRanges.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            Map.Entry<Range<K>, V> r12 = r11.next();
            r10.put(r12.getKey(), r12.getValue());
            goto L4
        L7:
            return r10.build();
        }

        public Object readResolve() {
            if (this.mapOfRanges.isEmpty() == false) goto L7;
            return ImmutableRangeMap.of();
        L7:
            return createRangeMap();
        }
    }

    static {
        EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> r10, ImmutableList<V> r11) {
        this.ranges = r10;
        this.values = r11;
    }

    public static /* synthetic */ ImmutableList access$000(ImmutableRangeMap r10) {
        return r10.ranges;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> r10) {
        if ((r10 instanceof ImmutableRangeMap) == true) goto L5;
        Map<Range<K>, ? extends V> r11 = r10.asMapOfRanges();
        ImmutableList.Builder r12 = new ImmutableList.Builder(r11.size());
        ImmutableList.Builder r13 = new ImmutableList.Builder(r11.size());
        Iterator r14 = r11.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L11;
        Map.Entry r15 = (Map.Entry) r14.next();
        r12.add(r15.getKey());
        r13.add(r15.getValue());
        goto L8
    L11:
        return new ImmutableRangeMap(r12.build(), r13.build());
    L5:
        return (ImmutableRangeMap) r10;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
        return asDescendingMapOfRanges();
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ Map asMapOfRanges() {
        return asMapOfRanges();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof RangeMap) == true) goto L5;
        return false;
    L5:
        return asMapOfRanges().equals(((RangeMap) r10).asMapOfRanges());
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public V get(K r10) {
        int r11 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r10), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        if (this.ranges.get(r11).contains(r10) == true) goto L8;
        return null;
    L8:
        return this.values.get(r11);
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public Map.Entry<Range<K>, V> getEntry(K r10) {
        int r11 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r10), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r11 != (-1)) goto L5;
        return null;
    L5:
        Range<K> r12 = this.ranges.get(r11);
        if (r12.contains(r10) == true) goto L8;
        return null;
    L8:
        return Maps.immutableEntry(r12, this.values.get(r11));
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void put(Range<K> r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void putAll(RangeMap<K, V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void putCoalescing(Range<K> r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void remove(Range<K> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Range<K> r10 = this.ranges.get(0);
        ImmutableList<Range<K>> r11 = this.ranges;
        return Range.create(r10.lowerBound, r11.get(r11.size() - 1).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ RangeMap subRangeMap(Range r10) {
        return subRangeMap(r10);
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> r10, V r11) {
        return new ImmutableRangeMap(ImmutableList.of(r10), ImmutableList.of(r11));
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
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
        ImmutableList<Range<K>> r11 = this.ranges;
        Function r12 = Range.upperBoundFn();
        Comparable r13 = r10.lowerBound;
        SortedLists.KeyPresentBehavior r14 = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior r15 = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int r16 = SortedLists.binarySearch(r11, r12, r13, r14, r15);
        int r17 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r10.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, r15);
        if (r16 >= r17) goto L14;
        final int r18 = r17 - r16;
        final ImmutableList<Range<K>> r19 = new AnonymousClass1(this, r18, r16, r10);
        final ImmutableList<V> r20 = this.values.subList(r16, r17);
        return (ImmutableRangeMap<K, V>) new AnonymousClass2(this, r19, r20, r10, this);
    L14:
        return of();
    }
}
