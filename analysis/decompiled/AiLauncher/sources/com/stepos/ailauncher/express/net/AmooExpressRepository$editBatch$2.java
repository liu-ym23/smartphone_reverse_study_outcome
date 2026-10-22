package com.stepos.ailauncher.express.net;

import Y8.t;
import com.stepos.ailauncher.network.ApiResponse;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/stepos/ailauncher/network/ApiResponse;", "Lcom/stepos/ailauncher/express/net/b;", "<anonymous>", "()Lcom/stepos/ailauncher/network/ApiResponse;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.express.net.AmooExpressRepository$editBatch$2", f = "AmooExpressApi.kt", l = {50}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooExpressRepository$editBatch$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super ApiResponse<AmooExpressData>>, Object> {
    final /* synthetic */ AmooExpressRequest $req;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmooExpressRepository$editBatch$2(AmooExpressRequest amooExpressRequest, InterfaceC4014c<? super AmooExpressRepository$editBatch$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$req = amooExpressRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new AmooExpressRepository$editBatch$2(this.$req, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super ApiResponse<AmooExpressData>> interfaceC4014c) {
        return ((AmooExpressRepository$editBatch$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
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
        a aVarG = AmooExpressRepository.INSTANCE.g();
        AmooExpressRequest amooExpressRequest = this.$req;
        this.label = 1;
        Object objA = aVarG.a(amooExpressRequest, this);
        return objA == objG ? objG : objA;
    }
}
