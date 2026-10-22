package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public interface RangeMap<K extends Comparable, V> {
    Map<Range<K>, V> asDescendingMapOfRanges();

    Map<Range<K>, V> asMapOfRanges();

    void clear();

    boolean equals(@NullableDecl Object r10);

    @NullableDecl
    V get(K r10);

    @NullableDecl
    Map.Entry<Range<K>, V> getEntry(K r10);

    int hashCode();

    void put(Range<K> r10, V r11);

    void putAll(RangeMap<K, V> r10);

    void putCoalescing(Range<K> r10, V r11);

    void remove(Range<K> r10);

    Range<K> span();

    RangeMap<K, V> subRangeMap(Range<K> r10);

    String toString();
}
