package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f135493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f135494b;

    public e(ValueAnimator r100, View r101) {
        this.f135493a = r100;
        this.f135494b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        View r101 = this.f135494b;
        Object r102 = this.f135493a.getAnimatedValue();
        if (r102 == null) goto L11;
        a1.n(r101, ((Integer) r102).intValue());
        View r103 = this.f135494b;
        Object r104 = this.f135493a.getAnimatedValue();
        if (r104 == null) goto L9;
        a1.m(r103, ((Integer) r104).intValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
