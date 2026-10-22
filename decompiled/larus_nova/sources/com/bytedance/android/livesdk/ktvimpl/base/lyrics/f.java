package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MvLyricViewV2 f143167a;

    public f(MvLyricViewV2 r100) {
        this.f143167a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Paint r101 = this.f143167a.getConfig().f203014i;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L9;
        r101.setAlpha(((Integer) r102).intValue());
        MvLyricViewV2 r103 = this.f143167a;
        if (r103.f143080s == true) goto L10;
        r103.invalidate();
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
