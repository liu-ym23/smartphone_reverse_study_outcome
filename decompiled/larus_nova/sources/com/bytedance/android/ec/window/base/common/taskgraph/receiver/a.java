package com.bytedance.android.ec.window.base.common.taskgraph.receiver;

import ao.b;
import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<IN, OUT> extends PipelineNode<IN, OUT> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OUT f49215f;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List r100, final Object r101) {
        Intrinsics.checkNotNullParameter(r100, "realNodes");
        StringBuilder r102 = new StringBuilder("proxy-by-list-of-");
        List r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(((PipelineNode) r105.next()).f49169b.f15692a);
        goto L4
    L6:
        r102.append(r104);
        super(new b(r102.toString()), new TransformProxyNode$2(r101), null);
        this.f49215f = r101;
    }
}
