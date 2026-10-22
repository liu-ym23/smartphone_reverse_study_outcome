package l2;

import android.graphics.Interpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.stepos.alphame.utils.Property;
import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public static final float[] f13497f = {255.0f};

    /* renamed from: g, reason: collision with root package name */
    public static final float[] f13498g = {Property.DEFAULT_FLOAT_VALUE};

    /* renamed from: b, reason: collision with root package name */
    public float[] f13500b;

    /* renamed from: d, reason: collision with root package name */
    public long f13502d;

    /* renamed from: e, reason: collision with root package name */
    public final View f13503e;

    /* renamed from: a, reason: collision with root package name */
    public final Interpolator f13499a = new Interpolator(1, 2);

    /* renamed from: c, reason: collision with root package name */
    public int f13501c = 0;

    public e(View view) {
        this.f13503e = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis < this.f13502d || this.f13501c != 1) {
            return;
        }
        View view = this.f13503e;
        if (!(view instanceof StepOSScrollBarView) || ((StepOSScrollBarView) view).f11404B) {
            return;
        }
        int i4 = (int) jCurrentAnimationTimeMillis;
        Interpolator interpolator = this.f13499a;
        interpolator.setKeyFrame(0, i4, f13497f);
        interpolator.setKeyFrame(1, i4 + 500, f13498g);
        this.f13501c = 2;
        view.invalidate();
    }
}
