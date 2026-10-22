package com.stepos.ailauncher.task.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter", f = "AgentBusEventRouter.kt", l = {503}, m = "pushCardToLiveViews", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$pushCardToLiveViews$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentBusEventRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$pushCardToLiveViews$1(AgentBusEventRouter agentBusEventRouter, InterfaceC4014c<? super AgentBusEventRouter$pushCardToLiveViews$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentBusEventRouter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.S(null, this);
    }
}
