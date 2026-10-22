package com.bytedance.apm.battery.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: ServiceFetcherProxyHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f4260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f4261b;

    static /* synthetic */ b a(c r0) {
        return r0.f4261b;
    }

    public c(Object r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        this.f4260a = r3;
        this.f4261b = r5;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r8, Method r9, Object[] r10) {
    L11:
        th = move-exception;
        com.bytedance.apm.h.a.a("APM-Battery", "ServiceFetcher getService hook failed: " + th.getMessage());
    L14:
        return r9.invoke(this.f4260a, r10);
    L3:
        if ("getService".equals(r9.getName()) == false) goto L14;
        Object r11 = r9.invoke(this.f4260a, r10);     // Catch: Throwable -> L11
        Field r0 = r11.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r0.setAccessible(true);     // Catch: Throwable -> L11
        final Object r2 = r0.get(r11);     // Catch: Throwable -> L11
        String r3 = r2.getClass().getName();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L10:
        return r11;
    L7:
        if (r3.startsWith(this.f4261b.a()) == false) goto L10;
        r0.set(r11, Proxy.newProxyInstance(r2.getClass().getClassLoader(), new Class[]{ZeusTransformUtils.forName(this.f4261b.a(), "com.obric.aiagent.plugin")}, new AnonymousClass1(this, r2)));     // Catch: Throwable -> L11
        goto L10
    }
}
