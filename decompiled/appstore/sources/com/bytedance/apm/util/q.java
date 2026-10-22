package com.bytedance.apm.util;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static Object[] a(Object r10, String r11, boolean r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r13 = r11.split("[.]");
        Class<?> r14 = r10.getClass();
        Object[] r15 = new Object[2];
        int r16 = r13.length;
        int r17 = 0;
        int r18 = 0;
    L6:
        if (r17 >= r16) goto L18;
        String r19 = r13[r17];
        r18 = r18 + 1;
        Field r20 = b(r14, r19, r12);
        if (r20 == null) goto L17;
        r20.setAccessible(true);
        r15[0] = r20;
        r15[1] = r10;
        r10 = r20.get(r10);
        if (r10 == null) goto L12;
        r14 = r10.getClass();
        goto L17
    L12:
        if (r18 >= r13.length) goto L18;
        throw new IllegalAccessException("can not getFieldValue as field '" + r19 + "' value is null in '" + r14.getName() + "'");
    L17:
        r17 = r17 + 1;
    L18:
        return r15;
    }

    public static Field b(Class r10, String r11, boolean r12) {
        NoSuchFieldException e10 = null;
        Field r13 = r10.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L9
        if (r12 == false) goto L27;
    L11:
        if (e10 == null) goto L24;
        if (r12 == false) goto L23;
    L13:
        r10 = r10.getSuperclass();
        if (r10 == null) goto L24;
        Field r14 = r10.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L18
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L18
        return r14;
    L18:
        e = move-exception;
        if (r10.getSuperclass() != null) goto L13;
        throw e;
    L23:
        throw e10;
    L24:
        return r13;
    L27:
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        return r13;
    L7:
        e10 = e;
    L9:
        e = move-exception;
        r13 = null;
        e10 = e;
        goto L11
    }

    public static void c(Object r10, String r11, Object r12) {
        d(r10, r11, r12, true);
    }

    public static void d(Object r10, String r11, Object r12, boolean r13) {
        Object[] r14 = a(r10, r11, r13);
        if (r14 == null) goto L7;
        ((Field) r14[0]).set(r14[1], r12);
        return;
    L7:
        throw new NoSuchFieldException("field:" + r11);
    }
}
