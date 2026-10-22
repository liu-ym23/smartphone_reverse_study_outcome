package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import java.util.Iterator;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class FoldStrategy extends k {
    public FoldStrategy(com.bytedance.android.livesdk.interactivity.api.settings.config.m r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r101, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r102, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r103) {
        Intrinsics.checkNotNullParameter(r100, "highQueue");
        Intrinsics.checkNotNullParameter(r101, "midQueue");
        Intrinsics.checkNotNullParameter(r102, "lowQueue");
        Intrinsics.checkNotNullParameter(r103, "targetBuffer");
        int r104 = RangesKt.coerceAtMost(r100.size(), this.f139584b.personalizedFoldCount);
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        this.f139583a.add(r100.poll());
        r106 = r106 + 1;
        goto L3
    L5:
        int r107 = Math.min(5 - this.f139583a.size(), r101.size());
        int r108 = 0;
    L6:
        if (r108 >= r107) goto L8;
        this.f139583a.add(r101.poll());
        r108 = r108 + 1;
        goto L6
    L8:
        int r109 = Math.min(r100.size(), 5 - this.f139583a.size());
    L9:
        if (r105 >= r109) goto L12;
        this.f139583a.add(r100.poll());
        r105 = r105 + 1;
    L12:
        if ((!this.f139583a.isEmpty()) == false) goto L15;
        r103.add(this.f139583a.poll());
        goto L12
    L15:
        if (v.a() == false) goto L23;
        boolean r110 = n.f133645a;
        if (n.f133645a == false) goto L23;
        n.b(FoldStrategy$fillBuffer$1.INSTANCE);
        Iterator r111 = r103.iterator();
    L20:
        if (r111.hasNext() == false) goto L22;
        final com.bytedance.android.livesdk.interactivity.api.entity.f r112 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r111.next();
        n.b(new FoldStrategy$fillBuffer$2$1(r112));
        goto L20
    L22:
        n.b(FoldStrategy$fillBuffer$3.INSTANCE);
    L23:
        this.f139583a.clear();
    }
}
