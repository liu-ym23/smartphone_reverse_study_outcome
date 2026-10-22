package com.obric.aikernel.phx.sdk.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {}, l = {140}, m = "updatePackage-0E7RQCE", n = {}, s = {})
final class AIKernelApi$updatePackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$updatePackage$1(AIKernelApi r1, Continuation<? super AIKernelApi$updatePackage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r1 = this.this$0.mo312updatePackage0E7RQCE(null, null, this);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Result.m802boximpl(r1);
    }
}
