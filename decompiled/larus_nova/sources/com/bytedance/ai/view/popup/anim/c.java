package com.bytedance.ai.view.popup.anim;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f37897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimController f37898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f37899c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f37898b.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r101 = this.f37899c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f37898b.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r101 = this.f37899c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f37897a.setVisibility(0);
        this.f37898b.a(AnimController.AnimProcessType.DOING, false, AnimationStyle.ZOOM.getValue());
    }

    public c(View r100, AnimController r101, com.bytedance.ai.view.popup.a r102) {
        this.f37897a = r100;
        this.f37898b = r101;
        this.f37899c = r102;
    }
}
