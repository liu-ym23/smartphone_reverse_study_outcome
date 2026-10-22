package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TimeInterpolator f13151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13153e;

    public d(long r3, long r5) {
        this.f13149a = 0;
        this.f13150b = 300;
        this.f13151c = null;
        this.f13152d = 0;
        this.f13153e = 1;
        this.f13149a = r3;
        this.f13150b = r5;
    }

    public d(long r3, long r5, TimeInterpolator r7) {
        TimeInterpolator r8 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r7, TimeInterpolator.class, "com.obric.aiagent.plugin");
        this.f13149a = 0;
        this.f13150b = 300;
        this.f13151c = null;
        this.f13152d = 0;
        this.f13153e = 1;
        this.f13149a = r3;
        this.f13150b = r5;
        this.f13151c = r8;
    }

    public void a(Animator r4) {
        r4.setStartDelay(a());
        r4.setDuration(b());
        r4.setInterpolator(c());
        if (ZeusTransformUtils.instanceOf(r4, ValueAnimator.class) == false) goto L6;
        ((ValueAnimator) ZeusTransformUtils.preCheckCast(r4, ValueAnimator.class, "com.obric.aiagent.plugin")).setRepeatCount(d());
        ((ValueAnimator) ZeusTransformUtils.preCheckCast(r4, ValueAnimator.class, "com.obric.aiagent.plugin")).setRepeatMode(e());
        return;
    }

    public long a() {
        return this.f13149a;
    }

    public long b() {
        return this.f13150b;
    }

    public TimeInterpolator c() {
        TimeInterpolator r0 = this.f13151c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return a.f13143b;
    }

    public int d() {
        return this.f13152d;
    }

    public int e() {
        return this.f13153e;
    }

    static d a(ValueAnimator r7) {
        d r6 = new d(r7.getStartDelay(), r7.getDuration(), b(r7));
        r6.f13152d = r7.getRepeatCount();
        r6.f13153e = r7.getRepeatMode();
        return r6;
    }

    private static TimeInterpolator b(ValueAnimator r1) {
        TimeInterpolator r2 = r1.getInterpolator();
        if (ZeusTransformUtils.instanceOf(r2, AccelerateDecelerateInterpolator.class) == true) goto L15;
        if (r2 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r2, AccelerateInterpolator.class) == false) goto L11;
        return a.f13144c;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, DecelerateInterpolator.class) == true) goto L13;
        return r2;
    L13:
        return a.f13145d;
    L15:
        return a.f13143b;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, d.class) == true) goto L9;
        return false;
    L9:
        d r7 = (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin");
        if (a() == r7.a()) goto L13;
        return false;
    L13:
        if (b() == r7.b()) goto L16;
        return false;
    L16:
        if (d() == r7.d()) goto L19;
        return false;
    L19:
        if (e() == r7.e()) goto L22;
        return false;
    L22:
        return c().getClass().equals(r7.c().getClass());
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }
}
