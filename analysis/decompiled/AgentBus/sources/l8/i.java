package l8;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* loaded from: classes.dex */
public final class i extends b0 implements v8.d {

    /* renamed from: a, reason: collision with root package name */
    public final Type f5870a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f5871b;

    /* renamed from: c, reason: collision with root package name */
    public final d7.z f5872c;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Type type) {
        b0 zVar;
        b0 zVar2;
        this.f5870a = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    q7.k.d(componentType, "getComponentType()");
                    zVar = componentType.isPrimitive() ? new z(componentType) : ((componentType instanceof GenericArrayType) || componentType.isArray()) ? new i(componentType) : componentType instanceof WildcardType ? new e0((WildcardType) componentType) : new q(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + type.getClass() + "): " + type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        q7.k.d(genericComponentType, "genericComponentType");
        boolean z4 = genericComponentType instanceof Class;
        if (z4) {
            Class cls2 = (Class) genericComponentType;
            if (cls2.isPrimitive()) {
                zVar2 = new z(cls2);
                this.f5871b = zVar2;
                this.f5872c = d7.z.f2978f;
            }
        }
        zVar = ((genericComponentType instanceof GenericArrayType) || (z4 && ((Class) genericComponentType).isArray())) ? new i(genericComponentType) : genericComponentType instanceof WildcardType ? new e0((WildcardType) genericComponentType) : new q(genericComponentType);
        zVar2 = zVar;
        this.f5871b = zVar2;
        this.f5872c = d7.z.f2978f;
    }

    @Override // l8.b0
    public final Type b() {
        return this.f5870a;
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        return this.f5872c;
    }
}
