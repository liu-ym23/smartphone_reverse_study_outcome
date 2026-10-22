package com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface RangeSet<C extends Comparable> {
    void add(Range<C> r1);

    void addAll(RangeSet<C> r1);

    Set<Range<C>> asRanges();

    void clear();

    RangeSet<C> complement();

    boolean contains(C r1);

    boolean encloses(Range<C> r1);

    boolean enclosesAll(RangeSet<C> r1);

    boolean equals(@Nullable Object r1);

    int hashCode();

    boolean isEmpty();

    Range<C> rangeContaining(C r1);

    void remove(Range<C> r1);

    void removeAll(RangeSet<C> r1);

    Range<C> span();

    RangeSet<C> subRangeSet(Range<C> r1);

    String toString();
}
