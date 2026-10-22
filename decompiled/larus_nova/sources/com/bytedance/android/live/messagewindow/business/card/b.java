package com.bytedance.android.live.messagewindow.business.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomRightCommonCard f82924a;

    public b(BottomRightCommonCard r100) {
        this.f82924a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        t61.c r101 = this.f82924a.f82911r;
        if (r101 == null) goto L8;
        Function0<Unit> r102 = r101.f544657b;
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke();
        return;
    L9:
        return;
    }
}
