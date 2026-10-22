package com.obric.autogui.agents.vlm.models.impl.f;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.a.d;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.system.IAutoActionSystemApi;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import org.json.JSONObject;

/* JADX INFO: compiled from: SpeculativeViewTreePrefetcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "SpecViewTreePrefetch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f27890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0697b f27891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f27892e;
    private final AtomicBoolean f;
    private final AtomicInteger g;
    private final AtomicInteger h;
    private final AtomicLong i;
    private final AtomicLong j;
    private final AtomicLong k;
    private final AtomicLong l;
    private final AtomicReference<List<ViewHierarchyDump>> m;

    /* JADX INFO: compiled from: SpeculativeViewTreePrefetcher.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a(String r13, String r14) {
            o.e(r13, "stepId");
            o.e(r14, "requestId");
            return new b(r13, r14, new C0697b(d.f28974a.E(), d.f28974a.F(), d.f28974a.G(), d.f28974a.H(), d.f28974a.I(), d.f28974a.J()), null).a();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SpeculativeViewTreePrefetcher.kt */
    private static final class C0697b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f27894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f27895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f27896d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f27897e;
        private final int f;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0697b.class) == true) goto L8;
            return false;
        L8:
            C0697b r10 = (C0697b) ZeusTransformUtils.preCheckCast(r9, C0697b.class, "com.obric.aiagent.plugin");
            if (this.f27893a == r10.f27893a) goto L12;
            return false;
        L12:
            if (this.f27894b == r10.f27894b) goto L15;
            return false;
        L15:
            if (this.f27895c == r10.f27895c) goto L18;
            return false;
        L18:
            if (this.f27896d == r10.f27896d) goto L21;
            return false;
        L21:
            if (this.f27897e == r10.f27897e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.f27893a) * 31) + Long.hashCode(this.f27894b)) * 31) + Long.hashCode(this.f27895c)) * 31) + Long.hashCode(this.f27896d)) * 31) + Long.hashCode(this.f27897e)) * 31) + Integer.hashCode(this.f);
        }

        public String toString() {
            return "Config(enabled=" + this.f27893a + ", initialDelayMs=" + this.f27894b + ", intervalMs=" + this.f27895c + ", expireMs=" + this.f27896d + ", cheapAbortThresholdMs=" + this.f27897e + ", maxDumps=" + this.f + ')';
        }

        public C0697b(boolean r1, long r2, long r4, long r6, long r8, int r10) {
            this.f27893a = r1;
            this.f27894b = r2;
            this.f27895c = r4;
            this.f27896d = r6;
            this.f27897e = r8;
            this.f = r10;
        }

        public final boolean a() {
            return this.f27893a;
        }

        public final long b() {
            return this.f27894b;
        }

        public final long c() {
            return this.f27895c;
        }

        public final long d() {
            return this.f27896d;
        }

        public final long e() {
            return this.f27897e;
        }

        public final int f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: SpeculativeViewTreePrefetcher.kt */
    @f(b = "SpeculativeViewTreePrefetcher.kt", c = {61, 67, 89}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.viewhierarchy.SpeculativeViewTreePrefetcher$start$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f27899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f27901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f27902e;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27901d = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f27901d, r5);
            r0.f27902e = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0186 -> B:19:0x006b). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27900c;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L15;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            long r6 = this.f27899b;
            int r2 = this.f27898a;
            am r8 = (am) ZeusTransformUtils.preCheckCast(this.f27902e, am.class, "com.obric.aiagent.plugin");
            d.o.a(r15);     // Catch: Throwable -> L13
        L28:
            Object r16 = n.f((List) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        L33:
            Throwable r9 = n.c(r16);
            if (r9 == null) goto L37;
            Loog.INSTANCE.e(b.TAG, "dump view hierarchy failed during speculative prefetch", r9);
        L37:
            if (n.b(r16) == false) goto L39;
            r16 = null;
        L39:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
            long r10 = AOSystemTools.INSTANCE.nowTimeMillis() - r6;
            long r7 = AOSystemTools.INSTANCE.nowTimeMillis();
            if (r2 != 1) goto L42;
            b.d(this.f27901d).set(r10);
        L42:
            b.e(this.f27901d).set(r10);
            b.f(this.f27901d).set(r7);
            b.g(this.f27901d).addAndGet(r10);
            if (r17 == null) goto L45;
            b.h(this.f27901d).incrementAndGet();
            b.i(this.f27901d).set(r17);
        L45:
            if (r2 == 1) goto L47;
        L49:
            long r11 = b.a(this.f27901d).c();
            d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27902e = r8;
            this.f27900c = 3;
            if (ax.a(r11, r18) != r0) goto L52;
            return r0;
        L52:
            am r3 = r8;
        L20:
            if (b.b(this.f27901d).get() == false) goto L22;
        L54:
            return x.f38692a;
        L22:
            if (b.c(this.f27901d).get() >= b.a(this.f27901d).f()) goto L54;
            int r19 = b.c(this.f27901d).incrementAndGet();
            long r12 = AOSystemTools.INSTANCE.nowTimeMillis();
            n.a r13 = n.f38560a;     // Catch: Throwable -> L30
            IAutoActionSystemApi r14 = AOPlatformTools.INSTANCE.system();     // Catch: Throwable -> L30
            int r20 = AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId();     // Catch: Throwable -> L30
            this.f27902e = r3;     // Catch: Throwable -> L30
            this.f27898a = r19;     // Catch: Throwable -> L30
            this.f27899b = r12;     // Catch: Throwable -> L30
            this.f27900c = 2;     // Catch: Throwable -> L30
            Object r21 = IAutoActionSystemApi.DefaultImpls.dumpViewHierarchy$default(r14, r20, false, this, 2, null);     // Catch: Throwable -> L30
            if (r21 != r0) goto L27;
            return r0;
        L27:
            r8 = r3;
            r2 = r19;
            r15 = r21;
            r6 = r12;
        L30:
            th = move-exception;
            r8 = r3;
            r2 = r19;
            th = th;
            r6 = r12;
        L32:
            n.a r22 = n.f38560a;
            r16 = n.f(d.o.a(th));
            goto L33
        L47:
            if (r10 > b.a(this.f27901d).e()) goto L49;
            b.j(this.f27901d).set(true);
        L13:
            th = th;
        L15:
            r3 = (am) ZeusTransformUtils.preCheckCast(this.f27902e, am.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
            goto L20
        L16:
            d.o.a(r15);
            r3 = (am) ZeusTransformUtils.preCheckCast(this.f27902e, am.class, "com.obric.aiagent.plugin");
            long r23 = b.a(this.f27901d).b();
            d.c.d r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27902e = r3;
            this.f27900c = 1;
            if (ax.a(r23, r110) != r0) goto L20;
            return r0;
        }
    }

    static {
        f27888a = new a(null);
    }

    public /* synthetic */ b(String r1, String r2, C0697b r3, h r4) {
        this(r1, r2, r3);
    }

    private b(String r3, String r4, C0697b r5) {
        this.f27889b = r3;
        this.f27890c = r4;
        this.f27891d = r5;
        this.f27892e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicInteger(0);
        this.h = new AtomicInteger(0);
        this.i = new AtomicLong(0);
        this.j = new AtomicLong(-1);
        this.k = new AtomicLong(0);
        this.l = new AtomicLong(0);
        this.m = new AtomicReference(null);
    }

    public static final /* synthetic */ C0697b a(b r0) {
        return r0.f27891d;
    }

    public static final /* synthetic */ AtomicBoolean b(b r0) {
        return r0.f27892e;
    }

    public static final /* synthetic */ AtomicInteger c(b r0) {
        return r0.g;
    }

    public static final /* synthetic */ AtomicLong d(b r0) {
        return r0.j;
    }

    public static final /* synthetic */ AtomicLong e(b r0) {
        return r0.k;
    }

    public static final /* synthetic */ AtomicLong f(b r0) {
        return r0.l;
    }

    public static final /* synthetic */ AtomicLong g(b r0) {
        return r0.i;
    }

    public static final /* synthetic */ AtomicInteger h(b r0) {
        return r0.h;
    }

    public static final /* synthetic */ AtomicReference i(b r0) {
        return r0.m;
    }

    public static final /* synthetic */ AtomicBoolean j(b r0) {
        return r0.f;
    }

    public final b a() {
        if (this.f27891d.a() == true) goto L5;
        return this;
    L5:
        AOThreadingTools.INSTANCE.launchIOJob((m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"));
        return this;
    }

    public final com.obric.autogui.agents.vlm.models.impl.f.a a(long r23, long r25) {
        boolean r2 = true;
        this.f27892e.set(true);
        Long r1 = Long.valueOf(this.l.get());
        long r7 = 0;
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        long r9 = r23 - ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue();
    L14:
        if (this.f27891d.a() == true) goto L16;
    L25:
        boolean r4 = false;
    L27:
        if (r4 == false) goto L30;
        String r11 = "hit";
    L48:
        if (r4 == false) goto L50;
        List r13 = (List) ZeusTransformUtils.preCheckCast(this.m.get(), List.class, "com.obric.aiagent.plugin");
    L51:
        if (r13 == null) goto L53;
        r7 = this.k.get();
    L53:
        IAutoActionTrackingApi r14 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("step_id", this.f27889b);
        r5.put("request_id", this.f27890c);
        if (r13 != null) goto L57;
        r2 = false;
    L57:
        r5.put("hit", r2);
        r5.put("miss_reason", r11);
        r5.put("aborted_cheap", this.f.get());
        r5.put("await_ms", r25);
        r5.put("dump_count", this.g.get());
        r5.put("success_count", this.h.get());
        r5.put("first_dump_cost", this.j.get());
        r5.put("last_dump_cost", this.k.get());
        r5.put("latest_age", r9);
        r5.put("theoretical_saving", r7);
        r5.put("total_dump_cost", this.i.get());
        x r6 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r14, "vlm_spec_viewtree_prefetch", r5, false, false, null, 28, null);
        if (r13 != null) goto L60;
        return null;
    L60:
        return new com.obric.autogui.agents.vlm.models.impl.f.a(r13, this.l.get(), this.f27891d.d());
    L50:
        r13 = null;
        goto L51
    L30:
        if (this.f27891d.a() == true) goto L33;
        r11 = "disabled";
        goto L48
    L33:
        if (this.f.get() == false) goto L36;
        r11 = "cheap_abort";
        goto L48
    L36:
        if (this.g.get() != 0) goto L39;
        r11 = "no_dump";
        goto L48
    L39:
        if (this.h.get() != 0) goto L42;
        r11 = "failed";
        goto L48
    L42:
        if (r9 <= this.f27891d.d()) goto L45;
        r11 = "expired";
        goto L48
    L45:
        if (r9 >= 0) goto L47;
        r11 = "no_valid_dump";
        goto L48
    L47:
        r11 = SensitiveType.UNKNOWN;
        goto L48
    L16:
        if (this.f.get() == true) goto L25;
        if (0 <= r9) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L25;
        r4 = true;
        goto L27
    L20:
        if (r9 > this.f27891d.d()) goto L22;
        r8 = true;
        goto L23
    L12:
        r9 = -1;
        goto L14
    L5:
        r3 = false;
        goto L7
    }
}
