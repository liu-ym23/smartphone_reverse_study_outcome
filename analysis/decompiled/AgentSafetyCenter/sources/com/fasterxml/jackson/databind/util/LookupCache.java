package com.fasterxml.jackson.databind.util;

import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface LookupCache<K, V> {
    void clear();

    default void contents(BiConsumer<K, V> biConsumer) {
        throw new UnsupportedOperationException();
    }

    default LookupCache<K, V> emptyCopy() {
        throw new UnsupportedOperationException("LookupCache implementation " + getClass().getName() + " does not implement `emptyCopy()`");
    }

    V get(Object obj);

    V put(K k10, V v10);

    V putIfAbsent(K k10, V v10);

    int size();
}
