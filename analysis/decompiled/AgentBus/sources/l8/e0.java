package l8;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* loaded from: classes.dex */
public final class e0 extends b0 implements v8.d {

    /* renamed from: a, reason: collision with root package name */
    public final WildcardType f5866a;

    public e0(WildcardType wildcardType) {
        this.f5866a = wildcardType;
    }

    @Override // l8.b0
    public final Type b() {
        return this.f5866a;
    }

    public final b0 c() {
        WildcardType wildcardType = this.f5866a;
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + wildcardType);
        }
        if (lowerBounds.length == 1) {
            Object objR0 = d7.n.r0(lowerBounds);
            q7.k.d(objR0, "lowerBounds.single()");
            Type type = (Type) objR0;
            boolean z4 = type instanceof Class;
            if (z4) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new z(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z4 && ((Class) type).isArray())) ? new i(type) : type instanceof WildcardType ? new e0((WildcardType) type) : new q(type);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        Type type2 = (Type) d7.n.r0(upperBounds);
        if (q7.k.a(type2, Object.class)) {
            return null;
        }
        q7.k.d(type2, "ub");
        boolean z10 = type2 instanceof Class;
        if (z10) {
            Class cls2 = (Class) type2;
            if (cls2.isPrimitive()) {
                return new z(cls2);
            }
        }
        return ((type2 instanceof GenericArrayType) || (z10 && ((Class) type2).isArray())) ? new i(type2) : type2 instanceof WildcardType ? new e0((WildcardType) type2) : new q(type2);
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        return d7.z.f2978f;
    }
}
