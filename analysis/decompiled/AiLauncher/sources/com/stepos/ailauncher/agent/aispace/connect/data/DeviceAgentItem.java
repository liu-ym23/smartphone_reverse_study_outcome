package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.sla.G;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/p;", "", "", "deviceId", "agent", "displayName", "", G.NETWORK_ONLINE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "Z", Const.INTENT_KEY_UMID, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.p, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DeviceAgentItem {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName(G.NETWORK_ONLINE)
    private final boolean online;

    public DeviceAgentItem() {
        this(null, null, null, false, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* renamed from: b, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceAgentItem)) {
            return false;
        }
        DeviceAgentItem deviceAgentItem = (DeviceAgentItem) other;
        return kotlin.jvm.internal.p.d(this.deviceId, deviceAgentItem.deviceId) && kotlin.jvm.internal.p.d(this.agent, deviceAgentItem.agent) && kotlin.jvm.internal.p.d(this.displayName, deviceAgentItem.displayName) && this.online == deviceAgentItem.online;
    }

    public int hashCode() {
        int iHashCode = ((this.deviceId.hashCode() * 31) + this.agent.hashCode()) * 31;
        String str = this.displayName;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.online);
    }

    public String toString() {
        return "DeviceAgentItem(deviceId=" + this.deviceId + ", agent=" + this.agent + ", displayName=" + this.displayName + ", online=" + this.online + ")";
    }

    public DeviceAgentItem(String deviceId, String agent, String str, boolean z10) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        this.deviceId = deviceId;
        this.agent = agent;
        this.displayName = str;
        this.online = z10;
    }

    public /* synthetic */ DeviceAgentItem(String str, String str2, String str3, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? true : z10);
    }
}
