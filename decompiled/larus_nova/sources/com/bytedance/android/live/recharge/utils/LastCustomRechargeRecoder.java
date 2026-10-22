package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class LastCustomRechargeRecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f90450a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f90451b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f90452c = false;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.android.live.recharge.deal.u) r100).f89765c), Long.valueOf(((com.bytedance.android.live.recharge.deal.u) r101).f89765c));
        }
    }

    static {
        f90450a = t.a().m6();
        f90451b = t.a().v7();
        f90452c = t.a().I2();
    }

    public static String a() {
        cy0.e.f465759a.getClass();
        cy0.j r100 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r101 = com.bytedance.android.scope.m.b(r100).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r101);
        return ((com.bytedance.android.livesdk.revenue.service.user.a) ((com.bytedance.live.kmp.core.c) r101)).getCurrentUserId();
    }

    public static void b(Order r100, com.bytedance.android.live.recharge.panel.context.c r101) {
        Intrinsics.checkNotNullParameter(r100, "order");
        Intrinsics.checkNotNullParameter(r101, "panelContext");
        com.bytedance.android.live.recharge.deal.f r102 = r100.o();
        if ((r102 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L11;
        if (((com.bytedance.android.live.recharge.deal.u) r102).f89770h == true) goto L8;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L18;
    L20:
        long r104 = 0;
    L21:
        HashMap r105 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(a(), Long.valueOf(r104))});
        KProperty[] r106 = i.f90460a;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        i.f90463d.setValue(null, i.f90460a[2], r105);
        return;
    L18:
        if (r100.o().g() > f90451b) goto L20;
        r104 = r100.o().g();
        goto L21
    L8:
        if (r101.a().f90016e == true) goto L11;
    L14:
        r103 = true;
    L11:
        if ((r102 instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L15;
        if (((com.bytedance.android.live.recharge.deal.d) r102).f89715k == false) goto L15;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.bytedance.android.live.recharge.deal.i c(com.bytedance.android.live.recharge.deal.i r110, com.bytedance.android.live.recharge.panel.context.c r111) {
        Intrinsics.checkNotNullParameter(r110, "dealSet");
        Object r100 = null;
        if (r111 == null) goto L7;
        com.bytedance.android.live.recharge.model.d r112 = r111.a();
        if (r112 == null) goto L7;
        String r113 = r112.f90013b;
    L9:
        if ((!Intrinsics.areEqual(r113, "click")) == false) goto L12;
        return r110;
    L12:
        if (f90450a == true) goto L14;
        return r110;
    L14:
        Long r114 = (Long) ((HashMap) i.f90463d.getValue(null, i.f90460a[2])).get(a());
        long r101 = 0;
        if (r114 == null) goto L17;
        final long r102 = r114.longValue();
    L19:
        if (r102 > 0) goto L22;
        return r110;
    L22:
        if (r110.c().isEmpty() == false) goto L25;
        return r110;
    L25:
        if (f90452c == false) goto L43;
        Iterator<T> r115 = r110.c().iterator();
    L28:
        if (r115.hasNext() == false) goto L35;
        Object r103 = r115.next();
        if (((com.bytedance.android.live.recharge.deal.u) r103).f89764b != r110.d()) goto L32;
        boolean r104 = true;
    L33:
        if (r104 == false) goto L28;
        r100 = r103;
        goto L35
    L32:
        r104 = false;
    L35:
        com.bytedance.android.live.recharge.deal.u r105 = (com.bytedance.android.live.recharge.deal.u) r100;
        if (r105 != null) goto L38;
        r105 = (com.bytedance.android.live.recharge.deal.u) CollectionsKt.firstOrNull(r110.c());
    L38:
        if (r105 == null) goto L41;
        r101 = r105.f89765c;
    L41:
        if (r102 > r101) goto L43;
        return r110;
    L43:
        com.bytedance.android.live.recharge.deal.u r116 = com.bytedance.android.live.recharge.deal.dto.a.a((int) r102, "上次使用");
        List r106 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(r110.c(), new a()));
        int r107 = CollectionsKt.binarySearch$default(r106, 0, 0, new LastCustomRechargeRecoder$tryInsertLastUseDeal$index$1(r102), 3, null);
        if (r107 < 0) goto L46;
        com.bytedance.android.live.recharge.deal.f r108 = (com.bytedance.android.live.recharge.deal.f) ListProtector.get(r106, r107);
        ListProtector.set(r106, r107, r116);
    L56:
        int r109 = com.bytedance.android.live.recharge.deal.k.f89719a;
        Long r117 = Long.valueOf(r116.f89764b);
        Long r118 = Long.valueOf(r116.f89764b);
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r119 = r110.getPanelExtraInfo();
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r121 = r119.entrySet().iterator();
    L58:
        if (r121.hasNext() == false) goto L65;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r122 = r121.next();
        if (r122.getKey().longValue() == r108.g()) goto L62;
        boolean r123 = true;
    L63:
        if (r123 == false) goto L58;
        r120.put(r122.getKey(), r122.getValue());
        goto L58
    L62:
        r123 = false;
        goto L63
    L65:
        Map<Long, com.bytedance.android.live.recharge.model.diamond.e> r124 = r110.j();
        LinkedHashMap r125 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e>> r126 = r124.entrySet().iterator();
    L67:
        if (r126.hasNext() == false) goto L75;
        Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e> r127 = r126.next();
        if (r127.getKey().longValue() == r108.g()) goto L71;
        boolean r128 = true;
    L72:
        if (r128 == false) goto L67;
        r125.put(r127.getKey(), r127.getValue());
        goto L67
    L71:
        r128 = false;
        goto L72
    L75:
        return com.bytedance.android.live.recharge.deal.k.a(r110, r106, r117, r118, r125, r120, 4);
    L46:
        int r129 = (-r107) - 1;
        if (r129 != 0) goto L50;
        r108 = (com.bytedance.android.live.recharge.deal.f) ListProtector.get(r106, r129);
        ListProtector.set(r106, r129, r116);
        goto L56
    L50:
        if (r129 != r106.size()) goto L52;
        r108 = (com.bytedance.android.live.recharge.deal.f) ListProtector.remove(r106, 0);
        r106.add(r116);
        goto L56
    L52:
        int r130 = r129 - 1;
        com.bytedance.android.live.recharge.deal.u r131 = (com.bytedance.android.live.recharge.deal.u) ListProtector.get(r106, r130);
        com.bytedance.android.live.recharge.deal.u r132 = (com.bytedance.android.live.recharge.deal.u) ListProtector.get(r106, r129);
        long r133 = r116.f89765c;
        if ((r133 - r131.f89765c) > (r132.f89765c - r133)) goto L55;
        r129 = r130;
    L55:
        r108 = (com.bytedance.android.live.recharge.deal.f) ListProtector.get(r106, r129);
        ListProtector.set(r106, r129, r116);
        goto L56
    L17:
        r102 = 0;
    L7:
        r113 = null;
        goto L9
    }
}
