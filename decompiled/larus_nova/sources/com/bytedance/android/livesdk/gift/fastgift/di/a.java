package com.bytedance.android.livesdk.gift.fastgift.di;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f126148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f126149b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Ref.IntRef r101 = this.f126148a;
        int r102 = r101.element;
        if (r102 >= 4) goto L6;
        r101.element = r102 + 1;
        this.f126149b.start();
        return;
    }

    public a(Ref.IntRef r100, AnimatorSet r101) {
        this.f126148a = r100;
        this.f126149b = r101;
    }
}
