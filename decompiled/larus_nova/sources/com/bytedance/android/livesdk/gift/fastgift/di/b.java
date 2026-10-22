package com.bytedance.android.livesdk.gift.fastgift.di;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f126150a;

    public b(Function0 r100) {
        this.f126150a = r100;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126150a.invoke();
    }
}
