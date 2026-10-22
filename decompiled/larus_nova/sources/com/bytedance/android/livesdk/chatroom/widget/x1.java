package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x1 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitQuickShotLayerWidget f119258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f119259b;

    public x1(PortraitQuickShotLayerWidget r100, Bitmap r101) {
        this.f119258a = r100;
        this.f119259b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if ((!Intrinsics.areEqual(this.f119259b, this.f119258a.f118676e)) == false) goto L5;
        return;
    L5:
        View r101 = this.f119258a.contentView;
        if (r101 == null) goto L9;
        r101.setAlpha(1 - r100.getAnimatedFraction());
    L9:
        if (r100.getAnimatedFraction() != 1.0f) goto L12;
        this.f119258a.yq();
        return;
    }
}
