package com.bytedance.android.live.profit.util;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f89093a = null;

    static {
        int r100 = m.f89111a;
        f89093a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(m.f89111a), "福袋"), TuplesKt.to(Integer.valueOf(m.f89112b), "红包")});
    }

    public static final void a(cy0.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        com.bytedance.android.livesdk.revenue.service.sti.a r102 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.f163449e.d(r100, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f() == true) goto L8;
        return;
    L8:
        Iterator<T> r103 = r102.X8().getIcons().iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if (((xr2.i) r104).f564839a != r101) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L10;
    L18:
        xr2.i r106 = (xr2.i) r104;
        if (r106 == null) goto L30;
        String r107 = f89093a.get(Integer.valueOf(r106.f564839a));
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        r102.Bl(String.valueOf(r101), r107);
        return;
    L30:
        return;
    L14:
        r105 = false;
        goto L15
    L17:
        r104 = null;
        goto L18
    }

    public static final void b(cy0.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        com.bytedance.android.livesdk.revenue.service.sti.a r102 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.f163449e.d(r100, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f() == true) goto L8;
        return;
    L8:
        Iterator<T> r103 = r102.X8().getIcons().iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if (((xr2.i) r104).f564839a != r101) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L10;
    L18:
        xr2.i r106 = (xr2.i) r104;
        if (r106 == null) goto L30;
        String r107 = f89093a.get(Integer.valueOf(r106.f564839a));
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        r102.Zg(String.valueOf(r101), r107);
        return;
    L30:
        return;
    L14:
        r105 = false;
        goto L15
    L17:
        r104 = null;
        goto L18
    }

    public static final void c(cy0.f r100, int r101, String r102, long r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r102, "strategyId");
        Intrinsics.checkNotNullParameter(r111, "benefit");
        Intrinsics.checkNotNullParameter(r112, "extraMessage");
        com.bytedance.android.livesdk.revenue.service.sti.a r103 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.f163449e.d(r100, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.f() == true) goto L8;
        return;
    L8:
        Iterator<T> r104 = r103.X8().getIcons().iterator();
    L10:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (((xr2.i) r105).f564839a != r101) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L10;
    L18:
        xr2.i r107 = (xr2.i) r105;
        if (r107 == null) goto L30;
        String r108 = f89093a.get(Integer.valueOf(r107.f564839a));
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        String r109 = r108;
        r103.I2(String.valueOf(r101), r109, r102, r110 / ((long) 1000), MapsKt.mutableMapOf(new Pair[]{new Pair("temp_benefit", r111), new Pair("temp_extra_message", r112)}));
        return;
    L30:
        return;
    L14:
        r106 = false;
        goto L15
    L17:
        r105 = null;
        goto L18
    }
}
