package com.bytedance.android.shopping.new_cart.widgets;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ECCartLoadingView> f179501a;

    public n(ECCartLoadingView r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.f179501a = new WeakReference(r100);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        ECCartLoadingView r101 = this.f179501a.get();
        if (r101 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, "animator");
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L13;
        float r103 = ((Float) r102).floatValue();
        CartObjectContainer r104 = r101.f179458i;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L9:
        float r105 = r103 * r104.f178937g.k4();
        View r106 = r101.f179460k;
        if (r106 == null) goto L15;
        r106.setTranslationX(r105);
        return;
    L15:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
