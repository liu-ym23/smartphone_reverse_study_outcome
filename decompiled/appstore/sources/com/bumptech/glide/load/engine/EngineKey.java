package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

    public EngineKey(Object r10, Key r11, int r12, int r13, Map<Class<?>, Transformation<?>> r14, Class<?> r15, Class<?> r16, Options r17) {
        this.model = Preconditions.checkNotNull(r10);
        this.signature = (Key) Preconditions.checkNotNull(r11, "Signature must not be null");
        this.width = r12;
        this.height = r13;
        this.transformations = (Map) Preconditions.checkNotNull(r14);
        this.resourceClass = (Class) Preconditions.checkNotNull(r15, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(r16, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(r17);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof EngineKey) == false) goto L22;
        EngineKey r11 = (EngineKey) r10;
        if (this.model.equals(r11.model) == true) goto L7;
        return false;
    L7:
        if (this.signature.equals(r11.signature) == true) goto L9;
        return false;
    L9:
        if (this.height == r11.height) goto L11;
        return false;
    L11:
        if (this.width == r11.width) goto L13;
        return false;
    L13:
        if (this.transformations.equals(r11.transformations) == true) goto L15;
        return false;
    L15:
        if (this.resourceClass.equals(r11.resourceClass) == true) goto L17;
        return false;
    L17:
        if (this.transcodeClass.equals(r11.transcodeClass) == true) goto L19;
        return false;
    L19:
        if (this.options.equals(r11.options) == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        int r10 = this.model.hashCode();
        this.hashCode = r10;
        int r11 = (((((r10 * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        this.hashCode = r11;
        int r12 = (r11 * 31) + this.transformations.hashCode();
        this.hashCode = r12;
        int r13 = (r12 * 31) + this.resourceClass.hashCode();
        this.hashCode = r13;
        int r14 = (r13 * 31) + this.transcodeClass.hashCode();
        this.hashCode = r14;
        this.hashCode = (r14 * 31) + this.options.hashCode();
    L6:
        return this.hashCode;
    }

    public String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.resourceClass + ", transcodeClass=" + this.transcodeClass + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.transformations + ", options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        throw new UnsupportedOperationException();
    }
}
