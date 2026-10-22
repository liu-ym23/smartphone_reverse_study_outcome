package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap {
    private int hashCode;

    public CachedHashCodeArrayMap() {
    }

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

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K r10, V r11) {
        this.hashCode = 0;
        return (V) super.put(r10, r11);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap r10) {
        this.hashCode = 0;
        super.putAll(r10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int r10) {
        this.hashCode = 0;
        return (V) super.removeAt(r10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int r10, V r11) {
        this.hashCode = 0;
        return (V) super.setValueAt(r10, r11);
    }
}
