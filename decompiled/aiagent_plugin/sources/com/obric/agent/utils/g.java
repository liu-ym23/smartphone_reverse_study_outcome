package com.obric.agent.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClientToolReportHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16031b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f16030a, r6.f16030a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f16031b, r6.f16031b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f16030a.hashCode() * 31) + this.f16031b.hashCode();
    }

    public String toString() {
        return "ClientToolInfo(toolName=" + this.f16030a + ", toolId=" + this.f16031b + ')';
    }

    public g(String r2, String r3) {
        d.h.b.o.e(r2, "toolName");
        d.h.b.o.e(r3, "toolId");
        this.f16030a = r2;
        this.f16031b = r3;
    }

    public final String a() {
        return this.f16030a;
    }

    public final String b() {
        return this.f16031b;
    }
}
