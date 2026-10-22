package com.bytedance.ai.applet.moa;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaPermissionGrantingStep", f = "MoaPermissionGrantingStep.kt", i = {0, 0}, l = {104}, m = "fetchPermissionStatus-0E7RQCE", n = {IFlowAppIntentIDL.PARAM_APPLET_ID, "scopeName"}, s = {"L$0", "L$1"})
public final class MoaPermissionGrantingStep$fetchPermissionStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaPermissionGrantingStep this$0;

    public MoaPermissionGrantingStep$fetchPermissionStatus$1(MoaPermissionGrantingStep r100, Continuation<? super MoaPermissionGrantingStep$fetchPermissionStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MoaPermissionGrantingStep r101 = this.this$0;
        int r102 = MoaPermissionGrantingStep.f34827c;
        Object r103 = r101.b(null, null, this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}
