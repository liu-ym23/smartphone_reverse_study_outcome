package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IconMoveAnimationTasklet f71183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f71184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EPointF f71185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EPointF f71186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f71187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Animatable f71188f;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        Animatable r101 = this.f71188f;
        if (r101 == null) goto L6;
        r101.stop();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        Animatable r101 = this.f71188f;
        if (r101 == null) goto L5;
        r101.start();
    L5:
        com.bytedance.android.live.liveinteract.animation.e r102 = this.f71183a.f71130m;
        EPointF r103 = this.f71185c;
        if (r102.Mk(r103, r103, this.f71186d) == true) goto L8;
        IconMoveAnimationTasklet r104 = this.f71183a;
        HSImageView r105 = this.f71184b;
        r104.getClass();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.width = 1;
        r106.height = 1;
        r105.setLayoutParams(r106);
        return;
    L8:
        this.f71183a.d(this.f71184b, this.f71187e);
    }

    public f(IconMoveAnimationTasklet r100, HSImageView r101, EPointF r102, EPointF r103, int r104, Animatable r105) {
        this.f71183a = r100;
        this.f71184b = r101;
        this.f71185c = r102;
        this.f71186d = r103;
        this.f71187e = r104;
        this.f71188f = r105;
    }
}
