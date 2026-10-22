package com.stepos.agentframework.adapter.bff;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$2$1", f = "BffClient.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class BffClient$reconnectSafe$2$1 extends SuspendLambda implements n {
    int label;
    final /* synthetic */ BffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BffClient$reconnectSafe$2$1(BffClient bffClient, H7.c<? super BffClient$reconnectSafe$2$1> cVar) {
        super(2, cVar);
        this.this$0 = bffClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new BffClient$reconnectSafe$2$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        r rVar = r.f317a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.b(obj);
        try {
            this.this$0.getClient().reconnect();
            return rVar;
        } catch (Exception e) {
            IConnectCallback iConnectCallback = this.this$0.getConnectCallback().get();
            if (iConnectCallback == null) {
                return null;
            }
            iConnectCallback.onError(e);
            return rVar;
        }
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((BffClient$reconnectSafe$2$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
