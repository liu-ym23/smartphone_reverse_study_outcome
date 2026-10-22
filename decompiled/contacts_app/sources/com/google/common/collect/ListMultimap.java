package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@Nullable Object r1);

    @Override // com.google.common.collect.Multimap
    List<V> get(@Nullable K r1);

    @Override // com.google.common.collect.Multimap
    List<V> removeAll(@Nullable Object r1);

    @Override // com.google.common.collect.Multimap
    List<V> replaceValues(K r1, Iterable<? extends V> r2);
}
