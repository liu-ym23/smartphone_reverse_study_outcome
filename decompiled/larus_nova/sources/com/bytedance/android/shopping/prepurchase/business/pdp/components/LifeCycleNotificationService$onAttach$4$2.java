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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/u;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.LifeCycleNotificationService$onAttach$4$2", f = "LifeCycleNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LifeCycleNotificationService$onAttach$4$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.u, Continuation<? super Unit>, Object> {
    final /* synthetic */ LastPageVideoZoomer $zoomer;
    private /* synthetic */ Object L$0;
    int label;

    public LifeCycleNotificationService$onAttach$4$2(LastPageVideoZoomer r100, Continuation r101) {
        this.$zoomer = r100;
        super(3, r101);
    }

    public final Continuation<Unit> create(CoroutineScope r100, vg3.u r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        LifeCycleNotificationService$onAttach$4$2 r103 = new LifeCycleNotificationService$onAttach$4$2(this.$zoomer, r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, vg3.u r101, Continuation<? super Unit> r102) {
        return ((LifeCycleNotificationService$onAttach$4$2) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        vg3.u r101 = (vg3.u) this.L$0;
        final LastPageVideoZoomer r102 = this.$zoomer;
        r102.getClass();
        r101.l1(new LastPageVideoZoomer$getCloseListener$1(r102));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
