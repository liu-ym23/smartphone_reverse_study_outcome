package com.bytedance.android.ec.core.monitor;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45161a = 0;

    static {
    }

    public static void a(String r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "orderUrl");
        Intrinsics.checkNotNullParameter("enter_order_detail", "scene");
        Intrinsics.checkNotNullParameter(r110, "packLogId");
        Intrinsics.checkNotNullParameter(r111, "skuLogId");
        boolean r101 = false;
        JSONObject r102 = null;
        if (StringsKt.contains$default(r100, "fe_lynx_commerce_buynow", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r100, "ecommerce_buynow_aweme", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r100, "ecommerce_buynow_huoshan", false, 2, null) == true) goto L10;
        return;
    L10:
        if (a2.b(r100) == false) goto L39;
        Uri r103 = UriProtector.parse(r100);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r103, "is_cart_order"), "1") == false) goto L14;
        return;
    L14:
        String r104 = UriProtector.getQueryParameter(r103, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT);
        if (r104 == null) goto L18;
        HashMap<String, JSONObject> r105 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        r102 = com.bytedance.android.ec.core.hybrid.utils.j.i(r104);
    L18:
        if (r102 != null) goto L20;
    L21:
        UriProtector.getQueryParameter(r103, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L22:
        if (r102 == null) goto L25;
        String r106 = r102.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r106 == null) goto L25;
    L26:
        if (r102 == null) goto L29;
        String r107 = r102.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r107 == null) goto L29;
    L30:
        JSONObject r108 = new JSONObject();
        r108.put("pack_log_id", r110);
        r108.put("sku_log_id", r111);
        r108.put("order_schema", r100);
        int r112 = l.f45163a;
        l.b(r100, "enter_order_detail", r108, CollectionsKt.listOf(new l.a[]{new l.a("id", "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, "is_json_string"), new l.a(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, "presence"), new l.a("combo_num", "valid_number"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE, "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID, "presence")}));
        if (a2.b(r106) == false) goto L40;
        if (r107 != null) goto L34;
    L35:
        r101 = true;
    L36:
        if (r101 == false) goto L41;
        int r109 = d.f45144a;
        d.d("dependency_cid_log_extra", "extra", "cid非空时log_extra字段为空", "enter_order_detail", r108);
        return;
    L41:
        return;
    L34:
        if (r107.length() != 0) goto L36;
    L40:
        return;
    L29:
        r107 = UriProtector.getQueryParameter(r103, "log_extra");
    L25:
        r106 = UriProtector.getQueryParameter(r103, "cid");
        goto L26
    L20:
        if (r102.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) != null) goto L22;
    }
}
