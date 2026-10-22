package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@Nullable Object r1, @Nullable Object r2);

    boolean containsKey(@Nullable Object r1);

    boolean containsValue(@Nullable Object r1);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@Nullable Object r1);

    Collection<V> get(@Nullable K r1);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    boolean put(@Nullable K r1, @Nullable V r2);

    boolean putAll(Multimap<? extends K, ? extends V> r1);

    boolean putAll(@Nullable K r1, Iterable<? extends V> r2);

    boolean remove(@Nullable Object r1, @Nullable Object r2);

    Collection<V> removeAll(@Nullable Object r1);

    Collection<V> replaceValues(@Nullable K r1, Iterable<? extends V> r2);

    int size();

    Collection<V> values();
}
