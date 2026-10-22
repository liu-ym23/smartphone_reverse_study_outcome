package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.common.api.model.PlaybackSmallCardViewState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlaybackSmallCardViewState f149980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f149981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f149982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f149983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f149984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f149985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function0 f149986g;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r110) {
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_ANIMATION);
        int r111 = this.f149980a.getSmallCardViewWidth();
        int r100 = this.f149980a.getSmallCardViewHeight();
        int r101 = this.f149980a.getProductImageSize();
        if (r111 <= 0) goto L8;
        if (r100 <= 0) goto L9;
        if (r101 <= 0) goto L10;
        int r112 = g.f149992a;
        View r113 = this.f149981b;
        int r102 = this.f149982c;
        int r103 = this.f149983d;
        View r104 = this.f149984e;
        int r105 = this.f149985f;
        PlaybackSmallCardViewState r106 = this.f149980a;
        Function0 r107 = this.f149986g;
        AnimatorSet r108 = new AnimatorSet();
        ValueAnimator r109 = ValueAnimator.ofInt(new int[]{r105, r106.getProductImageSize()});
        r109.setTarget(r104);
        r109.addUpdateListener(new c(r104));
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r102, r106.getSmallCardViewWidth()});
        r114.setTarget(r113);
        r114.addUpdateListener(new d(r113));
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{r103, r106.getSmallCardViewHeight()});
        r115.setTarget(r113);
        r115.addUpdateListener(new e(r113));
        r108.playTogether(new Animator[]{r109, r114, r115});
        r108.setDuration(300);
        r108.addListener(new f(r113, r107));
        r108.start();
        return;
    L10:
        return;
    L9:
        return;
    }

    public b(PlaybackSmallCardViewState r100, View r101, int r102, int r103, View r104, int r105, Function0 r106) {
        this.f149980a = r100;
        this.f149981b = r101;
        this.f149982c = r102;
        this.f149983d = r103;
        this.f149984e = r104;
        this.f149985f = r105;
        this.f149986g = r106;
    }
}
