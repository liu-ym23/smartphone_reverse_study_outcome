package com.stepos.agentframework.adapter.agentbus;

import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "it", "Lcom/stepos/agentframework/adapter/netcore/q;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)Lcom/stepos/agentframework/adapter/netcore/q;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$2", f = "AgentBusCoreAgentClient.kt", l = {3187}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient$answerInquiry$2 extends SuspendLambda implements p9.p<ClawChannelAgentBusBinding, InterfaceC4014c<? super InquiryAnswerResult>, Object> {
    final /* synthetic */ List<String> $answers;
    final /* synthetic */ String $inquiryId;
    final /* synthetic */ String $sessionId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusCoreAgentClient$answerInquiry$2(String str, String str2, List<String> list, InterfaceC4014c<? super AgentBusCoreAgentClient$answerInquiry$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$inquiryId = str2;
        this.$answers = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusCoreAgentClient$answerInquiry$2 agentBusCoreAgentClient$answerInquiry$2 = new AgentBusCoreAgentClient$answerInquiry$2(this.$sessionId, this.$inquiryId, this.$answers, interfaceC4014c);
        agentBusCoreAgentClient$answerInquiry$2.L$0 = obj;
        return agentBusCoreAgentClient$answerInquiry$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ClawChannelAgentBusBinding clawChannelAgentBusBinding, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return ((AgentBusCoreAgentClient$answerInquiry$2) create(clawChannelAgentBusBinding, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = (ClawChannelAgentBusBinding) this.L$0;
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
        String str = this.$sessionId;
        String str2 = this.$inquiryId;
        List<String> list = this.$answers;
        this.L$0 = g9.h.a(clawChannelAgentBusBinding);
        this.label = 1;
        Object objC = AgentBusTaskOpsKt.c(clawChannelAgentBusBinding, str, str2, list, 0L, this, 8, null);
        return objC == objG ? objG : objC;
    }
}
