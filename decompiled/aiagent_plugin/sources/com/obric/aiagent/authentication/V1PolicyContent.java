package com.obric.aiagent.authentication;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: V1PolicyContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class V1PolicyContent {
    private final String category;
    private final List<ProcessPolicies> policies;

    public static /* synthetic */ V1PolicyContent copy$default(V1PolicyContent r1, String r2, List r3, int r4, Object r5) {
        List<ProcessPolicies> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.category;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.policies;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.category;
    }

    public final List<ProcessPolicies> component2() {
        return this.policies;
    }

    public final V1PolicyContent copy(String r2, List<ProcessPolicies> r3) {
        return new V1PolicyContent(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, V1PolicyContent.class) == true) goto L8;
        return false;
    L8:
        V1PolicyContent r6 = (V1PolicyContent) ZeusTransformUtils.preCheckCast(r5, V1PolicyContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.category, r6.category) == true) goto L12;
        return false;
    L12:
        if (o.a(this.policies, r6.policies) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.category;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<ProcessPolicies> r4 = this.policies;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "V1PolicyContent(category=" + this.category + ", policies=" + this.policies + ')';
    }

    public V1PolicyContent(String r3, List<ProcessPolicies> r4) {
        List<ProcessPolicies> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.category = r3;
        this.policies = r5;
    }

    public final String getCategory() {
        return this.category;
    }

    public final List<ProcessPolicies> getPolicies() {
        return this.policies;
    }
}
