package com.bumptech.glide.load;

import S0.a;

/* loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    ANIMATED_WEBP(true),
    AVIF(true),
    ANIMATED_AVIF(true),
    UNKNOWN(false);


    /* renamed from: a, reason: collision with root package name */
    public final boolean f9566a;

    ImageHeaderParser$ImageType(boolean z4) {
        this.f9566a = z4;
    }

    public boolean hasAlpha() {
        return this.f9566a;
    }

    public boolean isWebp() {
        int i4 = a.f1788a[ordinal()];
        return i4 == 1 || i4 == 2 || i4 == 3;
    }
}
