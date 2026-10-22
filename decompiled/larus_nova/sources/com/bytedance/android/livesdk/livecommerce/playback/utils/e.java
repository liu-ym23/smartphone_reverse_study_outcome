package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f149989a;

    public e(View r100) {
        this.f149989a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        if ((this.f149989a.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L14;
        ViewGroup.LayoutParams r101 = this.f149989a.getLayoutParams();
        if (r101 == null) goto L13;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        r102.height = CastIntegerProtector.parseInt(r100.getAnimatedValue().toString());     // Catch: NumberFormatException -> L9
    L11:
        this.f149989a.setLayoutParams(r102);
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
}
