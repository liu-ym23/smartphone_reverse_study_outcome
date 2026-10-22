package com.obric.agent.trace;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntentMetricEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: compiled from: IntentMetricEvent.kt */
    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15503a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15503a, r6.f15503a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f15503a.hashCode();
        }

        public String toString() {
            return "FirstTokenDisplayed(traceId=" + this.f15503a + ')';
        }

        public String a() {
            return this.f15503a;
        }

        public a(String r2) {
            d.h.b.o.e(r2, "traceId");
            super(null);
            this.f15503a = r2;
        }
    }

    /* JADX INFO: compiled from: IntentMetricEvent.kt */
    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15508e;
        private final Integer f;
        private final boolean g;
        private final Long h;
        private final Long i;
        private final boolean j;
        private final boolean k;
        private final String l;
        private final boolean m;
        private final boolean n;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15504a, r6.f15504a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15505b, r6.f15505b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15506c, r6.f15506c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15507d, r6.f15507d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15508e, r6.f15508e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L50;
            return false;
        L50:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15504a.hashCode() * 31) + this.f15505b.hashCode()) * 31;
            String r1 = this.f15506c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15507d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f15508e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.f;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (((r10 + r12) * 31) + Boolean.hashCode(this.g)) * 31;
            Long r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Long r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (((((r16 + r18) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31;
            String r20 = this.l;
            if (r20 == null) goto L31;
            r2 = r20.hashCode();
        L31:
            return ((((r19 + r2) * 31) + Boolean.hashCode(this.m)) * 31) + Boolean.hashCode(this.n);
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("IntentCallEnd(traceId=").append(this.f15504a).append(", intentName=").append(this.f15505b).append(", jobId=").append(this.f15506c).append(", actionId=").append(this.f15507d).append(", calledAppName=").append(this.f15508e).append(", resultCode=").append(this.f).append(", isFinal=").append(this.g).append(", executeCostMs=").append(this.h).append(", appExecuteCostMs=").append(this.i).append(", isOmni=").append(this.j).append(", isContinuousTalk=").append(this.k).append(", dispatchSource=");
            r0.append(this.l).append(", isLocalIntent=").append(this.m).append(", noReplyExpected=").append(this.n).append(')');
            return r0.toString();
        }

        public String a() {
            return this.f15504a;
        }

        public final String b() {
            return this.f15505b;
        }

        public final String c() {
            return this.f15506c;
        }

        public final String d() {
            return this.f15507d;
        }

        public final String e() {
            return this.f15508e;
        }

        public final Integer f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final Long h() {
            return this.h;
        }

        public final Long i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }

        public final String l() {
            return this.l;
        }

        public final boolean m() {
            return this.m;
        }

        public final boolean n() {
            return this.n;
        }

        public b(String r2, String r3, String r4, String r5, String r6, Integer r7, boolean r8, Long r9, Long r10, boolean r11, boolean r12, String r13, boolean r14, boolean r15) {
            d.h.b.o.e(r2, "traceId");
            d.h.b.o.e(r3, "intentName");
            super(null);
            this.f15504a = r2;
            this.f15505b = r3;
            this.f15506c = r4;
            this.f15507d = r5;
            this.f15508e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
        }
    }

    /* JADX INFO: compiled from: IntentMetricEvent.kt */
    public static final class c extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15513e;
        private final String f;
        private final Long g;
        private final boolean h;
        private final boolean i;
        private final String j;
        private final boolean k;
        private final boolean l;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15509a, r6.f15509a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15510b, r6.f15510b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15511c, r6.f15511c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15512d, r6.f15512d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15513e, r6.f15513e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L44;
            return false;
        L44:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15509a.hashCode() * 31) + this.f15510b.hashCode()) * 31;
            String r1 = this.f15511c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15512d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f15513e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Long r14 = this.g;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (((((r13 + r15) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31;
            String r17 = this.j;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return ((((r16 + r2) * 31) + Boolean.hashCode(this.k)) * 31) + Boolean.hashCode(this.l);
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("IntentCallStart(traceId=").append(this.f15509a).append(", intentName=").append(this.f15510b).append(", jobId=").append(this.f15511c).append(", actionId=").append(this.f15512d).append(", callScene=").append(this.f15513e).append(", calledAppName=").append(this.f).append(", executeStartTimeMs=").append(this.g).append(", isOmni=").append(this.h).append(", isContinuousTalk=").append(this.i).append(", dispatchSource=").append(this.j).append(", isLocalIntent=").append(this.k).append(", noReplyExpected=");
            r0.append(this.l).append(')');
            return r0.toString();
        }

        public String a() {
            return this.f15509a;
        }

        public final String b() {
            return this.f15510b;
        }

        public final String c() {
            return this.f15511c;
        }

        public final String d() {
            return this.f15512d;
        }

        public final String e() {
            return this.f15513e;
        }

        public final String f() {
            return this.f;
        }

        public final Long g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final String j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }

        public final boolean l() {
            return this.l;
        }

        public c(String r2, String r3, String r4, String r5, String r6, String r7, Long r8, boolean r9, boolean r10, String r11, boolean r12, boolean r13) {
            d.h.b.o.e(r2, "traceId");
            d.h.b.o.e(r3, "intentName");
            super(null);
            this.f15509a = r2;
            this.f15510b = r3;
            this.f15511c = r4;
            this.f15512d = r5;
            this.f15513e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
        }
    }

    /* JADX INFO: compiled from: IntentMetricEvent.kt */
    public static final class d extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f15517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f15518e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15514a, r6.f15514a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15515b, r6.f15515b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15516c, r6.f15516c) == true) goto L18;
            return false;
        L18:
            if (this.f15517d == r6.f15517d) goto L21;
            return false;
        L21:
            if (this.f15518e == r6.f15518e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15514a.hashCode() * 31;
            String r1 = this.f15515b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15516c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + Boolean.hashCode(this.f15517d)) * 31) + Boolean.hashCode(this.f15518e);
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "QueryDisplayed(traceId=" + this.f15514a + ", localMessageId=" + this.f15515b + ", callScene=" + this.f15516c + ", isOmni=" + this.f15517d + ", isContinuousTalk=" + this.f15518e + ')';
        }

        public String a() {
            return this.f15514a;
        }

        public final String b() {
            return this.f15515b;
        }

        public final String c() {
            return this.f15516c;
        }

        public final boolean d() {
            return this.f15517d;
        }

        public final boolean e() {
            return this.f15518e;
        }

        public d(String r2, String r3, String r4, boolean r5, boolean r6) {
            d.h.b.o.e(r2, "traceId");
            super(null);
            this.f15514a = r2;
            this.f15515b = r3;
            this.f15516c = r4;
            this.f15517d = r5;
            this.f15518e = r6;
        }
    }

    /* JADX INFO: compiled from: IntentMetricEvent.kt */
    public static final class e extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15519a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15519a, r6.f15519a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f15519a.hashCode();
        }

        public String toString() {
            return "SummaryReplyScreenFinish(traceId=" + this.f15519a + ')';
        }

        public String a() {
            return this.f15519a;
        }

        public e(String r2) {
            d.h.b.o.e(r2, "traceId");
            super(null);
            this.f15519a = r2;
        }
    }

    /* JADX INFO: compiled from: IntentMetricEvent.kt */
    public static final class f extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f15523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15524e;
        private final String f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15520a, r6.f15520a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15521b, r6.f15521b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15522c, r6.f15522c) == true) goto L18;
            return false;
        L18:
            if (this.f15523d == r6.f15523d) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15524e, r6.f15524e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15520a.hashCode() * 31) + this.f15521b.hashCode()) * 31;
            String r1 = this.f15522c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.f15523d)) * 31;
            String r5 = this.f15524e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "TraceFinished(traceId=" + this.f15520a + ", terminalReason=" + this.f15521b + ", terminalFrom=" + this.f15522c + ", isValidLatencySample=" + this.f15523d + ", mergedToTraceId=" + this.f15524e + ", interruptedByTraceId=" + this.f + ')';
        }

        public /* synthetic */ f(String r8, String r9, String r10, boolean r11, String r12, String r13, int r14, d.h.b.h r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = "trace_finished";
        L5:
            String r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            String r3 = null;
        L10:
            if ((r14 & 8) == 0) goto L12;
            r11 = false;
        L12:
            boolean r4 = r11;
            if ((r14 & 16) == 0) goto L15;
            String r5 = null;
        L17:
            if ((r14 & 32) == 0) goto L19;
            String r6 = null;
        L20:
            this(r8, r2, r3, r4, r5, r6);
            return;
        L19:
            r6 = r13;
            goto L20
        L15:
            r5 = r12;
            goto L17
        L8:
            r3 = r10;
            goto L10
        }

        public String a() {
            return this.f15520a;
        }

        public final String b() {
            return this.f15521b;
        }

        public final String c() {
            return this.f15522c;
        }

        public final boolean d() {
            return this.f15523d;
        }

        public final String e() {
            return this.f15524e;
        }

        public final String f() {
            return this.f;
        }

        public f(String r2, String r3, String r4, boolean r5, String r6, String r7) {
            d.h.b.o.e(r2, "traceId");
            d.h.b.o.e(r3, "terminalReason");
            super(null);
            this.f15520a = r2;
            this.f15521b = r3;
            this.f15522c = r4;
            this.f15523d = r5;
            this.f15524e = r6;
            this.f = r7;
        }
    }

    public /* synthetic */ k(d.h.b.h r1) {
        this();
    }

    private k() {
    }
}
