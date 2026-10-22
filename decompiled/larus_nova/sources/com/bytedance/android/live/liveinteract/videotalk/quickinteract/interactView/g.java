package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f79610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f79611b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f79610a.f79607b.clearAnimation();
        this.f79610a.f79608c.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f79610a.f79606a.setText(this.f79611b);
        f r101 = this.f79610a;
        String r102 = this.f79611b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f79609d = r102;
    }

    public g(f r100, String r101) {
        this.f79610a = r100;
        this.f79611b = r101;
    }
}
