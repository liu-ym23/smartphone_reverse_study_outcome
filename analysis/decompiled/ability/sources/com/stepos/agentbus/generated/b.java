package com.stepos.agentbus.generated;

import S7.k;
import com.stepos.agentbus.generated.AgentBusBindingBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3449a;

    public /* synthetic */ b(int i) {
        this.f3449a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        AgentBusBindingBase.ConnectionStatus connectionStatus = (AgentBusBindingBase.ConnectionStatus) obj;
        switch (this.f3449a) {
            case 0:
                return AgentBusBindingBase$connectAndServe$inboundDispatcher$1.invokeSuspend$lambda$1(connectionStatus);
            case 1:
                return AgentBusBindingBase.connectAndServe$lambda$0(connectionStatus);
            case 2:
                return AgentBusBindingBase.connectAndServe$lambda$4(connectionStatus);
            case 3:
                return AgentBusBindingBase.runForever$lambda$0(connectionStatus);
            default:
                return AgentBusBindingBase.writeFrame$lambda$2(connectionStatus);
        }
    }
}
