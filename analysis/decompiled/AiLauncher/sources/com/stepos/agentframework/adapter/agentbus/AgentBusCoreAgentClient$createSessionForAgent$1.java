package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient", f = "AgentBusCoreAgentClient.kt", l = {1345, 3463, 1366, 3473, 3473, 3473}, m = "createSessionForAgent", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$createSessionForAgent$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$createSessionForAgent$1(AgentBusCoreAgentClient agentBusCoreAgentClient, InterfaceC4014c<? super AgentBusCoreAgentClient$createSessionForAgent$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
