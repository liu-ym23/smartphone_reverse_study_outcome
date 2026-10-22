package com.stepos.policy.sdk.bean;

import androidx.appfunctions.metadata.a;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/policy/sdk/bean/CloudPolicyUrlInfo;", "", "policyUid", "", "version", "", QueryAlgorithmBundle.KEY_CATEGORY, "(Ljava/lang/String;JLjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getPolicyUid", "getVersion", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CloudPolicyUrlInfo {
    private final String category;
    private final String policyUid;
    private final long version;

    public CloudPolicyUrlInfo(String policyUid, long j5, String str) {
        k.f(policyUid, "policyUid");
        this.policyUid = policyUid;
        this.version = j5;
        this.category = str;
    }

    public static /* synthetic */ CloudPolicyUrlInfo copy$default(CloudPolicyUrlInfo cloudPolicyUrlInfo, String str, long j5, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudPolicyUrlInfo.policyUid;
        }
        if ((i & 2) != 0) {
            j5 = cloudPolicyUrlInfo.version;
        }
        if ((i & 4) != 0) {
            str2 = cloudPolicyUrlInfo.category;
        }
        return cloudPolicyUrlInfo.copy(str, j5, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPolicyUid() {
        return this.policyUid;
    }

    /* renamed from: component2, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    public final CloudPolicyUrlInfo copy(String policyUid, long version, String category) {
        k.f(policyUid, "policyUid");
        return new CloudPolicyUrlInfo(policyUid, version, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudPolicyUrlInfo)) {
            return false;
        }
        CloudPolicyUrlInfo cloudPolicyUrlInfo = (CloudPolicyUrlInfo) other;
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
        int iC = a.c(this.policyUid.hashCode() * 31, 31, this.version);
        String str = this.category;
        return iC + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CloudPolicyUrlInfo(policyUid=");
        sb.append(this.policyUid);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", category=");
        return B7.a.g(')', this.category, sb);
    }
}
