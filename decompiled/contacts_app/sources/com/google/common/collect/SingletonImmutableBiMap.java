package com.google.common.collect;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    transient ImmutableBiMap<V, K> inverse;
    final transient K singleKey;
    final transient V singleValue;

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    SingletonImmutableBiMap(K r1, V r2) {
        CollectPreconditions.checkEntryNotNull(r1, r2);
        this.singleKey = r1;
        this.singleValue = r2;
    }

    private SingletonImmutableBiMap(K r1, V r2, ImmutableBiMap<V, K> r3) {
        this.singleKey = r1;
        this.singleValue = r2;
        this.inverse = r3;
    }

    SingletonImmutableBiMap(Map.Entry<? extends K, ? extends V> r2) {
        this(r2.getKey(), r2.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object r2) {
        if (this.singleKey.equals(r2) == true) goto L7;
        return null;
    L7:
        return this.singleValue;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@Nullable Object r1) {
        return this.singleKey.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object r1) {
        return this.singleValue.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.immutableEntry(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        SingletonImmutableBiMap r1 = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }
}
