package com.stepos.ailauncher.agent.skill;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillInstallResponse;", "Ljava/io/Serializable;", "", "envId", "", "Lcom/stepos/ailauncher/agent/skill/SkillInstallItemResponse;", "results", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEnvId", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillInstallResponse implements Serializable {
    private final String envId;
    private final List<SkillInstallItemResponse> results;

    /* JADX WARN: Multi-variable type inference failed */
    public SkillInstallResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<SkillInstallItemResponse> a() {
        return this.results;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillInstallResponse)) {
            return false;
        }
        SkillInstallResponse skillInstallResponse = (SkillInstallResponse) other;
        return p.d(this.envId, skillInstallResponse.envId) && p.d(this.results, skillInstallResponse.results);
    }

    public int hashCode() {
        String str = this.envId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<SkillInstallItemResponse> list = this.results;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SkillInstallResponse(envId=" + this.envId + ", results=" + this.results + ")";
    }

    public SkillInstallResponse(String str, List<SkillInstallItemResponse> list) {
        this.envId = str;
        this.results = list;
    }

    public /* synthetic */ SkillInstallResponse(String str, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list);
    }
}
