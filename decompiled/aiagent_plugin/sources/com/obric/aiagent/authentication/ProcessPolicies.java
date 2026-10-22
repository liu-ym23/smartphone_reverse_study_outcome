package com.obric.aiagent.authentication;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ProcessPolicies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcessPolicies {
    private final Map<String, ActionPolicy> actions;
    private final List<String> subject;
    private final List<String> target;

    public static /* synthetic */ ProcessPolicies copy$default(ProcessPolicies r1, List r2, List r3, Map r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, ActionPolicy> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.subject;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = r1.target;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = r1.actions;
    L12:
        return r1.copy(r7, r8, r9);
    }

    public final List<String> component1() {
        return this.subject;
    }

    public final List<String> component2() {
        return this.target;
    }

    public final Map<String, ActionPolicy> component3() {
        return this.actions;
    }

    public final ProcessPolicies copy(List<String> r2, List<String> r3, Map<String, ActionPolicy> r4) {
        return new ProcessPolicies((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProcessPolicies.class) == true) goto L8;
        return false;
    L8:
        ProcessPolicies r6 = (ProcessPolicies) ZeusTransformUtils.preCheckCast(r5, ProcessPolicies.class, "com.obric.aiagent.plugin");
        if (o.a(this.subject, r6.subject) == true) goto L12;
        return false;
    L12:
        if (o.a(this.target, r6.target) == true) goto L15;
        return false;
    L15:
        if (o.a(this.actions, r6.actions) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.subject;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.target;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, ActionPolicy> r7 = this.actions;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ProcessPolicies(subject=" + this.subject + ", target=" + this.target + ", actions=" + this.actions + ')';
    }

    public ProcessPolicies(List<String> r3, List<String> r4, Map<String, ActionPolicy> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map<String, ActionPolicy> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.subject = r6;
        this.target = r7;
        this.actions = r8;
    }

    public final List<String> getSubject() {
        return this.subject;
    }

    public final List<String> getTarget() {
        return this.target;
    }

    public final Map<String, ActionPolicy> getActions() {
        return this.actions;
    }
}
