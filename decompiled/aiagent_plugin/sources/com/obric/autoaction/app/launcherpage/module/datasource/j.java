package com.obric.autoaction.app.launcherpage.module.datasource;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TimerTaskRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f24276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f24277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f24278e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final boolean k;
    private final Integer l;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (this.f24274a == r10.f24274a) goto L12;
        return false;
    L12:
        if (o.a(this.f24275b, r10.f24275b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f24276c, r10.f24276c) == true) goto L18;
        return false;
    L18:
        if (this.f24277d == r10.f24277d) goto L21;
        return false;
    L21:
        if (o.a(this.f24278e, r10.f24278e) == true) goto L24;
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
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (o.a(this.l, r10.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.f24274a) * 31) + this.f24275b.hashCode()) * 31;
        Long r1 = this.f24276c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.f24277d)) * 31;
        Long r5 = this.f24278e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.f.hashCode()) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        String r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Boolean.hashCode(this.k)) * 31;
        Integer r14 = this.l;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
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
        r0.append("TimerTaskTriggerRecord(taskStatus=").append(this.f24274a).append(", timerTaskId=").append(this.f24275b).append(", triggerId=").append(this.f24276c).append(", triggerTime=").append(this.f24277d).append(", realActionTime=").append(this.f24278e).append(", cronExpr=").append(this.f).append(", name=").append(this.g).append(", action=").append(this.h).append(", sourceFrom=").append(this.i).append(", failedReasonString=").append(this.j).append(", isRepeat=").append(this.k).append(", enableStatus=");
        r0.append(this.l).append(')');
        return r0.toString();
    }

    public j(int r2, String r3, Long r4, long r5, Long r7, String r8, String r9, String r10, String r11, String r12, boolean r13, Integer r14) {
        o.e(r3, "timerTaskId");
        o.e(r8, "cronExpr");
        o.e(r10, "action");
        o.e(r11, "sourceFrom");
        this.f24274a = r2;
        this.f24275b = r3;
        this.f24276c = r4;
        this.f24277d = r5;
        this.f24278e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }

    public final int a() {
        return this.f24274a;
    }

    public final String b() {
        return this.f24275b;
    }

    public final Long c() {
        return this.f24276c;
    }

    public final long d() {
        return this.f24277d;
    }

    public final String e() {
        return this.h;
    }

    public final String f() {
        return this.i;
    }

    public final String g() {
        return this.j;
    }

    public final boolean h() {
        return this.k;
    }
}
