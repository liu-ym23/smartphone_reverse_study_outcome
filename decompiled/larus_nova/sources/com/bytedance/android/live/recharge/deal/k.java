package com.bytedance.android.live.recharge.deal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f89719a = 0;

    public k() {
    }

    static {
    }

    public static s a(i r210, List r211, Long r212, Long r213, Map r214, Map r310, int r311) {
        Map r100 = null;
        if ((r311 & 2) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r311 & 8) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r311 & 16) == 0) goto L13;
        Long r103 = null;
    L15:
        if ((r311 & 32) == 0) goto L17;
        Map r104 = null;
    L19:
        if ((r311 & 64) != 0) goto L22;
        r100 = r310;
    L22:
        Intrinsics.checkNotNullParameter(r210, "original");
        if ((r210 instanceof s) == false) goto L25;
        i r105 = ((s) r210).f89737a;
    L26:
        if (r101 != null) goto L28;
        r101 = r210.c();
    L28:
        List r106 = r101;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L30:
        if (r108.hasNext() == false) goto L32;
        u r109 = (u) r108.next();
        long r110 = r109.f89764b;
        long r111 = r109.f89765c;
        int r112 = r109.f89766d;
        int r113 = r109.f89767e;
        String r114 = r109.f89768f;
        String r115 = r109.f89769g;
        Iterator r215 = r108;
        boolean r116 = r109.f89770h;
        i r216 = r105;
        int r117 = r109.f89771i;
        Map r217 = r100;
        int r118 = r109.f89772j;
        Map r218 = r104;
        String r119 = r109.f89773k;
        int r120 = r109.f89774l;
        Intrinsics.checkNotNullParameter(r114, "description");
        Intrinsics.checkNotNullParameter(r115, "iapProductId");
        Intrinsics.checkNotNullParameter(r119, "diamondSignInfo");
        r107.add(new u(r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120));
        r108 = r215;
        r105 = r216;
        r100 = r217;
        r104 = r218;
        goto L30
    L32:
        Map r219 = r100;
        Map r220 = r104;
        i r221 = r105;
        List<d> r121 = r210.k();
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L34:
        if (r123.hasNext() == false) goto L36;
        r122.add(d.j((d) r123.next(), 0, false, 1023));
        goto L34
    L36:
        if (r102 == null) goto L38;
        long r124 = r102.longValue();
    L39:
        long r125 = r124;
        if (r103 == null) goto L42;
        long r126 = r103.longValue();
    L43:
        long r127 = r126;
        if (r220 != null) goto L46;
        Map r128 = r210.j();
    L47:
        if (r219 != null) goto L49;
        Map r129 = r210.getPanelExtraInfo();
    L51:
        return new s(r221, r107, r122, r125, r127, r128, r129);
    L49:
        r129 = r219;
        goto L51
    L46:
        r128 = r220;
        goto L47
    L42:
        r126 = r210.l();
        goto L43
    L38:
        r124 = r210.d();
        goto L39
    L25:
        r105 = r210;
        goto L26
    L17:
        r104 = r214;
        goto L19
    L13:
        r103 = r213;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
