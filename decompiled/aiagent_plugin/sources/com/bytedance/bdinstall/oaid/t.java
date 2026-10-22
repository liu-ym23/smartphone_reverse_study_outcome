package com.bytedance.bdinstall.oaid;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: XiaomiOppoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class t implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f6432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f6433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f6434c;

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Xiaomi";
    }

    static {
        Class<?> r0 = ZeusTransformUtils.forName("com.android.id.impl.IdProviderImpl", "com.obric.aiagent.plugin");     // Catch: Exception -> L4
        f6433b = r0;     // Catch: Exception -> L4
        f6432a = r0.newInstance();     // Catch: Exception -> L4
        f6434c = f6433b.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.bdinstall.t.c("Oaid#static reflect exception! " + e.getMessage());
    }

    t() {
    }

    static boolean a() {
        if (f6433b != null) goto L5;
    L9:
        return false;
    L5:
        if (f6432a == null) goto L9;
        if (f6434c == null) goto L9;
        return true;
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a();
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public k.a c(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        k.a r3 = new k.a();     // Catch: Exception -> L5
        r3.f6412b = a(r1, f6434c);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String a(Context r4, Method r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Object r0 = f6432a;
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
