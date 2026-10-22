package com.google.protobuf;

/* loaded from: classes.dex */
public enum a4 implements k2 {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    SYNTAX_EDITIONS(2),
    UNRECOGNIZED(-1);


    /* renamed from: f, reason: collision with root package name */
    public final int f2311f;

    a4(int i2) {
        this.f2311f = i2;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f2311f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
