package com.stepos.ailauncher.agent.aispace.connect.data;

import com.google.gson.annotations.SerializedName;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/n;", "", "", "deviceId", "agent", "", x5.d.EXTRA_ENABLED, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgent", "Z", "getEnabled", "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.n, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ChangeAgentStatusRequest {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName(x5.d.EXTRA_ENABLED)
    private final boolean enabled;

    public ChangeAgentStatusRequest(String deviceId, String agent, boolean z10) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        this.deviceId = deviceId;
        this.agent = agent;
        this.enabled = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangeAgentStatusRequest)) {
            return false;
        }
        ChangeAgentStatusRequest changeAgentStatusRequest = (ChangeAgentStatusRequest) other;
        return kotlin.jvm.internal.p.d(this.deviceId, changeAgentStatusRequest.deviceId) && kotlin.jvm.internal.p.d(this.agent, changeAgentStatusRequest.agent) && this.enabled == changeAgentStatusRequest.enabled;
    }

    public int hashCode() {
        return (((this.deviceId.hashCode() * 31) + this.agent.hashCode()) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "ChangeAgentStatusRequest(deviceId=" + this.deviceId + ", agent=" + this.agent + ", enabled=" + this.enabled + ")";
    }
}
