package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class u extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggTapOptimizeView.b f137958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f137959b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f137958a.f137867d;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLayerType(0, null);
        if (this.f137958a.f137872i.f137862b.b(r101) == true) goto L8;
        this.f137958a.f137872i.removeView(r101);
    L8:
        DiggTapOptimizeView.b r102 = this.f137958a;
        r102.f137872i.f137861a.remove(r102);
        if (this.f137959b.element < 5) goto L11;
        this.f137958a.f137872i.f137863c = 0;
        return;
    L11:
        if (this.f137958a.f137872i.f137863c < DiggABHelper.a().d()) goto L13;
        q4.f159129j.getClass();
        q4.f159128i = true;
        g32.d.b("DiggTapOptimizeView");
        return;
    L13:
        this.f137958a.f137872i.f137863c++;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f137958a.f137867d;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        r101.setLayerType(2, null);
        return;
    }

    public u(DiggTapOptimizeView.b r100, Ref.IntRef r101) {
        this.f137958a = r100;
        this.f137959b = r101;
    }
}
