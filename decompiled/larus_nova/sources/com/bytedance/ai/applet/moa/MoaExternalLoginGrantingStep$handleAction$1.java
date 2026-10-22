package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep", f = "MoaExternalLoginGrantingStep.kt", i = {0, 1}, l = {32, 34}, m = "handleAction", n = {"granted", "granted"}, s = {"Z$0", "Z$0"})
public final class MoaExternalLoginGrantingStep$handleAction$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaExternalLoginGrantingStep this$0;

    public MoaExternalLoginGrantingStep$handleAction$1(MoaExternalLoginGrantingStep r100, Continuation<? super MoaExternalLoginGrantingStep$handleAction$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, false, this);
    }
}
