package com.obric.aiagent.executionengine.scheduler.impl.execution.security;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: V1IntentExecutePolicyContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class V1IntentExecutePolicyContent {
    private final Map<String, IntentExecutePolicyGroup> policies;
    private final String version;

    public static /* synthetic */ V1IntentExecutePolicyContent copy$default(V1IntentExecutePolicyContent r1, String r2, Map r3, int r4, Object r5) {
        Map<String, IntentExecutePolicyGroup> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.version;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.policies;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.version;
    }

    public final Map<String, IntentExecutePolicyGroup> component2() {
        return this.policies;
    }

    public final V1IntentExecutePolicyContent copy(String r2, Map<String, IntentExecutePolicyGroup> r3) {
        return new V1IntentExecutePolicyContent(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, V1IntentExecutePolicyContent.class) == true) goto L8;
        return false;
    L8:
        V1IntentExecutePolicyContent r6 = (V1IntentExecutePolicyContent) ZeusTransformUtils.preCheckCast(r5, V1IntentExecutePolicyContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.version, r6.version) == true) goto L12;
        return false;
    L12:
        if (o.a(this.policies, r6.policies) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.version;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, IntentExecutePolicyGroup> r4 = this.policies;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "V1IntentExecutePolicyContent(version=" + this.version + ", policies=" + this.policies + ')';
    }

    public V1IntentExecutePolicyContent(String r3, Map<String, IntentExecutePolicyGroup> r4) {
        Map<String, IntentExecutePolicyGroup> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.version = r3;
        this.policies = r5;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Map<String, IntentExecutePolicyGroup> getPolicies() {
        return this.policies;
    }
}
