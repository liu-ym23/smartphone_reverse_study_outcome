package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboWaveView f126872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f126873b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126872a.removeView(this.f126873b);
    }

    public k(ComboWaveView r100, View r101) {
        this.f126872a = r100;
        this.f126873b = r101;
    }
}
