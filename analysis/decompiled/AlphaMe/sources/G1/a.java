package G1;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a implements GenericArrayType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f584a;

    public a(Type type) {
        Objects.requireNonNull(type);
        this.f584a = d.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && d.c(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f584a;
    }

    public final int hashCode() {
        return this.f584a.hashCode();
    }

    public final String toString() {
        return d.g(this.f584a) + "[]";
    }
}
