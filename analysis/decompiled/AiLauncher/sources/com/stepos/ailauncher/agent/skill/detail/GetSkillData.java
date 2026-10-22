package com.stepos.ailauncher.agent.skill.detail;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.task.space.C3577a2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/detail/F;", C3577a2.TYPE_SKILL, "Lcom/stepos/ailauncher/agent/skill/detail/F;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/detail/F;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.detail.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetSkillData {

    @SerializedName(C3577a2.TYPE_SKILL)
    private final SkillDetailDto skill;

    /* renamed from: a, reason: from getter */
    public final SkillDetailDto getSkill() {
        return this.skill;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetSkillData) && kotlin.jvm.internal.p.d(this.skill, ((GetSkillData) other).skill);
    }

    public int hashCode() {
        SkillDetailDto skillDetailDto = this.skill;
        if (skillDetailDto == null) {
            return 0;
        }
        return skillDetailDto.hashCode();
    }

    public String toString() {
        return "GetSkillData(skill=" + this.skill + ")";
    }
}
