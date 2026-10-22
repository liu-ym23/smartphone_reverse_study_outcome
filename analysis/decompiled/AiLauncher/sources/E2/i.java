package E2;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public long f2353a;

    /* renamed from: b, reason: collision with root package name */
    public long f2354b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f2355c;

    /* renamed from: d, reason: collision with root package name */
    public int f2356d;

    /* renamed from: e, reason: collision with root package name */
    public int f2357e;

    public i(long j10, long j11) {
        this.f2355c = null;
        this.f2356d = 0;
        this.f2357e = 1;
        this.f2353a = j10;
        this.f2354b = j11;
    }

    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), valueAnimator.getInterpolator());
        iVar.f2356d = valueAnimator.getRepeatCount();
        iVar.f2357e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(f());
            valueAnimator.setRepeatMode(g());
        }
    }

    public long c() {
        return this.f2353a;
    }

    public long d() {
        return this.f2354b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f2355c;
        return timeInterpolator != null ? timeInterpolator : a.f2340b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && f() == iVar.f() && g() == iVar.g()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int f() {
        return this.f2356d;
    }

    public int g() {
        return this.f2357e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f2356d = 0;
        this.f2357e = 1;
        this.f2353a = j10;
        this.f2354b = j11;
        this.f2355c = timeInterpolator;
    }
}
