package q7;

import d7.e0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements w7.d, d {

    /* renamed from: g, reason: collision with root package name */
    public static final Map f8806g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f8807h;

    /* renamed from: i, reason: collision with root package name */
    public static final LinkedHashMap f8808i;

    /* renamed from: f, reason: collision with root package name */
    public final Class f8809f;

    static {
        List listU0 = d7.s.u0(p7.a.class, p7.k.class, p7.n.class, p7.o.class, p7.p.class, p7.q.class, p7.r.class, p7.s.class, p7.t.class, p7.u.class, p7.b.class, p7.c.class, z7.f.class, p7.d.class, p7.e.class, p7.f.class, p7.g.class, p7.h.class, p7.i.class, p7.j.class, p7.l.class, p7.m.class, z7.f.class);
        ArrayList arrayList = new ArrayList(d7.t.A0(listU0, 10));
        int i2 = 0;
        for (Object obj : listU0) {
            int i10 = i2 + 1;
            if (i2 < 0) {
                d7.s.z0();
                throw null;
            }
            arrayList.add(new c7.j((Class) obj, Integer.valueOf(i2)));
            i2 = i10;
        }
        f8806g = e0.Z(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        k.d(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            k.b(str);
            sb2.append(ga.k.G0('.', str, str));
            sb2.append("CompanionObject");
            map3.put(sb2.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f8806g.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        f8807h = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(e0.S(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            k.b(str2);
            linkedHashMap.put(key, ga.k.G0('.', str2, str2));
        }
        f8808i = linkedHashMap;
    }

    public e(Class cls) {
        k.e(cls, "jClass");
        this.f8809f = cls;
    }

    public static void a() {
        throw new c7.i();
    }

    @Override // q7.d
    public final Class c() {
        return this.f8809f;
    }

    @Override // w7.d
    public final String d() {
        String str;
        Class cls = this.f8809f;
        k.e(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        boolean zIsArray = cls.isArray();
        HashMap map = f8807h;
        if (!zIsArray) {
            String str2 = (String) map.get(cls.getName());
            return str2 == null ? cls.getCanonicalName() : str2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (str = (String) map.get(componentType.getName())) != null) {
            strConcat = str.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && nb.i.u(this).equals(nb.i.u((w7.d) obj));
    }

    public final int hashCode() {
        return nb.i.u(this).hashCode();
    }

    @Override // w7.d
    public final boolean i() {
        a();
        throw null;
    }

    @Override // w7.d
    public final boolean l() {
        a();
        throw null;
    }

    @Override // w7.d
    public final boolean m() {
        a();
        throw null;
    }

    @Override // w7.d
    public final boolean r(Object obj) {
        Class clsU = this.f8809f;
        k.e(clsU, "jClass");
        Map map = f8806g;
        k.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(clsU);
        if (num != null) {
            return z.d(num.intValue(), obj);
        }
        if (clsU.isPrimitive()) {
            clsU = nb.i.u(nb.i.x(clsU));
        }
        return clsU.isInstance(obj);
    }

    @Override // w7.d
    public final boolean s() {
        a();
        throw null;
    }

    @Override // w7.d
    public final String t() {
        String str;
        Class cls = this.f8809f;
        k.e(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            boolean zIsArray = cls.isArray();
            LinkedHashMap linkedHashMap = f8808i;
            if (!zIsArray) {
                String str2 = (String) linkedHashMap.get(cls.getName());
                return str2 == null ? cls.getSimpleName() : str2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return ga.k.F0(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return ga.k.F0(simpleName, enclosingConstructor.getName() + '$', simpleName);
        }
        int iQ0 = ga.k.q0(simpleName, '$', 0, 6);
        if (iQ0 == -1) {
            return simpleName;
        }
        String strSubstring = simpleName.substring(iQ0 + 1, simpleName.length());
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String toString() {
        return this.f8809f + " (Kotlin reflection is not available)";
    }

    @Override // w7.d
    public final Object v() {
        a();
        throw null;
    }

    @Override // w7.b
    public final List w() {
        throw null;
    }
}
