package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class Options implements Key {
    private final ArrayMap values;

    public Options() {
        this.values = new CachedHashCodeArrayMap();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof Options) == true) goto L5;
        return false;
    L5:
        return this.values.equals(((Options) r10).values);
    }

    @Nullable
    public <T> T get(@NonNull Option<T> r10) {
        if (this.values.containsKey(r10) == false) goto L6;
        return (T) this.values.get(r10);
    L6:
        return r10.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(@NonNull Options r10) {
        this.values.putAll(r10.values);
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> r10, @NonNull T r11) {
        this.values.put(r10, r11);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.values.size()) goto L6;
        updateDiskCacheKey((Option) this.values.keyAt(r11), this.values.valueAt(r11), r10);
        r11 = r11 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void updateDiskCacheKey(@NonNull Option<T> r10, @NonNull Object r11, @NonNull MessageDigest r12) {
        r10.update(r11, r12);
    }
}
