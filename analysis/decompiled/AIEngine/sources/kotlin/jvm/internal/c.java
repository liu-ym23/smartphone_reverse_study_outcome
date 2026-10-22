package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import mb.m;
import zb.l;
import zb.n;
import zb.o;
import zb.p;
import zb.q;
import zb.r;
import zb.s;
import zb.t;
import zb.u;
import zb.v;
import zb.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements ec.c<Object>, b {

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends lb.c<?>>, Integer> f10080b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f10081c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f10082d;

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f10083a;

    static {
        List listB0 = m.b0(zb.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, zb.b.class, zb.c.class, zb.d.class, zb.e.class, zb.f.class, zb.g.class, zb.h.class, zb.i.class, zb.j.class, zb.k.class, zb.m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(m.Z(listB0, 10));
        int i10 = 0;
        for (Object obj : listB0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                m.f0();
                throw null;
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f10080b = kotlin.collections.b.m0(arrayList);
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
        HashMap<String, String> map3 = new HashMap<>();
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
        g.e(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            g.c(str);
            sb2.append(gc.q.H0(str, '.', str));
            sb2.append("CompanionObject");
            map3.put(sb2.toString(), str.concat(".Companion"));
        }
        for (Map.Entry<Class<? extends lb.c<?>>, Integer> entry : f10080b.entrySet()) {
            Class<? extends lb.c<?>> key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            map3.put(key.getName(), "kotlin.Function" + iIntValue);
        }
        f10081c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(mb.v.a0(map3.size()));
        Iterator<T> it = map3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key2 = entry2.getKey();
            String str2 = (String) entry2.getValue();
            g.c(str2);
            linkedHashMap.put(key2, gc.q.H0(str2, '.', str2));
        }
        f10082d = linkedHashMap;
    }

    public c(Class<?> jClass) {
        g.f(jClass, "jClass");
        this.f10083a = jClass;
    }

    @Override // kotlin.jvm.internal.b
    public final Class<?> a() {
        return this.f10083a;
    }

    @Override // ec.c
    public final boolean b(Object obj) {
        Class<?> jClass = this.f10083a;
        g.f(jClass, "jClass");
        Map<Class<? extends lb.c<?>>, Integer> map = f10080b;
        g.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = map.get(jClass);
        if (num != null) {
            return k.d(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = xb.a.f(i.a(jClass));
        }
        return jClass.isInstance(obj);
    }

    @Override // ec.c
    public final String c() {
        String str;
        Class<?> jClass = this.f10083a;
        g.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            boolean zIsArray = jClass.isArray();
            LinkedHashMap linkedHashMap = f10082d;
            if (!zIsArray) {
                String str2 = (String) linkedHashMap.get(jClass.getName());
                return str2 == null ? jClass.getSimpleName() : str2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            return gc.q.G0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return gc.q.G0(simpleName, enclosingConstructor.getName() + '$');
        }
        int iQ0 = gc.q.q0(simpleName, '$', 0, 6);
        if (iQ0 == -1) {
            return simpleName;
        }
        String strSubstring = simpleName.substring(iQ0 + 1, simpleName.length());
        g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String d() {
        String str;
        Class<?> jClass = this.f10083a;
        g.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        boolean zIsArray = jClass.isArray();
        HashMap<String, String> map = f10081c;
        if (!zIsArray) {
            String str2 = map.get(jClass.getName());
            return str2 == null ? jClass.getCanonicalName() : str2;
        }
        Class<?> componentType = jClass.getComponentType();
        if (componentType.isPrimitive() && (str = map.get(componentType.getName())) != null) {
            strConcat = str.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && xb.a.f(this).equals(xb.a.f((ec.c) obj));
    }

    public final int hashCode() {
        return xb.a.f(this).hashCode();
    }

    public final String toString() {
        return this.f10083a + " (Kotlin reflection is not available)";
    }
}
