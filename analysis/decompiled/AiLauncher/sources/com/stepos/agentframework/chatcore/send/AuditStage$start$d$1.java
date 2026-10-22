package com.stepos.agentframework.chatcore.send;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/g;", "<anonymous>", "()Lcom/stepos/agentframework/chatcore/audit/g;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.AuditStage$start$d$1", f = "AuditStage.kt", l = {43}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AuditStage$start$d$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, Object> {
    final /* synthetic */ p<SendContext, InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, Object> $a;
    final /* synthetic */ SendContext $ctx;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuditStage$start$d$1(p<? super SendContext, ? super InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, ? extends Object> pVar, SendContext sendContext, InterfaceC4014c<? super AuditStage$start$d$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$a = pVar;
        this.$ctx = sendContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new AuditStage$start$d$1(this.$a, this.$ctx, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g> interfaceC4014c) {
        return ((AuditStage$start$d$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
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
        p<SendContext, InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, Object> pVar = this.$a;
        SendContext sendContext = this.$ctx;
        this.label = 1;
        Object objInvoke = pVar.invoke(sendContext, this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
