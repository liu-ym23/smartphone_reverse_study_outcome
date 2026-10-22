package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class ResourceCacheKey implements Key {
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

    private byte[] getResourceClassBytes() {
        LruCache<Class<?>, byte[]> r100 = RESOURCE_CLASS_BYTES;
        byte[] r101 = r100.get(this.decodedResourceClass);
        if (r101 != null) goto L6;
        byte[] r102 = this.decodedResourceClass.getName().getBytes(Key.CHARSET);
        r100.put(this.decodedResourceClass, r102);
        return r102;
    L6:
        return r101;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r100 = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        Transformation<?> r101 = this.transformation;
        if (r101 == null) goto L6;
        r100 = (r100 * 31) + r101.hashCode();
    L6:
        return (((r100 * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation='" + this.transformation + "', options=" + this.options + '}';
    }

    public Key getSourceKey() {
        return this.sourceKey;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof ResourceCacheKey) == false) goto L20;
        ResourceCacheKey r101 = (ResourceCacheKey) r100;
        if (this.height == r101.height) goto L7;
        return false;
    L7:
        if (this.width == r101.width) goto L9;
        return false;
    L9:
        if (Util.bothNullOrEqual(this.transformation, r101.transformation) == true) goto L11;
        return false;
    L11:
        if (this.decodedResourceClass.equals(r101.decodedResourceClass) == true) goto L13;
        return false;
    L13:
        if (this.sourceKey.equals(r101.sourceKey) == true) goto L15;
        return false;
    L15:
        if (this.signature.equals(r101.signature) == true) goto L17;
        return false;
    L17:
        if (this.options.equals(r101.options) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        byte[] r101 = (byte[]) this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(r101).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(r100);
        this.sourceKey.updateDiskCacheKey(r100);
        r100.update(r101);
        Transformation<?> r102 = this.transformation;
        if (r102 == null) goto L5;
        r102.updateDiskCacheKey(r100);
    L5:
        this.options.updateDiskCacheKey(r100);
        r100.update(getResourceClassBytes());
        this.arrayPool.put(r101);
    }

    public ResourceCacheKey(ArrayPool r100, Key r101, Key r102, int r103, int r104, Transformation<?> r105, Class<?> r106, Options r107) {
        this.arrayPool = r100;
        this.sourceKey = r101;
        this.signature = r102;
        this.width = r103;
        this.height = r104;
        this.transformation = r105;
        this.decodedResourceClass = r106;
        this.options = r107;
    }
}
