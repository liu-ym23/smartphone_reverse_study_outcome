package com.obric.aiagent.product.platform.api.notification;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.a.b;
import d.h.b.o;
import d.n;
import d.x;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: ObricToastShowListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricToastShowListenerKt {
    private static final String TOAST_SHOW_CALLBACK_METHOD = "onToastShow";

    public static /* synthetic */ Object lambda$K3ibLNNUJZs10L0uz1TbPJ67oHw(Class r0, b r1, Object r2, Method r3, Object[] r4) {
        return newObricToastShowListenerProxy$lambda$1(r0, r1, r2, r3, r4);
    }

    public static final Object newObricToastShowListenerProxy(final Class<?> r3, b<? super ToastShowInfo, x> r4) {
        final b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r3, "listenerClass");
        o.e(r5, "onToastShown");
        if (r3.isInterface() == false) goto L7;
        Object r6 = Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, new $$Lambda$ObricToastShowListenerKt$K3ibLNNUJZs10L0uz1TbPJ67oHw(r3, r5));
        o.c(r6, "newProxyInstance(...)");
        return r6;
    L7:
        throw new IllegalArgumentException(("Toast listener must be an interface: " + r3.getName()).toString());
    }

    private static final Object newObricToastShowListenerProxy$lambda$1(Class r5, b r6, Object r7, Method r8, Object[] r9) {
        b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (o.a(r8.getDeclaringClass(), Object.class) == false) goto L33;
        String r11 = r8.getName();
        if (r11 == null) goto L31;
        int r0 = r11.hashCode();
        if (r0 == (-1776922004)) goto L28;
        if (r0 == (-1295482945)) goto L18;
        if (r0 != 147696667) goto L31;
        if (r11.equals("hashCode") == false) goto L31;
        return Integer.valueOf(System.identityHashCode(r7));
    L18:
        if (r11.equals("equals") == false) goto L31;
        if (r9 == null) goto L22;
        Object r12 = i.b(r9, 0);
    L23:
        if (r7 == r12) goto L46;
        r2 = false;
    L46:
        return Boolean.valueOf(r2);
    L22:
        r12 = null;
        goto L23
    L28:
        if (r11.equals("toString") == false) goto L31;
        return "ObricToastShowListenerProxy(" + r5.getName() + ')';
    L31:
        Class<?> r13 = r8.getReturnType();
        o.c(r13, "getReturnType(...)");
        return defaultValueFor(r13);
    L33:
        if (o.a(r8.getName(), TOAST_SHOW_CALLBACK_METHOD) == true) goto L35;
    L43:
        Class<?> r14 = r8.getReturnType();
        o.c(r14, "getReturnType(...)");
        return defaultValueFor(r14);
    L35:
        if (r8.getParameterTypes().length != 1) goto L43;
        if (r9 != null) goto L38;
    L40:
        r2 = false;
    L41:
        if (r2 == false) goto L43;
        r10.invoke(toToastShowInfo(r9[0]));
        Class<?> r15 = r8.getReturnType();
        o.c(r15, "getReturnType(...)");
        return defaultValueFor(r15);
    L38:
        if (r9.length != 1) goto L40;
        goto L40
    }

    private static final Object defaultValueFor(Class<?> r2) {
        if (o.a(r2, Boolean.TYPE) == false) goto L6;
        return false;
    L6:
        if (o.a(r2, Byte.TYPE) == false) goto L9;
        return (byte) 0;
    L9:
        if (o.a(r2, Short.TYPE) == false) goto L12;
        return (short) 0;
    L12:
        if (o.a(r2, Integer.TYPE) == false) goto L15;
        return 0;
    L15:
        if (o.a(r2, Long.TYPE) == false) goto L18;
        return 0L;
    L18:
        if (o.a(r2, Float.TYPE) == false) goto L21;
        return Float.valueOf(0.0f);
    L21:
        if (o.a(r2, Double.TYPE) == false) goto L24;
        return Double.valueOf(0.0d);
    L24:
        if (o.a(r2, Character.TYPE) == true) goto L35;
        return null;
    L35:
        return (char) 0;
    }

    private static final ToastShowInfo toToastShowInfo(Object r8) {
        Object r0 = readProperty(r8, "type");
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.toString();
    L6:
        Object r9 = readProperty(r8, "content");
        if (r9 == null) goto L9;
        r1 = r9.toString();
    L9:
        if (r1 != null) goto L11;
        String r10 = "";
    L13:
        return new ToastShowInfo(r2, r10, 0, 4, null);
    L11:
        r10 = r1;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    private static final Object readProperty(Object r6, String r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        StringBuilder r1 = new StringBuilder().append(MonitorConstants.CONNECT_TYPE_GET);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        char r3 = Character.toUpperCase(r7.charAt(0));
        String r4 = r7.substring(1);
        o.c(r4, "this as java.lang.String).substring(startIndex)");
        String r5 = r3 + r4;
    L12:
        String r8 = r1.append(r5).toString();
        n.a r9 = n.f38560a;     // Catch: Throwable -> L15
        Object r10 = n.f(r6.getClass().getField(r7).get(r6));     // Catch: Throwable -> L15
    L18:
        if (n.c(r10) == null) goto L26;
        n.a r11 = n.f38560a;     // Catch: Throwable -> L22
        Object r12 = n.f(r6.getClass().getMethod(r8, new Class[0]).invoke(r6, new Object[0]));     // Catch: Throwable -> L22
    L24:
        r10 = r12;
    L22:
        th = move-exception;
        n.a r13 = n.f38560a;
        r12 = n.f(d.o.a(th));
    L26:
        if (n.b(r10) == false) goto L29;
        return null;
    L29:
        return r10;
    L15:
        th = move-exception;
        n.a r14 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L18
    L11:
        r5 = r7;
        goto L12
    L8:
        r2 = false;
        goto L9
    }
}
