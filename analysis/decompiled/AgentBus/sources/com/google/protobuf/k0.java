package com.google.protobuf;

/* loaded from: classes.dex */
public enum k0 implements k2 {
    REPEATED_FIELD_ENCODING_UNKNOWN(0),
    PACKED(1),
    EXPANDED(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2423f;

    k0(int i2) {
        this.f2423f = i2;
    }

    public static k0 a(int i2) {
        if (i2 == 0) {
            return REPEATED_FIELD_ENCODING_UNKNOWN;
        }
        if (i2 == 1) {
            return PACKED;
        }
        if (i2 != 2) {
            return null;
        }
        return EXPANDED;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2423f;
    }
}
