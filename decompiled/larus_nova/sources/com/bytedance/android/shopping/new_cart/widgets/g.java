package com.bytedance.android.shopping.new_cart.widgets;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECCartLoadingView f179474a;

    public g(ECCartLoadingView r100) {
        this.f179474a = r100;
    }

    public final void a() {
        Context r100 = this.f179474a.getContext();
        Intrinsics.checkNotNullParameter(r100, "$this$isActivityAlive");
        if ((r100 instanceof Activity) == false) goto L9;
        Activity r101 = (Activity) r100;
        if (r101.isFinishing() == true) goto L9;
        if (r101.isDestroyed() == true) goto L9;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        dm.a.a("ECCartLoadingView").i("activity is not alive,clearValueAnimator");
        this.f179474a.U5();
        return;
    L14:
        this.f179474a.setVisibility(0);
        if (this.f179474a.f179457h.get() == false) goto L22;
        dm.a.a("ECCartLoadingView").i("wireFrame startLoading");
        ExtensionsKt.visible(ECCartLoadingView.T5(this.f179474a));
        ExtensionsKt.gone(ECCartLoadingView.S5(this.f179474a));
        ECCartLoadingView.R5(this.f179474a).stopAnimate();
        this.f179474a.U5();
        ECCartLoadingView r103 = this.f179474a;
        r103.f179460k = r103.findViewById(R.id.shimmer_wire_frame);
        View r104 = this.f179474a.f179460k;
        if (r104 == null) goto L19;
        r104.clearAnimation();
    L19:
        ECCartLoadingView r105 = this.f179474a;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r106.setDuration(800);
        r106.setRepeatCount(-1);
        r106.setRepeatMode(1);
        r106.addUpdateListener(new n(this.f179474a));
        Unit r107 = Unit.INSTANCE;
        r105.f179459j = r106;
        ValueAnimator r108 = this.f179474a.f179459j;
        if (r108 == null) goto L24;
        r108.start();
        return;
    L24:
        return;
    L22:
        ExtensionsKt.gone(ECCartLoadingView.T5(this.f179474a));
        ExtensionsKt.visible(ECCartLoadingView.S5(this.f179474a));
        ExtensionsKt.visible(ECCartLoadingView.R5(this.f179474a));
        ECCartLoadingView.R5(this.f179474a).startAnimate();
        return;
    L9:
        r102 = false;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
