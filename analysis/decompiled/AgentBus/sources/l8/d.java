package l8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final List f5857a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f5858b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map f5859c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f5860d;

    static {
        q7.x xVar = q7.w.f8821a;
        int i2 = 0;
        List<w7.d> listU0 = d7.s.u0(xVar.b(Boolean.TYPE), xVar.b(Byte.TYPE), xVar.b(Character.TYPE), xVar.b(Double.TYPE), xVar.b(Float.TYPE), xVar.b(Integer.TYPE), xVar.b(Long.TYPE), xVar.b(Short.TYPE));
        f5857a = listU0;
        ArrayList arrayList = new ArrayList(d7.t.A0(listU0, 10));
        for (w7.d dVar : listU0) {
            arrayList.add(new c7.j(nb.i.u(dVar), nb.i.v(dVar)));
        }
        f5858b = d7.e0.Z(arrayList);
        List<w7.d> list = f5857a;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        for (w7.d dVar2 : list) {
            arrayList2.add(new c7.j(nb.i.v(dVar2), nb.i.u(dVar2)));
        }
        f5859c = d7.e0.Z(arrayList2);
        List listU02 = d7.s.u0(p7.a.class, p7.k.class, p7.n.class, p7.o.class, p7.p.class, p7.q.class, p7.r.class, p7.s.class, p7.t.class, p7.u.class, p7.b.class, p7.c.class, z7.f.class, p7.d.class, p7.e.class, p7.f.class, p7.g.class, p7.h.class, p7.i.class, p7.j.class, p7.l.class, p7.m.class, z7.f.class);
        ArrayList arrayList3 = new ArrayList(d7.t.A0(listU02, 10));
        for (Object obj : listU02) {
            int i10 = i2 + 1;
            if (i2 < 0) {
                d7.s.z0();
                throw null;
            }
            arrayList3.add(new c7.j((Class) obj, Integer.valueOf(i2)));
            i2 = i10;
        }
        f5860d = d7.e0.Z(arrayList3);
    }

    public static final e9.b a(Class cls) {
        q7.k.e(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(a1.a.g(cls, "Can't compute ClassId for primitive type: "));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(a1.a.g(cls, "Can't compute ClassId for array type: "));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null && cls.getSimpleName().length() != 0) {
            Class<?> declaringClass = cls.getDeclaringClass();
            return declaringClass != null ? a(declaringClass).d(e9.f.e(cls.getSimpleName())) : e9.b.j(new e9.c(cls.getName()));
        }
        e9.c cVar = new e9.c(cls.getName());
        return new e9.b(cVar.e(), e9.c.j(cVar.f()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final String b(Class cls) {
        q7.k.e(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                return ga.r.d0(cls.getName(), '.', '/');
            }
            return "L" + ga.r.d0(cls.getName(), '.', '/') + ';';
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    return "V";
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    return "F";
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    return "S";
                }
                break;
        }
        throw new IllegalArgumentException(a1.a.g(cls, "Unsupported primitive type: "));
    }

    public static final List c(Type type) {
        q7.k.e(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return d7.z.f2978f;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return fa.l.v0(new fa.g(fa.l.s0(type, c.f5851h), c.f5852i, fa.n.f3639n));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        q7.k.d(actualTypeArguments, "actualTypeArguments");
        return d7.n.w0(actualTypeArguments);
    }

    public static final ClassLoader d(Class cls) {
        q7.k.e(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        q7.k.d(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }
}
