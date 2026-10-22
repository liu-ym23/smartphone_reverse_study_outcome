package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaPermissionGrantingStep", f = "MoaPermissionGrantingStep.kt", i = {}, l = {121}, m = "postPermissionStatus-BWLJW6A", n = {}, s = {})
public final class MoaPermissionGrantingStep$postPermissionStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaPermissionGrantingStep this$0;

    public MoaPermissionGrantingStep$postPermissionStatus$1(MoaPermissionGrantingStep r100, Continuation<? super MoaPermissionGrantingStep$postPermissionStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MoaPermissionGrantingStep r101 = this.this$0;
        int r102 = MoaPermissionGrantingStep.f34827c;
        Object r103 = r101.d(null, null, null, this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}
