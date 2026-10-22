package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17156b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, p.class) == true) goto L8;
        return false;
    L8:
        p r10 = (p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.aiagent.plugin");
        if (this.f17155a == r10.f17155a) goto L12;
        return false;
    L12:
        if (this.f17156b == r10.f17156b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f17155a) * 31) + Long.hashCode(this.f17156b);
    }

    public String toString() {
        return "LocationMonitorSamplingConfig(windowDurationMs=" + this.f17155a + ", sampleIntervalMs=" + this.f17156b + ')';
    }

    public p(long r1, long r3) {
        this.f17155a = r1;
        this.f17156b = r3;
    }

    public final long a() {
        return this.f17155a;
    }

    public final long b() {
        return this.f17156b;
    }
}
