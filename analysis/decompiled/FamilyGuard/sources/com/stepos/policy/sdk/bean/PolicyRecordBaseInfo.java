package com.stepos.policy.sdk.bean;

import j4.g;
import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicyRecordBaseInfo {
    private String category;
    private String policyId;
    private String version;

    public PolicyRecordBaseInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PolicyRecordBaseInfo copy$default(PolicyRecordBaseInfo policyRecordBaseInfo, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = policyRecordBaseInfo.category;
        }
        if ((i5 & 2) != 0) {
            str2 = policyRecordBaseInfo.policyId;
        }
        if ((i5 & 4) != 0) {
            str3 = policyRecordBaseInfo.version;
        }
        return policyRecordBaseInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.category;
    }

    public final String component2() {
        return this.policyId;
    }

    public final String component3() {
        return this.version;
    }

    public final PolicyRecordBaseInfo copy(String str, String str2, String str3) {
        k.g(str, "category");
        k.g(str2, "policyId");
        k.g(str3, "version");
        return new PolicyRecordBaseInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyRecordBaseInfo)) {
            return false;
        }
        PolicyRecordBaseInfo policyRecordBaseInfo = (PolicyRecordBaseInfo) obj;
        return k.b(this.category, policyRecordBaseInfo.category) && k.b(this.policyId, policyRecordBaseInfo.policyId) && k.b(this.version, policyRecordBaseInfo.version);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getPolicyId() {
        return this.policyId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.category.hashCode() * 31) + this.policyId.hashCode()) * 31) + this.version.hashCode();
    }

    public final void setCategory(String str) {
        k.g(str, "<set-?>");
        this.category = str;
    }

    public final void setPolicyId(String str) {
        k.g(str, "<set-?>");
        this.policyId = str;
    }

    public final void setVersion(String str) {
        k.g(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "PolicyRecordBaseInfo(category=" + this.category + ", policyId=" + this.policyId + ", version=" + this.version + ')';
    }

    public PolicyRecordBaseInfo(String str, String str2, String str3) {
        k.g(str, "category");
        k.g(str2, "policyId");
        k.g(str3, "version");
        this.category = str;
        this.policyId = str2;
        this.version = str3;
    }

    public /* synthetic */ PolicyRecordBaseInfo(String str, String str2, String str3, int i5, g gVar) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str2, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str3);
    }
}
