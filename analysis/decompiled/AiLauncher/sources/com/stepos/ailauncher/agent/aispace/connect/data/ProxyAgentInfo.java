package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.sla.G;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001e\u0010\u0011R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\u0013R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b$\u0010\u0011¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/w;", "", "", "deviceId", "agent", "displayName", "", G.NETWORK_ONLINE, "agentId", "", "pinned", "", "updateAt", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IJLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "Z", "f", "()Z", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_BACKGROUND_COMMAND, "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()J", "e", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.w, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ProxyAgentInfo {

    @SerializedName("agent")
    private final String agent;

    @SerializedName("agent_id")
    private final String agentId;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("icon")
    private final String icon;

    @SerializedName(G.NETWORK_ONLINE)
    private final boolean online;

    @SerializedName("pinned")
    private final int pinned;

    @SerializedName("updateat")
    private final long updateAt;

    public ProxyAgentInfo() {
        this(null, null, null, false, null, 0, 0L, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* renamed from: b, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: d, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: e, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProxyAgentInfo)) {
            return false;
        }
        ProxyAgentInfo proxyAgentInfo = (ProxyAgentInfo) other;
        return kotlin.jvm.internal.p.d(this.deviceId, proxyAgentInfo.deviceId) && kotlin.jvm.internal.p.d(this.agent, proxyAgentInfo.agent) && kotlin.jvm.internal.p.d(this.displayName, proxyAgentInfo.displayName) && this.online == proxyAgentInfo.online && kotlin.jvm.internal.p.d(this.agentId, proxyAgentInfo.agentId) && this.pinned == proxyAgentInfo.pinned && this.updateAt == proxyAgentInfo.updateAt && kotlin.jvm.internal.p.d(this.icon, proxyAgentInfo.icon);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    /* renamed from: g, reason: from getter */
    public final int getPinned() {
        return this.pinned;
    }

    /* renamed from: h, reason: from getter */
    public final long getUpdateAt() {
        return this.updateAt;
    }

    public int hashCode() {
        int iHashCode = ((this.deviceId.hashCode() * 31) + this.agent.hashCode()) * 31;
        String str = this.displayName;
        return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.online)) * 31) + this.agentId.hashCode()) * 31) + Integer.hashCode(this.pinned)) * 31) + Long.hashCode(this.updateAt)) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "ProxyAgentInfo(deviceId=" + this.deviceId + ", agent=" + this.agent + ", displayName=" + this.displayName + ", online=" + this.online + ", agentId=" + this.agentId + ", pinned=" + this.pinned + ", updateAt=" + this.updateAt + ", icon=" + this.icon + ")";
    }

    public ProxyAgentInfo(String deviceId, String agent, String str, boolean z10, String agentId, int i10, long j10, String icon) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(icon, "icon");
        this.deviceId = deviceId;
        this.agent = agent;
        this.displayName = str;
        this.online = z10;
        this.agentId = agentId;
        this.pinned = i10;
        this.updateAt = j10;
        this.icon = icon;
    }

    public /* synthetic */ ProxyAgentInfo(String str, String str2, String str3, boolean z10, String str4, int i10, long j10, String str5, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? true : z10, (i11 & 16) != 0 ? "" : str4, (i11 & 32) != 0 ? 0 : i10, (i11 & 64) != 0 ? 0L : j10, (i11 & 128) != 0 ? "" : str5);
    }
}
