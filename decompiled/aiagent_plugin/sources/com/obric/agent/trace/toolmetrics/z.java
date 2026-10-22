package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15949a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, z.class) == true) goto L8;
        return false;
    L8:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15949a, r6.f15949a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f15949a.hashCode();
    }

    public String toString() {
        return "OmniClientToolTraceToken(value=" + this.f15949a + ')';
    }

    public z(String r2) {
        d.h.b.o.e(r2, "value");
        this.f15949a = r2;
    }

    public final String a() {
        return this.f15949a;
    }
}
