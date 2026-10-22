package com.bytedance.reparo.core;

import android.os.Build;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ClassModifier.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f9142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f9143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f9144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9145d;

    /* JADX INFO: renamed from: com.bytedance.reparo.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassModifier.java */
    public static class C0210a extends Exception {
        public C0210a() {
        }
    }

    static {
        Field r1 = Class.class.getDeclaredField("classLoader");     // Catch: Exception -> L5
        f9142a = r1;     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Field r2 = Class.class.getDeclaredField("accessFlags");     // Catch: Exception -> L5
        f9143b = r2;     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        Field r3 = Class.class.getDeclaredField("status");     // Catch: Exception -> L5
        f9144c = r3;     // Catch: Exception -> L5
        r3.setAccessible(true);     // Catch: Exception -> L5
        ZeusTransformUtils.forName("com.bytedance.reparo.core.WandTrick", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        f9145d = ((Integer) ZeusTransformUtils.preCheckCast(f9144c.get(WandTrick.class), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Class r1, ClassLoader r2) {
        monitor-enter(r1);
        f9142a.set(r1, r2);     // Catch: Throwable -> L6
        monitor-exit(r1);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void a(Class r3) {
        b(r3.getSuperclass());
        Class<?>[] r4 = r3.getInterfaces();
        if (r4 == null) goto L7;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        b(r4[r1]);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public static void b(Class r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(f9143b.get(r3), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if ((r0 & 1) != 0) goto L14;
        int r1 = (r0 & (-8)) | 1;
        monitor-enter(r3);
        f9143b.set(r3, Integer.valueOf(r1));     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void a(Class r6, boolean r7) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return;
    L5:
        int r0 = f9145d;
        int r1 = 0;
        if (r7 == false) goto L8;
        int r2 = 0;
    L13:
        monitor-enter(r6);
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(f9144c.get(r6), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L25
        if (r7 == true) goto L21;
        if (r3 == r1) goto L20;
        if (r3 != r2) goto L21;
    L20:
        throw new C0210a();     // Catch: Throwable -> L25
    L21:
        if (r0 <= r3) goto L23;
        f9144c.set(r6, Integer.valueOf(r0));     // Catch: Throwable -> L25
        f(r6);     // Catch: Throwable -> L25
        com.bytedance.reparo.core.f.a.b("status bumped to " + r0 + ", class: " + r6.getName());     // Catch: Throwable -> L25
    L23:
        monitor-exit(r6);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L8:
        if (Build.VERSION.SDK_INT != 27) goto L10;
        r0 = r0 - 3;
    L11:
        r1 = r0 - 3;
        r2 = r0 - 1;
        goto L13
    L10:
        r0 = r0 - 2;
        goto L11
    }

    public static void c(Class<?> r4) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return;
    L5:
        Field[] r5 = com.bytedance.reparo.core.i.j.b(r4);
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Field r2 = r5[r1];
        WandTrick.b().changeFieldToPublic(r2);
        r1 = r1 + 1;
        goto L6
    }

    public static void d(Class<?> r4) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return;
    L5:
        Constructor<?>[] r5 = r4.getDeclaredConstructors();
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Constructor<?> r2 = r5[r1];
        WandTrick.b().changeConstructorToPublic(r2);
        r1 = r1 + 1;
        goto L6
    }

    public static void e(Class<?> r4) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return;
    L5:
        Method[] r5 = (Method[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r4).a(), Method[].class, "com.obric.aiagent.plugin");
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Method r2 = r5[r1];
        WandTrick.b().changeMethodProtectedToPublic(r2);
        r1 = r1 + 1;
        goto L6
    }

    private static void f(Class r8) {
        int r0 = f9143b.getInt(r8);
        if ((r0 & UiType.FLAG_WIFI_QRCODE_CARD) != 0) goto L14;
        WandTrick.b().changeClinitToPreverified(r8);
        Method[] r2 = (Method[]) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.j.a(r8).a(), Method[].class, "com.obric.aiagent.plugin");
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        WandTrick.b().changeMethodToPreverified(r2[r5]);
        r5 = r5 + 1;
        goto L5
    L7:
        Constructor<?>[] r6 = r8.getDeclaredConstructors();
        int r7 = r6.length;
    L8:
        if (r4 >= r7) goto L10;
        WandTrick.b().changeMethodToPreverified(r6[r4]);
        r4 = r4 + 1;
        goto L8
    L10:
        f9143b.set(r8, Integer.valueOf(r0 | UiType.FLAG_WIFI_QRCODE_CARD));
        com.bytedance.reparo.core.f.a.a("ensurePreverifiedMethods:" + r8.getName());
        return;
    }
}
