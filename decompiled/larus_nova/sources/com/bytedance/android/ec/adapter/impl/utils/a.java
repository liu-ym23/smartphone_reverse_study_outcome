package com.bytedance.android.ec.adapter.impl.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Field> f42792a = null;

    static {
        f42792a = new HashMap();
    }

    public static Object a(Object r100) throws IllegalAccessException {
        Class<?> r101 = r100.getClass();
        String r102 = r101.toString() + "#mTargetActivity";
        Map<String, Field> r103 = f42792a;
        monitor-enter(r103);
        Field r104 = (Field) ((HashMap) r103).get(r102);     // Catch: Throwable -> L31
        monitor-exit(r103);     // Catch: Throwable -> L31
        if (r104 != null) goto L9;
    L11:
        if (r101 == null) goto L24;
        r104 = r101.getDeclaredField("mTargetActivity");     // Catch: NoSuchFieldException -> L23
        if (r104.isAccessible() == true) goto L15;
        r104.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L15:
        Map<String, Field> r105 = f42792a;     // Catch: NoSuchFieldException -> L23
        monitor-enter(r105);     // Catch: NoSuchFieldException -> L23
        ((HashMap) r105).put(r102, r104);     // Catch: Throwable -> L20
        monitor-exit(r105);     // Catch: Throwable -> L20
    L25:
        if (r104 != null) goto L27;
        return null;
    L27:
        if (r104.isAccessible() == true) goto L30;
        r104.setAccessible(true);
    L30:
        return r104.get(r100);
    L20:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L23
    L23:
        r101 = r101.getSuperclass();
        goto L11
    L24:
        r104 = null;
        goto L25
    L9:
        if (r104.isAccessible() == true) goto L25;
        r104.setAccessible(true);
    L31:
        th = move-exception;
        throw th;
    }
}
