package com.bytedance.android.ec.core.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MetricNames> f45194a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(List<? extends MetricNames> r100) {
        Intrinsics.checkNotNullParameter(r100, "parallelMetrics");
        this.f45194a = r100;
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final void a(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
        Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
    }

    @Override // com.bytedance.android.ec.core.monitor.n
    public final Long b(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "durationOfMetrics");
        if (this.f45194a.isEmpty() == false) goto L5;
        return null;
    L5:
        Long r100 = r110.get(MetricNames.DURATION.getMetricNames());
        if (r100 != null) goto L8;
        return null;
    L8:
        if (r100.longValue() <= 0) goto L51;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = this.f45194a.iterator();
    L12:
        if (r102.hasNext() == false) goto L19;
        Long r103 = r110.get(((MetricNames) r102.next()).getMetricNames());
        if (r103 == null) goto L12;
        if (r103.longValue() <= 0) goto L12;
        r101.add(r103);
        goto L12
    L19:
        if (r101.isEmpty() == false) goto L21;
        return null;
    L21:
        Iterator r111 = r101.iterator();
        long r104 = 0;
    L23:
        if (r111.hasNext() == false) goto L28;
        long r105 = ((Number) r111.next()).longValue();
        if (r105 <= r104) goto L23;
        r104 = r105;
        goto L23
    L28:
        if (r104 > 0) goto L30;
        return null;
    L30:
        Long r112 = Long.valueOf(r100.longValue() - r104);
        if (r112.longValue() <= 0) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == true) goto L36;
        return null;
    L36:
        return r112;
    L33:
        r106 = false;
        goto L34
    L51:
        return null;
    }
}
