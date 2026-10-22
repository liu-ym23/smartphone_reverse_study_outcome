package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.animation.ValueAnimator;
import android.view.WindowManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f108667a;

    public k(m r100) {
        this.f108667a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L12;
        int r102 = ((Integer) r101).intValue();
        m r103 = this.f108667a;
        if (r103.f108693s == true) goto L14;
        WindowManager.LayoutParams r104 = r103.f108676b;
        r104.x = r102;
        r103.f108679e = r102;
        WindowManager r105 = r103.f108675a;
        if (r105 == null) goto L13;
        r105.updateViewLayout(r103.f108695u, r104);
        return;
    L13:
        return;
    L14:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
