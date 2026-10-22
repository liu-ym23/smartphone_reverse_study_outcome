package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = null;

    static {
        NO_ARGS = new Object[0];
    }

    public AbstractInvocationHandler() {
    }

    private static boolean isProxyOfSameInterfaces(Object r10, Class<?> r11) {
        if (r11.isInstance(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (Proxy.isProxyClass(r10.getClass()) == true) goto L7;
    L9:
        return false;
    L7:
        if (Arrays.equals(r10.getClass().getInterfaces(), r11.getInterfaces()) == false) goto L9;
        goto L9
    }

    public boolean equals(Object r10) {
        return super.equals(r10);
    }

    public abstract Object handleInvocation(Object r10, Method r11, Object[] r12) throws Throwable;

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r10, Method r11, @NullableDecl Object[] r12) throws Throwable {
        if (r12 != null) goto L5;
        r12 = NO_ARGS;
    L5:
        if (r12.length == 0) goto L7;
    L10:
        boolean r13 = true;
        if (r12.length != 1) goto L32;
        if (r11.getName().equals("equals") == false) goto L32;
        if (r11.getParameterTypes()[0] != Object.class) goto L32;
        Object r14 = r12[0];
        if (r14 == null) goto L19;
        if (r10 != r14) goto L24;
        return Boolean.TRUE;
    L24:
        if (isProxyOfSameInterfaces(r14, r10.getClass()) == true) goto L26;
    L28:
        r13 = false;
    L30:
        return Boolean.valueOf(r13);
    L26:
        if (equals(Proxy.getInvocationHandler(r14)) == false) goto L28;
    L19:
        return Boolean.FALSE;
    L32:
        if (r12.length != 0) goto L38;
        if (r11.getName().equals("toString") == false) goto L38;
        return toString();
    L38:
        return handleInvocation(r10, r11, r12);
    L7:
        if (r11.getName().equals("hashCode") == false) goto L10;
        return Integer.valueOf(hashCode());
    }

    public String toString() {
        return super.toString();
    }
}
