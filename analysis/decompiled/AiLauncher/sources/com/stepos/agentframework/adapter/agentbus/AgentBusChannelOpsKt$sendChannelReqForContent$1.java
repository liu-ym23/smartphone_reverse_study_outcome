package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt", f = "AgentBusChannelOps.kt", l = {213, 214}, m = "sendChannelReqForContent", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusChannelOpsKt$sendChannelReqForContent$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public AgentBusChannelOpsKt$sendChannelReqForContent$1(InterfaceC4014c<? super AgentBusChannelOpsKt$sendChannelReqForContent$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AgentBusChannelOpsKt.E(null, null, null, 0L, this);
    }
}
