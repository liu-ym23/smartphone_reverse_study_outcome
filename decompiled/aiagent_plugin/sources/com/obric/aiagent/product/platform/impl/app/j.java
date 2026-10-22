package com.obric.aiagent.product.platform.impl.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetFramework.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f18820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f18821b = null;

    public static final d a() {
        return f18820a;
    }

    static {
        f18820a = new d("assistant", "android.app.AssistantActivityManager", "android.app.IAssistantAutoVirtualDisplayRecordSetListener", "com.obric.aiagent.product.platform.impl.app.AssistantAutoVirtualDisplayRecordSetOfficialApi");
        f18821b = new d("obric", "android.app.ObricActivityManager", "android.app.IObricAutoVirtualDisplayRecordSetListener", "com.obric.aiagent.product.platform.impl.app.ObricAutoVirtualDisplayRecordSetOfficialApi");
    }

    public static final d b() {
        return f18821b;
    }

    public static final boolean a(d r7, ClassLoader r8, d.h.a.b<? super Class<?>, x> r9, d.h.a.b<? super Throwable, x> r10) {
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "api");
        o.e(r11, "onResolved");
        o.e(r12, "onUnavailable");
        Class<?> r4 = Class.forName(r7.b(), false, r8);     // Catch: LinkageError -> L8 Exception -> L10
        Class<?> r5 = Class.forName(r7.c(), false, r8);     // Catch: LinkageError -> L8 Exception -> L10
        if (r5.isAssignableFrom(Class.forName(r7.c() + "$Stub", false, r8)) == false) goto L7;
        Method r13 = r4.getMethod("beginAutoVirtualDisplayRecordSet", new Class[]{Integer.TYPE, Integer.TYPE, r5});     // Catch: LinkageError -> L8 Exception -> L10
        o.c(r13, "getMethod(...)");     // Catch: LinkageError -> L8 Exception -> L10
        Class r14 = Long.TYPE;     // Catch: LinkageError -> L8 Exception -> L10
        o.c(r14, "TYPE");     // Catch: LinkageError -> L8 Exception -> L10
        a(r13, r14);     // Catch: LinkageError -> L8 Exception -> L10
        Method r15 = r4.getMethod("addAutoVirtualDisplayRecordPackages", new Class[]{Long.TYPE, String[].class});     // Catch: LinkageError -> L8 Exception -> L10
        o.c(r15, "getMethod(...)");     // Catch: LinkageError -> L8 Exception -> L10
        Class r16 = Boolean.TYPE;     // Catch: LinkageError -> L8 Exception -> L10
        o.c(r16, "TYPE");     // Catch: LinkageError -> L8 Exception -> L10
        a(r15, r16);     // Catch: LinkageError -> L8 Exception -> L10
        Method r17 = r4.getMethod("endAutoVirtualDisplayRecordSet", new Class[]{Long.TYPE});     // Catch: LinkageError -> L8 Exception -> L10
        o.c(r17, "getMethod(...)");     // Catch: LinkageError -> L8 Exception -> L10
        Class r18 = Void.TYPE;     // Catch: LinkageError -> L8 Exception -> L10
        o.c(r18, "TYPE");     // Catch: LinkageError -> L8 Exception -> L10
        a(r17, r18);     // Catch: LinkageError -> L8 Exception -> L10
        o.a(r4);     // Catch: LinkageError -> L8 Exception -> L10
        r11.invoke(r4);     // Catch: LinkageError -> L8 Exception -> L10
        return true;
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: LinkageError -> L8 Exception -> L10
    L10:
        e = move-exception;
        r12.invoke(e);
    L13:
        return false;
    L8:
        e = move-exception;
        r12.invoke(e);
        goto L13
    }

    private static final void a(Method r2, Class<?> r3) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L10;
        if (o.a(r2.getReturnType(), r3) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
