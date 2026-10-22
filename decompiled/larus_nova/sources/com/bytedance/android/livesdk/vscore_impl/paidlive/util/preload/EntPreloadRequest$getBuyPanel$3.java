package com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/google/gson/JsonObject;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload.EntPreloadRequest$getBuyPanel$3", f = "EntPreloadRequest.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class EntPreloadRequest$getBuyPanel$3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends JsonObject>>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;
    int label;

    public EntPreloadRequest$getBuyPanel$3(Continuation r100) {
        super(3, r100);
    }

    public final Continuation<Unit> create(FlowCollector<? super Result<JsonObject>> r100, Throwable r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        EntPreloadRequest$getBuyPanel$3 r103 = new EntPreloadRequest$getBuyPanel$3(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super Result<? extends JsonObject>> r100, Throwable r101, Continuation<? super Unit> r102) {
        return ((EntPreloadRequest$getBuyPanel$3) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
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
        FlowCollector r103 = (FlowCollector) this.L$0;
        Throwable r104 = (Throwable) this.L$1;
        Result.Companion r105 = Result.Companion;
        Result r106 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r104)));
        this.L$0 = null;
        this.label = 1;
        if (r103.emit(r106, this) != r101) goto L12;
        return r101;
    }
}
