package com.bytedance.android.ec.window.base.common.taskgraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes44.dex */
public abstract class ProcessorNode<IN, OUT> extends PipelineNode<IN, OUT> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Job> f49176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<PipelineNode<OUT, ?>> f49177g;

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public Object a(PipelineNode<?, IN> r100, IN r101, ao.a r102, Continuation<? super OUT> r103) {
        return e(this, r100, r101, r102, r103);
    }

    public final void d(PipelineNode r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        ((ArrayList) this.f49177g).add(r100);
    }

    public final void f(eo.a<OUT, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        ((ArrayList) this.f49177g).add(r100);
    }

    public ProcessorNode(ao.b r100, Function1 r101, CoroutineContext r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "taskAction");
        super(r100, r101, r102);
        this.f49176f = new ArrayList();
        this.f49177g = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode, com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode, com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode] */
    /* JADX WARN: Type inference failed for: r12v0, types: [ao.a] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode] */
    /* JADX WARN: Type inference failed for: r2v1, types: [ao.a] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static Object e(ProcessorNode r110, PipelineNode r111, Object r112, ao.a r210, Continuation r211) {
        ?? r100 = r110;
        PipelineNode r101 = r111;
        ao.a r102 = r210;
        if ((r211 instanceof ProcessorNode$execute$1) == false) goto L7;
        ProcessorNode$execute$1 r103 = (ProcessorNode$execute$1) r211;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        Iterator r108 = (Iterator) r103.L$2;
        Object r109 = r103.L$1;
        ProcessorNode r113 = (ProcessorNode) r103.L$0;
        ResultKt.throwOnFailure(r105);
        ?? r114 = r113;
    L28:
        if (r108.hasNext() == false) goto L32;
        Job r115 = (Job) r108.next();
        r103.L$0 = r114;
        r103.L$1 = r109;
        r103.L$2 = r108;
        r103.label = 2;
        if (r115.join(r103) != r106) goto L28;
        return r106;
    L32:
        ((ArrayList) r114.f49176f).clear();
        return r109;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ao.a r116 = (ao.a) r103.L$2;
        r101 = (PipelineNode) r103.L$1;
        ProcessorNode r117 = (ProcessorNode) r103.L$0;
        ResultKt.throwOnFailure(r105);
        ?? r118 = r116;
        ?? r119 = r117;
    L19:
        if (r101 == null) goto L21;
        r118.a(r101, r119);
    L21:
        if (r105 == null) goto L26;
        Iterator r120 = r119.f49177g.iterator();
    L24:
        if (r120.hasNext() == false) goto L26;
        ProcessorNode$execute$$inlined$forEach$lambda$1 r121 = new ProcessorNode$execute$$inlined$forEach$lambda$1((PipelineNode) r120.next(), null, r119, r118, r119, r105);
        Deferred r122 = BuildersKt.async$default(r118.f15689a, null, null, r121, 3, null);
        ((ArrayList) r119.f49176f).add(r122);
    L26:
        r114 = r119;
        r108 = r119.f49176f.iterator();
        r109 = r105;
        goto L28
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.L$2 = r102;
        r103.label = 1;
        r105 = super.a(r101, r112, r102, r103);
        r119 = r100;
        r118 = r102;
        if (r105 != r106) goto L19;
        return r106;
    L7:
        r103 = new ProcessorNode$execute$1(r100, r211);
        goto L8
    }
}
