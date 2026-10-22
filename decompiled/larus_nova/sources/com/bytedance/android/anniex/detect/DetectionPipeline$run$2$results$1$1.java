package com.bytedance.android.anniex.detect;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/bytedance/android/anniex/detect/h;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.DetectionPipeline$run$2$results$1$1", f = "DetectorConfig.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
public final class DetectionPipeline$run$2$results$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends h, ? extends c>>, Object> {
    final /* synthetic */ f $context;
    final /* synthetic */ h $step;
    Object L$0;
    int label;

    public DetectionPipeline$run$2$results$1$1(h r100, f r101, Continuation<? super DetectionPipeline$run$2$results$1$1> r102) {
        this.$step = r100;
        this.$context = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DetectionPipeline$run$2$results$1$1(this.$step, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Pair<? extends h, ? extends c>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Pair<? extends h, ? extends c>> r101) {
        return ((DetectionPipeline$run$2$results$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        h r103 = (h) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        return TuplesKt.to(r103, r100);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        h r104 = this.$step;
        f r105 = this.$context;
        this.L$0 = r104;
        this.label = 1;
        Object r106 = r104.a(r105, this);
        if (r106 != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        r100 = r106;
        goto L13
    }
}
