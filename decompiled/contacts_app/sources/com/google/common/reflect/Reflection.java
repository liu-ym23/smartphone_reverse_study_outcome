package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class Reflection {
    public static String getPackageName(Class<?> r0) {
        return getPackageName(r0.getName());
    }

    public static String getPackageName(String r2) {
        int r0 = r2.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return "";
    L6:
        return r2.substring(0, r0);
    }

    public static void initialize(Class<?>... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Class<?> r2 = r5[r1];
        Class.forName(r2.getName(), true, r2.getClassLoader());     // Catch: ClassNotFoundException -> L7
        r1 = r1 + 1;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static <T> T newProxy(Class<T> r5, InvocationHandler r6) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkArgument(r5.isInterface(), "%s is not an interface", new Object[]{r5});
        return r5.cast(Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, r6));
    }

    private Reflection() {
    }
}
