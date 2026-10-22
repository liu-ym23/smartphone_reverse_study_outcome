package com.bytedance.monitor.util.unsafe;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectUtils {
    private static ReflectUtils sInstance;

    private ReflectUtils() {
    }

    public static ReflectUtils getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new ReflectUtils();
    L6:
        return sInstance;
    }

    public Method getMethod(Class<?> r1, String r2, Class<?>... r3) {
        if (r3 == null) goto L4;
        Method r0 = r1.getDeclaredMethod(r2, r3);     // Catch: NoSuchMethodException -> L6
    L9:
        return r0;
    L4:
        r0 = r1.getDeclaredMethod(r2, new Class[0]);     // Catch: NoSuchMethodException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public Object invokeStaticMethod(Method r2, Object... r3) {
        return invokeMethod(r2, null, r3);
    }

    public Object invokeMethod(Method r1, Object r2, Object... r3) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.invoke(r2, r3);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public Object getUnsafe(Class<?> r4) {
        return invokeStaticMethod(getMethod(r4, "getUnsafe", new Class[0]), new Object[0]);
    }
}
