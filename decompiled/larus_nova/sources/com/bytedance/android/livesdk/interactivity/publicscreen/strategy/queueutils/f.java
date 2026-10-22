package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.Queue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends k {
    public f(com.bytedance.android.livesdk.interactivity.api.settings.config.m r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r101, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r110, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r111) {
        Intrinsics.checkNotNullParameter(r100, "highQueue");
        Intrinsics.checkNotNullParameter(r101, "midQueue");
        Intrinsics.checkNotNullParameter(r110, "lowQueue");
        Intrinsics.checkNotNullParameter(r111, "targetBuffer");
        int r102 = 0;
        if (((r100.size() + r101.size()) + r110.size()) > 5) goto L13;
        int r103 = r100.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        this.f139583a.add(r100.poll());
        r104 = r104 + 1;
        goto L5
    L7:
        int r105 = r101.size();
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L10;
        this.f139583a.add(r101.poll());
        r106 = r106 + 1;
        goto L8
    L10:
        int r107 = r110.size();
    L11:
        if (r102 >= r107) goto L23;
        this.f139583a.add(r110.poll());
        r102 = r102 + 1;
    L23:
        if ((!this.f139583a.isEmpty()) == false) goto L25;
        r111.add(this.f139583a.poll());
        goto L23
    L25:
        this.f139583a.clear();
        return;
    L13:
        int r108 = this.f139584b.highPriorityCount;
        int r109 = r101.size() + r110.size();
        int r112 = Math.min(r108, r100.size());
        int r113 = 0;
    L14:
        if (r113 >= r112) goto L16;
        this.f139583a.add(r100.poll());
        r113 = r113 + 1;
        goto L14
    L16:
        int r114 = Math.min(5 - this.f139583a.size(), r109);
        int r115 = 0;
    L17:
        if (r115 >= r114) goto L19;
        int r116 = ScrollComposePriorityQueue.f139548g;
        this.f139583a.add((com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(r101, r110, ScrollComposePriorityQueue.a.f139555a)).poll());
        r115 = r115 + 1;
        goto L17
    L19:
        int r117 = Math.min(5 - this.f139583a.size(), r100.size());
    L20:
        if (r102 >= r117) goto L23;
        this.f139583a.add(r100.poll());
        r102 = r102 + 1;
        goto L20
    }
}
