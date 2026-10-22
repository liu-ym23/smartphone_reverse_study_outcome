package com.google.protobuf;

/* loaded from: classes.dex */
public enum n3 implements k2 {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* renamed from: f, reason: collision with root package name */
    public final int f2463f;

    n3(int i2) {
        this.f2463f = i2;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f2463f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
