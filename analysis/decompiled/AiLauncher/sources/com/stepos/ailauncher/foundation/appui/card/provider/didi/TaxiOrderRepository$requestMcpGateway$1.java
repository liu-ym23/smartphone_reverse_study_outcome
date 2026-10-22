package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository", f = "TaxiOrderRepository.kt", l = {151}, m = "requestMcpGateway", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaxiOrderRepository$requestMcpGateway$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaxiOrderRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaxiOrderRepository$requestMcpGateway$1(TaxiOrderRepository taxiOrderRepository, InterfaceC4014c<? super TaxiOrderRepository$requestMcpGateway$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taxiOrderRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, null, null, null, this);
    }
}
