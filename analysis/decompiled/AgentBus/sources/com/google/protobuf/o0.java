package com.google.protobuf;

/* loaded from: classes.dex */
public enum o0 implements k2 {
    LABEL_OPTIONAL(1),
    LABEL_REPEATED(3),
    LABEL_REQUIRED(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2470f;

    o0(int i2) {
        this.f2470f = i2;
    }

    public static o0 a(int i2) {
        if (i2 == 1) {
            return LABEL_OPTIONAL;
        }
        if (i2 == 2) {
            return LABEL_REQUIRED;
        }
        if (i2 != 3) {
            return null;
        }
        return LABEL_REPEATED;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2470f;
    }
}
