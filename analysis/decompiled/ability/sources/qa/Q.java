package qa;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public final class Q implements GenericArrayType {

    /* renamed from: a, reason: collision with root package name */
    public final Type f5648a;

    public Q(Type type) {
        this.f5648a = type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && U.c(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f5648a;
    }

    public final int hashCode() {
        return this.f5648a.hashCode();
    }

    public final String toString() {
        return U.p(this.f5648a) + "[]";
    }
}
