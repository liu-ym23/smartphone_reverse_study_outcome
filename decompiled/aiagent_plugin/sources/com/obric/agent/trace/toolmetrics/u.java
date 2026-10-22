package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f15927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f15929c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        if (this.f15927a == r6.f15927a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15928b, r6.f15928b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15929c, r6.f15929c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f15927a.hashCode() * 31) + this.f15928b.hashCode()) * 31) + this.f15929c.hashCode();
    }

    public String toString() {
        return "OmniClientToolTraceFragment(layer=" + this.f15927a + ", ownerNamespace=" + this.f15928b + ", fields=" + this.f15929c + ')';
    }

    public u(v r3, String r4, Map<String, ? extends Object> r5) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "layer");
        d.h.b.o.e(r4, "ownerNamespace");
        d.h.b.o.e(r6, "fields");
        this.f15927a = r3;
        this.f15928b = r4;
        this.f15929c = r6;
    }

    public final v a() {
        return this.f15927a;
    }

    public final String b() {
        return this.f15928b;
    }

    public final Map<String, Object> c() {
        return this.f15929c;
    }
}
