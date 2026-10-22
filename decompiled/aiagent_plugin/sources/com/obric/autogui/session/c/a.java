package com.obric.autogui.session.c;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOMetrics.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AO-Metrics";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0837a f30829a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f30830d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f30831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f30832c;

    /* JADX INFO: renamed from: com.obric.autogui.session.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOMetrics.kt */
    public static final class C0837a {
        public /* synthetic */ C0837a(h r1) {
            this();
        }

        private C0837a() {
        }
    }

    /* JADX INFO: compiled from: AOMetrics.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EnumC0838a f30834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f30835c;

        /* JADX INFO: renamed from: com.obric.autogui.session.c.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOMetrics.kt */
        public static final enum EnumC0838a extends Enum<EnumC0838a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0838a f30836a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0838a f30837b = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0838a[] f30838d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final /* synthetic */ d.d.a f30839e = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f30840c;

            private static final /* synthetic */ EnumC0838a[] a() {
                return new EnumC0838a[]{f30836a, f30837b};
            }

            private EnumC0838a(String r1, int r2, String r3) {
                super(r1, r2);
                this.f30840c = r3;
            }

            static {
                f30836a = new EnumC0838a("BEFORE", 0, "bef");
                f30837b = new EnumC0838a("AFTER", 1, "aft");
                EnumC0838a[] r0 = a();
                f30838d = r0;
                f30839e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            public static EnumC0838a valueOf(String r2) {
                return (EnumC0838a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0838a.class, r2), EnumC0838a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0838a[] values() {
                return (EnumC0838a[]) ZeusTransformUtils.preCheckCast(f30838d.clone(), EnumC0838a[].class, "com.obric.aiagent.plugin");
            }
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30833a, r8.f30833a) == true) goto L12;
            return false;
        L12:
            if (this.f30834b == r8.f30834b) goto L15;
            return false;
        L15:
            if (this.f30835c == r8.f30835c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30833a.hashCode() * 31) + this.f30834b.hashCode()) * 31) + Long.hashCode(this.f30835c);
        }

        public String toString() {
            return "EventEntry(name=" + this.f30833a + ", type=" + this.f30834b + ", timestamp=" + this.f30835c + ')';
        }

        public b(String r2, EnumC0838a r3, long r4) {
            o.e(r2, "name");
            o.e(r3, "type");
            this.f30833a = r2;
            this.f30834b = r3;
            this.f30835c = r4;
        }

        public final EnumC0838a getType() {
            return this.f30834b;
        }

        public final long a() {
            return this.f30835c;
        }
    }

    /* JADX INFO: compiled from: AOMetrics.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f30843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f30844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b f30845e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30841a, r6.f30841a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30842b, r6.f30842b) == true) goto L15;
            return false;
        L15:
            if (this.f30843c == r6.f30843c) goto L18;
            return false;
        L18:
            if (o.a(this.f30844d, r6.f30844d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f30845e, r6.f30845e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f30841a.hashCode() * 31) + this.f30842b.hashCode()) * 31) + Integer.hashCode(this.f30843c)) * 31) + this.f30844d.hashCode()) * 31) + this.f30845e.hashCode();
        }

        public String toString() {
            return "ProcedureEntry(phase=" + this.f30841a + ", name=" + this.f30842b + ", code=" + this.f30843c + ", bef=" + this.f30844d + ", aft=" + this.f30845e + ')';
        }

        public c(String r2, String r3, int r4, b r5, b r6) {
            o.e(r2, "phase");
            o.e(r3, "name");
            o.e(r5, "bef");
            o.e(r6, "aft");
            this.f30841a = r2;
            this.f30842b = r3;
            this.f30843c = r4;
            this.f30844d = r5;
            this.f30845e = r6;
        }

        public final String a() {
            return this.f30841a;
        }

        public final String b() {
            return this.f30842b;
        }

        public final long c() {
            return this.f30845e.a() - this.f30844d.a();
        }
    }

    /* JADX INFO: compiled from: AOMetrics.kt */
    @d.c.b.a.f(b = "AOMetrics.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.metrics.AOMetrics$afterProcedure$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f30850e;
        final /* synthetic */ long f;

        d(a r3, String r4, String r5, int r6, long r7, d.c.d<? super d> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30847b = r3;
            this.f30848c = r4;
            this.f30849d = r5;
            this.f30850e = r6;
            this.f = r7;
            super(1, r10);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30847b, this.f30848c, this.f30849d, this.f30850e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f30846a != 0) goto L18;
            d.o.a(r8);
            String r9 = a.a(this.f30847b, this.f30848c, this.f30849d, this.f30850e);
            b r5 = (b) ZeusTransformUtils.preCheckCast(a.a(this.f30847b).get(r9), b.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L8;
            Loog.INSTANCE.w(a.TAG, " - no matching bef event for `" + r9 + "` - ignored.");
            return x.f38692a;
        L8:
            c r10 = new c(this.f30848c, this.f30849d, this.f30850e, r5, new b(this.f30849d, b.EnumC0838a.f30837b, this.f));
            List r0 = a.b(this.f30847b);
            a r1 = this.f30847b;
            monitor-enter(r0);
            a.b(r1).add(r10);     // Catch: Throwable -> L14
            monitor-exit(r0);
            a.a(this.f30847b).remove(this.f30849d);
            return x.f38692a;
        L14:
            th = move-exception;
            throw th;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOMetrics.kt */
    @d.c.b.a.f(b = "AOMetrics.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.metrics.AOMetrics$beforeProcedure$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f30855e;
        final /* synthetic */ long f;

        e(a r3, String r4, String r5, int r6, long r7, d.c.d<? super e> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30852b = r3;
            this.f30853c = r4;
            this.f30854d = r5;
            this.f30855e = r6;
            this.f = r7;
            super(1, r10);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f30852b, this.f30853c, this.f30854d, this.f30855e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f30851a != 0) goto L7;
            d.o.a(r6);
            String r7 = a.a(this.f30852b, this.f30853c, this.f30854d, this.f30855e);
            b r0 = new b(this.f30854d, b.EnumC0838a.f30836a, this.f);
            ((Map) ZeusTransformUtils.preCheckCast(a.a(this.f30852b), Map.class, "com.obric.aiagent.plugin")).put(r7, r0);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOMetrics.kt */
    @d.c.b.a.f(b = "AOMetrics.kt", c = {150}, d = "invokeSuspend", e = "com.obric.autogui.session.metrics.AOMetrics$withJsonedMetrics$2")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m<JSONObject, d.c.d<? super x>, Object> f30858c;

        f(a r3, m<? super JSONObject, ? super d.c.d<? super x>, ? extends Object> r4, d.c.d<? super f> r5) {
            m<JSONObject, d.c.d<? super x>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30857b = r3;
            this.f30858c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f30857b, this.f30858c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30856a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            a r7 = this.f30857b;
            m<JSONObject, d.c.d<? super x>, Object> r2 = this.f30858c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30856a = 1;
            if (a.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AOMetrics.kt */
    @d.c.b.a.f(b = "AOMetrics.kt", c = {142}, d = "invokeSuspend", e = "com.obric.autogui.session.metrics.AOMetrics$withJsonedMetricsAsync$1")
    static final class g extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m<JSONObject, d.c.d<? super x>, Object> f30861c;

        g(a r3, m<? super JSONObject, ? super d.c.d<? super x>, ? extends Object> r4, d.c.d<? super g> r5) {
            m<JSONObject, d.c.d<? super x>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30860b = r3;
            this.f30861c = r6;
            super(1, r7);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f30860b, this.f30861c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30859a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            a r7 = this.f30860b;
            m<JSONObject, d.c.d<? super x>, Object> r2 = this.f30861c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30859a = 1;
            if (a.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public a() {
        this.f30831b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f30832c = new ConcurrentHashMap();
    }

    public static final /* synthetic */ Object a(a r2, m r3, d.c.d r4) {
        return r2.b((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(a r0, String r1, String r2, int r3) {
        return r0.c(r1, r2, r3);
    }

    public static final /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f30832c;
    }

    public static final /* synthetic */ List b(a r0) {
        return r0.f30831b;
    }

    static {
        f30829a = new C0837a(null);
        f30830d = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "ao-metrics-th", false, 2, null);
    }

    private final String c(String r2, String r3, int r4) {
        if (r4 < 0) goto L6;
        return r2 + '.' + r3 + '#' + r4;
    L6:
        return r2 + '.' + r3;
    }

    public static /* synthetic */ void a(a r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = -1;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r11, String r12, int r13) {
        o.e(r11, "phase");
        o.e(r12, "name");
        long r6 = AOSystemTools.INSTANCE.nowTimeMillis();
        f30830d.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this, r11, r12, r13, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void b(a r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = -1;
    L5:
        r0.b(r1, r2, r3);
    }

    public final void b(String r11, String r12, int r13) {
        o.e(r11, "phase");
        o.e(r12, "name");
        long r6 = AOSystemTools.INSTANCE.nowTimeMillis();
        f30830d.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, r11, r12, r13, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void a(m<? super JSONObject, ? super d.c.d<? super x>, ? extends Object> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        o.e(r6, "runnable");
        f30830d.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(m<? super JSONObject, ? super d.c.d<? super x>, ? extends Object> r5, d.c.d<? super x> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = i.a(f30830d.getCoroutineScope().a(), (m) ZeusTransformUtils.preCheckCast(new f(this, r7, null), m.class, "com.obric.aiagent.plugin"), r8);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    private final Object b(m<? super JSONObject, ? super d.c.d<? super x>, ? extends Object> r3, d.c.d<? super x> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = r5.invoke(a(), r6);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    private final JSONObject a() {
        List<c> r0 = this.f30831b;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.f30831b, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        monitor-exit(r0);
        JSONObject r8 = new JSONObject();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        String r7 = r6.a() + "__" + r6.b();
        Object r9 = r3.get(r7);
        if (r9 != null) goto L12;
        r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r3.put(r7, r9);
    L12:
        ((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin")).add(r5);
        goto L8
    L13:
        Iterator r10 = r3.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.aiagent.plugin")).size() > 1) goto L18;
        if (((List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.aiagent.plugin")).size() != 1) goto L15;
        r8.put((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin"), ((c) ZeusTransformUtils.preCheckCast(p.k((List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).c());
        goto L15
    L18:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin");
        long r13 = 0;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.getValue(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        r13 = r13 + ((c) ZeusTransformUtils.preCheckCast(r14.next(), c.class, "com.obric.aiagent.plugin")).c();
        goto L20
    L22:
        r8.put(r12, r13);
        goto L15
    L26:
        return r8;
    L27:
        th = move-exception;
        throw th;
    }
}
