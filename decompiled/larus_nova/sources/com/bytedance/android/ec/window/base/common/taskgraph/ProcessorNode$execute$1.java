package com.bytedance.android.ec.window.base.common.taskgraph;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007H\u0096@"}, d2 = {"IN", "OUT", "Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelineNode;", "preNode", "input", "Lao/a;", "nodeContextMgr", "Lkotlin/coroutines/Continuation;", "continuation", "", "execute"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode", f = "ProcessorNode.kt", i = {0, 0, 0, 1, 1}, l = {44, 63}, m = "execute$suspendImpl", n = {"this", "preNode", "nodeContextMgr", "this", "t"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class ProcessorNode$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProcessorNode this$0;

    public ProcessorNode$execute$1(ProcessorNode r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ProcessorNode.e(this.this$0, null, null, null, this);
    }
}
