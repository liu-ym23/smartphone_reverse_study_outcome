package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomDiggTapView.c f137944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f137945b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        CustomDiggTapView.c r101 = this.f137944a;
        ImageView r102 = r101.f137807d;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r101.f137811h.f137797b.b(r102) == true) goto L8;
        this.f137944a.f137811h.removeView(r102);
    L8:
        CustomDiggTapView.c r103 = this.f137944a;
        r103.f137811h.f137796a.remove(r103);
        if (this.f137945b.element >= 5) goto L12;
        q4.f159129j.getClass();
        q4.f159128i = true;
        g32.d.b("CustomDiggTapView");
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f137944a.f137807d;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }

    public j(CustomDiggTapView.c r100, Ref.IntRef r101) {
        this.f137944a = r100;
        this.f137945b = r101;
    }
}
