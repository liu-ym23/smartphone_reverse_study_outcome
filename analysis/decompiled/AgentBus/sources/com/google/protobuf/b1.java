package com.google.protobuf;

/* loaded from: classes.dex */
public enum b1 implements k2 {
    NONE(0),
    SET(1),
    ALIAS(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2316f;

    b1(int i2) {
        this.f2316f = i2;
    }

    public static b1 a(int i2) {
        if (i2 == 0) {
            return NONE;
        }
        if (i2 == 1) {
            return SET;
        }
        if (i2 != 2) {
            return null;
        }
        return ALIAS;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2316f;
    }
}
