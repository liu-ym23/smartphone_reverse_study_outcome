package com.obric.aiagent.llm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("SpanID")
    private final String f18714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("TraceID")
    private final String f18715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("Baggage")
    private final Map<String, Object> f18716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("SpanType")
    private final String f18717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("Name")
    private final String f18718e;

    @SerializedName("ServiceName")
    private final String f;

    @SerializedName("LogID")
    private final String g;

    @SerializedName("WorkspaceID")
    private final String h;

    @SerializedName("ParentSpanID")
    private final String i;

    @SerializedName("StartTime")
    private final String j;

    @SerializedName("FinishTime")
    private final String k;

    @SerializedName("Duration")
    private final long l;

    @SerializedName("TagMap")
    private final Map<String, Object> m;

    @SerializedName("SystemTagMap")
    private final Map<String, Object> n;

    @SerializedName("StatusCode")
    private final int o;

    public g() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, 32767, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18714a, r10.f18714a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18715b, r10.f18715b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f18716c, r10.f18716c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f18717d, r10.f18717d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f18718e, r10.f18718e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
        return false;
    L45:
        if (o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (o.a(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r0 = this.f18714a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f18715b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.f18716c.hashCode()) * 31;
        String r7 = this.f18717d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f18718e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.j;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.k;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return ((((((((r27 + r1) * 31) + Long.hashCode(this.l)) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + Integer.hashCode(this.o);
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        r0.append("SpanContext(spanId=").append(this.f18714a).append(", traceId=").append(this.f18715b).append(", baggage=").append(this.f18716c).append(", spanType=").append(this.f18717d).append(", name=").append(this.f18718e).append(", serviceName=").append(this.f).append(", logId=").append(this.g).append(", workspaceId=").append(this.h).append(", parentSpanId=").append(this.i).append(", startTime=").append(this.j).append(", finishTime=").append(this.k).append(", duration=");
        r0.append(this.l).append(", tagMap=").append(this.m).append(", systemTagMap=").append(this.n).append(", statusCode=").append(this.o).append(')');
        return r0.toString();
    }

    public g(String r7, String r8, Map<String, ? extends Object> r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, long r18, Map<String, ? extends Object> r20, Map<String, ? extends Object> r21, int r22) {
        Map<String, Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map<String, Object> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        Map<String, Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "baggage");
        o.e(r3, "tagMap");
        o.e(r2, "systemTagMap");
        this.f18714a = r7;
        this.f18715b = r8;
        this.f18716c = r1;
        this.f18717d = r10;
        this.f18718e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r3;
        this.n = r2;
        this.o = r22;
    }

    public /* synthetic */ g(String r17, String r18, Map r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, long r28, Map r30, Map r31, int r32, int r33, d.h.b.h r34) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        String r5 = null;
        if ((r33 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r33 & 4) == 0) goto L14;
        r1 = ao.b();
    L14:
        if ((r33 & 8) == 0) goto L16;
        String r7 = null;
    L18:
        if ((r33 & 16) == 0) goto L20;
        String r8 = null;
    L22:
        if ((r33 & 32) == 0) goto L24;
        String r9 = null;
    L26:
        if ((r33 & 64) == 0) goto L28;
        String r10 = null;
    L30:
        if ((r33 & 128) == 0) goto L32;
        String r11 = null;
    L34:
        if ((r33 & 256) == 0) goto L36;
        String r12 = null;
    L38:
        if ((r33 & 512) == 0) goto L40;
        String r13 = null;
    L42:
        if ((r33 & 1024) != 0) goto L46;
        r5 = r27;
    L46:
        if ((r33 & 2048) == 0) goto L48;
        long r14 = 0;
    L50:
        if ((r33 & 4096) == 0) goto L53;
        r3 = ao.b();
    L53:
        if ((r33 & 8192) == 0) goto L55;
        Map r15 = ao.b();
    L57:
        if ((r33 & 16384) == 0) goto L59;
        int r0 = 0;
    L60:
        this(r4, r6, r1, r7, r8, r9, r10, r11, r12, r13, r5, r14, r3, r15, r0);
        return;
    L59:
        r0 = r32;
        goto L60
    L55:
        r15 = r2;
        goto L57
    L48:
        r14 = r28;
        goto L50
    L40:
        r13 = r26;
        goto L42
    L36:
        r12 = r25;
        goto L38
    L32:
        r11 = r24;
        goto L34
    L28:
        r10 = r23;
        goto L30
    L24:
        r9 = r22;
        goto L26
    L20:
        r8 = r21;
        goto L22
    L16:
        r7 = r20;
        goto L18
    L9:
        r6 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }
}
