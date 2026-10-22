package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt", f = "AgentBusChannelOps.kt", l = {177}, m = "awaitRegenerateAck", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusChannelOpsKt$awaitRegenerateAck$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public AgentBusChannelOpsKt$awaitRegenerateAck$1(InterfaceC4014c<? super AgentBusChannelOpsKt$awaitRegenerateAck$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AgentBusChannelOpsKt.e(null, null, 0L, this);
    }
}
