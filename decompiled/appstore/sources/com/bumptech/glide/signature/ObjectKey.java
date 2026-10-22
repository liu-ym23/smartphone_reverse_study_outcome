package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectKey implements Key {
    private final Object object;

    public ObjectKey(@NonNull Object r10) {
        this.object = Preconditions.checkNotNull(r10);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof ObjectKey) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((ObjectKey) r10).object);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.object + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        r10.update(this.object.toString().getBytes(Key.CHARSET));
    }
}
