package com.stepos.agentframework.adapter.agentbus;

import a4.Message;
import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$chat$sendOnce$2", f = "AgentBusCoreAgentClient.kt", l = {965}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$chat$sendOnce$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ ClawChannelAgentBusBinding $bus;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ Message $toolMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$chat$sendOnce$2(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, Message message, InterfaceC4014c<? super AgentBusCoreAgentClient$chat$sendOnce$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$bus = clawChannelAgentBusBinding;
        this.$sessionId = str;
        this.$toolMessage = message;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusCoreAgentClient$chat$sendOnce$2(this.$bus, this.$sessionId, this.$toolMessage, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super String> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$chat$sendOnce$2) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        ClawChannelAgentBusBinding.ChatApi chat = this.$bus.getChat();
        String str = this.$sessionId;
        Message message = this.$toolMessage;
        this.label = 1;
        Object objI = chat.i(str, message, this);
        return objI == objG ? objG : objI;
    }
}
