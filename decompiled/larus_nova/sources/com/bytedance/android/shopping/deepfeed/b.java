package com.bytedance.android.shopping.deepfeed;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f173073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f173074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ he3.l f173075c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        DeepFeedProductFragment r101 = this.f173074b.f173076a;
        AbsDeepFeedProductVH r102 = r101.f173014v;
        if (r102 == null) goto L6;
        r102.y4(this.f173075c, r101.aa0());
        return;
    }

    public b(Map r100, c r101, he3.l r102) {
        this.f173073a = r100;
        this.f173074b = r101;
        this.f173075c = r102;
    }
}
