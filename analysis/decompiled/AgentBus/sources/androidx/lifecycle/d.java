package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f988c = new d();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f989a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f990b = new HashMap();

    public static void b(HashMap map, c cVar, p pVar, Class cls) {
        p pVar2 = (p) map.get(cVar);
        if (pVar2 == null || pVar == pVar2) {
            if (pVar2 == null) {
                map.put(cVar, pVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + cVar.f979b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + pVar2 + ", new value " + pVar);
    }

    public final b a(Class cls, Method[] methodArr) throws SecurityException {
        int i2;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f989a;
        if (superclass != null) {
            b bVarA = (b) map2.get(superclass);
            if (bVarA == null) {
                bVarA = a(superclass, null);
            }
            map.putAll(bVarA.f977b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            b bVarA2 = (b) map2.get(cls2);
            if (bVarA2 == null) {
                bVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : bVarA2.f977b.entrySet()) {
                b(map, (c) entry.getKey(), (p) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e10) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
            }
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            z zVar = (z) method.getAnnotation(z.class);
            if (zVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!v.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                p pVarValue = zVar.value();
                if (parameterTypes.length > 1) {
                    if (!p.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (pVarValue != p.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new c(i2, method), pVarValue, cls);
                z4 = true;
            }
        }
        b bVar = new b(map);
        map2.put(cls, bVar);
        this.f990b.put(cls, Boolean.valueOf(z4));
        return bVar;
    }
}
