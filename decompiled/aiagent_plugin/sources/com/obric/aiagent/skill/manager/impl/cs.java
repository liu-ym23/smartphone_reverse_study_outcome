package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dz f19696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19700e;
    private final Integer f;
    private final String g;
    private final dw h;
    private final String i;
    private final Boolean j;
    private final Map<String, Object> k;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, cs.class) == true) goto L8;
        return false;
    L8:
        cs r10 = (cs) ZeusTransformUtils.preCheckCast(r9, cs.class, "com.obric.aiagent.plugin");
        if (this.f19696a == r10.f19696a) goto L12;
        return false;
    L12:
        if (this.f19697b == r10.f19697b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19698c, r10.f19698c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19699d, r10.f19699d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19700e, r10.f19700e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f19696a.hashCode() * 31) + Long.hashCode(this.f19697b)) * 31) + this.f19698c.hashCode()) * 31;
        String r1 = this.f19699d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f19700e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        dw r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.j;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return ((r19 + r2) * 31) + this.k.hashCode();
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
        r0.append("SkillLoadPerformanceEvent(result=").append(this.f19696a).append(", durationMs=").append(this.f19697b).append(", traceId=").append(this.f19698c).append(", taskId=").append(this.f19699d).append(", skillId=").append(this.f19700e).append(", skillVersion=").append(this.f).append(", skillSource=").append(this.g).append(", errorCode=").append(this.h).append(", failureStage=").append(this.i).append(", retryable=").append(this.j).append(", dimensions=").append(this.k).append(')');
        return r0.toString();
    }

    public cs(dz r3, long r4, String r6, String r7, String r8, Integer r9, String r10, dw r11, String r12, Boolean r13, Map<String, ? extends Object> r14) {
        Map<String, Object> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "result");
        d.h.b.o.e(r6, "traceId");
        d.h.b.o.e(r15, "dimensions");
        this.f19696a = r3;
        this.f19697b = r4;
        this.f19698c = r6;
        this.f19699d = r7;
        this.f19700e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r15;
    }

    public final dz a() {
        return this.f19696a;
    }

    public final long b() {
        return this.f19697b;
    }

    public final String c() {
        return this.f19698c;
    }

    public final String d() {
        return this.f19699d;
    }

    public final String e() {
        return this.f19700e;
    }

    public final Integer f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final dw h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final Boolean j() {
        return this.j;
    }

    public final Map<String, Object> k() {
        return this.k;
    }
}
