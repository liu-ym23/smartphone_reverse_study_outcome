package n8;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.EmptyList;
import x8.InterfaceC2121d;

/* loaded from: classes4.dex */
public final class h extends u implements InterfaceC2121d {

    /* renamed from: a, reason: collision with root package name */
    public final Type f5358a;
    public final u b;
    public final EmptyList c;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Type type) {
        u sVar;
        u sVar2;
        this.f5358a = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.k.e(componentType, "getComponentType(...)");
                    sVar = componentType.isPrimitive() ? new s(componentType) : ((componentType instanceof GenericArrayType) || componentType.isArray()) ? new h(componentType) : componentType instanceof WildcardType ? new x((WildcardType) componentType) : new j(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + type.getClass() + "): " + type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        kotlin.jvm.internal.k.e(genericComponentType, "getGenericComponentType(...)");
        boolean z10 = genericComponentType instanceof Class;
        if (z10) {
            Class cls2 = (Class) genericComponentType;
            if (cls2.isPrimitive()) {
                sVar2 = new s(cls2);
                this.b = sVar2;
                this.c = EmptyList.f4893a;
            }
        }
        sVar = ((genericComponentType instanceof GenericArrayType) || (z10 && ((Class) genericComponentType).isArray())) ? new h(genericComponentType) : genericComponentType instanceof WildcardType ? new x((WildcardType) genericComponentType) : new j(genericComponentType);
        sVar2 = sVar;
        this.b = sVar2;
        this.c = EmptyList.f4893a;
    }

    @Override // n8.u
    public final Type b() {
        return this.f5358a;
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        return this.c;
    }
}
