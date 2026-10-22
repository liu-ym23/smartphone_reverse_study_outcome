package com.obric.autoaction.vdplayer.d.a;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: SimpleCountDownTimer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final am f25456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<Long, x> f25457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<x> f25458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f25459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f25460e;
    private ca f;
    private boolean g;

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SimpleCountDownTimer.kt */
    @f(b = "SimpleCountDownTimer.kt", c = {39}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.vm.countdown.SimpleCountDownTimer$start$1")
    static final class C0624a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f25461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f25462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f25463c;

        C0624a(a r3, d<? super C0624a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f25463c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0624a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0624a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0624a(this.f25463c, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:14:0x0050). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25462b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r3 = this.f25461a;
            o.a(r8);
        L14:
            r3 = r3 - a.c(this.f25463c);
        L10:
            if (r3 <= 0) goto L15;
            a.b(this.f25463c).invoke(d.c.b.a.b.a(r3));
            long r5 = a.c(this.f25463c);
            d r9 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25461a = r3;
            this.f25462b = 1;
            if (ax.a(r5, r9) != r0) goto L14;
            return r0;
        L15:
            a.d(this.f25463c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            r3 = a.a(this.f25463c);
            goto L10
        }
    }

    public a(am r3, b<? super Long, x> r4, d.h.a.a<x> r5, long r6, long r8) {
        am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        b<Long, x> r9 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "scope");
        d.h.b.o.e(r9, "onTick");
        d.h.b.o.e(r10, "onFinish");
        this.f25456a = r7;
        this.f25457b = r9;
        this.f25458c = r10;
        this.f25459d = r6;
        this.f25460e = r8;
    }

    public /* synthetic */ a(am r6, b r7, d.h.a.a r8, long r9, long r11, int r13, h r14) {
        am r10 = (am) ZeusTransformUtils.wrapperContextForParams(r6, am.class, "com.obric.aiagent.plugin");
        b r15 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L5;
        r9 = 8000;
    L5:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L8;
        r11 = 1000;
    L8:
        this(r10, r15, r0, r1, r11);
    }

    public static final /* synthetic */ long a(a r2) {
        return r2.f25459d;
    }

    public static final /* synthetic */ b b(a r0) {
        return r0.f25457b;
    }

    public static final /* synthetic */ long c(a r2) {
        return r2.f25460e;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.d();
    }

    public final void a() {
        if (this.g == false) goto L6;
        Loog.INSTANCE.d("SimpleCountDownTimer", "Timer has already finished. Ignoring start.");
        return;
    L6:
        c();
        this.f = i.a(this.f25456a, null, null, (m) ZeusTransformUtils.preCheckCast(new C0624a(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b() {
        c();
        d();
    }

    public final void c() {
        ca r0 = this.f;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f = null;
    }

    private final void d() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        this.f25458c.invoke();
    }
}
