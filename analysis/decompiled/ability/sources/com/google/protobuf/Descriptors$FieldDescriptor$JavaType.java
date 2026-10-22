package com.google.protobuf;

import java.io.Serializable;

/* loaded from: classes3.dex */
public enum Descriptors$FieldDescriptor$JavaType {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(ByteString.b),
    ENUM(null),
    MESSAGE(null);


    /* renamed from: a, reason: collision with root package name */
    public final Object f2823a;

    Descriptors$FieldDescriptor$JavaType(Serializable serializable) {
        this.f2823a = serializable;
    }
}
