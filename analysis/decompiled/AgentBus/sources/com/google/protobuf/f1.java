package com.google.protobuf;

/* loaded from: classes.dex */
public enum f1 implements k2 {
    IDEMPOTENCY_UNKNOWN(0),
    NO_SIDE_EFFECTS(1),
    IDEMPOTENT(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2349f;

    f1(int i2) {
        this.f2349f = i2;
    }

    public static f1 a(int i2) {
        if (i2 == 0) {
            return IDEMPOTENCY_UNKNOWN;
        }
        if (i2 == 1) {
            return NO_SIDE_EFFECTS;
        }
        if (i2 != 2) {
            return null;
        }
        return IDEMPOTENT;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2349f;
    }
}
