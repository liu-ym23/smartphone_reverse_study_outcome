package com.bytedance.android.anniex.lite.flow;

import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.AnnieXLynxDispatchManager$dispatchFlow$1", f = "AnnieXLynxDispatchManager.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXLynxDispatchManager$dispatchFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ oa.b $loadFlowTask;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ b this$0;

    public AnnieXLynxDispatchManager$dispatchFlow$1(b r100, oa.b r101, Continuation<? super AnnieXLynxDispatchManager$dispatchFlow$1> r102) {
        this.this$0 = r100;
        this.$loadFlowTask = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AnnieXLynxDispatchManager$dispatchFlow$1(this.this$0, this.$loadFlowTask, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AnnieXLynxDispatchManager$dispatchFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Iterator r103 = (Iterator) this.L$1;
        b r104 = (b) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        if (r103.hasNext() == false) goto L21;
        oa.a r105 = (oa.a) r103.next();
        if (r104.f40924e == null) goto L14;
        this.L$0 = r104;
        this.L$1 = r103;
        this.label = 1;
        r105.getClass();
        if (Unit.INSTANCE != r101) goto L14;
        return r101;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IAnnieXPreloadStrategyProvider r106 = this.this$0.f40925f;
        if (r106 == null) goto L21;
        KitType r107 = KitType.UNKNOWN;
        List r108 = r106.getLoadStrategy();
        if (r108 == null) goto L21;
        r104 = this.this$0;
        r103 = r108.iterator();
        goto L14
    }
}
