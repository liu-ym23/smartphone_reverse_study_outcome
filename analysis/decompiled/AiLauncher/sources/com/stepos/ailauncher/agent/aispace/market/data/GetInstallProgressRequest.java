package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/q;", "", "", "assetId", "reversionId", "installType", "semver", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAssetId", "getReversionId", "getInstallType", "getSemver", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.q, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetInstallProgressRequest {

    @SerializedName("asset_id")
    private final String assetId;

    @SerializedName("install_type")
    private final String installType;

    @SerializedName("reversion_id")
    private final String reversionId;

    @SerializedName("semver")
    private final String semver;

    public GetInstallProgressRequest(String assetId, String reversionId, String installType, String semver) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(installType, "installType");
        kotlin.jvm.internal.p.i(semver, "semver");
        this.assetId = assetId;
        this.reversionId = reversionId;
        this.installType = installType;
        this.semver = semver;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetInstallProgressRequest)) {
            return false;
        }
        GetInstallProgressRequest getInstallProgressRequest = (GetInstallProgressRequest) other;
        return kotlin.jvm.internal.p.d(this.assetId, getInstallProgressRequest.assetId) && kotlin.jvm.internal.p.d(this.reversionId, getInstallProgressRequest.reversionId) && kotlin.jvm.internal.p.d(this.installType, getInstallProgressRequest.installType) && kotlin.jvm.internal.p.d(this.semver, getInstallProgressRequest.semver);
    }

    public int hashCode() {
        return (((((this.assetId.hashCode() * 31) + this.reversionId.hashCode()) * 31) + this.installType.hashCode()) * 31) + this.semver.hashCode();
    }

    public String toString() {
        return "GetInstallProgressRequest(assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", installType=" + this.installType + ", semver=" + this.semver + ")";
    }
}
