package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f126934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f126935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f126936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboView f126937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f126938e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126936c = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f126936c == false) goto L5;
        return;
    L5:
        Runnable r101 = this.f126938e;
        if (r101 == null) goto L8;
        r101.run();
    L8:
        this.f126937d.setVisibility(8);
        this.f126935b = Long.valueOf(System.currentTimeMillis());
        this.f126936c = false;
        StringBuilder r102 = new StringBuilder("show time:");
        Long r103 = this.f126935b;
        long r104 = 0;
        if (r103 == null) goto L11;
        long r105 = r103.longValue();
    L12:
        Long r106 = this.f126934a;
        if (r106 == null) goto L15;
        r104 = r106.longValue();
    L15:
        r102.append(r105 - r104);
        r102.append("ms");
        jy0.b.d("GiftRareShopComboView", r102.toString());
        return;
    L11:
        r105 = 0;
        goto L12
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f126934a = Long.valueOf(System.currentTimeMillis());
    }

    public l(GiftRareShopComboView r100, com.bytedance.android.livesdk.gift.biggift.view.d r101) {
        this.f126937d = r100;
        this.f126938e = r101;
    }
}
