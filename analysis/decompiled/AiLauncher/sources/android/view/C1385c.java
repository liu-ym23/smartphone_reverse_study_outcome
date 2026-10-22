package android.view;

import android.view.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1385c {

    /* renamed from: c, reason: collision with root package name */
    public static C1385c f14264c = new C1385c();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a> f14265a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Boolean> f14266b = new HashMap();

    @Deprecated
    /* renamed from: androidx.lifecycle.c$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<Lifecycle.Event, List<b>> f14267a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<b, Lifecycle.Event> f14268b;

        public a(Map<b, Lifecycle.Event> map) {
            this.f14268b = map;
            for (Map.Entry<b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<b> arrayList = this.f14267a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f14267a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        public static void b(List<b> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lifecycleOwner, event, obj);
                }
            }
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b(this.f14267a.get(event), lifecycleOwner, event, obj);
            b(this.f14267a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.c$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f14269a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f14270b;

        public b(int i10, Method method) throws SecurityException {
            this.f14269a = i10;
            this.f14270b = method;
            method.setAccessible(true);
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i10 = this.f14269a;
                if (i10 == 0) {
                    this.f14270b.invoke(obj, null);
                } else if (i10 == 1) {
                    this.f14270b.invoke(obj, lifecycleOwner);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f14270b.invoke(obj, lifecycleOwner, event);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14269a == bVar.f14269a && this.f14270b.getName().equals(bVar.f14270b.getName());
        }

        public int hashCode() {
            return (this.f14269a * 31) + this.f14270b.getName().hashCode();
        }
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i10;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f14268b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : c(cls2).f14268b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            A a10 = (A) method.getAnnotation(A.class);
            if (a10 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                Lifecycle.Event eventValue = a10.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i10, method), eventValue, cls);
                z10 = true;
            }
        }
        a aVar = new a(map);
        this.f14265a.put(cls, aVar);
        this.f14266b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    public final Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    public a c(Class<?> cls) {
        a aVar = this.f14265a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class<?> cls) {
        Boolean bool = this.f14266b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((A) method.getAnnotation(A.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f14266b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f14270b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }
}
