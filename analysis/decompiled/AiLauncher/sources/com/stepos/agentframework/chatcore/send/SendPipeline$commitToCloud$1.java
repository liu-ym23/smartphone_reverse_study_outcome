package com.stepos.agentframework.chatcore.send;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.SendPipeline", f = "SendPipeline.kt", l = {216}, m = "commitToCloud", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendPipeline$commitToCloud$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendPipeline this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendPipeline$commitToCloud$1(SendPipeline sendPipeline, InterfaceC4014c<? super SendPipeline$commitToCloud$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = sendPipeline;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
