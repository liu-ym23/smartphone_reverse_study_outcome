package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.WindowManager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f181367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowManager f181368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ECDraweeView f181369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f181370d;

    public c(ValueAnimator r100, WindowManager r101, ECDraweeView r102, WindowManager.LayoutParams r103) {
        this.f181367a = r100;
        this.f181368b = r101;
        this.f181369c = r102;
        this.f181370d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = this.f181367a.getAnimatedValue();     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        Point r102 = (Point) r101;     // Catch: Throwable -> L10
        float r103 = 1 - this.f181367a.getAnimatedFraction();     // Catch: Throwable -> L10
        WindowManager r104 = this.f181368b;     // Catch: Throwable -> L10
        if (r104 == null) goto L7;
        ECDraweeView r105 = this.f181369c;     // Catch: Throwable -> L10
        WindowManager.LayoutParams r106 = this.f181370d;     // Catch: Throwable -> L10
        r106.x = r102.x;     // Catch: Throwable -> L10
        r106.y = r102.y;     // Catch: Throwable -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r104.updateViewLayout(r105, r106);     // Catch: Throwable -> L10
    L7:
        this.f181369c.setAlpha(r103);     // Catch: Throwable -> L10
        this.f181369c.setScaleX(0.3f - (this.f181367a.getAnimatedFraction() * 0.25f));     // Catch: Throwable -> L10
        this.f181369c.setScaleY(0.3f - (this.f181367a.getAnimatedFraction() * 0.25f));     // Catch: Throwable -> L10
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Point");     // Catch: Throwable -> L10
    L10:
        this.f181369c.setVisibility(4);
    }
}
