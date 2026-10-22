package com.stepos.ailauncher.agent.aispace.connect.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/C;", "", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/w;", "proxyAgents", "Lcom/stepos/ailauncher/agent/aispace/connect/data/v;", "openclawAgents", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.C, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SidebarAgentListData {

    @SerializedName("openclaw_agents")
    private final List<OpenClawAgentInfo> openclawAgents;

    @SerializedName("proxy_agents")
    private final List<ProxyAgentInfo> proxyAgents;

    /* JADX WARN: Multi-variable type inference failed */
    public SidebarAgentListData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<OpenClawAgentInfo> a() {
        return this.openclawAgents;
    }

    public final List<ProxyAgentInfo> b() {
        return this.proxyAgents;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SidebarAgentListData)) {
            return false;
        }
        SidebarAgentListData sidebarAgentListData = (SidebarAgentListData) other;
        return kotlin.jvm.internal.p.d(this.proxyAgents, sidebarAgentListData.proxyAgents) && kotlin.jvm.internal.p.d(this.openclawAgents, sidebarAgentListData.openclawAgents);
    }

    public int hashCode() {
        return (this.proxyAgents.hashCode() * 31) + this.openclawAgents.hashCode();
    }

    public String toString() {
        return "SidebarAgentListData(proxyAgents=" + this.proxyAgents + ", openclawAgents=" + this.openclawAgents + ")";
    }

    public SidebarAgentListData(List<ProxyAgentInfo> proxyAgents, List<OpenClawAgentInfo> openclawAgents) {
        kotlin.jvm.internal.p.i(proxyAgents, "proxyAgents");
        kotlin.jvm.internal.p.i(openclawAgents, "openclawAgents");
        this.proxyAgents = proxyAgents;
        this.openclawAgents = openclawAgents;
    }

    public /* synthetic */ SidebarAgentListData(List list, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? C1173v.m() : list2);
    }
}
