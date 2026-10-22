package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.Queue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends k {
    public g(com.bytedance.android.livesdk.interactivity.api.settings.config.m r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r101, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r102, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r103) {
        Intrinsics.checkNotNullParameter(r100, "highQueue");
        Intrinsics.checkNotNullParameter(r101, "midQueue");
        Intrinsics.checkNotNullParameter(r102, "lowQueue");
        Intrinsics.checkNotNullParameter(r103, "targetBuffer");
        int r104 = Math.min(r102.size(), this.f139584b.lowPriorityCount);
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        this.f139583a.add(r102.poll());
        r106 = r106 + 1;
        goto L3
    L5:
        int r107 = Math.min(5 - this.f139583a.size(), r100.size() + r101.size());
    L6:
        if (r105 >= r107) goto L9;
        int r108 = ScrollComposePriorityQueue.f139548g;
        this.f139583a.add((com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(r100, r101, ScrollComposePriorityQueue.a.f139555a)).poll());
        r105 = r105 + 1;
    L9:
        if ((!this.f139583a.isEmpty()) == false) goto L11;
        r103.add(this.f139583a.poll());
        goto L9
    L11:
        this.f139583a.clear();
    }
}
