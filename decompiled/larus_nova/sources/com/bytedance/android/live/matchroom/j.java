package com.bytedance.android.live.matchroom;

import android.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f82894a = null;

    static {
        f82894a = new j();
    }

    public j() {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L13;
        float r102 = ((Float) r101).floatValue();
        if (Float.isNaN(r102) == true) goto L14;
        boolean r103 = MatchRoomLandScapeAnimUtil.f82832a;
        WeakReference<d> r104 = MatchRoomLandScapeAnimUtil.f82843l;
        if (r104 == null) goto L15;
        d r105 = r104.get();
        if (r105 == null) goto L16;
        r105.b(r102);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
