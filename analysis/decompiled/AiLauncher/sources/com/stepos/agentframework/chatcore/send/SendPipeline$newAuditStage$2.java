package com.stepos.agentframework.chatcore.send;

import Y8.t;
import com.stepos.agentframework.chatcore.audit.ContentAuditClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "Lcom/stepos/agentframework/chatcore/audit/g;", "<anonymous>", "(Lcom/stepos/agentframework/chatcore/send/e;)Lcom/stepos/agentframework/chatcore/audit/g;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.SendPipeline$newAuditStage$2", f = "SendPipeline.kt", l = {42}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SendPipeline$newAuditStage$2 extends SuspendLambda implements p<SendContext, InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public SendPipeline$newAuditStage$2(InterfaceC4014c<? super SendPipeline$newAuditStage$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SendPipeline$newAuditStage$2 sendPipeline$newAuditStage$2 = new SendPipeline$newAuditStage$2(interfaceC4014c);
        sendPipeline$newAuditStage$2.L$0 = obj;
        return sendPipeline$newAuditStage$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SendContext sendContext, InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g> interfaceC4014c) {
        return ((SendPipeline$newAuditStage$2) create(sendContext, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SendContext sendContext = (SendContext) this.L$0;
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
        ContentAuditClient contentAuditClient = ContentAuditClient.INSTANCE;
        String agentId = sendContext.getAgentId();
        String text = sendContext.getText();
        if (text == null) {
            text = "";
        }
        String messageId = sendContext.getIds().getMessageId();
        this.L$0 = g9.h.a(sendContext);
        this.label = 1;
        Object objF = contentAuditClient.f(agentId, text, messageId, this);
        return objF == objG ? objG : objF;
    }
}
