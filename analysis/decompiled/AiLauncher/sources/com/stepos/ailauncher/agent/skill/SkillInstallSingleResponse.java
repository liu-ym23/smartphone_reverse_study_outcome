package com.stepos.ailauncher.agent.skill;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillInstallSingleResponse;", "Ljava/io/Serializable;", "", "envId", "Lcom/stepos/ailauncher/agent/skill/SkillInstallItemResponse;", "result", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillInstallItemResponse;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEnvId", "Lcom/stepos/ailauncher/agent/skill/SkillInstallItemResponse;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/SkillInstallItemResponse;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillInstallSingleResponse implements Serializable {
    private final String envId;
    private final SkillInstallItemResponse result;

    /* JADX WARN: Multi-variable type inference failed */
    public SkillInstallSingleResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final SkillInstallItemResponse getResult() {
        return this.result;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillInstallSingleResponse)) {
            return false;
        }
        SkillInstallSingleResponse skillInstallSingleResponse = (SkillInstallSingleResponse) other;
        return p.d(this.envId, skillInstallSingleResponse.envId) && p.d(this.result, skillInstallSingleResponse.result);
    }

    public int hashCode() {
        String str = this.envId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        SkillInstallItemResponse skillInstallItemResponse = this.result;
        return iHashCode + (skillInstallItemResponse != null ? skillInstallItemResponse.hashCode() : 0);
    }

    public String toString() {
        return "SkillInstallSingleResponse(envId=" + this.envId + ", result=" + this.result + ")";
    }

    public SkillInstallSingleResponse(String str, SkillInstallItemResponse skillInstallItemResponse) {
        this.envId = str;
        this.result = skillInstallItemResponse;
    }

    public /* synthetic */ SkillInstallSingleResponse(String str, SkillInstallItemResponse skillInstallItemResponse, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : skillInstallItemResponse);
    }
}
