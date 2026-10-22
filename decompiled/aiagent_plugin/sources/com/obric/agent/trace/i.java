package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IntentExecutionReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DownloadConstants.QUERY_KEY)
    private final String f15496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("rewrite_query")
    private final String f15497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("finish_time")
    private final String f15498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("result")
    private final f f15499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("total_cost")
    private final long f15500e;

    @SerializedName("states")
    private final List<o> f;

    @SerializedName("state_report")
    private final List<u> g;

    @SerializedName("task_state_report")
    private final w h;

    @SerializedName("query_type")
    private final String i;

    @SerializedName("log_id")
    private final String j;

    @SerializedName("query_id")
    private final String k;

    @SerializedName("msg_id")
    private final String l;

    @SerializedName(KnowledgeActivity.KEY_TASK_TYPE)
    private final String m;

    public static /* synthetic */ i a(i r15, String r16, String r17, String r18, f r19, long r20, List r22, List r23, w r24, String r25, String r26, String r27, String r28, String r29, int r30, Object r31) {
        List<o> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List<u> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        if ((r30 & 1) == 0) goto L5;
        String r4 = r15.f15496a;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r5 = r15.f15497b;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r6 = r15.f15498c;
    L15:
        if ((r30 & 8) == 0) goto L17;
        f r7 = r15.f15499d;
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r8 = r15.f15500e;
    L23:
        if ((r30 & 32) == 0) goto L26;
        r2 = r15.f;
    L26:
        if ((r30 & 64) == 0) goto L29;
        r3 = r15.g;
    L29:
        if ((r30 & 128) == 0) goto L31;
        w r10 = r15.h;
    L33:
        if ((r30 & 256) == 0) goto L35;
        String r11 = r15.i;
    L37:
        if ((r30 & 512) == 0) goto L39;
        String r12 = r15.j;
    L41:
        if ((r30 & 1024) == 0) goto L43;
        String r13 = r15.k;
    L45:
        if ((r30 & 2048) == 0) goto L47;
        String r14 = r15.l;
    L49:
        if ((r30 & 4096) == 0) goto L51;
        String r1 = r15.m;
    L53:
        return r15.a(r4, r5, r6, r7, r8, r2, r3, r10, r11, r12, r13, r14, r1);
    L51:
        r1 = r29;
        goto L53
    L47:
        r14 = r28;
        goto L49
    L43:
        r13 = r27;
        goto L45
    L39:
        r12 = r26;
        goto L41
    L35:
        r11 = r25;
        goto L37
    L31:
        r10 = r24;
        goto L33
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public final i a(String r18, String r19, String r20, f r21, long r22, List<? extends o> r24, List<u> r25, w r26, String r27, String r28, String r29, String r30, String r31) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r18, DownloadConstants.QUERY_KEY);
        d.h.b.o.e(r9, "states");
        return new i(r18, r19, r20, r21, r22, r9, r10, r26, r27, r28, r29, r30, r31);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15496a, r10.f15496a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15497b, r10.f15497b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15498c, r10.f15498c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15499d, r10.f15499d) == true) goto L21;
        return false;
    L21:
        if (this.f15500e == r10.f15500e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r10.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = this.f15496a.hashCode() * 31;
        String r1 = this.f15497b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f15498c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        f r8 = this.f15499d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + Long.hashCode(this.f15500e)) * 31) + this.f.hashCode()) * 31;
        List<u> r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        w r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.k;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.l;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.m;
        if (r29 == null) goto L43;
        r2 = r29.hashCode();
    L43:
        return r28 + r2;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
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
        r0.append("IntentExecutionReport(query=").append(this.f15496a).append(", rewriteQuery=").append(this.f15497b).append(", finishTime=").append(this.f15498c).append(", result=").append(this.f15499d).append(", totalCost=").append(this.f15500e).append(", states=").append(this.f).append(", stateReports=").append(this.g).append(", taskStateReports=").append(this.h).append(", queryType=").append(this.i).append(", logId=").append(this.j).append(", localMsgId=").append(this.k).append(", msgId=");
        r0.append(this.l).append(", taskType=").append(this.m).append(')');
        return r0.toString();
    }

    public i(String r7, String r8, String r9, f r10, long r11, List<? extends o> r13, List<u> r14, w r15, String r16, String r17, String r18, String r19, String r20) {
        List<o> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List<u> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, DownloadConstants.QUERY_KEY);
        d.h.b.o.e(r2, "states");
        this.f15496a = r7;
        this.f15497b = r8;
        this.f15498c = r9;
        this.f15499d = r10;
        this.f15500e = r11;
        this.f = r2;
        this.g = r3;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
    }

    public /* synthetic */ i(String r15, String r16, String r17, f r18, long r19, List r21, List r22, w r23, String r24, String r25, String r26, String r27, String r28, int r29, d.h.b.h r30) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if ((r29 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r29 & 4) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r29 & 8) == 0) goto L13;
        f r6 = null;
    L15:
        if ((r29 & 16) == 0) goto L17;
        long r7 = 0;
    L19:
        if ((r29 & 128) == 0) goto L21;
        w r9 = null;
    L23:
        if ((r29 & 256) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r29 & 512) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r29 & 1024) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r29 & 2048) == 0) goto L37;
        String r13 = null;
    L39:
        if ((r29 & 4096) != 0) goto L42;
        r4 = r28;
    L42:
        this(r15, r3, r5, r6, r7, r1, r2, r9, r10, r11, r12, r13, r4);
        return;
    L37:
        r13 = r27;
        goto L39
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r3 = r16;
        goto L7
    }

    public final String a() {
        return this.f15496a;
    }

    public final String b() {
        return this.f15497b;
    }

    public final String c() {
        return this.f15498c;
    }

    public final f d() {
        return this.f15499d;
    }

    public final long e() {
        return this.f15500e;
    }

    public final List<o> f() {
        return this.f;
    }

    public final List<u> g() {
        return this.g;
    }

    public final w h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final u a(o r5) {
        d.h.b.o.e(r5, "state");
        List<u> r4 = this.g;
        Object r0 = null;
        if (r4 == null) goto L20;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        if (((u) ZeusTransformUtils.preCheckCast(r1, u.class, "com.obric.aiagent.plugin")).a() != r5) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L6;
        r0 = r1;
        goto L14
    L10:
        r3 = false;
    L14:
        return (u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin");
    L20:
        return null;
    }
}
