package com.google.protobuf;

/* loaded from: classes.dex */
public enum i0 implements k2 {
    JSON_FORMAT_UNKNOWN(0),
    ALLOW(1),
    LEGACY_BEST_EFFORT(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2397f;

    i0(int i2) {
        this.f2397f = i2;
    }

    public static i0 a(int i2) {
        if (i2 == 0) {
            return JSON_FORMAT_UNKNOWN;
        }
        if (i2 == 1) {
            return ALLOW;
        }
        if (i2 != 2) {
            return null;
        }
        return LEGACY_BEST_EFFORT;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2397f;
    }
}
