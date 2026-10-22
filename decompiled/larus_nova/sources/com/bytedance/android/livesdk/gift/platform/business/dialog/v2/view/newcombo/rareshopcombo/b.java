package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboHeatHelper f126920a;

    public b(GiftRareShopComboHeatHelper r100) {
        this.f126920a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Boolean r101 = this.f126920a.f126885d.getValue();
        Boolean r102 = Boolean.FALSE;
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L6;
        this.f126920a.f126885d.setValue(r102);
        return;
    }
}
