package com.obric.autogui.agents;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AOAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC0655a f26117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ca f26118b;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOAgent.kt */
    public static final enum EnumC0655a extends Enum<EnumC0655a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0655a f26119a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0655a f26120b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0655a[] f26121d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f26122e = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f26123c;

        private static final /* synthetic */ EnumC0655a[] b() {
            return new EnumC0655a[]{f26119a, f26120b};
        }

        private EnumC0655a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f26123c = r3;
        }

        public final int a() {
            return this.f26123c;
        }

        static {
            f26119a = new EnumC0655a("SCRIPTED", 0, 0);
            f26120b = new EnumC0655a("VLM", 1, 1);
            EnumC0655a[] r0 = b();
            f26121d = r0;
            f26122e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0655a valueOf(String r2) {
            return (EnumC0655a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0655a.class, r2), EnumC0655a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0655a[] values() {
            return (EnumC0655a[]) ZeusTransformUtils.preCheckCast(f26121d.clone(), EnumC0655a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0656a f26124a = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final b f26125e = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f26126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f26127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f26128d;

        /* JADX INFO: renamed from: com.obric.autogui.agents.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOAgent.kt */
        public static final class C0656a {
            public /* synthetic */ C0656a(d.h.b.h r1) {
                this();
            }

            private C0656a() {
            }

            public final b a() {
                return b.d();
            }
        }

        public b() {
            this(null, null, 0, 7, null);
        }

        public b(e r2, String r3, int r4) {
            o.e(r2, "strategy");
            this.f26126b = r2;
            this.f26127c = r3;
            this.f26128d = r4;
        }

        public static final /* synthetic */ b d() {
            return f26125e;
        }

        public /* synthetic */ b(e r1, String r2, int r3, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = e.f26135a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = null;
        L9:
            if ((r4 & 4) == 0) goto L11;
            r3 = 1;
        L11:
            this(r1, r2, r3);
        }

        public final e a() {
            return this.f26126b;
        }

        public final String b() {
            return this.f26127c;
        }

        public final int c() {
            return this.f26128d;
        }

        static {
            f26124a = new C0656a(null);
            f26125e = new b(e.f26135a, null, 0, 4, null);
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    private static final class c implements com.obric.autogui.operator.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f26129a = null;

        static {
            f26129a = new c();
        }

        @Override // com.obric.autogui.operator.g
        public boolean a() {
            return false;
        }

        private c() {
        }

        @Override // com.obric.autogui.operator.g
        public String c() {
            return com.obric.autogui.operator.g.b.a(this);
        }

        @Override // com.obric.autogui.operator.g
        public int d() {
            return com.obric.autogui.operator.g.b.b(this);
        }

        @Override // com.obric.autogui.operator.g
        public com.obric.autogui.operator.g.e e() {
            return com.obric.autogui.operator.g.b.c(this);
        }

        @Override // com.obric.autogui.operator.g
        public Object f() {
            return com.obric.autogui.operator.g.b.d(this);
        }

        @Override // com.obric.autogui.operator.g
        public com.obric.autogui.operator.f g() {
            return com.obric.autogui.operator.g.b.e(this);
        }

        @Override // com.obric.autogui.operator.g
        public com.obric.autogui.operator.g.c b() {
            return com.obric.autogui.operator.g.c.f29924c;
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f26130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f26131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autogui.session.c.a f26132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f26133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.obric.autogui.operator.e f26134e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
            if (this.f26130a == r10.f26130a) goto L12;
            return false;
        L12:
            if (o.a(this.f26131b, r10.f26131b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f26132c, r10.f26132c) == true) goto L18;
            return false;
        L18:
            if (this.f26133d == r10.f26133d) goto L21;
            return false;
        L21:
            if (o.a(this.f26134e, r10.f26134e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((Integer.hashCode(this.f26130a) * 31) + this.f26131b.hashCode()) * 31) + this.f26132c.hashCode()) * 31) + Long.hashCode(this.f26133d)) * 31;
            com.obric.autogui.operator.e r3 = this.f26134e;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r0 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public String toString() {
            return "PredictionInfo(stepNum=" + this.f26130a + ", stepId=" + this.f26131b + ", metrics=" + this.f26132c + ", startAtBootTime=" + this.f26133d + ", readyStep=" + this.f26134e + ')';
        }

        public d(int r2, String r3, com.obric.autogui.session.c.a r4, long r5, com.obric.autogui.operator.e r7) {
            o.e(r3, "stepId");
            o.e(r4, "metrics");
            this.f26130a = r2;
            this.f26131b = r3;
            this.f26132c = r4;
            this.f26133d = r5;
            this.f26134e = r7;
        }

        public /* synthetic */ d(int r8, String r9, com.obric.autogui.session.c.a r10, long r11, com.obric.autogui.operator.e r13, int r14, d.h.b.h r15) {
            if ((r14 & 16) == 0) goto L5;
            r13 = null;
        L5:
            this(r8, r9, r10, r11, r13);
        }

        public final int a() {
            return this.f26130a;
        }

        public final String b() {
            return this.f26131b;
        }

        public final com.obric.autogui.session.c.a c() {
            return this.f26132c;
        }

        public final long d() {
            return this.f26133d;
        }

        public final void a(com.obric.autogui.operator.e r1) {
            this.f26134e = r1;
        }

        public final com.obric.autogui.operator.e e() {
            return this.f26134e;
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f26135a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f26136b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f26137c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f26138d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ e[] f26139e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f26135a, f26136b, f26137c, f26138d};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f26135a = new e("PROCEED", 0);
            f26136b = new e("ABORT_TASK", 1);
            f26137c = new e("RETRY_JUDGE", 2);
            f26138d = new e("INTERCEPT", 3);
            e[] r0 = a();
            f26139e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f26139e.clone(), e[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    public static final class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f26140b;

        public f() {
            this(null, 0, 3, null);
        }

        public /* synthetic */ f(String r1, long r2, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }

        public final long e() {
            return this.f26140b;
        }

        public f(String r7, long r8) {
            super(e.f26137c, r7, 0, 4, null);
            this.f26140b = r8;
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    @d.c.b.a.f(b = "AOAgent.kt", c = {155, 171}, d = "cancellableExecuteStep", e = "com.obric.autogui.agents.AOAgent")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f26143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26144d;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26143c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26142b = r3;
            this.f26144d |= Integer.MIN_VALUE;
            return a.c(this.f26143c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOAgent.kt */
    @d.c.b.a.f(b = "AOAgent.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.AOAgent$cancellableExecuteStep$2")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f26146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.operator.e f26147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f26148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ w<com.obric.autogui.operator.g> f26149e;
        private /* synthetic */ Object f;

        /* JADX INFO: renamed from: com.obric.autogui.agents.a$h$1, reason: invalid class name */
        /* JADX INFO: compiled from: AOAgent.kt */
        @d.c.b.a.f(b = "AOAgent.kt", c = {158}, d = "invokeSuspend", e = "com.obric.autogui.agents.AOAgent$cancellableExecuteStep$2$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26150a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.operator.e f26151b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.session.a f26152c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ w<com.obric.autogui.operator.g> f26153d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private /* synthetic */ Object f26154e;

            AnonymousClass1(com.obric.autogui.operator.e r3, com.obric.autogui.session.a r4, w<com.obric.autogui.operator.g> r5, d.c.d<? super AnonymousClass1> r6) {
                w<com.obric.autogui.operator.g> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26151b = r3;
                this.f26152c = r4;
                this.f26153d = r7;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f26151b, this.f26152c, this.f26153d, r7);
                r0.f26154e = r5;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26150a;
                if (r1 == 0) goto L10;
                if (r1 != 1) goto L9;
                am r2 = (am) ZeusTransformUtils.preCheckCast(this.f26154e, am.class, "com.obric.aiagent.plugin");
                d.o.a(r7);     // Catch: Throwable -> L18 CancellationException -> L24
            L15:
                this.f26153d.a((com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L22:
                Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r2), " - doOperations cancelled: " + this.f26151b);
                this.f26153d.a(c.f26129a);
                return x.f38692a;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                d.o.a(r7);
                am r8 = (am) ZeusTransformUtils.preCheckCast(this.f26154e, am.class, "com.obric.aiagent.plugin");
                com.obric.autogui.operator.e r3 = this.f26151b;     // Catch: Throwable -> L18 CancellationException -> L21
                com.obric.autogui.session.a r4 = this.f26152c;     // Catch: Throwable -> L18 CancellationException -> L21
                d.c.d<? super com.obric.autogui.operator.g> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 CancellationException -> L21
                this.f26154e = r8;     // Catch: Throwable -> L18 CancellationException -> L21
                this.f26150a = 1;     // Catch: Throwable -> L18 CancellationException -> L21
                Object r6 = r3.c(r4, r5);     // Catch: Throwable -> L18 CancellationException -> L21
                if (r6 != r0) goto L14;
                return r0;
            L14:
                r2 = r8;
                r7 = r6;
            L21:
                r2 = r8;
            L18:
                th = move-exception;
                this.f26153d.a(th);
                return x.f38692a;
            }
        }

        h(a r3, com.obric.autogui.operator.e r4, com.obric.autogui.session.a r5, w<com.obric.autogui.operator.g> r6, d.c.d<? super h> r7) {
            w<com.obric.autogui.operator.g> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26146b = r3;
            this.f26147c = r4;
            this.f26148d = r5;
            this.f26149e = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            h r11 = new h(this.f26146b, this.f26147c, this.f26148d, this.f26149e, r7);
            r11.f = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f26145a != 0) goto L7;
            d.o.a(r9);
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f, am.class, "com.obric.aiagent.plugin");
            a.a(this.f26146b, i.a(r2, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f26147c, this.f26148d, this.f26149e, null), m.class, "com.obric.aiagent.plugin"), 3, null));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public Object a(com.obric.autogui.session.a r3, d r4, d.c.d<? super b> r5) {
        return a(this, r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object a(com.obric.autogui.session.a r1, com.obric.autogui.operator.e r2, com.obric.autogui.operator.g r3, d.c.d<? super com.obric.autogui.operator.g> r4);

    public Object a(com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, d.c.d<? super x> r5) {
        return a(this, r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object a(com.obric.autogui.session.a r1, d.c.d<? super com.obric.autogui.common.e> r2);

    public abstract Object b(com.obric.autogui.session.a r1, d r2, d.c.d<? super com.obric.autogui.common.d<com.obric.autogui.operator.e>> r3);

    public Object b(com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, d.c.d<? super com.obric.autogui.operator.g> r5) {
        return b(this, r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public void b(com.obric.autogui.session.a r1) {
        o.e(r1, SensitiveType.SESSION);
    }

    public a(EnumC0655a r2) {
        o.e(r2, "type");
        this.f26117a = r2;
    }

    public static final /* synthetic */ void a(a r2, ca r3) {
        r2.f26118b = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Object c(a r2, com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, d.c.d r5) {
        return r2.c(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final EnumC0655a getType() {
        return this.f26117a;
    }

    public void a(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
        this.f26118b = null;
    }

    static /* synthetic */ Object a(a r0, com.obric.autogui.session.a r1, d r2, d.c.d<? super b> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return b.f26124a.a();
    }

    static /* synthetic */ Object a(a r0, com.obric.autogui.session.a r1, com.obric.autogui.operator.e r2, d.c.d<? super x> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    }

    static /* synthetic */ Object b(a r2, com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, d.c.d<? super com.obric.autogui.operator.g> r5) {
        return r2.c(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a() {
        ca r0 = this.f26118b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L19;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cancel: no ongoing step execution; no-need to cancel.");
        this.f26118b = null;
        return false;
    L19:
        ca r2 = this.f26118b;     // Catch: Throwable -> L16
        if (r2 == null) goto L15;
        ca.a.a(r2, null, 1, null);     // Catch: Throwable -> L16
    L15:
        return true;
    L16:
        th = move-exception;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cancel: failed: " + th);
        return false;
    L5:
        if (r0.b() != true) goto L7;
        r1 = true;
        goto L9
    }

    private final Object c(com.obric.autogui.session.a r15, com.obric.autogui.operator.e r16, d.c.d<? super com.obric.autogui.operator.g> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r2.f26144d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f26144d -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f26142b;
        Object r9 = d.c.a.b.a();
        int r3 = r2.f26144d;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r1);
    L23:
        return r1;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        w r4 = (w) ZeusTransformUtils.preCheckCast(r2.f26141a, w.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L20:
        r2.f26141a = null;
        r2.f26144d = 2;
        r1 = r4.a(r2);
        if (r1 != r9) goto L23;
        return r9;
    L16:
        d.o.a(r1);
        w r5 = y.a(null, 1, null);
        m r6 = (m) ZeusTransformUtils.preCheckCast(new h(this, r16, r15, r5, null), m.class, "com.obric.aiagent.plugin");
        r2.f26141a = r5;
        r2.f26144d = 1;
        if (an.a(r6, r2) != r9) goto L19;
        return r9;
    L19:
        r4 = r5;
    L7:
        r2 = new g(this, r0);
        goto L8
    }
}
