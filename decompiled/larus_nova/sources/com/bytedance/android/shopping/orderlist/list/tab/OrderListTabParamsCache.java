package com.bytedance.android.shopping.orderlist.list.tab;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderListTabParamsCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OrderListTabParamsCache f180365a = null;

    public OrderListTabParamsCache() {
    }

    static {
        f180365a = new OrderListTabParamsCache();
    }

    public static String a() {
        String r100 = r.f48132a.getCurrentUserId();
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        return "order_list_cache_tab_params_".concat(r100);
    }

    public static void b(Context r100, final a r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r102 = a();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r101 == null) goto L19;
        String r103 = r101.f180368c;
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L17:
        if ((!r104) == false) goto L19;
    L20:
        if (r101 != null) goto L23;
        r100.getSharedPreferences("js_kv_methods_20191113", 0).edit().remove(r102).apply();
        return;
    L23:
        JSONObject r105 = new JSONObject();
        r105.put("time", System.currentTimeMillis());
        r105.put("tab_mode", r101.f180368c);
        r105.put("tab_id", r101.f180367b);
        Integer r106 = r101.f180366a;
        if (r106 == null) goto L26;
        r105.put("biz_tab_id", r106.intValue());
    L26:
        String r107 = r105.toString();
        Lazy r108 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListTabParamsCache", new OrderListTabParamsCache$save$1(r101));
        ka3.b.b(r100, r102, r107);
        return;
    L12:
        if (StringsKt.isBlank(r103) == true) goto L15;
        r104 = false;
    L19:
        r101 = null;
        goto L20
    }
}
