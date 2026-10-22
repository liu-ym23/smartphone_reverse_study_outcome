package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
class EngineKey implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class<?> resourceClass;
    private final Key signature;
    private final Class<?> transcodeClass;
    private final Map<Class<?>, Transformation<?>> transformations;
    private final int width;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        int r100 = this.model.hashCode();
        this.hashCode = r100;
        int r101 = (((((r100 * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        this.hashCode = r101;
        int r102 = (r101 * 31) + this.transformations.hashCode();
        this.hashCode = r102;
        int r103 = (r102 * 31) + this.resourceClass.hashCode();
        this.hashCode = r103;
        int r104 = (r103 * 31) + this.transcodeClass.hashCode();
        this.hashCode = r104;
        this.hashCode = (r104 * 31) + this.options.hashCode();
    L6:
        return this.hashCode;
    }

    public String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.resourceClass + ", transcodeClass=" + this.transcodeClass + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.transformations + ", options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof EngineKey) == false) goto L22;
        EngineKey r101 = (EngineKey) r100;
        if (this.model.equals(r101.model) == true) goto L7;
        return false;
    L7:
        if (this.signature.equals(r101.signature) == true) goto L9;
        return false;
    L9:
        if (this.height == r101.height) goto L11;
        return false;
    L11:
        if (this.width == r101.width) goto L13;
        return false;
    L13:
        if (this.transformations.equals(r101.transformations) == true) goto L15;
        return false;
    L15:
        if (this.resourceClass.equals(r101.resourceClass) == true) goto L17;
        return false;
    L17:
        if (this.transcodeClass.equals(r101.transcodeClass) == true) goto L19;
        return false;
    L19:
        if (this.options.equals(r101.options) == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        throw new UnsupportedOperationException();
    }

    public EngineKey(Object r100, Key r101, int r102, int r103, Map<Class<?>, Transformation<?>> r104, Class<?> r105, Class<?> r106, Options r107) {
        this.model = Preconditions.checkNotNull(r100);
        this.signature = (Key) Preconditions.checkNotNull(r101, "Signature must not be null");
        this.width = r102;
        this.height = r103;
        this.transformations = (Map) Preconditions.checkNotNull(r104);
        this.resourceClass = (Class) Preconditions.checkNotNull(r105, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(r106, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(r107);
    }
}
