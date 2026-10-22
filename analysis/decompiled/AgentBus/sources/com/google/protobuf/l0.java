package com.google.protobuf;

/* loaded from: classes.dex */
public enum l0 implements k2 {
    UTF8_VALIDATION_UNKNOWN(0),
    VERIFY(2),
    NONE(3);


    /* renamed from: f, reason: collision with root package name */
    public final int f2431f;

    l0(int i2) {
        this.f2431f = i2;
    }

    public static l0 a(int i2) {
        if (i2 == 0) {
            return UTF8_VALIDATION_UNKNOWN;
        }
        if (i2 == 2) {
            return VERIFY;
        }
        if (i2 != 3) {
            return null;
        }
        return NONE;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2431f;
    }
}
