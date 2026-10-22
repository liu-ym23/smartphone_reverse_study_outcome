package androidx.datastore.preferences.protobuf;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum s1 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(f.f1105g),
    ENUM(null),
    MESSAGE(null);


    /* renamed from: c, reason: collision with root package name */
    public final Object f1204c;

    s1(Serializable serializable) {
        this.f1204c = serializable;
    }
}
