package o7;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements GenericArrayType, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Type f9250c;

    public e(Type type) {
        Objects.requireNonNull(type);
        this.f9250c = h.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && h.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f9250c;
    }

    public final int hashCode() {
        return this.f9250c.hashCode();
    }

    public final String toString() {
        return h.l(this.f9250c) + "[]";
    }
}
