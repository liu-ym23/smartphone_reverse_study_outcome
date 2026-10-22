package c91;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f22841a;

    public i(a r100) {
        this.f22841a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        this.f22841a.f22828f.setClipBounds(new Rect(-((int) r102), 0, this.f22841a.f22828f.getWidth(), this.f22841a.f22828f.getHeight()));
        this.f22841a.f22828f.requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
