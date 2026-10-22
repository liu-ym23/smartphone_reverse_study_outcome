package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiOrderRepository$fetch$deferred$1$2", f = "TaxiOrderRepository.kt", l = {91}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaxiOrderRepository$fetch$deferred$1$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super f0>, Object> {
    final /* synthetic */ String $cardTaskId;
    final /* synthetic */ String $orderNo;
    final /* synthetic */ String $platformOrderId;
    final /* synthetic */ String $userId;
    final /* synthetic */ TaxiVendorSpec $vendor;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaxiOrderRepository$fetch$deferred$1$2(TaxiVendorSpec taxiVendorSpec, String str, String str2, String str3, String str4, InterfaceC4014c<? super TaxiOrderRepository$fetch$deferred$1$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$vendor = taxiVendorSpec;
        this.$orderNo = str;
        this.$platformOrderId = str2;
        this.$cardTaskId = str3;
        this.$userId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaxiOrderRepository$fetch$deferred$1$2(this.$vendor, this.$orderNo, this.$platformOrderId, this.$cardTaskId, this.$userId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super f0> interfaceC4014c) {
        return ((TaxiOrderRepository$fetch$deferred$1$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        TaxiOrderRepository taxiOrderRepository = TaxiOrderRepository.INSTANCE;
        TaxiVendorSpec taxiVendorSpec = this.$vendor;
        String str = this.$orderNo;
        String str2 = this.$platformOrderId;
        String str3 = this.$cardTaskId;
        String str4 = this.$userId;
        this.label = 1;
        Object objM = taxiOrderRepository.m(taxiVendorSpec, str, str2, str3, str4, this);
        return objM == objG ? objG : objM;
    }
}
