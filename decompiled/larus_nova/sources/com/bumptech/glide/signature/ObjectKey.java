package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class ObjectKey implements Key {
    private final Object object;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.object + '}';
    }

    public ObjectKey(Object r100) {
        this.object = Preconditions.checkNotNull(r100);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof ObjectKey) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((ObjectKey) r100).object);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(this.object.toString().getBytes(Key.CHARSET));
    }
}
