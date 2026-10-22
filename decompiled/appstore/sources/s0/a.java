package s0;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Method a(Class r10, String r11, Class[] r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (u0.a.b(r11) == true) goto L19;
        r0.a.c("ReflectUtils", "thread id : " + Thread.currentThread().getName());     // Catch: Throwable -> L9
        return r10.getMethod(r11, r12);
    L9:
        th = move-exception;
        r0.a.g("ReflectUtils", "exception in getMethod, pkg : " + r10.getName() + ", function : " + r11 + ", " + th.toString());
        return r10.getDeclaredMethod(r11, r12);
    L21:
        return null;
    L19:
        return null;
    }

    public static Object b(Class r10, String r11, Class[] r12, Object[] r13, Object... r14) {
        if (r10 != null) goto L5;
    L26:
        return null;
    L5:
        if (u0.a.b(r11) == true) goto L26;
        if (r12 != null) goto L10;
        r12 = new Class[0];
    L10:
        if (r13 != null) goto L27;
        r13 = new Object[0];
    L27:
        Method r15 = a(r10, r11, r12);     // Catch: Throwable -> L21
        if (r15 != null) goto L15;
        return null;
    L15:
        r15.setAccessible(true);     // Catch: Throwable -> L21
        if (r14 == null) goto L24;
        if (r14.length <= 0) goto L24;
        return r15.invoke(r14[0], r13);
    L24:
        return r15.invoke(null, r13);
    L21:
        th = move-exception;
        r0.a.g("ReflectUtils", "exception in invokeMethod, pkg : " + r10.getName() + ", function : " + r11 + ", " + th.toString());
        goto L26
    }

    public static Object c(Class r10, String r11, Object... r12) {
        return b(r10, r11, null, null, r12);
    }
}
