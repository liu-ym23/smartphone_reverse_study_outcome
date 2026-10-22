package com.google.protobuf;

/* loaded from: classes.dex */
public enum z0 implements k2 {
    SPEED(1),
    CODE_SIZE(2),
    LITE_RUNTIME(3);


    /* renamed from: f, reason: collision with root package name */
    public final int f2642f;

    z0(int i2) {
        this.f2642f = i2;
    }

    public static z0 a(int i2) {
        if (i2 == 1) {
            return SPEED;
        }
        if (i2 == 2) {
            return CODE_SIZE;
        }
        if (i2 != 3) {
            return null;
        }
        return LITE_RUNTIME;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2642f;
    }
}
