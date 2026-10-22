package com.bytedance.reparo.core.i;

import android.os.Build;
import com.bytedance.reparo.core.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: ReflectUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method[] f9288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.reparo.core.i.a.c f9289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Field[] f9290c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.bytedance.reparo.core.i.a.b f9291d;

    public static Field a(Object r0, String r1) {
        return a(r0.getClass(), r1);
    }

    public static Field a(Class r3, String r4) {
        Class r0 = r3;
    L3:
        if (r0 == null) goto L10;
        Field r1 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L8
        if (r1.isAccessible() == true) goto L7;
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r1;
    L8:
        r0 = r0.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r4 + " not found in " + r3);
    }

    public static Method a(Object r0, String r1, Class<?>... r2) {
        return a(r0.getClass(), r1, r2);
    }

    public static Method a(Class r3, String r4, Class<?>... r5) {
        Class r0 = r3;
    L3:
        if (r0 == null) goto L10;
        Method r1 = r0.getDeclaredMethod(r4, r5);     // Catch: NoSuchMethodException -> L8
        if (r1.isAccessible() == true) goto L7;
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r1;
    L8:
        r0 = r0.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Method " + r4 + " with parameters " + Arrays.asList(r5) + " not found in " + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method b(Class r7, String r8, Class<?>... r9) {
        Class[] r0 = new Class[r9.length + 1];
        System.arraycopy(r9, 0, r0, 1, r9.length);
        Class r2 = r7;
    L3:
        if (r2 == null) goto L17;
        Class r4 = l.c(r2.getName());
        if (r4 == 0) goto L19;
        com.bytedance.reparo.core.j.b("Reparo", "findPeerPatchClass " + r4.getName());
        r0[0] = r2;     // Catch: NoSuchMethodException -> L18
        Method r5 = r4.getDeclaredMethod(l.a(r2.getName(), r8), r0);     // Catch: NoSuchMethodException -> L18
        if (r5.isAccessible() == true) goto L10;
        r5.setAccessible(true);     // Catch: NoSuchMethodException -> L18
    L10:
        return r5;
    L19:
        Method r6 = r2.getDeclaredMethod(r8, r9);     // Catch: NoSuchMethodException -> L15
        if (r6.isAccessible() == true) goto L14;
        r6.setAccessible(true);     // Catch: NoSuchMethodException -> L15
    L14:
        return r6;
    L15:
        r2 = r2.getSuperclass();
        goto L3
    L17:
        throw new NoSuchMethodException("Method " + r8 + " with parameters " + Arrays.asList(r9) + " not found in " + r7);
    }

    static {
        f9288a = new Method[0];
        f9290c = new Field[0];
    }

    public static com.bytedance.reparo.core.b.h<Method[], NoClassDefFoundError> a(Class r11) {
        Method[] r1 = f9288a;
        r1 = r11.getDeclaredMethods();     // Catch: Throwable -> L5 NoClassDefFoundError -> L7
    L28:
        return new com.bytedance.reparo.core.b.h(r1, null);
    L7:
        e = move-exception;
        Method[] r4 = c(r11);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        ArrayList r5 = new ArrayList(r4.length);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        int r6 = r4.length;     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L16;
        Method r8 = r4[r7];     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        r8.getReturnType();     // Catch: Throwable -> L13
        r8.getParameterTypes();     // Catch: Throwable -> L13
        r5.add(r8);     // Catch: Throwable -> L13
    L15:
        r7 = r7 + 1;     // Catch: Throwable -> L25 NoSuchMethodException -> L29
    L13:
        th = move-exception;
        com.bytedance.reparo.core.f.a.a("Error when getDeclaredMethods for " + r11, th);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        e.addSuppressed(th);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        goto L15
    L16:
        Method[] r2 = new Method[r5.size()];     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        r5.toArray(r2);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        if (Build.VERSION.SDK_INT == 26) goto L24;
        if (Build.VERSION.SDK_INT == 27) goto L24;
        return new com.bytedance.reparo.core.b.h(r2, null);
    L24:
        return new com.bytedance.reparo.core.b.h(r2, e);
    L25:
        th = move-exception;
        com.bytedance.reparo.core.f.a.b("Err when getDeclaredMethods for cls " + r11, th);
    L5:
        th = move-exception;
        com.bytedance.reparo.core.f.a.b("Err when getDeclaredMethods for cls " + r11, th);
        goto L28
    }

    private static Method[] c(Class r2) {
        if (f9289b != null) goto L6;
        f9289b = new com.bytedance.reparo.core.i.a.c();
    L6:
        return (Method[]) ZeusTransformUtils.preCheckCast(f9289b.a(r2, new Object[0]), Method[].class, "com.obric.aiagent.plugin");
    }

    public static Field[] b(Class r8) {
        Field[] r0 = f9290c;
        goto L6
    L30:
        return r8.getDeclaredFields();
    L7:
        Field[] r1 = d(r8);     // Catch: Throwable -> L17 NoSuchMethodException -> L21
        ArrayList r2 = new ArrayList(r1.length);     // Catch: Throwable -> L17 NoSuchMethodException -> L21
        int r3 = r1.length;     // Catch: Throwable -> L17 NoSuchMethodException -> L21
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L15;
        Field r5 = r1[r4];     // Catch: Throwable -> L17 NoSuchMethodException -> L21
        r5.getType();     // Catch: Throwable -> L12
        r2.add(r5);     // Catch: Throwable -> L12
    L14:
        r4 = r4 + 1;     // Catch: Throwable -> L17 NoSuchMethodException -> L21
    L12:
        th = move-exception;
        com.bytedance.reparo.core.f.a.a("Error when getDeclaredFields for " + r8, th);     // Catch: Throwable -> L17 NoSuchMethodException -> L21
        goto L14
    L15:
        r0 = new Field[r2.size()];     // Catch: Throwable -> L17 NoSuchMethodException -> L21
        return (Field[]) ZeusTransformUtils.preCheckCast(r2.toArray(r0), Field[].class, "com.obric.aiagent.plugin");
    L17:
        th = move-exception;
        com.bytedance.reparo.core.f.a.b("Err when getDeclaredFields for cls " + r8, th);
    L6:
        return f9290c;
    L20:
        return r0;
    }

    private static Field[] d(Class r2) {
        if (f9291d != null) goto L6;
        f9291d = new com.bytedance.reparo.core.i.a.b();
    L6:
        return (Field[]) ZeusTransformUtils.preCheckCast(f9291d.a(r2, new Object[0]), Field[].class, "com.obric.aiagent.plugin");
    }
}
