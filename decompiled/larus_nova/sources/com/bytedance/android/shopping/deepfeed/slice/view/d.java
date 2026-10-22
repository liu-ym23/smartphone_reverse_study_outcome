package com.bytedance.android.shopping.deepfeed.slice.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f173517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f173518b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f173517a.e(1.0f);
        this.f173518b.invoke();
    }

    public d(a r100, Function0 r101) {
        this.f173517a = r100;
        this.f173518b = r101;
    }
}
