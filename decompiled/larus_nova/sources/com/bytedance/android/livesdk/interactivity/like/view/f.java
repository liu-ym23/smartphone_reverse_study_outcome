package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.config.v50;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSelfDiggOptimizeView.c f137938a;

    public f(BottomSelfDiggOptimizeView.c r100) {
        this.f137938a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        v50 r101 = v50.f121422a;
        if (r101.getValue().booleanValue() == false) goto L5;
        BottomSelfDiggOptimizeView.c r102 = this.f137938a;
        ((LinkedList) r102.f137786g.f137765a).remove(r102);
    L5:
        BottomSelfDiggOptimizeView.c r103 = this.f137938a;
        ImageView r104 = r103.f137784e;
        if (r104 != null) goto L9;
        return;
    L9:
        if (r103.f137786g.f137766b == false) goto L12;
        r104.setLayerType(0, null);
    L12:
        if (this.f137938a.f137786g.f137767c.b(r104) == true) goto L14;
        this.f137938a.f137786g.removeView(r104);
    L14:
        BottomSelfDiggOptimizeView.c r105 = this.f137938a;
        ImageView r106 = r105.f137783d;
        if (r106 != null) goto L18;
        return;
    L18:
        if (r105.f137786g.f137766b == false) goto L21;
        r104.setLayerType(0, null);
    L21:
        if (this.f137938a.f137786g.f137767c.b(r106) == true) goto L24;
        this.f137938a.f137786g.removeView(r106);
    L24:
        if (r101.getValue().booleanValue() == true) goto L27;
        BottomSelfDiggOptimizeView.c r107 = this.f137938a;
        ((LinkedList) r107.f137786g.f137765a).remove(r107);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f137938a.f137783d;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
        if (this.f137938a.f137786g.f137766b == false) goto L7;
        r101.setLayerType(2, null);
    L7:
        ImageView r102 = this.f137938a.f137784e;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
        if (this.f137938a.f137786g.f137766b == false) goto L14;
        r102.setLayerType(2, null);
        return;
    L14:
        return;
    }
}
