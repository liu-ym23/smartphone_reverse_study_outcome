package com.bytedance.android.livesdk.utils.animate.frame;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class ValueFrameAnimator extends ValueAnimator {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f158837q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f158838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f158839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f158840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f158841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f158842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f158843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TimeInterpolator f158844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TypeEvaluator<Object> f158845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<ValueAnimator.AnimatorUpdateListener> f158846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<Float, Unit> f158847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f158848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f158849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f158850m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Unit> f158851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f158852o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<Float, Object> f158853p;

    public static final class Companion {
        @JvmStatic
        public static ValueFrameAnimator a(float... r100) {
            Intrinsics.checkNotNullParameter(r100, "values");
            return new ValueFrameAnimator(r100, AnonymousClass1.INSTANCE);
        }

        @JvmStatic
        public static ValueFrameAnimator b(int... r100) {
            Intrinsics.checkNotNullParameter(r100, "values");
            int r101 = r100.length;
            float[] r102 = new float[r101];
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L6;
            r102[r103] = r100[r103];
            r103 = r103 + 1;
            goto L3
        L6:
            return new ValueFrameAnimator(r102, ValueFrameAnimator$Companion$ofInt$1.INSTANCE);
        }
    }

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosedFloatingPointRange<Float> f158854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f158855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f158856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f158857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f158858e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ValueFrameAnimator f158859f;

        public a(ValueFrameAnimator r100, float r101, float r102, float r103, float r104) {
            this.f158859f = r100;
            this.f158855b = r101;
            this.f158856c = r102;
            this.f158857d = r103;
            this.f158858e = r104;
            this.f158854a = RangesKt.rangeTo(r103, r104);
        }
    }

    public static final class b extends com.bytedance.android.livesdk.utils.animate.frame.a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f158860o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Function1<Float, Unit> f158861p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Function0<Unit> f158862q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Function0<Unit> f158863r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Function0<Unit> f158864s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final Function0<Unit> f158865t;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r110, int r111, long r112, boolean r113, int r114, long r210, Function1<? super Float, Unit> r211, Function0<Unit> r212, Function0<Unit> r213, Function0<Unit> r214, Function0<Unit> r215) {
            Intrinsics.checkNotNullParameter(r110, "name");
            Intrinsics.checkNotNullParameter(r211, "onAnimateFractionUpdatedListener");
            Intrinsics.checkNotNullParameter(r212, "onAnimateStartListener");
            Intrinsics.checkNotNullParameter(r213, "onAnimateEndListener");
            super(r110, r111, r112, r210, r113, r114);
            this.f158861p = r211;
            this.f158862q = r212;
            this.f158863r = r213;
            this.f158864s = r214;
            this.f158865t = r215;
        }
    }

    static {
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void pause() {
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void resume() {
    }

    @Override // android.animation.ValueAnimator
    public final void reverse() {
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        b r100 = this.f158839b;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        b r100 = this.f158839b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f158860o;
    }

    @Override // android.animation.Animator
    public final boolean isPaused() {
        b r100 = this.f158839b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f158872g;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        b r100 = this.f158839b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f158866a != null) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        this.f158846i.clear();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void start() {
        int r100 = (int) ((this.f158842e / 1000) * 60);
        int r101 = getRepeatCount();
        if (r101 <= 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        b r103 = new b(this.f158840c, r100, this.f158842e, r102, r101, this.f158841d, new ValueFrameAnimator$initAnimator$1(this), this.f158848k, this.f158849l, this.f158850m, this.f158851n);
        this.f158839b = r103;
        r103.d();
        return;
    L5:
        if (r101 == (-1)) goto L8;
        r102 = false;
        goto L9
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return this.f158843f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        return this.f158842e;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final TimeInterpolator getInterpolator() {
        return this.f158844g;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getStartDelay() {
        return this.f158841d;
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f158846i.add(r100);
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue(String r100) {
        return super.getAnimatedValue(r100);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f158846i.remove(r100);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final Animator setDuration(long r100) {
        this.f158842e = r100;
        return this;
    }

    @Override // android.animation.ValueAnimator
    public final void setEvaluator(TypeEvaluator<?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f158845h = r100;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setInterpolator(TimeInterpolator r100) {
        this.f158844g = r100;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long r100) {
        this.f158841d = r100;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final ValueAnimator setDuration(long r100) {
        this.f158842e = r100;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ValueFrameAnimator(float[] r110, Function1<? super Float, ? extends Object> r111) {
        this.f158852o = r110;
        this.f158853p = r111;
        this.f158838a = new ArrayList(r110.length);
        int r112 = r110.length - 1;
        float r113 = 1.0f / r112;
        int r100 = 0;
    L3:
        if (r100 >= r112) goto L5;
        float[] r101 = this.f158852o;
        int r102 = r100 + 1;
        this.f158838a.add(new a(this, r101[r100], r101[r102], r100 * r113, r102 * r113));
        r100 = r102;
        goto L3
    L5:
        this.f158840c = "ValueFrameAnimator";
        this.f158842e = 1000;
        this.f158846i = new ArrayList();
        this.f158847j = new ValueFrameAnimator$onAnimateUpdatedListener$1(this);
        this.f158848k = new ValueFrameAnimator$onAnimateStartListener$1(this);
        this.f158849l = new ValueFrameAnimator$onAnimateEndListener$1(this);
        this.f158850m = new ValueFrameAnimator$onAnimateRepeatListener$1(this);
        this.f158851n = new ValueFrameAnimator$onAnimateCancelListener$1(this);
    }
}
