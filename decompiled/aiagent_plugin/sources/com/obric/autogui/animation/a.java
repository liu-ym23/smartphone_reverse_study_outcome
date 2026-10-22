package com.obric.autogui.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.autogui.animation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Animation.kt */
    @f(b = "Animation.kt", c = {65}, d = "invokeSuspend", e = "com.obric.autogui.animation.AnimationKt$animateTo$1")
    static final class C0719a extends l implements m<q<? super Integer>, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f28898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f28899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f28900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ TimeInterpolator f28901e;
        final /* synthetic */ boolean f;
        private /* synthetic */ Object g;

        /* JADX INFO: renamed from: com.obric.autogui.animation.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Animation.kt */
        @f(b = "Animation.kt", c = {43}, d = "invokeSuspend", e = "com.obric.autogui.animation.AnimationKt$animateTo$1$1$1")
        static final class C0720a extends l implements m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28902a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<Integer> f28903b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ValueAnimator f28904c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ q<Integer> f28905d;

            C0720a(z.f<Integer> r3, ValueAnimator r4, q<? super Integer> r5, d<? super C0720a> r6) {
                q<Integer> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
                d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
                this.f28903b = r3;
                this.f28904c = r4;
                this.f28905d = r7;
                super(2, r8);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((C0720a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0720a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r4, d<?> r5) {
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new C0720a(this.f28903b, this.f28904c, this.f28905d, r6), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28902a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L13:
                this.f28903b.f38504a = null;
                this.f28904c.resume();
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.f28903b.f38504a, Integer.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L13;
                q<Integer> r2 = this.f28905d;
                Integer r8 = d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
                this.f28902a = 1;
                if (r2.a(r8, this) != r0) goto L13;
                return r0;
            }
        }

        C0719a(int r3, int r4, long r5, TimeInterpolator r7, boolean r8, d<? super C0719a> r9) {
            TimeInterpolator r10 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r7, TimeInterpolator.class, "com.obric.aiagent.plugin");
            d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            this.f28898b = r3;
            this.f28899c = r4;
            this.f28900d = r5;
            this.f28901e = r10;
            this.f = r8;
            super(2, r11);
        }

        /* JADX INFO: renamed from: lambda$7CtTcMYS5T0Ewaj83sfEC5tOf-0, reason: not valid java name */
        public static /* synthetic */ String m791lambda$7CtTcMYS5T0Ewaj83sfEC5tOf0(int r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$GLDBLUNlSCoBFGkBWS7Gg4-JP8c, reason: not valid java name */
        public static /* synthetic */ void m792lambda$GLDBLUNlSCoBFGkBWS7Gg4JP8c(q r0, boolean r1, z.f r2, ValueAnimator r3, ValueAnimator r4) {
            a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ x lambda$cUpYOADUx9Feyfi8NXVbiM137WA(ValueAnimator r0, int r1) {
            return a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$zd9AfwoRkmhuBpYV_Y-UCfHnFyU, reason: not valid java name */
        public static /* synthetic */ String m793lambda$zd9AfwoRkmhuBpYV_YUCfHnFyU() {
            return a();
        }

        public final Object a(q<? super Integer> r3, d<? super x> r4) {
            return ((C0719a) ZeusTransformUtils.preCheckCast(create((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0719a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r11, d<?> r12) {
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
            C0719a r13 = new C0719a(this.f28898b, this.f28899c, this.f28900d, this.f28901e, this.f, r9);
            r13.g = r11;
            return (d) ZeusTransformUtils.preCheckCast(r13, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(q<? super Integer> r3, d<? super x> r4) {
            return a((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28897a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            final q r9 = (q) ZeusTransformUtils.preCheckCast(this.g, q.class, "com.obric.aiagent.plugin");
            final z.f r2 = new z.f();
            final ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{this.f28898b, this.f28899c});
            r4.setDuration(this.f28900d);
            r4.setInterpolator(this.f28901e);
            final boolean r5 = this.f;
            r4.addUpdateListener(new $$Lambda$a$a$GLDBLUNlSCoBFGkBWS7Gg4JP8c(r9, r5, r2, r4));
            r4.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnimationKt$animateTo$1$2(r9, this.f28899c), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
            r4.start();
            final int r3 = this.f28899c;
            d.h.a.a r6 = new $$Lambda$a$a$cUpYOADUx9Feyfi8NXVbiM137WA(r4, r3);
            d r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f28897a = 1;
            if (kotlinx.coroutines.a.o.a(r9, r6, r7) != r0) goto L12;
            return r0;
        }

        /* JADX WARN: Type inference failed for: r9v2, types: [T, java.lang.Integer] */
        private static final void a(q r8, boolean r9, z.f r10, ValueAnimator r11, ValueAnimator r12) {
            q r13 = (q) ZeusTransformUtils.wrapperContextForParams(r8, q.class, "com.obric.aiagent.plugin");
            Object r14 = r12.getAnimatedValue();
            d.h.b.o.a(r14, "null cannot be cast to non-null type kotlin.Float");
            int r15 = (int) ((Float) ZeusTransformUtils.preCheckCast(r14, Float.class, "com.obric.aiagent.plugin")).floatValue();
            Object r0 = r13.a_(Integer.valueOf(r15));
            if (r9 == true) goto L5;
            return;
        L5:
            if (h.a(r0) == true) goto L9;
            r10.f38504a = Integer.valueOf(r15);
            r11.pause();
            i.a((am) ZeusTransformUtils.preCheckCast(r13, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0720a(r10, r11, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            return;
        }

        private static final x a(ValueAnimator r3, final int r4) {
            Loog.INSTANCE.ep("launchTextAnimation", new $$Lambda$a$a$7CtTcMYS5T0Ewaj83sfEC5tOf0(r4), $$Lambda$a$a$zd9AfwoRkmhuBpYV_YUCfHnFyU.INSTANCE);
            r3.cancel();
            return x.f38692a;
        }

        private static final String a() {
            return "awaitClose, stack=" + Log.getStackTraceString(new Throwable());
        }

        private static final String a(int r2) {
            return "awaitClose, value=" + r2 + ", stack=" + Log.getStackTraceString(new Throwable());
        }
    }

    public static /* synthetic */ kotlinx.coroutines.b.h a(int r7, int r8, long r9, boolean r11, TimeInterpolator r12, int r13, Object r14) {
        TimeInterpolator r15 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r12, TimeInterpolator.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L5;
        r11 = false;
    L5:
        boolean r5 = r11;
        if ((r13 & 8) == 0) goto L9;
        r15 = (TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin");
    L9:
        return a(r7, r8, r9, r5, r15);
    }

    public static final kotlinx.coroutines.b.h<Integer> a(int r10, int r11, long r12, boolean r14, TimeInterpolator r15) {
        TimeInterpolator r7 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r15, TimeInterpolator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "interpolator");
        kotlinx.coroutines.b.h r13 = j.b((m) ZeusTransformUtils.preCheckCast(new C0719a(r10, r11, r12, r7, r14, null), m.class, "com.obric.aiagent.plugin"));
        if (r14 == false) goto L5;
        int r16 = 0;
    L7:
        return j.a(j.b(j.a(r13, r16, null, 2, null)), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"));
    L5:
        r16 = Integer.MAX_VALUE;
        goto L7
    }
}
