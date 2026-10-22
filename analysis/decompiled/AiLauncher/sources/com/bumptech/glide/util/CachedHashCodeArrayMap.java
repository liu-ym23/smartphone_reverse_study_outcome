package com.bumptech.glide.util;

import androidx.collection.a;
import androidx.collection.t;

/* loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends a<K, V> {
    private int hashCode;

    @Override // androidx.collection.t, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // androidx.collection.t, java.util.Map
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    @Override // androidx.collection.t, java.util.Map
    public V put(K k10, V v10) {
        this.hashCode = 0;
        return (V) super.put(k10, v10);
    }

    @Override // androidx.collection.t
    public void putAll(t<? extends K, ? extends V> tVar) {
        this.hashCode = 0;
        super.putAll(tVar);
    }

    @Override // androidx.collection.t
    public V removeAt(int i10) {
        this.hashCode = 0;
        return (V) super.removeAt(i10);
    }

    @Override // androidx.collection.t
    public V setValueAt(int i10, V v10) {
        this.hashCode = 0;
        return (V) super.setValueAt(i10, v10);
    }
}
