package com.google.protobuf;

/* loaded from: classes.dex */
public enum g0 implements k2 {
    ENUM_TYPE_UNKNOWN(0),
    OPEN(1),
    CLOSED(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2363f;

    g0(int i2) {
        this.f2363f = i2;
    }

    public static g0 a(int i2) {
        if (i2 == 0) {
            return ENUM_TYPE_UNKNOWN;
        }
        if (i2 == 1) {
            return OPEN;
        }
        if (i2 != 2) {
            return null;
        }
        return CLOSED;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2363f;
    }
}
