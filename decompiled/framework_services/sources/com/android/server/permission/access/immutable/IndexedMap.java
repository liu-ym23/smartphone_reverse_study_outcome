package com.android.server.permission.access.immutable;

import android.util.ArrayMap;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndexedMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IndexedMap<K, V> implements Immutable<MutableIndexedMap<K, V>> {
    private final ArrayMap<K, V> map;

    public /* synthetic */ IndexedMap(ArrayMap r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IndexedMap(ArrayMap<K, V> r1) {
        this.map = r1;
    }

    public final ArrayMap<K, V> getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.map;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ Object toMutable() {
        return toMutable();
    }

    public final int getSize() {
        return this.map.size();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final boolean contains(K r2) {
        return this.map.containsKey(r2);
    }

    public final V get(K r2) {
        return this.map.get(r2);
    }

    public final int indexOfKey(K r2) {
        return this.map.indexOfKey(r2);
    }

    public final K keyAt(int index) {
        return this.map.keyAt(index);
    }

    public final V valueAt(int index) {
        return this.map.valueAt(index);
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIndexedMap<K, V> toMutable() {
        return new MutableIndexedMap(this);
    }

    public String toString() {
        return this.map.toString();
    }
}
