package androidx.lifecycle;

import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f1367c;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1368a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1369b;

    static {
        d dVar = new d();
        dVar.f1368a = new HashMap();
        dVar.f1369b = new HashMap();
        VarHandle.storeStoreFence();
        f1367c = dVar;
    }

    public static void b(HashMap map, c cVar, o oVar, Class cls) {
        o oVar2 = (o) map.get(cVar);
        if (oVar2 == null || oVar == oVar2) {
            if (oVar2 == null) {
                map.put(cVar, oVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + cVar.f1364b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + oVar2 + ", new value " + oVar);
    }

    public final b a(Class cls, Method[] methodArr) {
        int i;
        HashMap map = this.f1368a;
        Class superclass = cls.getSuperclass();
        HashMap map2 = new HashMap();
        if (superclass != null) {
            b bVarA = (b) map.get(superclass);
            if (bVarA == null) {
                bVarA = a(superclass, null);
            }
            map2.putAll(bVarA.f1358b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            b bVarA2 = (b) map.get(cls2);
            if (bVarA2 == null) {
                bVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : bVarA2.f1358b.entrySet()) {
                b(map2, (c) entry.getKey(), (o) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e10) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
            }
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            e0 e0Var = (e0) method.getAnnotation(e0.class);
            if (e0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!x.class.isAssignableFrom(parameterTypes[0])) {
                        g5.f.s("invalid parameter type. Must be one and instanceof LifecycleOwner");
                        return null;
                    }
                    i = 1;
                }
                o oVarValue = e0Var.value();
                if (parameterTypes.length > 1) {
                    if (!o.class.isAssignableFrom(parameterTypes[1])) {
                        g5.f.s("invalid parameter type. second arg must be an event");
                        return null;
                    }
                    if (oVarValue != o.ON_ANY) {
                        g5.f.s("Second arg is supported only for ON_ANY value");
                        return null;
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    g5.f.s("cannot have more than 2 params");
                    return null;
                }
                c cVar = new c();
                cVar.f1363a = i;
                cVar.f1364b = method;
                method.setAccessible(true);
                VarHandle.storeStoreFence();
                b(map2, cVar, oVarValue, cls);
                z10 = true;
            }
        }
        b bVar = new b();
        bVar.f1358b = map2;
        HashMap map3 = new HashMap();
        bVar.f1357a = map3;
        for (Map.Entry entry2 : map2.entrySet()) {
            o oVar = (o) entry2.getValue();
            List arrayList = (List) map3.get(oVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map3.put(oVar, arrayList);
            }
            arrayList.add((c) entry2.getKey());
        }
        VarHandle.storeStoreFence();
        map.put(cls, bVar);
        this.f1369b.put(cls, Boolean.valueOf(z10));
        return bVar;
    }
}
