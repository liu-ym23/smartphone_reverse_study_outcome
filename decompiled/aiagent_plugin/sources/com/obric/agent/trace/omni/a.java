package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ReportBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<Object>> f15607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<e> f15608c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15606a, r6.f15606a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15607b, r6.f15607b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15608c, r6.f15608c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f15606a.hashCode() * 31) + this.f15607b.hashCode()) * 31) + this.f15608c.hashCode();
    }

    public String toString() {
        return "BucketSnapshot(messageId=" + this.f15606a + ", params=" + this.f15607b + ", timeline=" + this.f15608c + ')';
    }

    public a(String r3, Map<String, ? extends List<? extends Object>> r4, List<e> r5) {
        Map<String, List<Object>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List<e> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "messageId");
        d.h.b.o.e(r6, "params");
        d.h.b.o.e(r7, "timeline");
        this.f15606a = r3;
        this.f15607b = r6;
        this.f15608c = r7;
    }

    public final String a() {
        return this.f15606a;
    }

    public final Map<String, List<Object>> b() {
        return this.f15607b;
    }

    public final List<e> c() {
        return this.f15608c;
    }
}
