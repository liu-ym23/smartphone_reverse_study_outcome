package com.obric.autogui.agents.vlm.models.omni.intent;

import android.content.Context;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OmniGUIIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f28411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f28413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonObject f28414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28415e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final boolean k;
    private final Context l;
    private final boolean m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final Boolean r;
    private final Boolean s;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28411a, r6.f28411a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28412b, r6.f28412b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f28413c, r6.f28413c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f28414d, r6.f28414d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f28415e, r6.f28415e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (o.a(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (o.a(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (o.a(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (o.a(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (o.a(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (o.a(this.s, r6.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        Long r0 = this.f28411a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.f28412b.hashCode()) * 31;
        j r4 = this.f28413c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.f28414d.hashCode()) * 31;
        String r7 = this.f28415e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((((((r6 + r8) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        String r10 = this.j;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((((r9 + r11) * 31) + Boolean.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + Boolean.hashCode(this.m)) * 31;
        String r13 = this.n;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.o;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((r15 + r17) * 31) + this.p.hashCode()) * 31;
        String r19 = this.q;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.r;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.s;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        r0.append("OmniRequest(msgId=").append(this.f28411a).append(", sessionId=").append(this.f28412b).append(", singleAction=").append(this.f28413c).append(", stepJson=").append(this.f28414d).append(", prevStepStatus=").append(this.f28415e).append(", query=").append(this.f).append(", toolId=").append(this.g).append(", toolName=").append(this.h).append(", instructionType=").append(this.i).append(", instructionId=").append(this.j).append(", isGuiIdle=").append(this.k).append(", context=");
        r0.append(this.l).append(", keepBitmap=").append(this.m).append(", appListHash=").append(this.n).append(", abilityDescListHash=").append(this.o).append(", recommendTaskType=").append(this.p).append(", callerSource=").append(this.q).append(", allowUserInteraction=").append(this.r).append(", startInPlace=").append(this.s).append(')');
        return r0.toString();
    }

    public g(Long r12, String r13, j r14, JsonObject r15, String r16, String r17, String r18, String r19, String r20, String r21, boolean r22, Context r23, boolean r24, String r25, String r26, String r27, String r28, Boolean r29, Boolean r30) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r15, "stepJson");
        o.e(r17, DownloadConstants.QUERY_KEY);
        o.e(r18, "toolId");
        o.e(r19, "toolName");
        o.e(r20, "instructionType");
        o.e(r8, "context");
        o.e(r27, "recommendTaskType");
        this.f28411a = r12;
        this.f28412b = r13;
        this.f28413c = r14;
        this.f28414d = r15;
        this.f28415e = r16;
        this.f = r17;
        this.g = r18;
        this.h = r19;
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
        this.q = r28;
        this.r = r29;
        this.s = r30;
    }

    public /* synthetic */ g(Long r23, String r24, j r25, JsonObject r26, String r27, String r28, String r29, String r30, String r31, String r32, boolean r33, Context r34, boolean r35, String r36, String r37, String r38, String r39, Boolean r40, Boolean r41, int r42, d.h.b.h r43) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r34, Context.class, "com.obric.aiagent.plugin");
        if ((r42 & 4096) == 0) goto L5;
        boolean r15 = false;
    L7:
        if ((r42 & 8192) == 0) goto L9;
        String r16 = null;
    L11:
        if ((r42 & 16384) == 0) goto L13;
        String r17 = null;
    L15:
        if ((32768 & r42) == 0) goto L17;
        String r18 = "";
    L19:
        if ((65536 & r42) == 0) goto L21;
        String r19 = null;
    L23:
        if ((131072 & r42) == 0) goto L25;
        Boolean r20 = null;
    L27:
        if ((r42 & 262144) == 0) goto L29;
        Boolean r21 = null;
    L30:
        this(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r14, r15, r16, r17, r18, r19, r20, r21);
        return;
    L29:
        r21 = r41;
        goto L30
    L25:
        r20 = r40;
        goto L27
    L21:
        r19 = r39;
        goto L23
    L17:
        r18 = r38;
        goto L19
    L13:
        r17 = r37;
        goto L15
    L9:
        r16 = r36;
        goto L11
    L5:
        r15 = r35;
        goto L7
    }

    public final Long a() {
        return this.f28411a;
    }

    public final String b() {
        return this.f28412b;
    }

    public final j c() {
        return this.f28413c;
    }

    public final JsonObject d() {
        return this.f28414d;
    }

    public final String e() {
        return this.f28415e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final Context getContext() {
        return this.l;
    }

    public final boolean l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final String o() {
        return this.p;
    }

    public final String p() {
        return this.q;
    }

    public final Boolean q() {
        return this.r;
    }

    public final Boolean r() {
        return this.s;
    }
}
