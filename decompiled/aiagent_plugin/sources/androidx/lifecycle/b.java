package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassesInfoCache.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static b f2038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, a> f2039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f2040c;

    /* JADX INFO: compiled from: ClassesInfoCache.java */
    @Deprecated
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<i.a, List<C0061b>> f2041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<C0061b, i.a> f2042b;

        a(Map<C0061b, i.a> r6) {
            Map<C0061b, i.a> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            this.f2042b = r7;
            this.f2041a = new HashMap();
            Iterator<Map.Entry<C0061b, i.a>> r8 = r7.entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            i.a r2 = (i.a) ZeusTransformUtils.preCheckCast(r0.getValue(), i.a.class, "com.obric.aiagent.plugin");
            List<C0061b> r3 = (List) ZeusTransformUtils.preCheckCast(this.f2041a.get(r2), List.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L8;
            r3 = new ArrayList();
            this.f2041a.put(r2, r3);
        L8:
            r3.add((C0061b) ZeusTransformUtils.preCheckCast(r0.getKey(), C0061b.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        void a(p r4, i.a r5, Object r6) {
            p r7 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
            a((List) ZeusTransformUtils.preCheckCast(this.f2041a.get(r5), List.class, "com.obric.aiagent.plugin"), r7, r5, r6);
            a((List) ZeusTransformUtils.preCheckCast(this.f2041a.get(i.a.ON_ANY), List.class, "com.obric.aiagent.plugin"), r7, r5, r6);
        }

        private static void a(List<C0061b> r4, p r5, i.a r6, Object r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L7;
            int r0 = r8.size() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((C0061b) ZeusTransformUtils.preCheckCast(r8.get(r0), C0061b.class, "com.obric.aiagent.plugin")).a(r9, r6, r7);
            r0 = r0 - 1;
            goto L5
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    @Deprecated
    static final class C0061b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f2044b;

        C0061b(int r1, Method r2) {
            this.f2043a = r1;
            this.f2044b = r2;
            r2.setAccessible(true);
        }

        void a(p r5, i.a r6, Object r7) {
            p r8 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
            int r0 = this.f2043a;     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            if (r0 != 0) goto L6;
            this.f2044b.invoke(r7, new Object[0]);     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            return;
        L6:
            if (r0 != 1) goto L8;
            this.f2044b.invoke(r7, new Object[]{r8});     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            return;
        L8:
            if (r0 != 2) goto L21;
            this.f2044b.invoke(r7, new Object[]{r8, r6});     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            return;
        L21:
            return;
        L14:
            e = move-exception;
            throw new RuntimeException(e);
        L17:
            e = move-exception;
            throw new RuntimeException("Failed to call observer method", e.getCause());
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0061b.class) == true) goto L8;
            return false;
        L8:
            C0061b r6 = (C0061b) ZeusTransformUtils.preCheckCast(r5, C0061b.class, "com.obric.aiagent.plugin");
            if (this.f2043a != r6.f2043a) goto L14;
            if (this.f2044b.getName().equals(r6.f2044b.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (this.f2043a * 31) + this.f2044b.getName().hashCode();
        }
    }

    b() {
        this.f2039b = new HashMap();
        this.f2040c = new HashMap();
    }

    static {
        f2038a = new b();
    }

    boolean a(Class<?> r8) {
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(this.f2040c.get(r8), Boolean.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        Method[] r1 = c(r8);
        int r2 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L13;
        if (((x) ZeusTransformUtils.preCheckCast(r1[r4].getAnnotation(x.class), x.class, "com.obric.aiagent.plugin")) != null) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        a(r8, r1);
        return true;
    L13:
        this.f2040c.put(r8, false);
        return false;
    L5:
        return r0.booleanValue();
    }

    private Method[] c(Class<?> r2) {
        return r2.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    a b(Class<?> r4) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f2039b.get(r4), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return a(r4, null);
    }

    private void a(Map<C0061b, i.a> r3, C0061b r4, i.a r5, Class<?> r6) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        i.a r7 = (i.a) ZeusTransformUtils.preCheckCast(r2.get(r4), i.a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L8;
        if (r5 == r7) goto L8;
        throw new IllegalArgumentException("Method " + r4.f2044b.getName() + " in " + r6.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r7 + ", new value " + r5);
    L8:
        if (r7 != null) goto L11;
        r2.put(r4, r5);
        return;
    }

    private a a(Class<?> r13, Method[] r14) {
        Class<? super Object> r0 = r13.getSuperclass();
        HashMap r1 = new HashMap();
        if (r0 == null) goto L7;
        a r2 = b(r0);
        if (r2 == null) goto L7;
        r1.putAll(r2.f2042b);
    L7:
        Class<?>[] r3 = r13.getInterfaces();
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L15;
        Iterator<Map.Entry<C0061b, i.a>> r6 = b(r3[r5]).f2042b.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        a(r1, (C0061b) ZeusTransformUtils.preCheckCast(r7.getKey(), C0061b.class, "com.obric.aiagent.plugin"), (i.a) ZeusTransformUtils.preCheckCast(r7.getValue(), i.a.class, "com.obric.aiagent.plugin"), r13);
        goto L12
    L14:
        r5 = r5 + 1;
        goto L9
    L15:
        if (r14 != null) goto L18;
        r14 = c(r13);
    L18:
        int r8 = r14.length;
        int r9 = 0;
        boolean r10 = false;
    L19:
        if (r9 >= r8) goto L48;
        Method r11 = r14[r9];
        x r12 = (x) ZeusTransformUtils.preCheckCast(r11.getAnnotation(x.class), x.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L45;
        Class<?>[] r15 = r11.getParameterTypes();
        if (r15.length > 0) goto L26;
        int r16 = 0;
    L31:
        i.a r17 = r12.a();
        if (r15.length <= 1) goto L43;
        if (i.a.class.isAssignableFrom(r15[1]) == false) goto L41;
        if (r17 != i.a.ON_ANY) goto L39;
        r16 = 2;
        goto L43
    L39:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L41:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L43:
        if (r15.length > 2) goto L47;
        a(r1, new C0061b(r16, r11), r17, r13);
        r10 = true;
        goto L45
    L47:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L26:
        if (p.class.isAssignableFrom(r15[0]) == false) goto L29;
        r16 = 1;
        goto L31
    L29:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L45:
        r9 = r9 + 1;
        goto L19
    L48:
        a r18 = new a(r1);
        this.f2039b.put(r13, r18);
        this.f2040c.put(r13, Boolean.valueOf(r10));
        return r18;
    }
}
