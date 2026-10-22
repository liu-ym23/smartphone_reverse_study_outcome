package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboView f126931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f126932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f126933c;

    public k(GiftRareShopComboView r100, Drawable r101, Drawable r102) {
        this.f126931a = r100;
        this.f126932b = r101;
        this.f126933c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftRareShopComboView r101 = this.f126931a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L16;
        r101.G = ((Float) r102).floatValue();
        Drawable r103 = this.f126932b;
        if (r103 == null) goto L11;
        Object r104 = r100.getAnimatedValue();
        if (r104 == null) goto L10;
        r103.setAlpha((int) (((Float) r104).floatValue() * 255));
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        Drawable[] r105 = {this.f126933c, this.f126932b};
        View r106 = this.f126931a.f126888a;
        if (r106 == null) goto L17;
        r106.setBackground(new LayerDrawable(r105));
        return;
    L17:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
