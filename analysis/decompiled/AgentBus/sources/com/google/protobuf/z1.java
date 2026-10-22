package com.google.protobuf;

/* loaded from: classes.dex */
public enum z1 implements k2 {
    TYPE_UNKNOWN(0),
    TYPE_DOUBLE(1),
    TYPE_FLOAT(2),
    TYPE_INT64(3),
    TYPE_UINT64(4),
    TYPE_INT32(5),
    TYPE_FIXED64(6),
    TYPE_FIXED32(7),
    TYPE_BOOL(8),
    TYPE_STRING(9),
    TYPE_GROUP(10),
    TYPE_MESSAGE(11),
    TYPE_BYTES(12),
    TYPE_UINT32(13),
    TYPE_ENUM(14),
    TYPE_SFIXED32(15),
    TYPE_SFIXED64(16),
    TYPE_SINT32(17),
    TYPE_SINT64(18),
    UNRECOGNIZED(-1);


    /* renamed from: f, reason: collision with root package name */
    public final int f2663f;

    z1(int i2) {
        this.f2663f = i2;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f2663f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
