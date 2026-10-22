package com.stepos.agentframework.chatcore.agents;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ABBffClient", f = "ABBffClient.kt", l = {309}, m = "feedback", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ABBffClient$feedback$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ABBffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffClient$feedback$1(ABBffClient aBBffClient, InterfaceC4014c<? super ABBffClient$feedback$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = aBBffClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, null, null, null, 0, null, null, null, null, this);
    }
}
