package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f151022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f151023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f151024c;

    public c(b r100, View r101, int r102) {
        this.f151022a = r100;
        this.f151023b = r101;
        this.f151024c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L11;
        float r102 = ((Float) r101).floatValue();
        this.f151023b.setAlpha(r102);
        if (this.f151024c == 0) goto L7;
        return;
    L7:
        if (this.f151022a.f151017s == false) goto L13;
        this.f151023b.setTranslationY((1 - r102) * UtilityKotlinExtentionsKt.c(40));
        return;
    L13:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
