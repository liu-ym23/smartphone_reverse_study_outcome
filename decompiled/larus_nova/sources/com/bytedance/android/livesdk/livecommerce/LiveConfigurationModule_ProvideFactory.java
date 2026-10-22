package com.bytedance.android.livesdk.livecommerce;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.a;
import el2.b;
import el2.c;
import el2.d;
import el2.e;
import el2.f;
import hh2.g;
import sg2.a0;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveConfigurationModule_ProvideFactory implements Factory<g> {
    private final a0 module;

    @Override // javax.inject.Provider
    public g get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LiveConfigurationModule_ProvideFactory(a0 r100) {
        this.module = r100;
    }

    public static LiveConfigurationModule_ProvideFactory create(a0 r100) {
        return new LiveConfigurationModule_ProvideFactory(r100);
    }

    public static g provideInstance(a0 r100) {
        return proxyProvide(r100);
    }

    public static g proxyProvide(a0 r100) {
        r100.getClass();
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (ECAppInfoService.j() == false) goto L6;
        g r102 = a0.a();
    L20:
        return (g) Preconditions.checkNotNull(r102, "Cannot return null from a non-@Nullable @Provides method");
    L6:
        if (ECAppInfoService.k() == false) goto L9;
        r102 = new g();
        r102.y("https://lianmengapi.snssdk.com");
        r102.f485168a = new a();
        r102.f485169b = new d();
        Boolean r103 = Boolean.FALSE;
        r102.B(r103);
        r102.E(r103);
        r102.w(null);
        r102.A(null);
        Boolean r104 = Boolean.TRUE;
        r102.v(r104);
        r102.H(r103);
        r102.I(r103);
        r102.r(r104);
        r102.s(r104);
        r102.u(r104);
        r102.G(r103);
        r102.t(r103);
        r102.z(r104);
        goto L20
    L9:
        if (ECAppInfoService.l() == false) goto L12;
        r102 = new g();
        r102.y("https://lianmengapi.snssdk.com");
        r102.f485168a = new b();
        r102.f485169b = new e();
        Boolean r105 = Boolean.FALSE;
        r102.B(r105);
        r102.E(r105);
        r102.w(null);
        r102.A(null);
        Boolean r106 = Boolean.TRUE;
        r102.v(r106);
        r102.H(r105);
        r102.I(r105);
        r102.r(r106);
        r102.s(r106);
        r102.u(r106);
        r102.G(r105);
        r102.t(r105);
        r102.z(r106);
        goto L20
    L12:
        if (we.a.f559330a == false) goto L18;
        g r107 = new g();
        if (r101.n() == false) goto L16;
        String r108 = "https://saas.ecombdapi.com";
    L17:
        r107.y(r108);
        r107.f485168a = new c();
        r107.f485169b = new f();
        Boolean r109 = Boolean.TRUE;
        r107.B(r109);
        r107.E(r109);
        r107.w("tobsdk_");
        r107.A("ec_open_local_cache_sp");
        Boolean r110 = Boolean.FALSE;
        r107.v(r110);
        r107.H(r109);
        r107.I(r109);
        r107.r(r110);
        r107.s(Boolean.valueOf(EComABUtils.enableSaasPromotionCardOpt()));
        r107.u(Boolean.valueOf(EComABUtils.enableSaasDeviceDegrade()));
        r107.G(Boolean.valueOf(r101.n()));
        r107.t(r110);
        r107.x(r109);
        r107.F(r109);
        r107.C(r109);
        r107.z(r110);
        r102 = r107;
        goto L20
    L16:
        r108 = "https://isaas.ecombdapi.com";
        goto L17
    L18:
        r102 = a0.a();
        goto L20
    }
}
