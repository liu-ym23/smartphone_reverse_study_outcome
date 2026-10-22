package Z4;

import android.graphics.Interpolator;
import android.view.animation.AnimationUtils;
import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes3.dex */
public final class e implements Runnable {
    public static final float[] f = {255.0f};
    public static final float[] g = {0.0f};
    public float[] b;
    public long d;
    public final StepOSScrollBarView e;

    /* renamed from: a, reason: collision with root package name */
    public final Interpolator f1591a = new Interpolator(1, 2);
    public int c = 0;

    public e(StepOSScrollBarView stepOSScrollBarView) {
        this.e = stepOSScrollBarView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSScrollBarView stepOSScrollBarView;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis < this.d || this.c != 1 || (stepOSScrollBarView = this.e) == null || stepOSScrollBarView.f3609B) {
            return;
        }
        int i = (int) jCurrentAnimationTimeMillis;
        float[] fArr = f;
        Interpolator interpolator = this.f1591a;
        interpolator.setKeyFrame(0, i, fArr);
        interpolator.setKeyFrame(1, i + 500, g);
        this.c = 2;
        stepOSScrollBarView.invalidate();
    }
}
