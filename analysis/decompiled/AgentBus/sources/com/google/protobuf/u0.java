package com.google.protobuf;

/* loaded from: classes.dex */
public enum u0 implements k2 {
    JS_NORMAL(0),
    JS_STRING(1),
    JS_NUMBER(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2557f;

    u0(int i2) {
        this.f2557f = i2;
    }

    public static u0 a(int i2) {
        if (i2 == 0) {
            return JS_NORMAL;
        }
        if (i2 == 1) {
            return JS_STRING;
        }
        if (i2 != 2) {
            return null;
        }
        return JS_NUMBER;
    }

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2557f;
    }
}
