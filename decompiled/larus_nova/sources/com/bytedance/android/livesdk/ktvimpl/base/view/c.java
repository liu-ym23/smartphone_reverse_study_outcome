package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvAnchorLyricsDisplayView f143650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f143651b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        KtvAnchorLyricsDisplayView r101 = this.f143650a;
        r101.I = false;
        r101.f143587i.setEmpty();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        KtvAnchorLyricsDisplayView r101 = this.f143650a;
        r101.I = false;
        r101.f143595q = 0;
        r101.f143597s = false;
        r101.setCurShowIndex(this.f143651b);
        this.f143650a.f143587i.setEmpty();
        this.f143650a.invalidate();
    }

    public c(KtvAudienceLyricsDisplayView r100, int r101) {
        this.f143650a = r100;
        this.f143651b = r101;
    }
}
