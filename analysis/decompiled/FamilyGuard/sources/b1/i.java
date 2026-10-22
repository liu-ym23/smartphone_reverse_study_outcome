package b1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private long f11797a;

    /* renamed from: b, reason: collision with root package name */
    private long f11798b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f11799c;

    /* renamed from: d, reason: collision with root package name */
    private int f11800d;

    /* renamed from: e, reason: collision with root package name */
    private int f11801e;

    public i(long j5, long j6) {
        this.f11799c = null;
        this.f11800d = 0;
        this.f11801e = 1;
        this.f11797a = j5;
        this.f11798b = j6;
    }

    static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), valueAnimator.getInterpolator());
        iVar.f11800d = valueAnimator.getRepeatCount();
        iVar.f11801e = valueAnimator.getRepeatMode();
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
        return this.f11797a;
    }

    public long d() {
        return this.f11798b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f11799c;
        return timeInterpolator != null ? timeInterpolator : C0553a.f11784b;
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
        return this.f11800d;
    }

    public int g() {
        return this.f11801e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public i(long j5, long j6, TimeInterpolator timeInterpolator) {
        this.f11800d = 0;
        this.f11801e = 1;
        this.f11797a = j5;
        this.f11798b = j6;
        this.f11799c = timeInterpolator;
    }
}
