package com.bytedance.android.ec.sdk.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.window.shop.home.presenter.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p implements jj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f48130a = null;

    public p() {
    }

    static {
        f48130a = new p();
    }

    public static jj.a g() {
        return d.f48119b.getIECHostRouterManager();
    }

    @Override // jj.a
    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        g().b(r100);
    }

    @Override // jj.a
    public final void c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        g().c(r100);
    }

    @Override // jj.a
    public final void d(String r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r101, "fromAct");
        g().d(r100, r101);
    }

    @Override // jj.a
    public final void openSchema(Context r100, String r101) {
        g().openSchema(r100, r101);
    }

    @Override // jj.a
    public final void a(Context r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_ANIMATION);
        g().a(r100, r101, r102);
    }

    @Override // jj.a
    public final void f(Context r100, String r101, r0.a r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        g().f(r100, r101, r102);
    }

    @Override // jj.a
    public final void e(String r100, Activity r101, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "fromAct");
        g().e(r100, r101, r110, r111, r112);
    }
}
