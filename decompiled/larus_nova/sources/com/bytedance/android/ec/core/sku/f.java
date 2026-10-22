package com.bytedance.android.ec.core.sku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Map<String, Object>> f45327a = null;

    static {
        List r100 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("sku_specs", 1), TuplesKt.to("sku_count_stepper", 1), TuplesKt.to("sku_bottom_button", 1), TuplesKt.to("sku_base_info", 1), TuplesKt.to("sku_empty_line", 3), TuplesKt.to("sku_hint_bar", 1), TuplesKt.to("sku_poi_store", 1), TuplesKt.to("sku_top_banner", 1), TuplesKt.to("sku_car_adapter", 1), TuplesKt.to("sku_trade_mode", 1), TuplesKt.to("sku_dou_installment", 1)});
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Pair r103 = (Pair) r102.next();
        r101.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("name", r103.getFirst()), TuplesKt.to("url", "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_sku_pannel_template/" + ((String) r103.getFirst()) + "/main.json"), TuplesKt.to("num", r103.getSecond())}));
        goto L4
    L6:
        f45327a = r101;
    }
}
