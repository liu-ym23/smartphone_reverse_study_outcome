package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.task.space.C3577a2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/j;", "", "Lcom/stepos/ailauncher/agent/aispace/market/data/f;", C3577a2.TYPE_SKILL, "<init>", "(Lcom/stepos/ailauncher/agent/aispace/market/data/f;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/aispace/market/data/f;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/market/data/f;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetAgentSkillDetailData {

    @SerializedName(C3577a2.TYPE_SKILL)
    private final AgentSkillDto skill;

    /* JADX WARN: Multi-variable type inference failed */
    public GetAgentSkillDetailData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final AgentSkillDto getSkill() {
        return this.skill;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetAgentSkillDetailData) && kotlin.jvm.internal.p.d(this.skill, ((GetAgentSkillDetailData) other).skill);
    }

    public int hashCode() {
        AgentSkillDto agentSkillDto = this.skill;
        if (agentSkillDto == null) {
            return 0;
        }
        return agentSkillDto.hashCode();
    }

    public String toString() {
        return "GetAgentSkillDetailData(skill=" + this.skill + ")";
    }

    public GetAgentSkillDetailData(AgentSkillDto agentSkillDto) {
        this.skill = agentSkillDto;
    }

    public /* synthetic */ GetAgentSkillDetailData(AgentSkillDto agentSkillDto, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : agentSkillDto);
    }
}
