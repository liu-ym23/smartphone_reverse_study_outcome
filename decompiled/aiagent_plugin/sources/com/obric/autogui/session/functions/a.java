package com.obric.autogui.session.functions;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.o;

/* JADX INFO: compiled from: AOSessionFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.obric.autogui.session.a f30966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f30968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0844a f30969d;

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSessionFunction.kt */
    public static final class C0844a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f30970a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0844a.class) == true) goto L8;
            return false;
        L8:
            C0844a r8 = (C0844a) ZeusTransformUtils.preCheckCast(r7, C0844a.class, "com.obric.aiagent.plugin");
            if (this.f30970a == r8.f30970a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f30970a);
        }

        public String toString() {
            return "StartedFunctionSession(startedAtBootTime=" + this.f30970a + ')';
        }

        public C0844a(long r1) {
            this.f30970a = r1;
        }

        public final long a() {
            return this.f30970a;
        }
    }

    /* JADX INFO: compiled from: AOSessionFunction.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f30971a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f30972b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f30973c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f30974d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f30971a, f30972b};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f30971a = new b("STOPPED", 0);
            f30972b = new b("ONGOING", 1);
            b[] r0 = a();
            f30973c = r0;
            f30974d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f30973c.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOSessionFunction.kt */
    @f(b = "AOSessionFunction.kt", c = {51}, d = "start", e = "com.obric.autogui.session.functions.AOSessionFunction")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f30977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30978d;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30977c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30976b = r3;
            this.f30978d |= Integer.MIN_VALUE;
            return this.f30977c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOSessionFunction.kt */
    @f(b = "AOSessionFunction.kt", c = {70}, d = "stop", e = "com.obric.autogui.session.functions.AOSessionFunction")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f30981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30982d;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30981c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30980b = r3;
            this.f30982d |= Integer.MIN_VALUE;
            return this.f30981c.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public Object c(d.c.d<? super e> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object d(d.c.d<? super e> r3) {
        return b(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a(String r2) {
        o.e(r2, "name");
        this.f30967b = r2;
        this.f30968c = b.f30971a;
    }

    public final String a() {
        return this.f30967b;
    }

    public final com.obric.autogui.session.a b() {
        com.obric.autogui.session.a r0 = this.f30966a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c(SensitiveType.SESSION);
        return null;
    }

    public final void a(com.obric.autogui.session.a r2) {
        o.e(r2, "<set-?>");
        this.f30966a = r2;
    }

    public final void b(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
        a(r2);
    }

    public final Object a(d.c.d<? super e> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if ((r0.f30978d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30978d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f30976b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30978d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f30975a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L21:
        e r9 = (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin");
        if (r9.g() == true) goto L24;
        return r9;
    L24:
        this.f30969d = new C0844a(AOSystemTools.INSTANCE.bootTimeMillis());
        this.f30968c = b.f30972b;
        com.obric.autogui.b.c.f28941a.onFunctionStarted(this.f30967b);
        return e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        if (this.f30968c == b.f30972b) goto L17;
        r0.f30975a = this;
        r0.f30978d = 1;
        r8 = c(r0);
        if (r8 != r2) goto L21;
        return r2;
    L17:
        return e.f29014b.a();
    L7:
        r0 = new c(this, r7);
        goto L8
    }

    public final Object b(d.c.d<? super e> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
        if ((r0.f30982d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30982d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f30980b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30982d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f30979a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L21:
        e r9 = (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin");
        if (r9.g() == true) goto L24;
        return r9;
    L24:
        this.f30969d = null;
        this.f30968c = b.f30971a;
        com.obric.autogui.b.c.f28941a.onFunctionStopped(this.f30967b);
        return e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        if (this.f30968c == b.f30971a) goto L17;
        r0.f30979a = this;
        r0.f30982d = 1;
        r8 = d(r0);
        if (r8 != r2) goto L21;
        return r2;
    L17:
        return e.f29014b.a();
    L7:
        r0 = new d(this, r7);
        goto L8
    }

    static /* synthetic */ Object a(a r3, d.c.d<? super e> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(r3.f30967b, "started `" + r3.f30967b + "`.");
        return e.f29014b.a();
    }

    static /* synthetic */ Object b(a r3, d.c.d<? super e> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(r3.f30967b, "stopped `" + r3.f30967b + "`.");
        return e.f29014b.a();
    }

    public e c() {
        return e.f29014b.a();
    }

    public final long d() {
        C0844a r0 = this.f30969d;
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(this.f30967b, "calcTimeElapsedSinceStart: mStartedFunctionSession is null.");
        return 0;
    L7:
        return AOSystemTools.INSTANCE.bootTimeMillis() - r0.a();
    }
}
