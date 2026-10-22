package com.obric.autogui.session.state;

import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;

/* JADX INFO: compiled from: AOSessionBaseState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends com.obric.autogui.util.c.a {
    private static final String TAG = "AO-Ses-BState";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0853a f31211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BizStatus f31212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f31213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.session.state.b f31214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f31215e;
    private BizStatus.StatusChangedReasonStruct f;

    /* JADX INFO: renamed from: com.obric.autogui.session.state.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSessionBaseState.kt */
    public static final class C0853a {
        public /* synthetic */ C0853a(h r1) {
            this();
        }

        private C0853a() {
        }
    }

    /* JADX INFO: compiled from: AOSessionBaseState.kt */
    @d.c.b.a.f(b = "AOSessionBaseState.kt", c = {49, 51}, d = "changeTo", e = "com.obric.autogui.session.state.AOSessionBaseState")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f31219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f31220e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31211a = new C0853a(null);
    }

    public Object a(a r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object b(a r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        return b(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public int g() {
        return 0;
    }

    public Bundle h() {
        return null;
    }

    public /* synthetic */ a(BizStatus r1, com.obric.autogui.session.a r2, com.obric.autogui.session.state.b r3, boolean r4, int r5, h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public final BizStatus b() {
        return this.f31212b;
    }

    public final com.obric.autogui.session.a d() {
        return this.f31213c;
    }

    public final com.obric.autogui.session.state.b e() {
        return this.f31214d;
    }

    public a(BizStatus r9, com.obric.autogui.session.a r10, com.obric.autogui.session.state.b r11, boolean r12) {
        o.e(r9, "bizStatus");
        o.e(r10, SensitiveType.SESSION);
        o.e(r11, "machine");
        super(r9.name());
        this.f31212b = r9;
        this.f31213c = r10;
        this.f31214d = r11;
        this.f31215e = r12;
        this.f = new BizStatus.StatusChangedReasonStruct(0, null, null, null, 15, null);
    }

    public final void a(BizStatus.StatusChangedReasonStruct r2) {
        o.e(r2, "<set-?>");
        this.f = r2;
    }

    public final BizStatus.StatusChangedReasonStruct f() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.autogui.util.c.b
    public final Object b(com.obric.autogui.util.c.b r18, d.c.d<? super com.obric.autogui.common.e> r19) {
        a r0 = this;
        com.obric.autogui.util.c.b r2 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L7;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f;
        Object r7 = d.c.a.b.a();
        int r8 = r5.h;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        long r9 = r5.f31220e;
        z.f r1 = (z.f) ZeusTransformUtils.preCheckCast(r5.f31219d, z.f.class, "com.obric.aiagent.plugin");
        z.f r3 = (z.f) ZeusTransformUtils.preCheckCast(r5.f31218c, z.f.class, "com.obric.aiagent.plugin");
        com.obric.autogui.util.c.b r10 = (com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r5.f31217b, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        a r11 = (a) ZeusTransformUtils.preCheckCast(r5.f31216a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        T r12 = r6;
    L36:
        r1.f38504a = r12;
        r0 = r11;
        long r14 = r9;
        com.obric.autogui.util.c.b r13 = r10;
    L37:
        long r15 = System.currentTimeMillis() - r14;
        if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == false) goto L40;
        Loog.INSTANCE.d(TAG, "change(" + r0.f31213c.a() + "): [" + r0.i() + "] --> [" + ((a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin")).i() + "] (done - l=" + r15 + "ms)");
    L42:
        return r3.f38504a;
    L40:
        Loog.INSTANCE.e(TAG, "change(" + r0.f31213c.a() + "): [" + r0.i() + "] --> [" + ((a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin")).i() + "] (error - l=" + r15 + "ms)");
        goto L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = r5.f31220e;
        z.f r16 = (z.f) ZeusTransformUtils.preCheckCast(r5.f31219d, z.f.class, "com.obric.aiagent.plugin");
        r3 = (z.f) ZeusTransformUtils.preCheckCast(r5.f31218c, z.f.class, "com.obric.aiagent.plugin");
        r13 = (com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r5.f31217b, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        a r17 = (a) ZeusTransformUtils.preCheckCast(r5.f31216a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        z.f r20 = r16;
        r0 = r17;
        T r21 = r6;
    L30:
        r20.f38504a = r21;
        if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == false) goto L37;
        a r22 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
        r5.f31216a = r0;
        r5.f31217b = r13;
        r5.f31218c = r3;
        r5.f31219d = r3;
        r5.f31220e = r14;
        r5.h = 2;
        Object r23 = r0.a(r22, r5);
        if (r23 != r7) goto L35;
        return r7;
    L35:
        r11 = r0;
        r1 = r3;
        r10 = r13;
        r9 = r14;
        r12 = r23;
        goto L36
    L16:
        d.o.a(r6);
        if (ZeusTransformUtils.instanceOf(r2, a.class) == true) goto L21;
        Loog.INSTANCE.e(TAG, "changed to `" + r2.getClass() + "` is not supported.");
        return com.obric.autogui.common.e.f29014b.b("unsupported");
    L21:
        if (o.a(r2.getClass(), getClass()) == true) goto L23;
    L26:
        Loog.INSTANCE.d(TAG, "change(" + r0.f31213c.a() + "): [" + i() + "] --> [" + ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).i() + "] (start)");
        r20 = new z.f();
        r14 = System.currentTimeMillis();
        a r24 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        r5.f31216a = r0;
        r5.f31217b = r2;
        r5.f31218c = r20;
        r5.f31219d = r20;
        r5.f31220e = r14;
        r5.h = 1;
        Object r25 = r24.b(r0, r5);
        if (r25 != r7) goto L29;
        return r7;
    L29:
        r21 = r25;
        r13 = r2;
        r3 = r20;
        goto L30
    L23:
        if (r0.f31215e == true) goto L26;
        Loog.INSTANCE.d(TAG, "changed to [" + i() + "]; nothing changed");
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        r5 = new b(r0, r4);
        goto L8
    }

    @Override // com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r14) {
        com.obric.autogui.util.c.b r15 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        o.e(r15, "fromState");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == true) goto L6;
        Loog.INSTANCE.w(TAG, "onEnter from a non-AOSessionBaseState: " + r15.getClass());
        return;
    L6:
        long r4 = System.currentTimeMillis();
        com.obric.autogui.b.a.f28928a.onBizStatusChanged(this.f31213c.d(), ((a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin")).f31212b, this.f31212b, g(), this.f, h());
        Loog.INSTANCE.d(TAG, "entered: [" + i() + "]; status-change triggering spent " + (System.currentTimeMillis() - r4) + "ms");
    }

    static /* synthetic */ Object a(a r0, a r1, d.c.d<? super com.obric.autogui.common.e> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    static /* synthetic */ Object b(a r0, a r1, d.c.d<? super com.obric.autogui.common.e> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }
}
