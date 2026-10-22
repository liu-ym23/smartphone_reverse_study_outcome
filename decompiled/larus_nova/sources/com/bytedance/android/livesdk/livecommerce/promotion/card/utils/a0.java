package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f150301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f150302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f150303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f150304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AnimatorListenerAdapter f150305e;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f150306a;

        public a(a0 r100) {
            this.f150306a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            AnimatorListenerAdapter r101 = this.f150306a.f150305e;
            if (r101 == null) goto L6;
            r101.onAnimationEnd(r100);
            return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f150301a.setVisibility(8);
        this.f150302b.setVisibility(0);
        this.f150302b.setAlpha(0.0f);
        Runnable r101 = this.f150303c;
        if (r101 == null) goto L5;
        r101.run();
    L5:
        this.f150302b.animate().alpha(1.0f).setDuration(this.f150304d).setListener(new a(this)).start();
    }

    public a0(View r100, View r101, Runnable r102) {
        this.f150301a = r100;
        this.f150302b = r101;
        this.f150303c = r102;
        this.f150304d = 300;
        this.f150305e = null;
    }
}
