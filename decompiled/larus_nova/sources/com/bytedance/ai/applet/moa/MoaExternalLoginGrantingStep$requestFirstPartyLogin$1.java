package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep", f = "MoaExternalLoginGrantingStep.kt", i = {}, l = {114}, m = "requestFirstPartyLogin", n = {}, s = {})
public final class MoaExternalLoginGrantingStep$requestFirstPartyLogin$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaExternalLoginGrantingStep this$0;

    public MoaExternalLoginGrantingStep$requestFirstPartyLogin$1(MoaExternalLoginGrantingStep r100, Continuation<? super MoaExternalLoginGrantingStep$requestFirstPartyLogin$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MoaExternalLoginGrantingStep r101 = this.this$0;
        int r102 = MoaExternalLoginGrantingStep.f34789d;
        return r101.e(null, this);
    }
}
