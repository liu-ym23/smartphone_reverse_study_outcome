package com.bytedance.android.ec.window.base.common.taskgraph;

import com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.LinkerReceiverNode;
import com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.TimePointProcessorNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes44.dex */
public final class b<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<ProcessorNode<?, ?>> f49180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.b<?, ?>> f49181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<?, ?>, TimePointProcessorNode<?, ?>> f49182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public S f49183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ao.a f49184e;

    public b(ao.a r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeContextMgr");
        this.f49184e = r100;
        this.f49180a = new LinkedHashSet();
        this.f49181b = new LinkedHashMap();
        this.f49182c = new LinkedHashMap();
    }

    public final void c(com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        TimePointProcessorNode r101 = (TimePointProcessorNode) ((LinkedHashMap) this.f49182c).get(r100);
        if (r101 == null) goto L6;
        r101.g();
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b(com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Object r102 = ((LinkedHashMap) this.f49182c).get(r100);
        if ((r102 instanceof TimePointProcessorNode) == true) goto L5;
        r102 = null;
    L5:
        TimePointProcessorNode r103 = (TimePointProcessorNode) r102;
        if (r103 == null) goto L9;
        r103.f49197h.set((OUT) r101);
        r103.f49198i.release();
        return;
    }

    public final void d(ProcessorNode<?, ?> r100, Set<ProcessorNode<?, ?>> r101) {
        e(r100, r101);
        Iterator r102 = CollectionsKt.toList(r100.f49177g).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        e((PipelineNode) r102.next(), r101);
        goto L4
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void e(PipelineNode<? extends Object, ? extends Object> r100, Set<ProcessorNode<?, ?>> r101) {
        if (CollectionsKt.contains(r101, r100) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof ProcessorNode) == false) goto L9;
        this.f49180a.add(r100);
        r101.add(r100);
        d((ProcessorNode) r100, r101);
    L9:
        if ((r100 instanceof com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.b) == false) goto L12;
        Map<Object, com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.b<?, ?>> r102 = this.f49181b;
        ((com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.b) r100).getClass();
        r102.put(null, r100);
    L12:
        if ((r100 instanceof TimePointProcessorNode) == false) goto L15;
        this.f49182c.put((com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.c<?, ?>) ((TimePointProcessorNode) r100).f49199j, (TimePointProcessorNode<?, ?>) r100);
    L15:
        if ((r100 instanceof LinkerReceiverNode) == false) goto L18;
        LinkerReceiverNode r103 = (LinkerReceiverNode) r100;
        this.f49180a.add(r103.f49186i);
        r101.add(r103.f49186i);
        d(r103.f49186i, r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(c r100, Unit r101, CoroutineScope r110) {
        Intrinsics.checkNotNullParameter(r100, "sourceNode");
        Intrinsics.checkNotNullParameter(r110, "scope");
        this.f49183d = r101;
        d(r100, new LinkedHashSet());
        BuildersKt.launch$default(r110, null, null, new Pipeline$launch$1(this, r100, r101, null), 3, null);
    }
}
