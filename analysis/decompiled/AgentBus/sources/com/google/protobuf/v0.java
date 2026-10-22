package com.google.protobuf;

/* loaded from: classes.dex */
public enum v0 implements k2 {
    RETENTION_UNKNOWN(0),
    RETENTION_RUNTIME(1),
    RETENTION_SOURCE(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2586f;

    v0(int i2) {
        this.f2586f = i2;
    }

    public static v0 a(int i2) {
        if (i2 == 0) {
            return RETENTION_UNKNOWN;
        }
        if (i2 == 1) {
            return RETENTION_RUNTIME;
        }
        if (i2 != 2) {
            return null;
        }
        return RETENTION_SOURCE;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2586f;
    }
}
