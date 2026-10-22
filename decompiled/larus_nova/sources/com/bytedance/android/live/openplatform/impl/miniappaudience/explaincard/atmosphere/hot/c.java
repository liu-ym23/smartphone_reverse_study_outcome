package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppHotAtmosphereView f84874a;

    public c(MiniAppHotAtmosphereView r100) {
        this.f84874a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f84874a.setAlpha(1.0f);
        this.f84874a.setVisibility(4);
    }
}
