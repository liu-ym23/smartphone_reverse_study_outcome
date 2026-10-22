package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.sla.G;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/y;", "", "", "deviceId", "agent", "", G.NETWORK_ONLINE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgent", "Z", Const.INTENT_KEY_APIKEY, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.y, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class QueryDeviceAgentOnlineResponseData {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName(G.NETWORK_ONLINE)
    private final boolean online;

    public QueryDeviceAgentOnlineResponseData() {
        this(null, null, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryDeviceAgentOnlineResponseData)) {
            return false;
        }
        QueryDeviceAgentOnlineResponseData queryDeviceAgentOnlineResponseData = (QueryDeviceAgentOnlineResponseData) other;
        return kotlin.jvm.internal.p.d(this.deviceId, queryDeviceAgentOnlineResponseData.deviceId) && kotlin.jvm.internal.p.d(this.agent, queryDeviceAgentOnlineResponseData.agent) && this.online == queryDeviceAgentOnlineResponseData.online;
    }

    public int hashCode() {
        String str = this.deviceId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.agent;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.online);
    }

    public String toString() {
        return "QueryDeviceAgentOnlineResponseData(deviceId=" + this.deviceId + ", agent=" + this.agent + ", online=" + this.online + ")";
    }

    public QueryDeviceAgentOnlineResponseData(String str, String str2, boolean z10) {
        this.deviceId = str;
        this.agent = str2;
        this.online = z10;
    }

    public /* synthetic */ QueryDeviceAgentOnlineResponseData(String str, String str2, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? false : z10);
    }
}
