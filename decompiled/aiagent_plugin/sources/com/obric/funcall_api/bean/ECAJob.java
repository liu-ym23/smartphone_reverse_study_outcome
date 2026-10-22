package com.obric.funcall_api.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ECAJob {

    @SerializedName("actions")
    private final List<ECAAction> actions;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAJob() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECAJob copy$default(ECAJob r1, List r2, int r3, Object r4) {
        List<ECAAction> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.actions;
    L6:
        return r1.copy(r5);
    }

    public final List<ECAAction> component1() {
        return this.actions;
    }

    public final ECAJob copy(List<ECAAction> r2) {
        return new ECAJob((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ECAJob.class) == true) goto L8;
        return false;
    L8:
        ECAJob r6 = (ECAJob) ZeusTransformUtils.preCheckCast(r5, ECAJob.class, "com.obric.aiagent.plugin");
        if (o.a(this.actions, r6.actions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ECAAction> r0 = this.actions;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ECAJob(actions=" + this.actions + ')';
    }

    public ECAJob(List<ECAAction> r3) {
        this.actions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ ECAJob(List r2, int r3, h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    public final List<ECAAction> getActions() {
        return this.actions;
    }
}
