package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public interface RangeSet<C extends Comparable> {
    void add(Range<C> r10);

    void addAll(RangeSet<C> r10);

    void addAll(Iterable<Range<C>> r10);

    Set<Range<C>> asDescendingSetOfRanges();

    Set<Range<C>> asRanges();

    void clear();

    RangeSet<C> complement();

    boolean contains(C r10);

    boolean encloses(Range<C> r10);

    boolean enclosesAll(RangeSet<C> r10);

    boolean enclosesAll(Iterable<Range<C>> r10);

    boolean equals(@NullableDecl Object r10);

    int hashCode();

    boolean intersects(Range<C> r10);

    boolean isEmpty();

    Range<C> rangeContaining(C r10);

    void remove(Range<C> r10);

    void removeAll(RangeSet<C> r10);

    void removeAll(Iterable<Range<C>> r10);

    Range<C> span();

    RangeSet<C> subRangeSet(Range<C> r10);

    String toString();
}
