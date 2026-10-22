package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductInfoMarqueeView f174240a;

    public p(DeepFeedProductInfoMarqueeView r100) {
        this.f174240a = r100;
    }

    public final void a() {
        DeepFeedProductInfoMarqueeView r100 = this.f174240a;
        View r101 = r100.f174107a;
        View r102 = r100.f174108b;
        if (r101 == null) goto L5;
        int r103 = r101.getHeight();
    L6:
        r100.f174109c = r103;
        if (r101 == null) goto L24;
        if (r102 == null) goto L24;
        if (DeepFeedProductInfoMarqueeView.T5(r101) == false) goto L24;
        if (DeepFeedProductInfoMarqueeView.T5(r102) == false) goto L24;
        if (r101.getVisibility() != 0) goto L24;
        if (r102.getVisibility() != 0) goto L24;
        if (r100.f174109c <= 0) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L38;
        ValueAnimator r105 = r100.f174110d;
        if (r105 == null) goto L31;
        if (r105.isRunning() != true) goto L31;
        return;
    L31:
        if (r100.f174115i == false) goto L40;
        ValueAnimator r106 = r100.f174110d;
        if (r106 == null) goto L36;
        r106.cancel();
    L36:
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{0.0f, -r100.f174109c});
        r107.setDuration(r100.f174113g);
        r107.setInterpolator(new LinearInterpolator());
        r107.addUpdateListener(new q(r100));
        r107.addListener(new r(r100));
        Unit r108 = Unit.INSTANCE;
        r100.f174110d = r107;
        r107.start();
        return;
    L40:
        return;
    L38:
        return;
    L24:
        r104 = false;
        goto L25
    L5:
        r103 = r100.getHeight();
        goto L6
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
