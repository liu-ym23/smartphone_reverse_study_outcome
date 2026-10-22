package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    public AbstractRangeSet() {
    }

    @Override // com.google.common.collect.RangeSet
    public void add(Range<C> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(RangeSet<C> r10) {
        addAll(r10.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean contains(C r10) {
        if (rangeContaining(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public abstract boolean encloses(Range<C> r10);

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(RangeSet<C> r10) {
        return enclosesAll(r10.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof RangeSet) == true) goto L8;
        return false;
    L8:
        return asRanges().equals(((RangeSet) r10).asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean intersects(Range<C> r10) {
        return !subRangeSet(r10).isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public abstract Range<C> rangeContaining(C r10);

    @Override // com.google.common.collect.RangeSet
    public void remove(Range<C> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(RangeSet<C> r10) {
        removeAll(r10.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public final String toString() {
        return asRanges().toString();
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(Iterable<Range<C>> r10) {
        Iterator<Range<C>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        add(r11.next());
        goto L4
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(Iterable<Range<C>> r10) {
        Iterator<Range<C>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (encloses(r11.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(Iterable<Range<C>> r10) {
        Iterator<Range<C>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        remove(r11.next());
        goto L4
    }
}
