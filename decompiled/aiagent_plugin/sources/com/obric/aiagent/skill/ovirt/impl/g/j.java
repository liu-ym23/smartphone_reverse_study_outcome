package com.obric.aiagent.skill.ovirt.impl.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellOutputStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f21444e;
    private final boolean f;
    private final Integer g;
    private final boolean h;
    private final long i;
    private final long j;
    private final String k;
    private final String l;
    private final String m;

    public static /* synthetic */ j a(j r16, String r17, String r18, String r19, String r20, String r21, boolean r22, Integer r23, boolean r24, long r25, long r27, String r29, String r30, String r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = r16.f21440a;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.f21441b;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r4 = r16.f21442c;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r5 = r16.f21443d;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r6 = r16.f21444e;
    L23:
        if ((r32 & 32) == 0) goto L25;
        boolean r7 = r16.f;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Integer r8 = r16.g;
    L31:
        if ((r32 & 128) == 0) goto L33;
        boolean r9 = r16.h;
    L35:
        if ((r32 & 256) == 0) goto L37;
        long r10 = r16.i;
    L39:
        if ((r32 & 512) == 0) goto L41;
        long r12 = r16.j;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r14 = r16.k;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r15 = r16.l;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        String r1 = r16.m;
    L55:
        return r16.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r1);
    L53:
        r1 = r31;
        goto L55
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = r29;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final j a(String r18, String r19, String r20, String r21, String r22, boolean r23, Integer r24, boolean r25, long r26, long r28, String r30, String r31, String r32) {
        o.e(r18, "groupId");
        o.e(r19, "executionId");
        o.e(r20, "workDir");
        o.e(r21, "command");
        o.e(r22, "status");
        return new j(r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r31, r32);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21440a, r10.f21440a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21441b, r10.f21441b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f21442c, r10.f21442c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f21443d, r10.f21443d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f21444e, r10.f21444e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
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
        if (o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (o.a(this.m, r10.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f21440a.hashCode() * 31) + this.f21441b.hashCode()) * 31) + this.f21442c.hashCode()) * 31) + this.f21443d.hashCode()) * 31) + this.f21444e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31;
        Integer r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + Boolean.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31;
        String r5 = this.k;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.l;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.m;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        r0.append("VirtProcessSnapshot(groupId=").append(this.f21440a).append(", executionId=").append(this.f21441b).append(", workDir=").append(this.f21442c).append(", command=").append(this.f21443d).append(", status=").append(this.f21444e).append(", completed=").append(this.f).append(", exitCode=").append(this.g).append(", killed=").append(this.h).append(", startedAtMs=").append(this.i).append(", durationMs=").append(this.j).append(", clientEgressResultJson=").append(this.k).append(", stdoutPath=");
        r0.append(this.l).append(", stderrPath=").append(this.m).append(')');
        return r0.toString();
    }

    public j(String r8, String r9, String r10, String r11, String r12, boolean r13, Integer r14, boolean r15, long r16, long r18, String r20, String r21, String r22) {
        o.e(r8, "groupId");
        o.e(r9, "executionId");
        o.e(r10, "workDir");
        o.e(r11, "command");
        o.e(r12, "status");
        this.f21440a = r8;
        this.f21441b = r9;
        this.f21442c = r10;
        this.f21443d = r11;
        this.f21444e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r18;
        this.k = r20;
        this.l = r21;
        this.m = r22;
    }

    public /* synthetic */ j(String r20, String r21, String r22, String r23, String r24, boolean r25, Integer r26, boolean r27, long r28, long r30, String r32, String r33, String r34, int r35, d.h.b.h r36) {
        if ((r35 & 1024) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r35 & 2048) == 0) goto L9;
        String r17 = null;
    L11:
        if ((r35 & 4096) == 0) goto L13;
        String r18 = null;
    L14:
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r30, r16, r17, r18);
        return;
    L13:
        r18 = r34;
        goto L14
    L9:
        r17 = r33;
        goto L11
    L5:
        r16 = r32;
        goto L7
    }

    public final String a() {
        return this.f21440a;
    }

    public final String b() {
        return this.f21441b;
    }

    public final String c() {
        return this.f21442c;
    }

    public final String d() {
        return this.f21443d;
    }

    public final String e() {
        return this.f21444e;
    }

    public final boolean f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final long i() {
        return this.i;
    }

    public final long j() {
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
}
