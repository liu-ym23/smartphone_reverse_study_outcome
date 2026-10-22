package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickShotObserveWidget f119101a;

    public m(LandscapeQuickShotObserveWidget r100) {
        this.f119101a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        View r101 = this.f119101a.contentView;
        if (r101 == null) goto L6;
        r101.setAlpha(1 - r100.getAnimatedFraction());
    L6:
        if (r100.getAnimatedFraction() != 1.0f) goto L9;
        LandscapeQuickShotObserveWidget r102 = this.f119101a;
        int r103 = LandscapeQuickShotObserveWidget.f118952o;
        r102.xq();
        return;
    }
}
