package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindScreenRebirthAnimTrayView f136562a;

    public i(WindScreenRebirthAnimTrayView r100) {
        this.f136562a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f136562a.f136541e.setVisibility(0);
        this.f136562a.f136540d.setVisibility(8);
    }
}
