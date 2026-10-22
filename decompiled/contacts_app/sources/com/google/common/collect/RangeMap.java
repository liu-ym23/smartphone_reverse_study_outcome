package com.google.common.collect;

import java.lang.Comparable;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface RangeMap<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();

    void clear();

    boolean equals(@Nullable Object r1);

    @Nullable
    V get(K r1);

    @Nullable
    Map.Entry<Range<K>, V> getEntry(K r1);

    int hashCode();

    void put(Range<K> r1, V r2);

    void putAll(RangeMap<K, V> r1);

    void remove(Range<K> r1);

    Range<K> span();

    RangeMap<K, V> subRangeMap(Range<K> r1);

    String toString();
}
