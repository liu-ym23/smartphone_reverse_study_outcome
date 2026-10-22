package androidx.datastore.preferences.protobuf;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum a0 {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(f.class, f.f1105g),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* renamed from: c, reason: collision with root package name */
    public final Object f1082c;

    a0(Class cls, Serializable serializable) {
        this.f1082c = serializable;
    }
}
