package com.bytedance.ai.debugscene;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager", f = "AIDebugManager.kt", i = {}, l = {417}, m = "getPreviewAppVersionList", n = {}, s = {})
public final class AIDebugManager$getPreviewAppVersionList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIDebugManager this$0;

    public AIDebugManager$getPreviewAppVersionList$1(AIDebugManager r100, Continuation<? super AIDebugManager$getPreviewAppVersionList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(0, null, null, null, null, 0, this);
    }
}
