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
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@NullableDecl @CompatibleWith("K") Object r10, @NullableDecl @CompatibleWith("V") Object r11);

    boolean containsKey(@NullableDecl @CompatibleWith("K") Object r10);

    boolean containsValue(@NullableDecl @CompatibleWith("V") Object r10);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@NullableDecl Object r10);

    Collection<V> get(@NullableDecl K r10);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    @CanIgnoreReturnValue
    boolean put(@NullableDecl K r10, @NullableDecl V r11);

    @CanIgnoreReturnValue
    boolean putAll(Multimap<? extends K, ? extends V> r10);

    @CanIgnoreReturnValue
    boolean putAll(@NullableDecl K r10, Iterable<? extends V> r11);

    @CanIgnoreReturnValue
    boolean remove(@NullableDecl @CompatibleWith("K") Object r10, @NullableDecl @CompatibleWith("V") Object r11);

    @CanIgnoreReturnValue
    Collection<V> removeAll(@NullableDecl @CompatibleWith("K") Object r10);

    @CanIgnoreReturnValue
    Collection<V> replaceValues(@NullableDecl K r10, Iterable<? extends V> r11);

    int size();

    Collection<V> values();
}
