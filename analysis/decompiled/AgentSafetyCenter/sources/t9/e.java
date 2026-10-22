package t9;

import android.graphics.Interpolator;
import android.view.animation.AnimationUtils;
import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f13284j = {255.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final float[] f13285k = {0.0f};

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f13286c;

    /* renamed from: f, reason: collision with root package name */
    public float[] f13287f;

    /* renamed from: g, reason: collision with root package name */
    public int f13288g;

    /* renamed from: h, reason: collision with root package name */
    public long f13289h;
    public StepOSScrollBarView i;

    @Override // java.lang.Runnable
    public final void run() {
        StepOSScrollBarView stepOSScrollBarView = this.i;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis < this.f13289h || this.f13288g != 1 || stepOSScrollBarView == null || stepOSScrollBarView.F) {
            return;
        }
        int i = (int) jCurrentAnimationTimeMillis;
        Interpolator interpolator = this.f13286c;
        interpolator.setKeyFrame(0, i, f13284j);
        interpolator.setKeyFrame(1, i + 500, f13285k);
        this.f13288g = 2;
        stepOSScrollBarView.invalidate();
    }
}
