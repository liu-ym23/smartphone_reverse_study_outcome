package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboView f126930a;

    public j(GiftRareShopComboView r100) {
        this.f126930a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.s, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        HSImageView r101 = this.f126930a.f126902o;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }
}
