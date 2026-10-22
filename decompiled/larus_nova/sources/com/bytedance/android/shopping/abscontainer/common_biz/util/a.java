package com.bytedance.android.shopping.abscontainer.common_biz.util;

import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(String r100, ISchemaModel r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "business");
        Intrinsics.checkNotNullParameter(r101, "schemaModel");
        int r103 = j43.a.f497353a;
        if (ECAppInfoService.f48114e.i() == true) goto L5;
        return;
    L5:
        EventActionImpl r104 = new EventActionImpl();
        Intrinsics.checkNotNullParameter(r101, "schemaModel");
        Intrinsics.checkNotNullParameter(r100, "business");
        r104.doEventAction("schema_report_localtest", MapsKt.mapOf(new Pair[]{TuplesKt.to("business", r100), TuplesKt.to("location", "arch_skubuy"), TuplesKt.to("out_schema", r102), TuplesKt.to("report_id", r101.getQueryParam("id") + '_' + r101.getQueryParam("ecom_scene_id") + '_' + r100)}));
    }
}
