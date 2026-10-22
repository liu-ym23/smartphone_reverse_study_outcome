package com.bytedance.android.ec.core.monitor;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v implements n {
    public v() {
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final void a(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
        Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final Long b(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "durationOfMetrics");
        Long r100 = r110.get(MetricNames.DURATION.getMetricNames());
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.longValue() <= 0) goto L31;
        Iterator<Map.Entry<String, Long>> r111 = r110.entrySet().iterator();
        long r101 = 0;
    L8:
        boolean r102 = true;
        if (r111.hasNext() == false) goto L15;
        Map.Entry<String, Long> r103 = r111.next();
        String r104 = r103.getKey();
        long r105 = r103.getValue().longValue();
        if ((!Intrinsics.areEqual(r104, MetricNames.DURATION.getMetricNames())) == false) goto L8;
        if (r105 <= 0) goto L8;
        r101 = r101 + r105;
        goto L8
    L15:
        Long r112 = Long.valueOf(r100.longValue() - r101);
        if (r112.longValue() > 0) goto L19;
        r102 = false;
    L19:
        if (r102 == true) goto L21;
        return null;
    L21:
        return r112;
    L31:
        return null;
    }
}
