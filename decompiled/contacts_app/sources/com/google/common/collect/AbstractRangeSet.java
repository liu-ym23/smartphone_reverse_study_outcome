package com.google.common.collect;

import java.lang.Comparable;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    @Override // com.google.common.collect.RangeSet
    public abstract boolean encloses(Range<C> r1);

    @Override // com.google.common.collect.RangeSet
    public abstract Range<C> rangeContaining(C r1);

    AbstractRangeSet() {
    }

    @Override // com.google.common.collect.RangeSet
    public boolean contains(C r1) {
        if (rangeContaining(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public void add(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void remove(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(RangeSet<C> r2) {
        Iterator<Range<C>> r3 = r2.asRanges().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (encloses(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(RangeSet<C> r2) {
        Iterator<Range<C>> r3 = r2.asRanges().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add(r3.next());
        goto L4
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(RangeSet<C> r2) {
        Iterator<Range<C>> r3 = r2.asRanges().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    @Override // com.google.common.collect.RangeSet
    public boolean equals(@Nullable Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof RangeSet) == true) goto L8;
        return false;
    L8:
        return asRanges().equals(((RangeSet) r2).asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeSet
    public final String toString() {
        return asRanges().toString();
    }
}
