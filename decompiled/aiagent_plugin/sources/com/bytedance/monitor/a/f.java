package com.bytedance.monitor.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MethodUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Method> f8919a;

    static {
        f8919a = new HashMap();
    }

    private static Method a(Class<?> r2, String r3, Class<?>... r4) {
        Class<? super Object> r5 = r2.getSuperclass();
    L4:
        if (r5 == null) goto L11;
        if (Modifier.isPublic(r5.getModifiers()) == true) goto L12;
        r5 = r5.getSuperclass();
        goto L4
    L12:
        return r5.getMethod(r3, r4);
    L9:
        return null;
    L11:
        return null;
    }

    private static String b(Class<?> r3, String r4, Class<?>... r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.toString());
        r0.append("#");
        r0.append(r4);
        if (r5 != null) goto L5;
    L9:
        r0.append(Void.class.toString());
    L11:
        return r0.toString();
    L5:
        if (r5.length <= 0) goto L9;
        int r6 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r6) goto L11;
        r0.append(r5[r1].toString()).append("#");
        r1 = r1 + 1;
        goto L7
    }

    private static Method c(Class<?> r3, String r4, Class<?>... r5) {
    L2:
        if (r3 == null) goto L16;
        Class<?>[] r0 = r3.getInterfaces();
        int r1 = 0;
    L5:
        if (r1 >= r0.length) goto L15;
        if (Modifier.isPublic(r0[r1].getModifiers()) == false) goto L14;
        return r0[r1].getDeclaredMethod(r4, r5);
    L11:
        Method r2 = c(r0[r1], r4, r5);
        if (r2 == null) goto L14;
        return r2;
    L14:
        r1 = r1 + 1;
        goto L5
    L15:
        r3 = r3.getSuperclass();
        goto L2
    L16:
        return null;
    }

    private static Method a(Method r3) {
        if (e.a(r3) == true) goto L6;
        return null;
    L6:
        Class<?> r0 = r3.getDeclaringClass();
        if (Modifier.isPublic(r0.getModifiers()) == false) goto L9;
        return r3;
    L9:
        String r1 = r3.getName();
        Class<?>[] r4 = r3.getParameterTypes();
        Method r2 = c(r0, r1, r4);
        if (r2 == null) goto L12;
        return r2;
    L12:
        return a(r0, r1, r4);
    }

    private static Method a(String r3) {
        Map<String, Method> r0 = f8919a;
        monitor-enter(r0);
        Method r4 = (Method) ZeusTransformUtils.preCheckCast(f8919a.get(r3), Method.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.isAccessible() == true) goto L10;
        r4.setAccessible(true);
    L10:
        return r4;
    L13:
        th = move-exception;
        throw th;
    }

    private static Method d(Class<?> r4, String r5, Class<?>... r6) {
        String r0 = b(r4, r5, r6);
        Method r1 = a(r0);
        if (r1 == null) goto L15;
        return r1;
    L15:
        Method r2 = r4.getMethod(r5, r6);     // Catch: NoSuchMethodException -> L13
        e.a(r2);     // Catch: NoSuchMethodException -> L13
        Map<String, Method> r3 = f8919a;     // Catch: NoSuchMethodException -> L13
        monitor-enter(r3);     // Catch: NoSuchMethodException -> L13
        f8919a.put(r0, r2);     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;     // Catch: NoSuchMethodException -> L13
    L14:
        return a(r4, r0, r5, r6);
    }

    private static Method a(Class<?> r6, String r7, String r8, Class<?>... r9) {
        Method[] r10 = r6.getMethods();
        int r0 = r10.length;
        Method r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        Method r3 = r10[r2];
        if (r3.getName().equals(r8) == false) goto L14;
        if (e.a(r9, r3.getParameterTypes(), true) == false) goto L14;
        Method r4 = a(r3);
        if (r4 == null) goto L14;
        if (r1 != null) goto L12;
    L13:
        r1 = r4;
        goto L14
    L12:
        if (e.a(r4.getParameterTypes(), r1.getParameterTypes(), r9) < 0) goto L13;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        if (r1 == null) goto L17;
        e.a(r1);
    L17:
        Map<String, Method> r11 = f8919a;
        monitor-enter(r11);
        f8919a.put(r7, r1);     // Catch: Throwable -> L22
        monitor-exit(r11);     // Catch: Throwable -> L22
        return r1;
    L22:
        th = move-exception;
        throw th;
    }

    public static Object a(Class r1, String r2, Object... r3) {
        return a(r1, r2, c.a(r3), c.b(r3));
    }

    public static Object a(Class r1, String r2, Object[] r3, Class<?>[] r4) {
        Method r5 = d(r1, r2, r4);
        if (r5 == null) goto L7;
        return r5.invoke(null, c.a(r3));
    L7:
        throw new NoSuchMethodException("No such accessible method: " + r2 + "() on object: " + r1.getName());
    }
}
