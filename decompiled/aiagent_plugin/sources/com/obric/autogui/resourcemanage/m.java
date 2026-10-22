package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f30637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f30638b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L8;
        return false;
    L8:
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if (this.f30637a == r10.f30637a) goto L12;
        return false;
    L12:
        if (this.f30638b == r10.f30638b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f30637a) * 31) + Long.hashCode(this.f30638b);
    }

    public String toString() {
        return "RequestTimingConfig(minIntervalMs=" + this.f30637a + ", failureBackoffMs=" + this.f30638b + ')';
    }

    public m(long r1, long r3) {
        this.f30637a = r1;
        this.f30638b = r3;
    }

    public final long a() {
        return this.f30637a;
    }

    public final long b() {
        return this.f30638b;
    }
}
