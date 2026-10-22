package com.stepos.ailauncher.agent.skill;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillOperaParams;", "Ljava/io/Serializable;", "", "", "skillNames", "envId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSkillNames", "()Ljava/util/List;", "Ljava/lang/String;", "getEnvId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillOperaParams implements Serializable {
    private final String envId;
    private final List<String> skillNames;

    public SkillOperaParams(List<String> skillNames, String envId) {
        p.i(skillNames, "skillNames");
        p.i(envId, "envId");
        this.skillNames = skillNames;
        this.envId = envId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillOperaParams)) {
            return false;
        }
        SkillOperaParams skillOperaParams = (SkillOperaParams) other;
        return p.d(this.skillNames, skillOperaParams.skillNames) && p.d(this.envId, skillOperaParams.envId);
    }

    public int hashCode() {
        return (this.skillNames.hashCode() * 31) + this.envId.hashCode();
    }

    public String toString() {
        return "SkillOperaParams(skillNames=" + this.skillNames + ", envId=" + this.envId + ")";
    }

    public /* synthetic */ SkillOperaParams(List list, String str, int i10, i iVar) {
        this(list, (i10 & 2) != 0 ? "" : str);
    }
}
