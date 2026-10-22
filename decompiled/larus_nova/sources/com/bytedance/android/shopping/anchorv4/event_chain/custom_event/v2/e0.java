package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class e0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f166627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowManager f166628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f166629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f166630d;

    public e0(ValueAnimator r100, WindowManager r101, View r102, WindowManager.LayoutParams r103) {
        this.f166627a = r100;
        this.f166628b = r101;
        this.f166629c = r102;
        this.f166630d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = this.f166627a.getAnimatedValue();     // Catch: Throwable -> L12
        if (r101 == null) goto L11;
        Point r102 = (Point) r101;     // Catch: Throwable -> L12
        float r103 = 1 - this.f166627a.getAnimatedFraction();     // Catch: Throwable -> L12
        WindowManager r104 = this.f166628b;     // Catch: Throwable -> L12
        if (r104 == null) goto L8;
        View r105 = this.f166629c;     // Catch: Throwable -> L12
        WindowManager.LayoutParams r106 = this.f166630d;     // Catch: Throwable -> L12
        r106.x = r102.x;     // Catch: Throwable -> L12
        r106.y = r102.y;     // Catch: Throwable -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r104.updateViewLayout(r105, r106);     // Catch: Throwable -> L12
    L8:
        if (r103 > 0.4d) goto L16;
        float r108 = r103 + 0.4f;     // Catch: Throwable -> L12
        this.f166629c.setScaleX(r108);     // Catch: Throwable -> L12
        this.f166629c.setScaleY(r108);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Point");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ECExceptionMonitor.e(th);
        this.f166629c.setVisibility(4);
    }
}
