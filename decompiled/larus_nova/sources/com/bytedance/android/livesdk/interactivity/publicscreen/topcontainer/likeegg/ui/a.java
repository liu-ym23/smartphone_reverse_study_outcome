package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggView f140002a;

    public a(LikeEggView r100) {
        this.f140002a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        LikeEggProgressBar r104 = this.f140002a.f139986a;
        if (r104 == null) goto L12;
        r104.setProgress(r103);
        return;
    L12:
        return;
    }
}
