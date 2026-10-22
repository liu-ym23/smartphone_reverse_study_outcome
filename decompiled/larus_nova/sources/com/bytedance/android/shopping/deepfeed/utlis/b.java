package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductSlcView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f173968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f173969b;

    public b(DeepFeedProductSlcView r100, Function0 r101) {
        this.f173968a = r100;
        this.f173969b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        ViewGroup.LayoutParams r103 = this.f173968a.getLayoutParams();
        r103.height = r102;
        this.f173968a.setLayoutParams(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
