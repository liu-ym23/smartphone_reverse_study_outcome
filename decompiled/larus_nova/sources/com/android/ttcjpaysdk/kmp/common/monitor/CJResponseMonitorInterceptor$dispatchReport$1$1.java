package com.android.ttcjpaysdk.kmp.common.monitor;

import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import com.android.ttcjpaysdk.kmp.base.http.CJRequest;
import com.android.ttcjpaysdk.kmp.base.http.CJResponse;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.android.ttcjpaysdk.kmp.common.monitor.CJResponseMonitorInterceptor$dispatchReport$1$1", f = "CJResponseMonitorInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CJResponseMonitorInterceptor$dispatchReport$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CJRequest $request;
    final /* synthetic */ CJResponse $response;
    final /* synthetic */ CJResponseMonitorInterceptor $this_runCatching;
    private /* synthetic */ Object L$0;
    int label;

    public CJResponseMonitorInterceptor$dispatchReport$1$1(CJResponseMonitorInterceptor r100, CJRequest r101, CJResponse r102, Continuation<? super CJResponseMonitorInterceptor$dispatchReport$1$1> r103) {
        this.$this_runCatching = r100;
        this.$request = r101;
        this.$response = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CJResponseMonitorInterceptor$dispatchReport$1$1 r102 = new CJResponseMonitorInterceptor$dispatchReport$1$1(this.$this_runCatching, this.$request, this.$response, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CJResponseMonitorInterceptor$dispatchReport$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        CJResponseMonitorInterceptor r102 = this.$this_runCatching;
        CJRequest r103 = this.$request;
        CJResponse r104 = this.$response;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        CJResponseMonitorInterceptor.access$logServerApiStatus(r102, r103, r104);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L16;
        CJLogger r108 = CJLogger.INSTANCE;
        String r109 = r107.getMessage();
        if (r109 != null) goto L14;
        r109 = "";
    L14:
        r108.e("CJResponseMonitor", "logServerApiStatus error: ".concat(r109));
    L16:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
