package com.bytedance.android.shopping.prepurchase.business.pdp.components;

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

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$onAttach$1", f = "PdpRootComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdpRootComponent$onAttach$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.y, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public PdpRootComponent$onAttach$1(Continuation r100) {
        super(3, r100);
    }

    public final Continuation<Unit> create(CoroutineScope r100, vg3.y r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        PdpRootComponent$onAttach$1 r103 = new PdpRootComponent$onAttach$1(r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, vg3.y r101, Continuation<? super Unit> r102) {
        return ((PdpRootComponent$onAttach$1) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r101 = ((vg3.y) this.L$0).V();
        if (r101 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.perf.monitor.i r102 = r101.f167221a;
        r102.f167246e = Long.valueOf(System.currentTimeMillis());
        r101.l();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
