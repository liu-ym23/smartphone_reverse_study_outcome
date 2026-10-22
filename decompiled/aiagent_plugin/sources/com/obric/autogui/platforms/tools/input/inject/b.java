package com.obric.autogui.platforms.tools.input.inject;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.h;
import d.c.b.a.l;
import d.c.i;
import d.f;
import d.g;
import d.h.a.m;
import d.l.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: ScreenSwipe.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ScreenSwipe";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f30269b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f30270c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f30271d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TimeInterpolator f30272e = null;

    /* JADX INFO: compiled from: ScreenSwipe.kt */
    @d.c.b.a.f(b = "ScreenSwipe.kt", c = {ApWakeEvent.OTHER_START}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.input.inject.ScreenSwipe$sendMoveEvent$2")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f30273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f30274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f30275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f30276d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f30277e;
        float f;
        float g;
        int h;
        final /* synthetic */ boolean i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;
        final /* synthetic */ float l;
        final /* synthetic */ float m;
        final /* synthetic */ float n;
        final /* synthetic */ float o;

        a(boolean r3, long r4, long r6, float r8, float r9, float r10, float r11, d.c.d<? super a> r12) {
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            this.j = r4;
            this.k = r6;
            this.l = r8;
            this.m = r9;
            this.n = r10;
            this.o = r11;
            super(2, r13);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r13, d.c.d<?> r14) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.i, this.j, this.k, this.l, this.m, this.n, this.o, r11), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.h;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            o.a(r19);
        L18:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r19);
            boolean r3 = this.i;
            long r4 = this.j;
            final long r7 = this.k;
            final float r9 = this.l;
            final float r10 = this.m;
            final float r11 = this.n;
            final float r12 = this.o;
            this.f30273a = r3;
            this.f30274b = r4;
            this.f30275c = r7;
            this.f30276d = r9;
            this.f30277e = r10;
            this.f = r11;
            this.g = r12;
            this.h = 1;
            i r14 = new i(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")));
            final d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin");
            float[] r6 = new float[2];
            r6[0] = 0.0f;
            if (r3 == false) goto L11;
            float r5 = 1.0f;
        L12:
            r6[1] = r5;
            ValueAnimator r8 = ObjectAnimator.ofFloat(r6);
            r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
            r8.setDuration(r4);
            r8.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(new ScreenSwipe$sendMoveEvent$2$1$1$1(r7, r9, r10, r11, r12), ValueAnimator.AnimatorUpdateListener.class, "com.obric.aiagent.plugin"));
            r8.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new ScreenSwipe$sendMoveEvent$2$1$1$2(r15), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
            r8.start();
            Object r13 = r14.a();
            if (r13 != d.c.a.b.a()) goto L15;
            h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L15:
            if (r13 != r1) goto L18;
            return r1;
        L11:
            r5 = 0.99f;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.input.inject.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScreenSwipe.kt */
    @d.c.b.a.f(b = "ScreenSwipe.kt", c = {182}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.input.inject.ScreenSwipe$sendMoveEventV2$2")
    static final class C0811b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f30279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f30280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f30281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f30282e;
        float f;
        int g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ float j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;
        final /* synthetic */ float m;

        C0811b(long r3, long r5, float r7, float r8, float r9, float r10, d.c.d<? super C0811b> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            this.i = r5;
            this.j = r7;
            this.k = r8;
            this.l = r9;
            this.m = r10;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0811b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0811b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0811b(this.h, this.i, this.j, this.k, this.l, this.m, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.g;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r14);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r14);
            long r3 = this.h;
            final long r6 = this.i;
            final float r8 = this.j;
            final float r9 = this.k;
            final float r10 = this.l;
            final float r11 = this.m;
            this.f30278a = r3;
            this.f30279b = r6;
            this.f30280c = r8;
            this.f30281d = r9;
            this.f30282e = r10;
            this.f = r11;
            this.g = 1;
            i r2 = new i(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")));
            final d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
            ValueAnimator r12 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r12.setInterpolator(b.a());
            r12.setDuration(r3);
            r12.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(new ScreenSwipe$sendMoveEventV2$2$1$1$1(r6, r8, r9, r10, r11), ValueAnimator.AnimatorUpdateListener.class, "com.obric.aiagent.plugin"));
            r12.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new ScreenSwipe$sendMoveEventV2$2$1$1$2(r15), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
            r12.start();
            Object r16 = r2.a();
            if (r16 != d.c.a.b.a()) goto L11;
            h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L11:
            if (r16 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ScreenSwipe.kt */
    @d.c.b.a.f(b = "ScreenSwipe.kt", c = {224}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.input.inject.ScreenSwipe$stabilizeEndPosition$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f30284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f30285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f30286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f30287e;
        int f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ float i;

        c(long r3, float r5, float r6, d.c.d<? super c> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            this.h = r5;
            this.i = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.g, this.h, this.i, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0055 -> B:6:0x001a). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r27) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            int r3 = this.f30284b;
            float r4 = this.f30287e;
            float r5 = this.f30286d;
            long r6 = this.f30285c;
            int r8 = this.f30283a;
            o.a(r27);
        L6:
            float r18 = r4;
            float r19 = r5;
            int r22 = r8;
            r6 = r6;
            e.a(e.f30311a, 2, r6, SystemClock.uptimeMillis(), r19, r18, 1.0f, 0, null, null, 448, null);
            r3 = r3 + 1;
            r4 = r18;
            r5 = r19;
            r8 = r22;
        L10:
            if (r3 >= r8) goto L16;
            this.f30283a = r8;
            this.f30285c = r6;
            this.f30286d = r5;
            this.f30287e = r4;
            this.f30284b = r3;
            this.f = 1;
            if (ax.a(16, this) != r1) goto L6;
            return r1;
        L16:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r27);
            long r7 = this.g;
            r8 = 3;
            r3 = 0;
            r5 = this.h;
            r4 = this.i;
            r6 = r7;
            goto L10
        }
    }

    /* JADX INFO: compiled from: ScreenSwipe.kt */
    @d.c.b.a.f(b = "ScreenSwipe.kt", c = {92, 94, 99, 113}, d = "swipe", e = "com.obric.autogui.platforms.tools.input.inject.ScreenSwipe")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f30291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f30292e;
        float f;
        float g;
        boolean h;
        long i;
        long j;
        /* synthetic */ Object k;
        final /* synthetic */ b l;
        int m;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.k = r10;
            this.m |= Integer.MIN_VALUE;
            return this.l.a(0.0f, 0.0f, 0.0f, 0.0f, 0, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$Mhj869e-A0JFZhZ6RhJFR0jEdFQ, reason: not valid java name */
    public static /* synthetic */ long m861lambda$Mhj869eA0JFZhZ6RhJFR0jEdFQ() {
        return e();
    }

    public static /* synthetic */ boolean lambda$Og6I95u3yOeJ0aQ4a3xf4rNOlUQ() {
        return f();
    }

    /* JADX INFO: renamed from: lambda$bxTxN-tz8WVUByubKItpkF-fX2A, reason: not valid java name */
    public static /* synthetic */ boolean m862lambda$bxTxNtz8WVUByubKItpkFfX2A() {
        return d();
    }

    public static /* synthetic */ float lambda$jC8o0aeyxxoDPPKw5SNXejue5JM(float r0) {
        return a(r0);
    }

    private b() {
    }

    public static final /* synthetic */ TimeInterpolator a() {
        return f30272e;
    }

    static {
        f30268a = new b();
        f30269b = g.a($$Lambda$b$bxTxNtz8WVUByubKItpkFfX2A.INSTANCE);
        f30270c = g.a($$Lambda$b$Mhj869eA0JFZhZ6RhJFR0jEdFQ.INSTANCE);
        f30271d = g.a($$Lambda$b$Og6I95u3yOeJ0aQ4a3xf4rNOlUQ.INSTANCE);
        f30272e = $$Lambda$b$jC8o0aeyxxoDPPKw5SNXejue5JM.INSTANCE;
    }

    private final boolean b() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f30269b.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean d() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("opt_config.swipe_v2_enable", true);
    }

    private final long c() {
        return ((Number) ZeusTransformUtils.preCheckCast(f30270c.b(), Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    private static final long e() {
        return n.a(AutoActionConfigs.INSTANCE.getLongCfg("opt_config.swipe_v2_max_duration_ms", 400), 100);
    }

    private static final boolean f() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("operator.screen.swipe_fix", true);
    }

    private static final float a(float r4) {
        return (float) Math.sin((((double) r4) * 3.141592653589793d) / ((double) 2));
    }

    public final Object a(float r36, float r37, float r38, float r39, long r40, boolean r42, d.c.d<? super com.obric.autogui.common.e> r43) {
        b r11 = this;
        float r10 = r36;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r43, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r3.m & Integer.MIN_VALUE) == 0) goto L7;
        r3.m -= Integer.MIN_VALUE;
    L8:
        d r5 = r3;
        Object r2 = r5.k;
        Object r4 = d.c.a.b.a();
        int r6 = r5.m;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        long r7 = r5.i;
        float r0 = r5.g;
        float r8 = r5.f;
        float r9 = r5.f30292e;
        float r12 = r5.f30291d;
        com.obric.autogui.common.e r13 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f30290c, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        x r14 = (x) ZeusTransformUtils.preCheckCast(r5.f30289b, x.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f30288a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L53:
        com.obric.autogui.common.e r16 = r13;
        float r17 = r12;
        long r18 = r7;
    L55:
        if (r15.g() == false) goto L63;
        if (d.h.b.o.a(r14, x.f38692a) == false) goto L63;
        if (r16.g() == false) goto L63;
        return com.obric.autogui.common.e.f29014b.a();
    L63:
        return com.obric.autogui.common.b.a(com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platfom_input_swipe_failed_system, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platfom_input_swipe_failed_system"), null, 2, null), "swipe_error", "sX=" + r17 + ", sY=" + r9 + ", eX=" + r8 + ", eY=" + r0 + ", d=" + r18 + ", down=" + r15.h() + ", mov=" + r14 + ", up=" + r16.h(), false, null, 0, 28, null);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r19 = r5.j;
        r18 = r5.i;
        float r20 = r5.g;
        float r110 = r5.f;
        float r111 = r5.f30292e;
        float r112 = r5.f30291d;
        x r113 = (x) ZeusTransformUtils.preCheckCast(r5.f30290c, x.class, "com.obric.aiagent.plugin");
        com.obric.autogui.common.e r114 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f30289b, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        b r21 = (b) ZeusTransformUtils.preCheckCast(r5.f30288a, b.class, "com.obric.aiagent.plugin");
        o.a(r2);
        Object r115 = r4;
        float r22 = r112;
        float r116 = r110;
        float r117 = r20;
        d r23 = r5;
    L45:
        r17 = r22;
        long r24 = r19;
        r9 = r111;
        r8 = r116;
        r15 = r114;
        b r25 = r21;
        r0 = r117;
        r14 = r113;
        r16 = e.a(e.f30311a, 1, r24, SystemClock.uptimeMillis(), r8, r0, 0.0f, 0, null, null, 448, null);
        if (r25.b() == false) goto L55;
        if (r18 != r25.c()) goto L55;
        r23.f30288a = r15;
        r23.f30289b = r14;
        r23.f30290c = r16;
        r23.f30291d = r17;
        r23.f30292e = r9;
        r23.f = r8;
        r23.g = r0;
        r23.i = r18;
        r23.m = 4;
        if (ax.a(100, r23) != r115) goto L52;
        return r115;
    L52:
        long r33 = r18;
        r12 = r17;
        r13 = r16;
        r7 = r33;
        goto L53
    L18:
        r19 = r5.j;
        r18 = r5.i;
        boolean r26 = r5.h;
        r117 = r5.g;
        float r118 = r5.f;
        float r119 = r5.f30292e;
        float r120 = r5.f30291d;
        r114 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f30289b, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        b r27 = (b) ZeusTransformUtils.preCheckCast(r5.f30288a, b.class, "com.obric.aiagent.plugin");
        o.a(r2);
        r115 = r4;
        d r41 = r5;
        r11 = r27;
        float r28 = r118;
    L36:
        r22 = r120;
        r116 = r28;
    L31:
        r21 = r11;
        r111 = r119;
        r113 = x.f38692a;
        if (r21.b() == true) goto L42;
        if (r26 == true) goto L42;
        r23 = r41;
    L42:
        r23 = r41;
        r23.f30288a = r21;
        r23.f30289b = r114;
        r23.f30290c = r113;
        r23.f30291d = r22;
        r23.f30292e = r111;
        r23.f = r116;
        r23.g = r117;
        r23.i = r18;
        r23.j = r19;
        r23.m = 3;
        if (r21.a(r19, r116, r117, r23) != r115) goto L45;
        return r115;
    L19:
        r19 = r5.j;
        r18 = r5.i;
        r26 = r5.h;
        float r121 = r5.g;
        float r122 = r5.f;
        r119 = r5.f30292e;
        float r123 = r5.f30291d;
        r114 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f30289b, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        b r29 = (b) ZeusTransformUtils.preCheckCast(r5.f30288a, b.class, "com.obric.aiagent.plugin");
        o.a(r2);
        r115 = r4;
        d r124 = r5;
        r11 = r29;
        float r30 = r121;
        r10 = r123;
        r116 = r122;
    L30:
        r22 = r10;
        r41 = r124;
        r117 = r30;
        goto L31
    L20:
        o.a(r2);
        if (b() == false) goto L23;
        long r31 = n.a(r40, 100, c());
    L24:
        r11.a("swipe start startX: " + r10 + ", startY: " + r37 + ", endX: " + r38 + ", endY: " + r39 + ", duration: " + r31);
        long r125 = SystemClock.uptimeMillis();
        r114 = e.a(e.f30311a, 0, r125, r125, r36, r37, 1.0f, 0, null, null, 448, null);
        if (b() == false) goto L32;
        r5.f30288a = r11;
        r5.f30289b = r114;
        r5.f30291d = r10;
        r5.f30292e = r37;
        r5.f = r38;
        r5.g = r39;
        r5.h = r42;
        r5.i = r31;
        r5.j = r125;
        r5.m = 1;
        long r126 = r31;
        r115 = r4;
        r124 = r5;
        r116 = r38;
        r119 = r37;
        if (a(r125, r36, r37, r38, r39, r126, r124) != r115) goto L29;
        return r115;
    L29:
        r30 = r39;
        r26 = r42;
        r18 = r126;
        r19 = r125;
        goto L30
    L32:
        long r127 = r31;
        r115 = r4;
        r5.f30288a = r11;
        r5.f30289b = r114;
        r5.f30291d = r10;
        r5.f30292e = r37;
        r5.f = r38;
        r5.g = r39;
        r5.h = r42;
        r5.i = r127;
        r5.j = r125;
        r5.m = 2;
        r41 = r5;
        if (a(r125, r36, r37, r38, r39, r40, r42, r41) != r115) goto L35;
        return r115;
    L35:
        r117 = r39;
        r26 = r42;
        r28 = r38;
        r19 = r125;
        r18 = r127;
        r120 = r36;
        r119 = r37;
        goto L36
    L23:
        r31 = r40;
    L7:
        r3 = new d(r11, r1);
        goto L8
    }

    private final void a(String r2) {
        Loog.INSTANCE.d(TAG, r2);
    }

    private final Object a(long r16, float r18, float r19, float r20, float r21, long r22, boolean r24, d.c.d<? super x> r25) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        Object r1 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new a(r24, r22, r16, r20, r18, r21, r19, null), m.class, "com.obric.aiagent.plugin"), r0);
        if (r1 != d.c.a.b.a()) goto L6;
        return r1;
    L6:
        return x.f38692a;
    }

    private final Object a(long r15, float r17, float r18, float r19, float r20, long r21, d.c.d<? super x> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        Object r1 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C0811b(r21, r15, r19, r17, r20, r18, null), m.class, "com.obric.aiagent.plugin"), r0);
        if (r1 != d.c.a.b.a()) goto L6;
        return r1;
    L6:
        return x.f38692a;
    }

    private final Object a(long r9, float r11, float r12, d.c.d<? super x> r13) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        Object r10 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new c(r9, r11, r12, null), m.class, "com.obric.aiagent.plugin"), r8);
        if (r10 != d.c.a.b.a()) goto L6;
        return r10;
    L6:
        return x.f38692a;
    }
}
