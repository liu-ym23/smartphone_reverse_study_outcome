package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("eca_id")
    private String f32909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("target")
    private final String f32910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(DBDefinition.TITLE)
    private final String f32911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("status")
    private n f32912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("runtime_status")
    private m f32913e;

    @SerializedName("task_instruction")
    private final String f;

    @SerializedName("start_time")
    private final String g;

    @SerializedName("end_time")
    private final String h;

    @SerializedName("repeat_type")
    private final l i;

    @SerializedName("repeat_values")
    private final List<String> j;

    @SerializedName("time_condition")
    private final o k;

    @SerializedName("location_condition")
    private i l;

    @SerializedName("device_condition")
    private List<e> m;

    @SerializedName("condition_policy")
    private final c n;

    @SerializedName("omni_model")
    private final String o;

    @SerializedName("extensions")
    private final Map<String, String> p;

    @SerializedName("created_at")
    private final String q;

    @SerializedName("updated_at")
    private final String r;

    @SerializedName("trigger_policy")
    private final q s;

    public g() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32909a, r6.f32909a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32910b, r6.f32910b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f32911c, r6.f32911c) == true) goto L18;
        return false;
    L18:
        if (this.f32912d == r6.f32912d) goto L21;
        return false;
    L21:
        if (this.f32913e == r6.f32913e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (d.h.b.o.a(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (d.h.b.o.a(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (d.h.b.o.a(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (d.h.b.o.a(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (d.h.b.o.a(this.s, r6.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        String r0 = this.f32909a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f32910b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f32911c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        n r10 = this.f32912d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        m r13 = this.f32913e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        l r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        o r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        i r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        List<e> r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        c r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Map<String, String> r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.r;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        q r55 = this.s;
        if (r55 == null) goto L79;
        r1 = r55.hashCode();
    L79:
        return r54 + r1;
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
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
        r0.append("EventTaskEntityDto(ecaId=").append(this.f32909a).append(", target=").append(this.f32910b).append(", title=").append(this.f32911c).append(", status=").append(this.f32912d).append(", runtimeStatus=").append(this.f32913e).append(", taskInstruction=").append(this.f).append(", startTime=").append(this.g).append(", endTime=").append(this.h).append(", repeatType=").append(this.i).append(", repeatValues=").append(this.j).append(", timeCondition=").append(this.k).append(", locationCondition=");
        r0.append(this.l).append(", deviceCondition=").append(this.m).append(", conditionPolicy=").append(this.n).append(", omniModel=").append(this.o).append(", extensions=").append(this.p).append(", createdAt=").append(this.q).append(", updatedAt=").append(this.r).append(", triggerControlPolicy=").append(this.s).append(')');
        return r0.toString();
    }

    public g(String r7, String r8, String r9, n r10, m r11, String r12, String r13, String r14, l r15, List<String> r16, o r17, i r18, List<e> r19, c r20, String r21, Map<String, String> r22, String r23, String r24, q r25) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        List<e> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        this.f32909a = r7;
        this.f32910b = r8;
        this.f32911c = r9;
        this.f32912d = r10;
        this.f32913e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r1;
        this.k = r17;
        this.l = r18;
        this.m = r3;
        this.n = r20;
        this.o = r21;
        this.p = r2;
        this.q = r23;
        this.r = r24;
        this.s = r25;
    }

    public /* synthetic */ g(String r21, String r22, String r23, n r24, m r25, String r26, String r27, String r28, l r29, List r30, o r31, i r32, List r33, c r34, String r35, Map r36, String r37, String r38, q r39, int r40, d.h.b.h r41) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        if ((r40 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        n r8 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        m r9 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        l r13 = null;
    L39:
        if ((r40 & 512) == 0) goto L42;
        r1 = null;
    L42:
        if ((r40 & 1024) == 0) goto L44;
        o r14 = null;
    L46:
        if ((r40 & 2048) == 0) goto L48;
        i r15 = null;
    L50:
        if ((r40 & 4096) == 0) goto L53;
        r3 = null;
    L53:
        if ((r40 & 8192) == 0) goto L55;
        c r5 = null;
    L57:
        if ((r40 & 16384) == 0) goto L59;
        String r16 = null;
    L61:
        if ((r40 & 32768) == 0) goto L63;
        Map r17 = null;
    L65:
        if ((r40 & 65536) == 0) goto L67;
        String r18 = null;
    L69:
        if ((r40 & UiType.FLAG_PHONE_CARD) == 0) goto L71;
        String r19 = null;
    L73:
        if ((r40 & 262144) == 0) goto L75;
        q r0 = null;
    L76:
        this(r4, r6, r7, r8, r9, r10, r11, r12, r13, r1, r14, r15, r3, r5, r16, r17, r18, r19, r0);
        return;
    L75:
        r0 = r39;
        goto L76
    L71:
        r19 = r38;
        goto L73
    L67:
        r18 = r37;
        goto L69
    L63:
        r17 = r2;
        goto L65
    L59:
        r16 = r35;
        goto L61
    L55:
        r5 = r34;
        goto L57
    L48:
        r15 = r32;
        goto L50
    L44:
        r14 = r31;
        goto L46
    L37:
        r13 = r29;
        goto L39
    L33:
        r12 = r28;
        goto L35
    L29:
        r11 = r27;
        goto L31
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    public final void a(String r1) {
        this.f32909a = r1;
    }

    public final String a() {
        return this.f32911c;
    }

    public final void a(n r1) {
        this.f32912d = r1;
    }

    public final void a(m r1) {
        this.f32913e = r1;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        return this.h;
    }

    public final l e() {
        return this.i;
    }

    public final List<String> f() {
        return this.j;
    }

    public final o g() {
        return this.k;
    }

    public final void a(i r1) {
        this.l = r1;
    }

    public final i h() {
        return this.l;
    }

    public final void a(List<e> r3) {
        this.m = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<e> i() {
        return this.m;
    }

    public final String j() {
        return this.o;
    }

    public final Map<String, String> k() {
        return this.p;
    }

    public final q l() {
        return this.s;
    }
}
