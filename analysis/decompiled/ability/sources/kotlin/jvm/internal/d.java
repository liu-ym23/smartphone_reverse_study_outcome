package kotlin.jvm.internal;

import D7.w;
import S7.q;
import S7.r;
import S7.s;
import S7.t;
import S7.u;
import b8.InterfaceC0844e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.KotlinReflectionNotSupportedError;

/* loaded from: classes3.dex */
public final class d implements Z7.d, c {
    public static final Map b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f4923a;

    static {
        List listN = H4.o.N(S7.a.class, S7.k.class, S7.n.class, S7.o.class, S7.p.class, q.class, r.class, s.class, t.class, u.class, S7.b.class, S7.c.class, InterfaceC0844e.class, S7.d.class, S7.e.class, S7.f.class, S7.g.class, S7.h.class, S7.i.class, S7.j.class, S7.l.class, S7.m.class, InterfaceC0844e.class);
        ArrayList arrayList = new ArrayList(w.c0(listN, 10));
        int i = 0;
        for (Object obj : listN) {
            int i6 = i + 1;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i)));
            i = i6;
        }
        b = kotlin.collections.a.X(arrayList);
    }

    public d(Class jClass) {
        k.f(jClass, "jClass");
        this.f4923a = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public final Class b() {
        return this.f4923a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && M.a.a0(this).equals(M.a.a0((Z7.d) obj));
    }

    @Override // Z7.d
    public final int hashCode() {
        return M.a.a0(this).hashCode();
    }

    @Override // Z7.d
    public final boolean j() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // Z7.d
    public final boolean k(Object obj) {
        Class jClass = this.f4923a;
        k.f(jClass, "jClass");
        Map map = b;
        k.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(jClass);
        if (num != null) {
            return p.g(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = M.a.a0(M.a.c0(jClass));
        }
        return jClass.isInstance(obj);
    }

    @Override // Z7.d
    public final String l() {
        String strF;
        Class jClass = this.f4923a;
        k.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        if (!jClass.isArray()) {
            String strF2 = p.f(jClass.getName());
            return strF2 == null ? jClass.getCanonicalName() : strF2;
        }
        Class<?> componentType = jClass.getComponentType();
        if (componentType.isPrimitive() && (strF = p.f(componentType.getName())) != null) {
            strConcat = strF.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    @Override // Z7.d
    public final String m() {
        String strI;
        Class jClass = this.f4923a;
        k.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            if (!jClass.isArray()) {
                String strI2 = p.i(jClass.getName());
                return strI2 == null ? jClass.getSimpleName() : strI2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (strI = p.i(componentType.getName())) != null) {
                strConcat = strI.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            return j9.m.H0(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return j9.m.G0('$', simpleName, simpleName);
        }
        return j9.m.H0(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    public final String toString() {
        return this.f4923a.toString() + " (Kotlin reflection is not available)";
    }
}
