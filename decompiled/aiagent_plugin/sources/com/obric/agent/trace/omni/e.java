package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: OmniEventStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f15628a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15628a, r6.f15628a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f15628a.hashCode();
    }

    public String toString() {
        return "NodeEventRecord(params=" + this.f15628a + ')';
    }

    public e(Map<String, ? extends Object> r3) {
        Map<String, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "params");
        this.f15628a = r4;
    }

    public final Map<String, Object> a() {
        return this.f15628a;
    }
}
