package com.stepos.agentframework.adapter.agentbus;

import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi", f = "ClawChannelAgentBusBinding.kt", l = {451, 452}, m = ChatTracker.CLICK_DELETE, v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding$SessionsApi$delete$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClawChannelAgentBusBinding.SessionsApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClawChannelAgentBusBinding$SessionsApi$delete$1(ClawChannelAgentBusBinding.SessionsApi sessionsApi, InterfaceC4014c<? super ClawChannelAgentBusBinding$SessionsApi$delete$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = sessionsApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, 0L, this);
    }
}
