package com.stepos.agentframework.chatcore.agents;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.AgentBusClient", f = "AgentBusClient.kt", l = {419}, m = "batchDeleteTasks", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusClient$batchDeleteTasks$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentBusClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusClient$batchDeleteTasks$1(AgentBusClient agentBusClient, InterfaceC4014c<? super AgentBusClient$batchDeleteTasks$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentBusClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
