package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding", f = "ClawChannelAgentBusBinding.kt", l = {819}, m = "sendMessageInternal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding$sendMessageInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClawChannelAgentBusBinding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClawChannelAgentBusBinding$sendMessageInternal$1(ClawChannelAgentBusBinding clawChannelAgentBusBinding, InterfaceC4014c<? super ClawChannelAgentBusBinding$sendMessageInternal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = clawChannelAgentBusBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.M(null, null, null, null, this);
    }
}
