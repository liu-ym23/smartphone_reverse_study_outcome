package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboWaveView f126942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f126943b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126942a.removeView(this.f126943b);
    }

    public p(GiftRareShopComboWaveView r100, View r101) {
        this.f126942a = r100;
        this.f126943b = r101;
    }
}
