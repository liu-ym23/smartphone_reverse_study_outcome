package com.obric.event.task.base.report;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f32775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f32776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32777e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32773a, r6.f32773a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32774b, r6.f32774b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f32775c, r6.f32775c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f32776d, r6.f32776d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f32777e, r6.f32777e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.f32773a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f32774b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.f32775c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.f32776d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f32777e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "DiscoveryInstructionReportInfo(instructionId=" + this.f32773a + ", query=" + this.f32774b + ", instructionType=" + this.f32775c + ", executeType=" + this.f32776d + ", shortCommand=" + this.f32777e + ')';
    }

    public g(String r1, String r2, Integer r3, Integer r4, String r5) {
        this.f32773a = r1;
        this.f32774b = r2;
        this.f32775c = r3;
        this.f32776d = r4;
        this.f32777e = r5;
    }

    public final String a() {
        return this.f32773a;
    }

    public final String b() {
        return this.f32774b;
    }

    public final Integer c() {
        return this.f32775c;
    }

    public final Integer d() {
        return this.f32776d;
    }

    public final String e() {
        return this.f32777e;
    }
}
