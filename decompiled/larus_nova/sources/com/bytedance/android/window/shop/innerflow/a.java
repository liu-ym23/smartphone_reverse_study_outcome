package com.bytedance.android.window.shop.innerflow;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f189038a = 0;

    static {
    }

    public static Map a(ECWindowInnerFlowViewModel r110) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = null;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, ECWindowInnerFlowViewModel.getParam$default(r110, com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, null, 2, null));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, ECWindowInnerFlowViewModel.getParam$default(r110, com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, null, 2, null));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, ECWindowInnerFlowViewModel.getParam$default(r110, com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, null, 2, null));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, ECWindowInnerFlowViewModel.getParam$default(r110, com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, null, 2, null));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r110.getParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "store_page"));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        r100.put("product_form", BytedCertConstant.CertKey.FLOW);
        r100.put("request_id", ECWindowInnerFlowViewModel.getParam$default(r110, "request_id", null, 2, null));
        r100.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, ECWindowInnerFlowViewModel.getParam$default(r110, com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, null, 2, null));
        int r102 = r110.getInnerFlowParam().f189041c;
        if (r102 != 5) goto L5;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, "live_top");
        r100.put("tab_name_second", "live_top_101");
    L9:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        r100.put("author_id", ECWindowInnerFlowViewModel.getParam$default(r110, "author_id", null, 2, null));
        r100.put("anchor_id", ECWindowInnerFlowViewModel.getParam$default(r110, "author_id", null, 2, null));
        JSONObject r103 = z1.g(ECWindowInnerFlowViewModel.getParam$default(r110, com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API, null, 2, null));
        if (r103 == null) goto L12;
        r101 = r103.optString("ecom_scene_id");
    L12:
        if (r101 != null) goto L14;
        r101 = "";
    L14:
        r100.put("ecom_scene_id", r101);
        r100.put("flow_type", String.valueOf(r110.getInnerFlowParam().f189041c));
        return r100;
    L5:
        if (r102 != 6) goto L9;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, "live_top");
        r100.put("tab_name_second", "live_top_102");
        goto L9
    }

    public static Map b(ECWindowInnerFlowViewModel r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        r101.put("author_id", ECWindowInnerFlowViewModel.getParam$default(r100, "author_id", null, 2, null));
        r101.put("anchor_id", ECWindowInnerFlowViewModel.getParam$default(r100, "author_id", null, 2, null));
        JSONObject r102 = z1.g(ECWindowInnerFlowViewModel.getParam$default(r100, com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API, null, 2, null));
        if (r102 == null) goto L5;
        String r103 = r102.optString("ecom_scene_id");
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101.put("ecom_scene_id", r103);
        r101.put("flow_type", String.valueOf(r100.getInnerFlowParam().f189041c));
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, ECWindowInnerFlowViewModel.getParam$default(r100, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, 2, null));
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    public static Map c(ECWindowInnerFlowViewModel r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r102, "productId");
        Map r103 = b(r100);
        r103.put("product_form", BytedCertConstant.CertKey.FLOW);
        r103.put("product_id", r102);
        r103.put("product_orders", String.valueOf(r101));
        r103.put(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product");
        return r103;
    }

    public static void d(ECWindowInnerFlowViewModel r100, String r101, Pair... r102) {
        Intrinsics.checkNotNullParameter(r100, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r101, "area");
        Intrinsics.checkNotNullParameter(r102, "pairs");
        Map<String, String> r103 = b(r100);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r101);
        MapsKt.putAll(r103, r102);
        r100.doEventAction("click_product_flow_other", r103, new Pair[0]);
    }
}
