package com.stepos.agentframework.adapter.agentbus;

import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi", f = "ClawChannelAgentBusBinding.kt", l = {250, 251}, m = "send", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding$BffApi$send$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClawChannelAgentBusBinding.BffApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClawChannelAgentBusBinding$BffApi$send$1(ClawChannelAgentBusBinding.BffApi bffApi, InterfaceC4014c<? super ClawChannelAgentBusBinding$BffApi$send$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = bffApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, 0L, this);
    }
}
