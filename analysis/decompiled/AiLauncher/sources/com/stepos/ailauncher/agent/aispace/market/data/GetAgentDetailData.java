package com.stepos.ailauncher.agent.aispace.market.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/h;", "", "Lcom/stepos/ailauncher/agent/aispace/market/data/b;", "agent", "", "Lcom/stepos/ailauncher/agent/aispace/market/data/f;", "skills", "<init>", "(Lcom/stepos/ailauncher/agent/aispace/market/data/b;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/aispace/market/data/b;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/market/data/b;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.h, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetAgentDetailData {

    @SerializedName("agent")
    private final AgentMarketItemDto agent;

    @SerializedName("skills")
    private final List<AgentSkillDto> skills;

    /* JADX WARN: Multi-variable type inference failed */
    public GetAgentDetailData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final AgentMarketItemDto getAgent() {
        return this.agent;
    }

    public final List<AgentSkillDto> b() {
        return this.skills;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetAgentDetailData)) {
            return false;
        }
        GetAgentDetailData getAgentDetailData = (GetAgentDetailData) other;
        return kotlin.jvm.internal.p.d(this.agent, getAgentDetailData.agent) && kotlin.jvm.internal.p.d(this.skills, getAgentDetailData.skills);
    }

    public int hashCode() {
        AgentMarketItemDto agentMarketItemDto = this.agent;
        return ((agentMarketItemDto == null ? 0 : agentMarketItemDto.hashCode()) * 31) + this.skills.hashCode();
    }

    public String toString() {
        return "GetAgentDetailData(agent=" + this.agent + ", skills=" + this.skills + ")";
    }

    public GetAgentDetailData(AgentMarketItemDto agentMarketItemDto, List<AgentSkillDto> skills) {
        kotlin.jvm.internal.p.i(skills, "skills");
        this.agent = agentMarketItemDto;
        this.skills = skills;
    }

    public /* synthetic */ GetAgentDetailData(AgentMarketItemDto agentMarketItemDto, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : agentMarketItemDto, (i10 & 2) != 0 ? C1173v.m() : list);
    }
}
