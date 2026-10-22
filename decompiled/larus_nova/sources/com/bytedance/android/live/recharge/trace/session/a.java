package com.bytedance.android.live.recharge.trace.session;

import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f90393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<b>> f90394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f90395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f90396d;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.trace.session.a$a, reason: collision with other inner class name */
    public static final class C1390a {
    }

    static {
    }

    public final void a() {
        this.f90395c = true;
        u0 r100 = u0.f90999f;
        u0 r101 = t0.b().b(this.f90393a);
        final LinkedHashMap r102 = new LinkedHashMap();
        r102.put("session_duration", String.valueOf(r101.f91006a));
        r102.putAll(this.f90396d);
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((LinkedHashMap) this.f90394b).keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L17;
        String r105 = (String) r104.next();
        LinkedHashMap r106 = (LinkedHashMap) this.f90394b;
        Object r107 = r106.get(r105);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        r106.put(r105, r107);
    L8:
        List r108 = (List) r107;
        Iterator r109 = r108.iterator();
    L10:
        if (r109.hasNext() == false) goto L12;
        b r110 = (b) r109.next();
        r102.put(r110.f90398b, String.valueOf(r110.f90399c.b(this.f90393a).f91006a));
        goto L10
    L12:
        CollectionsKt.addAll(r103, r108);
        final LinkedHashMap r111 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator r112 = r103.iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        b r113 = (b) r112.next();
        Pair r114 = TuplesKt.to(r113.f90398b, r113);
        r111.put(r114.getFirst(), r114.getSecond());
        goto L14
    L16:
        Function2<c, c, Unit> r115 = new RechargePanelSession$writeMetrics$1(r111, r102);
        c r116 = d.f90403b;
        c r117 = d.f90404c;
        r115.invoke2(r116, r117);
        c r118 = d.f90409h;
        r115.invoke2(r117, r118);
        c r119 = d.f90411j;
        r115.invoke2(r118, r119);
        c r120 = d.f90406e;
        r115.invoke2(r116, r120);
        r115.invoke2(r118, r120);
        r115.invoke2(r119, r120);
        goto L4
    L17:
        jy0.b.a("Recharge/RechargePanelSession", CollectionsKt.joinToString$default(r102.entrySet(), "\n", null, null, 0, null, RechargePanelSession$uploadEvents$2.INSTANCE, 30, null));
        n r121 = new n();
        Map<String, String> r122 = r121.f516447a;
        Intrinsics.checkNotNullParameter(r122, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r122.putAll(r102);
        m r123 = new m();
        r123.b(LogCommon.ROOM);
        r123.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r124 = r121.f516448b;
        ArrayList r125 = (ArrayList) r124;
        r125.addAll(r123.f516446a);
        e.f465759a.getClass();
        j r126 = e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r127 = com.bytedance.android.scope.m.b(r126).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r127);
        ((i) ((f80.a) r127)).w3("livesdk_rd_recharge_duration_v2", r121.f516447a, r121.f516448b);
        ((LinkedHashMap) this.f90394b).clear();
        jy0.b.d("Recharge/RechargePanelSession", "session closed");
    }

    public a() {
        u0 r100 = u0.f90999f;
        this.f90393a = t0.b();
        this.f90394b = new LinkedHashMap();
        this.f90396d = new LinkedHashMap();
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f90395c == false) goto L5;
        return;
    L5:
        jy0.b.a("Recharge/RechargePanelSession", "reportEvent: " + r100);
        String r101 = r100.f90397a;
        LinkedHashMap r102 = (LinkedHashMap) this.f90394b;
        Object r103 = r102.get(r101);
        if (r103 != null) goto L8;
        r103 = new ArrayList();
        r102.put(r101, r103);
    L8:
        ((List) r103).add(r100);
    }

    public final void c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.getClass();
        String r101 = r100.f90400a;
        String r102 = r100.f90401b;
        u0 r103 = u0.f90999f;
        b(new b(r101, r102, t0.b()));
    }
}
