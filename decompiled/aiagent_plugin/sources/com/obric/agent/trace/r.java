package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: OmniTaskReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    @SerializedName("last_error_code")
    private final String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("instruction_id")
    private final String f15852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("instruction_type")
    private final String f15853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("instruction_entry")
    private final String f15854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("all_duration")
    private final long f15855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("all_duration_exclude_wait_queue")
    private final long f15856e;

    @SerializedName("wait_queue_duration")
    private final long f;

    @SerializedName("prepare_duration")
    private final long g;

    @SerializedName("prepare_server_duration")
    private final long h;

    @SerializedName("prepare_client_duration")
    private final long i;

    @SerializedName("gui_exec_all_duration")
    private final long j;

    @SerializedName("memory_exec_all_duration")
    private final long k;

    @SerializedName("tool_exec_stage_duration")
    private final long l;

    @SerializedName("client_tool_duration")
    private final long m;

    @SerializedName("tool_all_exec_duration")
    private final long n;

    @SerializedName("tool_count")
    private final int o;

    @SerializedName("server_tool_count")
    private final int p;

    @SerializedName("server_tool_duration")
    private final long q;

    @SerializedName("last_tool_name")
    private final String r;

    @SerializedName("last_tool_args")
    private final String s;

    @SerializedName("last_tool_duration")
    private final long t;

    @SerializedName("last_tool_id")
    private final String u;

    @SerializedName("error_code")
    private final String v;

    @SerializedName("finish_reason")
    private final String w;

    @SerializedName("tool_list")
    private final List<x> x;

    @SerializedName("clarify_list")
    private final List<b> y;

    @SerializedName("call_user_list")
    private final List<a> z;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, r.class) == true) goto L8;
        return false;
    L8:
        r r10 = (r) ZeusTransformUtils.preCheckCast(r9, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15852a, r10.f15852a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15853b, r10.f15853b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15854c, r10.f15854c) == true) goto L18;
        return false;
    L18:
        if (this.f15855d == r10.f15855d) goto L21;
        return false;
    L21:
        if (this.f15856e == r10.f15856e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
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
        if (this.m == r10.m) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (d.h.b.o.a(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (d.h.b.o.a(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r10.t) goto L69;
        return false;
    L69:
        if (d.h.b.o.a(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (d.h.b.o.a(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (d.h.b.o.a(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (d.h.b.o.a(this.x, r10.x) == true) goto L81;
        return false;
    L81:
        if (d.h.b.o.a(this.y, r10.y) == true) goto L84;
        return false;
    L84:
        if (d.h.b.o.a(this.z, r10.z) == true) goto L87;
        return false;
    L87:
        if (d.h.b.o.a(this.A, r10.A) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        String r0 = this.f15852a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f15853b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f15854c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((((((((((((((((((((((((((((((((((((((((((((r6 + r8) * 31) + Long.hashCode(this.f15855d)) * 31) + Long.hashCode(this.f15856e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Long.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + Integer.hashCode(this.o)) * 31) + Integer.hashCode(this.p)) * 31) + Long.hashCode(this.q)) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + Long.hashCode(this.t)) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31;
        String r10 = this.A;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("OmniTaskReport(instructionId=").append(this.f15852a).append(", instructionType=").append(this.f15853b).append(", instructionEntry=").append(this.f15854c).append(", allDuration=").append(this.f15855d).append(", allDurationExcludeWaitQueue=").append(this.f15856e).append(", waitQueueDuration=").append(this.f).append(", prepareDuration=").append(this.g).append(", prepareServerDuration=").append(this.h).append(", prepareClientDuration=").append(this.i).append(", guiExecAllDuration=").append(this.j).append(", memoryExecAllDuration=").append(this.k).append(", toolExecStageDuration=");
        r0.append(this.l).append(", clientToolDuration=").append(this.m).append(", toolAllExecDuration=").append(this.n).append(", toolCount=").append(this.o).append(", serverToolCount=").append(this.p).append(", serverToolDuration=").append(this.q).append(", lastToolName=").append(this.r).append(", lastToolArgs=").append(this.s).append(", lastToolDuration=").append(this.t).append(", lastToolId=").append(this.u).append(", errorCode=").append(this.v).append(", finishReason=").append(this.w);
        r0.append(", toolList=").append(this.x).append(", clarifyList=").append(this.y).append(", callUserList=").append(this.z).append(", lastErrorCode=").append(this.A).append(')');
        return r0.toString();
    }

    public r(String r12, String r13, String r14, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, int r37, int r38, long r39, String r41, String r42, long r43, String r45, String r46, String r47, List<x> r48, List<b> r49, List<a> r50, String r51) {
        List<x> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r48, List.class, "com.obric.aiagent.plugin");
        List<b> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r49, List.class, "com.obric.aiagent.plugin");
        List<a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r50, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r41, "lastToolName");
        d.h.b.o.e(r42, "lastToolArgs");
        d.h.b.o.e(r45, "lastToolId");
        d.h.b.o.e(r46, "errorCode");
        d.h.b.o.e(r47, "finishReason");
        d.h.b.o.e(r6, "toolList");
        d.h.b.o.e(r8, "clarifyList");
        d.h.b.o.e(r7, "callUserList");
        this.f15852a = r12;
        this.f15853b = r13;
        this.f15854c = r14;
        this.f15855d = r15;
        this.f15856e = r17;
        this.f = r19;
        this.g = r21;
        this.h = r23;
        this.i = r25;
        this.j = r27;
        this.k = r29;
        this.l = r31;
        this.m = r33;
        this.n = r35;
        this.o = r37;
        this.p = r38;
        this.q = r39;
        this.r = r41;
        this.s = r42;
        this.t = r43;
        this.u = r45;
        this.v = r46;
        this.w = r47;
        this.x = r6;
        this.y = r8;
        this.z = r7;
        this.A = r51;
    }
}
