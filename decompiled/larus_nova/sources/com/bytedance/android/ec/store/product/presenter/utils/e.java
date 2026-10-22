package com.bytedance.android.ec.store.product.presenter.utils;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.WindowManager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f48368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowManager f48369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ECDraweeView f48370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f48371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f48372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f48373f;

    public e(ValueAnimator r100, WindowManager r101, ECDraweeView r102, WindowManager.LayoutParams r103, int r104, int r105) {
        this.f48368a = r100;
        this.f48369b = r101;
        this.f48370c = r102;
        this.f48371d = r103;
        this.f48372e = r104;
        this.f48373f = r105;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        Object r111 = this.f48368a.getAnimatedValue();     // Catch: Throwable -> L10
        if (r111 == null) goto L9;
        Point r112 = (Point) r111;     // Catch: Throwable -> L10
        float r100 = 1.0f - (this.f48368a.getAnimatedFraction() * 0.8f);     // Catch: Throwable -> L10
        WindowManager r101 = this.f48369b;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        ECDraweeView r102 = this.f48370c;     // Catch: Throwable -> L10
        WindowManager.LayoutParams r103 = this.f48371d;     // Catch: Throwable -> L10
        int r104 = r112.x;     // Catch: Throwable -> L10
        int r105 = this.f48372e;     // Catch: Throwable -> L10
        r103.x = r104 - ((int) (((double) (r105 - (r105 * r100))) * 0.5d));     // Catch: Throwable -> L10
        int r113 = r112.y;     // Catch: Throwable -> L10
        int r106 = this.f48373f;     // Catch: Throwable -> L10
        r103.y = r113 - ((int) (((double) (r106 - (r106 * r100))) * 0.5d));     // Catch: Throwable -> L10
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r101.updateViewLayout(r102, r103);     // Catch: Throwable -> L10
    L7:
        this.f48370c.setScaleX(r100);     // Catch: Throwable -> L10
        this.f48370c.setScaleY(r100);     // Catch: Throwable -> L10
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Point");     // Catch: Throwable -> L10
    L10:
        this.f48370c.setVisibility(4);
    }
}
