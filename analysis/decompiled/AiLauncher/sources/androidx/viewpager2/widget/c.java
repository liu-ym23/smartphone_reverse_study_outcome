package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ViewPager2 f15138a;

    /* renamed from: b, reason: collision with root package name */
    public final f f15139b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f15140c;

    /* renamed from: d, reason: collision with root package name */
    public VelocityTracker f15141d;

    /* renamed from: e, reason: collision with root package name */
    public int f15142e;

    /* renamed from: f, reason: collision with root package name */
    public float f15143f;

    /* renamed from: g, reason: collision with root package name */
    public int f15144g;

    /* renamed from: h, reason: collision with root package name */
    public long f15145h;

    public c(ViewPager2 viewPager2, f fVar, RecyclerView recyclerView) {
        this.f15138a = viewPager2;
        this.f15139b = fVar;
        this.f15140c = recyclerView;
    }

    public final void a(long j10, int i10, float f10, float f11) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.f15145h, j10, i10, f10, f11, 0);
        this.f15141d.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    public boolean b() {
        if (this.f15139b.g()) {
            return false;
        }
        this.f15144g = 0;
        this.f15143f = 0;
        this.f15145h = SystemClock.uptimeMillis();
        c();
        this.f15139b.k();
        if (!this.f15139b.i()) {
            this.f15140c.stopScroll();
        }
        a(this.f15145h, 0, 0.0f, 0.0f);
        return true;
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f15141d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f15141d = VelocityTracker.obtain();
            this.f15142e = ViewConfiguration.get(this.f15138a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    public boolean d() {
        if (!this.f15139b.h()) {
            return false;
        }
        this.f15139b.m();
        VelocityTracker velocityTracker = this.f15141d;
        velocityTracker.computeCurrentVelocity(1000, this.f15142e);
        if (this.f15140c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f15138a.p();
        return true;
    }

    public boolean e(float f10) {
        if (!this.f15139b.h()) {
            return false;
        }
        float f11 = this.f15143f - f10;
        this.f15143f = f11;
        int iRound = Math.round(f11 - this.f15144g);
        this.f15144g += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z10 = this.f15138a.getOrientation() == 0;
        int i10 = z10 ? iRound : 0;
        int i11 = z10 ? 0 : iRound;
        float f12 = z10 ? this.f15143f : 0.0f;
        float f13 = z10 ? 0.0f : this.f15143f;
        this.f15140c.scrollBy(i10, i11);
        a(jUptimeMillis, 2, f12, f13);
        return true;
    }

    public boolean f() {
        return this.f15139b.h();
    }
}
