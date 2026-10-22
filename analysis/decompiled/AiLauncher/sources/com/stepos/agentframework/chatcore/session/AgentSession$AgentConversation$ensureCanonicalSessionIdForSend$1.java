package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation", f = "AgentSession.kt", l = {3674, 3687, 3731, 3751, 3763, 3775, 3781}, m = "ensureCanonicalSessionIdForSend", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$ensureCanonicalSessionIdForSend$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentSession.AgentConversation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$ensureCanonicalSessionIdForSend$1(AgentSession.AgentConversation agentConversation, InterfaceC4014c<? super AgentSession$AgentConversation$ensureCanonicalSessionIdForSend$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentConversation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.z(this);
    }
}
