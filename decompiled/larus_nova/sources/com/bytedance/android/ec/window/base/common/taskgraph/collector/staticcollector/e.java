package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode;
import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes44.dex */
public abstract class e<IN> extends ProcessorNode<IN, IN> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutexImpl f49193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f49194i;

    public abstract List<LinkerReceiverNode<?>> g();

    public abstract IN h();

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public final NodeType c() {
        return NodeType.COLLECTOR;
    }

    public e(ao.b r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        super(r100, StaticCollectorNode$1.INSTANCE, null);
        MutexImpl r101 = kotlinx.coroutines.sync.b.a();
        this.f49193h = r101;
        StringBuilder r102 = new StringBuilder();
        r102.append(getClass());
        r102.append('-');
        r102.append(r101.hashCode());
        this.f49194i = r102.toString();
    }
}
