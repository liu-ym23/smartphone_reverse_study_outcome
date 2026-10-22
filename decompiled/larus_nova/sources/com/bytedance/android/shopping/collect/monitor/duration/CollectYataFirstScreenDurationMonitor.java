package com.bytedance.android.shopping.collect.monitor.duration;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.collect.monitor.error.CollectRunCatchExtKt;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectYataFirstScreenDurationMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<CollectYataFirstScreenPoint, Long> f172230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f172231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f172232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f172233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f172234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f172235g;

    public CollectYataFirstScreenDurationMonitor(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "baseParams");
        this.f172234f = r100;
        this.f172235g = r101;
        i r102 = i.f47987a;
        String r103 = r102.create("ec_perf_duration_collect");
        this.f172229a = r103;
        this.f172230b = new ConcurrentHashMap();
        this.f172231c = LazyKt.lazy(CollectYataFirstScreenDurationMonitor$extraParams$2.INSTANCE);
        d r104 = r102.get(r103);
        if (r104 == null) goto L8;
        Iterator<String> r105 = r101.keys();
    L6:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();
        r104.b(r106, this.f172235g.get(r106));
        goto L6
    L10:
        return;
    }

    public static void a(final CollectYataFirstScreenDurationMonitor r100, final CollectYataFirstScreenPoint r101) {
        Intrinsics.checkNotNullParameter(r101, "point");
        final Long r102 = null;
        CollectRunCatchExtKt.a(r100.f172234f, "CollectYataFirstScreenDurationMonitor-addPointSafely", new CollectYataFirstScreenDurationMonitor$addPointSafely$1(r100, r101, r102));
    }
}
