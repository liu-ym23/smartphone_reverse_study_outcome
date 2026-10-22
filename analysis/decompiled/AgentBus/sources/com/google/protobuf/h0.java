package com.google.protobuf;

/* loaded from: classes.dex */
public enum h0 implements k2 {
    FIELD_PRESENCE_UNKNOWN(0),
    EXPLICIT(1),
    IMPLICIT(2),
    LEGACY_REQUIRED(3);


    /* renamed from: f, reason: collision with root package name */
    public final int f2386f;

    h0(int i2) {
        this.f2386f = i2;
    }

    public static h0 a(int i2) {
        if (i2 == 0) {
            return FIELD_PRESENCE_UNKNOWN;
        }
        if (i2 == 1) {
            return EXPLICIT;
        }
        if (i2 == 2) {
            return IMPLICIT;
        }
        if (i2 != 3) {
            return null;
        }
        return LEGACY_REQUIRED;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2386f;
    }
}
