package com.stepos.policy.sdk.bean;

import j4.k;

/* loaded from: classes.dex */
public final class CloudPolicyUrlInfo {
    private final String category;
    private final String policyUid;
    private final long version;

    public CloudPolicyUrlInfo(String str, long j5, String str2) {
        k.g(str, "policyUid");
        this.policyUid = str;
        this.version = j5;
        this.category = str2;
    }

    public static /* synthetic */ CloudPolicyUrlInfo copy$default(CloudPolicyUrlInfo cloudPolicyUrlInfo, String str, long j5, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = cloudPolicyUrlInfo.policyUid;
        }
        if ((i5 & 2) != 0) {
            j5 = cloudPolicyUrlInfo.version;
        }
        if ((i5 & 4) != 0) {
            str2 = cloudPolicyUrlInfo.category;
        }
        return cloudPolicyUrlInfo.copy(str, j5, str2);
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

    public final CloudPolicyUrlInfo copy(String str, long j5, String str2) {
        k.g(str, "policyUid");
        return new CloudPolicyUrlInfo(str, j5, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudPolicyUrlInfo)) {
            return false;
        }
        CloudPolicyUrlInfo cloudPolicyUrlInfo = (CloudPolicyUrlInfo) obj;
        return k.b(this.policyUid, cloudPolicyUrlInfo.policyUid) && this.version == cloudPolicyUrlInfo.version && k.b(this.category, cloudPolicyUrlInfo.category);
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
        int iHashCode = ((this.policyUid.hashCode() * 31) + Long.hashCode(this.version)) * 31;
        String str = this.category;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CloudPolicyUrlInfo(policyUid=" + this.policyUid + ", version=" + this.version + ", category=" + this.category + ')';
    }
}
