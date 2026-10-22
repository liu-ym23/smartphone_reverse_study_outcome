package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/view/Y8;", "", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "sessions", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "agents", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.Y8, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SidebarSnapshot {
    private final List<IExternalAgentBindService.SidebarAgent> agents;
    private final List<SidebarSession> sessions;

    public SidebarSnapshot(List<SidebarSession> sessions, List<IExternalAgentBindService.SidebarAgent> agents) {
        kotlin.jvm.internal.p.i(sessions, "sessions");
        kotlin.jvm.internal.p.i(agents, "agents");
        this.sessions = sessions;
        this.agents = agents;
    }

    public final List<IExternalAgentBindService.SidebarAgent> a() {
        return this.agents;
    }

    public final List<SidebarSession> b() {
        return this.sessions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SidebarSnapshot)) {
            return false;
        }
        SidebarSnapshot sidebarSnapshot = (SidebarSnapshot) other;
        return kotlin.jvm.internal.p.d(this.sessions, sidebarSnapshot.sessions) && kotlin.jvm.internal.p.d(this.agents, sidebarSnapshot.agents);
    }

    public int hashCode() {
        return (this.sessions.hashCode() * 31) + this.agents.hashCode();
    }

    public String toString() {
        return "SidebarSnapshot(sessions=" + this.sessions + ", agents=" + this.agents + ")";
    }
}
