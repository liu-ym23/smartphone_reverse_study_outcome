package com.stepos.ailauncher.agent.aispace.connect.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/h;", "", "", "title", "description", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/i;", "agents", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.h, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentEntranceGroup {

    @SerializedName("agents")
    private final List<AgentEntranceItem> agents;

    @SerializedName("description")
    private final String description;

    @SerializedName("title")
    private final String title;

    public AgentEntranceGroup() {
        this(null, null, null, 7, null);
    }

    public final List<AgentEntranceItem> a() {
        return this.agents;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentEntranceGroup)) {
            return false;
        }
        AgentEntranceGroup agentEntranceGroup = (AgentEntranceGroup) other;
        return kotlin.jvm.internal.p.d(this.title, agentEntranceGroup.title) && kotlin.jvm.internal.p.d(this.description, agentEntranceGroup.description) && kotlin.jvm.internal.p.d(this.agents, agentEntranceGroup.agents);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.agents.hashCode();
    }

    public String toString() {
        return "AgentEntranceGroup(title=" + this.title + ", description=" + this.description + ", agents=" + this.agents + ")";
    }

    public AgentEntranceGroup(String title, String description, List<AgentEntranceItem> agents) {
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(agents, "agents");
        this.title = title;
        this.description = description;
        this.agents = agents;
    }

    public /* synthetic */ AgentEntranceGroup(String str, String str2, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? C1173v.m() : list);
    }
}
