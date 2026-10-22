package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f126921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboHeatHelper f126922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f126923c;

    public c(ValueAnimator r100, GiftRareShopComboHeatHelper r101, Ref.FloatRef r102) {
        this.f126921a = r100;
        this.f126922b = r101;
        this.f126923c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Ref.FloatRef r101 = this.f126923c;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L13;
        r101.element = ((Float) r102).floatValue();
        if (this.f126922b.f126886e <= 4000) goto L14;
        float r103 = this.f126921a.getDuration() * this.f126923c.element;
        GiftRareShopComboHeatHelper r104 = this.f126922b;
        if (r103 >= (r104.f126886e - 4000)) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r104.f126885d.getValue(), Boolean.FALSE) == false) goto L16;
        this.f126922b.f126885d.setValue(Boolean.TRUE);
        return;
    L16:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
