package com.stepos.agentbus.generated;

import S7.k;
import com.stepos.agentbus.generated.AgentBusBindingBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3448a;
    public final /* synthetic */ AgentBusBindingBase b;

    public /* synthetic */ a(AgentBusBindingBase agentBusBindingBase, int i) {
        this.f3448a = i;
        this.b = agentBusBindingBase;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3448a;
        AgentBusBindingBase agentBusBindingBase = this.b;
        AgentBusBindingBase.ConnectionStatus connectionStatus = (AgentBusBindingBase.ConnectionStatus) obj;
        switch (i) {
            case 0:
                return AgentBusBindingBase$connectAndServe$inboundDispatcher$1.invokeSuspend$lambda$0(agentBusBindingBase, connectionStatus);
            case 1:
                return AgentBusBindingBase.connectAndServe$lambda$2(agentBusBindingBase, connectionStatus);
            case 2:
                return AgentBusBindingBase.connectAndServe$lambda$3(agentBusBindingBase, connectionStatus);
            case 3:
                return AgentBusBindingBase.runForever$lambda$1(agentBusBindingBase, connectionStatus);
            case 4:
                return AgentBusBindingBase.writeFrame$lambda$0$0(agentBusBindingBase, connectionStatus);
            default:
                return AgentBusBindingBase.writeFrame$lambda$0$1(agentBusBindingBase, connectionStatus);
        }
    }
}
