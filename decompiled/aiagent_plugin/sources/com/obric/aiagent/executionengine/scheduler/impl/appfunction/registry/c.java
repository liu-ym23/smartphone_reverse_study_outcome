package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionAppMetadataReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18245e;
    private final String f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18241a, r6.f18241a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18242b, r6.f18242b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18243c, r6.f18243c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18244d, r6.f18244d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f18245e, r6.f18245e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f18241a.hashCode() * 31) + this.f18242b.hashCode()) * 31;
        String r1 = this.f18243c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.f18244d.hashCode()) * 31) + this.f18245e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AppFunctionAppMetadata(description=" + this.f18241a + ", displayDescription=" + this.f18242b + ", displayName=" + this.f18243c + ", skillName=" + this.f18244d + ", skillDescription=" + this.f18245e + ", triggerExamples=" + this.f + ')';
    }

    public c(String r2, String r3, String r4, String r5, String r6, String r7) {
        d.h.b.o.e(r2, "description");
        d.h.b.o.e(r3, "displayDescription");
        d.h.b.o.e(r5, "skillName");
        d.h.b.o.e(r6, "skillDescription");
        d.h.b.o.e(r7, "triggerExamples");
        this.f18241a = r2;
        this.f18242b = r3;
        this.f18243c = r4;
        this.f18244d = r5;
        this.f18245e = r6;
        this.f = r7;
    }

    public /* synthetic */ c(String r8, String r9, String r10, String r11, String r12, String r13, int r14, d.h.b.h r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = null;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }

    public final String a() {
        return this.f18241a;
    }

    public final void a(String r1) {
        this.f18243c = r1;
    }

    public final String b() {
        return this.f18244d;
    }

    public final String c() {
        return this.f18245e;
    }

    public final String d() {
        return this.f;
    }
}
