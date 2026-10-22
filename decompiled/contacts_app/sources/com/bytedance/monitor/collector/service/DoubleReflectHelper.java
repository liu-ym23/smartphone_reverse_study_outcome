package com.bytedance.monitor.collector.service;

import com.bytedance.monitor.util.FieldUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubleReflectHelper {
    public static boolean isAndroidPHigher() {
        return true;
    }

    private DoubleReflectHelper() {
    }

    public static Field getFieldInner(Class<?> r6, String r7) {
        Field r8 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7});     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethodInner(Class<?> r7, String r8, Class<?>... r9) throws NoSuchMethodException {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Object readField(Object r1, String r2) {
        return getField(r1.getClass(), r2).get(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Field getField(Class<?> r1, String r2) {
        if (isAndroidPHigher() == false) goto L9;
        return getFieldInner(r1, r2);
    L6:
        return null;
    L9:
        return FieldUtils.getField(r1, r2);
    }
}
