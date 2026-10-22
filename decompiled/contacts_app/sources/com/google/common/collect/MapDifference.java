package com.google.common.collect;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface MapDifference<K, V> {

    public interface ValueDifference<V> {
        boolean equals(@Nullable Object r1);

        int hashCode();

        V leftValue();

        V rightValue();
    }

    boolean areEqual();

    Map<K, ValueDifference<V>> entriesDiffering();

    Map<K, V> entriesInCommon();

    Map<K, V> entriesOnlyOnLeft();

    Map<K, V> entriesOnlyOnRight();

    boolean equals(@Nullable Object r1);

    int hashCode();
}
