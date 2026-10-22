package c91;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f22834a;

    public b(a r100) {
        this.f22834a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup.LayoutParams r101 = this.f22834a.f22823a.getLayoutParams();
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.width = ((Integer) r102).intValue();
        this.f22834a.f22823a.requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
