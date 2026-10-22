package com.google.protobuf;

/* loaded from: classes.dex */
public enum j0 implements k2 {
    MESSAGE_ENCODING_UNKNOWN(0),
    LENGTH_PREFIXED(1),
    DELIMITED(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2411f;

    j0(int i2) {
        this.f2411f = i2;
    }

    public static j0 a(int i2) {
        if (i2 == 0) {
            return MESSAGE_ENCODING_UNKNOWN;
        }
        if (i2 == 1) {
            return LENGTH_PREFIXED;
        }
        if (i2 != 2) {
            return null;
        }
        return DELIMITED;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2411f;
    }
}
