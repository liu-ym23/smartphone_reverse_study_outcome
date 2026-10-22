package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f151025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f151026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f151027c;

    public d(b r100, int r101, View r102) {
        this.f151025a = r100;
        this.f151026b = r101;
        this.f151027c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L11;
        float r102 = ((Float) r101).floatValue();
        this.f151027c.setAlpha(1 - r102);
        if (this.f151026b == 0) goto L7;
        return;
    L7:
        if (this.f151025a.f151017s == false) goto L13;
        this.f151027c.setTranslationY(r102 * (-UtilityKotlinExtentionsKt.c(40)));
        return;
    L13:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
