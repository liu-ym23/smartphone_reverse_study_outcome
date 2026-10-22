package com.stepos.policy.sdk.bean;

import a0.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudPolicyUrlInfo {
    private final String category;
    private final String policyUid;
    private final long version;

    public CloudPolicyUrlInfo(String policyUid, long j10, String str) {
        g.f(policyUid, "policyUid");
        this.policyUid = policyUid;
        this.version = j10;
        this.category = str;
    }

    public static /* synthetic */ CloudPolicyUrlInfo copy$default(CloudPolicyUrlInfo cloudPolicyUrlInfo, String str, long j10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cloudPolicyUrlInfo.policyUid;
        }
        if ((i10 & 2) != 0) {
            j10 = cloudPolicyUrlInfo.version;
        }
        if ((i10 & 4) != 0) {
            str2 = cloudPolicyUrlInfo.category;
        }
        return cloudPolicyUrlInfo.copy(str, j10, str2);
    }

    public final String component1() {
        return this.policyUid;
    }

    public final long component2() {
        return this.version;
    }

    public final String component3() {
        return this.category;
    }

    public final CloudPolicyUrlInfo copy(String policyUid, long j10, String str) {
        g.f(policyUid, "policyUid");
        return new CloudPolicyUrlInfo(policyUid, j10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudPolicyUrlInfo)) {
            return false;
        }
        CloudPolicyUrlInfo cloudPolicyUrlInfo = (CloudPolicyUrlInfo) obj;
        return g.b(this.policyUid, cloudPolicyUrlInfo.policyUid) && this.version == cloudPolicyUrlInfo.version && g.b(this.category, cloudPolicyUrlInfo.category);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getPolicyUid() {
        return this.policyUid;
    }

    public final long getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iC = a.c(this.policyUid.hashCode() * 31, this.version, 31);
        String str = this.category;
        return iC + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CloudPolicyUrlInfo(policyUid=");
        sb2.append(this.policyUid);
        sb2.append(", version=");
        sb2.append(this.version);
        sb2.append(", category=");
        return ai.onnxruntime.a.n(sb2, this.category, ')');
    }
}
