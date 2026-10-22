package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$retryLastRound$2", f = "SessionHandler.kt", l = {2488}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$retryLastRound$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession $currentSession;
    final /* synthetic */ String $sid;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$retryLastRound$2(SessionHandler sessionHandler, AgentSession agentSession, String str, InterfaceC4014c<? super SessionHandler$retryLastRound$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$currentSession = agentSession;
        this.$sid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$retryLastRound$2(this.this$0, this.$currentSession, this.$sid, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$retryLastRound$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SessionHandler sessionHandler = this.this$0;
            AgentSession agentSession = this.$currentSession;
            String str = this.$sid;
            this.label = 1;
            if (sessionHandler.W2(agentSession, str, true, "retryLastRound", this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
