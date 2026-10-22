package com.bytedance.ai.miniappevent;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter$enqueueNative$1", f = "AIMiniAppEventCenter.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class AIMiniAppEventCenter$enqueueNative$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $event;
    final /* synthetic */ AIMiniAppEventCenter.c $eventNotify;
    int label;

    public AIMiniAppEventCenter$enqueueNative$1(AIMiniAppEventCenter.c r100, a r101, Continuation<? super AIMiniAppEventCenter$enqueueNative$1> r102) {
        this.$eventNotify = r100;
        this.$event = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIMiniAppEventCenter$enqueueNative$1(this.$eventNotify, this.$event, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIMiniAppEventCenter$enqueueNative$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AIMiniAppEventCenter r103 = AIMiniAppEventCenter.f36687a;
        AIMiniAppEventCenter.c r104 = this.$eventNotify;
        AIMiniAppEventCenter.b r105 = new AIMiniAppEventCenter.b("native", this.$event.f36712e.getWireValue(), true);
        this.label = 1;
        if (AIMiniAppEventCenter.a(r103, r104, r105, this) != r101) goto L12;
        return r101;
    }
}
