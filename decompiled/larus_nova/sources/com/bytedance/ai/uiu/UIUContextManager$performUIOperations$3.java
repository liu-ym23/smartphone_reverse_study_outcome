package com.bytedance.ai.uiu;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager", f = "UIUContextManager.kt", i = {}, l = {260}, m = "performUIOperations", n = {}, s = {})
final class UIUContextManager$performUIOperations$3 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public UIUContextManager$performUIOperations$3(a r100, Continuation<? super UIUContextManager$performUIOperations$3> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return a.d(this.this$0, null, null, this);
    }
}
