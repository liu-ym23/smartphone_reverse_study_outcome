package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import java.util.Iterator;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class DoubleHitStrategy extends k {
    public DoubleHitStrategy(com.bytedance.android.livesdk.interactivity.api.settings.config.m r100) {
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
        int r107 = Math.min(this.f139584b.highPriorityCount, r100.size());
        int r108 = 0;
    L6:
        if (r108 >= r107) goto L8;
        this.f139583a.add(r100.poll());
        r108 = r108 + 1;
        goto L6
    L8:
        int r109 = Math.min(r101.size(), 5 - this.f139583a.size());
        int r110 = 0;
    L9:
        if (r110 >= r109) goto L11;
        this.f139583a.add(r101.poll());
        r110 = r110 + 1;
        goto L9
    L11:
        int r111 = Math.min(r100.size(), 5 - this.f139583a.size());
    L12:
        if (r105 >= r111) goto L15;
        this.f139583a.add(r100.poll());
        r105 = r105 + 1;
    L15:
        if ((!this.f139583a.isEmpty()) == false) goto L18;
        r103.add(this.f139583a.poll());
        goto L15
    L18:
        if (v.a() == false) goto L26;
        boolean r112 = n.f133645a;
        if (n.f133645a == false) goto L26;
        n.b(DoubleHitStrategy$fillBuffer$1.INSTANCE);
        Iterator r113 = r103.iterator();
    L23:
        if (r113.hasNext() == false) goto L25;
        final com.bytedance.android.livesdk.interactivity.api.entity.f r114 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r113.next();
        n.b(new DoubleHitStrategy$fillBuffer$2$1(r114));
        goto L23
    L25:
        n.b(DoubleHitStrategy$fillBuffer$3.INSTANCE);
    L26:
        this.f139583a.clear();
    }
}
