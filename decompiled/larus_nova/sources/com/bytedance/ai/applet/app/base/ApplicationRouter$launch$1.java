package com.bytedance.ai.applet.app.base;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.base.ApplicationRouter$DefaultImpls", f = "ApplicationRouter.kt", i = {}, l = {33}, m = "launch-gIAlu-s", n = {}, s = {})
final class ApplicationRouter$launch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ApplicationRouter$launch$1(Continuation<? super ApplicationRouter$launch$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ApplicationRouter$launch$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        ResultKt.throwOnFailure(r103);
        Object r105 = ((Result) r103).m9458unboximpl();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r105;
    L13:
        return Result.m9448boximpl(r105);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        r102.label = 1;
        throw null;
    L5:
        r102 = new ApplicationRouter$launch$1(this);
        goto L6
    }
}
