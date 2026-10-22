package com.obric.performance.power.monitor.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SensorInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f37006b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f37005a == r6.f37005a) goto L12;
        return false;
    L12:
        if (o.a(this.f37006b, r6.f37006b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f37005a) * 31;
        Integer r1 = this.f37006b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SensorInfo(listenerHashCode=" + this.f37005a + ", sensorHashCode=" + this.f37006b + ')';
    }

    public a(int r1, Integer r2) {
        this.f37005a = r1;
        this.f37006b = r2;
    }

    public final int a() {
        return this.f37005a;
    }

    public final Integer b() {
        return this.f37006b;
    }
}
