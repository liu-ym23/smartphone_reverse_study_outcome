package com.bytedance.android.ec.host.impl;

import android.app.Application;
import com.larus.abtest.api.IAbTest;
import com.larus.common.apphost.AppHost;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements yj.g, yj.o {
    public n() {
    }

    @Override // yj.g
    public final void b() {
    }

    @Override // yj.g
    public final void c() {
    }

    @Override // yj.g
    public final void e() {
    }

    @Override // yj.g
    public final void f() {
    }

    @Override // yj.g
    public final void h() {
    }

    @Override // yj.g
    public final void j() {
    }

    @Override // yj.g
    public final void l() {
    }

    @Override // yj.g
    public final void m() {
    }

    @Override // yj.g
    public final void n() {
    }

    @Override // yj.g
    public final void o() {
    }

    @Override // yj.g
    public final void p() {
    }

    @Override // yj.g
    public final void q() {
    }

    @Override // yj.g
    public final void r() {
    }

    @Override // yj.g
    public final void t() {
    }

    @Override // yj.g
    public final void u() {
    }

    @Override // yj.g
    public final void v() {
    }

    @Override // yj.g
    public final com.bytedance.android.ec.hybrid.data.i k() {
        return new com.bytedance.android.ec.hybrid.data.i(0);
    }

    @Override // yj.g
    public final Map<String, List<String>> s() {
        return new LinkedHashMap();
    }

    @Override // yj.g
    public final Boolean g() {
        return Boolean.TRUE;
    }

    @Override // yj.o
    public final Object i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        ft9.k r102 = ft9.k.f478804a;     // Catch: Throwable -> L14
        Application r103 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L14
        r102.getClass();     // Catch: Throwable -> L14
        JSONObject r104 = ft9.k.c(r103);     // Catch: Throwable -> L14
        if (r104 == null) goto L7;
        Object r105 = r104.opt(r100);     // Catch: Throwable -> L14
        if (r105 == null) goto L7;
    L12:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r106) == false) goto L20;
        return null;
    L20:
        return r106;
    L7:
        if (r104 == null) goto L11;
        JSONObject r107 = r104.optJSONObject("ecom_saas_config");     // Catch: Throwable -> L14
        if (r107 == null) goto L11;
        r105 = r107.opt(r100);     // Catch: Throwable -> L14
    L11:
        r105 = null;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // yj.g
    public final <T> T a(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        T r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        ft9.k r104 = ft9.k.f478804a;     // Catch: Throwable -> L16
        Application r105 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L16
        r104.getClass();     // Catch: Throwable -> L16
        JSONObject r106 = ft9.k.c(r105);     // Catch: Throwable -> L16
        if (r106 == null) goto L7;
        Object r107 = r106.opt(r100);     // Catch: Throwable -> L16
        if (r107 == null) goto L7;
    L12:
        if (r107 != null) goto L14;
        r107 = null;
    L14:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r108) == true) goto L22;
        r102 = (T) r108;
    L22:
        if (r102 != null) goto L27;
        IAbTest.Companion r109 = IAbTest.f286085a;
        Class<?> r110 = r101.getClass();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type java.lang.Class<T of com.bytedance.android.ec.host.impl.ECHybridHostABService.getValue>");
        return (T) r109.r(r100, r110, r101);
    L27:
        return r102;
    L7:
        if (r106 == null) goto L11;
        JSONObject r111 = r106.optJSONObject("ecom_saas_config");     // Catch: Throwable -> L16
        if (r111 == null) goto L11;
        r107 = r111.opt(r100);     // Catch: Throwable -> L16
    L11:
        r107 = null;
    L16:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // yj.g
    public final void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
    }
}
