package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class Options implements Key {
    private final ArrayMap<Option<?>, Object> values;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.values.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    public Options() {
        this.values = new CachedHashCodeArrayMap();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof Options) == true) goto L5;
        return false;
    L5:
        return this.values.equals(((Options) r100).values);
    }

    public <T> T get(Option<T> r100) {
        if (this.values.containsKey(r100) == false) goto L6;
        return (T) this.values.get(r100);
    L6:
        return r100.getDefaultValue();
    }

    public void putAll(Options r100) {
        this.values.putAll(r100.values);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.values.size()) goto L6;
        updateDiskCacheKey(this.values.keyAt(r101), this.values.valueAt(r101), r100);
        r101 = r101 + 1;
        goto L4
    }

    public <T> Options set(Option<T> r100, T r101) {
        this.values.put(r100, r101);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void updateDiskCacheKey(Option<T> r100, Object r101, MessageDigest r102) {
        r100.update(r101, r102);
    }
}
