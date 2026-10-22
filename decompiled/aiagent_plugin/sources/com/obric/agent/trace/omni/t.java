package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReportBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f15709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15710e;
    private final long f;
    private final String g;
    private final String h;
    private final long i;
    private final String j;

    public static /* synthetic */ t a(t r14, String r15, String r16, String r17, long r18, String r20, long r21, String r23, String r24, long r25, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = r14.f15706a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.f15707b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.f15708c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        long r5 = r14.f15709d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r7 = r14.f15710e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r8 = r14.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r10 = r14.g;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r11 = r14.h;
    L35:
        if ((r28 & 256) == 0) goto L37;
        long r12 = r14.i;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r1 = r14.j;
    L43:
        return r14.a(r2, r3, r4, r5, r7, r8, r10, r11, r12, r1);
    L41:
        r1 = r27;
        goto L43
    L37:
        r12 = r25;
        goto L39
    L33:
        r11 = r24;
        goto L35
    L29:
        r10 = r23;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final t a(String r16, String r17, String r18, long r19, String r21, long r22, String r24, String r25, long r26, String r28) {
        d.h.b.o.e(r16, "messageId");
        d.h.b.o.e(r17, "toolId");
        d.h.b.o.e(r18, "toolName");
        d.h.b.o.e(r21, "executeId");
        d.h.b.o.e(r24, "toolArgs");
        d.h.b.o.e(r25, "actionType");
        d.h.b.o.e(r28, "errCode");
        return new t(r16, r17, r18, r19, r21, r22, r24, r25, r26, r28);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15706a, r10.f15706a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15707b, r10.f15707b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15708c, r10.f15708c) == true) goto L18;
        return false;
    L18:
        if (this.f15709d == r10.f15709d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f15710e, r10.f15710e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((this.f15706a.hashCode() * 31) + this.f15707b.hashCode()) * 31) + this.f15708c.hashCode()) * 31) + Long.hashCode(this.f15709d)) * 31) + this.f15710e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Long.hashCode(this.i)) * 31) + this.j.hashCode();
    }

    public String toString() {
        return "ReportDispatchIntentBean(messageId=" + this.f15706a + ", toolId=" + this.f15707b + ", toolName=" + this.f15708c + ", dispatchTime=" + this.f15709d + ", executeId=" + this.f15710e + ", finishTime=" + this.f + ", toolArgs=" + this.g + ", actionType=" + this.h + ", duration=" + this.i + ", errCode=" + this.j + ')';
    }

    public t(String r2, String r3, String r4, long r5, String r7, long r8, String r10, String r11, long r12, String r14) {
        d.h.b.o.e(r2, "messageId");
        d.h.b.o.e(r3, "toolId");
        d.h.b.o.e(r4, "toolName");
        d.h.b.o.e(r7, "executeId");
        d.h.b.o.e(r10, "toolArgs");
        d.h.b.o.e(r11, "actionType");
        d.h.b.o.e(r14, "errCode");
        this.f15706a = r2;
        this.f15707b = r3;
        this.f15708c = r4;
        this.f15709d = r5;
        this.f15710e = r7;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r14;
    }

    public /* synthetic */ t(String r18, String r19, String r20, long r21, String r23, long r24, String r26, String r27, long r28, String r30, int r31, d.h.b.h r32) {
        if ((r31 & 16) == 0) goto L5;
        String r9 = "";
    L7:
        if ((r31 & 32) == 0) goto L9;
        long r10 = -1;
    L11:
        if ((r31 & 64) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r31 & 128) == 0) goto L17;
        String r13 = "";
    L19:
        if ((r31 & 256) == 0) goto L21;
        long r14 = -1;
    L23:
        if ((r31 & 512) == 0) goto L25;
        String r16 = "0";
    L26:
        this(r18, r19, r20, r21, r9, r10, r12, r13, r14, r16);
        return;
    L25:
        r16 = r30;
        goto L26
    L21:
        r14 = r28;
        goto L23
    L17:
        r13 = r27;
        goto L19
    L13:
        r12 = r26;
        goto L15
    L9:
        r10 = r24;
        goto L11
    L5:
        r9 = r23;
        goto L7
    }

    public final String a() {
        return this.f15707b;
    }

    public final String b() {
        return this.f15708c;
    }

    public final long c() {
        return this.f15709d;
    }

    public final String d() {
        return this.f15710e;
    }

    public final long e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final long h() {
        return this.i;
    }

    public final String i() {
        return this.j;
    }
}
