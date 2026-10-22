package com.bumptech.glide.f;

/* JADX INFO: compiled from: CachedHashCodeArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<K, V> extends androidx.b.a<K, V> {
    private int i;

    public b() {
    }

    @Override // androidx.b.g, java.util.Map
    public void clear() {
        this.i = 0;
        super.clear();
    }

    @Override // androidx.b.g
    public V a(int r2, V r3) {
        this.i = 0;
        return (V) super.a(r2, r3);
    }

    @Override // androidx.b.g, java.util.Map
    public V put(K r2, V r3) {
        this.i = 0;
        return (V) super.put(r2, r3);
    }

    @Override // androidx.b.g
    public void a(androidx.b.g<? extends K, ? extends V> r2) {
        this.i = 0;
        super.a(r2);
    }

    @Override // androidx.b.g
    public V d(int r2) {
        this.i = 0;
        return (V) super.d(r2);
    }

    @Override // androidx.b.g, java.util.Map
    public int hashCode() {
        if (this.i != 0) goto L6;
        this.i = super.hashCode();
    L6:
        return this.i;
    }
}
