package com.bytedance.android.shopping.anchorv4.helper;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class z {
    static {
    }

    public static SlcCommonAction a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter("a1.b8094.c7963.d8736", "btmCode");
        return new SlcCommonAction("openSchema", MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", r100), TuplesKt.to("btm_fields", MapsKt.mapOf(TuplesKt.to("btm_code", "a1.b8094.c7963.d8736")))}));
    }
}
