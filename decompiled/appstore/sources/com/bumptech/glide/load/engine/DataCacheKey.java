package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    public DataCacheKey(Key r10, Key r11) {
        this.sourceKey = r10;
        this.signature = r11;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof DataCacheKey) == false) goto L10;
        DataCacheKey r11 = (DataCacheKey) r10;
        if (this.sourceKey.equals(r11.sourceKey) == true) goto L7;
        return false;
    L7:
        if (this.signature.equals(r11.signature) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public Key getSourceKey() {
        return this.sourceKey;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        this.sourceKey.updateDiskCacheKey(r10);
        this.signature.updateDiskCacheKey(r10);
    }
}
