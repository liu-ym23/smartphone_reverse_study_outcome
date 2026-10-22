package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f149987a;

    public c(View r100) {
        this.f149987a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ViewGroup.LayoutParams r101 = this.f149987a.getLayoutParams();
        r101.height = CastIntegerProtector.parseInt(r100.getAnimatedValue().toString());
        ViewGroup.LayoutParams r102 = this.f149987a.getLayoutParams();
        r102.width = CastIntegerProtector.parseInt(r100.getAnimatedValue().toString()) + UtilityKotlinExtentionsKt.d(20);
    }
}
