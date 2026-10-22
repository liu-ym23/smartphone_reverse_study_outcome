package com.stepos.agentframework.adapter.agentbus;

import a4.Message;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$onIncomingMessage$2", f = "AgentBusCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$onIncomingMessage$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ AgentBusCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$onIncomingMessage$2(AgentBusCoreAgentClient agentBusCoreAgentClient, String str, Message message, InterfaceC4014c<? super AgentBusCoreAgentClient$onIncomingMessage$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentBusCoreAgentClient;
        this.$sessionId = str;
        this.$message = message;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$onIncomingMessage$2(this.this$0, this.$sessionId, this.$message, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$onIncomingMessage$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!this.this$0.v1()) {
            return Y8.t.f7040a;
        }
        this.this$0.U0(this.$sessionId, this.$message);
        return Y8.t.f7040a;
    }
}
