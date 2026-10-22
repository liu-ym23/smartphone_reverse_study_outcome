package kotlin.reflect.jvm.internal.impl.protobuf;

import H8.AbstractC0244e;

/* loaded from: classes4.dex */
public enum WireFormat$JavaType {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(AbstractC0244e.f769a),
    ENUM(null),
    MESSAGE(null);


    /* renamed from: a, reason: collision with root package name */
    public final Object f5103a;

    WireFormat$JavaType(Object obj) {
        this.f5103a = obj;
    }
}
