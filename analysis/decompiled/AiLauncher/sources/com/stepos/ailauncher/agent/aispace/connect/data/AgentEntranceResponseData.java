package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/j;", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/h;", ConnectedAgentsActivity.FILTER_STEPAI, "otherAgents", "Lcom/stepos/ailauncher/agent/aispace/connect/data/k;", W4.b.STEP_INSTALL, "<init>", "(Lcom/stepos/ailauncher/agent/aispace/connect/data/h;Lcom/stepos/ailauncher/agent/aispace/connect/data/h;Lcom/stepos/ailauncher/agent/aispace/connect/data/k;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/aispace/connect/data/h;", "c", "()Lcom/stepos/ailauncher/agent/aispace/connect/data/h;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/agent/aispace/connect/data/k;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/connect/data/k;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentEntranceResponseData {

    @SerializedName(W4.b.STEP_INSTALL)
    private final AgentInstallConfig install;

    @SerializedName("other_agents")
    private final AgentEntranceGroup otherAgents;

    @SerializedName(ConnectedAgentsActivity.FILTER_STEPAI)
    private final AgentEntranceGroup stepai;

    public AgentEntranceResponseData() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final AgentInstallConfig getInstall() {
        return this.install;
    }

    /* renamed from: b, reason: from getter */
    public final AgentEntranceGroup getOtherAgents() {
        return this.otherAgents;
    }

    /* renamed from: c, reason: from getter */
    public final AgentEntranceGroup getStepai() {
        return this.stepai;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentEntranceResponseData)) {
            return false;
        }
        AgentEntranceResponseData agentEntranceResponseData = (AgentEntranceResponseData) other;
        return kotlin.jvm.internal.p.d(this.stepai, agentEntranceResponseData.stepai) && kotlin.jvm.internal.p.d(this.otherAgents, agentEntranceResponseData.otherAgents) && kotlin.jvm.internal.p.d(this.install, agentEntranceResponseData.install);
    }

    public int hashCode() {
        AgentEntranceGroup agentEntranceGroup = this.stepai;
        int iHashCode = (agentEntranceGroup == null ? 0 : agentEntranceGroup.hashCode()) * 31;
        AgentEntranceGroup agentEntranceGroup2 = this.otherAgents;
        int iHashCode2 = (iHashCode + (agentEntranceGroup2 == null ? 0 : agentEntranceGroup2.hashCode())) * 31;
        AgentInstallConfig agentInstallConfig = this.install;
        return iHashCode2 + (agentInstallConfig != null ? agentInstallConfig.hashCode() : 0);
    }

    public String toString() {
        return "AgentEntranceResponseData(stepai=" + this.stepai + ", otherAgents=" + this.otherAgents + ", install=" + this.install + ")";
    }

    public AgentEntranceResponseData(AgentEntranceGroup agentEntranceGroup, AgentEntranceGroup agentEntranceGroup2, AgentInstallConfig agentInstallConfig) {
        this.stepai = agentEntranceGroup;
        this.otherAgents = agentEntranceGroup2;
        this.install = agentInstallConfig;
    }

    public /* synthetic */ AgentEntranceResponseData(AgentEntranceGroup agentEntranceGroup, AgentEntranceGroup agentEntranceGroup2, AgentInstallConfig agentInstallConfig, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : agentEntranceGroup, (i10 & 2) != 0 ? null : agentEntranceGroup2, (i10 & 4) != 0 ? null : agentInstallConfig);
    }
}
