package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public class MediaStoreSignature implements Key {
    private final long dateModified;
    private final String mimeType;
    private final int orientation;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r100 = this.mimeType.hashCode() * 31;
        long r101 = this.dateModified;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L20;
        MediaStoreSignature r101 = (MediaStoreSignature) r100;
        if (this.dateModified == r101.dateModified) goto L14;
        return false;
    L14:
        if (this.orientation == r101.orientation) goto L17;
        return false;
    L17:
        if (this.mimeType.equals(r101.mimeType) == true) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        r100.update(this.mimeType.getBytes(Key.CHARSET));
    }

    public MediaStoreSignature(String r100, long r101, int r102) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.mimeType = r100;
        this.dateModified = r101;
        this.orientation = r102;
    }
}
