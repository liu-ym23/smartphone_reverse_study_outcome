package yb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f16087b;

    /* renamed from: a, reason: collision with root package name */
    public Class f16088a;

    static {
        List listF = ac.a.F(xb.a.class, xb.l.class, xb.p.class, xb.q.class, xb.r.class, xb.s.class, xb.t.class, xb.u.class, xb.v.class, xb.w.class, xb.b.class, xb.c.class, xb.d.class, xb.e.class, xb.f.class, xb.g.class, xb.h.class, xb.i.class, xb.j.class, xb.k.class, xb.m.class, xb.n.class, xb.o.class);
        ArrayList arrayList = new ArrayList(kb.m.m0(listF, 10));
        int i = 0;
        for (Object obj : listF) {
            int i3 = i + 1;
            if (i < 0) {
                ac.a.a0();
                throw null;
            }
            arrayList.add(new jb.g((Class) obj, Integer.valueOf(i)));
            i = i3;
        }
        f16087b = kb.w.Q(arrayList);
    }

    @Override // yb.d
    public final Class a() {
        return this.f16088a;
    }

    public final String b() {
        String strD;
        Class cls = this.f16088a;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strD2 = x.d(cls.getName());
            return strD2 == null ? cls.getCanonicalName() : strD2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strD = x.d(componentType.getName())) != null) {
            strConcat = strD.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final String c() {
        String strF;
        Class cls = this.f16088a;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strF2 = x.f(cls.getName());
                return strF2 == null ? cls.getSimpleName() : strF2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strF = x.f(componentType.getName())) != null) {
                strConcat = strF.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return hc.h.q0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            int iD0 = hc.h.d0(simpleName, '$', 0, 6);
            return iD0 == -1 ? simpleName : simpleName.substring(iD0 + 1, simpleName.length());
        }
        return hc.h.q0(simpleName, enclosingConstructor.getName() + '$');
    }

    public final boolean d(Object obj) {
        Class clsF = this.f16088a;
        clsF.getClass();
        Map map = f16087b;
        map.getClass();
        Integer num = (Integer) map.get(clsF);
        if (num != null) {
            return x.e(num.intValue(), obj);
        }
        if (clsF.isPrimitive()) {
            clsF = t0.a.f(v.a(clsF));
        }
        return clsF.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && t0.a.f(this).equals(t0.a.f((e) obj));
    }

    public final int hashCode() {
        return t0.a.f(this).hashCode();
    }

    public final String toString() {
        return this.f16088a + " (Kotlin reflection is not available)";
    }
}
