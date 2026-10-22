package com.bytedance.android.shopping.anchorv4.nav.controls;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareBtnAnimController f167142a;

    public g(ShareBtnAnimController r100) {
        this.f167142a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        b r101 = this.f167142a.f167134m;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }
}
