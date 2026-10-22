package com.ss.android.deviceregister.base;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: XiaomiOppoImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class x implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f37406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f37407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f37408c;

    static {
        Class<?> r0 = ZeusTransformUtils.forName("com.android.id.impl.IdProviderImpl", "com.obric.aiagent.plugin");     // Catch: Exception -> L4
        f37407b = r0;     // Catch: Exception -> L4
        f37406a = r0.newInstance();     // Catch: Exception -> L4
        f37408c = f37407b.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.ss.android.deviceregister.o.c(com.ss.android.deviceregister.o.f37441a, "Api#static reflect exception! " + e.getMessage());
    }

    x() {
    }

    static boolean a() {
        if (f37407b != null) goto L5;
    L9:
        return false;
    L5:
        if (f37406a == null) goto L9;
        if (f37408c == null) goto L9;
        return true;
    }

    @Override // com.ss.android.deviceregister.base.o
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a();
    }

    @Override // com.ss.android.deviceregister.base.o
    public o.a c(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.a r3 = new o.a();     // Catch: Exception -> L5
        r3.f37379a = a(r1, f37408c);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String a(Context r4, Method r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Object r0 = f37406a;
        if (r0 == null) goto L10;
        if (r5 != null) goto L13;
        return null;
    L13:
        Object r7 = r5.invoke(r0, new Object[]{r6});     // Catch: Exception -> L12
        if (r7 == null) goto L16;
        return (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L16:
        return null;
    L17:
        return null;
    L10:
        return null;
    }
}
