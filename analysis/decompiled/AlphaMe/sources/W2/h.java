package W2;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class h extends B0.f {

    /* renamed from: b, reason: collision with root package name */
    public final ValueAnimator f2030b = new ValueAnimator();

    @Override // B0.f
    public final void A0() {
        this.f2030b.start();
    }

    @Override // B0.f
    public final boolean R() {
        return this.f2030b.isRunning();
    }

    @Override // B0.f
    public final void e() {
        this.f2030b.cancel();
    }

    @Override // B0.f
    public final void s0(int i4) {
        this.f2030b.setDuration(i4);
    }

    @Override // B0.f
    public final void t0(float f4, float f5) {
        this.f2030b.setFloatValues(f4, f5);
    }

    @Override // B0.f
    public final void u0(Interpolator interpolator) {
        this.f2030b.setInterpolator(interpolator);
    }

    @Override // B0.f
    public final float w() {
        return ((Float) this.f2030b.getAnimatedValue()).floatValue();
    }

    @Override // B0.f
    public final void y0(e eVar) {
        this.f2030b.addUpdateListener(new g(eVar));
    }
}
