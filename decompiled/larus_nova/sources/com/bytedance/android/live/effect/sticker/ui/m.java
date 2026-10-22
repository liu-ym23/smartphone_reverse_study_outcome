package com.bytedance.android.live.effect.sticker.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerFavoriteImageView f68589a;

    public m(StickerFavoriteImageView r100) {
        this.f68589a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        StickerFavoriteImageView.b r101 = this.f68589a.f68458c;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.onAnimationEnd();
        return;
    }
}
