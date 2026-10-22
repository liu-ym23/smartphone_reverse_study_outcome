package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\u000eR\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/w;", "", "", "installType", "assetId", "reversionId", "semver", "displayName", "", "testing", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInstallType", "getAssetId", "getReversionId", "getSemver", "getDisplayName", "Z", "getTesting", "()Z", "getIcon", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.w, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InstallOrUpdateAgentRequest {

    @SerializedName("asset_id")
    private final String assetId;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("install_type")
    private final String installType;

    @SerializedName("reversion_id")
    private final String reversionId;

    @SerializedName("semver")
    private final String semver;

    @SerializedName("testing")
    private final boolean testing;

    public InstallOrUpdateAgentRequest(String installType, String assetId, String reversionId, String semver, String displayName, boolean z10, String icon) {
        kotlin.jvm.internal.p.i(installType, "installType");
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(icon, "icon");
        this.installType = installType;
        this.assetId = assetId;
        this.reversionId = reversionId;
        this.semver = semver;
        this.displayName = displayName;
        this.testing = z10;
        this.icon = icon;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallOrUpdateAgentRequest)) {
            return false;
        }
        InstallOrUpdateAgentRequest installOrUpdateAgentRequest = (InstallOrUpdateAgentRequest) other;
        return kotlin.jvm.internal.p.d(this.installType, installOrUpdateAgentRequest.installType) && kotlin.jvm.internal.p.d(this.assetId, installOrUpdateAgentRequest.assetId) && kotlin.jvm.internal.p.d(this.reversionId, installOrUpdateAgentRequest.reversionId) && kotlin.jvm.internal.p.d(this.semver, installOrUpdateAgentRequest.semver) && kotlin.jvm.internal.p.d(this.displayName, installOrUpdateAgentRequest.displayName) && this.testing == installOrUpdateAgentRequest.testing && kotlin.jvm.internal.p.d(this.icon, installOrUpdateAgentRequest.icon);
    }

    public int hashCode() {
        return (((((((((((this.installType.hashCode() * 31) + this.assetId.hashCode()) * 31) + this.reversionId.hashCode()) * 31) + this.semver.hashCode()) * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.testing)) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "InstallOrUpdateAgentRequest(installType=" + this.installType + ", assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", semver=" + this.semver + ", displayName=" + this.displayName + ", testing=" + this.testing + ", icon=" + this.icon + ")";
    }
}
