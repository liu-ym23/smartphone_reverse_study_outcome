package com.bytedance.android.shopping.ligo.monitor;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static Map a(ll.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getTrackMap");
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", r100.e()), TuplesKt.to("region_name", r100.b()), TuplesKt.to("region_type", String.valueOf(r100.d())), TuplesKt.to("dynamic_type", String.valueOf(r100.a()))});
    }
}
