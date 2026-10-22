package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$handleBackgroundModeration$1", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$handleBackgroundModeration$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ RunBlockedEvent $event;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$handleBackgroundModeration$1(SessionHandler sessionHandler, String str, RunBlockedEvent runBlockedEvent, InterfaceC4014c<? super SessionHandler$handleBackgroundModeration$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$sessionId = str;
        this.$event = runBlockedEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$handleBackgroundModeration$1(this.this$0, this.$sessionId, this.$event, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$handleBackgroundModeration$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AgentSession agentSession = this.this$0.session;
        ChatMessage chatMessageT1 = agentSession != null ? agentSession.T1(this.$sessionId) : null;
        if (chatMessageT1 != null && !kotlin.jvm.internal.p.d(chatMessageT1.getMessageId(), this.$event.getRunId())) {
            this.this$0.v2(chatMessageT1.getMessageId());
        }
        return Y8.t.f7040a;
    }
}
