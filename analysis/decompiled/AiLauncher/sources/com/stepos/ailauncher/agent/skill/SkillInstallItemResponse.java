package com.stepos.ailauncher.agent.skill;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.task.space.C3577a2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillInstallItemResponse;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "msg", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "skillId", Const.INTENT_KEY_UMID, "code", "I", Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/agent/skill/SkillItem;", C3577a2.TYPE_SKILL, "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "c", "()Lcom/stepos/ailauncher/agent/skill/SkillItem;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillInstallItemResponse implements Serializable {
    private final int code;
    private final String msg;
    private final SkillItem skill;
    private final String skillId;

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: c, reason: from getter */
    public final SkillItem getSkill() {
        return this.skill;
    }

    /* renamed from: d, reason: from getter */
    public final String getSkillId() {
        return this.skillId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillInstallItemResponse)) {
            return false;
        }
        SkillInstallItemResponse skillInstallItemResponse = (SkillInstallItemResponse) other;
        return p.d(this.msg, skillInstallItemResponse.msg) && p.d(this.skillId, skillInstallItemResponse.skillId) && this.code == skillInstallItemResponse.code && p.d(this.skill, skillInstallItemResponse.skill);
    }

    public int hashCode() {
        String str = this.msg;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.skillId;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.code)) * 31;
        SkillItem skillItem = this.skill;
        return iHashCode2 + (skillItem != null ? skillItem.hashCode() : 0);
    }

    public String toString() {
        return "SkillInstallItemResponse(msg=" + this.msg + ", skillId=" + this.skillId + ", code=" + this.code + ", skill=" + this.skill + ")";
    }
}
