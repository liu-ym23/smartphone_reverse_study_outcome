package com.obric.performance.power.monitor.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DoubleReflectHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f37019a = null;

    public static Field a(Class<?> r6, String r7) {
        Field r8 = (Field) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7}), Field.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method a(Class<?> r7, String r8, Class<?>... r9) {
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9}), Method.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    static {
        f37019a = new HashMap();
    }
}
