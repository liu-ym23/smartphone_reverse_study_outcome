package com.obric.autogui.agents.a.g;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.agents.a.m.r;
import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.t;
import com.obric.autogui.agents.a.m.v;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "ActionEffectObserve";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.c.d f26458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final am f26459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, e> f26460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f26461e;
    private final ConcurrentHashMap<String, a> f;
    private final AtomicBoolean g;

    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ca f26462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.a.a.f f26463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicReference<b> f26464c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26462a, r6.f26462a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f26463b, r6.f26463b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f26464c, r6.f26464c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f26462a.hashCode() * 31) + this.f26463b.hashCode()) * 31) + this.f26464c.hashCode();
        }

        public String toString() {
            return "ActiveAsyncObservation(job=" + this.f26462a + ", input=" + this.f26463b + ", terminal=" + this.f26464c + ')';
        }

        public a(ca r3, com.obric.autogui.agents.a.a.f r4, AtomicReference<b> r5) {
            ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
            o.e(r6, "job");
            o.e(r4, "input");
            o.e(r5, "terminal");
            this.f26462a = r6;
            this.f26463b = r4;
            this.f26464c = r5;
        }

        public final com.obric.autogui.agents.a.a.f a() {
            return this.f26463b;
        }

        public final void a(r r3) {
            o.e(r3, "reason");
            this.f26464c.compareAndSet(null, new b.a(r3));
            ca.a.a(this.f26462a, null, 1, null);
        }
    }

    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    private interface b {

        /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final r f26465a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (this.f26465a == r6.f26465a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f26465a.hashCode();
            }

            public String toString() {
                return "Cancelled(reason=" + this.f26465a + ')';
            }

            public a(r r2) {
                o.e(r2, "reason");
                this.f26465a = r2;
            }

            public final r a() {
                return this.f26465a;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.g.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
        public static final class C0664b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.autogui.agents.a.f.i f26466a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0664b.class) == true) goto L8;
                return false;
            L8:
                C0664b r6 = (C0664b) ZeusTransformUtils.preCheckCast(r5, C0664b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f26466a, r6.f26466a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f26466a.hashCode();
            }

            public String toString() {
                return "Completed(outcome=" + this.f26466a + ')';
            }

            public C0664b(com.obric.autogui.agents.a.f.i r2) {
                o.e(r2, "outcome");
                this.f26466a = r2;
            }

            public final com.obric.autogui.agents.a.f.i a() {
                return this.f26466a;
            }
        }

        /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f26467a = null;

            static {
                f26467a = new c();
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
                return 1198499240;
            }

            public String toString() {
                return "Failed";
            }

            private c() {
            }
        }
    }

    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    public static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f26468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ca f26469b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26468a, r6.f26468a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f26469b, r6.f26469b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f26468a.hashCode() * 31) + this.f26469b.hashCode();
        }

        public String toString() {
            return "InFlightObservation(pending=" + this.f26468a + ", job=" + this.f26469b + ')';
        }

        public d(e r3, ca r4) {
            ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
            o.e(r3, "pending");
            o.e(r5, "job");
            this.f26468a = r3;
            this.f26469b = r5;
        }

        public final e a() {
            return this.f26468a;
        }

        public final ca b() {
            return this.f26469b;
        }
    }

    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.a.a.f f26470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final t f26471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.a<x> f26472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final m<com.obric.autogui.agents.a.f.i, v, x> f26473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicBoolean f26474e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26470a, r6.f26470a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f26471b, r6.f26471b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f26472c, r6.f26472c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f26473d, r6.f26473d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f26474e, r6.f26474e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f26470a.hashCode() * 31) + this.f26471b.hashCode()) * 31) + this.f26472c.hashCode()) * 31) + this.f26473d.hashCode()) * 31) + this.f26474e.hashCode();
        }

        public String toString() {
            return "PendingObservation(input=" + this.f26470a + ", timingRecorder=" + this.f26471b + ", onStarted=" + this.f26472c + ", onFinished=" + this.f26473d + ", finished=" + this.f26474e + ')';
        }

        public e(com.obric.autogui.agents.a.a.f r3, t r4, d.h.a.a<x> r5, m<? super com.obric.autogui.agents.a.f.i, ? super v, x> r6, AtomicBoolean r7) {
            d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            m<com.obric.autogui.agents.a.f.i, v, x> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
            o.e(r3, "input");
            o.e(r4, "timingRecorder");
            o.e(r8, "onStarted");
            o.e(r9, "onFinished");
            o.e(r7, "finished");
            this.f26470a = r3;
            this.f26471b = r4;
            this.f26472c = r8;
            this.f26473d = r9;
            this.f26474e = r7;
        }

        public final com.obric.autogui.agents.a.a.f a() {
            return this.f26470a;
        }

        public final t b() {
            return this.f26471b;
        }

        public final d.h.a.a<x> c() {
            return this.f26472c;
        }

        public final m<com.obric.autogui.agents.a.f.i, v, x> d() {
            return this.f26473d;
        }

        public /* synthetic */ e(com.obric.autogui.agents.a.a.f r8, t r9, d.h.a.a r10, m r11, AtomicBoolean r12, int r13, d.h.b.h r14) {
            d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
            m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
            if ((r13 & 16) == 0) goto L5;
            r12 = new AtomicBoolean(false);
        L5:
            this(r8, r9, r4, r5, r12);
        }

        public final AtomicBoolean e() {
            return this.f26474e;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.g.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    @d.c.b.a.f(b = "ActionEffectObservationScheduler.kt", c = {291}, d = "consumeWithModelScreenshot", e = "com.obric.autogui.agents.actioneffect.pipeline.ActionEffectObservationScheduler")
    static final class C0665f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26479e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ f h;
        int i;

        C0665f(f r3, d.c.d<? super C0665f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectObservationScheduler.kt */
    @d.c.b.a.f(b = "ActionEffectObservationScheduler.kt", c = {172}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.pipeline.ActionEffectObservationScheduler$scheduleAsync$job$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f26481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f26482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.a.a.f f26483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ t f26484e;
        final /* synthetic */ AtomicReference<b> f;

        g(AtomicBoolean r3, f r4, com.obric.autogui.agents.a.a.f r5, t r6, AtomicReference<b> r7, d.c.d<? super g> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26481b = r3;
            this.f26482c = r4;
            this.f26483d = r5;
            this.f26484e = r6;
            this.f = r7;
            super(2, r9);
        }

        public static /* synthetic */ CharSequence lambda$j1F_rg91J1NrbhEFsMjUzL6XpVo(com.obric.autogui.agents.a.f.b r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f26481b, this.f26482c, this.f26483d, this.f26484e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f26480a;
            boolean r6 = true;
            if (r2 == 0) goto L13;
            if (r2 != 1) goto L12;
            d.o.a(r20);     // Catch: Exception -> L7 CancellationException -> L9
            Object r3 = r20;
        L17:
            com.obric.autogui.agents.a.f.i r1 = (com.obric.autogui.agents.a.f.i) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.f.i.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            boolean r4 = this.f.compareAndSet(null, new b.C0664b(r1));     // Catch: Exception -> L7 CancellationException -> L9
            Loog r7 = Loog.INSTANCE;     // Catch: Exception -> L7 CancellationException -> L9
            StringBuilder r8 = new StringBuilder().append("[OAutoActionEffect] async observation completed ").append(com.obric.autogui.agents.a.c.f26286a.a(this.f26483d)).append(", terminal_accepted=");     // Catch: Exception -> L7 CancellationException -> L9
            if (r4 == false) goto L20;
            boolean r5 = true;
        L21:
            StringBuilder r9 = r8.append(r5).append(", start_status=").append(r1.a()).append(", status=").append(r1.b()).append(", finish_reason=").append(r1.i()).append(", detector=");     // Catch: Exception -> L7 CancellationException -> L9
            com.obric.autogui.agents.a.f.c r10 = r1.c();     // Catch: Exception -> L7 CancellationException -> L9
            if (r10 == null) goto L25;
            String r11 = r10.a();     // Catch: Exception -> L7 CancellationException -> L9
        L26:
            String r12 = "";
            if (r11 != null) goto L29;
            r11 = "";
        L29:
            StringBuilder r13 = r9.append(r11).append(", served_reason=").append(com.obric.autogui.agents.a.b.a(r1.d(), 240)).append(", detect_count=").append(r1.f()).append(", error_reason=");     // Catch: Exception -> L7 CancellationException -> L9
            com.obric.autogui.agents.a.f.e r14 = r1.h();     // Catch: Exception -> L7 CancellationException -> L9
            if (r14 == null) goto L32;
            String r15 = r14.name();     // Catch: Exception -> L7 CancellationException -> L9
        L33:
            if (r15 == null) goto L36;
            r12 = r15;
        L36:
            StringBuilder r16 = r13.append(r12).append(", detector_results=").append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r1.e(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$f$g$j1F_rg91J1NrbhEFsMjUzL6XpVo.INSTANCE, 30, null)).append(", has_hint=");     // Catch: Exception -> L7 CancellationException -> L9
            if (r1.g() != null) goto L40;
            r6 = false;
        L40:
            r7.i(f.TAG, r16.append(r6).toString());     // Catch: Exception -> L7 CancellationException -> L9
        L44:
            return x.f38692a;
        L32:
            r15 = null;
            goto L33
        L25:
            r11 = null;
            goto L26
        L20:
            r5 = false;
            goto L21
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r20);
            this.f26481b.set(true);
            com.obric.autogui.agents.a.c.d r17 = f.a(this.f26482c);     // Catch: Exception -> L7 CancellationException -> L9
            com.obric.autogui.agents.a.a.f r18 = this.f26483d;     // Catch: Exception -> L7 CancellationException -> L9
            t r19 = this.f26484e;     // Catch: Exception -> L7 CancellationException -> L9
            d.c.d r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7 CancellationException -> L9
            this.f26480a = 1;     // Catch: Exception -> L7 CancellationException -> L9
            r3 = com.obric.autogui.agents.a.c.d.a(r17, r18, r19, null, null, false, null, null, r110, BDImageUploader.MessageIsPreHeatResultUsed, null);     // Catch: Exception -> L7 CancellationException -> L9
            if (r3 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            this.f.compareAndSet(null, new b.a(r.f26708d));
            throw e;
        L7:
            e = move-exception;
            this.f.compareAndSet(null, b.c.f26467a);
            Loog.INSTANCE.w(f.TAG, "[OAutoActionEffect] async observation failed " + com.obric.autogui.agents.a.c.f26286a.a(this.f26483d) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
            goto L44
        }

        private static final CharSequence a(com.obric.autogui.agents.a.f.b r2) {
            return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a().a() + ':' + r2.b(), CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f26457a = new c(null);
    }

    public static /* synthetic */ x lambda$K9noZyKBjlLsvRgyXzuP5Ng5G_8(AtomicBoolean r0, AtomicReference r1, t r2, com.obric.autogui.agents.a.a.f r3, f r4, m r5, String r6, Throwable r7) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public f(com.obric.autogui.agents.a.c.d r4) {
        o.e(r4, "evaluator");
        this.f26458b = r4;
        this.f26459c = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.f26460d = new ConcurrentHashMap();
        this.f26461e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new AtomicBoolean(false);
    }

    public static final /* synthetic */ com.obric.autogui.agents.a.c.d a(f r0) {
        return r0.f26458b;
    }

    public final void a(String r9) {
        o.e(r9, ObricMemoryConstants.KEY_SESSION_ID);
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.f26460d.remove(r9), e.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] pending observation cancelled " + com.obric.autogui.agents.a.c.f26286a.a(r0.a()) + ", reason=next_step");
        a(r0, null, s.f26712c, r.f26705a);
    L5:
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.f.remove(r9), a.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L9;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] async observation cancellation requested " + com.obric.autogui.agents.a.c.f26286a.a(r8.a()) + ", reason=next_step");
        r8.a(r.f26705a);
        return;
    }

    public final void a(String r11, com.obric.autogui.agents.a.a.f r12, t r13, d.h.a.a<x> r14, m<? super com.obric.autogui.agents.a.f.i, ? super v, x> r15) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r15, m.class, "com.obric.aiagent.plugin");
        o.e(r11, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r12, "input");
        o.e(r13, "timingRecorder");
        o.e(r5, "onStarted");
        o.e(r6, "onFinished");
        e r16 = new e(r12, r13, r5, r6, null, 16, null);
        if (this.g.get() == false) goto L6;
        a(r16, null, s.f26712c, r.f26707c);
        return;
    L6:
        e r17 = (e) ZeusTransformUtils.preCheckCast(this.f26460d.put(r11, r16), e.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L10;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] pending observation cancelled " + com.obric.autogui.agents.a.c.f26286a.a(r17.a()) + ", reason=replaced");
        a(r17, null, s.f26712c, r.f26706b);
    L10:
        if (this.g.get() == true) goto L12;
    L15:
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] pending observation registered " + com.obric.autogui.agents.a.c.f26286a.a(r12) + ", source=model_screenshot");
        return;
    L12:
        if (this.f26460d.remove(r11, r16) == false) goto L15;
        a(r16, null, s.f26712c, r.f26707c);
    }

    public final void a(final String r23, final com.obric.autogui.agents.a.a.f r24, final t r25, m<? super com.obric.autogui.agents.a.f.i, ? super v, x> r26) {
        final m<? super com.obric.autogui.agents.a.f.i, ? super v, x> r12 = (m) ZeusTransformUtils.wrapperContextForParams(r26, m.class, "com.obric.aiagent.plugin");
        o.e(r23, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r24, "input");
        o.e(r25, "timingRecorder");
        o.e(r12, "onFinished");
        if (this.g.get() == false) goto L6;
        a(r24, null, r25.a(s.f26712c, r.f26707c), r12);
        return;
    L6:
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] async observation scheduled " + com.obric.autogui.agents.a.c.f26286a.a(r24));
        final AtomicBoolean r14 = new AtomicBoolean(false);
        final AtomicReference r15 = new AtomicReference(null);
        ca r7 = kotlinx.coroutines.i.a(this.f26459c, null, ao.f38852b, (m) ZeusTransformUtils.preCheckCast(new g(r14, this, r24, r25, r15, null), m.class, "com.obric.aiagent.plugin"), 1, null);
        r7.a_(new $$Lambda$f$K9noZyKBjlLsvRgyXzuP5Ng5G_8(r14, r15, r25, r24, this, r12, r23));
        a r0 = new a(r7, r24, r15);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f.put(r23, r0), a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] async observation cancellation requested " + com.obric.autogui.agents.a.c.f26286a.a(r1.a()) + ", reason=replaced");
        r1.a(r.f26706b);
    L10:
        if (this.g.get() == true) goto L12;
    L14:
        r7.s_();
        return;
    L12:
        if (this.f.remove(r23, r0) == false) goto L14;
        r0.a(r.f26707c);
        goto L14
    }

    private static final x a(AtomicBoolean r3, AtomicReference r4, t r5, com.obric.autogui.agents.a.a.f r6, f r7, m r8, String r9, Throwable r10) {
        m<? super com.obric.autogui.agents.a.f.i, ? super v, x> r11 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, CancellationException.class) == true) goto L5;
        b r12 = (b) ZeusTransformUtils.preCheckCast(b.c.f26467a, b.class, "com.obric.aiagent.plugin");
    L10:
        a r13 = null;
        r4.compareAndSet(null, r12);
        b r14 = (b) ZeusTransformUtils.preCheckCast(r4.get(), b.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L15;
        r12 = r14;
    L15:
        if (ZeusTransformUtils.instanceOf(r12, b.C0664b.class) == false) goto L17;
        b.C0664b r15 = (b.C0664b) ZeusTransformUtils.preCheckCast(r12, b.C0664b.class, "com.obric.aiagent.plugin");
    L18:
        if (r15 == null) goto L20;
        com.obric.autogui.agents.a.f.i r16 = r15.a();
    L22:
        if (ZeusTransformUtils.instanceOf(r12, b.a.class) == false) goto L24;
        b.a r0 = (b.a) ZeusTransformUtils.preCheckCast(r12, b.a.class, "com.obric.aiagent.plugin");
    L25:
        if (r0 == null) goto L27;
        r r1 = r0.a();
    L29:
        if (ZeusTransformUtils.instanceOf(r12, b.C0664b.class) == false) goto L32;
        s r17 = ((b.C0664b) ZeusTransformUtils.preCheckCast(r12, b.C0664b.class, "com.obric.aiagent.plugin")).a().i();
    L37:
        v r18 = r5.a(r17, r1);
        com.obric.autogui.agents.a.c.f26286a.a(TAG, r6.k(), r18);
        r7.a(r6, r16, r18, r11);
        a r19 = (a) ZeusTransformUtils.preCheckCast(r7.f.get(r9), a.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L45;
        if (o.a(r19.a().b(), r6.b()) == false) goto L42;
        r13 = r19;
    L42:
        if (r13 == null) goto L45;
        r7.f.remove(r9, r13);
    L45:
        return x.f38692a;
    L32:
        if (ZeusTransformUtils.instanceOf(r12, b.a.class) == false) goto L35;
        r17 = s.f26712c;
        goto L37
    L35:
        if (ZeusTransformUtils.instanceOf(r12, b.c.class) == false) goto L47;
        r17 = s.f26713d;
        goto L37
    L47:
        throw new d.k();
    L27:
        r1 = null;
        goto L29
    L24:
        r0 = null;
        goto L25
    L20:
        r16 = null;
        goto L22
    L17:
        r15 = null;
        goto L18
    L5:
        if (r3.get() == false) goto L7;
        r r20 = r.f26708d;
    L8:
        r12 = (b) ZeusTransformUtils.preCheckCast(new b.a(r20), b.class, "com.obric.aiagent.plugin");
        goto L10
    L7:
        r20 = r.f26709e;
        goto L8
    }

    public static /* synthetic */ Object a(f r7, String r8, com.obric.autogui.agents.vlm.models.a.a.b r9, com.obric.autogui.agents.a.l.c r10, com.obric.autogui.agents.a.c.i r11, d.c.d r12, int r13, Object r14) {
        com.obric.autogui.agents.a.c.i r5 = (com.obric.autogui.agents.a.c.i) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.autogui.agents.a.c.i.class, "com.obric.aiagent.plugin");
        d.c.d<? super Boolean> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r13 & 2) == 0) goto L5;
        com.obric.autogui.agents.vlm.models.a.a.b r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        com.obric.autogui.agents.a.l.c r4 = null;
    L11:
        return r7.a(r8, r3, r4, r5, r6);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9371. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public final java.lang.Object a(java.lang.String r22, com.obric.autogui.agents.vlm.models.a.a.b r23, com.obric.autogui.agents.a.l.c r24, com.obric.autogui.agents.a.c.i r25, d.c.d<? super java.lang.Boolean> r26) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r21v0 'this' com.obric.autogui.agents.a.g.f A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.obric.autogui.agents.a.g.f.a(java.lang.String, com.obric.autogui.agents.vlm.models.a.a$b, com.obric.autogui.agents.a.l.c, com.obric.autogui.agents.a.c.i, d.c.d<? super java.lang.Boolean>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 937
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.agents.a.g.f.a(java.lang.String, com.obric.autogui.agents.vlm.models.a.a$b, com.obric.autogui.agents.a.l.c, com.obric.autogui.agents.a.c.i, d.c.d):java.lang.Object");
    }

    public final boolean a(String r8, String r9) {
        o.e(r8, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r9, "reason");
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.f26460d.remove(r8), e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return false;
    L6:
        a(r1);
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] model screenshot observation unavailable " + com.obric.autogui.agents.a.c.f26286a.a(r1.a()) + ", reason=" + com.obric.autogui.agents.a.b.a(r9, 80));
        a(this, r1, null, s.f26713d, null, 8, null);
        return true;
    }

    public final void a() {
        this.g.set(true);
        Set<Map.Entry<String, e>> r0 = this.f26460d.entrySet();
        o.c(r0, "<get-entries>(...)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r3);
        Object r8 = r3.getKey();
        o.c(r8, "component1(...)");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        Object r4 = r3.getValue();
        o.c(r4, "component2(...)");
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if (this.f26460d.remove(r6, r5) == false) goto L4;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] pending observation cancelled " + com.obric.autogui.agents.a.c.f26286a.a(r5.a()) + ", reason=session_cleanse");
        a(r5, null, s.f26712c, r.f26707c);
        goto L4
    L9:
        Set<Map.Entry<String, d>> r2 = this.f26461e.entrySet();
        o.c(r2, "<get-entries>(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r9);
        Object r10 = r9.getKey();
        o.c(r10, "component1(...)");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        Object r12 = r9.getValue();
        o.c(r12, "component2(...)");
        d r13 = (d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.aiagent.plugin");
        if (this.f26461e.remove(r11, r13) == false) goto L11;
        r13.b().a(new CancellationException("ActionEffect session cleansed"));
        a(r13.a(), null, s.f26712c, r.f26707c);
        goto L11
    L16:
        Set<Map.Entry<String, a>> r14 = this.f.entrySet();
        o.c(r14, "<get-entries>(...)");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r15.hasNext() == false) goto L22;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r16);
        Object r17 = r16.getKey();
        o.c(r17, "component1(...)");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin");
        Object r19 = r16.getValue();
        o.c(r19, "component2(...)");
        a r20 = (a) ZeusTransformUtils.preCheckCast(r19, a.class, "com.obric.aiagent.plugin");
        if (this.f.remove(r18, r20) == false) goto L18;
        r20.a(r.f26707c);
        goto L18
    L22:
        an.a(this.f26459c, null, 1, null);
    }

    private final void a(e r4) {
        r4.c().invoke();     // Catch: Exception -> L4 CancellationException -> L7
    L11:
        return;
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] pending start callback failed " + com.obric.autogui.agents.a.c.f26286a.a(r4.a()) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
    }

    static /* synthetic */ void a(f r0, e r1, com.obric.autogui.agents.a.f.i r2, s r3, r r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    private final void a(e r3, com.obric.autogui.agents.a.f.i r4, s r5, r r6) {
        if (r3.e().compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        v r2 = r3.b().a(r5, r6);
        if (r4 == null) goto L8;
        com.obric.autogui.agents.a.c.f26286a.a(TAG, r3.a(), r4, r2);
    L8:
        com.obric.autogui.agents.a.c.f26286a.a(TAG, r3.a().k(), r2);
        r3.d().invoke(r4, r2);     // Catch: Exception -> L11 CancellationException -> L14
    L18:
        return;
    L14:
        e = move-exception;
        throw e;
    L11:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] pending outcome callback failed " + com.obric.autogui.agents.a.c.f26286a.a(r3.a()) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
    }

    private final void a(com.obric.autogui.agents.a.a.f r2, com.obric.autogui.agents.a.f.i r3, v r4, m<? super com.obric.autogui.agents.a.f.i, ? super v, x> r5) {
        ((m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin")).invoke(r3, r4);     // Catch: Exception -> L5 CancellationException -> L8
    L12:
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] async outcome callback failed " + com.obric.autogui.agents.a.c.f26286a.a(r2) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
    }
}
