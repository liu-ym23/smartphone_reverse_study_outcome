package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements v5.c, g {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f3673b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f3674a;

    static {
        List listS = c5.l.S(new Class[]{p5.a.class, p5.l.class, p5.p.class, p5.q.class, p5.r.class, p5.s.class, p5.t.class, p5.u.class, p5.v.class, p5.w.class, p5.b.class, p5.c.class, p5.d.class, p5.e.class, p5.f.class, p5.g.class, p5.h.class, p5.i.class, p5.j.class, p5.k.class, p5.m.class, p5.n.class, p5.o.class});
        ArrayList arrayList = new ArrayList(c5.o.n0(listS, 10));
        int i8 = 0;
        for (Object obj : listS) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                c5.n.m0();
                throw null;
            }
            arrayList.add(new b5.g((Class) obj, Integer.valueOf(i8)));
            i8 = i9;
        }
        f3673b = c5.z.V(arrayList);
    }

    public h(Class jClass) {
        p.e(jClass, "jClass");
        this.f3674a = jClass;
    }

    @Override // kotlin.jvm.internal.g
    public final Class a() {
        return this.f3674a;
    }

    public final String b() {
        String strK;
        Class jClass = this.f3674a;
        p.e(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            if (!jClass.isArray()) {
                String strK2 = p.k(jClass.getName());
                return strK2 == null ? jClass.getSimpleName() : strK2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (strK = p.k(componentType.getName())) != null) {
                strConcat = strK.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            return x5.n.L1(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return x5.n.K1(simpleName, '$', simpleName);
        }
        return x5.n.L1(simpleName, enclosingConstructor.getName() + '$');
    }

    public final boolean c(Object obj) {
        Class jClass = this.f3674a;
        p.e(jClass, "jClass");
        Map map = f3673b;
        p.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(jClass);
        if (num != null) {
            return d0.b(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = k4.v.J(z.a(jClass));
        }
        return jClass.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof h) && k4.v.J(this).equals(k4.v.J((v5.c) obj));
    }

    public final int hashCode() {
        return k4.v.J(this).hashCode();
    }

    public final String toString() {
        return this.f3674a.toString() + " (Kotlin reflection is not available)";
    }
}
