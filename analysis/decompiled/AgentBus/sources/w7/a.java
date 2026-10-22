package w7;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class a implements GenericArrayType, Type {

    /* renamed from: f, reason: collision with root package name */
    public final Type f10859f;

    public a(Type type) {
        q7.k.e(type, "elementType");
        this.f10859f = type;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return q7.k.a(this.f10859f, ((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f10859f;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return e0.d(this.f10859f) + "[]";
    }

    public final int hashCode() {
        return this.f10859f.hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
