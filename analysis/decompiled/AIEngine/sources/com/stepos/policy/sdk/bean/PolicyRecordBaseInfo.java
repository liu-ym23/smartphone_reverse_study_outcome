package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyRecordBaseInfo {
    private String category;
    private String policyId;
    private String version;

    public PolicyRecordBaseInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PolicyRecordBaseInfo copy$default(PolicyRecordBaseInfo policyRecordBaseInfo, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = policyRecordBaseInfo.category;
        }
        if ((i10 & 2) != 0) {
            str2 = policyRecordBaseInfo.policyId;
        }
        if ((i10 & 4) != 0) {
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

    public final PolicyRecordBaseInfo copy(String category, String policyId, String version) {
        g.f(category, "category");
        g.f(policyId, "policyId");
        g.f(version, "version");
        return new PolicyRecordBaseInfo(category, policyId, version);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyRecordBaseInfo)) {
            return false;
        }
        PolicyRecordBaseInfo policyRecordBaseInfo = (PolicyRecordBaseInfo) obj;
        return g.b(this.category, policyRecordBaseInfo.category) && g.b(this.policyId, policyRecordBaseInfo.policyId) && g.b(this.version, policyRecordBaseInfo.version);
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
        return this.version.hashCode() + d.a(this.category.hashCode() * 31, 31, this.policyId);
    }

    public final void setCategory(String str) {
        g.f(str, "<set-?>");
        this.category = str;
    }

    public final void setPolicyId(String str) {
        g.f(str, "<set-?>");
        this.policyId = str;
    }

    public final void setVersion(String str) {
        g.f(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyRecordBaseInfo(category=");
        sb2.append(this.category);
        sb2.append(", policyId=");
        sb2.append(this.policyId);
        sb2.append(", version=");
        return a.n(sb2, this.version, ')');
    }

    public PolicyRecordBaseInfo(String category, String policyId, String version) {
        g.f(category, "category");
        g.f(policyId, "policyId");
        g.f(version, "version");
        this.category = category;
        this.policyId = policyId;
        this.version = version;
    }

    public /* synthetic */ PolicyRecordBaseInfo(String str, String str2, String str3, int i10, e eVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
    }
}
