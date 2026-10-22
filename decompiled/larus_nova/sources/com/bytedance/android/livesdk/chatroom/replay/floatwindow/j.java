package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f108666a;

    public j(m r100) {
        this.f108666a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue("x");
        if (r101 == null) goto L11;
        int r102 = ((Integer) r101).intValue();
        Object r103 = r100.getAnimatedValue("y");
        if (r103 == null) goto L9;
        int r104 = ((Integer) r103).intValue();
        this.f108666a.c(r102, r104);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
