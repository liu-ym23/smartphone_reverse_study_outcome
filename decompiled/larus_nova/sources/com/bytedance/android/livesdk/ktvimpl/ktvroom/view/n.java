package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class n extends com.bytedance.android.live.core.utils.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f145210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f145211b;

    @Override // com.bytedance.android.live.core.utils.s, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f145211b.f145138x = false;
    }

    @Override // com.bytedance.android.live.core.utils.s, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f145211b.f145138x = false;
        c r101 = this.f145211b.N;
        r101.f145263e = this.f145210a;
        c r102 = this.f145211b.M;
        r102.f145263e = this.f145210a;
        c r103 = this.f145211b.O;
        r103.f145263e = this.f145210a;
        u r104 = this.f145211b.P;
        r104.f145263e = this.f145210a;
    }

    public n(float r100, j r101) {
        this.f145210a = r100;
        this.f145211b = r101;
    }
}
