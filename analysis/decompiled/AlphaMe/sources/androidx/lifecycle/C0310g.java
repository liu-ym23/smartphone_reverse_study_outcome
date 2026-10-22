package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0310g {

    /* renamed from: c, reason: collision with root package name */
    public static final C0310g f3941c = new C0310g();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3942a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3943b = new HashMap();

    public static void c(HashMap map, C0309f c0309f, EnumC0326x enumC0326x, Class cls) {
        EnumC0326x enumC0326x2 = (EnumC0326x) map.get(c0309f);
        if (enumC0326x2 == null || enumC0326x == enumC0326x2) {
            if (enumC0326x2 == null) {
                map.put(c0309f, enumC0326x);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0309f.f3937b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0326x2 + ", new value " + enumC0326x);
    }

    public final C0308e a(Class cls, Method[] methodArr) throws SecurityException {
        int i4;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null) {
            map.putAll(b(superclass).f3929b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : b(cls2).f3929b.entrySet()) {
                c(map, (C0309f) entry.getKey(), (EnumC0326x) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e4) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e4);
            }
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i4 = 0;
                } else {
                    if (!G.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i4 = 1;
                }
                EnumC0326x enumC0326xValue = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!EnumC0326x.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (enumC0326xValue != EnumC0326x.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i4 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(map, new C0309f(method, i4), enumC0326xValue, cls);
                z4 = true;
            }
        }
        C0308e c0308e = new C0308e(map);
        this.f3942a.put(cls, c0308e);
        this.f3943b.put(cls, Boolean.valueOf(z4));
        return c0308e;
    }

    public final C0308e b(Class cls) {
        C0308e c0308e = (C0308e) this.f3942a.get(cls);
        return c0308e != null ? c0308e : a(cls, null);
    }
}
