package com.obric.autogui.agents.a.a.a;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.input.InjectTextResponse;
import com.obric.autogui.common.api.platform.input.InjectTextResponseListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InjectTextResponseListener f26220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<Long> f26221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<InjectTextResponseListener, Boolean> f26222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<InjectTextResponseListener, Boolean> f26223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f26224e;
    private boolean f;
    private boolean g;
    private final AtomicReference<b> h;
    private final CountDownLatch i;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.a.a.p$1, reason: invalid class name */
    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {
        AnonymousClass1(Object r8) {
            super(0, r8, AOSystemTools.class, "bootTimeMillis", "bootTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(((AOSystemTools) ZeusTransformUtils.preCheckCast(this.receiver, AOSystemTools.class, "com.obric.aiagent.plugin")).bootTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InjectTextResponse f26225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f26226b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f26225a, r8.f26225a) == true) goto L12;
            return false;
        L12:
            if (this.f26226b == r8.f26226b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f26225a.hashCode() * 31) + Long.hashCode(this.f26226b);
        }

        public String toString() {
            return "CallbackSnapshot(response=" + this.f26225a + ", registrationToCallbackElapsedMs=" + this.f26226b + ')';
        }

        public a(InjectTextResponse r2, long r3) {
            d.h.b.o.e(r2, "response");
            this.f26225a = r2;
            this.f26226b = r3;
        }

        public final InjectTextResponse a() {
            return this.f26225a;
        }

        public final long b() {
            return this.f26226b;
        }
    }

    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    private static abstract class b {

        /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f26227a = null;

            static {
                f26227a = new a();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
                return false;
            L9:
                a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return 1221503443;
            }

            public String toString() {
                return "Closed";
            }

            private a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.a.a.p$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
        public static final class C0659b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c f26228a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0659b.class) == true) goto L8;
                return false;
            L8:
                C0659b r6 = (C0659b) ZeusTransformUtils.preCheckCast(r5, C0659b.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f26228a, r6.f26228a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f26228a.hashCode();
            }

            public String toString() {
                return "Frozen(result=" + this.f26228a + ')';
            }

            public final c a() {
                return this.f26228a;
            }

            public C0659b(c r2) {
                d.h.b.o.e(r2, "result");
                super(null);
                this.f26228a = r2;
            }
        }

        /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f26229a = null;

            static {
                f26229a = new c();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
                return false;
            L9:
                c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return -159451653;
            }

            public String toString() {
                return "Idle";
            }

            private c() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f26230a;

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
                return false;
            L8:
                d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
                if (this.f26230a == r8.f26230a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Long.hashCode(this.f26230a);
            }

            public String toString() {
                return "Listening(startedAtMs=" + this.f26230a + ')';
            }

            public final long a() {
                return this.f26230a;
            }

            public d(long r2) {
                super(null);
                this.f26230a = r2;
            }
        }

        /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
        public static final class e extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final a f26231a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
                return false;
            L8:
                e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f26231a, r6.f26231a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f26231a.hashCode();
            }

            public String toString() {
                return "Received(snapshot=" + this.f26231a + ')';
            }

            public final a a() {
                return this.f26231a;
            }

            public e(a r2) {
                d.h.b.o.e(r2, "snapshot");
                super(null);
                this.f26231a = r2;
            }
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f26232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f26233b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f26232a, r8.f26232a) == true) goto L12;
            return false;
        L12:
            if (this.f26233b == r8.f26233b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            a r0 = this.f26232a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Long.hashCode(this.f26233b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "FreezeResult(callback=" + this.f26232a + ", waitElapsedMs=" + this.f26233b + ')';
        }

        public c(a r1, long r2) {
            this.f26232a = r1;
            this.f26233b = r2;
        }

        public final a a() {
            return this.f26232a;
        }

        public final long b() {
            return this.f26233b;
        }
    }

    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f26234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f26235b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (this.f26234a == r6.f26234a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f26235b, r6.f26235b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f26234a) * 31;
            Long r1 = this.f26235b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "RecordResult(accepted=" + this.f26234a + ", registrationToCallbackElapsedMs=" + this.f26235b + ')';
        }

        public d(boolean r1, Long r2) {
            this.f26234a = r1;
            this.f26235b = r2;
        }

        public final boolean a() {
            return this.f26234a;
        }

        public final Long b() {
            return this.f26235b;
        }
    }

    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f26236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f26237b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f26236a == r6.f26236a) goto L12;
            return false;
        L12:
            if (this.f26237b == r6.f26237b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f26236a) * 31) + Boolean.hashCode(this.f26237b);
        }

        public String toString() {
            return "RegisterResult(registered=" + this.f26236a + ", skippedBecauseClosed=" + this.f26237b + ')';
        }

        public e(boolean r1, boolean r2) {
            this.f26236a = r1;
            this.f26237b = r2;
        }

        public final boolean a() {
            return this.f26236a;
        }

        public final boolean b() {
            return this.f26237b;
        }
    }

    /* JADX INFO: compiled from: TypeInjectTextCallbackSession.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f26238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f26239b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (this.f26238a == r6.f26238a) goto L12;
            return false;
        L12:
            if (this.f26239b == r6.f26239b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f26238a) * 31) + Boolean.hashCode(this.f26239b);
        }

        public String toString() {
            return "ReleaseResult(hadRegistration=" + this.f26238a + ", released=" + this.f26239b + ')';
        }

        public f(boolean r1, boolean r2) {
            this.f26238a = r1;
            this.f26239b = r2;
        }

        public final boolean a() {
            return this.f26238a;
        }

        public final boolean b() {
            return this.f26239b;
        }
    }

    /* JADX INFO: renamed from: lambda$MkxO__bchH_KI0DWZNPK-T8zP4Q, reason: not valid java name */
    public static /* synthetic */ boolean m709lambda$MkxO__bchH_KI0DWZNPKT8zP4Q(InjectTextResponseListener r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$pyL_eujITZBEuHItRyna10sohxc(InjectTextResponseListener r0) {
        return b(r0);
    }

    public p(InjectTextResponseListener r3, d.h.a.a<Long> r4, d.h.a.b<? super InjectTextResponseListener, Boolean> r5, d.h.a.b<? super InjectTextResponseListener, Boolean> r6) {
        InjectTextResponseListener r7 = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r3, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<InjectTextResponseListener, Boolean> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<InjectTextResponseListener, Boolean> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "listener");
        d.h.b.o.e(r8, "clockMs");
        d.h.b.o.e(r9, "registerListener");
        d.h.b.o.e(r10, "unregisterListener");
        this.f26220a = r7;
        this.f26221b = r8;
        this.f26222c = r9;
        this.f26223d = r10;
        this.f26224e = new Object();
        this.h = new AtomicReference(b.c.f26229a);
        this.i = new CountDownLatch(1);
    }

    public /* synthetic */ p(InjectTextResponseListener r2, d.h.a.a r3, d.h.a.b r4, d.h.a.b r5, int r6, d.h.b.h r7) {
        InjectTextResponseListener r8 = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r2, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(AOSystemTools.INSTANCE), d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r10 = $$Lambda$p$MkxO__bchH_KI0DWZNPKT8zP4Q.INSTANCE;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r11 = $$Lambda$p$pyL_eujITZBEuHItRyna10sohxc.INSTANCE;
    L11:
        this(r8, r9, r10, r11);
    }

    private static final boolean a(InjectTextResponseListener r2) {
        InjectTextResponseListener r3 = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r2, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return AOPlatformTools.INSTANCE.input().registerInjectTextResponseListener(r3);
    }

    private static final boolean b(InjectTextResponseListener r2) {
        InjectTextResponseListener r3 = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r2, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return AOPlatformTools.INSTANCE.input().unregisterInjectTextResponseListener(r3);
    }

    public final e a() {
        Object r0 = this.f26224e;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L8;
        e r5 = new e(false, true);     // Catch: Throwable -> L25
    L23:
        monitor-exit(r0);
        return r5;
    L8:
        if (this.f == false) goto L10;
        r5 = new e(true, false);     // Catch: Throwable -> L25
        goto L23
    L10:
        c();     // Catch: Throwable -> L25
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L13
        p r2 = (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Object r3 = d.n.f(Boolean.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r2.f26222c.invoke(r2.f26220a), Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L13
    L16:
        if (d.n.b(r3) == false) goto L18;
        r3 = false;
    L18:
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L25
        this.f = r4;     // Catch: Throwable -> L25
        if (r4 == true) goto L22;
        d();     // Catch: Throwable -> L25
    L22:
        r5 = new e(this.f, false);     // Catch: Throwable -> L25
    L13:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L25
        r3 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25
        goto L16
    }

    public final f b() {
        Object r0 = this.f26224e;
        monitor-enter(r0);
        this.g = true;     // Catch: Throwable -> L22
        if (this.f == true) goto L26;
        f r6 = new f(false, true);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r0);
        return r6;
    L26:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        p r3 = (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r4 = d.n.f(Boolean.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r3.f26223d.invoke(r3.f26220a), Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L11
    L14:
        if (d.n.b(r4) == false) goto L16;
        r4 = false;
    L16:
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L22
        if (r5 == false) goto L19;
        this.f = false;     // Catch: Throwable -> L22
    L19:
        r6 = new f(true, r5);     // Catch: Throwable -> L22
    L11:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L22
        r4 = d.n.f(d.o.a(th));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final d a(InjectTextResponse r8) {
        d.h.b.o.e(r8, "response");
    L3:
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.d.class) == false) goto L10;
        a r1 = new a(r8, d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26221b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - ((b.d) ZeusTransformUtils.preCheckCast(r0, b.d.class, "com.obric.aiagent.plugin")).a(), 0));
        if (this.h.compareAndSet(r0, new b.e(r1)) == false) goto L3;
        this.i.countDown();
        return new d(true, Long.valueOf(r1.b()));
    L10:
        if (ZeusTransformUtils.instanceOf(r0, b.e.class) == true) goto L12;
        Long r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, b.C0659b.class) == false) goto L21;
        a r3 = ((b.C0659b) ZeusTransformUtils.preCheckCast(r0, b.C0659b.class, "com.obric.aiagent.plugin")).a().a();
        if (r3 == null) goto L19;
        r2 = Long.valueOf(r3.b());
    L19:
        return new d(false, r2);
    L21:
        if (d.h.b.o.a(r0, b.c.f26229a) == true) goto L28;
        if (d.h.b.o.a(r0, b.a.f26227a) == true) goto L28;
        throw new d.k();
    L28:
        return new d(false, null);
    L12:
        return new d(false, Long.valueOf(((b.e) ZeusTransformUtils.preCheckCast(r0, b.e.class, "com.obric.aiagent.plugin")).a().b()));
    }

    public final c a(long r8) {
        long r9 = d.l.n.a(r8, 0);
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(this.f26221b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (ZeusTransformUtils.instanceOf(this.h.get(), b.d.class) == true) goto L5;
    L9:
        long r10 = d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26221b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - r2, 0);
    L10:
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.e.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r0, b.C0659b.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r0, b.d.class) == false) goto L23;
    L29:
        c r1 = new c(null, r10);
        if (this.h.compareAndSet(r0, new b.C0659b(r1)) == false) goto L10;
        this.i.countDown();
        return r1;
    L23:
        if (d.h.b.o.a(r0, b.c.f26229a) == true) goto L29;
        if (d.h.b.o.a(r0, b.a.f26227a) == true) goto L29;
        throw new d.k();
    L19:
        return ((b.C0659b) ZeusTransformUtils.preCheckCast(r0, b.C0659b.class, "com.obric.aiagent.plugin")).a();
    L12:
        c r3 = new c(((b.e) ZeusTransformUtils.preCheckCast(r0, b.e.class, "com.obric.aiagent.plugin")).a(), r10);
        if (this.h.compareAndSet(r0, new b.C0659b(r3)) == false) goto L10;
        this.i.countDown();
        return r3;
    L5:
        if (r9 <= 0) goto L9;
        this.i.await(r9, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8
    L8:
        Thread.currentThread().interrupt();
        goto L9
    }

    private final void c() {
        this.h.compareAndSet(b.c.f26229a, new b.d(((Number) ZeusTransformUtils.preCheckCast(this.f26221b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue()));
    }

    private final void d() {
    L2:
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.d.class) == false) goto L4;
        if (this.h.compareAndSet(r0, b.a.f26227a) == false) goto L2;
        this.i.countDown();
        return;
    }
}
