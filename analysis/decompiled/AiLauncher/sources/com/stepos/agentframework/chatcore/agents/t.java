package com.stepos.agentframework.chatcore.agents;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.C1963x;
import com.stepos.agentframework.chatcore.session.SessionConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/t;", "Lcom/stepos/agentframework/chatcore/agents/m;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "config", "Lcom/stepos/agentframework/chatcore/agents/u;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/SessionConfig;)Lcom/stepos/agentframework/chatcore/agents/u;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class t implements m {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    @Override // com.stepos.agentframework.chatcore.agents.m
    public u a(SessionConfig config) {
        kotlin.jvm.internal.p.i(config, "config");
        String agentType = config.getAgentType();
        switch (agentType.hashCode()) {
            case -934610874:
                if (agentType.equals("remote")) {
                    return new RemoteClient("");
                }
                break;
            case -504196183:
                if (agentType.equals(C1963x.AGENT_TYPE_OPENCLAW)) {
                    return new AgentOpenClawClient();
                }
                break;
            case 103145323:
                if (agentType.equals("local")) {
                    return new v();
                }
                break;
            case 151529406:
                if (agentType.equals(C1963x.AGENT_TYPE_AGENTBUS_BFF)) {
                    return new ABBffClient();
                }
                break;
            case 1469161819:
                if (agentType.equals(C1963x.AGENT_TYPE_AGENTBUS)) {
                    return new AgentBusClient();
                }
                break;
        }
        return new ThirdPartClient();
    }
}
