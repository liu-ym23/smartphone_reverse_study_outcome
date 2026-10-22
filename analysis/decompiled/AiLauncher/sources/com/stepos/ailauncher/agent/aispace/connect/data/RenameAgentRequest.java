package com.stepos.ailauncher.agent.aispace.connect.data;

import com.google.gson.annotations.SerializedName;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/z;", "", "", "deviceId", "agent", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgent", "getDisplayName", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.z, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RenameAgentRequest {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    public RenameAgentRequest(String deviceId, String agent, String displayName) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        this.deviceId = deviceId;
        this.agent = agent;
        this.displayName = displayName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenameAgentRequest)) {
            return false;
        }
        RenameAgentRequest renameAgentRequest = (RenameAgentRequest) other;
        return kotlin.jvm.internal.p.d(this.deviceId, renameAgentRequest.deviceId) && kotlin.jvm.internal.p.d(this.agent, renameAgentRequest.agent) && kotlin.jvm.internal.p.d(this.displayName, renameAgentRequest.displayName);
    }

    public int hashCode() {
        return (((this.deviceId.hashCode() * 31) + this.agent.hashCode()) * 31) + this.displayName.hashCode();
    }

    public String toString() {
        return "RenameAgentRequest(deviceId=" + this.deviceId + ", agent=" + this.agent + ", displayName=" + this.displayName + ")";
    }
}
