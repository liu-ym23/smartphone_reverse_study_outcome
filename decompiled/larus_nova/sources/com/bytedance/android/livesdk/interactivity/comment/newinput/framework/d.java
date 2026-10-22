package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.animation.ValueAnimator;
import android.widget.HorizontalScrollView;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f135491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f135492b;

    public d(ValueAnimator r100, b r101) {
        this.f135491a = r100;
        this.f135492b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        HorizontalScrollView r101 = this.f135492b.f135486m;
        Object r102 = this.f135491a.getAnimatedValue();
        if (r102 == null) goto L7;
        a1.p(r101, ((Integer) r102).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
