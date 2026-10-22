package com.obric.aiagent.ipc.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IPCAnomalyDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f18644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18645b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18644a, r6.f18644a) == true) goto L12;
        return false;
    L12:
        if (this.f18645b == r6.f18645b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f18644a.hashCode() * 31) + Integer.hashCode(this.f18645b);
    }

    public String toString() {
        return "IPCAnomalyDecision(anomalyTypes=" + this.f18644a + ", windowCount=" + this.f18645b + ')';
    }

    public b(List<? extends e> r3, int r4) {
        List<e> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "anomalyTypes");
        this.f18644a = r5;
        this.f18645b = r4;
    }

    public final List<e> a() {
        return this.f18644a;
    }

    public final int b() {
        return this.f18645b;
    }
}
