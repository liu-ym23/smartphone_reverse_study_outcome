package com.obric.autogui.agents.a.c;

import android.content.ComponentName;
import com.obric.autogui.agents.a.f.j;
import com.obric.autogui.agents.a.m.r;
import com.obric.autogui.agents.a.m.s;
import com.obric.autogui.agents.a.m.t;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.m;
import d.h.b.l;
import d.h.b.o;
import d.h.b.z;
import d.k;
import d.l.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: ActionEffectEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "ActionEffectEvaluator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26294a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.c.b f26295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<com.obric.autogui.agents.a.f.c, com.obric.autogui.agents.a.b.a> f26296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Long> f26297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<Boolean> f26298e;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.c.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    /* synthetic */ class AnonymousClass1 extends l implements d.h.a.b<com.obric.autogui.agents.a.f.c, com.obric.autogui.agents.a.b.a> {
        AnonymousClass1(Object r8) {
            super(1, r8, com.obric.autogui.agents.a.b.c.class, "create", "create(Lcom/obric/autogui/agents/actioneffect/model/ActionEffectDetectorType;)Lcom/obric/autogui/agents/actioneffect/detector/ActionEffectDetector;", 0);
        }

        public final com.obric.autogui.agents.a.b.a a(com.obric.autogui.agents.a.f.c r3) {
            o.e(r3, "p0");
            return ((com.obric.autogui.agents.a.b.c) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.autogui.agents.a.b.c.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.autogui.agents.a.b.a invoke(com.obric.autogui.agents.a.f.c r3) {
            return a((com.obric.autogui.agents.a.f.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.f.c.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.c.d$2, reason: invalid class name */
    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    /* synthetic */ class AnonymousClass2 extends l implements d.h.a.a<Long> {
        AnonymousClass2(Object r8) {
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

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.c.d$3, reason: invalid class name */
    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    /* synthetic */ class AnonymousClass3 extends l implements d.h.a.a<Boolean> {
        AnonymousClass3(Object r8) {
            super(0, r8, com.obric.autogui.agents.a.k.a.class, "isSecurePage", "isSecurePage()Z", 0);
        }

        public final Boolean a() {
            return Boolean.valueOf(((com.obric.autogui.agents.a.k.a) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.autogui.agents.a.k.a.class, "com.obric.aiagent.plugin")).a());
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.autogui.agents.a.f.b> f26300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.a.f.b f26301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f26302c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26300a, r8.f26300a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f26301b, r8.f26301b) == true) goto L15;
            return false;
        L15:
            if (this.f26302c == r8.f26302c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f26300a.hashCode() * 31) + this.f26301b.hashCode()) * 31) + Long.hashCode(this.f26302c);
        }

        public String toString() {
            return "ActionEffectDetectorBatch(results=" + this.f26300a + ", aggregated=" + this.f26301b + ", elapsedMs=" + this.f26302c + ')';
        }

        public a(List<com.obric.autogui.agents.a.f.b> r3, com.obric.autogui.agents.a.f.b r4, long r5) {
            List<com.obric.autogui.agents.a.f.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r6, "results");
            o.e(r4, "aggregated");
            this.f26300a = r6;
            this.f26301b = r4;
            this.f26302c = r5;
        }

        public final List<com.obric.autogui.agents.a.f.b> a() {
            return this.f26300a;
        }

        public final com.obric.autogui.agents.a.f.b b() {
            return this.f26301b;
        }

        public final long c() {
            return this.f26302c;
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f26303a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f26304b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f26305c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f26306d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f26307e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f26303a, f26304b, f26305c, f26306d};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f26303a = new c("DELAY", 0);
            f26304b = new c("SNAPSHOT", 1);
            f26305c = new c("DETECTOR_BATCH", 2);
            f26306d = new c("AGGREGATION", 3);
            c[] r0 = a();
            f26307e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f26307e.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.c.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    private static final class C0661d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.a<Long> f26308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f26309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f26310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f26311d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f26312e;
        private c f;
        private long g;

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.c.d$d$a */
        /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f26313a = null;

            static {
                int[] r0 = new int[c.values().length];
                r0[c.f26303a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[c.f26304b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[c.f26305c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[c.f26306d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f26313a = r0;
            }
        }

        public C0661d(d.h.a.a<Long> r3) {
            d.h.a.a<Long> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r4, "clockMs");
            this.f26308a = r4;
        }

        public final long a() {
            return this.f26309b;
        }

        public final long b() {
            return this.f26310c;
        }

        public final long c() {
            return this.f26311d;
        }

        public final long d() {
            return this.f26312e;
        }

        public final void a(c r3) {
            o.e(r3, "stage");
            if (this.f != null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L13;
            StringBuilder r4 = new StringBuilder().append("Round timing stage ");
            c r2 = this.f;
            if (r2 == null) goto L10;
            String r5 = r2.name();
        L12:
            throw new IllegalStateException(r4.append(r5).append(" has not finished").toString().toString());
        L10:
            r5 = null;
            goto L12
        L13:
            this.f = r3;
            this.g = ((Number) ZeusTransformUtils.preCheckCast(this.f26308a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final long b(c r8) {
            o.e(r8, "stage");
            if (this.f != r8) goto L5;
            boolean r0 = true;
        L6:
            String r2 = null;
            if (r0 == true) goto L13;
            StringBuilder r1 = new StringBuilder().append("Round timing stage mismatch: expected=");
            c r7 = this.f;
            if (r7 == null) goto L12;
            r2 = r7.name();
        L12:
            throw new IllegalStateException(r1.append(r2).append(", actual=").append(r8.name()).toString().toString());
        L13:
            long r3 = n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26308a.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.g, 0);
            int r9 = a.f26313a[r8.ordinal()];
            if (r9 != 1) goto L16;
            this.f26309b += r3;
        L27:
            this.f = null;
            this.g = 0;
            return r3;
        L16:
            if (r9 != 2) goto L18;
            this.f26310c += r3;
            goto L27
        L18:
            if (r9 != 3) goto L20;
            this.f26311d += r3;
            goto L27
        L20:
            if (r9 != 4) goto L23;
            this.f26312e += r3;
            goto L27
        L23:
            throw new k();
        L5:
            r0 = false;
            goto L6
        }

        public final void e() {
            c r0 = this.f;
            if (r0 == null) goto L6;
            b(r0);
            return;
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    @d.c.b.a.f(b = "ActionEffectEvaluator.kt", c = {194}, d = "evaluate", e = "com.obric.autogui.agents.actioneffect.evaluation.ActionEffectEvaluator")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26318e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        long k;
        long l;
        /* synthetic */ Object m;
        final /* synthetic */ d n;
        int o;

        e(d r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.n = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.m = r10;
            this.o |= Integer.MIN_VALUE;
            return this.n.a(null, null, null, null, false, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    @d.c.b.a.f(b = "ActionEffectEvaluator.kt", c = {220, 245, 247, 281}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.evaluation.ActionEffectEvaluator$evaluate$completed$1")
    static final class f extends d.c.b.a.l implements m<am, d.c.d<? super com.obric.autogui.agents.a.f.i>, Object> {
        long A;
        long B;
        int C;
        final /* synthetic */ int D;
        final /* synthetic */ z.f<com.obric.autogui.agents.a.f.b> E;
        final /* synthetic */ z.f<List<com.obric.autogui.agents.a.f.b>> F;
        final /* synthetic */ d G;
        final /* synthetic */ z.d H;
        final /* synthetic */ z.f<com.obric.autogui.agents.a.f.k> I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        final /* synthetic */ t f26319J;
        final /* synthetic */ j K;
        final /* synthetic */ boolean L;
        final /* synthetic */ boolean M;
        final /* synthetic */ com.obric.autogui.agents.a.a.f N;
        final /* synthetic */ com.obric.autogui.agents.vlm.models.a.a.b O;
        final /* synthetic */ com.obric.autogui.agents.a.l.c P;
        final /* synthetic */ i Q;
        final /* synthetic */ z.f<com.obric.autogui.agents.a.l.c> R;
        final /* synthetic */ com.obric.autogui.agents.a.l.a S;
        final /* synthetic */ boolean T;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f26321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f26322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26324e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Object p;
        Object q;
        Object r;
        Object s;
        Object t;
        Object u;
        boolean v;
        boolean w;
        boolean x;
        long y;
        long z;

        f(int r6, z.f<com.obric.autogui.agents.a.f.b> r7, z.f<List<com.obric.autogui.agents.a.f.b>> r8, d r9, z.d r10, z.f<com.obric.autogui.agents.a.f.k> r11, t r12, j r13, boolean r14, boolean r15, com.obric.autogui.agents.a.a.f r16, com.obric.autogui.agents.vlm.models.a.a.b r17, com.obric.autogui.agents.a.l.c r18, i r19, z.f<com.obric.autogui.agents.a.l.c> r20, com.obric.autogui.agents.a.l.a r21, boolean r22, d.c.d<? super f> r23) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r19, i.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
            this.D = r6;
            this.E = r7;
            this.F = r8;
            this.G = r9;
            this.H = r10;
            this.I = r11;
            this.f26319J = r12;
            this.K = r13;
            this.L = r14;
            this.M = r15;
            this.N = r16;
            this.O = r17;
            this.P = r18;
            this.Q = r1;
            this.R = r20;
            this.S = r21;
            this.T = r22;
            super(2, r2);
        }

        public static /* synthetic */ CharSequence lambda$e8L6UvvGb5AVDu503hwvfCHgCnQ(com.obric.autogui.agents.a.f.b r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.agents.a.f.i> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r23, d.c.d<?> r24) {
            d.c.d r21 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.D, this.E, this.F, this.G, this.H, this.I, this.f26319J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, r21), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.agents.a.f.i> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 33, insn: 0x03b0: MOVE (r2 I:??[OBJECT, ARRAY]) = (r33 I:??[OBJECT, ARRAY]), block:B:24:0x03ae */
        /* JADX WARN: Not initialized variable reg: 33, insn: 0x03bb: MOVE (r2 I:??[OBJECT, ARRAY]) = (r33 I:??[OBJECT, ARRAY]), block:B:26:0x03b9 */
        /* JADX WARN: Not initialized variable reg: 34, insn: 0x03b2: MOVE (r3 I:??[OBJECT, ARRAY]) = (r34 I:??[OBJECT, ARRAY]), block:B:24:0x03ae */
        /* JADX WARN: Not initialized variable reg: 34, insn: 0x03bd: MOVE (r3 I:??[OBJECT, ARRAY]) = (r34 I:??[OBJECT, ARRAY]), block:B:26:0x03b9 */
        /* JADX WARN: Not initialized variable reg: 35, insn: 0x03b4: MOVE (r9 I:??[OBJECT, ARRAY]) = (r35 I:??[OBJECT, ARRAY]), block:B:24:0x03ae */
        /* JADX WARN: Not initialized variable reg: 35, insn: 0x03bf: MOVE (r9 I:??[OBJECT, ARRAY]) = (r35 I:??[OBJECT, ARRAY]), block:B:26:0x03b9 */
        /* JADX WARN: Type inference failed for: r10v23, types: [T, com.obric.autogui.agents.a.f.k] */
        /* JADX WARN: Type inference failed for: r12v22 */
        /* JADX WARN: Type inference failed for: r12v27 */
        /* JADX WARN: Type inference failed for: r12v3, types: [T, com.obric.autogui.agents.a.m.s] */
        /* JADX WARN: Type inference failed for: r12v35 */
        /* JADX WARN: Type inference failed for: r12v36 */
        /* JADX WARN: Type inference failed for: r12v37 */
        /* JADX WARN: Type inference failed for: r12v48 */
        /* JADX WARN: Type inference failed for: r1v39, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v62, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v0, types: [d.h.b.z$f, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v226 */
        /* JADX WARN: Type inference failed for: r2v56, types: [T] */
        /* JADX WARN: Type inference failed for: r2v88 */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.autogui.agents.a.c.d$d, int] */
        /* JADX WARN: Type inference failed for: r3v117 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v41 */
        /* JADX WARN: Type inference failed for: r3v51 */
        /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v85 */
        /* JADX WARN: Type inference failed for: r48v0 */
        /* JADX WARN: Type inference failed for: r48v1 */
        /* JADX WARN: Type inference failed for: r48v2 */
        /* JADX WARN: Type inference failed for: r48v4 */
        /* JADX WARN: Type inference failed for: r48v5 */
        /* JADX WARN: Type inference failed for: r48v6 */
        /* JADX WARN: Type inference failed for: r4v112 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v16, types: [T, com.obric.autogui.agents.a.m.s] */
        /* JADX WARN: Type inference failed for: r4v17, types: [T, com.obric.autogui.agents.a.m.s] */
        /* JADX WARN: Type inference failed for: r4v89 */
        /* JADX WARN: Type inference failed for: r53v0 */
        /* JADX WARN: Type inference failed for: r53v4 */
        /* JADX WARN: Type inference failed for: r53v5 */
        /* JADX WARN: Type inference failed for: r83v0 */
        /* JADX WARN: Type inference failed for: r83v1 */
        /* JADX WARN: Type inference failed for: r83v2 */
        /* JADX WARN: Type inference failed for: r9v17, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r9v18, types: [T, com.obric.autogui.agents.a.f.b] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x062d -> B:67:0x0644). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0687 -> B:359:0x06bc). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r95) {
            f r1 = this;
            ?? r2 = d.c.a.b.a();
            ?? r3 = r1.C;
            String r14 = "com.obric.aiagent.plugin";
            if (r3 == 0) goto L34;
            if (r3 != 1) goto L346;
            String r19 = ", snapshot_elapsed_ms=";
            String r22 = ", status=";
            String r24 = ", round=";
            long r4 = r1.z;
            long r5 = r1.y;
            int r6 = r1.f26323d;
            int r7 = r1.f26322c;
            int r8 = r1.f26321b;
            boolean r9 = r1.x;
            boolean r10 = r1.w;
            boolean r12 = r1.v;
            int r13 = r1.f26320a;
            z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r1.t, z.f.class, "com.obric.aiagent.plugin");
            C0661d r15 = (C0661d) ZeusTransformUtils.preCheckCast(r1.s, C0661d.class, "com.obric.aiagent.plugin");
            z.f r30 = r11;
            com.obric.autogui.agents.a.m.j r16 = (com.obric.autogui.agents.a.m.j) ZeusTransformUtils.preCheckCast(r1.r, com.obric.autogui.agents.a.m.j.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.k> r17 = (z.f) ZeusTransformUtils.preCheckCast(r1.q, z.f.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.b> r18 = (z.f) ZeusTransformUtils.preCheckCast(r1.p, z.f.class, "com.obric.aiagent.plugin");
            z.f<List<com.obric.autogui.agents.a.f.b>> r20 = (z.f) ZeusTransformUtils.preCheckCast(r1.o, z.f.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.a r21 = (com.obric.autogui.agents.a.l.a) ZeusTransformUtils.preCheckCast(r1.n, com.obric.autogui.agents.a.l.a.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.l.c> r23 = (z.f) ZeusTransformUtils.preCheckCast(r1.m, z.f.class, "com.obric.aiagent.plugin");
            i r37 = (i) ZeusTransformUtils.preCheckCast(r1.l, i.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.c r25 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r1.k, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.a.a.b r39 = (com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r1.j, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin");
            z.d r40 = (z.d) ZeusTransformUtils.preCheckCast(r1.i, z.d.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.a.f r26 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r1.h, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
            j r27 = (j) ZeusTransformUtils.preCheckCast(r1.g, j.class, "com.obric.aiagent.plugin");
            d r28 = (d) ZeusTransformUtils.preCheckCast(r1.f, d.class, "com.obric.aiagent.plugin");
            t r29 = (t) ZeusTransformUtils.preCheckCast(r1.f26324e, t.class, "com.obric.aiagent.plugin");
            d.o.a(r95);     // Catch: Throwable -> L30 CancellationException -> L32
            z.f<com.obric.autogui.agents.a.l.c> r110 = r23;
            r14 = "com.obric.aiagent.plugin";
            com.obric.autogui.agents.a.l.c r111 = r25;
            boolean r38 = r10;
            boolean r112 = r9;
            int r31 = r8;
            com.obric.autogui.agents.a.a.f r32 = r26;
            boolean r41 = r12;
            t r33 = r29;
            d r34 = r28;
            C0661d r35 = r15;
            com.obric.autogui.agents.a.m.j r36 = r16;
            z.f<List<com.obric.autogui.agents.a.f.b>> r310 = r20;
            int r113 = r7;
            String r210 = d.TAG;
            int r42 = r13;
            long r114 = r4;
            z.f<com.obric.autogui.agents.a.f.k> r211 = r17;
            z.f<com.obric.autogui.agents.a.f.b> r212 = r18;
            com.obric.autogui.agents.a.l.a r311 = r21;
            long r312 = r5;
            ?? r43 = r2;
            j r44 = r27;
        L67:
            ?? r53 = r43;
            int r58 = r31;
            boolean r59 = r112;
            long r54 = r114;
            z.f r115 = r30;
            z.f<List<com.obric.autogui.agents.a.f.b>> r313 = r310;
            com.obric.autogui.agents.a.l.a r314 = r311;
            long r56 = r312;
            com.obric.autogui.agents.vlm.models.a.a.b r116 = r39;
            z.d r45 = r40;
            int r52 = r42;
            f r315 = r1;
            d r46 = r34;
            com.obric.autogui.agents.a.m.j r117 = r36;
            z.f<com.obric.autogui.agents.a.l.c> r316 = r110;
            t r47 = r33;
            boolean r48 = r38;
            j r317 = r44;
            int r118 = r6;
            i r49 = r37;
            boolean r50 = r41;
            int r89 = r113;
            C0661d r119 = r35;
            int r51 = r89;
        L359:
            z.f r318 = r115;
            com.obric.autogui.agents.a.m.j r319 = r117;
            long r67 = r119.b(c.f26303a);     // Catch: Throwable -> L290 CancellationException -> L292
            if (r50 == true) goto L90;
            if (r51 <= 0) goto L88;
            if (r48 == false) goto L90;
        L88:
            String r120 = r14;
        L89:
            int r213 = r118;
            r119.a(c.f26304b);     // Catch: Throwable -> L286 CancellationException -> L288
            boolean r55 = r48;
            r318 = r318;
            String r320 = r120;
            long r62 = ((Number) ZeusTransformUtils.preCheckCast(d.a(r46).invoke(), Number.class, r120)).longValue();     // Catch: Throwable -> L282 CancellationException -> L284
            if (r51 == 0) goto L344;
            if (r49 == null) goto L143;
            f r57 = r315;
            r57.f26324e = r47;     // Catch: Throwable -> L282 CancellationException -> L284
            r57.f = r46;     // Catch: Throwable -> L282 CancellationException -> L284
            j r121 = r317;
            r57.g = r121;     // Catch: Throwable -> L282 CancellationException -> L284
            r57.h = r32;     // Catch: Throwable -> L282 CancellationException -> L284
            r57.i = r45;     // Catch: Throwable -> L282 CancellationException -> L284
            r57.j = r116;     // Catch: Throwable -> L282 CancellationException -> L284
            r57.k = r111;     // Catch: Throwable -> L282 CancellationException -> L284
            r57.l = r49;     // Catch: Throwable -> L282 CancellationException -> L284
            t r321 = r47;
            z.f<com.obric.autogui.agents.a.l.c> r60 = r316;
            r57.m = r60;     // Catch: Throwable -> L139 CancellationException -> L141
            z.f<com.obric.autogui.agents.a.l.c> r322 = r60;
            com.obric.autogui.agents.a.l.a r61 = r314;
            r57.n = r61;     // Catch: Throwable -> L139 CancellationException -> L141
            com.obric.autogui.agents.a.l.a r323 = r61;
            z.f<List<com.obric.autogui.agents.a.f.b>> r63 = r313;
            r57.o = r63;     // Catch: Throwable -> L139 CancellationException -> L141
            z.f<com.obric.autogui.agents.a.f.b> r64 = r212;
            r57.p = r64;     // Catch: Throwable -> L139 CancellationException -> L141
            z.f<com.obric.autogui.agents.a.f.b> r214 = r64;
            z.f<com.obric.autogui.agents.a.f.k> r65 = r211;
            r57.q = r65;     // Catch: Throwable -> L139 CancellationException -> L141
            r57.r = r319;     // Catch: Throwable -> L139 CancellationException -> L141
            r57.s = r119;     // Catch: Throwable -> L139 CancellationException -> L141
            r319 = r319;
            r57.t = r318;     // Catch: Throwable -> L135 CancellationException -> L137
            r318 = r318;
            int r66 = r52;
            r57.f26320a = r66;     // Catch: Throwable -> L131 CancellationException -> L133
            r57.v = r50;     // Catch: Throwable -> L131 CancellationException -> L133
            int r215 = r66;
            r57.w = r55;     // Catch: Throwable -> L131 CancellationException -> L133
            boolean r68 = r59;
            r57.x = r68;     // Catch: Throwable -> L131 CancellationException -> L133
            int r69 = r58;
            r57.f26321b = r69;     // Catch: Throwable -> L131 CancellationException -> L133
            r57.f26322c = r51;     // Catch: Throwable -> L131 CancellationException -> L133
            r57.f26323d = r213;     // Catch: Throwable -> L131 CancellationException -> L133
            z.f<com.obric.autogui.agents.a.f.k> r324 = r65;
            d r216 = r46;
            long r70 = r56;
            r57.y = r70;     // Catch: Throwable -> L131 CancellationException -> L133
            r57.z = r62;     // Catch: Throwable -> L131 CancellationException -> L133
            long r410 = r70;
            long r71 = r54;
            r57.A = r71;     // Catch: Throwable -> L131 CancellationException -> L133
            long r411 = r71;
            r57.B = r67;     // Catch: Throwable -> L131 CancellationException -> L133
            r57.C = 2;     // Catch: Throwable -> L131 CancellationException -> L133
            Object r72 = r49.a(r213, r57);     // Catch: Throwable -> L131 CancellationException -> L133
            ?? r73 = r53;
            if (r72 != r73) goto L122;
            return r73;
        L122:
            com.obric.autogui.agents.a.a.f r412 = r32;
            j r413 = r121;
            int r122 = r51;
            long r74 = r67;
            f r94 = r57;
            d r75 = r216;
            int r217 = r69;
            z.f<List<com.obric.autogui.agents.a.f.b>> r325 = r63;
            boolean r326 = r55;
            boolean r218 = r68;
            C0661d r327 = r119;
            int r123 = r213;
            ?? r76 = r73;
        L367:
            d r96 = r75;
            String r77 = r320;
            com.obric.autogui.agents.a.c.a r78 = (com.obric.autogui.agents.a.c.a) ZeusTransformUtils.preCheckCast(r72, com.obric.autogui.agents.a.c.a.class, r77);     // Catch: Throwable -> L125 CancellationException -> L128
            r315 = r94;
            r320 = r77;
            r67 = r74;
            r116 = r116;
            r62 = r62;
            r111 = r111;
            int r79 = r217;
            boolean r710 = r218;
            int r711 = r215;
            r212 = r214;
            r316 = r322;
            com.obric.autogui.agents.a.m.j r124 = r319;
            r318 = r318;
            r313 = r325;
            z.f<com.obric.autogui.agents.a.f.k> r610 = r324;
            long r712 = r410;
            long r713 = r411;
            r32 = r412;
            j r80 = r413;
            d r125 = r96;
            ?? r126 = r76;
            r50 = r50;
            i r81 = r49;
            z.d r219 = r45;
            int r97 = r123;
            int r82 = r122;
            r55 = r326;
            com.obric.autogui.agents.a.l.a r83 = r323;
            t r127 = r321;
            r119 = r327;
        L387:
            com.obric.autogui.agents.a.c.b r84 = d.c(r125);     // Catch: Throwable -> L276 CancellationException -> L279
            com.obric.autogui.agents.a.a r220 = r32.k();     // Catch: Throwable -> L276 CancellationException -> L279
            i r328 = r81;
            com.obric.autogui.agents.a.l.a r329 = r83;
            String r85 = "after_" + r82;     // Catch: Throwable -> L276 CancellationException -> L279
            if (r78 != null) goto L381;
            com.obric.autogui.agents.vlm.models.a.a.b r330 = null;
        L153:
            if (r78 == null) goto L156;
            com.obric.autogui.agents.a.l.c r86 = r78.b();     // Catch: Throwable -> L148 CancellationException -> L150
        L157:
            if (r55 == false) goto L159;
        L158:
            boolean r331 = false;
        L162:
            boolean r221 = r55;
            boolean r87 = r50;
            d r88 = r125;
            C0661d r714 = r119;
            com.obric.autogui.agents.a.l.c r128 = r86;
            ?? r90 = r126;
            boolean r129 = r331;
            z.f r332 = r318;
            com.obric.autogui.agents.a.m.j r91 = r124;
            t r92 = r127;
            com.obric.autogui.agents.a.c.c r93 = new com.obric.autogui.agents.a.c.c(r220, r85, r329, r330, r128, r129, r127, com.obric.autogui.agents.a.m.o.f26694c, r97);     // Catch: Throwable -> L272 CancellationException -> L274
            r315.f26324e = r92;     // Catch: Throwable -> L272 CancellationException -> L274
            r315.f = r88;     // Catch: Throwable -> L272 CancellationException -> L274
            r315.g = r80;     // Catch: Throwable -> L272 CancellationException -> L274
            com.obric.autogui.agents.a.a.f r98 = r32;
            r315.h = r98;     // Catch: Throwable -> L272 CancellationException -> L274
            z.d r99 = r219;
            r315.i = r99;     // Catch: Throwable -> L272 CancellationException -> L274
            com.obric.autogui.agents.vlm.models.a.a.b r130 = r116;
            r315.j = r130;     // Catch: Throwable -> L272 CancellationException -> L274
            com.obric.autogui.agents.a.l.c r131 = r111;
            r315.k = r131;     // Catch: Throwable -> L272 CancellationException -> L274
            r315.l = r328;     // Catch: Throwable -> L272 CancellationException -> L274
            z.f<com.obric.autogui.agents.a.l.c> r100 = r316;
            r315.m = r100;     // Catch: Throwable -> L272 CancellationException -> L274
            r315.n = r329;     // Catch: Throwable -> L272 CancellationException -> L274
            z.f<List<com.obric.autogui.agents.a.f.b>> r132 = r313;
            r315.o = r132;     // Catch: Throwable -> L272 CancellationException -> L274
            z.f<com.obric.autogui.agents.a.f.b> r133 = r212;
            r315.p = r133;     // Catch: Throwable -> L272 CancellationException -> L274
            z.f<com.obric.autogui.agents.a.f.k> r134 = r610;
            r315.q = r134;     // Catch: Throwable -> L272 CancellationException -> L274
            com.obric.autogui.agents.a.m.j r135 = r91;
            r315.r = r135;     // Catch: Throwable -> L268 CancellationException -> L270
            t r222 = r92;
            r315.s = r714;     // Catch: Throwable -> L264 CancellationException -> L266
            r714 = r714;
            r315.t = r332;     // Catch: Throwable -> L260 CancellationException -> L262
            r315.u = r100;     // Catch: Throwable -> L260 CancellationException -> L262
            r332 = r332;
            int r101 = r711;
            r315.f26320a = r101;     // Catch: Throwable -> L256 CancellationException -> L258
            r315.v = r87;     // Catch: Throwable -> L256 CancellationException -> L258
            r315.w = r221;     // Catch: Throwable -> L256 CancellationException -> L258
            boolean r102 = r710;
            r315.x = r102;     // Catch: Throwable -> L256 CancellationException -> L258
            int r103 = r79;
            r315.f26321b = r103;     // Catch: Throwable -> L256 CancellationException -> L258
            int r104 = r97;
            r315.f26322c = r104;     // Catch: Throwable -> L256 CancellationException -> L258
            j r333 = r80;
            long r105 = r712;
            r315.y = r105;     // Catch: Throwable -> L256 CancellationException -> L258
            long r106 = r62;
            r315.z = r106;     // Catch: Throwable -> L256 CancellationException -> L258
            long r107 = r713;
            r315.A = r107;     // Catch: Throwable -> L256 CancellationException -> L258
            long r108 = r67;
            r315.B = r108;     // Catch: Throwable -> L256 CancellationException -> L258
            r315.C = 3;     // Catch: Throwable -> L256 CancellationException -> L258
            Object r109 = r84.a(r93, r315);     // Catch: Throwable -> L256 CancellationException -> L258
        L174:
            if (r109 != r90) goto L176;
            return r90;
        L176:
            ?? r810 = r90;
            i r223 = r328;
            f r334 = r315;
            z.f<com.obric.autogui.agents.a.l.c> r136 = r100;
            z.f<com.obric.autogui.agents.a.f.b> r715 = r133;
            z.f<com.obric.autogui.agents.a.f.k> r811 = r134;
            int r137 = r101;
            boolean r812 = r221;
            boolean r813 = r102;
            boolean r814 = r87;
            z.f r335 = r332;
            int r815 = r103;
            j r224 = r333;
            long r816 = r107;
            long r336 = r108;
            C0661d r138 = r714;
            ?? r139 = r109;
            com.obric.autogui.agents.a.l.a r225 = r329;
            com.obric.autogui.agents.vlm.models.a.a.b r337 = r130;
            com.obric.autogui.agents.a.l.c r338 = r131;
            t r140 = r222;
            int r141 = r104;
            long r142 = r106;
            z.f<List<com.obric.autogui.agents.a.f.b>> r226 = r132;
            long r143 = r105;
        L363:
            r100.f38504a = r139;     // Catch: Throwable -> L250 CancellationException -> L253
            long r144 = d.a(r88, r142);     // Catch: Throwable -> L250 CancellationException -> L253
            r138.b(c.f26304b);     // Catch: Throwable -> L250 CancellationException -> L253
            com.obric.autogui.agents.a.l.c r145 = r136.f38504a;     // Catch: Throwable -> L250 CancellationException -> L253
            z.f<com.obric.autogui.agents.a.l.c> r339 = r136;
            String r146 = r320;
            if (((com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r145, com.obric.autogui.agents.a.l.c.class, r146)).e() == false) goto L182;
            long r147 = d.a(r88, r143);     // Catch: Throwable -> L250 CancellationException -> L253
            com.obric.autogui.agents.a.f.i r148 = new com.obric.autogui.agents.a.f.i(com.obric.autogui.agents.a.f.k.f26443b, com.obric.autogui.agents.a.f.k.f26443b, null, "snapshot provider reported secure page", p.b(), r99.f38502a, null, null, null, 448, null);     // Catch: Throwable -> L250 CancellationException -> L253
            Loog.INSTANCE.i(r210, "[OAutoActionEffect] sample short-circuited " + com.obric.autogui.agents.a.c.f26286a.a(r98) + r24 + r141 + '/' + r137 + r22 + com.obric.autogui.agents.a.f.k.f26443b + ", reason=secure_snapshot, delay_elapsed_ms=" + r336 + r19 + r144 + ", detector_batch_elapsed_ms=0, round_elapsed_ms=" + r147 + ", detect_count=" + r99.f38502a);     // Catch: Throwable -> L250 CancellationException -> L253
            a(r138, r140, r135, r335);
            return r148;
        L182:
            z.f r149 = r335;
            long r150 = r336;
            String r340 = r24;
            String r227 = r19;
            String r151 = r22;
            r138.a(c.f26305c);     // Catch: Throwable -> L246 CancellationException -> L248
            com.obric.autogui.agents.a.l.c r414 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r339.f38504a, com.obric.autogui.agents.a.l.c.class, r146);     // Catch: Throwable -> L246 CancellationException -> L248
            f r152 = r334;
            r152.f26324e = r140;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.f = r88;     // Catch: Throwable -> L246 CancellationException -> L248
            j r153 = r224;
            r152.g = r153;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.h = r98;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.i = r99;     // Catch: Throwable -> L246 CancellationException -> L248
            z.d r228 = r99;
            com.obric.autogui.agents.vlm.models.a.a.b r154 = r337;
            r152.j = r154;     // Catch: Throwable -> L246 CancellationException -> L248
            com.obric.autogui.agents.vlm.models.a.a.b r341 = r154;
            com.obric.autogui.agents.a.l.c r155 = r338;
            r152.k = r155;     // Catch: Throwable -> L246 CancellationException -> L248
            com.obric.autogui.agents.a.l.c r342 = r155;
            i r156 = r223;
            r152.l = r156;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.m = r339;     // Catch: Throwable -> L246 CancellationException -> L248
            com.obric.autogui.agents.a.l.a r157 = r225;
            r152.n = r157;     // Catch: Throwable -> L246 CancellationException -> L248
            z.f<List<com.obric.autogui.agents.a.f.b>> r158 = r226;
            r152.o = r158;     // Catch: Throwable -> L246 CancellationException -> L248
            z.f<com.obric.autogui.agents.a.f.b> r159 = r715;
            r152.p = r159;     // Catch: Throwable -> L246 CancellationException -> L248
            z.f<com.obric.autogui.agents.a.f.k> r160 = r811;
            r152.q = r160;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.r = r135;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.s = r138;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.t = r149;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.u = null;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.f26320a = r137;     // Catch: Throwable -> L246 CancellationException -> L248
            boolean r161 = r814;
            r152.v = r161;     // Catch: Throwable -> L246 CancellationException -> L248
            boolean r162 = r812;
            r152.w = r162;     // Catch: Throwable -> L246 CancellationException -> L248
            boolean r163 = r813;
            r152.x = r163;     // Catch: Throwable -> L246 CancellationException -> L248
            int r164 = r815;
            r152.f26321b = r164;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.f26322c = r141;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.y = r143;     // Catch: Throwable -> L246 CancellationException -> L248
            long r415 = r143;
            long r165 = r816;
            r152.z = r165;     // Catch: Throwable -> L246 CancellationException -> L248
            r152.A = r150;     // Catch: Throwable -> L246 CancellationException -> L248
            long r343 = r150;
            r152.B = r144;     // Catch: Throwable -> L246 CancellationException -> L248
            int r416 = r164;
            r152.C = 4;     // Catch: Throwable -> L246 CancellationException -> L248
            Object r166 = d.a(r88, r98, r414, r141, r137, r140, r152);     // Catch: Throwable -> L246 CancellationException -> L248
            int r417 = r141;
            ?? r167 = r810;
            if (r166 != r167) goto L187;
            return r167;
        L187:
            ?? r418 = r167;
            t r910 = r140;
            com.obric.autogui.agents.a.a.f r168 = r98;
            f r911 = r152;
            boolean r510 = r161;
            z.f<com.obric.autogui.agents.a.l.c> r817 = r339;
            boolean r511 = r162;
            boolean r419 = r163;
            int r169 = r137;
            d r170 = r88;
            com.obric.autogui.agents.a.l.a r344 = r157;
            z.f<com.obric.autogui.agents.a.f.b> r171 = r159;
            z.f<com.obric.autogui.agents.a.f.k> r172 = r160;
            long r345 = r165;
            long r229 = r144;
            z.f r230 = r149;
            long r173 = r415;
            i r420 = r156;
            z.f<List<com.obric.autogui.agents.a.f.b>> r174 = r158;
            j r421 = r153;
            z.d r175 = r228;
            com.obric.autogui.agents.a.m.j r231 = r135;
            int r176 = r417;
        L334:
            a r177 = (a) ZeusTransformUtils.preCheckCast(r166, a.class, r146);     // Catch: Throwable -> L240 CancellationException -> L243
            r138.b(c.f26305c);     // Catch: Throwable -> L240 CancellationException -> L243
            r175.f38502a++;     // Catch: Throwable -> L240 CancellationException -> L243
            r174.f38504a = r177.a();     // Catch: Throwable -> L240 CancellationException -> L243
            r171.f38504a = r177.b();     // Catch: Throwable -> L240 CancellationException -> L243
            r138.a(c.f26306d);     // Catch: Throwable -> L240 CancellationException -> L243
            if (r419 == true) goto L371;
            com.obric.autogui.agents.a.f.b r178 = r177.b();     // Catch: Throwable -> L240 CancellationException -> L243
        L197:
            r138.b(c.f26306d);     // Catch: Throwable -> L240 CancellationException -> L243
            long r179 = d.a(r170, r173);     // Catch: Throwable -> L240 CancellationException -> L243
            if (r172.f38504a != null) goto L200;
            r172.f38504a = r178.b();     // Catch: Throwable -> L192 CancellationException -> L194
        L200:
            z.f<com.obric.autogui.agents.a.f.b> r346 = r171;
            if (r178.b() != com.obric.autogui.agents.a.f.k.f26443b) goto L203;
        L206:
            boolean r180 = true;
        L207:
            Loog r181 = Loog.INSTANCE;     // Catch: Throwable -> L240 CancellationException -> L243
            C0661d r422 = r138;
            StringBuilder r182 = new StringBuilder();     // Catch: Throwable -> L236 CancellationException -> L238
            d r347 = r170;
            z.f<com.obric.autogui.agents.a.f.k> r423 = r172;
            String r183 = r340;
            StringBuilder r184 = r182.append("[OAutoActionEffect] sample ").append(com.obric.autogui.agents.a.c.f26286a.a(r168)).append(r183).append(r176).append('/').append(r169).append(", delay_requested_ms=");     // Catch: Throwable -> L236 CancellationException -> L238
            z.f<List<com.obric.autogui.agents.a.f.b>> r232 = r174;
            int r185 = r169;
            z.d r348 = r175;
            String r186 = r227;
            r184.append(n.a(r345, 0)).append(", delay_elapsed_ms=").append(r343).append(r186).append(r229).append(", detector_batch_elapsed_ms=").append(r177.c()).append(", round_elapsed_ms=").append(r179).append(", aggregated_status=").append(r178.b()).append(", served_detector=").append(r178.a().a()).append(", served_reason=").append(com.obric.autogui.agents.a.b.a(r178.c(), 240)).append(", detector_results=");     // Catch: Throwable -> L236 CancellationException -> L238
            StringBuilder r187 = r182.append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r232.f38504a, Iterable.class, r146), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, r146), null, null, 0, null, $$Lambda$d$f$e8L6UvvGb5AVDu503hwvfCHgCnQ.INSTANCE, 30, null)).append(", available_component=");     // Catch: Throwable -> L236 CancellationException -> L238
            z.f<com.obric.autogui.agents.a.l.c> r188 = r817;
            if (((com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r188.f38504a, com.obric.autogui.agents.a.l.c.class, r146)).a() == null) goto L212;
            boolean r189 = true;
        L213:
            StringBuilder r190 = r187.append(r189).append(", available_viewtree=");     // Catch: Throwable -> L236 CancellationException -> L238
            if (((com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r188.f38504a, com.obric.autogui.agents.a.l.c.class, r146)).b() == null) goto L216;
            boolean r191 = true;
        L217:
            StringBuilder r192 = r190.append(r191).append(", available_image=");     // Catch: Throwable -> L236 CancellationException -> L238
            if (((com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r188.f38504a, com.obric.autogui.agents.a.l.c.class, r146)).c() == null) goto L220;
            boolean r193 = true;
        L221:
            r192.append(r193).append(", secure=").append(((com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r188.f38504a, com.obric.autogui.agents.a.l.c.class, r146)).e()).append(", snapshot_error_count=").append(((com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r188.f38504a, com.obric.autogui.agents.a.l.c.class, r146)).f());     // Catch: Throwable -> L236 CancellationException -> L238
            String r194 = r210;
            r181.i(r194, r182.toString());     // Catch: Throwable -> L236 CancellationException -> L238
            if (r180 == false) goto L235;
            List r195 = (List) ZeusTransformUtils.preCheckCast(r232.f38504a, List.class, r146);     // Catch: Throwable -> L236 CancellationException -> L238
            int r196 = r348.f38502a;     // Catch: Throwable -> L236 CancellationException -> L238
            com.obric.autogui.agents.a.f.k r197 = (com.obric.autogui.agents.a.f.k) ZeusTransformUtils.preCheckCast(r423.f38504a, com.obric.autogui.agents.a.f.k.class, r146);     // Catch: Throwable -> L236 CancellationException -> L238
            if (r197 != null) goto L232;
            r197 = com.obric.autogui.agents.a.f.k.f;     // Catch: Throwable -> L227 CancellationException -> L229
        L229:
            e = move-exception;
            CancellationException r198 = e;
            z.f r199 = r230;
        L310:
            r199.f38504a = com.obric.autogui.agents.a.c.e.a(r198);     // Catch: Throwable -> L312
            throw r198;     // Catch: Throwable -> L312
        L227:
            th = move-exception;
            Throwable r200 = th;
            z.f r201 = r230;
        L304:
            r201.f38504a = s.f26713d;     // Catch: Throwable -> L312
            throw r200;     // Catch: Throwable -> L312
        L232:
            com.obric.autogui.agents.a.f.i r202 = d.a(r347, r178, r195, r196, r197, null, 16, null);     // Catch: Throwable -> L236 CancellationException -> L238
            a(r422, r910, r231, r230);
            return r202;
        L235:
            t r203 = r910;
            a(r422, r203, r231, r230);
            r113 = r416 + 1;
            r14 = r146;
            r45 = r348;
            r211 = r423;
            r24 = r183;
            r210 = r194;
            r22 = r151;
            r116 = r341;
            com.obric.autogui.agents.a.l.c r1100 = r342;
            r212 = r346;
            com.obric.autogui.agents.a.l.a r204 = r344;
            r46 = r347;
            r44 = r421;
            r32 = r168;
            r19 = r186;
            i r1101 = r420;
            r1 = r911;
            z.f<List<com.obric.autogui.agents.a.f.b>> r205 = r232;
            t r206 = r203;
            int r207 = r185;
            r110 = r188;
            ?? r424 = r418;
        L35:
            if (r113 >= r207) goto L315;
            int r349 = r207;
            int r208 = r113 + 1;
            z.f<List<com.obric.autogui.agents.a.f.b>> r350 = r205;
            com.obric.autogui.agents.a.m.j r912 = r206.a(r208);
            r35 = new C0661d(d.a(r46));
            com.obric.autogui.agents.a.l.a r351 = r204;
            com.obric.autogui.agents.a.l.c r352 = r1100;
            r49 = r1101;
            long r1102 = ((Number) ZeusTransformUtils.preCheckCast(d.a(r46).invoke(), Number.class, r14)).longValue();
            z.f r209 = new z.f();
            r209.f38504a = s.f26710a;
            Long r1103 = d.c.b.a.b.a(r44.c());     // Catch: Throwable -> L300 CancellationException -> L306
            ((Number) ZeusTransformUtils.preCheckCast(r1103, Number.class, r14)).longValue();     // Catch: Throwable -> L300 CancellationException -> L306
            if (r113 <= 0) goto L40;
            boolean r1104 = true;
        L41:
            if (r1104 == true) goto L44;
            r1103 = null;
        L44:
            if (r1103 != null) goto L377;
            r114 = 0;
        L52:
            r35.a(c.f26303a);     // Catch: Throwable -> L300 CancellationException -> L306
            if (r114 <= 0) goto L80;
            r1.f26324e = r206;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.f = r46;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.g = r44;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.h = r32;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.i = r45;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.j = r116;     // Catch: Throwable -> L300 CancellationException -> L306
            r111 = r352;
            r1.k = r111;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.l = r49;     // Catch: Throwable -> L300 CancellationException -> L306
            r1.m = r110;     // Catch: Throwable -> L300 CancellationException -> L306
            r33 = r206;
            r1.n = r351;     // Catch: Throwable -> L76 CancellationException -> L78
            r311 = r351;
            r1.o = r350;     // Catch: Throwable -> L76 CancellationException -> L78
            r310 = r350;
            z.f<com.obric.autogui.agents.a.f.b> r233 = r212;
            r1.p = r233;     // Catch: Throwable -> L76 CancellationException -> L78
            r212 = r233;
            z.f<com.obric.autogui.agents.a.f.k> r234 = r211;
            r1.q = r234;     // Catch: Throwable -> L76 CancellationException -> L78
            r211 = r234;
            r1.r = r912;     // Catch: Throwable -> L72 CancellationException -> L74
            r1.s = r35;     // Catch: Throwable -> L72 CancellationException -> L74
            r1.t = r209;     // Catch: Throwable -> L72 CancellationException -> L74
            r912 = r912;
            r1.f26320a = r349;     // Catch: Throwable -> L76 CancellationException -> L78
            boolean r235 = r510;
            r1.v = r235;     // Catch: Throwable -> L76 CancellationException -> L78
            boolean r236 = r511;
            r1.w = r236;     // Catch: Throwable -> L76 CancellationException -> L78
            r38 = r236;
            boolean r237 = r419;
            r1.x = r237;     // Catch: Throwable -> L76 CancellationException -> L78
            r1.f26321b = r113;     // Catch: Throwable -> L76 CancellationException -> L78
            r1.f26322c = r113;     // Catch: Throwable -> L76 CancellationException -> L78
            r1.f26323d = r208;     // Catch: Throwable -> L76 CancellationException -> L78
            z.f r913 = r209;
            r1.y = r1102;     // Catch: Throwable -> L68 CancellationException -> L70
            r1.z = r114;     // Catch: Throwable -> L68 CancellationException -> L70
            r312 = r1102;
            r1.C = 1;     // Catch: Throwable -> L68 CancellationException -> L70
            ?? r238 = r424;
            if (ax.a(r114, r1) != r238) goto L66;
            return r238;
        L66:
            r34 = r46;
            r42 = r349;
            r41 = r235;
            r30 = r913;
            r43 = r238;
            r37 = r49;
            r6 = r208;
            r36 = r912;
            r40 = r45;
            r31 = r113;
            r39 = r116;
            r112 = r237;
            goto L67
        L70:
            e = e;
        L309:
            r199 = r913;
            r198 = e;
        L68:
            th = th;
        L303:
            r201 = r913;
            r200 = th;
            goto L304
        L74:
            e = e;
            r912 = r912;
        L308:
            r913 = r209;
        L72:
            th = th;
            r912 = r912;
        L302:
            r913 = r209;
        L78:
            e = e;
        L76:
            th = th;
            goto L302
        L80:
            r111 = r352;
            r53 = r424;
            r58 = r113;
            r54 = r114;
            r52 = r349;
            r313 = r350;
            r314 = r351;
            r47 = r206;
            r56 = r1102;
            r48 = r511;
            r59 = r419;
            r115 = r209;
            r117 = r912;
            r315 = r1;
            r317 = r44;
            r316 = r110;
            r50 = r510;
            r118 = r208;
            r119 = r35;
            r51 = r58;
            goto L359
        L377:
            r114 = r1103.longValue();     // Catch: Throwable -> L47 CancellationException -> L49
        L49:
            e = move-exception;
            r198 = e;
            r199 = r209;
        L47:
            th = move-exception;
            r200 = th;
            r201 = r209;
            goto L304
        L40:
            r1104 = false;
        L306:
            e = e;
            r33 = r206;
        L300:
            th = th;
            r33 = r206;
            goto L302
        L315:
            String r239 = r14;
            com.obric.autogui.agents.a.j.a r240 = com.obric.autogui.agents.a.j.a.f26523a;
            com.obric.autogui.agents.a.f.b r241 = (com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r1.E.f38504a, com.obric.autogui.agents.a.f.b.class, r239);
            if (r241 != null) goto L318;
            r241 = com.obric.autogui.agents.a.j.a.f26523a.a((List) ZeusTransformUtils.preCheckCast(r1.F.f38504a, List.class, r239));
        L318:
            com.obric.autogui.agents.a.f.b r242 = r240.a(r241);
            com.obric.autogui.agents.a.f.k r243 = r242.b();
            d r244 = r1.G;
            List r245 = (List) ZeusTransformUtils.preCheckCast(r1.F.f38504a, List.class, r239);
            int r246 = r1.H.f38502a;
            com.obric.autogui.agents.a.f.k r247 = (com.obric.autogui.agents.a.f.k) ZeusTransformUtils.preCheckCast(r1.I.f38504a, com.obric.autogui.agents.a.f.k.class, r239);
            if (r247 != null) goto L321;
            r247 = com.obric.autogui.agents.a.f.k.f;
        L321:
            com.obric.autogui.agents.a.f.k r248 = r247;
            if (r243 != com.obric.autogui.agents.a.f.k.f26445d) goto L326;
            com.obric.autogui.agents.a.f.e r249 = com.obric.autogui.agents.a.f.e.f26412a;
        L330:
            return d.a(r244, r242, r245, r246, r248, r249);
        L326:
            if (r243 != com.obric.autogui.agents.a.f.k.f26446e) goto L328;
            r249 = com.obric.autogui.agents.a.f.e.f26415d;
            goto L330
        L328:
            r249 = com.obric.autogui.agents.a.f.e.f26413b;
            goto L330
        L220:
            r193 = false;
            goto L221
        L216:
            r191 = false;
            goto L217
        L212:
            r189 = false;
        L238:
            e = e;
            r138 = r422;
        L245:
            r198 = e;
            r199 = r230;
        L236:
            th = th;
            r138 = r422;
        L242:
            r200 = th;
            r201 = r230;
            goto L304
        L203:
            if (r178.b() == com.obric.autogui.agents.a.f.k.f26442a) goto L206;
            r180 = false;
            goto L207
        L371:
            r178 = com.obric.autogui.agents.a.j.a.f26523a.a(r177.b());     // Catch: Throwable -> L192 CancellationException -> L194
        L194:
            e = move-exception;
            r198 = e;
            r199 = r230;
        L192:
            th = move-exception;
            r200 = th;
            r201 = r230;
            goto L304
        L243:
            e = e;
        L240:
            th = th;
            goto L242
        L248:
            e = e;
        L255:
            r198 = e;
            r199 = r149;
        L246:
            th = th;
        L252:
            r200 = th;
            r201 = r149;
        L253:
            e = e;
            r149 = r335;
        L250:
            th = th;
            r149 = r335;
        L258:
            e = e;
        L281:
            r198 = e;
            r199 = r332;
        L256:
            th = th;
        L278:
            r200 = th;
            r201 = r332;
            goto L304
        L262:
            e = e;
            r332 = r332;
        L260:
            th = th;
            r332 = r332;
            goto L278
        L266:
            e = e;
            r714 = r714;
        L264:
            th = th;
            r714 = r714;
            goto L278
        L270:
            e = e;
            r222 = r92;
        L268:
            th = th;
            r222 = r92;
            goto L278
        L274:
            e = e;
            r222 = r92;
            r135 = r91;
        L272:
            th = th;
            r222 = r92;
            r135 = r91;
            goto L278
        L159:
            if (r50 == true) goto L161;
            if (r82 <= 0) goto L158;
        L161:
            r331 = true;
            goto L162
        L156:
            r86 = null;
            goto L157
        L381:
            r330 = r78.a();     // Catch: Throwable -> L148 CancellationException -> L150
        L150:
            e = move-exception;
            r198 = e;
            r199 = r318;
        L148:
            th = move-exception;
            r200 = th;
            r201 = r318;
        L279:
            e = e;
            r714 = r119;
            r332 = r318;
            r222 = r127;
            r135 = r124;
        L276:
            th = th;
            r714 = r119;
            r332 = r318;
            r222 = r127;
            r135 = r124;
            goto L278
        L128:
            e = move-exception;
            r198 = e;
        L130:
            r199 = r318;
        L125:
            th = move-exception;
            r200 = th;
        L127:
            r201 = r318;
            goto L304
        L133:
            e = e;
        L299:
            r198 = e;
        L131:
            th = th;
        L296:
            r200 = th;
            goto L127
        L137:
            e = e;
            r318 = r318;
        L135:
            th = th;
            r318 = r318;
            goto L296
        L141:
            e = e;
            r319 = r319;
        L139:
            th = th;
            r319 = r319;
            goto L296
        L143:
            j r1105 = r317;
            r97 = r213;
            r80 = r1105;
            r125 = r46;
            r711 = r52;
            r127 = r47;
            r710 = r59;
            r124 = r319;
            r79 = r58;
            r610 = r211;
            r712 = r56;
            r713 = r54;
            r78 = null;
            ?? r1106 = r53;
        L144:
            r219 = r45;
            r83 = r314;
            int r818 = r51;
            r81 = r49;
            r82 = r818;
            r126 = r1106;
            goto L387
        L344:
            com.obric.autogui.agents.a.c.a r250 = new com.obric.autogui.agents.a.c.a(r116, r111);     // Catch: Throwable -> L106 CancellationException -> L108
            r127 = r47;
            r97 = r213;
            r610 = r211;
            r711 = r52;
            r1106 = r53;
            r713 = r54;
            r712 = r56;
            r79 = r58;
            r710 = r59;
            r124 = r319;
            r78 = r250;
            r125 = r46;
            r80 = r317;
            goto L144
        L108:
            e = move-exception;
            r199 = r318;
            r198 = e;
        L106:
            th = move-exception;
            r201 = r318;
            r200 = th;
        L284:
            e = e;
            r319 = r319;
        L293:
            r321 = r47;
        L282:
            th = th;
            r319 = r319;
        L291:
            r321 = r47;
            goto L296
        L288:
            e = e;
            r319 = r319;
            r321 = r47;
            r318 = r318;
        L286:
            th = th;
            r319 = r319;
            r321 = r47;
            r318 = r318;
        L90:
            r120 = r14;
            if (((Boolean) ZeusTransformUtils.preCheckCast(d.b(r46).invoke(), Boolean.class, r120)).booleanValue() == false) goto L89;
            Loog.INSTANCE.i(r210, "[OAutoActionEffect] evaluation short-circuited " + com.obric.autogui.agents.a.c.f26286a.a(r32) + r24 + r118 + r22 + com.obric.autogui.agents.a.f.k.f26443b + ", reason=secure_page_before_snapshot");     // Catch: Throwable -> L95 CancellationException -> L97
            com.obric.autogui.agents.a.f.i r251 = new com.obric.autogui.agents.a.f.i(com.obric.autogui.agents.a.f.k.f26443b, com.obric.autogui.agents.a.f.k.f26443b, null, "active operating space is secure", p.b(), r45.f38502a, null, null, null, 448, null);     // Catch: Throwable -> L95 CancellationException -> L97
            a(r119, r47, r319, r318);
            return r251;
        L97:
            e = move-exception;
            r198 = e;
            r199 = r318;
        L95:
            th = move-exception;
            r200 = th;
            r201 = r318;
            goto L304
        L292:
            e = e;
        L290:
            th = th;
            goto L291
        L297:
            e = e;
            r321 = r47;
            r318 = r115;
            r319 = r117;
        L294:
            th = th;
            r321 = r47;
            r318 = r115;
            r319 = r117;
            goto L296
        L32:
            e = move-exception;
            r198 = e;
            r199 = r30;
        L30:
            th = move-exception;
            r200 = th;
            r201 = r30;
            goto L304
        L346:
            if (r3 == 2) goto L20;
            if (r3 == 3) goto L17;
            if (r3 != 4) goto L16;
            long r252 = r1.B;
            long r253 = r1.A;
            long r254 = r1.z;
            long r255 = r1.y;
            r176 = r1.f26322c;
            int r1107 = r1.f26321b;
            boolean r1108 = r1.x;
            boolean r256 = r1.w;
            boolean r257 = r1.v;
            int r258 = r1.f26320a;
            z.f r259 = (z.f) ZeusTransformUtils.preCheckCast(r1.t, z.f.class, "com.obric.aiagent.plugin");
            C0661d r260 = (C0661d) ZeusTransformUtils.preCheckCast(r1.s, C0661d.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.m.j r261 = (com.obric.autogui.agents.a.m.j) ZeusTransformUtils.preCheckCast(r1.r, com.obric.autogui.agents.a.m.j.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.k> r262 = (z.f) ZeusTransformUtils.preCheckCast(r1.q, z.f.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.b> r263 = (z.f) ZeusTransformUtils.preCheckCast(r1.p, z.f.class, "com.obric.aiagent.plugin");
            z.f<List<com.obric.autogui.agents.a.f.b>> r264 = (z.f) ZeusTransformUtils.preCheckCast(r1.o, z.f.class, "com.obric.aiagent.plugin");
            r344 = (com.obric.autogui.agents.a.l.a) ZeusTransformUtils.preCheckCast(r1.n, com.obric.autogui.agents.a.l.a.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.l.c> r265 = (z.f) ZeusTransformUtils.preCheckCast(r1.m, z.f.class, "com.obric.aiagent.plugin");
            r420 = (i) ZeusTransformUtils.preCheckCast(r1.l, i.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.c r266 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r1.k, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.a.a.b r267 = (com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r1.j, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin");
            z.d r268 = (z.d) ZeusTransformUtils.preCheckCast(r1.i, z.d.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.a.f r269 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r1.h, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
            r421 = (j) ZeusTransformUtils.preCheckCast(r1.g, j.class, "com.obric.aiagent.plugin");
            d r270 = (d) ZeusTransformUtils.preCheckCast(r1.f, d.class, "com.obric.aiagent.plugin");
            t r271 = (t) ZeusTransformUtils.preCheckCast(r1.f26324e, t.class, "com.obric.aiagent.plugin");
            d.o.a(r95);     // Catch: Throwable -> L11 CancellationException -> L13
            r911 = r1;
            r210 = d.TAG;
            r419 = r1108;
            r418 = r2;
            r511 = r256;
            r510 = r257;
            r169 = r258;
            r231 = r261;
            r172 = r262;
            r174 = r264;
            r817 = r265;
            r341 = r267;
            r168 = r269;
            r229 = r252;
            r416 = r1107;
            r170 = r270;
            r138 = r260;
            r146 = "com.obric.aiagent.plugin";
            r175 = r268;
            r166 = r95;
            r910 = r271;
            r227 = ", snapshot_elapsed_ms=";
            r151 = ", status=";
            r230 = r259;
            r343 = r253;
            r342 = r266;
            r340 = ", round=";
            r171 = r263;
            r345 = r254;
            r173 = r255;
            goto L334
        L13:
            e = move-exception;
            r198 = e;
            r199 = r259;
        L11:
            th = move-exception;
            r200 = th;
            r201 = r259;
            goto L304
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            r19 = ", snapshot_elapsed_ms=";
            r24 = ", round=";
            long r272 = r1.B;
            long r273 = r1.A;
            long r274 = r1.z;
            long r275 = r1.y;
            int r1109 = r1.f26322c;
            int r1110 = r1.f26321b;
            boolean r1111 = r1.x;
            boolean r1112 = r1.w;
            boolean r276 = r1.v;
            int r277 = r1.f26320a;
            z.f<com.obric.autogui.agents.a.l.c> r278 = (z.f) ZeusTransformUtils.preCheckCast(r1.u, z.f.class, "com.obric.aiagent.plugin");
            z.f r279 = (z.f) ZeusTransformUtils.preCheckCast(r1.t, z.f.class, "com.obric.aiagent.plugin");
            C0661d r280 = (C0661d) ZeusTransformUtils.preCheckCast(r1.s, C0661d.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.m.j r281 = (com.obric.autogui.agents.a.m.j) ZeusTransformUtils.preCheckCast(r1.r, com.obric.autogui.agents.a.m.j.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.k> r282 = (z.f) ZeusTransformUtils.preCheckCast(r1.q, z.f.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.b> r283 = (z.f) ZeusTransformUtils.preCheckCast(r1.p, z.f.class, "com.obric.aiagent.plugin");
            z.f<List<com.obric.autogui.agents.a.f.b>> r284 = (z.f) ZeusTransformUtils.preCheckCast(r1.o, z.f.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.a r285 = (com.obric.autogui.agents.a.l.a) ZeusTransformUtils.preCheckCast(r1.n, com.obric.autogui.agents.a.l.a.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.l.c> r286 = (z.f) ZeusTransformUtils.preCheckCast(r1.m, z.f.class, "com.obric.aiagent.plugin");
            i r287 = (i) ZeusTransformUtils.preCheckCast(r1.l, i.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.c r288 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r1.k, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.a.a.b r289 = (com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r1.j, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin");
            z.d r290 = (z.d) ZeusTransformUtils.preCheckCast(r1.i, z.d.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.a.f r291 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r1.h, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
            j r292 = (j) ZeusTransformUtils.preCheckCast(r1.g, j.class, "com.obric.aiagent.plugin");
            d r293 = (d) ZeusTransformUtils.preCheckCast(r1.f, d.class, "com.obric.aiagent.plugin");
            t r294 = (t) ZeusTransformUtils.preCheckCast(r1.f26324e, t.class, "com.obric.aiagent.plugin");
            d.o.a(r95);     // Catch: Throwable -> L23 CancellationException -> L25
            r816 = r273;
            r210 = d.TAG;
            r815 = r1110;
            r813 = r1111;
            r812 = r1112;
            r22 = ", status=";
            r810 = r2;
            r814 = r276;
            r137 = r277;
            r138 = r280;
            r135 = r281;
            r811 = r282;
            r715 = r283;
            r226 = r284;
            r225 = r285;
            r136 = r286;
            r338 = r288;
            r337 = r289;
            r88 = r293;
            r334 = r1;
            r141 = r1109;
            r320 = "com.obric.aiagent.plugin";
            r142 = r274;
            r143 = r275;
            r100 = r278;
            r335 = r279;
            r99 = r290;
            r98 = r291;
            r140 = r294;
            r336 = r272;
            r223 = r287;
            r224 = r292;
            r139 = r95;
            goto L363
        L20:
            r19 = ", snapshot_elapsed_ms=";
            r24 = ", round=";
            long r295 = r1.B;
            long r296 = r1.A;
            long r297 = r1.z;
            long r298 = r1.y;
            int r1113 = r1.f26323d;
            int r1114 = r1.f26322c;
            int r1115 = r1.f26321b;
            boolean r1116 = r1.x;
            boolean r299 = r1.w;
            boolean r300 = r1.v;
            r326 = r299;
            int r301 = r1.f26320a;
            z.f r302 = (z.f) ZeusTransformUtils.preCheckCast(r1.t, z.f.class, "com.obric.aiagent.plugin");
            r327 = (C0661d) ZeusTransformUtils.preCheckCast(r1.s, C0661d.class, "com.obric.aiagent.plugin");
            r319 = (com.obric.autogui.agents.a.m.j) ZeusTransformUtils.preCheckCast(r1.r, com.obric.autogui.agents.a.m.j.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.k> r303 = (z.f) ZeusTransformUtils.preCheckCast(r1.q, z.f.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.f.b> r304 = (z.f) ZeusTransformUtils.preCheckCast(r1.p, z.f.class, "com.obric.aiagent.plugin");
            r325 = (z.f) ZeusTransformUtils.preCheckCast(r1.o, z.f.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.a r305 = (com.obric.autogui.agents.a.l.a) ZeusTransformUtils.preCheckCast(r1.n, com.obric.autogui.agents.a.l.a.class, "com.obric.aiagent.plugin");
            z.f<com.obric.autogui.agents.a.l.c> r306 = (z.f) ZeusTransformUtils.preCheckCast(r1.m, z.f.class, "com.obric.aiagent.plugin");
            i r307 = (i) ZeusTransformUtils.preCheckCast(r1.l, i.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.l.c r308 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r1.k, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.a.a.b r309 = (com.obric.autogui.agents.vlm.models.a.a.b) ZeusTransformUtils.preCheckCast(r1.j, com.obric.autogui.agents.vlm.models.a.a.b.class, "com.obric.aiagent.plugin");
            z.d r353 = (z.d) ZeusTransformUtils.preCheckCast(r1.i, z.d.class, "com.obric.aiagent.plugin");
            r412 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r1.h, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
            r413 = (j) ZeusTransformUtils.preCheckCast(r1.g, j.class, "com.obric.aiagent.plugin");
            d r354 = (d) ZeusTransformUtils.preCheckCast(r1.f, d.class, "com.obric.aiagent.plugin");
            t r355 = (t) ZeusTransformUtils.preCheckCast(r1.f26324e, t.class, "com.obric.aiagent.plugin");
            d.o.a(r95);     // Catch: Throwable -> L23 CancellationException -> L25
            r94 = r1;
            r210 = d.TAG;
            r22 = ", status=";
            r76 = r2;
            r123 = r1113;
            r217 = r1115;
            r218 = r1116;
            r116 = r309;
            r122 = r1114;
            r62 = r297;
            r49 = r307;
            r72 = r95;
            r50 = r300;
            r322 = r306;
            r410 = r298;
            r74 = r295;
            r215 = r301;
            r214 = r304;
            r323 = r305;
            r45 = r353;
            r318 = r302;
            r324 = r303;
            r321 = r355;
            r320 = "com.obric.aiagent.plugin";
            r111 = r308;
            r75 = r354;
            r411 = r296;
        L25:
            e = move-exception;
            r198 = e;
            r199 = r33;
        L23:
            th = move-exception;
            r200 = th;
            r201 = r33;
            goto L304
        L34:
            r19 = ", snapshot_elapsed_ms=";
            r22 = ", status=";
            r24 = ", round=";
            d.o.a(r95);
            int r356 = r1.D;
            t r357 = r1.f26319J;
            r46 = r1.G;
            r44 = r1.K;
            boolean r358 = r1.L;
            boolean r359 = r1.M;
            r32 = r1.N;
            r45 = r1.H;
            r116 = r1.O;
            r1100 = r1.P;
            r1101 = r1.Q;
            r110 = r1.R;
            com.obric.autogui.agents.a.l.a r360 = r1.S;
            z.f<List<com.obric.autogui.agents.a.f.b>> r361 = r1.F;
            z.f<com.obric.autogui.agents.a.f.b> r362 = r1.E;
            r510 = r358;
            r511 = r359;
            r424 = r2;
            r207 = r356;
            r205 = r361;
            r419 = r1.T;
            r211 = r1.I;
            r206 = r357;
            r210 = d.TAG;
            r204 = r360;
            r212 = r362;
            r113 = 0;
        L312:
            th = move-exception;
            a(r3, 4, 2, r2);
            throw th;
        }

        private static final void a(C0661d r11, t r12, com.obric.autogui.agents.a.m.j r13, z.f<s> r14) {
            r11.e();
            r12.a(r13, r11.a(), r11.b(), r11.c(), r11.d(), (s) ZeusTransformUtils.preCheckCast(r14.f38504a, s.class, "com.obric.aiagent.plugin"));
        }

        private static final CharSequence a(com.obric.autogui.agents.a.f.b r2) {
            return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a().a() + ':' + r2.b(), CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    @d.c.b.a.f(b = "ActionEffectEvaluator.kt", c = {503}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.evaluation.ActionEffectEvaluator$runDetectorGroup$2$1")
    static final class g extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.autogui.agents.a.f.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26329e;
        long f;
        int g;
        final /* synthetic */ t h;
        final /* synthetic */ int i;
        final /* synthetic */ com.obric.autogui.agents.a.f.c j;
        final /* synthetic */ d k;
        final /* synthetic */ com.obric.autogui.agents.a.l.c l;
        final /* synthetic */ com.obric.autogui.agents.a.a.f m;
        final /* synthetic */ int n;

        g(t r3, int r4, com.obric.autogui.agents.a.f.c r5, d r6, com.obric.autogui.agents.a.l.c r7, com.obric.autogui.agents.a.a.f r8, int r9, d.c.d<? super g> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            this.i = r4;
            this.j = r5;
            this.k = r6;
            this.l = r7;
            this.m = r8;
            this.n = r9;
            super(1, r11);
        }

        public final Object a(d.c.d<? super com.obric.autogui.agents.a.f.b> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r12) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.h, this.i, this.j, this.k, this.l, this.m, this.n, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.autogui.agents.a.f.b> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v17, types: [com.obric.autogui.agents.a.m.t] */
        /* JADX WARN: Type inference failed for: r20v0 */
        /* JADX WARN: Type inference failed for: r20v1 */
        /* JADX WARN: Type inference failed for: r20v2 */
        /* JADX WARN: Type inference failed for: r20v3 */
        /* JADX WARN: Type inference failed for: r20v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r20v5 */
        /* JADX WARN: Type inference failed for: r20v6 */
        /* JADX WARN: Type inference failed for: r20v7 */
        /* JADX WARN: Type inference failed for: r20v8 */
        /* JADX WARN: Type inference failed for: r20v9 */
        /* JADX WARN: Type inference failed for: r29v0, types: [com.obric.autogui.agents.a.c] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v40 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r38v0 */
        /* JADX WARN: Type inference failed for: r38v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r38v2 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Class, java.lang.Class<com.obric.autogui.agents.a.f.b>] */
        /* JADX WARN: Type inference failed for: r4v6, types: [com.obric.autogui.agents.a.m.t] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r42) {
            Object r0 = d.c.a.b.a();
            ?? r2 = this.g;
            ?? r4 = 1;
            if (r2 == 0) goto L18;
            if (r2 != 1) goto L17;
            long r7 = this.f;
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f26329e, String.class, "com.obric.aiagent.plugin");
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.f26328d, String.class, "com.obric.aiagent.plugin");
            String r10 = (String) ZeusTransformUtils.preCheckCast(this.f26327c, String.class, "com.obric.aiagent.plugin");
            s r11 = (s) ZeusTransformUtils.preCheckCast(this.f26326b, s.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.a.m.f r12 = (com.obric.autogui.agents.a.m.f) ZeusTransformUtils.preCheckCast(this.f26325a, com.obric.autogui.agents.a.m.f.class, "com.obric.aiagent.plugin");
            d.o.a(r42);     // Catch: Throwable -> L8 Exception -> L12 CancellationException -> L14
            Object r1 = r42;
            ?? r5 = 1;
            r2 = r3;
        L42:
            r4 = com.obric.autogui.agents.a.f.b.class;
            com.obric.autogui.agents.a.f.b r6 = (com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r1, r4, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L44
            ?? r8 = r2;
            ?? r13 = r5;
        L43:
            com.obric.autogui.agents.a.m.f r14 = r12;
            s r39 = r11;
            ?? r15 = r8;
            String r40 = r10;
            String r16 = r9;
            long r34 = d.a(this.k, r7);     // Catch: Throwable -> L70
            if (r6.b() != com.obric.autogui.agents.a.f.k.f26446e) goto L53;
            s r17 = s.f26713d;     // Catch: Throwable -> L70
        L54:
            s r18 = r17;
            String r19 = r6.b().name();     // Catch: Throwable -> L68
            String r20 = r6.c();     // Catch: Throwable -> L66
            ?? r29 = com.obric.autogui.agents.a.c.f26286a;     // Catch: Throwable -> L64
            com.obric.autogui.agents.a.a r31 = this.m.k();     // Catch: Throwable -> L64
            int r21 = this.i;     // Catch: Throwable -> L64
            String r37 = r6.e();     // Catch: Throwable -> L64
            if (r6.b() != com.obric.autogui.agents.a.f.k.f26446e) goto L60;
            ?? r38 = r13;
        L61:
            r29.a(d.TAG, r31, r21, r6, r34, r18, r37, r38);     // Catch: Throwable -> L64
            this.h.a(r14, r18, r19, r20, r40, r16, r15);
            return r6;
        L60:
            r38 = 0;
        L64:
            th = th;
            r14 = r14;
            s r110 = r18;
            String r111 = r19;
            String r112 = r20;
            String r113 = r40;
            String r114 = r16;
            ?? r22 = r15;
        L78:
            this.h.a(r14, r110, r111, r112, r113, r114, r22);
            throw th;
        L66:
            th = th;
            r14 = r14;
            r110 = r18;
            r111 = r19;
            r113 = r40;
            r114 = r16;
            ?? r23 = r15;
        L11:
            r112 = null;
            r22 = r23;
        L68:
            th = th;
            r110 = r18;
        L72:
            r113 = r40;
            r114 = r16;
            ?? r24 = r15;
        L10:
            r111 = null;
            r23 = r24;
            goto L11
        L53:
            r17 = s.f26710a;     // Catch: Throwable -> L70
        L70:
            th = th;
            r110 = r39;
            goto L72
        L44:
            e = e;
        L49:
            r6 = new com.obric.autogui.agents.a.f.b(this.j, com.obric.autogui.agents.a.f.k.f26446e, "detector error:" + e.getClass().getSimpleName(), null, "error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 8, null);     // Catch: Throwable -> L8
            r8 = r2;
            r13 = r5;
            goto L43
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r42);
            r12 = this.h.a(this.i, this.j.a());
            r7 = ((Number) ZeusTransformUtils.preCheckCast(d.a(this.k).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
            r11 = s.f26713d;
            ComponentName r25 = this.l.a();
            if (r25 == null) goto L21;
            r10 = r25.getClassName();
        L23:
            if (this.j != com.obric.autogui.agents.a.f.c.f26402a) goto L25;
            boolean r26 = true;
        L26:
            if (r26 == false) goto L30;
            ComponentName r27 = this.m.c().a();
            if (r27 == null) goto L30;
            r9 = r27.getClassName();
        L31:
            if (r26 == false) goto L35;
            ComponentName r28 = this.l.a();
            if (r28 == null) goto L35;
            r2 = r28.getClassName();
        L36:
            com.obric.autogui.agents.a.b.a r115 = (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(d.d(this.k).invoke(this.j), com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 Exception -> L12 CancellationException -> L14
            com.obric.autogui.agents.a.b.b r116 = new com.obric.autogui.agents.a.b.b(this.m, this.l, this.j, this.i, this.n);     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            d.c.d<? super com.obric.autogui.agents.a.f.b> r30 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            this.f26325a = r12;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            this.f26326b = r11;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            this.f26327c = r10;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            this.f26328d = r9;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            this.f26329e = r2;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            this.f = r7;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L46
            r5 = 1;
            r5 = 1;
            this.g = 1;     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L44
            r1 = r115.a(r116, r30);     // Catch: Throwable -> L8 CancellationException -> L14 Exception -> L44
            r2 = r2;
            if (r1 != r0) goto L42;
            return r0;
        L46:
            e = e;
            r5 = 1;
        L35:
            r2 = 0;
        L30:
            r9 = null;
            goto L31
        L25:
            r26 = false;
            goto L26
        L21:
            r10 = null;
        L8:
            th = th;
            r24 = r2;
            r114 = r9;
            r113 = r10;
            r110 = r11;
            r14 = r12;
        L12:
            e = e;
            r5 = r4;
        L14:
            e = move-exception;
            s r117 = com.obric.autogui.agents.a.c.e.a(e);     // Catch: Throwable -> L8
            Loog.INSTANCE.i(d.TAG, "[OAutoActionEffect] detector cancelled " + com.obric.autogui.agents.a.c.f26286a.a(this.m) + ", round=" + this.i + ", detector=" + this.j.a() + ", finish_reason=" + s.f26712c + ", cancel_reason=scope_cancelled, elapsed_ms=" + d.a(this.k, r7));     // Catch: Throwable -> L76
            throw e;     // Catch: Throwable -> L76
        L76:
            th = th;
            r22 = r2;
            r112 = "scope_cancelled";
            r114 = r9;
            r113 = r10;
            r110 = r117;
            r14 = r12;
            r111 = null;
            goto L78
        }
    }

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    @d.c.b.a.f(b = "ActionEffectEvaluator.kt", c = {411, BDAbstractUpload.KeyIsSDKMaxRetryCount}, d = "runDetectors", e = "com.obric.autogui.agents.actioneffect.evaluation.ActionEffectEvaluator")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26333d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26334e;
        Object f;
        int g;
        int h;
        long i;
        /* synthetic */ Object j;
        final /* synthetic */ d k;
        int l;

        h(d r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.j = r8;
            this.l |= Integer.MIN_VALUE;
            return d.a(this.k, null, null, 0, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26294a = new b(null);
    }

    public d(com.obric.autogui.agents.a.c.b r3, d.h.a.b<? super com.obric.autogui.agents.a.f.c, ? extends com.obric.autogui.agents.a.b.a> r4, d.h.a.a<Long> r5, d.h.a.a<Boolean> r6) {
        com.obric.autogui.agents.a.c.b r7 = (com.obric.autogui.agents.a.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.a.c.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.autogui.agents.a.f.c, com.obric.autogui.agents.a.b.a> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Boolean> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "snapshotCaptureSource");
        o.e(r8, "detectorFactory");
        o.e(r9, "clockMs");
        o.e(r10, "securePageResolver");
        this.f26295b = r7;
        this.f26296c = r8;
        this.f26297d = r9;
        this.f26298e = r10;
    }

    public static final /* synthetic */ long a(d r0, long r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.obric.autogui.agents.a.f.i a(d r6, com.obric.autogui.agents.a.f.b r7, List r8, int r9, com.obric.autogui.agents.a.f.k r10, com.obric.autogui.agents.a.f.e r11) {
        return r6.a(r7, (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public static final /* synthetic */ d.h.a.a a(d r0) {
        return r0.f26297d;
    }

    public static final /* synthetic */ Object a(d r7, com.obric.autogui.agents.a.a.f r8, com.obric.autogui.agents.a.l.c r9, int r10, int r11, t r12, d.c.d r13) {
        return r7.a(r8, r9, r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ d.h.a.a b(d r0) {
        return r0.f26298e;
    }

    public static final /* synthetic */ com.obric.autogui.agents.a.c.b c(d r0) {
        return r0.f26295b;
    }

    public static final /* synthetic */ d.h.a.b d(d r0) {
        return r0.f26296c;
    }

    public /* synthetic */ d(com.obric.autogui.agents.a.c.b r2, d.h.a.b r3, d.h.a.a r4, d.h.a.a r5, int r6, d.h.b.h r7) {
        com.obric.autogui.agents.a.c.b r8 = (com.obric.autogui.agents.a.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.agents.a.c.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(com.obric.autogui.agents.a.b.c.f26276a), d.h.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r10 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass2(AOSystemTools.INSTANCE), d.h.a.a.class, "com.obric.aiagent.plugin");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass3(com.obric.autogui.agents.a.k.a.f26530a), d.h.a.a.class, "com.obric.aiagent.plugin");
    L11:
        this(r8, r9, r10, r11);
    }

    public d(final com.obric.autogui.agents.a.l.d r8) {
        o.e(r8, "snapshotProvider");
        this((com.obric.autogui.agents.a.c.b) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r8), com.obric.autogui.agents.a.c.b.class, "com.obric.aiagent.plugin"), null, null, null, 14, null);
    }

    public static /* synthetic */ Object a(d r11, com.obric.autogui.agents.a.a.f r12, t r13, com.obric.autogui.agents.vlm.models.a.a.b r14, com.obric.autogui.agents.a.l.c r15, boolean r16, i r17, Integer r18, d.c.d r19, int r20, Object r21) {
        i r0 = (i) ZeusTransformUtils.wrapperContextForParams(r17, i.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.agents.a.f.i> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r20 & 4) == 0) goto L5;
        com.obric.autogui.agents.vlm.models.a.a.b r5 = null;
    L7:
        if ((r20 & 8) == 0) goto L9;
        com.obric.autogui.agents.a.l.c r6 = null;
    L11:
        if ((r20 & 16) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((r20 & 32) == 0) goto L17;
        i r8 = null;
    L19:
        if ((r20 & 64) == 0) goto L21;
        Integer r9 = null;
    L23:
        return r11.a(r12, r13, r5, r6, r7, r8, r9, r10);
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r0;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 65, insn: 0x10f8: MOVE (r17 I:??[long, double]) = (r65 I:??[long, double]), block:B:570:0x10f2 */
    /* JADX WARN: Type inference failed for: r0v112 */
    /* JADX WARN: Type inference failed for: r0v118, types: [T, com.obric.autogui.agents.a.m.s] */
    /* JADX WARN: Type inference failed for: r0v128, types: [com.obric.autogui.agents.a.c.d] */
    /* JADX WARN: Type inference failed for: r0v136, types: [T] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v187 */
    /* JADX WARN: Type inference failed for: r0v188 */
    /* JADX WARN: Type inference failed for: r0v189 */
    /* JADX WARN: Type inference failed for: r0v62, types: [T, com.obric.autogui.agents.a.m.s] */
    /* JADX WARN: Type inference failed for: r0v75, types: [T, com.obric.autogui.agents.a.m.s] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.obric.autogui.agents.a.c.d$e, d.c.d, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r12v3, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v5, types: [T, com.obric.autogui.agents.a.l.c] */
    /* JADX WARN: Type inference failed for: r12v7, types: [T, com.obric.autogui.agents.a.m.s] */
    /* JADX WARN: Type inference failed for: r16v1, types: [com.obric.autogui.agents.a.a.f, com.obric.autogui.agents.a.c.i] */
    /* JADX WARN: Type inference failed for: r16v28 */
    /* JADX WARN: Type inference failed for: r16v29 */
    /* JADX WARN: Type inference failed for: r16v30 */
    /* JADX WARN: Type inference failed for: r16v31 */
    /* JADX WARN: Type inference failed for: r16v32 */
    /* JADX WARN: Type inference failed for: r16v33 */
    /* JADX WARN: Type inference failed for: r1v149 */
    /* JADX WARN: Type inference failed for: r1v170, types: [com.obric.autogui.agents.a.a.f] */
    /* JADX WARN: Type inference failed for: r1v199 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference failed for: r3v78, types: [T, com.obric.autogui.agents.a.m.s] */
    /* JADX WARN: Type inference failed for: r3v79, types: [T, com.obric.autogui.agents.a.m.s] */
    /* JADX WARN: Type inference failed for: r3v80, types: [com.obric.autogui.agents.a.m.t] */
    /* JADX WARN: Type inference failed for: r3v83 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v54, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r6v52, types: [com.obric.autogui.agents.a.c] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.obric.autogui.agents.a.c] */
    /* JADX WARN: Type inference failed for: r89v0, types: [com.obric.autogui.agents.a.c.d, com.obric.autogui.agents.a.m.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r89v25 */
    /* JADX WARN: Type inference failed for: r89v26 */
    /* JADX WARN: Type inference failed for: r89v27 */
    /* JADX WARN: Type inference failed for: r89v28 */
    /* JADX WARN: Type inference failed for: r89v29 */
    /* JADX WARN: Type inference failed for: r89v30 */
    /* JADX WARN: Type inference failed for: r90v0, types: [com.obric.autogui.agents.a.a.f, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r91v0, types: [com.obric.autogui.agents.a.m.t, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v61, types: [com.obric.autogui.agents.a.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 17 */
    public final Object a(com.obric.autogui.agents.a.a.f r90, t r91, com.obric.autogui.agents.vlm.models.a.a.b r92, com.obric.autogui.agents.a.l.c r93, boolean r94, i r95, Integer r96, d.c.d<? super com.obric.autogui.agents.a.f.i> r97) {
        ?? r16 = (i) ZeusTransformUtils.wrapperContextForParams(r95, i.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r97, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        if ((r2.o & Integer.MIN_VALUE) == 0) goto L7;
        r2.o -= Integer.MIN_VALUE;
    L8:
        ?? r12 = r2;
        ?? r3 = r12.m;
        Object r11 = d.c.a.b.a();
        ?? r4 = r12.o;
        String r21 = null;
        if (r4 == 0) goto L20;
        if (r4 != 1) goto L19;
        long r14 = r12.l;
        long r8 = r12.k;
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r12.j, Long.class, "com.obric.aiagent.plugin");
        z.f r6 = (z.f) ZeusTransformUtils.preCheckCast(r12.i, z.f.class, "com.obric.aiagent.plugin");
        z.f r0 = (z.f) ZeusTransformUtils.preCheckCast(r12.h, z.f.class, "com.obric.aiagent.plugin");
        z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(r12.g, z.f.class, "com.obric.aiagent.plugin");
        z.d r9 = (z.d) ZeusTransformUtils.preCheckCast(r12.f, z.d.class, "com.obric.aiagent.plugin");
        j r10 = (j) ZeusTransformUtils.preCheckCast(r12.f26318e, j.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.m.h r13 = (com.obric.autogui.agents.a.m.h) ZeusTransformUtils.preCheckCast(r12.f26317d, com.obric.autogui.agents.a.m.h.class, "com.obric.aiagent.plugin");
        t r15 = (t) ZeusTransformUtils.preCheckCast(r12.f26316c, t.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.f r17 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r12.f26315b, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
        d r18 = (d) ZeusTransformUtils.preCheckCast(r12.f26314a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L14 CancellationException -> L16
        Long r19 = r5;
        String r62 = ", total_elapsed_ms=";
        String r63 = ", framework_callback_available=";
        String r64 = ", callback_wait_ms=";
        String r68 = "[OAutoActionEffect] evaluation timing ";
        String r67 = ", finish_reason=";
        String r70 = ", completed_rounds=";
        String r78 = ", timeout_ms=";
        String r79 = ", registration_to_callback_elapsed_ms=";
        long r86 = r14;
        String r73 = ", cancelled_detector_count=";
        String r71 = ", detector_execution_count=";
        String r74 = TAG;
        boolean r110 = true;
        z.f r111 = r6;
        z.f r112 = r0;
        j r20 = r10;
        com.obric.autogui.agents.a.m.h r22 = r13;
        ?? r23 = r15;
        ?? r24 = r3;
        ?? r25 = r17;
        String r26 = "com.obric.aiagent.plugin";
        long r113 = r8;
        z.f r27 = r7;
        z.d r28 = r9;
        ?? r29 = r18;
    L628:
        com.obric.autogui.agents.a.f.i r30 = (com.obric.autogui.agents.a.f.i) ZeusTransformUtils.preCheckCast(r24, com.obric.autogui.agents.a.f.i.class, r26);     // Catch: Throwable -> L497 CancellationException -> L499
        long r114 = r29.a(r113);     // Catch: Throwable -> L497 CancellationException -> L499
        if (r30 == null) goto L634;
        ?? r31 = s.f26710a;     // Catch: Throwable -> L497 CancellationException -> L499
    L401:
        r111.f38504a = r31;     // Catch: Throwable -> L497 CancellationException -> L499
        if (r30 != null) goto L415;
        com.obric.autogui.agents.a.f.k r32 = (com.obric.autogui.agents.a.f.k) ZeusTransformUtils.preCheckCast(r112.f38504a, com.obric.autogui.agents.a.f.k.class, r26);     // Catch: Throwable -> L394 CancellationException -> L397
        if (r32 != null) goto L406;
        r32 = com.obric.autogui.agents.a.f.k.f;     // Catch: Throwable -> L394 CancellationException -> L397
    L406:
        com.obric.autogui.agents.a.f.k r210 = r32;
        com.obric.autogui.agents.a.f.k r211 = com.obric.autogui.agents.a.f.k.f;     // Catch: Throwable -> L394 CancellationException -> L397
        List r212 = (List) ZeusTransformUtils.preCheckCast(r27.f38504a, List.class, r26);     // Catch: Throwable -> L394 CancellationException -> L397
        int r33 = r28.f38502a;     // Catch: Throwable -> L394 CancellationException -> L397
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast(r27.f38504a, Iterable.class, r26)).iterator();     // Catch: Throwable -> L394 CancellationException -> L397
    L408:
        if (r34.hasNext() == false) goto L412;
        String r35 = ((com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r34.next(), com.obric.autogui.agents.a.f.b.class, r26)).d();     // Catch: Throwable -> L394 CancellationException -> L397
        if (r35 == null) goto L408;
        String r36 = r35;
    L413:
        com.obric.autogui.agents.a.f.i r37 = new com.obric.autogui.agents.a.f.i(r210, r211, null, "evaluation timed out before conclusive result", r212, r33, r36, com.obric.autogui.agents.a.f.e.f26414c, null, 256, null);     // Catch: Throwable -> L394 CancellationException -> L397
    L417:
        com.obric.autogui.agents.a.f.i r38 = com.obric.autogui.agents.a.f.i.a(r37, null, null, null, null, null, 0, null, null, (s) ZeusTransformUtils.preCheckCast(r111.f38504a, s.class, r26), 255, null);     // Catch: Throwable -> L497 CancellationException -> L499
        if (r30 == null) goto L636;
        String r39 = r62;
        String r40 = r74;
    L442:
        s r41 = (s) ZeusTransformUtils.preCheckCast(r111.f38504a, s.class, r26);
        if (r111.f38504a != s.f26712c) goto L445;
        r r42 = r.f26708d;
    L446:
        r23.a(r22, r41, r42);
        com.obric.autogui.agents.a.m.g r43 = r23.b().j();
        Loog r44 = Loog.INSTANCE;
        StringBuilder r45 = new StringBuilder().append(r68).append(com.obric.autogui.agents.a.c.f26286a.a(r25)).append(r67).append(r111.f38504a).append(r70);
        if (r43 == null) goto L451;
        List<com.obric.autogui.agents.a.m.i> r46 = r43.e();
        if (r46 == null) goto L451;
        int r47 = r46.size();
    L452:
        StringBuilder r48 = r45.append(r47).append(r71);
        if (r43 == null) goto L457;
        List<com.obric.autogui.agents.a.m.e> r49 = r43.f();
        if (r49 == null) goto L457;
        int r50 = r49.size();
    L458:
        StringBuilder r51 = r48.append(r50).append(r73);
        if (r43 == null) goto L478;
        List<com.obric.autogui.agents.a.m.e> r52 = r43.f();
        if (r52 == null) goto L478;
        Iterable r53 = (Iterable) ZeusTransformUtils.preCheckCast(r52, Iterable.class, r26);
        if (ZeusTransformUtils.instanceOf(r53, Collection.class) == true) goto L465;
    L467:
        Iterator r54 = r53.iterator();
        int r55 = 0;
    L469:
        if (r54.hasNext() == false) goto L479;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r54.next(), com.obric.autogui.agents.a.m.e.class, r26)).e() != s.f26712c) goto L473;
        boolean r56 = r110;
    L474:
        if (r56 == false) goto L469;
        r55 = r55 + 1;
        if (r55 >= 0) goto L469;
        p.d();
        goto L469
    L473:
        r56 = false;
    L479:
        StringBuilder r57 = r51.append(r55).append(r63);
        if (r19 != null) goto L483;
        r110 = false;
    L483:
        StringBuilder r58 = r57.append(r110).append(r79);
        if (r19 == null) goto L486;
        String r59 = r19.toString();
    L487:
        if (r59 != null) goto L489;
        r59 = "";
    L489:
        StringBuilder r60 = r58.append(r59).append(r64).append(r86).append(r39);
        if (r43 == null) goto L492;
        r21 = d.c.b.a.b.a(r43.a()).toString();
    L492:
        if (r21 != null) goto L494;
        String r61 = "";
    L495:
        r44.i(r40, r60.append(r61).toString());
        return r38;
    L494:
        r61 = r21;
        goto L495
    L486:
        r59 = null;
        goto L487
    L465:
        if (((Collection) ZeusTransformUtils.preCheckCast(r53, Collection.class, r26)).isEmpty() == false) goto L467;
    L478:
        r55 = 0;
    L457:
        r50 = 0;
    L451:
        r47 = 0;
        goto L452
    L445:
        r42 = null;
        goto L446
    L636:
        Loog r65 = Loog.INSTANCE;     // Catch: Throwable -> L433 CancellationException -> L437
        StringBuilder r66 = new StringBuilder().append("[OAutoActionEffect] evaluation timeout ").append(com.obric.autogui.agents.a.c.f26286a.a(r25)).append(", detect_count=").append(r28.f38502a).append(r78).append(r20.e());     // Catch: Throwable -> L433 CancellationException -> L437
        r39 = r62;
        r40 = r74;
        r65.w(r40, r66.append(r39).append(r114).toString());     // Catch: Throwable -> L425 CancellationException -> L427
    L427:
        e = e;
    L567:
        r111.f38504a = s.f26712c;     // Catch: Throwable -> L569
        throw e;     // Catch: Throwable -> L569
    L425:
        th = th;
    L561:
        r111.f38504a = s.f26713d;     // Catch: Throwable -> L569
        throw th;     // Catch: Throwable -> L569
    L431:
        e = e;
    L429:
        th = th;
        goto L561
    L437:
        e = e;
    L433:
        th = th;
        goto L561
    L397:
        e = e;
    L394:
        th = th;
        goto L561
    L412:
        r36 = null;
        goto L413
    L415:
        r37 = r30;
        goto L417
    L634:
        r31 = s.f26711b;     // Catch: Throwable -> L394 CancellationException -> L397
    L499:
        e = e;
    L497:
        th = th;
        goto L561
    L16:
        e = e;
        r111 = r6;
    L14:
        th = th;
        r111 = r6;
        goto L561
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r3);
        com.obric.autogui.agents.a.m.h r69 = r91.a();
        long r72 = ((Number) ZeusTransformUtils.preCheckCast(this.f26297d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        j r75 = r90.a();
        com.obric.autogui.agents.a.l.a r213 = com.obric.autogui.agents.a.l.a.f26531a.a(r75.b());
        z.d r115 = new z.d();
        z.f r76 = new z.f();
        r76.f38504a = p.b();
        z.f r116 = new z.f();
        z.f r77 = new z.f();
        r77.f38504a = r90.c();
        z.f r117 = new z.f();
        z.f r80 = new z.f();
        r80.f38504a = s.f26712c;
        Long r118 = r90.f();
        long r81 = r90.g();
        com.obric.autogui.agents.a.a.e r119 = r90.e();     // Catch: Throwable -> L557 CancellationException -> L563
    L676:
        int r82 = n.c(r75.d(), 1);     // Catch: Throwable -> L553 CancellationException -> L555
        if (r90.i() == false) goto L27;
        if (r96 != null) goto L27;
        boolean r120 = true;
    L28:
        if (r96 == null) goto L46;
        String r310 = "com.obric.aiagent.plugin";
        z.f r311 = r80;
        int r121 = n.c(r96.intValue(), 1);     // Catch: Throwable -> L34 CancellationException -> L36
    L50:
        if (r16 == 0) goto L52;
        boolean r312 = true;
    L644:
        Loog r83 = Loog.INSTANCE;     // Catch: Throwable -> L547 CancellationException -> L550
        StringBuilder r84 = new StringBuilder();     // Catch: Throwable -> L547 CancellationException -> L550
        StringBuilder r85 = r84.append("[OAutoActionEffect] evaluation begin ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", configured_max_detect_count=").append(r82).append(", effective_max_detect_count=").append(r121).append(", max_detect_count_overridden=");     // Catch: Throwable -> L547 CancellationException -> L550
        if (r96 == null) goto L56;
        boolean r87 = true;
    L57:
        StringBuilder r88 = r85.append(r87).append(", baseline_dynamic_surface=");     // Catch: Throwable -> L547 CancellationException -> L550
        Boolean r89 = r90.h();     // Catch: Throwable -> L547 CancellationException -> L550
        if (r89 == null) goto L61;
        String r98 = r89.toString();     // Catch: Throwable -> L34 CancellationException -> L36
    L62:
        if (r98 != null) goto L64;
        r98 = "";
    L64:
        StringBuilder r99 = r88.append(r98).append(", surface_single_round=");     // Catch: Throwable -> L547 CancellationException -> L550
        if (r120 == false) goto L67;
        boolean r100 = true;
    L68:
        StringBuilder r101 = r99.append(r100).append(", timeout_ms=").append(r75.e()).append(", required_component=").append(r213.a()).append(", required_viewtree=").append(r213.b()).append(", required_image=").append(r213.c()).append(", framework_callback_available=");     // Catch: Throwable -> L547 CancellationException -> L550
        if (r118 == null) goto L71;
        boolean r102 = true;
    L72:
        r101.append(r102).append(", registration_to_callback_elapsed_ms=");     // Catch: Throwable -> L547 CancellationException -> L550
        if (r118 == null) goto L76;
        String r103 = r118.toString();     // Catch: Throwable -> L34 CancellationException -> L36
    L77:
        if (r103 != null) goto L79;
        r103 = "";
    L79:
        r84.append(r103).append(", callback_wait_ms=").append(r81);     // Catch: Throwable -> L547 CancellationException -> L550
        String r104 = r84.toString();     // Catch: Throwable -> L547 CancellationException -> L550
        String r105 = TAG;
        r83.i(r105, r104);     // Catch: Throwable -> L543 CancellationException -> L545
        if (r93 == null) goto L92;
    L85:
        if (r93.e() != true) goto L92;
        boolean r106 = true;
    L94:
        if (r106 == true) goto L670;
        boolean r214 = r120;
        String r107 = r310;
        int r313 = r121;
        r111 = r311;
        if (r94 == false) goto L268;
    L664:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f26298e.invoke(), Boolean.class, r107)).booleanValue() == true) goto L680;
        r105 = r105;
        goto L268
    L680:
        long r108 = a(r72);     // Catch: Throwable -> L247 CancellationException -> L249
        r111.f38504a = s.f26710a;     // Catch: Throwable -> L247 CancellationException -> L249
        Loog r109 = Loog.INSTANCE;     // Catch: Throwable -> L247 CancellationException -> L249
        StringBuilder r122 = new StringBuilder().append("[OAutoActionEffect] evaluation short-circuited ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", status=").append(com.obric.autogui.agents.a.f.k.f26443b).append(", reason=secure_page_before_direct, framework_callback_available=");     // Catch: Throwable -> L247 CancellationException -> L249
        if (r118 == null) goto L173;
        boolean r123 = true;
    L174:
        StringBuilder r124 = r122.append(r123).append(", registration_to_callback_elapsed_ms=");     // Catch: Throwable -> L247 CancellationException -> L249
        if (r118 != null) goto L650;
        String r125 = null;
    L183:
        if (r125 != null) goto L185;
        r125 = "";
    L185:
        String r126 = r124.append(r125).append(", callback_wait_ms=").append(r81).append(", detect_count=0, total_elapsed_ms=").append(r108).toString();     // Catch: Throwable -> L247 CancellationException -> L249
        r105 = r105;
        r109.i(r105, r126);     // Catch: Throwable -> L243 CancellationException -> L245
        com.obric.autogui.agents.a.f.i r127 = new com.obric.autogui.agents.a.f.i(com.obric.autogui.agents.a.f.k.f26443b, com.obric.autogui.agents.a.f.k.f26443b, null, "active operating space is secure", p.b(), 0, null, null, null, 448, null);     // Catch: Throwable -> L243 CancellationException -> L245
        s r128 = (s) ZeusTransformUtils.preCheckCast(r111.f38504a, s.class, r107);
        if (r111.f38504a != s.f26712c) goto L191;
        r r129 = r.f26708d;
    L192:
        r91.a(r69, r128, r129);
        com.obric.autogui.agents.a.m.g r130 = r91.b().j();
        Loog r131 = Loog.INSTANCE;
        StringBuilder r132 = new StringBuilder().append("[OAutoActionEffect] evaluation timing ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", finish_reason=").append(r111.f38504a).append(", completed_rounds=");
        if (r130 == null) goto L197;
        List<com.obric.autogui.agents.a.m.i> r133 = r130.e();
        if (r133 == null) goto L197;
        int r134 = r133.size();
    L198:
        StringBuilder r135 = r132.append(r134).append(", detector_execution_count=");
        if (r130 == null) goto L203;
        List<com.obric.autogui.agents.a.m.e> r136 = r130.f();
        if (r136 == null) goto L203;
        int r137 = r136.size();
    L204:
        StringBuilder r138 = r135.append(r137).append(", cancelled_detector_count=");
        if (r130 == null) goto L224;
        List<com.obric.autogui.agents.a.m.e> r139 = r130.f();
        if (r139 == null) goto L224;
        Iterable r140 = (Iterable) ZeusTransformUtils.preCheckCast(r139, Iterable.class, r107);
        if (ZeusTransformUtils.instanceOf(r140, Collection.class) == true) goto L211;
    L213:
        Iterator r141 = r140.iterator();
        int r142 = 0;
    L215:
        if (r141.hasNext() == false) goto L225;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r141.next(), com.obric.autogui.agents.a.m.e.class, r107)).e() != s.f26712c) goto L219;
        boolean r143 = true;
    L220:
        if (r143 == false) goto L215;
        r142 = r142 + 1;
        if (r142 >= 0) goto L215;
        p.d();
        goto L215
    L219:
        r143 = false;
    L225:
        StringBuilder r144 = r138.append(r142).append(", framework_callback_available=");
        if (r118 == null) goto L228;
        boolean r145 = true;
    L229:
        StringBuilder r146 = r144.append(r145).append(", registration_to_callback_elapsed_ms=");
        if (r118 == null) goto L232;
        String r147 = r118.toString();
    L233:
        if (r147 != null) goto L235;
        r147 = "";
    L235:
        StringBuilder r148 = r146.append(r147).append(", callback_wait_ms=").append(r81).append(", total_elapsed_ms=");
        if (r130 == null) goto L238;
        r21 = d.c.b.a.b.a(r130.a()).toString();
    L238:
        if (r21 != null) goto L240;
        String r149 = "";
    L241:
        r131.i(r105, r148.append(r149).toString());
        return r127;
    L240:
        r149 = r21;
        goto L241
    L232:
        r147 = null;
        goto L233
    L228:
        r145 = false;
        goto L229
    L211:
        if (((Collection) ZeusTransformUtils.preCheckCast(r140, Collection.class, r107)).isEmpty() == false) goto L213;
    L224:
        r142 = 0;
    L203:
        r137 = 0;
    L197:
        r134 = 0;
        goto L198
    L191:
        r129 = null;
        goto L192
    L245:
        e = e;
    L243:
        th = th;
        goto L561
    L650:
        r125 = r118.toString();     // Catch: Throwable -> L178 CancellationException -> L180
    L180:
        e = e;
    L178:
        th = th;
        goto L561
    L173:
        r123 = false;
    L249:
        e = e;
        r111 = r111;
    L247:
        th = th;
        r111 = r111;
        goto L561
    L256:
        e = e;
    L252:
        th = th;
    L263:
        e = e;
    L260:
        th = th;
    L268:
        if (r119 == null) goto L674;
        long r150 = a(r72);     // Catch: Throwable -> L346 CancellationException -> L350
        r111.f38504a = s.f26710a;     // Catch: Throwable -> L346 CancellationException -> L350
        Loog r151 = Loog.INSTANCE;     // Catch: Throwable -> L346 CancellationException -> L350
    L632:
        StringBuilder r152 = new StringBuilder().append("[OAutoActionEffect] evaluation short-circuited ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", status=").append(r119.a()).append(", reason=").append(r119.b()).append(r17);     // Catch: Throwable -> L342 CancellationException -> L344
        if (r118 == null) goto L274;
        boolean r153 = true;
    L275:
        StringBuilder r154 = r152.append(r153).append(", registration_to_callback_elapsed_ms=");     // Catch: Throwable -> L342 CancellationException -> L344
        if (r118 != null) goto L640;
        String r155 = null;
    L284:
        if (r155 != null) goto L286;
        r155 = "";
    L286:
        r151.i(r105, r154.append(r155).append(", callback_wait_ms=").append(r81).append(", detect_count=0, total_elapsed_ms=").append(r150).toString());     // Catch: Throwable -> L342 CancellationException -> L344
        com.obric.autogui.agents.a.f.i r156 = r119.c();     // Catch: Throwable -> L342 CancellationException -> L344
        s r157 = (s) ZeusTransformUtils.preCheckCast(r111.f38504a, s.class, r107);
        if (r111.f38504a != s.f26712c) goto L290;
        r r158 = r.f26708d;
    L291:
        r91.a(r69, r157, r158);
        com.obric.autogui.agents.a.m.g r159 = r91.b().j();
        Loog r160 = Loog.INSTANCE;
        StringBuilder r161 = new StringBuilder().append("[OAutoActionEffect] evaluation timing ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", finish_reason=").append(r111.f38504a).append(r26);
        if (r159 == null) goto L296;
        List<com.obric.autogui.agents.a.m.i> r162 = r159.e();
        if (r162 == null) goto L296;
        int r163 = r162.size();
    L297:
        StringBuilder r164 = r161.append(r163).append(", detector_execution_count=");
        if (r159 == null) goto L302;
        List<com.obric.autogui.agents.a.m.e> r165 = r159.f();
        if (r165 == null) goto L302;
        int r166 = r165.size();
    L303:
        StringBuilder r167 = r164.append(r166).append(", cancelled_detector_count=");
        if (r159 == null) goto L323;
        List<com.obric.autogui.agents.a.m.e> r168 = r159.f();
        if (r168 == null) goto L323;
        Iterable r169 = (Iterable) ZeusTransformUtils.preCheckCast(r168, Iterable.class, r107);
        if (ZeusTransformUtils.instanceOf(r169, Collection.class) == true) goto L310;
    L312:
        Iterator r170 = r169.iterator();
        int r171 = 0;
    L314:
        if (r170.hasNext() == false) goto L324;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r170.next(), com.obric.autogui.agents.a.m.e.class, r107)).e() != s.f26712c) goto L318;
        boolean r172 = true;
    L319:
        if (r172 == false) goto L314;
        r171 = r171 + 1;
        if (r171 >= 0) goto L314;
        p.d();
        goto L314
    L318:
        r172 = false;
    L324:
        StringBuilder r173 = r167.append(r171).append(", framework_callback_available=");
        if (r118 == null) goto L327;
        boolean r174 = true;
    L328:
        StringBuilder r175 = r173.append(r174).append(", registration_to_callback_elapsed_ms=");
        if (r118 == null) goto L331;
        String r176 = r118.toString();
    L332:
        if (r176 != null) goto L334;
        r176 = "";
    L334:
        StringBuilder r177 = r175.append(r176).append(", callback_wait_ms=").append(r81).append(r97);
        if (r159 == null) goto L337;
        r21 = d.c.b.a.b.a(r159.a()).toString();
    L337:
        if (r21 != null) goto L339;
        String r178 = "";
    L340:
        r160.i(r105, r177.append(r178).toString());
        return r156;
    L339:
        r178 = r21;
        goto L340
    L331:
        r176 = null;
        goto L332
    L327:
        r174 = false;
        goto L328
    L310:
        if (((Collection) ZeusTransformUtils.preCheckCast(r169, Collection.class, r107)).isEmpty() == false) goto L312;
    L323:
        r171 = 0;
    L302:
        r166 = 0;
    L296:
        r163 = 0;
        goto L297
    L290:
        r158 = null;
        goto L291
    L640:
        r155 = r118.toString();     // Catch: Throwable -> L279 CancellationException -> L281
    L281:
        e = e;
        r111 = r111;
    L279:
        th = th;
        r111 = r111;
        goto L561
    L274:
        r153 = false;
    L344:
        e = e;
    L342:
        th = th;
    L350:
        e = e;
    L346:
        th = th;
        goto L561
    L674:
        Loog r179 = Loog.INSTANCE;     // Catch: Throwable -> L539 CancellationException -> L541
    L656:
        StringBuilder r180 = new StringBuilder().append("[OAutoActionEffect] direct result unavailable ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", callback_wait_ms=").append(r81).append(", fallback=");     // Catch: Throwable -> L533 CancellationException -> L536
    L660:
    L531:
        e = e;
    L538:
        r111 = r111;
    L529:
        th = th;
    L535:
        r111 = r111;
        goto L561
    L360:
        if (r90.j() != com.obric.autogui.agents.a.f.a.f26395d) goto L367;
        String r181 = "virtual_viewtree";
    L368:
        r179.i(r105, r180.append(r181).toString());     // Catch: Throwable -> L529 CancellationException -> L531
        long r182 = n.a(n.a(r75.e(), 1) - a(r72), 0);     // Catch: Throwable -> L529 CancellationException -> L531
        if (r214 == false) goto L371;
        boolean r215 = true;
    L372:
        r64 = ", callback_wait_ms=";
        r63 = r17;
        r62 = ", total_elapsed_ms=";
        r68 = "[OAutoActionEffect] evaluation timing ";
        r67 = ", finish_reason=";
        r70 = ", completed_rounds=";
        r71 = ", detector_execution_count=";
        r74 = r105;
        r73 = ", cancelled_detector_count=";
        r78 = ", timeout_ms=";
        r79 = ", registration_to_callback_elapsed_ms=";
        r26 = r107;
        m r183 = (m) ZeusTransformUtils.preCheckCast(new f(r313, r116, r76, this, r115, r117, r91, r75, r94, r312, r90, r92, r93, r16, r77, r213, r215, null), m.class, r26);     // Catch: Throwable -> L519 CancellationException -> L522
        r12.f26314a = this;     // Catch: Throwable -> L519 CancellationException -> L522
        r12.f26315b = r90;     // Catch: Throwable -> L519 CancellationException -> L522
        r12.f26316c = r91;     // Catch: Throwable -> L519 CancellationException -> L522
        r22 = r69;
        r12.f26317d = r22;     // Catch: Throwable -> L513 CancellationException -> L516
        r20 = r75;
        r12.f26318e = r20;     // Catch: Throwable -> L513 CancellationException -> L516
        r28 = r115;
        r12.f = r28;     // Catch: Throwable -> L513 CancellationException -> L516
        r27 = r76;
        r12.g = r27;     // Catch: Throwable -> L513 CancellationException -> L516
        r112 = r117;
        r12.h = r112;     // Catch: Throwable -> L513 CancellationException -> L516
        r111 = r111;
        r12.i = r111;     // Catch: Throwable -> L509 CancellationException -> L511
        r19 = r118;
        r12.j = r19;     // Catch: Throwable -> L505 CancellationException -> L507
        r113 = r72;
        r12.k = r113;     // Catch: Throwable -> L505 CancellationException -> L507
        r12.l = r81;     // Catch: Throwable -> L501 CancellationException -> L503
        r110 = true;
        r12.o = 1;     // Catch: Throwable -> L501 CancellationException -> L503
    L385:
        Object r184 = dg.b(r182, r183, r12);     // Catch: Throwable -> L505 CancellationException -> L507
    L387:
        if (r184 != r11) goto L389;
        return r11;
    L389:
        r23 = r91;
        r24 = r184;
        r29 = this;
        r86 = r81;
        r25 = r90;
    L503:
        e = e;
    L501:
        th = th;
    L507:
        e = e;
    L505:
        th = th;
        goto L561
    L511:
        e = e;
    L509:
        th = th;
        goto L561
    L516:
        e = e;
        r111 = r111;
    L513:
        th = th;
        r111 = r111;
        goto L561
    L522:
        e = e;
        r111 = r111;
    L519:
        th = th;
        r111 = r111;
        goto L561
    L527:
        e = e;
        r111 = r111;
    L525:
        th = th;
        r111 = r111;
        goto L561
    L371:
        r215 = false;
        goto L372
    L367:
        r181 = "snapshot_detectors";
    L536:
        e = e;
    L533:
        th = th;
    L541:
        e = e;
        r111 = r111;
    L539:
        th = th;
        r111 = r111;
        goto L561
    L670:
        long r185 = a(r72);     // Catch: Throwable -> L158 CancellationException -> L161
        z.f r186 = r311;
        r186.f38504a = s.f26710a;     // Catch: Throwable -> L154 CancellationException -> L156
        Loog.INSTANCE.i(r105, "[OAutoActionEffect] evaluation short-circuited " + com.obric.autogui.agents.a.c.f26286a.a(r90) + ", status=" + com.obric.autogui.agents.a.f.k.f26443b + ", reason=secure_model_screenshot, detect_count=0, total_elapsed_ms=" + r185);     // Catch: Throwable -> L154 CancellationException -> L156
        com.obric.autogui.agents.a.f.i r187 = new com.obric.autogui.agents.a.f.i(com.obric.autogui.agents.a.f.k.f26443b, com.obric.autogui.agents.a.f.k.f26443b, null, "model screenshot reported secure page", p.b(), 0, null, null, null, 448, null);     // Catch: Throwable -> L154 CancellationException -> L156
        String r188 = r310;
        s r189 = (s) ZeusTransformUtils.preCheckCast(r186.f38504a, s.class, r188);
        if (r186.f38504a != s.f26712c) goto L102;
        r r190 = r.f26708d;
    L103:
        r91.a(r69, r189, r190);
        com.obric.autogui.agents.a.m.g r191 = r91.b().j();
        Loog r192 = Loog.INSTANCE;
        StringBuilder r193 = new StringBuilder().append("[OAutoActionEffect] evaluation timing ").append(com.obric.autogui.agents.a.c.f26286a.a(r90)).append(", finish_reason=").append(r186.f38504a).append(", completed_rounds=");
        if (r191 == null) goto L108;
        List<com.obric.autogui.agents.a.m.i> r194 = r191.e();
        if (r194 == null) goto L108;
        int r195 = r194.size();
    L109:
        StringBuilder r196 = r193.append(r195).append(", detector_execution_count=");
        if (r191 == null) goto L114;
        List<com.obric.autogui.agents.a.m.e> r197 = r191.f();
        if (r197 == null) goto L114;
        int r198 = r197.size();
    L115:
        StringBuilder r199 = r196.append(r198).append(", cancelled_detector_count=");
        if (r191 == null) goto L135;
        List<com.obric.autogui.agents.a.m.e> r1100 = r191.f();
        if (r1100 == null) goto L135;
        Iterable r1101 = (Iterable) ZeusTransformUtils.preCheckCast(r1100, Iterable.class, r188);
        if (ZeusTransformUtils.instanceOf(r1101, Collection.class) == true) goto L122;
    L124:
        Iterator r1102 = r1101.iterator();
        int r1103 = 0;
    L126:
        if (r1102.hasNext() == false) goto L136;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r1102.next(), com.obric.autogui.agents.a.m.e.class, r188)).e() != s.f26712c) goto L130;
        boolean r1104 = true;
    L131:
        if (r1104 == false) goto L126;
        r1103 = r1103 + 1;
        if (r1103 >= 0) goto L126;
        p.d();
        goto L126
    L130:
        r1104 = false;
    L136:
        StringBuilder r200 = r199.append(r1103).append(", framework_callback_available=");
        if (r118 == null) goto L139;
        boolean r201 = true;
    L140:
        StringBuilder r202 = r200.append(r201).append(", registration_to_callback_elapsed_ms=");
        if (r118 == null) goto L143;
        String r203 = r118.toString();
    L144:
        if (r203 != null) goto L146;
        r203 = "";
    L146:
        StringBuilder r204 = r202.append(r203).append(", callback_wait_ms=").append(r81).append(", total_elapsed_ms=");
        if (r191 == null) goto L149;
        r21 = d.c.b.a.b.a(r191.a()).toString();
    L149:
        if (r21 != null) goto L151;
        String r205 = "";
    L152:
        r192.i(r105, r204.append(r205).toString());
        return r187;
    L151:
        r205 = r21;
        goto L152
    L143:
        r203 = null;
        goto L144
    L139:
        r201 = false;
        goto L140
    L122:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1101, Collection.class, r188)).isEmpty() == false) goto L124;
    L135:
        r1103 = 0;
    L114:
        r198 = 0;
    L108:
        r195 = 0;
        goto L109
    L102:
        r190 = null;
        goto L103
    L156:
        e = e;
    L163:
        r111 = r186;
    L154:
        th = th;
    L160:
        r111 = r186;
        goto L561
    L161:
        e = e;
        r186 = r311;
    L158:
        th = th;
        r186 = r311;
    L89:
        e = e;
    L45:
        r111 = r311;
    L87:
        th = th;
    L41:
        r111 = r311;
    L92:
        r106 = false;
        goto L94
    L545:
        e = e;
    L552:
        r111 = r311;
    L543:
        th = th;
    L549:
        r111 = r311;
        goto L561
    L76:
        r103 = null;
        goto L77
    L71:
        r102 = false;
        goto L72
    L67:
        r100 = false;
        goto L68
    L61:
        r98 = null;
        goto L62
    L56:
        r87 = false;
    L550:
        e = e;
    L547:
        th = th;
        goto L549
    L52:
        r312 = false;
    L36:
        e = e;
    L34:
        th = th;
        goto L41
    L42:
        e = e;
        r311 = r80;
    L38:
        th = th;
        r311 = r80;
        goto L41
    L46:
        r311 = r80;
        r310 = "com.obric.aiagent.plugin";
        if (r120 == false) goto L49;
        r121 = 1;
        goto L50
    L49:
        r121 = r82;
    L27:
        r120 = false;
        goto L28
    L555:
        e = e;
    L565:
        r111 = r80;
    L553:
        th = th;
    L559:
        r111 = r80;
    L563:
        e = e;
    L557:
        th = th;
    L569:
        th = move-exception;
        s r206 = (s) ZeusTransformUtils.preCheckCast(", registration_to_callback_elapsed_ms=".f38504a, s.class, r4);
        if (", registration_to_callback_elapsed_ms=".f38504a != s.f26712c) goto L573;
        r r207 = r.f26708d;
    L574:
        a(", finish_reason=", r206, r207);
        com.obric.autogui.agents.a.m.g r208 = b().j();
        Loog r209 = Loog.INSTANCE;
        StringBuilder r216 = new StringBuilder().append(TAG).append(com.obric.autogui.agents.a.c.f26286a.a(r16)).append("[OAutoActionEffect] evaluation timing ").append(", registration_to_callback_elapsed_ms=".f38504a).append(", timeout_ms=");
        if (r208 == null) goto L579;
        List<com.obric.autogui.agents.a.m.i> r217 = r208.e();
        if (r217 == null) goto L579;
        int r218 = r217.size();
    L580:
        StringBuilder r219 = r216.append(r218).append("com.obric.aiagent.plugin");
        if (r208 == null) goto L585;
        List<com.obric.autogui.agents.a.m.e> r220 = r208.f();
        if (r220 == null) goto L585;
        int r221 = r220.size();
    L586:
        StringBuilder r222 = r219.append(r221).append(r91);
        if (r208 == null) goto L606;
        List<com.obric.autogui.agents.a.m.e> r223 = r208.f();
        if (r223 == null) goto L606;
        Iterable r224 = (Iterable) ZeusTransformUtils.preCheckCast(r223, Iterable.class, r4);
        if (ZeusTransformUtils.instanceOf(r224, Collection.class) == true) goto L593;
    L595:
        Iterator r225 = r224.iterator();
        int r226 = 0;
    L597:
        if (r225.hasNext() == false) goto L607;
        if (((com.obric.autogui.agents.a.m.e) ZeusTransformUtils.preCheckCast(r225.next(), com.obric.autogui.agents.a.m.e.class, r4)).e() != s.f26712c) goto L601;
        boolean r227 = true;
    L602:
        if (r227 == false) goto L597;
        r226 = r226 + 1;
        if (r226 >= 0) goto L597;
        p.d();
        goto L597
    L601:
        r227 = false;
    L607:
        StringBuilder r228 = r222.append(r226).append(", callback_wait_ms=");
        if (r12 == 0) goto L610;
        boolean r229 = true;
    L611:
        StringBuilder r230 = r228.append(r229).append(r90);
        if (r12 == 0) goto L614;
        String r231 = r12.toString();
    L615:
        if (r231 != null) goto L617;
        r231 = "";
    L617:
        StringBuilder r232 = r230.append(r231).append(r3).append(r65).append(", completed_rounds=");
        if (r208 == null) goto L620;
        r21 = d.c.b.a.b.a(r208.a()).toString();
    L620:
        if (r21 != null) goto L622;
        String r233 = "";
    L623:
        r209.i(1, r232.append(r233).toString());
        throw th;
    L622:
        r233 = r21;
        goto L623
    L614:
        r231 = null;
        goto L615
    L610:
        r229 = false;
        goto L611
    L593:
        if (((Collection) ZeusTransformUtils.preCheckCast(r224, Collection.class, r4)).isEmpty() == false) goto L595;
    L606:
        r226 = 0;
    L585:
        r221 = 0;
    L579:
        r218 = 0;
        goto L580
    L573:
        r207 = null;
    L7:
        r2 = new e(this, r1);
        goto L8
    }

    private final Object a(com.obric.autogui.agents.a.a.f r24, com.obric.autogui.agents.a.l.c r25, int r26, int r27, t r28, d.c.d<? super a> r29) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, h.class) == false) goto L7;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r1, h.class, "com.obric.aiagent.plugin");
        if ((r2.l & Integer.MIN_VALUE) == 0) goto L7;
        r2.l -= Integer.MIN_VALUE;
    L8:
        h r15 = r2;
        Object r3 = r15.j;
        Object r14 = d.c.a.b.a();
        int r4 = r15.l;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r5 = r15.h;
        long r6 = r15.i;
        int r7 = r15.g;
        com.obric.autogui.agents.a.f.k r8 = (com.obric.autogui.agents.a.f.k) ZeusTransformUtils.preCheckCast(r15.f, com.obric.autogui.agents.a.f.k.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.f.b r9 = (com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r15.f26334e, com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin");
        List<com.obric.autogui.agents.a.f.b> r10 = (List) ZeusTransformUtils.preCheckCast(r15.f26333d, List.class, "com.obric.aiagent.plugin");
        List<? extends com.obric.autogui.agents.a.f.c> r11 = (List) ZeusTransformUtils.preCheckCast(r15.f26332c, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.f r12 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r15.f26331b, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
        d r0 = (d) ZeusTransformUtils.preCheckCast(r15.f26330a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        boolean r22 = true;
    L51:
        List<com.obric.autogui.agents.a.f.b> r13 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.f.b r16 = r9;
        com.obric.autogui.agents.a.f.k r17 = r8;
        List<? extends com.obric.autogui.agents.a.f.c> r18 = r11;
        int r19 = r5;
        List<com.obric.autogui.agents.a.f.b> r20 = r10;
    L54:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L56;
        List<com.obric.autogui.agents.a.f.b> r21 = r13;
    L57:
        if (r21 == null) goto L59;
        com.obric.autogui.agents.a.f.b r23 = com.obric.autogui.agents.a.j.a.f26523a.a(r21);
    L60:
        if (r23 != null) goto L62;
    L70:
        com.obric.autogui.agents.a.f.b r110 = null;
    L71:
        if (r23 != null) goto L73;
    L78:
        com.obric.autogui.agents.a.f.b r111 = null;
    L80:
        if (r17 != com.obric.autogui.agents.a.f.k.f26443b) goto L82;
    L89:
        Loog r30 = Loog.INSTANCE;
        StringBuilder r31 = new StringBuilder().append("[OAutoActionEffect] detector stages ").append(com.obric.autogui.agents.a.c.f26286a.a(r12)).append(", round=").append(r7).append(", non_image_status=").append(r17).append(", image_configured=").append(!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty()).append(", image_fallback_executed=");
        if (r19 == 0) goto L92;
        boolean r32 = r22;
    L93:
        r30.i(TAG, r31.append(r32).toString());
        return new a(p.c((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")), r16, r0.a(r6));
    L92:
        r32 = false;
        goto L93
    L82:
        if (r17 == com.obric.autogui.agents.a.f.k.f26442a) goto L89;
        if (r110 != null) goto L88;
        if (r111 != null) goto L87;
        r16 = com.obric.autogui.agents.a.j.a.f26523a.a(p.c((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")));
        goto L89
    L87:
        r16 = r111;
        goto L89
    L88:
        r16 = r110;
        goto L89
    L73:
        if (r23.b() != com.obric.autogui.agents.a.f.k.f26444c) goto L75;
        boolean r112 = r22;
    L76:
        if (r112 == false) goto L78;
        r111 = r23;
        goto L80
    L75:
        r112 = false;
        goto L76
    L62:
        if (r23.b() != com.obric.autogui.agents.a.f.k.f26443b) goto L64;
    L67:
        boolean r113 = r22;
    L68:
        if (r113 == false) goto L70;
        r110 = r23;
        goto L71
    L64:
        if (r23.b() == com.obric.autogui.agents.a.f.k.f26442a) goto L67;
        r113 = false;
        goto L68
    L59:
        r23 = null;
        goto L60
    L56:
        r21 = null;
        goto L57
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r33 = r15.i;
        int r34 = r15.h;
        r7 = r15.g;
        r18 = (List) ZeusTransformUtils.preCheckCast(r15.f26334e, List.class, "com.obric.aiagent.plugin");
        t r35 = (t) ZeusTransformUtils.preCheckCast(r15.f26333d, t.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.l.c r36 = (com.obric.autogui.agents.a.l.c) ZeusTransformUtils.preCheckCast(r15.f26332c, com.obric.autogui.agents.a.l.c.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.f r114 = (com.obric.autogui.agents.a.a.f) ZeusTransformUtils.preCheckCast(r15.f26331b, com.obric.autogui.agents.a.a.f.class, "com.obric.aiagent.plugin");
        r0 = (d) ZeusTransformUtils.preCheckCast(r15.f26330a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        t r115 = r35;
        int r37 = r34;
        r6 = r33;
        Object r38 = r3;
        com.obric.autogui.agents.a.a.f r39 = r114;
    L38:
        r20 = (List) ZeusTransformUtils.preCheckCast(r38, List.class, "com.obric.aiagent.plugin");
        r16 = com.obric.autogui.agents.a.j.a.f26523a.a(r20);
        com.obric.autogui.agents.a.f.k r116 = r16.b();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L41;
    L45:
        r19 = 0;
    L46:
        if (r19 == 0) goto L52;
        r15.f26330a = r0;
        r15.f26331b = r39;
        r15.f26332c = r18;
        r15.f26333d = r20;
        r15.f26334e = r16;
        r15.f = r116;
        r15.g = r7;
        r15.i = r6;
        r15.h = r19;
        r15.l = 2;
        int r117 = r19;
        r22 = true;
        Object r40 = r0.a(r18, r39, r36, r7, r37, r115, r15);
        if (r40 != r14) goto L50;
        return r14;
    L50:
        r12 = r39;
        r10 = r20;
        r11 = r18;
        r3 = r40;
        r5 = r117;
        r8 = r116;
        r9 = r16;
        goto L51
    L52:
        r22 = true;
        r12 = r39;
        r13 = p.b();
        r17 = r116;
        goto L54
    L41:
        if (r116 == com.obric.autogui.agents.a.f.k.f26443b) goto L45;
        if (r116 == com.obric.autogui.agents.a.f.k.f26442a) goto L45;
        r19 = 1;
        goto L46
    L16:
        d.o.a(r3);
        long r118 = ((Number) ZeusTransformUtils.preCheckCast(this.f26297d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Iterable r41 = (Iterable) ZeusTransformUtils.preCheckCast(r24.a().b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r42 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r43 = r41.iterator();
    L18:
        if (r43.hasNext() == false) goto L25;
        Object r44 = r43.next();
        if (((com.obric.autogui.agents.a.f.c) ZeusTransformUtils.preCheckCast(r44, com.obric.autogui.agents.a.f.c.class, "com.obric.aiagent.plugin")) == com.obric.autogui.agents.a.f.c.f26405d) goto L22;
        boolean r45 = true;
    L23:
        if (r45 == false) goto L18;
        r42.add(r44);
        goto L18
    L22:
        r45 = false;
        goto L23
    L25:
        List<? extends com.obric.autogui.agents.a.f.c> r46 = (List) ZeusTransformUtils.preCheckCast(r42, List.class, "com.obric.aiagent.plugin");
        Iterable r47 = (Iterable) ZeusTransformUtils.preCheckCast(r24.a().b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r48 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r49 = r47.iterator();
    L27:
        if (r49.hasNext() == false) goto L34;
        Object r50 = r49.next();
        if (((com.obric.autogui.agents.a.f.c) ZeusTransformUtils.preCheckCast(r50, com.obric.autogui.agents.a.f.c.class, "com.obric.aiagent.plugin")) != com.obric.autogui.agents.a.f.c.f26405d) goto L31;
        boolean r51 = true;
    L32:
        if (r51 == false) goto L27;
        r48.add(r50);
        goto L27
    L31:
        r51 = false;
        goto L32
    L34:
        List<? extends com.obric.autogui.agents.a.f.c> r52 = (List) ZeusTransformUtils.preCheckCast(r48, List.class, "com.obric.aiagent.plugin");
        r15.f26330a = this;
        r15.f26331b = r24;
        r15.f26332c = r25;
        r15.f26333d = r28;
        r15.f26334e = r52;
        r15.g = r26;
        r15.h = r27;
        r15.i = r118;
        r15.l = 1;
        Object r53 = a(r46, r24, r25, r26, r27, r28, r15);
        if (r53 != r14) goto L37;
        return r14;
    L37:
        r7 = r26;
        r37 = r27;
        r38 = r53;
        r0 = this;
        r6 = r118;
        r18 = r52;
        r39 = r24;
        r36 = r25;
        r115 = r28;
    L7:
        r2 = new h(this, r1);
        goto L8
    }

    private final Object a(List<? extends com.obric.autogui.agents.a.f.c> r15, com.obric.autogui.agents.a.a.f r16, com.obric.autogui.agents.a.l.c r17, int r18, int r19, t r20, d.c.d<? super List<com.obric.autogui.agents.a.f.b>> r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r3.add((d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r20, r18, (com.obric.autogui.agents.a.f.c) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.autogui.agents.a.f.c.class, "com.obric.aiagent.plugin"), this, r17, r16, r19, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        goto L4
    L7:
        return com.obric.autogui.agents.a.c.e.a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), r2);
    }

    static /* synthetic */ com.obric.autogui.agents.a.f.i a(d r6, com.obric.autogui.agents.a.f.b r7, List r8, int r9, com.obric.autogui.agents.a.f.k r10, com.obric.autogui.agents.a.f.e r11, int r12, Object r13) {
        List<com.obric.autogui.agents.a.f.b> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.a(r7, r2, r9, r10, r11);
    }

    private final com.obric.autogui.agents.a.f.i a(com.obric.autogui.agents.a.f.b r15, List<com.obric.autogui.agents.a.f.b> r16, int r17, com.obric.autogui.agents.a.f.k r18, com.obric.autogui.agents.a.f.e r19) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.f.k r4 = r15.b();
        com.obric.autogui.agents.a.f.c r5 = r15.a();
        String r6 = r15.c();
        String r0 = r15.d();
        if (r0 != null) goto L12;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = ((com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin")).d();
        if (r2 == null) goto L6;
    L11:
        String r9 = r2;
    L14:
        return new com.obric.autogui.agents.a.f.i(r18, r4, r5, r6, r7, r17, r9, r19, null, 256, null);
    L10:
        r2 = null;
        goto L11
    L12:
        r9 = r0;
        goto L14
    }

    private final long a(long r3) {
        return n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26297d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - r3, 0);
    }
}
