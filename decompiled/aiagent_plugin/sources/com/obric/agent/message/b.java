package com.obric.agent.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: IAgentMessageExtProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f15200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15201b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f15200a, r6.f15200a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f15201b, r6.f15201b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f15200a.hashCode() * 31) + this.f15201b.hashCode();
    }

    public String toString() {
        return "ProviderParam(map=" + this.f15200a + ", content=" + this.f15201b + ')';
    }

    public b(Map<String, String> r3, String r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r5, "map");
        o.e(r4, "content");
        this.f15200a = r5;
        this.f15201b = r4;
    }

    public final Map<String, String> a() {
        return this.f15200a;
    }
}
