package bi3;

import android.animation.ValueAnimator;
import android.view.Window;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f19098a;

    public f(Window r100) {
        this.f19098a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L11;
        float r102 = ((Float) r101).floatValue();
        this.f19098a.setDimAmount(r102);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
