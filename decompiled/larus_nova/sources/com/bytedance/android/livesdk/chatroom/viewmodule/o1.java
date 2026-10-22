package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ValueAnimator;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class o1 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f115321a;

    public o1(s1 r100) {
        this.f115321a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) this.f115321a.f115453q.getAnimatedValue()).intValue();
        UIUtils.updateLayout(this.f115321a.f115440d, Math.max(r101, 1), -3);
    }
}
