package com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.Choreographer;
import android.view.View;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.animate.frame.ValueFrameAnimator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ObjectAnimatorCompat extends Animator {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f129752l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f129753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f129754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueFrameAnimator.b f129755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f129756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f129757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f129758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TimeInterpolator f129759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f129760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super Float, Unit> f129761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f129762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f129763k;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/anim/compat/ObjectAnimatorCompat$Method;", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface Method {
    }

    public static final class a {
        public static ObjectAnimatorCompat a(View r100, @Method String r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, e.f25671s);
            ObjectAnimatorCompat r104 = new ObjectAnimatorCompat();
            r104.setTarget(r100);
            ((ArrayList) r104.f129754b).add(r101);
            r104.f129756d = r102;
            r104.f129757e = r103;
            return r104;
        }
    }

    static {
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return 0;
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long r100) {
    }

    @Override // android.animation.Animator
    public final void start() {
        this.f129755c = new ValueFrameAnimator.b("ObjectAnimatorCompat", 60, this.f129758f, false, 0, 0, new ObjectAnimatorCompat$initAnimator$1(this), this.f129762j, this.f129763k, null, null);
        super.start();
        ValueFrameAnimator.b r100 = this.f129755c;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        this.f129760h = true;
    }

    public ObjectAnimatorCompat() {
        this.f129754b = new ArrayList();
        this.f129757e = 1.0f;
        this.f129758f = 1000;
        this.f129761i = new ObjectAnimatorCompat$onAnimateUpdatedListener$1(this);
        this.f129762j = new ObjectAnimatorCompat$onAnimateStartListener$1(this);
        this.f129763k = new ObjectAnimatorCompat$onAnimateEndListener$1(this);
    }

    @Override // android.animation.Animator
    public final void cancel() {
        super.cancel();
        ValueFrameAnimator.b r100 = this.f129755c;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        this.f129760h = false;
    }

    @Override // android.animation.Animator
    public final void pause() {
        super.pause();
        ValueFrameAnimator.b r100 = this.f129755c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f158866a == null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L16;
        r100.f158869d = System.currentTimeMillis() - r100.f158868c;
        r100.f158870e = true;
        r100.f158872g = true;
        com.bytedance.android.livesdk.utils.animate.frame.a.ChoreographerFrameCallbackC2429a r102 = r100.f158866a;
        if (r102 == null) goto L15;
        Choreographer.getInstance().removeFrameCallback(r102);
        r100.f158866a = null;
        return;
    L15:
        return;
    L16:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.animation.Animator
    public final void resume() {
        super.resume();
        this.f129760h = true;
        ValueFrameAnimator.b r100 = this.f129755c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f158872g == false) goto L10;
        r100.f158872g = false;
        r100.d();
        return;
    }

    @Override // android.animation.Animator
    public final long getDuration() {
        return this.f129758f;
    }

    @Override // android.animation.Animator
    public final TimeInterpolator getInterpolator() {
        return this.f129759g;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return this.f129760h;
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener r100) {
        super.addListener(r100);
    }

    @Override // android.animation.Animator
    public final void addPauseListener(Animator.AnimatorPauseListener r100) {
        super.addPauseListener(r100);
        if (v.a() == true) goto L6;
        return;
    L6:
        throw new IllegalAccessException("not support");
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long r100) {
        this.f129758f = r100;
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator r100) {
        this.f129759g = r100;
    }

    @Override // android.animation.Animator
    public final void setTarget(Object r100) {
        if ((r100 instanceof View) == false) goto L7;
        this.f129753a = new WeakReference(r100);
        return;
    L7:
        throw new IllegalArgumentException("must be a view");
    }
}
