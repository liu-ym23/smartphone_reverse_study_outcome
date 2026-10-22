package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftComboProgressBar f126880a;

    public q(GiftComboProgressBar r100) {
        this.f126880a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        GiftComboProgressBar r101 = this.f126880a;
        Animator r102 = r101.f126797r;
        if (r102 == null) goto L5;
        c.a(r102);
    L5:
        Animator r103 = r101.f126799t;
        if (r103 != null) goto L8;
    L10:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r101.f126798s, 0.0f});
        r104.setDuration(1300);
        r104.setStartDelay(0);
        r104.addUpdateListener(new l(r101));
        r104.addListener(new m(r101));
        Unit r105 = Unit.INSTANCE;
        r101.f126799t = r104;
        r104.start();
        return;
    L8:
        if (r103.isRunning() != true) goto L10;
    }
}
