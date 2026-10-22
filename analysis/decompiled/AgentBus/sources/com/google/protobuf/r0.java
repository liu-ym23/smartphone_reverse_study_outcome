package com.google.protobuf;

/* loaded from: classes.dex */
public enum r0 implements k2 {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2511f;

    r0(int i2) {
        this.f2511f = i2;
    }

    public static r0 a(int i2) {
        if (i2 == 0) {
            return STRING;
        }
        if (i2 == 1) {
            return CORD;
        }
        if (i2 != 2) {
            return null;
        }
        return STRING_PIECE;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2511f;
    }
}
