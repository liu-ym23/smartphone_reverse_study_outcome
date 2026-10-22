package com.android.ttcjpaysdk.kmp.base.util;

import com.android.ttcjpaysdk.kmp.base.http.CJHeader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.android.ttcjpaysdk.kmp.base.util.CJTimeUtils$updateServerTime$2$1", f = "CJTimeUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CJTimeUtils$updateServerTime$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CJHeader $header;
    final /* synthetic */ long $netCost;
    final /* synthetic */ String $syncUrl;
    int label;

    public CJTimeUtils$updateServerTime$2$1(CJHeader r100, long r101, String r102, Continuation<? super CJTimeUtils$updateServerTime$2$1> r103) {
        this.$header = r100;
        this.$netCost = r101;
        this.$syncUrl = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CJTimeUtils$updateServerTime$2$1(this.$header, this.$netCost, this.$syncUrl, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CJTimeUtils$updateServerTime$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        CJTimeUtils.access$updateAndSaveOffset(CJTimeUtils.INSTANCE, this.$header.getValue(), this.$netCost, this.$syncUrl);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
