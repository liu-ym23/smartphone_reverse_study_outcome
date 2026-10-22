package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        boolean equals(@Nullable Object r1);

        C getColumnKey();

        R getRowKey();

        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C r1);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@Nullable Object r1, @Nullable Object r2);

    boolean containsColumn(@Nullable Object r1);

    boolean containsRow(@Nullable Object r1);

    boolean containsValue(@Nullable Object r1);

    boolean equals(@Nullable Object r1);

    V get(@Nullable Object r1, @Nullable Object r2);

    int hashCode();

    boolean isEmpty();

    V put(R r1, C r2, V r3);

    void putAll(Table<? extends R, ? extends C, ? extends V> r1);

    V remove(@Nullable Object r1, @Nullable Object r2);

    Map<C, V> row(R r1);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
