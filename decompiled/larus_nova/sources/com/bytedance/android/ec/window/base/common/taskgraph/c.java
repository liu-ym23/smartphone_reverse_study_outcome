package com.bytedance.android.ec.window.base.common.taskgraph;

import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c<IN, OUT> extends ProcessorNode<IN, OUT> {
    @Override // com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public final NodeType c() {
        return NodeType.SOURCE;
    }

    public c(ao.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "taskAction");
        super(r100, r101, null);
    }

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode, com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public final Object a(PipelineNode<?, IN> r100, IN r101, ao.a r102, Continuation<? super OUT> r103) {
        if (r100 != null) goto L4;
        boolean r104 = true;
    L5:
        if (r104 == false) goto L9;
        return ProcessorNode.e(this, r100, r101, r102, r103);
    L9:
        throw new IllegalStateException(("SourceNode should not have previous node, current preNode is " + r100).toString());
    L4:
        r104 = false;
        goto L5
    }
}
