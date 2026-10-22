package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f127911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseGiftMVIViewChildNode f127912b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f127911a.setVisibility(0);
        this.f127912b.p(0);
        super.onAnimationStart(r100);
    }

    public b1(ViewGroup r100, BaseGiftMVIViewChildNode r101) {
        this.f127911a = r100;
        this.f127912b = r101;
    }
}
