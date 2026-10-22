package com.bytedance.platform.godzilla.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ProxyHelper {
    private ProxyHelper() {
    }

    public static Object createProxy(Object r2, InvocationHandler r3) {
        List<Class<?>> r0 = getAllInterfaces(r2.getClass());
        if (r0 != null) goto L5;
    L7:
        Class[] r1 = new Class[0];
    L9:
        return Proxy.newProxyInstance(r2.getClass().getClassLoader(), r1, r3);
    L5:
        if (r0.size() <= 0) goto L7;
        r1 = (Class[]) r0.toArray(new Class[r0.size()]);
        goto L9
    }

    private static List<Class<?>> getAllInterfaces(Class<?> r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        LinkedHashSet r0 = new LinkedHashSet();
        getAllInterfaces(r1, r0);
        return new ArrayList(r0);
    }

    private static void getAllInterfaces(Class<?> r5, HashSet<Class<?>> r6) {
    L2:
        if (r5 == null) goto L10;
        Class<?>[] r0 = r5.getInterfaces();
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        Class<?> r3 = r0[r2];
        if (r6.add(r3) == false) goto L8;
        getAllInterfaces(r3, r6);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        r5 = r5.getSuperclass();
        goto L2
    }
}
