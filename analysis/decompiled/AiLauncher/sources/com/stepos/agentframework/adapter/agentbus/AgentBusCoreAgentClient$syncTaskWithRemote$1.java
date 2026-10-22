package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient", f = "AgentBusCoreAgentClient.kt", l = {1534}, m = "syncTaskWithRemote", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$syncTaskWithRemote$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$syncTaskWithRemote$1(AgentBusCoreAgentClient agentBusCoreAgentClient, InterfaceC4014c<? super AgentBusCoreAgentClient$syncTaskWithRemote$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, this);
    }
}
