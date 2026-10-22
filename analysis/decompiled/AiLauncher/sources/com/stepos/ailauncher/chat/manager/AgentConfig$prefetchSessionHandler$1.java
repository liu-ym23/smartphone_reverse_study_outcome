package com.stepos.ailauncher.chat.manager;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.AgentConfig", f = "AgentConfig.kt", l = {73}, m = "prefetchSessionHandler", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentConfig$prefetchSessionHandler$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentConfig this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentConfig$prefetchSessionHandler$1(AgentConfig agentConfig, InterfaceC4014c<? super AgentConfig$prefetchSessionHandler$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(this);
    }
}
