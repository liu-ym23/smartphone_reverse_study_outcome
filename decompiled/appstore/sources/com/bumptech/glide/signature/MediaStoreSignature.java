package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class MediaStoreSignature implements Key {
    private final long dateModified;

    @NonNull
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(@Nullable String r10, long r11, int r12) {
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        this.mimeType = r10;
        this.dateModified = r11;
        this.orientation = r12;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L20;
        MediaStoreSignature r11 = (MediaStoreSignature) r10;
        if (this.dateModified == r11.dateModified) goto L14;
        return false;
    L14:
        if (this.orientation == r11.orientation) goto L17;
        return false;
    L17:
        if (this.mimeType.equals(r11.mimeType) == true) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r10 = this.mimeType.hashCode() * 31;
        long r11 = this.dateModified;
        return ((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        r10.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        r10.update(this.mimeType.getBytes(Key.CHARSET));
    }
}
