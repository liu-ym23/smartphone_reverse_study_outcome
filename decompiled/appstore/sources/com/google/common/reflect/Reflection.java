package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Reflection {
    private Reflection() {
    }

    public static String getPackageName(Class<?> r10) {
        return getPackageName(r10.getName());
    }

    public static void initialize(Class<?>... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        Class<?> r13 = r10[r12];
        Class.forName(r13.getName(), true, r13.getClassLoader());     // Catch: ClassNotFoundException -> L7
        r12 = r12 + 1;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static <T> T newProxy(Class<T> r10, InvocationHandler r11) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkArgument(r10.isInterface(), "%s is not an interface", r10);
        return r10.cast(Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, r11));
    }

    public static String getPackageName(String r10) {
        int r11 = r10.lastIndexOf(46);
        if (r11 >= 0) goto L6;
        return "";
    L6:
        return r10.substring(0, r11);
    }
}
