package com.obric.oui.panel.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: AnimController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f35900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f35901b;

    /* JADX INFO: compiled from: AnimController.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35902a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f35903b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f35904c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f35905d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f35902a, f35903b, f35904c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f35905d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35902a = new a("NONE", 0);
            f35903b = new a("DOING", 1);
            f35904c = new a("DONE", 2);
            f35905d = a();
        }
    }

    public static /* synthetic */ void lambda$aE2bv9QrZtZdk9EGi7CA4005tek(d.h.a.b r0, ValueAnimator r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$hLpv1KpNCHcvxMZNy5PZVQtpk-k, reason: not valid java name */
    public static /* synthetic */ void m1114lambda$hLpv1KpNCHcvxMZNy5PZVQtpkk(d.h.a.b r0, ValueAnimator r1) {
        a(r0, r1);
    }

    public b() {
        this.f35900a = a.f35902a;
        this.f35901b = a.f35902a;
    }

    public final void a(a r2) {
        o.e(r2, "<set-?>");
        this.f35900a = r2;
    }

    public final void b(a r2) {
        o.e(r2, "<set-?>");
        this.f35901b = r2;
    }

    public final void a(ObjectAnimator r3, d.h.a.b<? super Float, x> r4) {
        d.h.a.b<? super Float, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "animProgressListener");
        if (this.f35900a == a.f35902a) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        c(r3, r5).start();
    }

    private final ObjectAnimator c(ObjectAnimator r3, d.h.a.b<? super Float, x> r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnimController$getContainerEnterAnim$1(this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r3.addUpdateListener(new $$Lambda$b$hLpv1KpNCHcvxMZNy5PZVQtpkk(r5));
        return r3;
    }

    private static final void a(d.h.a.b r2, ValueAnimator r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "$animProgressListener");
        o.e(r3, "animation");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        r4.invoke(Float.valueOf(r3.getAnimatedFraction()));     // Catch: Throwable -> L5
        n.f(x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        n.f(d.o.a(th));
    }

    public final void b(ObjectAnimator r3, d.h.a.b<? super Float, x> r4) {
        d.h.a.b<? super Float, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "animProgressListener");
        if (this.f35901b == a.f35902a) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        d(r3, r5).start();
    }

    private final ObjectAnimator d(ObjectAnimator r3, d.h.a.b<? super Float, x> r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnimController$getContainerExitAnim$1(this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r3.addUpdateListener(new $$Lambda$b$aE2bv9QrZtZdk9EGi7CA4005tek(r5));
        return r3;
    }

    private static final void b(d.h.a.b r2, ValueAnimator r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "$animProgressListener");
        o.e(r3, "animation");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        n.f((x) ZeusTransformUtils.preCheckCast(r4.invoke(Float.valueOf(r3.getAnimatedFraction())), x.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        n.f(d.o.a(th));
    }
}
