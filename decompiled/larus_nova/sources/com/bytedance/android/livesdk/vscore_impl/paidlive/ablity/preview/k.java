package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f160390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f160391b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f160390a.f160410s;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ViewGroup r102 = this.f160390a.f160398g;
        if (r102 == null) goto L8;
        r102.setAlpha(1.0f);
    L8:
        ViewGroup r103 = this.f160390a.f160395d;
        if (r103 == null) goto L11;
        r103.setAlpha(1.0f);
    L11:
        HSImageView r104 = this.f160390a.f160414w;
        if (r104 == null) goto L14;
        r104.setAlpha(1.0f);
    L14:
        HSImageView r105 = this.f160390a.f160413v;
        if (r105 == null) goto L18;
        r105.setAlpha(1.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        ViewGroup r101 = this.f160390a.f160410s;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }

    public k(l r100, List r101) {
        this.f160390a = r100;
        this.f160391b = r101;
    }
}
