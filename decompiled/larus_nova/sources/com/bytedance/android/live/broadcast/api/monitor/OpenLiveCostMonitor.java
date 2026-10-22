package com.bytedance.android.live.broadcast.api.monitor;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenLiveCostMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<OpenLiveAction, Long> f59059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f59060b = null;

    static {
        f59060b = LazyKt.lazy(OpenLiveCostMonitor$enable$2.INSTANCE);
    }

    public static void b(OpenLiveAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (((Boolean) f59060b.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (f59059a != null) goto L8;
        f59059a = new LinkedHashMap();
    L8:
        Map<OpenLiveAction, Long> r101 = f59059a;
        if (r101 == null) goto L12;
        Long r102 = r101.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    }

    public static Pair a(OpenLiveAction r100, OpenLiveAction r101) {
        String r102 = "from_" + r100.getValue() + "_to_" + r101.getValue();
        Map<OpenLiveAction, Long> r103 = f59059a;
        if (r103 == null) goto L7;
        Long r104 = (Long) ((LinkedHashMap) r103).get(r101);
        if (r104 == null) goto L7;
        long r105 = r104.longValue();
    L8:
        Map<OpenLiveAction, Long> r106 = f59059a;
        if (r106 == null) goto L13;
        Long r107 = (Long) ((LinkedHashMap) r106).get(r100);
        if (r107 == null) goto L13;
        long r108 = r107.longValue();
    L15:
        return TuplesKt.to(r102, String.valueOf(RangesKt.coerceAtLeast(r105 - r108, 0)));
    L13:
        r108 = 0;
    L7:
        r105 = 0;
        goto L8
    }
}
