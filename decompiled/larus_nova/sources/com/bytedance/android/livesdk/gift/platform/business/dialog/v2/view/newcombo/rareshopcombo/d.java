package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboHeatHelper f126924a;

    public d(GiftRareShopComboHeatHelper r100) {
        this.f126924a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        GiftRareShopComboHeatHelper r101 = this.f126924a;
        Animator r102 = r101.f126882a;
        if (r102 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r102);
    L5:
        r101.f126884c.setValue(Boolean.FALSE);
    }
}
