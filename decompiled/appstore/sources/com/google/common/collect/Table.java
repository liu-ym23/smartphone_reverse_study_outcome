package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        boolean equals(@NullableDecl Object r10);

        @NullableDecl
        C getColumnKey();

        @NullableDecl
        R getRowKey();

        @NullableDecl
        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C r10);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@NullableDecl @CompatibleWith("R") Object r10, @NullableDecl @CompatibleWith("C") Object r11);

    boolean containsColumn(@NullableDecl @CompatibleWith("C") Object r10);

    boolean containsRow(@NullableDecl @CompatibleWith("R") Object r10);

    boolean containsValue(@NullableDecl @CompatibleWith("V") Object r10);

    boolean equals(@NullableDecl Object r10);

    V get(@NullableDecl @CompatibleWith("R") Object r10, @NullableDecl @CompatibleWith("C") Object r11);

    int hashCode();

    boolean isEmpty();

    @CanIgnoreReturnValue
    @NullableDecl
    V put(R r10, C r11, V r12);

    void putAll(Table<? extends R, ? extends C, ? extends V> r10);

    @CanIgnoreReturnValue
    @NullableDecl
    V remove(@NullableDecl @CompatibleWith("R") Object r10, @NullableDecl @CompatibleWith("C") Object r11);

    Map<C, V> row(R r10);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
