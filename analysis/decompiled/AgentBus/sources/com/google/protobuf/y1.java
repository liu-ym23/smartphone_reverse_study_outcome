package com.google.protobuf;

/* loaded from: classes.dex */
public enum y1 implements k2 {
    CARDINALITY_UNKNOWN(0),
    CARDINALITY_OPTIONAL(1),
    CARDINALITY_REQUIRED(2),
    CARDINALITY_REPEATED(3),
    UNRECOGNIZED(-1);


    /* renamed from: f, reason: collision with root package name */
    public final int f2634f;

    y1(int i2) {
        this.f2634f = i2;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f2634f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
