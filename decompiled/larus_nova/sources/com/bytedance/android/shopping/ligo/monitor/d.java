package com.bytedance.android.shopping.ligo.monitor;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f176464a;

    public d(String r100) {
        this.f176464a = r100;
    }

    public static Map a(ll.a r100, Pair... r101) {
        int r102 = 0;
        Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", r100.e()), TuplesKt.to("region_name", r100.b()), TuplesKt.to("region_type", String.valueOf(r100.d())), TuplesKt.to("dynamic_type", String.valueOf(r100.a()))});
        int r104 = r101.length;
    L3:
        if (r102 >= r104) goto L6;
        Pair r105 = r101[r102];
        r103.put(r105.getFirst(), r105.getSecond());
        r102 = r102 + 1;
        goto L3
    L6:
        return MapsKt.toMap(r103);
    }
}
