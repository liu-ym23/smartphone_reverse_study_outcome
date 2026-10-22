package com.stepos.ailauncher.agent.aispace.market.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/t;", "", "", "Lcom/stepos/ailauncher/agent/aispace/market/data/e;", "skills", "", "total", "<init>", "(Ljava/util/List;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "I", Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.t, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetOrSearchSkillListData {

    @SerializedName("skills")
    private final List<AgentSkillBean> skills;

    @SerializedName("total")
    private final int total;

    /* JADX WARN: Multi-variable type inference failed */
    public GetOrSearchSkillListData() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public final List<AgentSkillBean> a() {
        return this.skills;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetOrSearchSkillListData)) {
            return false;
        }
        GetOrSearchSkillListData getOrSearchSkillListData = (GetOrSearchSkillListData) other;
        return kotlin.jvm.internal.p.d(this.skills, getOrSearchSkillListData.skills) && this.total == getOrSearchSkillListData.total;
    }

    public int hashCode() {
        return (this.skills.hashCode() * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "GetOrSearchSkillListData(skills=" + this.skills + ", total=" + this.total + ")";
    }

    public GetOrSearchSkillListData(List<AgentSkillBean> skills, int i10) {
        kotlin.jvm.internal.p.i(skills, "skills");
        this.skills = skills;
        this.total = i10;
    }

    public /* synthetic */ GetOrSearchSkillListData(List list, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? C1173v.m() : list, (i11 & 2) != 0 ? 0 : i10);
    }
}
