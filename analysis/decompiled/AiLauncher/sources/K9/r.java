package K9;

import K9.D;
import Z8.C1173v;
import Z8.C1174w;
import Z9.InterfaceC1178a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes5.dex */
public final class r extends D implements Z9.j {

    /* renamed from: b, reason: collision with root package name */
    public final Type f4188b;

    /* renamed from: c, reason: collision with root package name */
    public final Z9.i f4189c;

    public r(Type reflectType) {
        Z9.i reflectJavaClass;
        kotlin.jvm.internal.p.i(reflectType, "reflectType");
        this.f4188b = reflectType;
        Type typeM = M();
        if (typeM instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) typeM);
        } else if (typeM instanceof TypeVariable) {
            reflectJavaClass = new E((TypeVariable) typeM);
        } else {
            if (!(typeM instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + typeM.getClass() + "): " + typeM);
            }
            Type rawType = ((ParameterizedType) typeM).getRawType();
            kotlin.jvm.internal.p.g(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.f4189c = reflectJavaClass;
    }

    @Override // Z9.d
    public boolean A() {
        return false;
    }

    @Override // Z9.j
    public String B() {
        return M().toString();
    }

    @Override // Z9.j
    public String D() {
        throw new UnsupportedOperationException("Type not found: " + M());
    }

    @Override // K9.D
    public Type M() {
        return this.f4188b;
    }

    @Override // Z9.j
    public Z9.i c() {
        return this.f4189c;
    }

    @Override // K9.D, Z9.d
    public InterfaceC1178a d(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return null;
    }

    @Override // Z9.d
    public Collection<InterfaceC1178a> getAnnotations() {
        return C1173v.m();
    }

    @Override // Z9.j
    public boolean t() {
        Type typeM = M();
        if (typeM instanceof Class) {
            TypeVariable[] typeParameters = ((Class) typeM).getTypeParameters();
            kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // Z9.j
    public List<Z9.x> x() {
        List<Type> listH = C0925f.h(M());
        D.a aVar = D.f4146a;
        ArrayList arrayList = new ArrayList(C1174w.x(listH, 10));
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }
}
