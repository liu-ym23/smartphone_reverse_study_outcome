package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = null;
    private final ArrayPool arrayPool;
    private final Class<?> decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation<?> transformation;
    private final int width;

    static {
        RESOURCE_CLASS_BYTES = new LruCache(50);
    }

    public ResourceCacheKey(ArrayPool r10, Key r11, Key r12, int r13, int r14, Transformation<?> r15, Class<?> r16, Options r17) {
        this.arrayPool = r10;
        this.sourceKey = r11;
        this.signature = r12;
        this.width = r13;
        this.height = r14;
        this.transformation = r15;
        this.decodedResourceClass = r16;
        this.options = r17;
    }

    private byte[] getResourceClassBytes() {
        LruCache<Class<?>, byte[]> r10 = RESOURCE_CLASS_BYTES;
        byte[] r11 = r10.get(this.decodedResourceClass);
        if (r11 != null) goto L6;
        byte[] r12 = this.decodedResourceClass.getName().getBytes(Key.CHARSET);
        r10.put(this.decodedResourceClass, r12);
        return r12;
    L6:
        return r11;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof ResourceCacheKey) == false) goto L20;
        ResourceCacheKey r11 = (ResourceCacheKey) r10;
        if (this.height == r11.height) goto L7;
        return false;
    L7:
        if (this.width == r11.width) goto L9;
        return false;
    L9:
        if (Util.bothNullOrEqual(this.transformation, r11.transformation) == true) goto L11;
        return false;
    L11:
        if (this.decodedResourceClass.equals(r11.decodedResourceClass) == true) goto L13;
        return false;
    L13:
        if (this.sourceKey.equals(r11.sourceKey) == true) goto L15;
        return false;
    L15:
        if (this.signature.equals(r11.signature) == true) goto L17;
        return false;
    L17:
        if (this.options.equals(r11.options) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r10 = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        Transformation<?> r11 = this.transformation;
        if (r11 == null) goto L6;
        r10 = (r10 * 31) + r11.hashCode();
    L6:
        return (((r10 * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation='" + this.transformation + "', options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        byte[] r11 = (byte[]) this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(r11).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(r10);
        this.sourceKey.updateDiskCacheKey(r10);
        r10.update(r11);
        Transformation<?> r12 = this.transformation;
        if (r12 == null) goto L5;
        r12.updateDiskCacheKey(r10);
    L5:
        this.options.updateDiskCacheKey(r10);
        r10.update(getResourceClassBytes());
        this.arrayPool.put(r11);
    }
}
