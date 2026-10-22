package com.obric.funcall_api.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ECAData {

    @SerializedName("jobs")
    private final List<ECAJob> jobs;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECAData copy$default(ECAData r1, List r2, int r3, Object r4) {
        List<ECAJob> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.jobs;
    L6:
        return r1.copy(r5);
    }

    public final List<ECAJob> component1() {
        return this.jobs;
    }

    public final ECAData copy(List<ECAJob> r2) {
        return new ECAData((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ECAData.class) == true) goto L8;
        return false;
    L8:
        ECAData r6 = (ECAData) ZeusTransformUtils.preCheckCast(r5, ECAData.class, "com.obric.aiagent.plugin");
        if (o.a(this.jobs, r6.jobs) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ECAJob> r0 = this.jobs;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ECAData(jobs=" + this.jobs + ')';
    }

    public ECAData(List<ECAJob> r3) {
        this.jobs = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ ECAData(List r2, int r3, h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    public final List<ECAJob> getJobs() {
        return this.jobs;
    }
}
