package com.stepos.policy.sdk.bean;

import B7.a;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyRecordBaseInfo;", "", QueryAlgorithmBundle.KEY_CATEGORY, "", "policyId", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getPolicyId", "setPolicyId", "getVersion", "setVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PolicyRecordBaseInfo {
    private String category;
    private String policyId;
    private String version;

    public PolicyRecordBaseInfo() {
        this(null, null, null, 7, null);
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

    /* renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPolicyId() {
        return this.policyId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final PolicyRecordBaseInfo copy(String category, String policyId, String version) {
        k.f(category, "category");
        k.f(policyId, "policyId");
        k.f(version, "version");
        return new PolicyRecordBaseInfo(category, policyId, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyRecordBaseInfo)) {
            return false;
        }
        PolicyRecordBaseInfo policyRecordBaseInfo = (PolicyRecordBaseInfo) other;
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
        return this.version.hashCode() + a.c(this.category.hashCode() * 31, 31, this.policyId);
    }

    public final void setCategory(String str) {
        k.f(str, "<set-?>");
        this.category = str;
    }

    public final void setPolicyId(String str) {
        k.f(str, "<set-?>");
        this.policyId = str;
    }

    public final void setVersion(String str) {
        k.f(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyRecordBaseInfo(category=");
        sb.append(this.category);
        sb.append(", policyId=");
        sb.append(this.policyId);
        sb.append(", version=");
        return a.g(')', this.version, sb);
    }

    public PolicyRecordBaseInfo(String category, String policyId, String version) {
        k.f(category, "category");
        k.f(policyId, "policyId");
        k.f(version, "version");
        this.category = category;
        this.policyId = policyId;
        this.version = version;
    }

    public /* synthetic */ PolicyRecordBaseInfo(String str, String str2, String str3, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
