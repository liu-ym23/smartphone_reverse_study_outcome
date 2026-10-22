package com.obric.aiagent.executionengine.scheduler.impl.execution.security;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: IntentExecutePolicyGroup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentExecutePolicyGroup {
    private final IntentExecutePolicyItem policy;

    @SerializedName("sub_actions")
    private final Map<String, IntentExecutePolicyItem> subActions;

    public static /* synthetic */ IntentExecutePolicyGroup copy$default(IntentExecutePolicyGroup r1, IntentExecutePolicyItem r2, Map r3, int r4, Object r5) {
        Map<String, IntentExecutePolicyItem> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.policy;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.subActions;
    L9:
        return r1.copy(r2, r6);
    }

    public final IntentExecutePolicyItem component1() {
        return this.policy;
    }

    public final Map<String, IntentExecutePolicyItem> component2() {
        return this.subActions;
    }

    public final IntentExecutePolicyGroup copy(IntentExecutePolicyItem r2, Map<String, IntentExecutePolicyItem> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "policy");
        return new IntentExecutePolicyGroup(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IntentExecutePolicyGroup.class) == true) goto L8;
        return false;
    L8:
        IntentExecutePolicyGroup r6 = (IntentExecutePolicyGroup) ZeusTransformUtils.preCheckCast(r5, IntentExecutePolicyGroup.class, "com.obric.aiagent.plugin");
        if (o.a(this.policy, r6.policy) == true) goto L12;
        return false;
    L12:
        if (o.a(this.subActions, r6.subActions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.policy.hashCode() * 31;
        Map<String, IntentExecutePolicyItem> r1 = this.subActions;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "IntentExecutePolicyGroup(policy=" + this.policy + ", subActions=" + this.subActions + ')';
    }

    public IntentExecutePolicyGroup(IntentExecutePolicyItem r3, Map<String, IntentExecutePolicyItem> r4) {
        Map<String, IntentExecutePolicyItem> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "policy");
        this.policy = r3;
        this.subActions = r5;
    }

    public final IntentExecutePolicyItem getPolicy() {
        return this.policy;
    }

    public final Map<String, IntentExecutePolicyItem> getSubActions() {
        return this.subActions;
    }

    public final IntentExecutePolicyItem getSubActionPolicy(String r6) {
        Map<String, IntentExecutePolicyItem> r0 = this.subActions;
        if (r0 == null) goto L18;
        Set<Map.Entry<String, IntentExecutePolicyItem>> r1 = r0.entrySet();
        if (r1 == null) goto L18;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (d.o.o.a((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"), r6, true) == false) goto L8;
    L13:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L18;
        IntentExecutePolicyItem r8 = (IntentExecutePolicyItem) ZeusTransformUtils.preCheckCast(r7.getValue(), IntentExecutePolicyItem.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L18;
        return r8;
    L12:
        r3 = null;
    L18:
        return this.policy;
    }
}
