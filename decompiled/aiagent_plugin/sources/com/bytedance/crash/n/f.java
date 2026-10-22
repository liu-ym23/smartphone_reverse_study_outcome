package com.bytedance.crash.n;

import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: JavaCalls.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f7624a = null;

    /* JADX INFO: compiled from: JavaCalls.java */
    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<? extends T> f7625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f7626b;
    }

    static {
        HashMap r0 = new HashMap();
        f7624a = r0;
        r0.put(Boolean.class, Boolean.TYPE);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        r0.put(Integer.class, Integer.TYPE);
        r0.put(Float.class, Float.TYPE);
        r0.put(Long.class, Long.TYPE);
        r0.put(Double.class, Double.TYPE);
        r0.put(Boolean.TYPE, Boolean.TYPE);
        r0.put(Byte.TYPE, Byte.TYPE);
        r0.put(Character.TYPE, Character.TYPE);
        r0.put(Short.TYPE, Short.TYPE);
        r0.put(Integer.TYPE, Integer.TYPE);
        r0.put(Float.TYPE, Float.TYPE);
        r0.put(Long.TYPE, Long.TYPE);
        r0.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T a(Object r2, String r3, Object... r4) {
        return (T) b(r2, r3, r4);
    L4:
        e = move-exception;
        r.a("JavaCalls", "Meet exception when call Method '" + r3 + "' in " + r2, e);
        return null;
    }

    private static <T> T b(Object r2, String r3, Object... r4) {
        return (T) a(r2.getClass(), r3, a(r4)).invoke(r2, b(r4));
    }

    private static Method a(Class<?> r1, String r2, Class<?>... r3) {
        Method r4 = r1.getDeclaredMethod(r2, r3);     // Catch: Throwable -> L8 NoSuchMethodException -> L10
        if (r4 == null) goto L7;
        r4.setAccessible(true);
        return r4;
    L7:
        throw new NoSuchMethodException();
    L11:
        if (r1.getSuperclass() == null) goto L15;
        return a(r1.getSuperclass(), r2, r3);
    L15:
        throw new NoSuchMethodException();
    L9:
        throw new NoSuchMethodException();
    }

    private static Class<?>[] a(Object... r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.length <= 0) goto L25;
        Class<?>[] r1 = new Class[r6.length];
        int r2 = 0;
    L8:
        if (r2 >= r6.length) goto L20;
        Object r3 = r6[r2];
        if (r3 != null) goto L12;
    L14:
        if (r3 != null) goto L16;
        Class<?> r4 = null;
    L17:
        r1[r2] = r4;
    L18:
        r2 = r2 + 1;
        goto L8
    L16:
        r4 = r3.getClass();
        goto L17
    L12:
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L14;
        r1[r2] = ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")).f7625a;
        goto L18
    L20:
        return r1;
    L25:
        return null;
    }

    private static Object[] b(Object... r5) {
        if (r5 != null) goto L4;
    L15:
        return null;
    L4:
        if (r5.length <= 0) goto L15;
        Object[] r0 = new Object[r5.length];
        int r1 = 0;
    L7:
        if (r1 >= r5.length) goto L20;
        Object r2 = r5[r1];
        if (r2 != null) goto L11;
    L13:
        r0[r1] = r2;
    L14:
        r1 = r1 + 1;
        goto L7
    L11:
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L13;
        r0[r1] = ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).f7626b;
        goto L14
    L20:
        return r0;
    }
}
