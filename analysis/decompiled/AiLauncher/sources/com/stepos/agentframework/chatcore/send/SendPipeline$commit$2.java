package com.stepos.agentframework.chatcore.send;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.send.SendPipeline;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.SendPipeline$commit$2", f = "SendPipeline.kt", l = {179, 187}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SendPipeline$commit$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AuditStage $audit;
    final /* synthetic */ g $bridge;
    final /* synthetic */ SendContext $ctx;
    final /* synthetic */ SendPipeline.b $send;
    Object L$0;
    int label;
    final /* synthetic */ SendPipeline this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendPipeline$commit$2(AuditStage auditStage, SendPipeline sendPipeline, SendContext sendContext, g gVar, SendPipeline.b bVar, InterfaceC4014c<? super SendPipeline$commit$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$audit = auditStage;
        this.this$0 = sendPipeline;
        this.$ctx = sendContext;
        this.$bridge = gVar;
        this.$send = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SendPipeline$commit$2(this.$audit, this.this$0, this.$ctx, this.$bridge, this.$send, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SendPipeline$commit$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009f, code lost:
    
        if (r1.g(r3, r5) == r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.send.SendPipeline$commit$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
