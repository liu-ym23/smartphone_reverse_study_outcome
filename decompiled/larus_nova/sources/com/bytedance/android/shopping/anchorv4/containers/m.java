package com.bytedance.android.shopping.anchorv4.containers;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes12.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f166225a;

    public m(Ref.ObjectRef r100) {
        this.f166225a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        c r101 = (c) this.f166225a.element;
        if (r101 == null) goto L6;
        r101.invalidate();
        return;
    }
}
