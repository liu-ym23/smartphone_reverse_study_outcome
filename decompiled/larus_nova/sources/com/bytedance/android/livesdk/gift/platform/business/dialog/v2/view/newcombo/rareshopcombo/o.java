package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboView f126941a;

    public o(GiftRareShopComboView r100) {
        this.f126941a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftRareShopComboView r101 = this.f126941a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L16;
        r101.G = ((Float) r102).floatValue();
        Drawable r103 = s1.m(R.drawable.ttlive_gift_rare_shop_combo_bg);
        Drawable r104 = s1.m(R.drawable.ttlive_gift_rare_shop_combo_button_high_light);
        if (r104 == null) goto L11;
        Object r105 = r100.getAnimatedValue();
        if (r105 == null) goto L10;
        r104.setAlpha((int) (((Float) r105).floatValue() * 255));
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        Drawable[] r106 = {r103, r104};
        View r107 = this.f126941a.f126888a;
        if (r107 == null) goto L17;
        r107.setBackground(new LayerDrawable(r106));
        return;
    L17:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
