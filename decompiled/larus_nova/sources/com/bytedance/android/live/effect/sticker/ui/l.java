package com.bytedance.android.live.effect.sticker.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerFavoriteImageView f68587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f68588b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f68588b.start();
        StickerFavoriteImageView.b r101 = this.f68587a.f68458c;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.onStateChange(1);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        StickerFavoriteImageView.b r101 = this.f68587a.f68458c;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.onStateChange(0);
        return;
    }

    public l(StickerFavoriteImageView r100, AnimatorSet r101) {
        this.f68587a = r100;
        this.f68588b = r101;
    }
}
