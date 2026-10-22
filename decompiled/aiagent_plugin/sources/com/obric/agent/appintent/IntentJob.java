package com.obric.agent.appintent;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: Intent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentJob {

    @SerializedName("actions")
    private final List<IntentAction> actions;

    /* JADX WARN: Multi-variable type inference failed */
    public IntentJob() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ IntentJob copy$default(IntentJob r1, List r2, int r3, Object r4) {
        List<IntentAction> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.actions;
    L6:
        return r1.copy(r5);
    }

    public final List<IntentAction> component1() {
        return this.actions;
    }

    public final IntentJob copy(List<IntentAction> r2) {
        return new IntentJob((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IntentJob.class) == true) goto L8;
        return false;
    L8:
        IntentJob r6 = (IntentJob) ZeusTransformUtils.preCheckCast(r5, IntentJob.class, "com.obric.aiagent.plugin");
        if (o.a(this.actions, r6.actions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<IntentAction> r0 = this.actions;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "IntentJob(actions=" + this.actions + ')';
    }

    public IntentJob(List<IntentAction> r3) {
        this.actions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ IntentJob(List r2, int r3, h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    public final List<IntentAction> getActions() {
        return this.actions;
    }
}
