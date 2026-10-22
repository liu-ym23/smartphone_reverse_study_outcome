package com.bytedance.android.livesdk.clearscreen.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.clearscreen.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f119518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ClearScreenUtils f119519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f119520c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f119520c == true) goto L5;
        this.f119518a.e(8);
    L5:
        this.f119519b.f119505l = 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f119520c == false) goto L6;
        this.f119518a.e(0);
        return;
    }

    public c(i r100, ClearScreenUtils r101, boolean r102) {
        this.f119518a = r100;
        this.f119519b = r101;
        this.f119520c = r102;
    }
}
