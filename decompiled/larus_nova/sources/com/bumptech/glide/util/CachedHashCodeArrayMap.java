package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes39.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int hashCode;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        this.hashCode = super.hashCode();
    L6:
        return this.hashCode;
    }

    public CachedHashCodeArrayMap() {
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (CachedHashCodeArrayMap.class != r100.getClass()) goto L18;
        if (super.equals(r100) == true) goto L14;
        return false;
    L14:
        if (hashCode() == ((CachedHashCodeArrayMap) r100).hashCode()) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> r100) {
        this.hashCode = 0;
        super.putAll(r100);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int r100) {
        this.hashCode = 0;
        return (V) super.removeAt(r100);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K r100, V r101) {
        this.hashCode = 0;
        return (V) super.put(r100, r101);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int r100, V r101) {
        this.hashCode = 0;
        return (V) super.setValueAt(r100, r101);
    }
}
