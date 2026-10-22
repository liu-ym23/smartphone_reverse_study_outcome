package com.bytedance.android.live.liveinteract.animation;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w extends BaseAnimationListener {
    public w() {
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (r101 < (r100.getFrameCount() - 1)) goto L6;
        r100.stop();
        return;
    }
}
