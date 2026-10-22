package com.bytedance.android.ec.sdk.helper;

import android.app.Activity;
import android.os.Bundle;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements pj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f48132a = null;

    public r() {
    }

    static {
        f48132a = new r();
    }

    public static pj.a g() {
        return d.f48119b.getIECHostUserService();
    }

    @Override // pj.a
    public final long a() {
        return g().a();
    }

    @Override // pj.a
    public final Observable<Boolean> b() {
        return g().b();
    }

    @Override // pj.a
    public final String f() {
        return g().f();
    }

    @Override // pj.a
    public final String getAccessToken() {
        return g().getAccessToken();
    }

    @Override // pj.a
    public final String getCurrentUserId() {
        return g().getCurrentUserId();
    }

    @Override // pj.a
    public final boolean isLogin() {
        return g().isLogin();
    }

    @Override // pj.a
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ecSceneID");
        Intrinsics.checkNotNullParameter("goods_detail", SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        return g().c(r100);
    }

    @Override // pj.a
    public final void showLogin(Activity r100, String r101, String r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        g().showLogin(r100, r101, r110, r111, r112);
    }

    @Override // pj.a
    public final void d(Activity r100, String r110, String r111, String r112, Function0<Unit> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Intrinsics.checkNotNullParameter(r112, "source");
        g().d(r100, r110, r111, r112, r113, r114);
    }

    @Override // pj.a
    public final void e(Activity r100, String r110, String r111, Bundle r112, Function0<Unit> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        g().e(r100, r110, r111, r112, r113, r114);
    }
}
