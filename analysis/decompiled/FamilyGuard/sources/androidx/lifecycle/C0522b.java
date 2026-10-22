package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0522b {

    /* renamed from: c, reason: collision with root package name */
    static C0522b f10855c = new C0522b();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, a> f10856a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f10857b = new HashMap();

    @Deprecated
    /* renamed from: androidx.lifecycle.b$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map<AbstractC0533m.a, List<C0136b>> f10858a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<C0136b, AbstractC0533m.a> f10859b;

        a(Map<C0136b, AbstractC0533m.a> map) {
            this.f10859b = map;
            for (Map.Entry<C0136b, AbstractC0533m.a> entry : map.entrySet()) {
                AbstractC0533m.a value = entry.getValue();
                List<C0136b> arrayList = this.f10858a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f10858a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void b(List<C0136b> list, InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(interfaceC0539t, aVar, obj);
                }
            }
        }

        void a(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b(this.f10858a.get(aVar), interfaceC0539t, aVar, obj);
            b(this.f10858a.get(AbstractC0533m.a.ON_ANY), interfaceC0539t, aVar, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0136b {

        /* renamed from: a, reason: collision with root package name */
        final int f10860a;

        /* renamed from: b, reason: collision with root package name */
        final Method f10861b;

        C0136b(int i5, Method method) throws SecurityException {
            this.f10860a = i5;
            this.f10861b = method;
            method.setAccessible(true);
        }

        void a(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i5 = this.f10860a;
                if (i5 == 0) {
                    this.f10861b.invoke(obj, null);
                } else if (i5 == 1) {
                    this.f10861b.invoke(obj, interfaceC0539t);
                } else {
                    if (i5 != 2) {
                        return;
                    }
                    this.f10861b.invoke(obj, interfaceC0539t, aVar);
                }
            } catch (IllegalAccessException e6) {
                throw new RuntimeException(e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to call observer method", e7.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0136b)) {
                return false;
            }
            C0136b c0136b = (C0136b) obj;
            return this.f10860a == c0136b.f10860a && this.f10861b.getName().equals(c0136b.f10861b.getName());
        }

        public int hashCode() {
            return (this.f10860a * 31) + this.f10861b.getName().hashCode();
        }
    }

    C0522b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i5;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f10859b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0136b, AbstractC0533m.a> entry : c(cls2).f10859b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z5 = false;
        for (Method method : methodArr) {
            D d6 = (D) method.getAnnotation(D.class);
            if (d6 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i5 = 0;
                } else {
                    if (!InterfaceC0539t.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i5 = 1;
                }
                AbstractC0533m.a aVarValue = d6.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0533m.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0533m.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i5 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0136b(i5, method), aVarValue, cls);
                z5 = true;
            }
        }
        a aVar = new a(map);
        this.f10856a.put(cls, aVar);
        this.f10857b.put(cls, Boolean.valueOf(z5));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e6) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e6);
        }
    }

    private void e(Map<C0136b, AbstractC0533m.a> map, C0136b c0136b, AbstractC0533m.a aVar, Class<?> cls) {
        AbstractC0533m.a aVar2 = map.get(c0136b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0136b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0136b.f10861b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    a c(Class<?> cls) {
        a aVar = this.f10856a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f10857b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((D) method.getAnnotation(D.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f10857b.put(cls, Boolean.FALSE);
        return false;
    }
}
