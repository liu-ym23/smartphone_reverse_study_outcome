package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f45479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f45480b;

    public d(Function1 r100, Function0 r101) {
        this.f45479a = r100;
        this.f45480b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f45479a.invoke(r100.getAnimatedValue());
    }
}
