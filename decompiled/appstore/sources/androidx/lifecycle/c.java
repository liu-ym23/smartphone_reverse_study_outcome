package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f3507c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3509b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f3510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f3511b;

        public a(Map r10) {
            this.f3511b = r10;
            this.f3510a = new HashMap();
            Iterator r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            Map.Entry r12 = (Map.Entry) r11.next();
            Lifecycle.Event r13 = (Lifecycle.Event) r12.getValue();
            List r14 = (List) this.f3510a.get(r13);
            if (r14 != null) goto L8;
            r14 = new ArrayList();
            this.f3510a.put(r13, r14);
        L8:
            r14.add((b) r12.getKey());
            goto L4
        }

        public static void b(List r10, LifecycleOwner r11, Lifecycle.Event r12, Object r13) {
            if (r10 == null) goto L6;
            int r14 = r10.size() - 1;
        L4:
            if (r14 < 0) goto L8;
            ((b) r10.get(r14)).a(r11, r12, r13);
            r14 = r14 - 1;
            goto L4
        L8:
            return;
        }

        public void a(LifecycleOwner r10, Lifecycle.Event r11, Object r12) {
            b((List) this.f3510a.get(r11), r10, r11, r12);
            b((List) this.f3510a.get(Lifecycle.Event.ON_ANY), r10, r11, r12);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f3513b;

        public b(int r10, Method r11) {
            this.f3512a = r10;
            this.f3513b = r11;
            r11.setAccessible(true);
        }

        public void a(LifecycleOwner r10, Lifecycle.Event r11, Object r12) {
            int r13 = this.f3512a;     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            if (r13 != 0) goto L5;
            this.f3513b.invoke(r12, null);     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            return;
        L5:
            if (r13 != 1) goto L7;
            this.f3513b.invoke(r12, new Object[]{r10});     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            return;
        L7:
            if (r13 != 2) goto L22;
            this.f3513b.invoke(r12, new Object[]{r10, r11});     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            return;
        L22:
            return;
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L12:
            e = move-exception;
            throw new RuntimeException("Failed to call observer method", e.getCause());
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f3512a != r11.f3512a) goto L14;
            if (this.f3513b.getName().equals(r11.f3513b.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (this.f3512a * 31) + this.f3513b.getName().hashCode();
        }
    }

    static {
        f3507c = new c();
    }

    public c() {
        this.f3508a = new HashMap();
        this.f3509b = new HashMap();
    }

    public final a a(Class r12, Method[] r13) {
        Class r10 = r12.getSuperclass();
        HashMap r11 = new HashMap();
        if (r10 == null) goto L7;
        a r14 = c(r10);
        if (r14 == null) goto L7;
        r11.putAll(r14.f3511b);
    L7:
        Class<?>[] r15 = r12.getInterfaces();
        int r16 = r15.length;
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L14;
        Iterator r18 = c(r15[r17]).f3511b.entrySet().iterator();
    L11:
        if (r18.hasNext() == false) goto L13;
        Map.Entry r19 = (Map.Entry) r18.next();
        e(r11, (b) r19.getKey(), (Lifecycle.Event) r19.getValue(), r12);
        goto L11
    L13:
        r17 = r17 + 1;
        goto L8
    L14:
        if (r13 != null) goto L17;
        r13 = b(r12);
    L17:
        int r20 = r13.length;
        int r21 = 0;
        boolean r22 = false;
    L18:
        if (r21 >= r20) goto L47;
        Method r23 = r13[r21];
        OnLifecycleEvent r24 = (OnLifecycleEvent) r23.getAnnotation(OnLifecycleEvent.class);
        if (r24 == null) goto L44;
        Class<?>[] r25 = r23.getParameterTypes();
        if (r25.length > 0) goto L25;
        int r26 = 0;
    L30:
        Lifecycle.Event r27 = r24.value();
        if (r25.length <= 1) goto L42;
        if (Lifecycle.Event.class.isAssignableFrom(r25[1]) == false) goto L40;
        if (r27 != Lifecycle.Event.ON_ANY) goto L38;
        r26 = 2;
        goto L42
    L38:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L40:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L42:
        if (r25.length > 2) goto L46;
        e(r11, new b(r26, r23), r27, r12);
        r22 = true;
        goto L44
    L46:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L25:
        if (LifecycleOwner.class.isAssignableFrom(r25[0]) == false) goto L28;
        r26 = 1;
        goto L30
    L28:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L44:
        r21 = r21 + 1;
        goto L18
    L47:
        a r110 = new a(r11);
        this.f3508a.put(r12, r110);
        this.f3509b.put(r12, Boolean.valueOf(r22));
        return r110;
    }

    public final Method[] b(Class r10) {
        return r10.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    public a c(Class r10) {
        a r11 = (a) this.f3508a.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return a(r10, null);
    }

    public boolean d(Class r10) {
        Boolean r11 = (Boolean) this.f3509b.get(r10);
        if (r11 != null) goto L5;
        Method[] r12 = b(r10);
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L13;
        if (((OnLifecycleEvent) r12[r14].getAnnotation(OnLifecycleEvent.class)) != null) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        a(r10, r12);
        return true;
    L13:
        this.f3509b.put(r10, Boolean.FALSE);
        return false;
    L5:
        return r11.booleanValue();
    }

    public final void e(Map r10, b r11, Lifecycle.Event r12, Class r13) {
        Lifecycle.Event r14 = (Lifecycle.Event) r10.get(r11);
        if (r14 == null) goto L8;
        if (r12 == r14) goto L8;
        throw new IllegalArgumentException("Method " + r11.f3513b.getName() + " in " + r13.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r14 + ", new value " + r12);
    L8:
        if (r14 != null) goto L11;
        r10.put(r11, r12);
        return;
    }
}
