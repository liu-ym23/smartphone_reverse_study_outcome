package b8;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

/* loaded from: classes4.dex */
public final class k0 implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final l0 f2045a;
    public final int b;
    public final Object c;

    public k0(l0 l0Var, int i, C7.f fVar) {
        this.f2045a = l0Var;
        this.b = i;
        this.c = fVar;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [C7.f, java.lang.Object] */
    @Override // S7.a
    public final Object invoke() {
        l0 l0Var = this.f2045a;
        p0 p0Var = l0Var.b;
        Type type = p0Var != null ? (Type) p0Var.invoke() : null;
        if (type instanceof Class) {
            Class cls = (Class) type;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            kotlin.jvm.internal.k.c(componentType);
            return componentType;
        }
        boolean z10 = type instanceof GenericArrayType;
        int i = this.b;
        if (z10) {
            if (i == 0) {
                Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                kotlin.jvm.internal.k.c(genericComponentType);
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + l0Var);
        }
        if (!(type instanceof ParameterizedType)) {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + l0Var);
        }
        Type type2 = (Type) ((List) this.c.getF4884a()).get(i);
        if (!(type2 instanceof WildcardType)) {
            return type2;
        }
        WildcardType wildcardType = (WildcardType) type2;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        kotlin.jvm.internal.k.e(lowerBounds, "getLowerBounds(...)");
        Type type3 = (Type) D7.q.n0(lowerBounds);
        if (type3 == null) {
            Type[] upperBounds = wildcardType.getUpperBounds();
            kotlin.jvm.internal.k.e(upperBounds, "getUpperBounds(...)");
            type3 = (Type) D7.q.k0(upperBounds);
        }
        kotlin.jvm.internal.k.c(type3);
        return type3;
    }
}
