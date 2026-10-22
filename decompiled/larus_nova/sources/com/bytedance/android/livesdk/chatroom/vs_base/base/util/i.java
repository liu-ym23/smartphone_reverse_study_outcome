package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f117938a;

    public i(g r100) {
        this.f117938a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L11;
        float r102 = ((Float) r101).floatValue();
        wr1.b r103 = this.f117938a.f117935c;
        if (r103 == null) goto L12;
        LiveBlurAnimView r104 = r103.getView();
        if (r104 == null) goto L13;
        r104.setAlpha(1.0f - r102);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
