package com.stepos.ailauncher.agent.aispace.connect.data;

import com.google.gson.annotations.SerializedName;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/x;", "", "", "deviceId", "agent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgent", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.x, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class QueryDeviceAgentOnlineRequest {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    public QueryDeviceAgentOnlineRequest(String deviceId, String agent) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        this.deviceId = deviceId;
        this.agent = agent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryDeviceAgentOnlineRequest)) {
            return false;
        }
        QueryDeviceAgentOnlineRequest queryDeviceAgentOnlineRequest = (QueryDeviceAgentOnlineRequest) other;
        return kotlin.jvm.internal.p.d(this.deviceId, queryDeviceAgentOnlineRequest.deviceId) && kotlin.jvm.internal.p.d(this.agent, queryDeviceAgentOnlineRequest.agent);
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.agent.hashCode();
    }

    public String toString() {
        return "QueryDeviceAgentOnlineRequest(deviceId=" + this.deviceId + ", agent=" + this.agent + ")";
    }
}
