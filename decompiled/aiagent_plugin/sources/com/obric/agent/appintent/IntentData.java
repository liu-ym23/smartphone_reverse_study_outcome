package com.obric.agent.appintent;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: Intent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentData {

    @SerializedName("isCloud")
    private final boolean isCloud;

    @SerializedName("jobs")
    private final List<IntentJob> jobs;

    /* JADX WARN: Multi-variable type inference failed */
    public IntentData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ IntentData copy$default(IntentData r1, List r2, boolean r3, int r4, Object r5) {
        List<IntentJob> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.jobs;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.isCloud;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<IntentJob> component1() {
        return this.jobs;
    }

    public final boolean component2() {
        return this.isCloud;
    }

    public final IntentData copy(List<IntentJob> r2, boolean r3) {
        return new IntentData((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IntentData.class) == true) goto L8;
        return false;
    L8:
        IntentData r6 = (IntentData) ZeusTransformUtils.preCheckCast(r5, IntentData.class, "com.obric.aiagent.plugin");
        if (o.a(this.jobs, r6.jobs) == true) goto L12;
        return false;
    L12:
        if (this.isCloud == r6.isCloud) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<IntentJob> r0 = this.jobs;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Boolean.hashCode(this.isCloud);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "IntentData(jobs=" + this.jobs + ", isCloud=" + this.isCloud + ')';
    }

    public IntentData(List<IntentJob> r3, boolean r4) {
        this.jobs = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.isCloud = r4;
    }

    public /* synthetic */ IntentData(List r2, boolean r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r6, r3);
    }

    public final List<IntentJob> getJobs() {
        return this.jobs;
    }

    public final boolean isCloud() {
        return this.isCloud;
    }
}
