package com.stepos.agentframework.adapter.agentbus;

import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi", f = "ClawChannelAgentBusBinding.kt", l = {380, 381}, m = com.stepos.ailauncher.chat.trace.f.ENTRY_HISTORY, v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding$ChatApi$history$2 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClawChannelAgentBusBinding.ChatApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClawChannelAgentBusBinding$ChatApi$history$2(ClawChannelAgentBusBinding.ChatApi chatApi, InterfaceC4014c<? super ClawChannelAgentBusBinding$ChatApi$history$2> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = chatApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, 0, null, 0L, null, this);
    }
}
