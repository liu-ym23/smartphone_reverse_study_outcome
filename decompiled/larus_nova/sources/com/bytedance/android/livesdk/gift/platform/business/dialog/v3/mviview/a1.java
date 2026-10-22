package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pair f127685a;

    public a1(Pair r100) {
        this.f127685a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ((ViewGroup) this.f127685a.getFirst()).setVisibility(0);
        ((BaseGiftMVIViewChildNode) this.f127685a.getSecond()).p(0);
        super.onAnimationStart(r100);
    }
}
