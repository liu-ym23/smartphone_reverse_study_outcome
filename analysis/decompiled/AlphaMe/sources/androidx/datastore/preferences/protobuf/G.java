package androidx.datastore.preferences.protobuf;

import com.stepos.alphame.utils.Property;
import java.io.Serializable;

/* loaded from: classes.dex */
public enum G {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(Property.DEFAULT_FLOAT_VALUE)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(AbstractC0259h.class, AbstractC0259h.f3480b),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* renamed from: a, reason: collision with root package name */
    public final Object f3409a;

    G(Class cls, Serializable serializable) {
    }
}
