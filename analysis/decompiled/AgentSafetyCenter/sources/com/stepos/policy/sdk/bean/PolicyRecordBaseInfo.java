package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import k0.a;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyRecordBaseInfo {
    private String category;
    private String policyId;
    private String version;

    public /* synthetic */ PolicyRecordBaseInfo(String str, String str2, String str3, int i, f fVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ PolicyRecordBaseInfo copy$default(PolicyRecordBaseInfo policyRecordBaseInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = policyRecordBaseInfo.category;
        }
        if ((i & 2) != 0) {
            str2 = policyRecordBaseInfo.policyId;
        }
        if ((i & 4) != 0) {
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
        str.getClass();
        str2.getClass();
        str3.getClass();
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
        return k.a(this.category, policyRecordBaseInfo.category) && k.a(this.policyId, policyRecordBaseInfo.policyId) && k.a(this.version, policyRecordBaseInfo.version);
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
        return this.version.hashCode() + b.d(this.category.hashCode() * 31, 31, this.policyId);
    }

    public final void setCategory(String str) {
        str.getClass();
        this.category = str;
    }

    public final void setPolicyId(String str) {
        str.getClass();
        this.policyId = str;
    }

    public final void setVersion(String str) {
        str.getClass();
        this.version = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyRecordBaseInfo(category=");
        sb2.append(this.category);
        sb2.append(", policyId=");
        sb2.append(this.policyId);
        sb2.append(", version=");
        return a.s(sb2, this.version, ')');
    }

    public PolicyRecordBaseInfo(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.category = str;
        this.policyId = str2;
        this.version = str3;
    }

    public PolicyRecordBaseInfo() {
        this(null, null, null, 7, null);
    }
}
