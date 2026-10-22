package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183073a = 0;

    static {
    }

    public static void b(JSONObject r100, String r101, boolean r102) {
        if (r100 != null) goto L5;
        JSONObject r103 = new JSONObject();
        r103.put("sku_session_id", r101);
        JSONObject r104 = new JSONObject();
        r104.put("status_code", 2);
        Unit r105 = Unit.INSTANCE;
        r103.put("response", r104);
        ECLiveHybridUtil.f("ecom.sku.add.cart", r103);
        return;
    L5:
        r100.put("status_msg", r100.optString("msg"));
        JSONObject r106 = new JSONObject();
        r106.put("sku_session_id", r101);
        r106.put("response", r100);
        r106.put("success", r102);
        Unit r107 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r106);
    }

    public static void a(JSONObject r100, Integer r101, String r102, String r103) {
        if (r100 != null) goto L5;
        JSONObject r104 = new JSONObject();
        r104.put("status_code", 2);
        r104.put("scene_type", r101);
        r104.put("product_id", r103);
        r104.put("promotion_id", r102);
        Unit r105 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r104);
        return;
    L5:
        String r106 = r100.optString("msg");
        r100.put("scene_type", r101);
        r100.put("product_id", r103);
        r100.put("promotion_id", r102);
        r100.put("status_msg", r106);
        Unit r107 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r100);
    }

    public static void c(String r100, String r101, String r102, Integer r103, Map r104) {
        Intrinsics.checkNotNullParameter(r101, "btmShowId");
        JSONObject r105 = new JSONObject();
        r105.put("btm_show_id", r101);     // Catch: Throwable -> L16
        r105.put("cart_id", r102);     // Catch: Throwable -> L16
        r105.put("product_id", r100);     // Catch: Throwable -> L16
        r105.put("scene_type", r103);     // Catch: Throwable -> L16
        Iterator r106 = ((LinkedHashMap) r104).entrySet().iterator();     // Catch: Throwable -> L16
    L4:
        if (r106.hasNext() == false) goto L14;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L16
        if (r107.getValue() == null) goto L4;
        String r108 = (String) r107.getKey();     // Catch: Throwable -> L16
        Object r109 = r107.getValue();     // Catch: Throwable -> L16
        if (r109 == null) goto L11;
        String r110 = r109.toString();     // Catch: Throwable -> L16
    L12:
        r105.put(r108, r110);     // Catch: Throwable -> L16
        goto L4
    L11:
        r110 = null;
    L14:
        com.bytedance.android.ec.sdk.helper.g.f48122a.logV3("add_cart_success", r105);
    }
}
