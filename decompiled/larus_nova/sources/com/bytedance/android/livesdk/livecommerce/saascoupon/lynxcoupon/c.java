package com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.card.ExternalCardStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f152899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f152900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f152901c;

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r110) {
        Intrinsics.checkNotNullParameter(r110, "lynxView");
        Intrinsics.checkNotNullParameter(r110, "lynxView");
        dm.a.a("LynxCardController").i("[load][ExternalCard] load lynx success, schema: " + this.f152899a);
        final a r100 = this.f152900b;
        ViewGroup r101 = this.f152901c;
        r100.getClass();
        r100.f152882e = ExternalCardStatus.ANIM_SHOWING;
        Long r102 = r100.f152887j.c();
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        final long r104 = r103 / 1000;
        if (r104 > 0) goto L9;
        r100.f152882e = ExternalCardStatus.FINISHED;
        return;
    L9:
        r101.addView(r100.f152881d);
        r100.f152881d.setAlpha(0.0f);
        r100.f152881d.requestLayout();
        FrameLayout r105 = r100.f152881d;
        final Function0<Unit> r106 = new LynxCardController$displayCard$1(r100, r104);
        final Function0<Unit> r107 = new LynxCardController$displayCard$2(r100);
        dm.a.a("LynxCardController").i("[anim][ExternalCard] showCardAnim");
        r100.f152889l.a(r105, new LynxCardController$showCardAnim$1(r100), new LynxCardController$showCardAnim$2(r106), new LynxCardController$showCardAnim$3(r100, r107), null);
        return;
    L5:
        r103 = 10000;
        goto L6
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        dm.a.a("LynxCardController").w("[load][ExternalCard] load lynx failed, schema: " + this.f152899a + ", errMsg: " + r101, null);
        this.f152901c.removeView(r100);
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public c(String r100, a r101, ViewGroup r102) {
        this.f152899a = r100;
        this.f152900b = r101;
        this.f152901c = r102;
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }
}
