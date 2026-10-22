package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode;
import com.bytedance.android.ec.window.base.common.taskgraph.collector.stub.TimePointProcessorNode;
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final String b(ProcessorNode<?, ?>... r100) {
        StringBuilder r101 = new StringBuilder(ShareChannel.COLLECT);
        ArrayList r102 = new ArrayList(r100.length);
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add("-" + r100[r104].f49169b);
        r104 = r104 + 1;
        goto L3
    L5:
        r101.append(r102);
        return r101.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final b a(TimePointProcessorNode r100, TimePointProcessorNode r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "processorNodeA");
        Intrinsics.checkNotNullParameter(r101, "processorNodeB");
        Intrinsics.checkNotNullParameter(r102, "transformer");
        b r103 = new b(new ao.b(b(new ProcessorNode[]{r100, r101})), r102);
        Intrinsics.checkNotNullParameter(r100, "nodeA");
        Intrinsics.checkNotNullParameter(r101, "nodeB");
        r100.d((PipelineNode) r103.f49189j.f49191a);
        r101.d((PipelineNode) r103.f49189j.f49192b);
        return r103;
    }
}
