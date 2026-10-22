package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductSlcView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f173970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f173971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f173972c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup.LayoutParams r101 = this.f173970a.getLayoutParams();
        r101.height = this.f173971b;
        this.f173970a.setLayoutParams(r101);
        Function0 r102 = this.f173972c;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }

    public c(DeepFeedProductSlcView r100, int r101, Function0 r102) {
        this.f173970a = r100;
        this.f173971b = r101;
        this.f173972c = r102;
    }
}
