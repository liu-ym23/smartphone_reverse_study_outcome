package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + '}';
    }

    public Key getSourceKey() {
        return this.sourceKey;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof DataCacheKey) == false) goto L10;
        DataCacheKey r101 = (DataCacheKey) r100;
        if (this.sourceKey.equals(r101.sourceKey) == true) goto L7;
        return false;
    L7:
        if (this.signature.equals(r101.signature) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        this.sourceKey.updateDiskCacheKey(r100);
        this.signature.updateDiskCacheKey(r100);
    }

    public DataCacheKey(Key r100, Key r101) {
        this.sourceKey = r100;
        this.signature = r101;
    }
}
