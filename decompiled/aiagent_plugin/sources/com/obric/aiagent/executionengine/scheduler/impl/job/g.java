package com.obric.aiagent.executionengine.scheduler.impl.job;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f18554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.b f18556c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18554a, r6.f18554a) == true) goto L12;
        return false;
    L12:
        if (this.f18555b == r6.f18555b) goto L15;
        return false;
    L15:
        if (o.a(this.f18556c, r6.f18556c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f18554a.hashCode() * 31) + Integer.hashCode(this.f18555b)) * 31) + this.f18556c.hashCode();
    }

    public String toString() {
        return "PendingOmniAuditRecord(job=" + this.f18554a + ", recordIndex=" + this.f18555b + ", internalRecord=" + this.f18556c + ')';
    }

    public g(c r2, int r3, c.b r4) {
        o.e(r2, "job");
        o.e(r4, "internalRecord");
        this.f18554a = r2;
        this.f18555b = r3;
        this.f18556c = r4;
    }

    public final c a() {
        return this.f18554a;
    }

    public final int b() {
        return this.f18555b;
    }

    public final c.b c() {
        return this.f18556c;
    }
}
