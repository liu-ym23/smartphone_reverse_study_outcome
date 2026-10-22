package com.bytedance.android.shopping.feed.utils;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f175474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECDraweeView f175475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowManager f175476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f175477d;

    public x(ValueAnimator r100, ECDraweeView r101, WindowManager r102, WindowManager.LayoutParams r103) {
        this.f175474a = r100;
        this.f175475b = r101;
        this.f175476c = r102;
        this.f175477d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = this.f175474a.getAnimatedValue();     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        PointF r102 = (PointF) r101;     // Catch: Throwable -> L10
        float r103 = 1 - this.f175474a.getAnimatedFraction();     // Catch: Throwable -> L10
        WindowManager r104 = this.f175476c;     // Catch: Throwable -> L10
        if (r104 == null) goto L7;
        ECDraweeView r105 = this.f175475b;     // Catch: Throwable -> L10
        WindowManager.LayoutParams r106 = this.f175477d;     // Catch: Throwable -> L10
        r106.x = (int) r102.x;     // Catch: Throwable -> L10
        r106.y = (int) r102.y;     // Catch: Throwable -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r104.updateViewLayout(r105, r106);     // Catch: Throwable -> L10
    L7:
        this.f175475b.setAlpha(r103);     // Catch: Throwable -> L10
        this.f175475b.setScaleX(0.3f - (this.f175474a.getAnimatedFraction() * 0.25f));     // Catch: Throwable -> L10
        this.f175475b.setScaleY(0.3f - (this.f175474a.getAnimatedFraction() * 0.25f));     // Catch: Throwable -> L10
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f175475b.setVisibility(4);
        ECExceptionMonitor.e(th);
    }
}
