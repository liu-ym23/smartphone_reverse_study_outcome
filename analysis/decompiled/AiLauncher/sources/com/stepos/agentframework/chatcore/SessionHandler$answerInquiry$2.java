package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$answerInquiry$2", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$answerInquiry$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $canonical;
    final /* synthetic */ String $outboundId;
    final /* synthetic */ AgentSession $s;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$answerInquiry$2(AgentSession agentSession, String str, String str2, InterfaceC4014c<? super SessionHandler$answerInquiry$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$s = agentSession;
        this.$canonical = str;
        this.$outboundId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$answerInquiry$2(this.$s, this.$canonical, this.$outboundId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((SessionHandler$answerInquiry$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a(this.$s.c0(this.$canonical, this.$outboundId));
    }
}
