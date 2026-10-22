package cd3;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcScrollingView f23373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f23374b;

    public c(SlcScrollingView r100, int r101) {
        this.f23373a = r100;
        this.f23374b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        View r101 = this.f23373a.getChildAt(0);
        if (r101 != null) goto L5;
    L16:
        this.f23373a.c();
        return;
    L5:
        if (r101.getMeasuredWidth() != this.f23374b) goto L16;
        if ((!Intrinsics.areEqual(r100, this.f23373a.f173631b)) == false) goto L10;
        return;
    L10:
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L15;
        this.f23373a.b(((Float) r102).floatValue());
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
