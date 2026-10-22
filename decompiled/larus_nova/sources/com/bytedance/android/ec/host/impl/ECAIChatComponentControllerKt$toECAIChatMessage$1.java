package com.bytedance.android.ec.host.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.ec.host.impl.ECAIChatComponentControllerKt", f = "ECAIChatComponentController.kt", i = {0}, l = {241}, m = "toECAIChatMessage", n = {"$this$toECAIChatMessage"}, s = {"L$0"})
final class ECAIChatComponentControllerKt$toECAIChatMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public ECAIChatComponentControllerKt$toECAIChatMessage$1(Continuation<? super ECAIChatComponentControllerKt$toECAIChatMessage$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return b.a(null, this);
    }
}
