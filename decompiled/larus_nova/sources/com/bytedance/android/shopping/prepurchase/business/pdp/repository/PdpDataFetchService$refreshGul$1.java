package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.y;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$refreshGul$1", f = "PdpDataFetchService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdpDataFetchService$refreshGul$1 extends SuspendLambda implements Function3<CoroutineScope, y, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public PdpDataFetchService$refreshGul$1(Continuation r100) {
        super(3, r100);
    }

    public final Continuation<Unit> create(CoroutineScope r100, y r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        PdpDataFetchService$refreshGul$1 r103 = new PdpDataFetchService$refreshGul$1(r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, y r101, Continuation<? super Unit> r102) {
        return ((PdpDataFetchService$refreshGul$1) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ((y) this.L$0).I0().a();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
