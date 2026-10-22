package n8;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.EmptyList;
import x8.InterfaceC2121d;

/* loaded from: classes4.dex */
public final class x extends u implements InterfaceC2121d {

    /* renamed from: a, reason: collision with root package name */
    public final WildcardType f5368a;
    public final EmptyList b = EmptyList.f4893a;

    public x(WildcardType wildcardType) {
        this.f5368a = wildcardType;
    }

    @Override // n8.u
    public final Type b() {
        return this.f5368a;
    }

    public final u c() {
        WildcardType wildcardType = this.f5368a;
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + wildcardType);
        }
        if (lowerBounds.length == 1) {
            Object objA0 = D7.q.A0(lowerBounds);
            kotlin.jvm.internal.k.e(objA0, "single(...)");
            Type type = (Type) objA0;
            boolean z10 = type instanceof Class;
            if (z10) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new s(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z10 && ((Class) type).isArray())) ? new h(type) : type instanceof WildcardType ? new x((WildcardType) type) : new j(type);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        Type type2 = (Type) D7.q.A0(upperBounds);
        if (kotlin.jvm.internal.k.b(type2, Object.class)) {
            return null;
        }
        kotlin.jvm.internal.k.c(type2);
        boolean z11 = type2 instanceof Class;
        if (z11) {
            Class cls2 = (Class) type2;
            if (cls2.isPrimitive()) {
                return new s(cls2);
            }
        }
        return ((type2 instanceof GenericArrayType) || (z11 && ((Class) type2).isArray())) ? new h(type2) : type2 instanceof WildcardType ? new x((WildcardType) type2) : new j(type2);
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        return this.b;
    }
}
