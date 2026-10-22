package com.bytedance.safetyguard.lxc.internal.e.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10546b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (this.f10545a == r10.f10545a) goto L12;
        return false;
    L12:
        if (o.a(this.f10546b, r10.f10546b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f10545a) * 31) + this.f10546b.hashCode();
    }

    public String toString() {
        return "ConfiguringAppOperation(generation=" + this.f10545a + ", operationId=" + this.f10546b + ')';
    }

    public b(long r2, String r4) {
        o.e(r4, "operationId");
        this.f10545a = r2;
        this.f10546b = r4;
    }

    public final String a() {
        return this.f10546b;
    }
}
