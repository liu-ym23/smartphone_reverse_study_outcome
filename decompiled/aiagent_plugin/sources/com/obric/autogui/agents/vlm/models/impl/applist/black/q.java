package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ai;
import d.a.ax;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    private static final String TAG = "VDRecordSet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f27519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f27520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final am f27521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<d.c.d<? super x>, Object> f27522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f27523e;
    private final kotlinx.coroutines.f.a f;
    private a g;
    private c h;
    private final AtomicLong i;
    private final Object j;
    private final Map<Long, Integer> k;
    private final AtomicReference<e> l;
    private final h m;

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f27524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f27526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set<String> f27527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f27528e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27524a, r10.f27524a) == true) goto L12;
            return false;
        L12:
            if (this.f27525b == r10.f27525b) goto L15;
            return false;
        L15:
            if (this.f27526c == r10.f27526c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f27527d, r10.f27527d) == true) goto L21;
            return false;
        L21:
            if (this.f27528e == r10.f27528e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f27524a.hashCode() * 31) + Integer.hashCode(this.f27525b)) * 31) + Long.hashCode(this.f27526c)) * 31) + this.f27527d.hashCode()) * 31) + Boolean.hashCode(this.f27528e);
        }

        public String toString() {
            return "ActiveSession(attempt=" + this.f27524a + ", displayId=" + this.f27525b + ", sessionId=" + this.f27526c + ", publishedPackages=" + this.f27527d + ", closing=" + this.f27528e + ')';
        }

        public a(e r3, int r4, long r5, Set<String> r7, boolean r8) {
            Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "attempt");
            d.h.b.o.e(r9, "publishedPackages");
            this.f27524a = r3;
            this.f27525b = r4;
            this.f27526c = r5;
            this.f27527d = r9;
            this.f27528e = r8;
        }

        public /* synthetic */ a(e r8, int r9, long r10, Set r12, boolean r13, int r14, d.h.b.h r15) {
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
            if ((r14 & 16) == 0) goto L5;
            r13 = false;
        L5:
            this(r8, r9, r10, r5, r13);
        }

        public final e a() {
            return this.f27524a;
        }

        public final int b() {
            return this.f27525b;
        }

        public final long c() {
            return this.f27526c;
        }

        public final Set<String> d() {
            return this.f27527d;
        }

        public final void a(boolean r1) {
            this.f27528e = r1;
        }

        public final boolean e() {
            return this.f27528e;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    private static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f27529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27530b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27529a, r6.f27529a) == true) goto L12;
            return false;
        L12:
            if (this.f27530b == r6.f27530b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f27529a.hashCode() * 31) + Integer.hashCode(this.f27530b);
        }

        public String toString() {
            return "LegacyCompatibilitySession(attempt=" + this.f27529a + ", displayId=" + this.f27530b + ')';
        }

        public c(e r2, int r3) {
            d.h.b.o.e(r2, "attempt");
            this.f27529a = r2;
            this.f27530b = r3;
        }

        public final e a() {
            return this.f27529a;
        }

        public final int b() {
            return this.f27530b;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    private static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f27531a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f27532b = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f27533e = null;
        private static final /* synthetic */ d.d.a f = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f27534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f27535d;

        private static final /* synthetic */ d[] c() {
            return new d[]{f27531a, f27532b};
        }

        private d(String r1, int r2, String r3, boolean r4) {
            super(r1, r2);
            this.f27534c = r3;
            this.f27535d = r4;
        }

        public final String a() {
            return this.f27534c;
        }

        public final boolean b() {
            return this.f27535d;
        }

        static {
            f27531a = new d("OPEN_APP", 0, "open_app", false);
            f27532b = new d("START_IN_PLACE", 1, "start_in_place", true);
            d[] r0 = c();
            f27533e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f27533e.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f27536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f27537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final r f27538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f27539d;

        public e(long r2, String r4, r r5, AtomicBoolean r6) {
            d.h.b.o.e(r4, "ownerToken");
            d.h.b.o.e(r6, "endRequested");
            this.f27536a = r2;
            this.f27537b = r4;
            this.f27538c = r5;
            this.f27539d = r6;
        }

        public final long a() {
            return this.f27536a;
        }

        public final String b() {
            return this.f27537b;
        }

        public final r c() {
            return this.f27538c;
        }

        public /* synthetic */ e(long r7, String r9, r r10, AtomicBoolean r11, int r12, d.h.b.h r13) {
            if ((r12 & 8) == 0) goto L5;
            r11 = new AtomicBoolean(false);
        L5:
            this(r7, r9, r10, r11);
        }

        public final AtomicBoolean d() {
            return this.f27539d;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$begin$2")
    static final class f extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f27541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f27542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f27543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f27544e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;

        f(q r3, e r4, int r5, String r6, String r7, int r8, d.c.d<? super f> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27541b = r3;
            this.f27542c = r4;
            this.f27543d = r5;
            this.f27544e = r6;
            this.f = r7;
            this.g = r8;
            super(1, r10);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((f) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f27541b, this.f27542c, this.f27543d, this.f27544e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r34) {
            d.c.a.b.a();
            if (this.f27540a != 0) goto L46;
            d.o.a(r34);
            q.a(this.f27541b).set(this.f27542c);
            Loog.INSTANCE.i(q.TAG, "event=begin_requested displayId=" + this.f27543d + " generation=" + this.f27542c.a() + " owner=" + this.f27544e);
            q.a(this.f27541b, true, "replaced_by_begin", null, 4, null);
            c r7 = null;
            q.a(this.f27541b, "replaced_by_begin", null, 2, null);
            if (q.a(this.f27541b, this.f27542c, this.f27543d, "before_framework_begin") == true) goto L7;
            Set<String> r1 = o.f27499a.a((Collection) ZeusTransformUtils.preCheckCast(d.a.p.a(this.f), Collection.class, "com.obric.aiagent.plugin"));
            if (r1.size() == 1) goto L13;
            Loog.INSTANCE.e(q.TAG, "event=begin_failed displayId=" + this.f27543d + " reason=invalid_assistant_package");
            q.a(this.f27541b, "begin", "blocked", "invalid_assistant_package", null, null, null, d.c.b.a.b.a(this.f27543d), this.f27544e, null, null, null, null, null, d.c.b.a.b.a(true), null, null, 57144, null);
            q.a(this.f27541b, this.f27542c);
            return d.c.b.a.b.a(false);
        L13:
            if (q.b(this.f27541b).a() == true) goto L16;
            r7 = new c(this.f27542c, this.f27543d);
        L16:
            if (r7 == null) goto L19;
            q.a(this.f27541b, r7);
        L19:
            if (q.a(this.f27541b, this.f27542c, this.f27543d, "after_framework_capability_check") == false) goto L24;
            if (r7 == null) goto L23;
            q.a(this.f27541b, "task_end_during_begin", r7);
        L23:
            return d.c.b.a.b.a(false);
        L24:
            if (r7 == null) goto L27;
            Loog.INSTANCE.i(q.TAG, "event=begin_skipped displayId=" + this.f27543d + " generation=" + this.f27542c.a() + " owner=" + this.f27544e + " reason=framework_api_unavailable compatibility=legacy_noop");
            return d.c.b.a.b.a(true);
        L27:
            Loog.INSTANCE.i(q.TAG, "event=initial_packages_ready displayId=" + this.f27543d + " source=assistant package=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.i((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin")) + " packageCount=" + r1.size());
            long r12 = q.b(this.f27541b).a(this.f27543d, this.g, (ObricAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(q.c(this.f27541b), ObricAutoVirtualDisplayRecordSetListener.class, "com.obric.aiagent.plugin"));
            if (r12 > 0) goto L31;
            Loog.INSTANCE.e(q.TAG, "event=begin_failed displayId=" + this.f27543d + " returnedSessionId=" + r12);
            q.a(this.f27541b, "begin", "failed", "invalid_framework_session_id", null, null, d.c.b.a.b.a(r12), d.c.b.a.b.a(this.f27543d), this.f27544e, null, null, null, null, null, d.c.b.a.b.a(true), null, null, 57112, null);
            q.a(this.f27541b, this.f27542c);
            return d.c.b.a.b.a(false);
        L31:
            Loog.INSTANCE.i(q.TAG, "event=begin_succeeded displayId=" + this.f27543d + " sessionId=" + r12);
            a r4 = new a(this.f27542c, this.f27543d, r12, d.a.p.t((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), false, 16, null);
            q.a(this.f27541b, r4);
            if (this.f27542c.d().get() == false) goto L36;
            Loog.INSTANCE.i(q.TAG, "event=begin_cancelled displayId=" + this.f27543d + " sessionId=" + r12 + " generation=" + this.f27542c.a() + " stage=after_framework_begin");
            q.a(this.f27541b, true, "task_end_during_begin", r4);
            return d.c.b.a.b.a(false);
        L36:
            if (q.a(this.f27541b, r4, (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"), "initial") == true) goto L40;
            Loog.INSTANCE.e(q.TAG, "event=initial_publish_failed sessionId=" + r12 + " packageCount=" + r1.size());
            q.a(this.f27541b, "begin", "failed", "initial_add_rejected", "initial", r4, null, null, null, null, null, null, d.c.b.a.b.a(r1.size()), null, d.c.b.a.b.a(true), d.c.b.a.b.a(true), null, 38880, null);
            q.a(this.f27541b, true, "initial_add_failed", r4);
            return d.c.b.a.b.a(false);
        L40:
            if (this.f27542c.d().get() == false) goto L43;
            Loog.INSTANCE.i(q.TAG, "event=begin_cancelled displayId=" + this.f27543d + " sessionId=" + r12 + " generation=" + this.f27542c.a() + " stage=after_initial_add");
            q.a(this.f27541b, true, "task_end_during_begin", r4);
            return d.c.b.a.b.a(false);
        L43:
            Loog.INSTANCE.i(q.TAG, "event=session_active sessionId=" + r12 + " displayId=" + this.f27543d + " packageCount=" + r1.size());
            return d.c.b.a.b.a(true);
        L7:
            return d.c.b.a.b.a(false);
        L46:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {596, 629, 630}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$end$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f27546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f27547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f27548d;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.q$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
        @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$end$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27549a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q f27550b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f27551c;

            AnonymousClass1(q r3, a r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27550b = r3;
                this.f27551c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27550b, this.f27551c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r22) {
                d.c.a.b.a();
                if (this.f27549a != 0) goto L10;
                d.o.a(r22);
                a r1 = q.e(this.f27550b);
                a r7 = this.f27551c;
                if (r1 != r7) goto L7;
                q.a(this.f27550b, "end", "timeout", "close_callback_timeout", "task_end", r7, null, null, null, null, null, null, null, null, null, d.c.b.a.b.a(true), null, 49120, null);
            L7:
                q.a(this.f27550b, false, "close_callback_timeout", this.f27551c);
                return x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
        @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$end$1$endingSession$1")
        static final class a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27552a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q f27553b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f27554c;

            a(q r3, e r4, d.c.d<? super a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27553b = r3;
                this.f27554c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super a> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27553b, this.f27554c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super a> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f27552a != 0) goto L36;
                d.o.a(r7);
                e r8 = (e) ZeusTransformUtils.preCheckCast(q.a(this.f27553b).get(), e.class, "com.obric.aiagent.plugin");
                if (r8 == this.f27554c) goto L12;
                Loog r0 = Loog.INSTANCE;
                StringBuilder r6 = new StringBuilder().append("event=end_ignored requestedGeneration=").append(this.f27554c.a()).append(" activeGeneration=");
                if (r8 == null) goto L9;
                Long r9 = d.c.b.a.b.a(r8.a());
            L10:
                r0.i(q.TAG, r6.append(r9).append(" reason=stale_attempt").toString());
                return null;
            L9:
                r9 = null;
                goto L10
            L12:
                c r10 = q.d(this.f27553b);
                if (r10 == null) goto L15;
                e r1 = r10.a();
            L17:
                if (r1 != this.f27554c) goto L20;
                q.a(this.f27553b, "task_end", r10);
                return null;
            L20:
                a r11 = q.e(this.f27553b);
                if (r11 != null) goto L23;
            L29:
                Loog r2 = Loog.INSTANCE;
                StringBuilder r12 = new StringBuilder().append("event=end_ignored requestedGeneration=").append(this.f27554c.a()).append(" activeSessionId=");
                if (r11 == null) goto L32;
                Long r13 = d.c.b.a.b.a(r11.c());
            L33:
                r2.i(q.TAG, r12.append(r13).append(" reason=no_matching_session").toString());
                return null;
            L32:
                r13 = null;
                goto L33
            L23:
                if (r11.a() != this.f27554c) goto L29;
                if (q.a(this.f27553b, r11, "task_end") == true) goto L28;
                return null;
            L28:
                return r11;
            L15:
                r1 = null;
                goto L17
            L36:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        g(q r3, e r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27547c = r3;
            this.f27548d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f27547c, this.f27548d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27546b;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            d.o.a(r10);
        L26:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f27545a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r10);
        L22:
            q r11 = this.f27547c;
            d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27547c, r2, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27545a = null;
            this.f27546b = 3;
            if (q.a(r11, r3, r4) != r0) goto L26;
            return r0;
        L11:
            d.o.a(r10);
        L15:
            r2 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L18;
            d.h.a.b r12 = q.f(this.f27547c);
            this.f27545a = r2;
            this.f27546b = 2;
            if (r12.invoke(this) != r0) goto L22;
            return r0;
        L18:
            return x.f38692a;
        L12:
            d.o.a(r10);
            q r13 = this.f27547c;
            d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this.f27547c, this.f27548d, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27546b = 1;
            r10 = q.a(r13, r5, r7);
            if (r10 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    public static final class h extends ObricAutoVirtualDisplayRecordSetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f27555a;

        /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
        @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {99}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$frameworkListener$1$onPackageAdmitted$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27556a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q f27557b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f27558c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f27559d;

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.q$h$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
            @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$frameworkListener$1$onPackageAdmitted$1$1")
            static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f27560a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ q f27561b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ long f27562c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f27563d;

                AnonymousClass1(q r3, long r4, String r6, d.c.d<? super AnonymousClass1> r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f27561b = r3;
                    this.f27562c = r4;
                    this.f27563d = r6;
                    super(1, r8);
                }

                public final Object a(d.c.d<? super x> r3) {
                    return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(d.c.d<?> r9) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27561b, this.f27562c, this.f27563d, r7), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    d.c.a.b.a();
                    if (this.f27560a != 0) goto L7;
                    d.o.a(r3);
                    q.a(this.f27561b, this.f27562c, this.f27563d);
                    return x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            a(q r3, long r4, String r6, d.c.d<? super a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27557b = r3;
                this.f27558c = r4;
                this.f27559d = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27557b, this.f27558c, this.f27559d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27556a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r10);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r10);
                q r11 = this.f27557b;
                d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27557b, this.f27558c, this.f27559d, null), d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27556a = 1;
                if (q.a(r11, r2, r3) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
        @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {114}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$frameworkListener$1$onRecordSetClosed$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27564a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q f27565b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f27566c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f27567d;

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.q$h$b$1, reason: invalid class name */
            /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
            @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$frameworkListener$1$onRecordSetClosed$1$1")
            static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f27568a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ q f27569b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ long f27570c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f27571d;

                AnonymousClass1(q r3, long r4, int r6, d.c.d<? super AnonymousClass1> r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f27569b = r3;
                    this.f27570c = r4;
                    this.f27571d = r6;
                    super(1, r8);
                }

                public final Object a(d.c.d<? super x> r3) {
                    return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(d.c.d<?> r9) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27569b, this.f27570c, this.f27571d, r7), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.b
                public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                    return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    d.c.a.b.a();
                    if (this.f27568a != 0) goto L7;
                    d.o.a(r3);
                    q.a(this.f27569b, this.f27570c, this.f27571d);
                    return x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(q r3, long r4, int r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27565b = r3;
                this.f27566c = r4;
                this.f27567d = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f27565b, this.f27566c, this.f27567d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v2, types: [d.x, java.lang.Object] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r11) {
                Object r1 = d.c.a.b.a();
                int r2 = this.f27564a;
                if (r2 == 0) goto L11;
                if (r2 != 1) goto L10;
                d.o.a(r11);     // Catch: Throwable -> L7
            L15:
                q.b(this.f27565b, this.f27566c);
                b this = x.f38692a;
                return this;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r11);
                q r12 = this.f27565b;     // Catch: Throwable -> L7
                d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27565b, this.f27566c, this.f27567d, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                d.c.d r0 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                this.f27564a = 1;     // Catch: Throwable -> L7
                if (q.a(r12, r3, r0) != r1) goto L15;
                return r1;
            L7:
                th = move-exception;
                q.b(this.f27565b, this.f27566c);
                throw th;
            }
        }

        h(q r1) {
            this.f27555a = r1;
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener
        public void onPackageAdmitted(long r9, String r11) {
            d.h.b.o.e(r11, "packageName");
            Loog.INSTANCE.i(q.TAG, "event=admitted_callback_received sessionId=" + r9 + " package=" + r11 + " action=add_to_framework_record_set");
            kotlinx.coroutines.i.a(q.g(this.f27555a), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f27555a, r9, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener
        public void onRecordSetClosed(long r9, int r11) {
            q.a(this.f27555a, r9);
            Loog.INSTANCE.i(q.TAG, "event=closed_callback_received sessionId=" + r9 + " reason=" + r11 + " action=end_framework_and_cleanup");
            kotlinx.coroutines.i.a(q.g(this.f27555a), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f27555a, r9, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$publishAuthorizedOpenAppPackage$2")
    static final class i extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f27573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27575d;

        i(q r3, String r4, String r5, d.c.d<? super i> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27573b = r3;
            this.f27574c = r4;
            this.f27575d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((i) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f27573b, this.f27574c, this.f27575d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f27572a != 0) goto L7;
            d.o.a(r3);
            return d.c.b.a.b.a(q.a(this.f27573b, this.f27574c, this.f27575d, d.f27531a));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController$publishStartInPlacePackage$2")
    static final class j extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f27577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27579d;

        j(q r3, String r4, String r5, d.c.d<? super j> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27577b = r3;
            this.f27578c = r4;
            this.f27579d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((j) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f27577b, this.f27578c, this.f27579d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f27576a != 0) goto L7;
            d.o.a(r3);
            return d.c.b.a.b.a(q.a(this.f27577b, this.f27578c, this.f27579d, d.f27532b));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSessionController.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSessionController.kt", c = {966, 968}, d = "withStateLock", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSessionController")
    static final class k<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f27583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27584e;

        k(q r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27583d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27582c = r3;
            this.f27584e |= Integer.MIN_VALUE;
            return q.a(this.f27583d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27519a = new b(null);
    }

    public q(n r5, am r6, d.h.a.b<? super d.c.d<? super x>, ? extends Object> r7, t r8) {
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
        am r10 = (am) ZeusTransformUtils.wrapperContextForParams(r6, am.class, "com.obric.aiagent.plugin");
        d.h.a.b<d.c.d<? super x>, Object> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        t r12 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "framework");
        d.h.b.o.e(r10, "scope");
        d.h.b.o.e(r11, "waitForCloseCallback");
        d.h.b.o.e(r12, "trackingReporter");
        this.f27520b = r9;
        this.f27521c = r10;
        this.f27522d = r11;
        this.f27523e = r12;
        this.f = kotlinx.coroutines.f.c.a(false, 1, null);
        this.i = new AtomicLong(0);
        this.j = new Object();
        this.k = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.l = new AtomicReference(null);
        this.m = new h(this);
    }

    public static final /* synthetic */ Object a(q r2, d.h.a.b r3, d.c.d r4) {
        return r2.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReference a(q r0) {
        return r0.l;
    }

    public static final /* synthetic */ void a(q r0, long r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(q r0, long r1, int r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(q r0, long r1, String r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(q r0, a r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ void a(q r0, c r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void a(q r0, e r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(q r0, String r1, c r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(q r0, boolean r1, String r2, a r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ boolean a(q r0, a r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(q r2, a r3, Collection r4, String r5) {
        return r2.a(r3, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin"), r5);
    }

    public static final /* synthetic */ boolean a(q r0, e r1, int r2, String r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ boolean a(q r0, String r1, String r2, d r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ n b(q r0) {
        return r0.f27520b;
    }

    public static final /* synthetic */ void b(q r0, long r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ h c(q r0) {
        return r0.m;
    }

    public static final /* synthetic */ c d(q r0) {
        return r0.h;
    }

    public static final /* synthetic */ a e(q r0) {
        return r0.g;
    }

    public static final /* synthetic */ d.h.a.b f(q r0) {
        return r0.f27522d;
    }

    public static final /* synthetic */ am g(q r0) {
        return r0.f27521c;
    }

    public /* synthetic */ q(n r2, am r3, d.h.a.b r4, t r5, int r6, d.h.b.h r7) {
        n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin");
        am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        t r11 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r11 = (t) ZeusTransformUtils.preCheckCast(m.f27494a, t.class, "com.obric.aiagent.plugin");
    L5:
        this(r8, r9, r10, r11);
    }

    public final Object a(String r14, int r15, int r16, String r17, r r18, d.c.d<? super Boolean> r19) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this, new e(this.i.incrementAndGet(), r17, r18, null, 8, null), r15, r17, r14, r16, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r10);
    }

    public static /* synthetic */ Object a(q r1, String r2, String r3, d.c.d r4, int r5, Object r6) {
        d.c.d<? super Boolean> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        return r1.a(r2, r3, r7);
    }

    public final Object a(String r4, String r5, d.c.d<? super Boolean> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this, r4, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r7);
    }

    public final Object b(String r4, String r5, d.c.d<? super Boolean> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(new j(this, r4, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r7);
    }

    private final boolean a(String r26, String r27, d r28) {
        String r4 = r28.a();
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed reason=empty_package");
        a(this, "package_gate", "blocked", "empty_package", r4, null, null, null, null, r27, null, null, null, null, true, null, null, 57072, null);
        return false;
    L10:
        c r1 = this.h;
        if (r1 != null) goto L13;
        a r2 = this.g;
        if (r2 != null) goto L29;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed package=" + r10 + " reason=no_active_session");
        a(this, "package_gate", "blocked", "no_active_session", r4, null, null, null, null, r27, r10, null, null, null, true, null, null, 56560, null);
        return false;
    L29:
        if (r27 == null) goto L35;
        if (d.h.b.o.a(r2.a().b(), r27) == true) goto L35;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed sessionId=" + r2.c() + " package=" + r10 + " expectedOwner=" + r27 + " activeOwner=" + r2.a().b() + " reason=stale_owner");
        a(this, "package_gate", "blocked", "stale_owner", r4, r2, null, null, null, r27, r10, null, null, null, true, null, false, 23776, null);
        return false;
    L35:
        if (r2.e() == false) goto L38;
        String r3 = "end_already_sent";
    L44:
        if (r3 == null) goto L48;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed sessionId=" + r2.c() + " package=" + r10 + " reason=session_closing detail=" + r3);
        a(this, "package_gate", "blocked", r3, r4, r2, null, null, null, null, r10, null, null, null, true, null, null, 56800, null);
        return false;
    L48:
        if (r2.d().contains(r10) == false) goto L52;
        Loog.INSTANCE.i(TAG, "event=" + r4 + "_add_skipped sessionId=" + r2.c() + " package=" + r10 + " reason=already_published");
        return true;
    L52:
        if (o.f27499a.b((Collection) ZeusTransformUtils.preCheckCast(ax.b(r2.d(), r10), Collection.class, "com.obric.aiagent.plugin")) == true) goto L55;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed sessionId=" + r2.c() + " package=" + r10 + " reason=session_limit totalCount=" + r2.d().size());
        a(this, "package_gate", "blocked", "session_limit", r4, r2, null, null, null, null, r10, Integer.valueOf(r2.d().size()), Integer.valueOf(r2.d().size() + 1), null, true, true, null, 37344, null);
        a(true, r4 + "_add_limit_exceeded", r2);
        return false;
    L55:
        Loog.INSTANCE.i(TAG, "event=" + r4 + "_add_started sessionId=" + r2.c() + " package=" + r10);
        if (a(r2, (Collection) ZeusTransformUtils.preCheckCast(ax.a(r10), Collection.class, "com.obric.aiagent.plugin"), r4) == true) goto L61;
        boolean r21 = r28.b();
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed sessionId=" + r2.c() + " package=" + r10 + " reason=framework_rejected");
        a(this, "package_gate", "blocked", "framework_rejected", r4, r2, null, null, null, null, r10, Integer.valueOf(r2.d().size()), Integer.valueOf(r2.d().size() + 1), null, true, Boolean.valueOf(r21), null, 37344, null);
        if (r21 == false) goto L60;
        a(true, r4 + "_add_failed", r2);
    L60:
        return false;
    L61:
        boolean r5 = r2.a().d().get();
        boolean r6 = c(r2.c());
        if (r5 == true) goto L67;
        if (r6 == true) goto L67;
        r2.d().add(r10);
        Loog.INSTANCE.i(TAG, "event=" + r4 + "_add_succeeded sessionId=" + r2.c() + " package=" + r10 + " totalCount=" + r2.d().size());
        return true;
    L67:
        if (r6 == false) goto L69;
        String r7 = "framework_closed_during_add";
    L70:
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed sessionId=" + r2.c() + " package=" + r10 + " reason=" + r7);
        a(this, "package_gate", "blocked", r7, r4, r2, null, null, null, null, r10, Integer.valueOf(r2.d().size()), Integer.valueOf(r2.d().size() + 1), null, true, true, null, 37344, null);
        a(true, r4 + "_add_completed_after_close", r2);
        return false;
    L69:
        r7 = "session_ended_during_add";
        goto L70
    L38:
        if (r2.a().d().get() == false) goto L41;
        r3 = "task_end_pending";
        goto L44
    L41:
        if (c(r2.c()) == false) goto L43;
        r3 = "framework_close_pending";
        goto L44
    L43:
        r3 = null;
        goto L44
    L13:
        if (r27 == null) goto L19;
        if (d.h.b.o.a(r1.a().b(), r27) == true) goto L19;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed displayId=" + r1.b() + " package=" + r10 + " expectedOwner=" + r27 + " activeOwner=" + r1.a().b() + " reason=stale_owner");
        a(this, "package_gate", "blocked", "stale_owner", r4, null, null, Integer.valueOf(r1.b()), r1.a().b(), r27, r10, null, null, null, true, null, false, 23600, null);
        return false;
    L19:
        if (r1.a().d().get() == false) goto L22;
        Loog.INSTANCE.e(TAG, "event=" + r4 + "_add_failed displayId=" + r1.b() + " package=" + r10 + " reason=task_end_pending compatibility=legacy_noop");
        a(this, "package_gate", "blocked", "task_end_pending", r4, null, null, Integer.valueOf(r1.b()), r1.a().b(), null, r10, null, null, null, true, null, null, 56624, null);
        return false;
    L22:
        Loog.INSTANCE.i(TAG, "event=" + r4 + "_add_skipped displayId=" + r1.b() + " package=" + r10 + " reason=framework_api_unavailable compatibility=legacy_noop");
        return true;
    L5:
        r0 = false;
        goto L7
    }

    public final void a(String r9) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.l.get(), e.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Loog.INSTANCE.i(TAG, "event=end_ignored reason=no_current_attempt");
        return;
    L6:
        if (r9 == null) goto L12;
        if (d.h.b.o.a(r0.b(), r9) == true) goto L12;
        Loog.INSTANCE.i(TAG, "event=end_ignored expectedOwner=" + r9 + " activeOwner=" + r0.b() + " reason=stale_owner");
        return;
    L12:
        if (r0.d().compareAndSet(false, true) == true) goto L15;
        Loog.INSTANCE.i(TAG, "event=end_ignored generation=" + r0.a() + " reason=already_requested");
        return;
    L15:
        kotlinx.coroutines.i.a(this.f27521c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean a(a r18, Collection<String> r19, String r20) {
        List<List<String>> r1 = o.f27499a.c((Collection) ZeusTransformUtils.wrapperContextForParams(r19, Collection.class, "com.obric.aiagent.plugin"));
        int r6 = 1;
        if (r1.isEmpty() == false) goto L6;
        Loog.INSTANCE.i(TAG, "event=add_skipped sessionId=" + r18.c() + " phase=" + r20 + " reason=empty_set");
        return true;
    L6:
        Iterable r3 = d.a.p.r((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L9;
    L11:
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        ai r7 = (ai) ZeusTransformUtils.preCheckCast(r4.next(), ai.class, "com.obric.aiagent.plugin");
        int r8 = r7.c();
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7.d(), List.class, "com.obric.aiagent.plugin");
        int r10 = r8 + r6;
        Loog.INSTANCE.i(TAG, "event=add_requested sessionId=" + r18.c() + " phase=" + r20 + " batch=" + r10 + '/' + r1.size() + " packageCount=" + r9.size());
        boolean r11 = this.f27520b.a(r18.c(), (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin"));
        Loog.INSTANCE.i(TAG, "event=add_completed sessionId=" + r18.c() + " phase=" + r20 + " batch=" + r10 + '/' + r1.size() + " packageCount=" + r9.size() + " success=" + r11);
        if (r11 == false) goto L16;
        r6 = 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(long r24, String r26) {
        a r10 = this.g;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r2 = false;
        if (r10 != null) goto L5;
    L28:
        Loog r7 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("event=admitted_callback_ignored callbackSessionId=").append(r24).append(" activeSessionId=");
        if (r10 == null) goto L31;
        Object r1 = Long.valueOf(r10.c());
    L32:
        StringBuilder r3 = r0.append(r1).append(" emptyPackage=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L35;
        r2 = true;
    L35:
        r7.i(TAG, r3.append(r2).toString());
        return;
    L31:
        r1 = null;
        goto L32
    L5:
        if (r10.c() != r24) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L9;
        Object[] r6 = true;
    L10:
        if (r6 == true) goto L28;
        if (r10.e() == false) goto L16;
        Loog.INSTANCE.i(TAG, "event=admitted_callback_ignored sessionId=" + r24 + " reason=session_closing package=" + r5);
        return;
    L16:
        boolean r4 = r10.d().contains(r5);
        if (r4 == false) goto L19;
    L22:
        Loog.INSTANCE.i(TAG, "event=admitted_add_started sessionId=" + r24 + " package=" + r5 + " alreadyPublished=" + r4);
        if (a(r10, (Collection) ZeusTransformUtils.preCheckCast(ax.a(r5), Collection.class, "com.obric.aiagent.plugin"), "admitted") == true) goto L26;
        Loog.INSTANCE.e(TAG, "event=admitted_add_failed sessionId=" + r24 + " package=" + r5 + " reason=framework_rejected");
        a(this, "admitted_callback", "failed", "framework_rejected", "admitted", r10, null, null, null, null, r5, Integer.valueOf(r10.d().size()), Integer.valueOf(r10.d().size() + (!r4 ? 1 : 0)), null, null, true, null, 45536, null);
        a(true, "admitted_add_failed", r10);
        return;
    L26:
        r10.d().add(r5);
        Loog.INSTANCE.i(TAG, "event=admitted_add_succeeded sessionId=" + r24 + " package=" + r5 + " totalCount=" + r10.d().size());
        return;
    L19:
        if (o.f27499a.b((Collection) ZeusTransformUtils.preCheckCast(ax.b(r10.d(), r5), Collection.class, "com.obric.aiagent.plugin")) == true) goto L22;
        Loog.INSTANCE.e(TAG, "event=admitted_add_failed sessionId=" + r24 + " package=" + r5 + " reason=session_limit totalCount=" + r10.d().size());
        a(this, "admitted_callback", "blocked", "session_limit", "admitted", r10, null, null, null, null, r5, Integer.valueOf(r10.d().size()), Integer.valueOf(r10.d().size() + 1), null, null, true, null, 45536, null);
        a(true, "admitted_add_limit_exceeded", r10);
        return;
    L9:
        r6 = false;
        goto L10
    }

    private final void a(long r25, int r27) {
        a r1 = this.g;
        Long r4 = null;
        if (r1 != null) goto L5;
    L22:
        Loog r0 = Loog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("event=closed_callback_ignored callbackSessionId=").append(r25).append(" activeSessionId=");
        if (r1 == null) goto L25;
        r4 = Long.valueOf(r1.c());
    L25:
        r0.i(TAG, r2.append(r4).toString());
        return;
    L5:
        if (r1.c() != r25) goto L22;
        if (r27 == 1) goto L15;
        if (r27 != 2) goto L11;
        String r8 = "display_removed";
    L16:
        String r13 = r8;
        if (d.o.o.b(r13, "unknown_", false, 2, null) == false) goto L19;
        boolean r20 = true;
        a r23 = r1;
        a(this, "closed_callback", "unexpected", "unknown_close_reason", null, r23, null, null, null, null, null, null, null, Integer.valueOf(r27), null, true, null, 45032, null);
    L20:
        Loog.INSTANCE.i(TAG, "event=session_closed_by_framework sessionId=" + r25 + " reason=" + r13);
        a(r20, "framework_closed_" + r27, r23);
        return;
    L19:
        r23 = r1;
        r20 = true;
        goto L20
    L11:
        if (r27 == 4) goto L13;
        r8 = "unknown_" + r27;
        goto L16
    L13:
        r8 = "replaced";
        goto L16
    L15:
        r8 = "ended";
        goto L16
    }

    static /* synthetic */ void a(q r0, boolean r1, String r2, a r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(boolean r6, String r7, a r8) {
        a r0 = this.g;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r8 == null) goto L10;
        if (r0 == r8) goto L10;
        Loog.INSTANCE.i(TAG, "event=session_cleanup_ignored expectedSessionId=" + r8.c() + " activeSessionId=" + r0.c() + " source=" + r7 + " reason=stale_session");
        return;
    L10:
        this.g = null;
        a(r0.a());
        if (r6 == false) goto L13;
        a(r0, r7);
    L13:
        r0.d().clear();
        Loog.INSTANCE.i(TAG, "event=session_cleaned sessionId=" + r0.c() + " displayId=" + r0.b() + " source=" + r7);
    }

    static /* synthetic */ void a(q r0, String r1, c r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    private final void a(String r7, c r8) {
        c r0 = this.h;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r8 == null) goto L10;
        if (r0 == r8) goto L10;
        Loog.INSTANCE.i(TAG, "event=compatibility_session_cleanup_ignored expectedGeneration=" + r8.a().a() + " activeGeneration=" + r0.a().a() + " source=" + r7 + " reason=stale_session");
        return;
    L10:
        this.h = null;
        a(r0.a());
        Loog.INSTANCE.i(TAG, "event=compatibility_session_cleaned displayId=" + r0.b() + " generation=" + r0.a().a() + " source=" + r7);
    }

    private final boolean a(a r8, String r9) {
        if (r8.e() == false) goto L6;
        Loog.INSTANCE.i(TAG, "event=end_ignored sessionId=" + r8.c() + " source=" + r9 + " reason=already_requested");
        return false;
    L6:
        r8.a(true);
        Loog.INSTANCE.i(TAG, "event=end_requested sessionId=" + r8.c() + " displayId=" + r8.b() + " source=" + r9);
        this.f27520b.a(r8.c());
        return true;
    }

    private final boolean a(e r4, int r5, String r6) {
        if (r4.d().get() == true) goto L6;
        return false;
    L6:
        Loog.INSTANCE.i(TAG, "event=begin_cancelled displayId=" + r5 + " generation=" + r4.a() + " stage=" + r6);
        a(r4);
        return true;
    }

    private final void a(e r2) {
        this.l.compareAndSet(r2, null);
    }

    private final void a(long r4) {
        Object r0 = this.j;
        monitor-enter(r0);
        Long r1 = Long.valueOf(r4);     // Catch: Throwable -> L7
        Map<Long, Integer> r3 = this.k;     // Catch: Throwable -> L7
        r3.put(r1, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3.getOrDefault(Long.valueOf(r4), 0), Number.class, "com.obric.aiagent.plugin")).intValue() + 1));     // Catch: Throwable -> L7
        x r5 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void b(long r5) {
        Object r0 = this.j;
        monitor-enter(r0);
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(this.k.getOrDefault(Long.valueOf(r5), 0), Number.class, "com.obric.aiagent.plugin")).intValue() - 1;     // Catch: Throwable -> L10
        if (r1 <= 0) goto L7;
        this.k.put(Long.valueOf(r5), Integer.valueOf(r1));     // Catch: Throwable -> L10
        x r4 = x.f38692a;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
        return;
    L7:
        this.k.remove(Long.valueOf(r5));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private final boolean c(long r2) {
        Object r0 = this.j;
        monitor-enter(r0);
        boolean r1 = this.k.containsKey(Long.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(q r20, String r21, String r22, String r23, String r24, a r25, Long r26, Integer r27, String r28, String r29, String r30, Integer r31, Integer r32, Integer r33, Boolean r34, Boolean r35, Boolean r36, int r37, Object r38) {
        if ((r37 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r37 & 16) == 0) goto L9;
        a r8 = null;
    L11:
        if ((r37 & 32) == 0) goto L13;
        Long r9 = null;
    L15:
        if ((r37 & 64) == 0) goto L17;
        Integer r10 = null;
    L19:
        if ((r37 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r37 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r37 & 512) == 0) goto L29;
        String r13 = null;
    L31:
        if ((r37 & 1024) == 0) goto L33;
        Integer r14 = null;
    L35:
        if ((r37 & 2048) == 0) goto L37;
        Integer r15 = null;
    L39:
        if ((r37 & 4096) == 0) goto L41;
        Integer r16 = null;
    L43:
        if ((r37 & 8192) == 0) goto L45;
        Boolean r17 = null;
    L47:
        if ((r37 & 16384) == 0) goto L49;
        Boolean r18 = null;
    L51:
        if ((r37 & 32768) == 0) goto L53;
        Boolean r19 = null;
    L54:
        r20.a(r21, r22, r23, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L53:
        r19 = r36;
        goto L54
    L49:
        r18 = r35;
        goto L51
    L45:
        r17 = r34;
        goto L47
    L41:
        r16 = r33;
        goto L43
    L37:
        r15 = r32;
        goto L39
    L33:
        r14 = r31;
        goto L35
    L29:
        r13 = r30;
        goto L31
    L25:
        r12 = r29;
        goto L27
    L21:
        r11 = r28;
        goto L23
    L17:
        r10 = r27;
        goto L19
    L13:
        r9 = r26;
        goto L15
    L9:
        r8 = r25;
        goto L11
    L5:
        r7 = r24;
        goto L7
    }

    private final void a(String r25, String r26, String r27, String r28, a r29, Long r30, Integer r31, String r32, String r33, String r34, Integer r35, Integer r36, Integer r37, Boolean r38, Boolean r39, Boolean r40) {
        if (r29 != null) goto L5;
        a r1 = this.g;
    L6:
        if (r1 == null) goto L9;
        e r2 = r1.a();
        if (r2 == null) goto L9;
    L10:
        Boolean r3 = null;
        if (r32 != null) goto L15;
        if (r2 == null) goto L14;
        String r13 = r2.b();
    L16:
        if (r2 == null) goto L22;
        r r4 = r2.c();
        if (r4 == null) goto L22;
        if (d.h.b.o.a(r4.b(), r13) == false) goto L22;
    L23:
        t r0 = this.f27523e;
        if (r30 != null) goto L28;
        if (r1 == null) goto L27;
        Long r10 = Long.valueOf(r1.c());
    L29:
        if (r31 != null) goto L33;
        if (r1 == null) goto L32;
        Integer r11 = Integer.valueOf(r1.b());
    L34:
        if (r4 == null) goto L36;
        String r12 = r4.a();
    L37:
        if (r4 == null) goto L39;
        Integer r15 = Integer.valueOf(r4.c());
    L40:
        if (r4 == null) goto L42;
        r3 = Boolean.valueOf(r4.d());
    L42:
        r0.a(new s(r25, r26, r27, r28, r10, r11, r12, r13, r33, r15, r3, r34, r35, r36, r37, r38, r39, r40));
        return;
    L39:
        r15 = null;
        goto L40
    L36:
        r12 = null;
        goto L37
    L32:
        r11 = null;
        goto L34
    L33:
        r11 = r31;
        goto L34
    L27:
        r10 = null;
        goto L29
    L28:
        r10 = r30;
    L22:
        r4 = null;
        goto L23
    L14:
        r13 = null;
        goto L16
    L15:
        r13 = r32;
    L9:
        r2 = (e) ZeusTransformUtils.preCheckCast(this.l.get(), e.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r1 = r29;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.f.a] */
    private final <T> Object a(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r9, d.c.d<? super T> r10) {
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, k.class) == false) goto L7;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r12, k.class, "com.obric.aiagent.plugin");
        if ((r1.f27584e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f27584e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f27582c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f27584e;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        q r8 = (q) ZeusTransformUtils.preCheckCast(r1.f27580a, q.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Throwable -> L15
        q r14 = r8;
    L26:
        q this = r14.f;
        kotlinx.coroutines.f.a.C1058a.b(this, null, 1, null);
        return r13;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r11 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r1.f27581b, d.h.a.b.class, "com.obric.aiagent.plugin");
        q r15 = (q) ZeusTransformUtils.preCheckCast(r1.f27580a, q.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        Object r16 = r15;
    L23:
        r1.f27580a = r16;     // Catch: Throwable -> L15
        r1.f27581b = null;     // Catch: Throwable -> L15
        r1.f27584e = 2;     // Catch: Throwable -> L15
        r13 = r11.invoke(r1);     // Catch: Throwable -> L15
        r14 = r16;
        if (r13 != r3) goto L26;
        return r3;
    L20:
        d.o.a(r13);
        kotlinx.coroutines.f.a r17 = this.f;
        r1.f27580a = this;
        r1.f27581b = r11;
        r1.f27584e = 1;
        this = this;
        if (kotlinx.coroutines.f.a.C1058a.a(r17, null, r1, 1, null) != r3) goto L23;
        return r3;
    L15:
        th = move-exception;
        kotlinx.coroutines.f.a.C1058a.b(this.f, null, 1, null);
        throw th;
    L7:
        r1 = new k(this, r12);
        goto L8
    }
}
