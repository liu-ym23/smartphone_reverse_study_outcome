package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$markTopConversationRead$1", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$markTopConversationRead$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$markTopConversationRead$1(SessionHandler sessionHandler, InterfaceC4014c<? super SessionHandler$markTopConversationRead$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$markTopConversationRead$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$markTopConversationRead$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AgentSession.AgentConversation topConversation;
        AgentSession agentSession;
        AgentSession.AgentConversation topConversation2;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String str = this.this$0.TAG;
        AgentSession agentSession2 = this.this$0.session;
        C4148a.k(str, "markTopConversationRead real: " + ((agentSession2 == null || (topConversation2 = agentSession2.getTopConversation()) == null) ? null : topConversation2.getSessionId()), false, 4, null);
        AgentSession agentSession3 = this.this$0.session;
        if (agentSession3 == null || (topConversation = agentSession3.getTopConversation()) == null) {
            return Y8.t.f7040a;
        }
        if (topConversation.B().length() > 0 && (agentSession = this.this$0.session) != null) {
            AgentSession.E1(agentSession, topConversation.B(), 0L, 2, null);
        }
        return Y8.t.f7040a;
    }
}
