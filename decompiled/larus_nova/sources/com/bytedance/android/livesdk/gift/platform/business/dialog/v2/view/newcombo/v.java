package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f126948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f126949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f126950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GiftComboView f126951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f126952e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126950c = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f126950c == false) goto L5;
        return;
    L5:
        Runnable r101 = this.f126952e;
        if (r101 == null) goto L8;
        r101.run();
    L8:
        this.f126951d.setVisibility(8);
        this.f126949b = Long.valueOf(System.currentTimeMillis());
        this.f126950c = false;
        StringBuilder r102 = new StringBuilder("show time:");
        Long r103 = this.f126949b;
        long r104 = 0;
        if (r103 == null) goto L11;
        long r105 = r103.longValue();
    L12:
        Long r106 = this.f126948a;
        if (r106 == null) goto L15;
        r104 = r106.longValue();
    L15:
        r102.append(r105 - r104);
        r102.append("ms");
        jy0.b.d("GiftComboViewOpt", r102.toString());
        return;
    L11:
        r105 = 0;
        goto L12
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126948a = Long.valueOf(System.currentTimeMillis());
    }

    public v(GiftComboView r100, Runnable r101) {
        this.f126951d = r100;
        this.f126952e = r101;
    }
}
