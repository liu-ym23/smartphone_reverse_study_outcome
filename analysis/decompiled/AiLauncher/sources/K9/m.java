package K9;

import K9.D;
import Z8.C1173v;
import Z9.InterfaceC1178a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes5.dex */
public final class m extends D implements Z9.f {

    /* renamed from: b, reason: collision with root package name */
    public final Type f4180b;

    /* renamed from: c, reason: collision with root package name */
    public final D f4181c;

    /* renamed from: d, reason: collision with root package name */
    public final Collection<InterfaceC1178a> f4182d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4183e;

    public m(Type reflectType) {
        D dA;
        kotlin.jvm.internal.p.i(reflectType, "reflectType");
        this.f4180b = reflectType;
        Type typeM = M();
        if (!(typeM instanceof GenericArrayType)) {
            if (typeM instanceof Class) {
                Class cls = (Class) typeM;
                if (cls.isArray()) {
                    D.a aVar = D.f4146a;
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.p.h(componentType, "getComponentType(...)");
                    dA = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + M().getClass() + "): " + M());
        }
        D.a aVar2 = D.f4146a;
        Type genericComponentType = ((GenericArrayType) typeM).getGenericComponentType();
        kotlin.jvm.internal.p.h(genericComponentType, "getGenericComponentType(...)");
        dA = aVar2.a(genericComponentType);
        this.f4181c = dA;
        this.f4182d = C1173v.m();
    }

    @Override // Z9.d
    public boolean A() {
        return this.f4183e;
    }

    @Override // K9.D
    public Type M() {
        return this.f4180b;
    }

    @Override // Z9.f
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public D n() {
        return this.f4181c;
    }

    @Override // Z9.d
    public Collection<InterfaceC1178a> getAnnotations() {
        return this.f4182d;
    }
}
