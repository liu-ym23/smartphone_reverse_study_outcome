package ie;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class t0 implements GenericArrayType {

    /* renamed from: c, reason: collision with root package name */
    public final Type f6080c;

    public t0(Type type) {
        this.f6080c = type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && w0.e(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f6080c;
    }

    public final int hashCode() {
        return this.f6080c.hashCode();
    }

    public final String toString() {
        return w0.s(this.f6080c) + "[]";
    }
}
