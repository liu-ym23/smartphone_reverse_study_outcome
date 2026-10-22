package Z7;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: Z7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0290a implements GenericArrayType, Type {

    /* renamed from: a, reason: collision with root package name */
    public final Type f1610a;

    public C0290a(Type elementType) {
        kotlin.jvm.internal.k.f(elementType, "elementType");
        this.f1610a = elementType;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return kotlin.jvm.internal.k.b(this.f1610a, ((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f1610a;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return kotlin.reflect.b.a(this.f1610a) + "[]";
    }

    public final int hashCode() {
        return this.f1610a.hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
