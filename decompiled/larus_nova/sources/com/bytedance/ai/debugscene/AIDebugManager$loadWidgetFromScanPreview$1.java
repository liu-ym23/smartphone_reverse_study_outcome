package com.bytedance.ai.debugscene;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager", f = "AIDebugManager.kt", i = {0}, l = {1369}, m = "loadWidgetFromScanPreview", n = {"widgetId"}, s = {"L$0"})
public final class AIDebugManager$loadWidgetFromScanPreview$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIDebugManager this$0;

    public AIDebugManager$loadWidgetFromScanPreview$1(AIDebugManager r100, Continuation<? super AIDebugManager$loadWidgetFromScanPreview$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AIDebugManager r101 = this.this$0;
        AIDebugManager r102 = AIDebugManager.f36217a;
        return r101.r(null, null, null, this);
    }
}
