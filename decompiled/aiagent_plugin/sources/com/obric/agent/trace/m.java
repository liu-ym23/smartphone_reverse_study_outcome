package com.obric.agent.trace;

import android.os.SystemClock;
import androidx.core.provider.FontsContractCompat;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentMetricsReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private static final String TAG = "IntentMetricsReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f15526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, c> f15527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, g> f15528c = null;

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f15530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f15531c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15529a, r6.f15529a) == true) goto L12;
            return false;
        L12:
            if (this.f15530b == r6.f15530b) goto L15;
            return false;
        L15:
            if (this.f15531c == r6.f15531c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f15529a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + Boolean.hashCode(this.f15530b)) * 31) + Boolean.hashCode(this.f15531c);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "DispatchSourceSnapshot(dispatchSource=" + this.f15529a + ", isLocalIntent=" + this.f15530b + ", noReplyExpected=" + this.f15531c + ')';
        }

        public a(String r1, boolean r2, boolean r3) {
            this.f15529a = r1;
            this.f15530b = r2;
            this.f15531c = r3;
        }

        public final String a() {
            return this.f15529a;
        }

        public final boolean b() {
            return this.f15530b;
        }

        public final boolean c() {
            return this.f15531c;
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15536e;
        private volatile String f;
        private volatile boolean g;
        private volatile boolean h;
        private volatile String i;
        private volatile boolean j;
        private volatile boolean k;
        private final long l;
        private volatile Long m;
        private volatile Long n;
        private volatile Long o;
        private volatile Integer p;
        private volatile boolean q;
        private volatile boolean r;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15532a, r10.f15532a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15533b, r10.f15533b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15534c, r10.f15534c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15535d, r10.f15535d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15536e, r10.f15536e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L33;
            return false;
        L33:
            if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r10.j) goto L39;
            return false;
        L39:
            if (this.k == r10.k) goto L42;
            return false;
        L42:
            if (this.l == r10.l) goto L45;
            return false;
        L45:
            if (d.h.b.o.a(this.m, r10.m) == true) goto L48;
            return false;
        L48:
            if (d.h.b.o.a(this.n, r10.n) == true) goto L51;
            return false;
        L51:
            if (d.h.b.o.a(this.o, r10.o) == true) goto L54;
            return false;
        L54:
            if (d.h.b.o.a(this.p, r10.p) == true) goto L57;
            return false;
        L57:
            if (this.q == r10.q) goto L60;
            return false;
        L60:
            if (this.r == r10.r) goto L62;
            return false;
        L62:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15532a.hashCode() * 31) + this.f15533b.hashCode()) * 31;
            String r1 = this.f15534c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15535d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f15536e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            if (this.f != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (((((r10 + r11) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31;
            if (this.i != null) goto L21;
            int r13 = 0;
        L22:
            int r14 = (((((((r12 + r13) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31;
            if (this.m != null) goto L25;
            int r15 = 0;
        L26:
            int r16 = (r14 + r15) * 31;
            if (this.n != null) goto L29;
            int r17 = 0;
        L30:
            int r18 = (r16 + r17) * 31;
            if (this.o != null) goto L33;
            int r19 = 0;
        L34:
            int r20 = (r18 + r19) * 31;
            if (this.p == null) goto L39;
            r2 = this.p.hashCode();
        L39:
            return ((((r20 + r2) * 31) + Boolean.hashCode(this.q)) * 31) + Boolean.hashCode(this.r);
        L33:
            r19 = this.o.hashCode();
            goto L34
        L29:
            r17 = this.n.hashCode();
            goto L30
        L25:
            r15 = this.m.hashCode();
            goto L26
        L21:
            r13 = this.i.hashCode();
            goto L22
        L17:
            r11 = this.f.hashCode();
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
            r0.append("IntentCallMetric(traceId=").append(this.f15532a).append(", intentName=").append(this.f15533b).append(", jobId=").append(this.f15534c).append(", actionId=").append(this.f15535d).append(", callScene=").append(this.f15536e).append(", calledAppName=").append(this.f).append(", isOmni=").append(this.g).append(", isContinuousTalk=").append(this.h).append(", dispatchSource=").append(this.i).append(", isLocalIntent=").append(this.j).append(", noReplyExpected=").append(this.k).append(", startTimeMs=");
            r0.append(this.l).append(", endTimeMs=").append(this.m).append(", executeCostMs=").append(this.n).append(", appExecuteCostMs=").append(this.o).append(", resultCode=").append(this.p).append(", isFinal=").append(this.q).append(", hasResult=").append(this.r).append(')');
            return r0.toString();
        }

        public b(String r5, String r6, String r7, String r8, String r9, String r10, boolean r11, boolean r12, String r13, boolean r14, boolean r15, long r16, Long r18, Long r19, Long r20, Integer r21, boolean r22, boolean r23) {
            d.h.b.o.e(r5, "traceId");
            d.h.b.o.e(r6, "intentName");
            this.f15532a = r5;
            this.f15533b = r6;
            this.f15534c = r7;
            this.f15535d = r8;
            this.f15536e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r18;
            this.n = r19;
            this.o = r20;
            this.p = r21;
            this.q = r22;
            this.r = r23;
        }

        public /* synthetic */ b(String r24, String r25, String r26, String r27, String r28, String r29, boolean r30, boolean r31, String r32, boolean r33, boolean r34, long r35, Long r37, Long r38, Long r39, Integer r40, boolean r41, boolean r42, int r43, d.h.b.h r44) {
            if ((r43 & 4096) == 0) goto L5;
            Long r17 = null;
        L7:
            if ((r43 & 8192) == 0) goto L9;
            Long r18 = null;
        L11:
            if ((r43 & 16384) == 0) goto L13;
            Long r19 = null;
        L15:
            if ((32768 & r43) == 0) goto L17;
            Integer r20 = null;
        L19:
            if ((65536 & r43) == 0) goto L21;
            boolean r21 = false;
        L23:
            if ((r43 & UiType.FLAG_PHONE_CARD) == 0) goto L25;
            boolean r22 = false;
        L26:
            this(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r17, r18, r19, r20, r21, r22);
            return;
        L25:
            r22 = r42;
            goto L26
        L21:
            r21 = r41;
            goto L23
        L17:
            r20 = r40;
            goto L19
        L13:
            r19 = r39;
            goto L15
        L9:
            r18 = r38;
            goto L11
        L5:
            r17 = r37;
            goto L7
        }

        public final String a() {
            return this.f15532a;
        }

        public final String b() {
            return this.f15533b;
        }

        public final String c() {
            return this.f15534c;
        }

        public final String d() {
            return this.f15535d;
        }

        public final void a(String r1) {
            this.f = r1;
        }

        public final String e() {
            return this.f;
        }

        public final void a(boolean r1) {
            this.g = r1;
        }

        public final boolean f() {
            return this.g;
        }

        public final void b(boolean r1) {
            this.h = r1;
        }

        public final boolean g() {
            return this.h;
        }

        public final void b(String r1) {
            this.i = r1;
        }

        public final String h() {
            return this.i;
        }

        public final void c(boolean r1) {
            this.j = r1;
        }

        public final boolean i() {
            return this.j;
        }

        public final void d(boolean r1) {
            this.k = r1;
        }

        public final boolean j() {
            return this.k;
        }

        public final long k() {
            return this.l;
        }

        public final void a(Long r1) {
            this.m = r1;
        }

        public final Long l() {
            return this.m;
        }

        public final void b(Long r1) {
            this.n = r1;
        }

        public final Long m() {
            return this.n;
        }

        public final void c(Long r1) {
            this.o = r1;
        }

        public final Long n() {
            return this.o;
        }

        public final void a(Integer r1) {
            this.p = r1;
        }

        public final Integer o() {
            return this.p;
        }

        public final void e(boolean r1) {
            this.q = r1;
        }

        public final boolean p() {
            return this.q;
        }

        public final void f(boolean r1) {
            this.r = r1;
        }

        public final boolean q() {
            return this.r;
        }

        public final String r() {
            return m.a(m.f15526a, this.f15532a, this.f15533b, this.f15534c, this.f15535d);
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile Long f15538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f15539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile String f15540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile boolean f15541e;
        private volatile boolean f;
        private volatile String g;
        private volatile boolean h;
        private volatile boolean i;
        private volatile Long j;
        private volatile Long k;
        private final List<b> l;
        private final Set<String> m;
        private final Set<String> n;
        private volatile boolean o;
        private volatile boolean p;
        private volatile boolean q;
        private volatile long r;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15537a, r8.f15537a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15538b, r8.f15538b) == true) goto L15;
            return false;
        L15:
            if (this.f15539c == r8.f15539c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15540d, r8.f15540d) == true) goto L21;
            return false;
        L21:
            if (this.f15541e == r8.f15541e) goto L24;
            return false;
        L24:
            if (this.f == r8.f) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r8.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r8.h) goto L33;
            return false;
        L33:
            if (this.i == r8.i) goto L36;
            return false;
        L36:
            if (d.h.b.o.a(this.j, r8.j) == true) goto L39;
            return false;
        L39:
            if (d.h.b.o.a(this.k, r8.k) == true) goto L42;
            return false;
        L42:
            if (d.h.b.o.a(this.l, r8.l) == true) goto L45;
            return false;
        L45:
            if (d.h.b.o.a(this.m, r8.m) == true) goto L48;
            return false;
        L48:
            if (d.h.b.o.a(this.n, r8.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r8.o) goto L54;
            return false;
        L54:
            if (this.p == r8.p) goto L57;
            return false;
        L57:
            if (this.q == r8.q) goto L60;
            return false;
        L60:
            if (this.r == r8.r) goto L62;
            return false;
        L62:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15537a.hashCode() * 31;
            int r2 = 0;
            if (this.f15538b != null) goto L5;
            int r1 = 0;
        L6:
            int r3 = (((r0 + r1) * 31) + Boolean.hashCode(this.f15539c)) * 31;
            if (this.f15540d != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (((((r3 + r4) * 31) + Boolean.hashCode(this.f15541e)) * 31) + Boolean.hashCode(this.f)) * 31;
            if (this.g != null) goto L13;
            int r6 = 0;
        L14:
            int r7 = (((((r5 + r6) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31;
            if (this.j != null) goto L17;
            int r8 = 0;
        L18:
            int r9 = (r7 + r8) * 31;
            if (this.k == null) goto L23;
            r2 = this.k.hashCode();
        L23:
            return ((((((((((((((r9 + r2) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + Boolean.hashCode(this.o)) * 31) + Boolean.hashCode(this.p)) * 31) + Boolean.hashCode(this.q)) * 31) + Long.hashCode(this.r);
        L17:
            r8 = this.j.hashCode();
            goto L18
        L13:
            r6 = this.g.hashCode();
            goto L14
        L9:
            r4 = this.f15540d.hashCode();
            goto L10
        L5:
            r1 = this.f15538b.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("QueryMetric(traceId=").append(this.f15537a).append(", queryStartTimeMs=").append(this.f15538b).append(", hasQueryDisplayed=").append(this.f15539c).append(", queryCallScene=").append(this.f15540d).append(", isOmni=").append(this.f15541e).append(", isContinuousTalk=").append(this.f).append(", dispatchSource=").append(this.g).append(", isLocalIntent=").append(this.h).append(", noReplyExpected=").append(this.i).append(", firstTokenTimeMs=").append(this.j).append(", finishTimeMs=").append(this.k).append(", intentCalls=");
            r0.append(this.l).append(", reportedStartKeys=").append(this.m).append(", reportedFinishKeys=").append(this.n).append(", firstTokenReported=").append(this.o).append(", screenFinishReported=").append(this.p).append(", terminalReported=").append(this.q).append(", lastUpdatedMs=").append(this.r).append(')');
            return r0.toString();
        }

        public c(String r8, Long r9, boolean r10, String r11, boolean r12, boolean r13, String r14, boolean r15, boolean r16, Long r17, Long r18, List<b> r19, Set<String> r20, Set<String> r21, boolean r22, boolean r23, boolean r24, long r25) {
            List<b> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
            Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.aiagent.plugin");
            Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "traceId");
            d.h.b.o.e(r2, "intentCalls");
            d.h.b.o.e(r4, "reportedStartKeys");
            d.h.b.o.e(r3, "reportedFinishKeys");
            this.f15537a = r8;
            this.f15538b = r9;
            this.f15539c = r10;
            this.f15540d = r11;
            this.f15541e = r12;
            this.f = r13;
            this.g = r14;
            this.h = r15;
            this.i = r16;
            this.j = r17;
            this.k = r18;
            this.l = r2;
            this.m = r4;
            this.n = r3;
            this.o = r22;
            this.p = r23;
            this.q = r24;
            this.r = r25;
        }

        public final String a() {
            return this.f15537a;
        }

        public final void a(Long r1) {
            this.f15538b = r1;
        }

        public final Long b() {
            return this.f15538b;
        }

        public final void a(boolean r1) {
            this.f15539c = r1;
        }

        public final boolean c() {
            return this.f15539c;
        }

        public final void a(String r1) {
            this.f15540d = r1;
        }

        public final String d() {
            return this.f15540d;
        }

        public final void b(boolean r1) {
            this.f15541e = r1;
        }

        public final boolean e() {
            return this.f15541e;
        }

        public final void c(boolean r1) {
            this.f = r1;
        }

        public final boolean f() {
            return this.f;
        }

        public final void b(String r1) {
            this.g = r1;
        }

        public final String g() {
            return this.g;
        }

        public final void d(boolean r1) {
            this.h = r1;
        }

        public final boolean h() {
            return this.h;
        }

        public final void e(boolean r1) {
            this.i = r1;
        }

        public final boolean i() {
            return this.i;
        }

        public final void b(Long r1) {
            this.j = r1;
        }

        public final Long j() {
            return this.j;
        }

        public final void c(Long r1) {
            this.k = r1;
        }

        public final Long k() {
            return this.k;
        }

        public /* synthetic */ c(String r20, Long r21, boolean r22, String r23, boolean r24, boolean r25, String r26, boolean r27, boolean r28, Long r29, Long r30, List r31, Set r32, Set r33, boolean r34, boolean r35, boolean r36, long r37, int r39, d.h.b.h r40) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
            Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.aiagent.plugin");
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r33, Set.class, "com.obric.aiagent.plugin");
            if ((r39 & 2) == 0) goto L5;
            Long r5 = null;
        L7:
            if ((r39 & 4) == 0) goto L9;
            boolean r7 = false;
        L11:
            if ((r39 & 8) == 0) goto L13;
            String r9 = null;
        L15:
            if ((r39 & 16) == 0) goto L17;
            boolean r10 = false;
        L19:
            if ((r39 & 32) == 0) goto L21;
            boolean r11 = false;
        L23:
            if ((r39 & 64) == 0) goto L25;
            String r12 = null;
        L27:
            if ((r39 & 128) == 0) goto L29;
            boolean r13 = false;
        L31:
            if ((r39 & 256) == 0) goto L33;
            boolean r14 = false;
        L35:
            if ((r39 & 512) == 0) goto L37;
            Long r15 = null;
        L39:
            if ((r39 & 1024) == 0) goto L41;
            Long r6 = null;
        L43:
            if ((r39 & 2048) == 0) goto L46;
            r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L46:
            if ((r39 & 4096) == 0) goto L49;
            r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        L49:
            if ((r39 & 8192) == 0) goto L52;
            r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        L52:
            if ((r39 & 16384) == 0) goto L54;
            boolean r2 = false;
        L56:
            if ((32768 & r39) == 0) goto L58;
            boolean r8 = false;
        L60:
            if ((r39 & 65536) == 0) goto L62;
            boolean r16 = false;
        L64:
            if ((r39 & UiType.FLAG_PHONE_CARD) == 0) goto L66;
            long r17 = SystemClock.elapsedRealtime();
        L67:
            this(r20, r5, r7, r9, r10, r11, r12, r13, r14, r15, r6, r1, r3, r4, r2, r8, r16, r17);
            return;
        L66:
            r17 = r37;
            goto L67
        L62:
            r16 = r36;
            goto L64
        L58:
            r8 = r35;
            goto L60
        L54:
            r2 = r34;
            goto L56
        L41:
            r6 = r30;
            goto L43
        L37:
            r15 = r29;
            goto L39
        L33:
            r14 = r28;
            goto L35
        L29:
            r13 = r27;
            goto L31
        L25:
            r12 = r26;
            goto L27
        L21:
            r11 = r25;
            goto L23
        L17:
            r10 = r24;
            goto L19
        L13:
            r9 = r23;
            goto L15
        L9:
            r7 = r22;
            goto L11
        L5:
            r5 = r21;
            goto L7
        }

        public final List<b> l() {
            return this.l;
        }

        public final Set<String> m() {
            return this.m;
        }

        public final Set<String> n() {
            return this.n;
        }

        public final void f(boolean r1) {
            this.o = r1;
        }

        public final boolean o() {
            return this.o;
        }

        public final void g(boolean r1) {
            this.p = r1;
        }

        public final boolean p() {
            return this.p;
        }

        public final void h(boolean r1) {
            this.q = r1;
        }

        public final boolean q() {
            return this.q;
        }

        public final void a(long r1) {
            this.r = r1;
        }

        public final long r() {
            return this.r;
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f15542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f15543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f15544c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15542a, r6.f15542a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15543b, r6.f15543b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15544c, r6.f15544c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            JSONObject r0 = this.f15542a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.f15543b.hashCode()) * 31;
            f r4 = this.f15544c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ScreenFinishReport(firstTokenParams=" + this.f15542a + ", screenFinishParams=" + this.f15543b + ", terminalReport=" + this.f15544c + ')';
        }

        public d(JSONObject r2, JSONObject r3, f r4) {
            d.h.b.o.e(r3, "screenFinishParams");
            this.f15542a = r2;
            this.f15543b = r3;
            this.f15544c = r4;
        }

        public final JSONObject a() {
            return this.f15542a;
        }

        public final JSONObject b() {
            return this.f15543b;
        }

        public final f c() {
            return this.f15544c;
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f15548d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f15549e;
        private final String f;
        private final boolean g;
        private final boolean h;
        private final Long i;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15545a, r6.f15545a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15546b, r6.f15546b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15547c, r6.f15547c) == true) goto L18;
            return false;
        L18:
            if (this.f15548d == r6.f15548d) goto L21;
            return false;
        L21:
            if (this.f15549e == r6.f15549e) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (d.h.b.o.a(this.i, r6.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15545a.hashCode() * 31) + this.f15546b.hashCode()) * 31;
            String r1 = this.f15547c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + Boolean.hashCode(this.f15548d)) * 31) + Boolean.hashCode(this.f15549e)) * 31;
            String r5 = this.f;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((((r4 + r6) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31;
            Long r8 = this.i;
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
            return "StartReport(traceId=" + this.f15545a + ", intentName=" + this.f15546b + ", callScene=" + this.f15547c + ", isOmni=" + this.f15548d + ", isContinuousTalk=" + this.f15549e + ", dispatchSource=" + this.f + ", isLocalIntent=" + this.g + ", noReplyExpected=" + this.h + ", queryToCallStartCostMs=" + this.i + ')';
        }

        public e(String r2, String r3, String r4, boolean r5, boolean r6, String r7, boolean r8, boolean r9, Long r10) {
            d.h.b.o.e(r2, "traceId");
            d.h.b.o.e(r3, "intentName");
            this.f15545a = r2;
            this.f15546b = r3;
            this.f15547c = r4;
            this.f15548d = r5;
            this.f15549e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }

        public final String a() {
            return this.f15545a;
        }

        public final String b() {
            return this.f15546b;
        }

        public final String c() {
            return this.f15547c;
        }

        public final boolean d() {
            return this.f15548d;
        }

        public final boolean e() {
            return this.f15549e;
        }

        public final String f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final Long i() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JSONObject f15552c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15550a, r6.f15550a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15551b, r6.f15551b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15552c, r6.f15552c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f15550a.hashCode() * 31) + this.f15551b.hashCode()) * 31) + this.f15552c.hashCode();
        }

        public String toString() {
            return "TerminalReport(traceId=" + this.f15550a + ", terminalReason=" + this.f15551b + ", params=" + this.f15552c + ')';
        }

        public f(String r2, String r3, JSONObject r4) {
            d.h.b.o.e(r2, "traceId");
            d.h.b.o.e(r3, "terminalReason");
            d.h.b.o.e(r4, "params");
            this.f15550a = r2;
            this.f15551b = r3;
            this.f15552c = r4;
        }

        public final String a() {
            return this.f15550a;
        }

        public final String b() {
            return this.f15551b;
        }

        public final JSONObject c() {
            return this.f15552c;
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f15553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f15556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15557e;
        private final String f;
        private volatile boolean g;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
            return false;
        L8:
            g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
            if (this.f15553a == r10.f15553a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15554b, r10.f15554b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15555c, r10.f15555c) == true) goto L18;
            return false;
        L18:
            if (this.f15556d == r10.f15556d) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15557e, r10.f15557e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((Long.hashCode(this.f15553a) * 31) + this.f15554b.hashCode()) * 31;
            String r1 = this.f15555c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.f15556d)) * 31;
            String r5 = this.f15557e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((r7 + r2) * 31) + Boolean.hashCode(this.g);
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "TerminatedTraceState(timestampMs=" + this.f15553a + ", terminalReason=" + this.f15554b + ", terminalFrom=" + this.f15555c + ", isValidLatencySample=" + this.f15556d + ", mergedToTraceId=" + this.f15557e + ", interruptedByTraceId=" + this.f + ", terminalReported=" + this.g + ')';
        }

        public g(long r2, String r4, String r5, boolean r6, String r7, String r8, boolean r9) {
            d.h.b.o.e(r4, "terminalReason");
            this.f15553a = r2;
            this.f15554b = r4;
            this.f15555c = r5;
            this.f15556d = r6;
            this.f15557e = r7;
            this.f = r8;
            this.g = r9;
        }

        public final long a() {
            return this.f15553a;
        }

        public final String b() {
            return this.f15554b;
        }

        public final String c() {
            return this.f15555c;
        }

        public final boolean d() {
            return this.f15556d;
        }

        public final String e() {
            return this.f15557e;
        }

        public final String f() {
            return this.f;
        }

        public final void a(boolean r1) {
            this.g = r1;
        }

        public final boolean g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    @d.c.b.a.f(b = "IntentMetricsReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentMetricsReporter$onFirstTokenDisplayed$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15559b;

        h(String r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15559b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f15559b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [T, com.obric.agent.trace.m$f] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f15558a != 0) goto L45;
            d.o.a(r6);
            long r0 = m.a(m.f15526a);
            if (m.a(m.f15526a, this.f15559b, r0) == false) goto L8;
            m.a().remove(this.f15559b);
            ILogDepend.Companion.i(m.TAG, "skip first token for terminal traceId=" + this.f15559b);
            return d.x.f38692a;
        L8:
            c r7 = (c) ZeusTransformUtils.preCheckCast(m.a().get(this.f15559b), c.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L11;
            z.f r2 = new z.f();
            monitor-enter(r7);
            ?? r3 = m.a(m.f15526a, r7, r0, "first_token");     // Catch: Throwable -> L41
            if (r3 == 0) goto L17;
            r2.f38504a = r3;     // Catch: Throwable -> L41
        L17:
            JSONObject r4 = null;
            if (r7.q() == false) goto L21;
        L30:
            monitor-exit(r7);
            if (r4 == null) goto L36;
            String r5 = this.f15559b;
            IAppLog r8 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L35;
            r8.reportToFlow("o_app_intent_first_token", r4);
        L35:
            ILogDepend.Companion.i(m.TAG, "report first token traceId=" + r5 + " params=" + r4);
        L36:
            f r9 = (f) ZeusTransformUtils.preCheckCast(r2.f38504a, f.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L40;
            m.a(m.f15526a, r9);
        L40:
            return d.x.f38692a;
        L21:
            if (r7.o() == true) goto L30;
            if (r7.l().isEmpty() == true) goto L30;
            r7.f(true);     // Catch: Throwable -> L41
            Long r10 = r7.j();     // Catch: Throwable -> L41
            if (r10 != null) goto L29;
            r10 = d.c.b.a.b.a(r0);     // Catch: Throwable -> L41
        L29:
            r7.b(r10);     // Catch: Throwable -> L41
            r7.a(r0);     // Catch: Throwable -> L41
            r4 = m.a(m.f15526a, r7);     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            throw th;
        L11:
            return d.x.f38692a;
        L45:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    @d.c.b.a.f(b = "IntentMetricsReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentMetricsReporter$onIntentCallEnd$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15564e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;
        final /* synthetic */ String i;
        final /* synthetic */ boolean j;
        final /* synthetic */ boolean k;
        final /* synthetic */ Long l;
        final /* synthetic */ Long m;
        final /* synthetic */ Integer n;
        final /* synthetic */ boolean o;

        i(String r5, String r6, String r7, String r8, String r9, boolean r10, boolean r11, String r12, boolean r13, boolean r14, Long r15, Long r16, Integer r17, boolean r18, d.c.d<? super i> r19) {
            d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15561b = r5;
            this.f15562c = r6;
            this.f15563d = r7;
            this.f15564e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r12;
            this.j = r13;
            this.k = r14;
            this.l = r15;
            this.m = r16;
            this.n = r17;
            this.o = r18;
            super(2, r1);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r20, d.c.d<?> r21) {
            d.c.d r18 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f15561b, this.f15562c, this.f15563d, this.f15564e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, r18), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r43) {
            d.c.a.b.a();
            if (this.f15560a != 0) goto L147;
            d.o.a(r43);
            long r14 = m.a(m.f15526a);
            g r6 = m.c(m.f15526a, this.f15561b, r14);
            c r1 = (c) ZeusTransformUtils.preCheckCast(m.a().get(this.f15561b), c.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L17;
            if (r6 == null) goto L17;
            String r2 = this.f15561b;
            String r3 = this.f15562c;
            String r4 = this.f15563d;
            String r5 = this.f15564e;
            String r7 = this.f;
            boolean r8 = this.g;
            boolean r9 = this.h;
            String r10 = this.i;
            boolean r11 = this.j;
            boolean r12 = this.k;
            Long r13 = this.l;
            if (r13 == null) goto L10;
            long r28 = r14 - ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).longValue();
        L11:
            b r15 = new b(r2, r3, r4, r5, null, r7, r8, r9, r10, r11, r12, r28, d.c.b.a.b.a(r14), this.l, this.m, this.n, true, true);
            if (this.o == false) goto L15;
            m.a(m.f15526a, r15);
            m.a(m.f15526a, this.f15561b, r14, r6, d.a.p.a(r15), null, r14, new a(this.i, this.j, this.k), this.g, this.h);
        L15:
            return d.x.f38692a;
        L10:
            r28 = r14;
        L17:
            if (r1 != null) goto L19;
            long r16 = r14;
            r1 = m.b(m.f15526a, this.f15561b, r16);
        L20:
            String r17 = this.f15561b;
            String r18 = this.f15562c;
            String r19 = this.f15563d;
            String r20 = this.f15564e;
            boolean r21 = this.g;
            boolean r22 = this.h;
            String r110 = this.i;
            boolean r111 = this.j;
            boolean r112 = this.k;
            String r113 = this.f;
            boolean r23 = this.o;
            Long r24 = this.l;
            long r36 = r16;
            Long r114 = this.m;
            Integer r0 = this.n;
            monitor-enter(r1);
            b r25 = null;
            if (r1.q() == false) goto L25;
        L24:
            b r26 = r25;
            monitor-exit(r1);
            if (r26 == null) goto L142;
            m.a(m.f15526a, r26);
        L142:
            return d.x.f38692a;
        L25:
            String r115 = m.a(m.f15526a, r17, r18, r19, r20);     // Catch: Throwable -> L143
            if (r1.e() == true) goto L30;
            if (r21 == true) goto L30;
            boolean r27 = false;
        L31:
            r1.b(r27);     // Catch: Throwable -> L143
            if (r1.f() == true) goto L36;
            if (r22 == true) goto L36;
            boolean r29 = false;
        L37:
            r1.c(r29);     // Catch: Throwable -> L143
            m r30 = m.f15526a;     // Catch: Throwable -> L143
            if (r112 == false) goto L40;
            boolean r31 = true;
        L41:
            m.a(r30, r1, r110, r111, r31);     // Catch: Throwable -> L143
            List<b> r32 = r1.l();     // Catch: Throwable -> L143
            ListIterator<b> r33 = r32.listIterator(r32.size());     // Catch: Throwable -> L143
        L43:
            if (r33.hasPrevious() == false) goto L48;
            b r34 = r33.previous();     // Catch: Throwable -> L143
            ListIterator<b> r44 = r33;
            if (d.h.b.o.a(((b) ZeusTransformUtils.preCheckCast(r34, b.class, "com.obric.aiagent.plugin")).r(), r115) == true) goto L49;
            r33 = r44;
        L49:
            b r35 = (b) ZeusTransformUtils.preCheckCast(r34, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r35 != null) goto L106;
            List<b> r37 = r1.l();     // Catch: Throwable -> L143
            ListIterator<b> r38 = r37.listIterator(r37.size());     // Catch: Throwable -> L143
        L53:
            if (r38.hasPrevious() == false) goto L64;
            b r39 = r38.previous();     // Catch: Throwable -> L143
            b r40 = (b) ZeusTransformUtils.preCheckCast(r39, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r20 != null) goto L57;
        L61:
            boolean r41 = false;
        L62:
            if (r41 == false) goto L53;
        L65:
            r35 = (b) ZeusTransformUtils.preCheckCast(r39, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r35 != null) goto L106;
            List<b> r42 = r1.l();     // Catch: Throwable -> L143
            ListIterator<b> r45 = r42.listIterator(r42.size());     // Catch: Throwable -> L143
        L69:
            if (r45.hasPrevious() == false) goto L81;
            b r46 = r45.previous();     // Catch: Throwable -> L143
            b r47 = (b) ZeusTransformUtils.preCheckCast(r46, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r20 != null) goto L78;
            if (r19 == null) goto L78;
            if (d.h.b.o.a(r47.b(), r18) == false) goto L78;
            if (d.h.b.o.a(r47.c(), r19) == false) goto L78;
            boolean r48 = true;
        L79:
            if (r48 == false) goto L69;
        L82:
            r35 = (b) ZeusTransformUtils.preCheckCast(r46, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r35 != null) goto L106;
            List<b> r49 = r1.l();     // Catch: Throwable -> L143
            ListIterator<b> r50 = r49.listIterator(r49.size());     // Catch: Throwable -> L143
        L86:
            if (r50.hasPrevious() == false) goto L98;
            b r51 = r50.previous();     // Catch: Throwable -> L143
            b r52 = (b) ZeusTransformUtils.preCheckCast(r51, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r19 != null) goto L95;
            if (r20 != null) goto L95;
            if (d.h.b.o.a(r52.b(), r18) == false) goto L95;
            if (r52.p() == true) goto L95;
            boolean r53 = true;
        L96:
            if (r53 == false) goto L86;
        L99:
            r35 = (b) ZeusTransformUtils.preCheckCast(r51, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L143
            if (r35 != null) goto L106;
            String r54 = null;
            boolean r116 = r1.e();     // Catch: Throwable -> L143
            boolean r210 = r1.f();     // Catch: Throwable -> L143
            if (r112 == false) goto L104;
            boolean r211 = true;
        L105:
            String r410 = r113;
            r35 = new b(r17, r18, r19, r20, r54, r113, r116, r210, r110, r111, r211, r36, null, null, null, null, false, false, 258048, null);     // Catch: Throwable -> L143
            r1.l().add(r35);     // Catch: Throwable -> L143
            long r55 = r36;
        L107:
            r1.a(r55);     // Catch: Throwable -> L143
            String r56 = r410;
            if (r56 == null) goto L116;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r56, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L112;
            String r117 = r56;
        L113:
            if (r117 == null) goto L116;
            r35.a(r117);     // Catch: Throwable -> L143
            goto L116
        L112:
            r117 = null;
        L116:
            if (r35.f() == false) goto L118;
        L121:
            boolean r57 = true;
        L122:
            r35.a(r57);     // Catch: Throwable -> L143
            if (r35.g() == false) goto L125;
        L128:
            boolean r58 = true;
        L129:
            r35.b(r58);     // Catch: Throwable -> L143
            m r59 = m.f15526a;     // Catch: Throwable -> L143
            if (r112 == false) goto L132;
            boolean r60 = true;
        L133:
            m.a(r59, r35, r110, r111, r60);     // Catch: Throwable -> L143
            if (r23 == false) goto L24;
            r35.a(d.c.b.a.b.a(r55));     // Catch: Throwable -> L143
            r35.b(r24);     // Catch: Throwable -> L143
            r35.c(r114);     // Catch: Throwable -> L143
            r35.a(r0);     // Catch: Throwable -> L143
            r35.e(true);     // Catch: Throwable -> L143
            r35.f(true);     // Catch: Throwable -> L143
            if (r1.n().add(r35.r()) == false) goto L24;
            r25 = r35;
            goto L24
        L132:
            r60 = false;
            goto L133
        L125:
            if (r1.f() == true) goto L128;
            r58 = false;
            goto L129
        L118:
            if (r1.e() == true) goto L121;
            r57 = false;
            goto L122
        L104:
            r211 = false;
        L95:
            r53 = false;
            goto L96
        L98:
            r51 = null;
        L78:
            r48 = false;
            goto L79
        L81:
            r46 = null;
            goto L82
        L57:
            if (d.h.b.o.a(r40.b(), r18) == false) goto L61;
            if (d.h.b.o.a(r40.d(), r20) == false) goto L61;
            r41 = true;
            goto L62
        L64:
            r39 = null;
        L106:
            r410 = r113;
            r55 = r36;
            goto L107
        L48:
            r34 = null;
            goto L49
        L40:
            r31 = false;
        L36:
            r29 = true;
        L30:
            r27 = true;
        L143:
            th = move-exception;
            throw th;
        L19:
            r16 = r14;
            goto L20
        L147:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    @d.c.b.a.f(b = "IntentMetricsReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentMetricsReporter$onIntentCallStart$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f15569e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ String j;
        final /* synthetic */ String k;
        final /* synthetic */ String l;
        final /* synthetic */ Long m;

        j(String r3, String r4, String r5, boolean r6, boolean r7, String r8, boolean r9, boolean r10, String r11, String r12, String r13, Long r14, d.c.d<? super j> r15) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15566b = r3;
            this.f15567c = r4;
            this.f15568d = r5;
            this.f15569e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            super(2, r16);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r18, d.c.d<?> r19) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f15566b, this.f15567c, this.f15568d, this.f15569e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, r16), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r41) {
            d.c.a.b.a();
            if (this.f15565a != 0) goto L91;
            d.o.a(r41);
            long r9 = m.a(m.f15526a);
            g r6 = m.c(m.f15526a, this.f15566b, r9);
            c r1 = (c) ZeusTransformUtils.preCheckCast(m.a().get(this.f15566b), c.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L14;
            if (r6 == null) goto L14;
            m.a(m.f15526a, new e(this.f15566b, this.f15567c, this.f15568d, this.f15569e, this.f, this.g, this.h, this.i, null));
            m r2 = m.f15526a;
            String r3 = this.f15566b;
            String r12 = this.f15566b;
            String r13 = this.f15567c;
            String r14 = this.j;
            String r15 = this.k;
            String r4 = this.f15568d;
            String r5 = this.l;
            boolean r7 = this.f15569e;
            boolean r8 = this.f;
            String r11 = this.g;
            boolean r10 = this.h;
            boolean r16 = this.i;
            Long r17 = this.m;
            if (r17 == null) goto L10;
            long r23 = r17.longValue();
        L11:
            m.a(r2, r3, r9, r6, d.a.p.a(new b(r12, r13, r14, r15, r4, r5, r7, r8, r11, r10, r16, r23, null, null, null, null, false, false, 258048, null)), null, r9, new a(this.g, this.h, this.i), this.f15569e, this.f);
            return d.x.f38692a;
        L10:
            r23 = r9;
        L14:
            if (r1 != null) goto L16;
            long r18 = r9;
            r1 = m.b(m.f15526a, this.f15566b, r18);
        L17:
            String r19 = m.a(m.f15526a, this.f15566b, this.f15567c, this.j, this.k);
            boolean r20 = this.f15569e;
            boolean r21 = this.f;
            String r110 = this.g;
            boolean r111 = this.h;
            boolean r112 = this.i;
            String r22 = this.f15568d;
            String r113 = this.f15566b;
            String r114 = this.f15567c;
            String r115 = this.j;
            String r24 = this.k;
            String r25 = this.l;
            Long r0 = this.m;
            monitor-enter(r1);
            e r29 = null;
            if (r1.q() == false) goto L22;
        L21:
            e r26 = r29;
            monitor-exit(r1);
            if (r26 == null) goto L86;
            m.a(m.f15526a, r26);
        L86:
            return d.x.f38692a;
        L22:
            r1.a(r18);     // Catch: Throwable -> L87
            if (r1.e() == true) goto L27;
            if (r20 == true) goto L27;
            boolean r27 = false;
        L28:
            r1.b(r27);     // Catch: Throwable -> L87
            if (r1.f() == true) goto L33;
            if (r21 == true) goto L33;
            boolean r28 = false;
        L34:
            r1.c(r28);     // Catch: Throwable -> L87
            m r30 = m.f15526a;     // Catch: Throwable -> L87
            if (r112 == false) goto L37;
            boolean r31 = true;
        L38:
            m.a(r30, r1, r110, r111, r31);     // Catch: Throwable -> L87
            String r32 = r1.d();     // Catch: Throwable -> L87
            if (r32 != null) goto L41;
            r32 = r22;
        L41:
            boolean r33 = r1.e();     // Catch: Throwable -> L87
            boolean r34 = r1.f();     // Catch: Throwable -> L87
            long r35 = r18;
            Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast(r1.l(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
            if (ZeusTransformUtils.instanceOf(r36, Collection.class) == true) goto L44;
        L46:
            Iterator r37 = r36.iterator();     // Catch: Throwable -> L87
        L48:
            if (r37.hasNext() == false) goto L53;
            Iterator r40 = r37;
            if (d.h.b.o.a(((b) ZeusTransformUtils.preCheckCast(r37.next(), b.class, "com.obric.aiagent.plugin")).r(), r19) == true) goto L51;
            r37 = r40;
            goto L48
        L51:
            boolean r38 = true;
        L54:
            if (r38 == true) goto L60;
            List<b> r39 = r1.l();     // Catch: Throwable -> L87
            if (r0 == null) goto L58;
            long r116 = r0.longValue();     // Catch: Throwable -> L87
        L59:
            boolean r310 = r112;
            boolean r311 = r111;
            String r312 = r110;
            r39.add(new b(r113, r114, r115, r24, r32, r25, r33, r34, r312, r311, r310, r116, null, null, null, null, false, false, 258048, null));     // Catch: Throwable -> L87
        L62:
            if (r1.m().add(r19) == false) goto L21;
            Long r42 = r1.b();     // Catch: Throwable -> L87
            if (r42 == null) goto L75;
            ((Number) ZeusTransformUtils.preCheckCast(r42, Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L87
            if (r1.c() == true) goto L69;
            r42 = null;
        L69:
            if (r42 == null) goto L75;
            long r43 = ((Number) ZeusTransformUtils.preCheckCast(r42, Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L87
            if (r0 == null) goto L73;
            long r44 = r0.longValue();     // Catch: Throwable -> L87
        L74:
            Long r117 = d.c.b.a.b.a(d.l.n.a(r44 - r43, 0));     // Catch: Throwable -> L87
        L77:
            if (r310 == false) goto L79;
            boolean r118 = true;
        L80:
            r29 = new e(r113, r114, r32, r33, r34, r312, r311, r118, r117);     // Catch: Throwable -> L87
            goto L21
        L79:
            r118 = false;
            goto L80
        L73:
            r44 = r35;
        L75:
            r117 = null;
            goto L77
        L58:
            r116 = r35;
            goto L59
        L60:
            r310 = r112;
            r311 = r111;
            r312 = r110;
        L53:
            r38 = false;
            goto L54
        L44:
            if (((Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L46;
        L37:
            r31 = false;
        L33:
            r28 = true;
        L27:
            r27 = true;
        L87:
            th = move-exception;
            throw th;
        L16:
            r18 = r9;
            goto L17
        L91:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    @d.c.b.a.f(b = "IntentMetricsReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentMetricsReporter$onQueryDisplayed$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f15574e;
        final /* synthetic */ boolean f;

        k(String r3, String r4, String r5, boolean r6, boolean r7, d.c.d<? super k> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15571b = r3;
            this.f15572c = r4;
            this.f15573d = r5;
            this.f15574e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f15571b, this.f15572c, this.f15573d, this.f15574e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f15570a != 0) goto L41;
            d.o.a(r9);
            long r0 = m.a(m.f15526a);
            if (m.a(m.f15526a, this.f15571b, r0) == false) goto L8;
            ILogDepend.Companion.i(m.TAG, "skip query displayed for terminal traceId=" + this.f15571b);
            return d.x.f38692a;
        L8:
            c r10 = m.b(m.f15526a, this.f15571b, r0);
            String r2 = this.f15573d;
            boolean r3 = this.f15574e;
            boolean r4 = this.f;
            monitor-enter(r10);
        L37:
            th = move-exception;
            throw th;
        L11:
            if (r10.b() != null) goto L13;
        L14:
            r10.a(d.c.b.a.b.a(r0));     // Catch: Throwable -> L37
        L15:
            boolean r5 = true;
            r10.a(true);     // Catch: Throwable -> L37
            if (r2 == null) goto L24;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
            r2 = null;
        L21:
            if (r2 == null) goto L24;
            r10.a(r2);     // Catch: Throwable -> L37
        L24:
            if (r10.e() == true) goto L28;
            if (r3 == true) goto L28;
            boolean r6 = false;
        L29:
            r10.b(r6);     // Catch: Throwable -> L37
            if (r4 == true) goto L33;
            r5 = false;
        L33:
            r10.c(r5);     // Catch: Throwable -> L37
            r10.a(r0);     // Catch: Throwable -> L37
            d.x r1 = d.x.f38692a;     // Catch: Throwable -> L37
            monitor-exit(r10);
            ILogDepend.Companion.i(m.TAG, "onQueryDisplayed traceId=" + this.f15571b + " localMessageId=" + this.f15572c + " callScene=" + this.f15573d + " isOmni=" + this.f15574e + " isContinuousTalk=" + this.f);
            return d.x.f38692a;
        L28:
            r6 = true;
            goto L29
        L13:
            if (r10.c() == true) goto L15;
        L41:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    @d.c.b.a.f(b = "IntentMetricsReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentMetricsReporter$onSummaryReplyScreenFinish$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15576b;

        l(String r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15576b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f15576b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [T, com.obric.agent.trace.m$f] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            d.c.a.b.a();
            if (this.f15575a != 0) goto L58;
            d.o.a(r14);
            long r2 = m.a(m.f15526a);
            if (m.a(m.f15526a, this.f15576b, r2) == false) goto L8;
            m.a().remove(this.f15576b);
            ILogDepend.Companion.i(m.TAG, "skip screen finish for terminal traceId=" + this.f15576b);
            return d.x.f38692a;
        L8:
            c r15 = (c) ZeusTransformUtils.preCheckCast(m.a().get(this.f15576b), c.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L11;
            z.f r9 = new z.f();
            String r0 = this.f15576b;
            monitor-enter(r15);
            ?? r1 = m.a(m.f15526a, r15, r2, "screen_finish");     // Catch: Throwable -> L54
            if (r1 == 0) goto L17;
            r9.f38504a = r1;     // Catch: Throwable -> L54
        L17:
            JSONObject r4 = null;
            d r5 = null;
            r5 = null;
            r5 = null;
            if (r15.q() == false) goto L21;
        L34:
            monitor-exit(r15);
            if (r5 == null) goto L49;
            String r13 = this.f15576b;
            JSONObject r16 = r5.a();
            if (r16 == null) goto L42;
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L41;
            r3.reportToFlow("o_app_intent_first_token", r16);
        L41:
            ILogDepend.Companion.i(m.TAG, "report first token fallback traceId=" + r13 + " params=" + r16);
        L42:
            IAppLog r17 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L45;
            r17.reportToFlow("o_app_intent_screen_finish", r5.b());
        L45:
            ILogDepend.Companion.i(m.TAG, "report screen finish traceId=" + r13 + " params=" + r5.b());
            f r18 = r5.c();
            if (r18 == null) goto L48;
            m.a(m.f15526a, r18);
        L48:
            c r19 = (c) ZeusTransformUtils.preCheckCast(m.a().remove(r13), c.class, "com.obric.aiagent.plugin");
        L49:
            f r110 = (f) ZeusTransformUtils.preCheckCast(r9.f38504a, f.class, "com.obric.aiagent.plugin");
            if (r110 == null) goto L53;
            m.a(m.f15526a, r110);
        L53:
            return d.x.f38692a;
        L21:
            if (r15.p() == true) goto L34;
            if (r15.l().isEmpty() == false) goto L27;
            m.a().remove(r0);     // Catch: Throwable -> L54
            goto L34
        L27:
            if (r15.o() == true) goto L32;
            r15.f(true);     // Catch: Throwable -> L54
            Long r6 = r15.j();     // Catch: Throwable -> L54
            if (r6 != null) goto L31;
            r6 = d.c.b.a.b.a(r2);     // Catch: Throwable -> L54
        L31:
            r15.b(r6);     // Catch: Throwable -> L54
            r4 = m.a(m.f15526a, r15);     // Catch: Throwable -> L54
        L32:
            r15.g(true);     // Catch: Throwable -> L54
            r15.c(d.c.b.a.b.a(r2));     // Catch: Throwable -> L54
            r15.a(r2);     // Catch: Throwable -> L54
            r5 = new d(r4, m.b(m.f15526a, r15), m.a(m.f15526a, r15, r2, "server_reply_done", "screen_finish", true, null, null));     // Catch: Throwable -> L54
        L54:
            th = move-exception;
            throw th;
        L11:
            return d.x.f38692a;
        L58:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.trace.m$m, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntentMetricsReporter.kt */
    @d.c.b.a.f(b = "IntentMetricsReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentMetricsReporter$onTraceFinished$1")
    static final class C0317m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f15581e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        private /* synthetic */ Object h;

        C0317m(String r3, String r4, String r5, boolean r6, String r7, String r8, d.c.d<? super C0317m> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15578b = r3;
            this.f15579c = r4;
            this.f15580d = r5;
            this.f15581e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((C0317m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0317m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            C0317m r13 = new C0317m(this.f15578b, this.f15579c, this.f15580d, this.f15581e, this.f, this.g, r9);
            r13.h = r11;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            d.c.a.b.a();
            if (this.f15577a != 0) goto L25;
            d.o.a(r13);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            long r2 = m.a(m.f15526a);
            c r15 = (c) ZeusTransformUtils.preCheckCast(m.a().get(this.f15578b), c.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L7;
            m.a(m.f15526a, r2);
            m.b().putIfAbsent(this.f15578b, new g(r2, this.f15579c, this.f15580d, this.f15581e, this.f, this.g, false));
            f r16 = null;
        L16:
            if (r16 == null) goto L18;
            m.a(m.f15526a, r16);
        L20:
            return d.x.f38692a;
        L18:
            ILogDepend.Companion.i(m.TAG, "trace finished cleanup traceId=" + this.f15578b + " reason=" + this.f15579c + " without active metric");
            goto L20
        L7:
            String r4 = this.f15579c;
            String r5 = this.f15580d;
            boolean r0 = this.f15581e;
            String r7 = this.f;
            String r8 = this.g;
            String r9 = this.f15578b;
            monitor-enter(r15);
            m r1 = m.f15526a;     // Catch: Throwable -> L21
            if (r0 == false) goto L12;
            boolean r3 = true;
        L13:
            f r6 = m.a(r1, r15, r2, r4, r5, r3, r7, r8);     // Catch: Throwable -> L21
            m.a().remove(r9, r15);     // Catch: Throwable -> L21
            monitor-exit(r15);
            r16 = r6;
            goto L16
        L12:
            r3 = false;
        L21:
            th = move-exception;
            throw th;
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: lambda$EhA8ulLj-T5ZPc6BMB841joS_p4, reason: not valid java name */
    public static /* synthetic */ boolean m105lambda$EhA8ulLjT5ZPc6BMB841joS_p4(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$TH3yTAt2eqFEaRCrS_aSNV6PBIc(long r0, Map.Entry r2) {
        return a(r0, r2);
    }

    private m() {
    }

    public static final /* synthetic */ long a(m r2) {
        return r2.c();
    }

    public static final /* synthetic */ f a(m r0, c r1, long r2, String r4) {
        return r0.a(r1, r2, r4);
    }

    public static final /* synthetic */ f a(m r0, c r1, long r2, String r4, String r5, boolean r6, String r7, String r8) {
        return r0.a(r1, r2, r4, r5, r6, r7, r8);
    }

    public static final /* synthetic */ String a(m r0, String r1, String r2, String r3, String r4) {
        return r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f15527b;
    }

    public static final /* synthetic */ JSONObject a(m r0, c r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ void a(m r0, long r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(m r0, b r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(m r0, b r1, String r2, boolean r3, boolean r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(m r0, c r1, String r2, boolean r3, boolean r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(m r0, e r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(m r0, f r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(m r13, String r14, long r15, g r17, List r18, Long r19, long r20, a r22, boolean r23, boolean r24) {
        r13.a(r14, r15, r17, (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin"), r19, r20, r22, r23, r24);
    }

    public static final /* synthetic */ boolean a(m r0, String r1, long r2) {
        return r0.b(r1, r2);
    }

    public static final /* synthetic */ c b(m r0, String r1, long r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f15528c;
    }

    public static final /* synthetic */ JSONObject b(m r0, c r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ g c(m r0, String r1, long r2) {
        return r0.c(r1, r2);
    }

    static {
        f15526a = new m();
        f15527b = new ConcurrentHashMap();
        f15528c = new ConcurrentHashMap();
    }

    public final void a(com.obric.agent.trace.k r18) {
        d.h.b.o.e(r18, "event");
        if (ZeusTransformUtils.instanceOf(r18, com.obric.agent.trace.k.d.class) == false) goto L6;
        a(((com.obric.agent.trace.k.d) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.d.class, "com.obric.aiagent.plugin")).a(), ((com.obric.agent.trace.k.d) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.d.class, "com.obric.aiagent.plugin")).b(), ((com.obric.agent.trace.k.d) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.d.class, "com.obric.aiagent.plugin")).c(), ((com.obric.agent.trace.k.d) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.d.class, "com.obric.aiagent.plugin")).d(), ((com.obric.agent.trace.k.d) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.d.class, "com.obric.aiagent.plugin")).e());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.agent.trace.k.c.class) == false) goto L9;
        a(((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).a(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).b(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).c(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).d(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).e(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).f(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).g(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).h(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).i(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).j(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).k(), ((com.obric.agent.trace.k.c) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.c.class, "com.obric.aiagent.plugin")).l());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.agent.trace.k.b.class) == false) goto L12;
        a(((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).a(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).b(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).c(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).d(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).e(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).f(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).g(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).h(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).i(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).j(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).k(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).l(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).m(), ((com.obric.agent.trace.k.b) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.b.class, "com.obric.aiagent.plugin")).n());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.agent.trace.k.a.class) == false) goto L15;
        a(((com.obric.agent.trace.k.a) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.a.class, "com.obric.aiagent.plugin")).a());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.agent.trace.k.e.class) == false) goto L18;
        b(((com.obric.agent.trace.k.e) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.e.class, "com.obric.aiagent.plugin")).a());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.agent.trace.k.f.class) == false) goto L22;
        a(((com.obric.agent.trace.k.f) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.f.class, "com.obric.aiagent.plugin")).a(), ((com.obric.agent.trace.k.f) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.f.class, "com.obric.aiagent.plugin")).b(), ((com.obric.agent.trace.k.f) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.f.class, "com.obric.aiagent.plugin")).c(), ((com.obric.agent.trace.k.f) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.f.class, "com.obric.aiagent.plugin")).d(), ((com.obric.agent.trace.k.f) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.f.class, "com.obric.aiagent.plugin")).e(), ((com.obric.agent.trace.k.f) ZeusTransformUtils.preCheckCast(r18, com.obric.agent.trace.k.f.class, "com.obric.aiagent.plugin")).f());
        return;
    L22:
        throw new d.k();
    }

    private final void a(String r13, String r14, String r15, boolean r16, boolean r17) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r13, r14, r15, r16, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(String r20, String r21, String r22, String r23, String r24, String r25, Long r26, boolean r27, boolean r28, String r29, boolean r30, boolean r31) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L10;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r20, r21, r24, r27, r28, r29, r30, r31, r22, r23, r25, r26, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    }

    private final void a(String r21, String r22, String r23, String r24, String r25, Integer r26, boolean r27, Long r28, Long r29, boolean r30, boolean r31, String r32, boolean r33, boolean r34) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L10;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r21, r22, r23, r24, r25, r30, r31, r32, r33, r34, r28, r29, r26, r27, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    }

    private final void a(String r8) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void b(String r8) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(String r14, String r15, String r16, boolean r17, String r18, String r19) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0317m(r14, r15, r16, r17, r18, r19, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final c a(String r26, long r27) {
        ConcurrentMap r14 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f15527b, ConcurrentMap.class, "com.obric.aiagent.plugin");
        Object r0 = r14.get(r26);
        if (r0 != null) goto L7;
        Set r16 = null;
        boolean r17 = false;
        String r24 = "com.obric.aiagent.plugin";
        c r13 = new c(r26, Long.valueOf(r27), false, null, false, false, null, false, false, null, null, null, r16, r16, r17, r17, false, 0, 262140, null);
        r0 = r14.putIfAbsent(r26, r13);
        if (r0 != null) goto L8;
        r0 = r13;
    L8:
        d.h.b.o.c(r0, "getOrPut(...)");
        return (c) ZeusTransformUtils.preCheckCast(r0, c.class, r24);
    L7:
        r24 = "com.obric.aiagent.plugin";
        goto L8
    }

    private final f a(c r25, long r26, String r28, String r29, boolean r30, String r31, String r32) {
        String r10 = r29;
        if (r25.q() == false) goto L5;
        return null;
    L5:
        List r15 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r25.l(), Iterable.class, "com.obric.aiagent.plugin"));
        boolean r8 = !((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty();
        r25.h(r8);
        ((Map) ZeusTransformUtils.preCheckCast(f15528c, Map.class, "com.obric.aiagent.plugin")).put(r25.a(), new g(r26, r28, r29, r30, r31, r32, r8));
        if (r15.isEmpty() == false) goto L9;
        return null;
    L9:
        String r0 = null;
        a r1 = a(r25);
        Long r2 = r25.b();
        if (r2 == null) goto L12;
    L11:
        long r3 = r2.longValue();
    L25:
        JSONObject r4 = new JSONObject();
        r4.put("traceid", r25.a());
        r4.put("trace_terminal_reason", r28);
        r4.put("is_valid_latency_sample", r30 ? 1 : 0);
        r4.put("intent_count", r15.size());
        m r5 = f15526a;
        r5.b(r4, r25.e());
        r5.a(r4, r25.f());
        r5.a(r4, r1.a(), r1.b(), r1.c());
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r6.iterator();
    L27:
        if (r9.hasNext() == false) goto L29;
        r7.add(((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.aiagent.plugin")).b());
        goto L27
    L29:
        r4.put(Ext.KEY_INTENT_NAME, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        r4.put("duration_since_query_ms", d.l.n.a(r26 - r3, 0));
        if (r10 != null) goto L32;
    L37:
        String r11 = r31;
        if (r11 == null) goto L46;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L43;
        r11 = null;
    L43:
        if (r11 == null) goto L46;
        r4.put("merged_to_traceid", r11);
    L46:
        if (r32 == null) goto L53;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r32, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L50;
        r0 = r32;
    L50:
        if (r0 == null) goto L53;
        r4.put("interrupted_by_traceid", r0);
    L53:
        return new f(r25.a(), r28, r4);
    L32:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L35;
        r10 = null;
    L35:
        if (r10 == null) goto L37;
        r4.put("terminal_from", r10);
        goto L37
    L12:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r12.hasNext() == true) goto L15;
        Comparable r13 = null;
    L21:
        r2 = (Long) ZeusTransformUtils.preCheckCast(r13, Long.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        r3 = r25.r();
        goto L25
    L15:
        r13 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r12.next(), b.class, "com.obric.aiagent.plugin")).k()), Comparable.class, "com.obric.aiagent.plugin");
    L17:
        if (r12.hasNext() == false) goto L21;
        Comparable r14 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r12.next(), b.class, "com.obric.aiagent.plugin")).k()), Comparable.class, "com.obric.aiagent.plugin");
        if (r13.compareTo(r14) <= 0) goto L17;
        r13 = r14;
        goto L17
    }

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
    private final void a(String r19, long r20, g r22, List<b> r23, Long r24, long r25, a r27, boolean r28, boolean r29) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        if (r22.g() == false) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L72;
        monitor-enter(r22);
    L60:
        th = move-exception;
        throw th;
    L9:
        if (r22.g() == false) goto L13;
        monitor-exit(r22);
        return;
    L13:
        r22.a(true);     // Catch: Throwable -> L60
        d.x r4 = d.x.f38692a;     // Catch: Throwable -> L60
        monitor-exit(r22);
        String r5 = null;
        if (r24 == null) goto L18;
        long r6 = r24.longValue();
    L31:
        JSONObject r7 = new JSONObject();
        r7.put("traceid", r19);
        r7.put("trace_terminal_reason", r22.b());
        r7.put("is_valid_latency_sample", r22.d() ? 1 : 0);
        r7.put("intent_count", r2.size());
        m r8 = f15526a;
        r8.b(r7, r28);
        r8.a(r7, r29);
        r8.a(r7, r27.a(), r27.b(), r27.c());
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r3.iterator();
    L33:
        if (r10.hasNext() == false) goto L35;
        r9.add(((b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.aiagent.plugin")).b());
        goto L33
    L35:
        r7.put(Ext.KEY_INTENT_NAME, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        r7.put("duration_since_query_ms", d.l.n.a(r20 - r6, 0));
        String r11 = r22.c();
        if (r11 != null) goto L38;
    L43:
        String r12 = r22.e();
        if (r12 != null) goto L46;
    L51:
        String r13 = r22.f();
        if (r13 != null) goto L54;
    L58:
        a(new f(r19, r22.b(), r7));
        return;
    L54:
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L56;
        r5 = r13;
    L56:
        if (r5 == null) goto L58;
        r7.put("interrupted_by_traceid", r5);
        goto L58
    L46:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L49;
        r12 = null;
    L49:
        if (r12 == null) goto L51;
        r7.put("merged_to_traceid", r12);
        goto L51
    L38:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L41;
        r11 = null;
    L41:
        if (r11 == null) goto L43;
        r7.put("terminal_from", r11);
        goto L43
    L18:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r14.hasNext() == true) goto L21;
        Comparable r15 = null;
    L27:
        Long r16 = (Long) ZeusTransformUtils.preCheckCast(r15, Long.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L30;
        r6 = r16.longValue();
        goto L31
    L30:
        r6 = r25;
        goto L31
    L21:
        r15 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r14.next(), b.class, "com.obric.aiagent.plugin")).k()), Comparable.class, "com.obric.aiagent.plugin");
    L23:
        if (r14.hasNext() == false) goto L27;
        Comparable r17 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r14.next(), b.class, "com.obric.aiagent.plugin")).k()), Comparable.class, "com.obric.aiagent.plugin");
        if (r15.compareTo(r17) <= 0) goto L23;
        r15 = r17;
        goto L23
    }

    private final void a(f r3) {
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        r2.reportToFlow("o_app_intent_trace_terminal", r3.c());
    L5:
        ILogDepend.Companion.i(TAG, "report trace terminal traceId=" + r3.a() + " reason=" + r3.b() + " params=" + r3.c());
    }

    private final boolean b(String r1, long r2) {
        if (c(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final g c(String r1, long r2) {
        a(r2);
        return (g) ZeusTransformUtils.preCheckCast(f15528c.get(r1), g.class, "com.obric.aiagent.plugin");
    }

    private final void a(final long r2) {
        Set<Map.Entry<String, g>> r1 = f15528c.entrySet();
        final d.h.a.b r0 = new $$Lambda$m$TH3yTAt2eqFEaRCrS_aSNV6PBIc(r2);
        r1.removeIf(new $$Lambda$m$EhA8ulLjT5ZPc6BMB841joS_p4(r0));
    }

    private static final boolean a(long r2, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "it");
        if ((r2 - ((g) ZeusTransformUtils.preCheckCast(r5.getValue(), g.class, "com.obric.aiagent.plugin")).a()) <= 600000) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final void a(c r3, String r4, boolean r5, boolean r6) {
        boolean r2 = true;
        if (r4 == null) goto L17;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L17;
        String r0 = r3.g();
        if (r0 != null) goto L12;
    L15:
        r3.b(r4);
        goto L17
    L12:
        if (d.h.b.o.a(r0, r4) == true) goto L15;
        r4 = "mixed_action";
    L17:
        if (r3.h() == true) goto L21;
        if (r5 == true) goto L21;
        boolean r7 = false;
    L22:
        r3.d(r7);
        if (r3.i() == true) goto L27;
        if (r6 == true) goto L27;
        r2 = false;
    L27:
        r3.e(r2);
        return;
    L21:
        r7 = true;
        goto L22
    }

    private final void a(b r3, String r4, boolean r5, boolean r6) {
        boolean r2 = true;
        if (r4 == null) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        r3.b(r4);
    L11:
        if (r3.i() == true) goto L15;
        if (r5 == true) goto L15;
        boolean r7 = false;
    L16:
        r3.c(r7);
        if (r3.j() == true) goto L21;
        if (r6 == true) goto L21;
        r2 = false;
    L21:
        r3.d(r2);
        return;
    L15:
        r7 = true;
        goto L16
    }

    private final f a(c r14, long r15, String r17) {
        Long r0 = r14.b();
        if (r0 == null) goto L9;
        long r2 = r15 - r0.longValue();
        if (r2 > 600000) goto L7;
        return null;
    L7:
        f r1 = a(r14, r15, "timeout_cleanup", r17, false, null, null);
        f15527b.remove(r14.a(), r14);
        ILogDepend.Companion.i(TAG, "drop stale reply metric stage=" + r17 + " traceId=" + r14.a() + " ageMs=" + r2 + " maxAgeMs=600000 intentCount=" + r14.l().size());
        return r1;
    L9:
        return null;
    }

    private final a a(c r8) {
        List r7 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r8.l(), Iterable.class, "com.obric.aiagent.plugin"));
        if (r7.isEmpty() == true) goto L5;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L7:
        boolean r4 = true;
        if (r1.hasNext() == false) goto L17;
        String r3 = ((b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin")).h();
        if (r3 != null) goto L12;
    L14:
        r3 = null;
    L15:
        if (r3 == null) goto L7;
        r2.add(r3);
        goto L7
    L12:
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
    L17:
        List r5 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if (r5.isEmpty() == false) goto L21;
        String r9 = r8.g();
    L24:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L27;
    L29:
        Iterator r10 = r6.iterator();
    L31:
        if (r10.hasNext() == false) goto L28;
        if (((b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.aiagent.plugin")).i() == true) goto L31;
        boolean r11 = false;
    L35:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L38;
    L40:
        Iterator r13 = r12.iterator();
    L42:
        if (r13.hasNext() == false) goto L47;
        if (((b) ZeusTransformUtils.preCheckCast(r13.next(), b.class, "com.obric.aiagent.plugin")).j() == true) goto L42;
        r4 = false;
    L47:
        return new a(r9, r11, r4);
    L38:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L40;
    L28:
        r11 = true;
        goto L35
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L29;
    L21:
        if (r5.size() != 1) goto L23;
        r9 = (String) ZeusTransformUtils.preCheckCast(d.a.p.k(r5), String.class, "com.obric.aiagent.plugin");
        goto L24
    L23:
        r9 = "mixed_action";
        goto L24
    L5:
        return new a(r8.g(), r8.h(), r8.i());
    }

    private final void a(e r9) {
        JSONObject r0 = new JSONObject();
        r0.put("traceid", r9.a());
        r0.put(Ext.KEY_INTENT_NAME, r9.b());
        b(r0, r9.d());
        a(r0, r9.e());
        a(r0, r9.f(), r9.g(), r9.h());
        String r8 = r9.c();
        Long r1 = null;
        boolean r2 = true;
        if (r8 != null) goto L5;
    L10:
        Long r10 = r9.i();
        if (r10 != null) goto L13;
    L20:
        IAppLog r11 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L23;
        r11.reportToFlow("o_app_intent_call_start", r0);
    L23:
        ILogDepend.Companion.i(TAG, "report call start traceId=" + r9.a() + " intentName=" + r9.b() + " callScene=" + r9.c() + " isOmni=" + r9.d() + " isContinuousTalk=" + r9.e() + " queryToCallStartCostMs=" + r9.i());
        return;
    L13:
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).longValue() >= 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r1 = r10;
    L18:
        if (r1 == null) goto L20;
        r0.put("query_to_call_start_cost", ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue());
        goto L20
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L10;
        r0.put("call_scene", r8);
        goto L10
    }

    private final void a(b r12) {
        JSONObject r0 = new JSONObject();
        Integer r1 = r12.o();
        r0.put("traceid", r12.a());
        r0.put(Ext.KEY_INTENT_NAME, r12.b());
        b(r0, r12.f());
        a(r0, r12.g());
        a(r0, r12.h(), r12.i(), r12.j());
        boolean r3 = false;
        if (r12.q() == false) goto L9;
        if (r1 == null) goto L9;
        if (r1.intValue() != 0) goto L9;
        boolean r2 = true;
    L10:
        r0.put("is_execute_success", r2);
        Long r4 = r12.m();
        if (r4 == null) goto L13;
        long r5 = r4.longValue();
    L14:
        r0.put("execute_cost", d.l.n.a(r5, 0));
        if (r1 == null) goto L17;
        int r11 = r1.intValue();
    L18:
        r0.put(FontsContractCompat.Columns.RESULT_CODE, r11);
        String r13 = r12.e();
        Long r6 = null;
        if (r13 != null) goto L21;
    L26:
        if (r1 == null) goto L28;
        r0.put("app_result_code", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue()));
    L28:
        Long r14 = r12.n();
        if (r14 != null) goto L31;
    L37:
        IAppLog r15 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L40;
        r15.reportToFlow("o_app_intent_call_finish", r0);
    L40:
        ILogDepend.Companion.i(TAG, "report call finish traceId=" + r12.a() + " intent=" + r12.b() + " params=" + r0);
        return;
    L31:
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L33;
        r3 = true;
    L33:
        if (r3 == false) goto L35;
        r6 = r14;
    L35:
        if (r6 == null) goto L37;
        r0.put("app_execute_cost", ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue());
        goto L37
    L21:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L24;
        r13 = null;
    L24:
        if (r13 == null) goto L26;
        r0.put("called_app", r13);
        goto L26
    L17:
        r11 = -1;
        goto L18
    L13:
        r5 = a(r12.k(), r12.l());
    L9:
        r2 = false;
        goto L10
    }

    private final JSONObject b(c r19) {
        List r0 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r19.l(), Iterable.class, "com.obric.aiagent.plugin"));
        a r1 = a(r19);
        Long r3 = r19.b();
        if (r3 == null) goto L5;
    L4:
        long r4 = r3.longValue();
    L19:
        Long r5 = r19.j();
        if (r5 == null) goto L22;
        long r6 = r5.longValue();
    L23:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L25:
        if (r9.hasNext() == false) goto L29;
        Long r10 = ((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.aiagent.plugin")).l();
        if (r10 == null) goto L25;
        r8.add(r10);
        goto L25
    L29:
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(d.a.p.v((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Long.class, "com.obric.aiagent.plugin");
        JSONObject r12 = new JSONObject();
        r12.put("traceid", r19.a());
        r12.put("intent_count", r0.size());
        m r13 = f15526a;
        r13.b(r12, r19.e());
        r13.a(r12, r19.f());
        r13.a(r12, r1.a(), r1.b(), r1.c());
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r2.iterator();
    L31:
        if (r15.hasNext() == false) goto L33;
        r14.add(((b) ZeusTransformUtils.preCheckCast(r15.next(), b.class, "com.obric.aiagent.plugin")).b());
        goto L31
    L33:
        r12.put(Ext.KEY_INTENT_NAME, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        r12.put("query_to_first_token_cost", d.l.n.a(r6 - r4, 0));
        if (r11 == null) goto L36;
        r12.put("intent_finish_to_first_token_cost", d.l.n.a(r6 - ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).longValue(), 0));
    L36:
        return r12;
    L22:
        r6 = c();
        goto L23
    L5:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r16.hasNext() == true) goto L8;
        Comparable r17 = null;
    L15:
        r3 = (Long) ZeusTransformUtils.preCheckCast(r17, Long.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L4;
        r4 = r19.r();
        goto L19
    L8:
        Comparable r18 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.aiagent.plugin")).k()), Comparable.class, "com.obric.aiagent.plugin");
    L10:
        if (r16.hasNext() == false) goto L14;
        Comparable r20 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.aiagent.plugin")).k()), Comparable.class, "com.obric.aiagent.plugin");
        if (r18.compareTo(r20) <= 0) goto L10;
        r18 = r20;
        goto L10
    L14:
        r17 = r18;
        goto L15
    }

    private final JSONObject c(c r20) {
        a r0 = a(r20);
        Long r1 = r20.b();
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        Long r3 = r20.j();
        if (r3 == null) goto L9;
    L8:
        long r4 = r3.longValue();
    L13:
        Long r5 = r20.k();
        if (r5 == null) goto L16;
        long r6 = r5.longValue();
    L17:
        JSONObject r7 = new JSONObject();
        r7.put("traceid", r20.a());
        m r8 = f15526a;
        r8.b(r7, r20.e());
        r8.a(r7, r20.f());
        r8.a(r7, r0.a(), r0.b(), r0.c());
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r20.l(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        r10.add(((b) ZeusTransformUtils.preCheckCast(r11.next(), b.class, "com.obric.aiagent.plugin")).b());
        goto L19
    L21:
        r7.put(Ext.KEY_INTENT_NAME, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        r7.put("screen_render_cost", d.l.n.a(r6 - r4, 0));
        r7.put("query_to_finish_cost", d.l.n.a(r6 - r2, 0));
        return r7;
    L16:
        r6 = c();
        goto L17
    L9:
        r3 = r20.k();
        if (r3 != null) goto L8;
        r4 = c();
        goto L13
    L5:
        r2 = r20.r();
        goto L6
    }

    private final String a(String r10, String r11, String r12, String r13) {
        String[] r9 = new String[4];
        r9[0] = r10;
        r9[1] = r11;
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        r9[2] = r12;
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        r9[3] = r13;
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(r9), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("#", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    private final long a(long r3, Long r5) {
        if (r5 == null) goto L4;
        long r0 = r5.longValue();
    L6:
        return d.l.n.a(r0 - r3, 0);
    L4:
        r0 = r3;
        goto L6
    }

    private final long c() {
        return SystemClock.elapsedRealtime();
    }

    private final void a(JSONObject r1, boolean r2) {
        r1.put("is_obric_continuous_talk", r2 ? 1 : 0);
    }

    private final void b(JSONObject r1, boolean r2) {
        r1.put("is_omni", r2 ? 1 : 0);
    }

    private final void a(JSONObject r2, String r3, boolean r4, boolean r5) {
        if (r3 != null) goto L4;
    L9:
        r2.put("is_local_intent", r4 ? 1 : 0);
        r2.put("no_reply_expected", r5 ? 1 : 0);
        return;
    L4:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r3 = null;
    L7:
        if (r3 == null) goto L9;
        r2.put("dispatch_source", r3);
        goto L9
    }
}
