package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/B;", "", "", "assetId", "", x5.d.EXTRA_ENABLED, "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAssetId", "Z", "getEnabled", "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.B, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SetAgentEnabledRequest {

    @SerializedName("asset_id")
    private final String assetId;

    @SerializedName(x5.d.EXTRA_ENABLED)
    private final boolean enabled;

    public SetAgentEnabledRequest(String assetId, boolean z10) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        this.assetId = assetId;
        this.enabled = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetAgentEnabledRequest)) {
            return false;
        }
        SetAgentEnabledRequest setAgentEnabledRequest = (SetAgentEnabledRequest) other;
        return kotlin.jvm.internal.p.d(this.assetId, setAgentEnabledRequest.assetId) && this.enabled == setAgentEnabledRequest.enabled;
    }

    public int hashCode() {
        return (this.assetId.hashCode() * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "SetAgentEnabledRequest(assetId=" + this.assetId + ", enabled=" + this.enabled + ")";
    }
}
