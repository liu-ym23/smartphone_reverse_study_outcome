package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface BiMap<K, V> extends Map<K, V> {
    V forcePut(@Nullable K r1, @Nullable V r2);

    BiMap<V, K> inverse();

    V put(@Nullable K r1, @Nullable V r2);

    void putAll(Map<? extends K, ? extends V> r1);

    @Override // java.util.Map
    Set<V> values();
}
