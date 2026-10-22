package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f186965a = null;

    public s() {
    }

    static {
        f186965a = SetsKt.setOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, "category_id", "tab_type", "page_version", "page_name", "follow_status", com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "live_anchor_id", com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, "product_form", com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, "customer_id", com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, "icon_type", "ecom_scene_id", "dismiss_live_strand"});
    }

    public static String f(LayoutTypes r100) {
        if (r100 == null) goto L8;
        int r101 = r.f186964a[r100.ordinal()];
        if (r101 != 1) goto L7;
        return "single_product";
    L7:
        if (r101 != 2) goto L8;
        return "clothes_preview";
    L8:
        return "double_product";
    }

    public static JSONObject d(q r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.commerce.base.json.a[] r102 = new com.bytedance.commerce.base.json.a[19];
        String r103 = "";
        if (Intrinsics.areEqual(r100.f186947g, "shop") == false) goto L5;
        String r104 = "share_alert";
    L8:
        r102[0] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r104);
        String r105 = r100.f186941a;
        String r106 = null;
        if (r105 == null) goto L16;
        if ((!StringsKt.isBlank(r105)) == true) goto L14;
        r105 = null;
    L14:
        if (r105 == null) goto L16;
    L22:
        r102[1] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r105);
        r102[2] = JsonDslUtilKt.d("category_id", "");
        r102[3] = JsonDslUtilKt.d("tab_type", "");
        r102[4] = JsonDslUtilKt.d("page_version", "");
        String r107 = r100.f186949i;
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        r102[5] = JsonDslUtilKt.d("page_name", r107);
        Integer r108 = r100.f186951k;
        if (r108 == null) goto L28;
        r106 = String.valueOf(r108.intValue());
    L28:
        if (r106 != null) goto L30;
        r106 = "";
    L30:
        r102[6] = JsonDslUtilKt.d("follow_status", r106);
        String r109 = r100.f186952l;
        if (r109 != null) goto L33;
        r109 = "";
    L33:
        r102[7] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, r109);
        r102[8] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        String r110 = r100.f186953m;
        if (r110 != null) goto L36;
        r110 = "";
    L36:
        r102[9] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r110);
        String r111 = r100.f186954n;
        if (r111 != null) goto L39;
        r111 = "";
    L39:
        r102[10] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r111);
        String r112 = r100.f186955o;
        if (r112 != null) goto L42;
        r112 = "";
    L42:
        r102[11] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r112);
        String r113 = r100.f186956p;
        if (r113 != null) goto L45;
        r113 = "";
    L45:
        r102[12] = JsonDslUtilKt.d("live_anchor_id", r113);
        String r114 = r100.f186943c;
        if (r114 != null) goto L48;
        r114 = "";
    L48:
        r102[13] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, r114);
        String r115 = r100.f186944d;
        if (r115 != null) goto L51;
        r115 = "";
    L51:
        r102[14] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, r115);
        String r116 = r100.f186945e;
        if (r116 != null) goto L54;
        r116 = "";
    L54:
        r102[15] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, r116);
        String r117 = r100.f186957q;
        if (r117 == null) goto L58;
        r103 = r117;
    L58:
        r102[16] = JsonDslUtilKt.d("product_form", r103);
        r102[17] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, "shop");
        r102[18] = JsonDslUtilKt.c("dismiss_live_strand", 1);
        JSONObject r118 = JsonDslUtilKt.a(r102);
        if (r100.f186960t == false) goto L70;
        String r119 = r100.f186961u;
        if (r119 != null) goto L63;
    L66:
        boolean r120 = true;
    L67:
        if (r120 == true) goto L70;
        r118.put("customer_id", r100.f186961u);
        goto L70
    L63:
        if (StringsKt.isBlank(r119) == true) goto L66;
        r120 = false;
    L70:
        if (r100.f186946f == false) goto L72;
        e(r118, com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r100.f186947g);
        e(r118, com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, r100.f186948h);
    L72:
        e(r118, "icon_type", r100.f186962v);
        if (r101 == null) goto L87;
        Iterator r121 = r101.entrySet().iterator();
    L76:
        if (r121.hasNext() == false) goto L87;
        Map.Entry r122 = (Map.Entry) r121.next();
        String r123 = (String) r122.getKey();
        String r124 = (String) r122.getValue();
        if (f186965a.contains(r123) == true) goto L76;
        if (r124 != null) goto L81;
    L84:
        boolean r125 = true;
    L85:
        if (r125 == true) goto L76;
        r118.put(r123, r124);
        goto L76
    L81:
        if (StringsKt.isBlank(r124) == true) goto L84;
        r125 = false;
    L87:
        JSONObject r126 = com.bytedance.android.shopping.extensions.k.w(r100.f186963w);
        if (r126 == null) goto L90;
        e(r118, "ecom_scene_id", r126.optString("ecom_scene_id"));
    L90:
        return r118;
    L16:
        if (Intrinsics.areEqual(r100.f186949i, "classification_secondary_page") == false) goto L19;
        r105 = "classification";
        goto L22
    L19:
        if (r100.f186960t == false) goto L21;
        r105 = "featured";
        goto L22
    L21:
        r105 = "products";
        goto L22
    L5:
        r104 = r100.f186950j;
        if (r104 != null) goto L8;
        r104 = "";
        goto L8
    }

    public static void e(JSONObject r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r100.put(r101, r102);
        return;
    L11:
        return;
    L4:
        if (StringsKt.isBlank(r102) == true) goto L7;
        r103 = false;
        goto L8
    }

    public static Map a(Map r100, q r101, String r102, int r103, PageFinder r104) {
        if (r100 == null) goto L5;
        Map r105 = MapsKt.toMutableMap(r100);
        if (r105 == null) goto L5;
    L6:
        r105.putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to("category_id", null), TuplesKt.to("tab_type", null), TuplesKt.to("page_version", null), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r101.f186941a), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, r101.f186943c), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, r101.f186944d), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, r101.f186945e), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, "0"), TuplesKt.to("search_params", r101.f186942b), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, "shop"), TuplesKt.to("product_form", r101.f186957q), TuplesKt.to("btm_index", String.valueOf(r103 + 1)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101.f186941a), TuplesKt.to("tab_name_second", r101.f186958r), TuplesKt.to("is_discount_selected", r101.f186959s), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product"), TuplesKt.to("bst_tag", "bst_tag")}));
        if (r101.f186946f == false) goto L9;
        r105.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r101.f186947g);
        r105.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, r101.f186948h);
    L9:
        Intrinsics.checkNotNullParameter(r105, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "btm");
        Intrinsics.checkNotNullParameter(r104, "pageFinder");
        Iterator<Map.Entry<String, Object>> r106 = BtmSDK.INSTANCE.createReportParams(r102, r104).entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L17;
        Map.Entry<String, Object> r107 = r106.next();
        String r108 = r107.getKey();
        Object r109 = r107.getValue();
        if (r109 == null) goto L15;
        String r110 = r109.toString();
    L16:
        r105.put(r108, r110);
        goto L11
    L15:
        r110 = null;
        goto L16
    L17:
        return r105;
    L5:
        r105 = new LinkedHashMap();
        goto L6
    }

    public static Map b(q r100, String r101, int r102, PageFinder r103, Integer r104, Integer r105, Integer r106, Map r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r103, "pageFinder");
        Map r108 = a(r107, r100, r101, r102, r103);
        if (r104 == null) goto L5;
        String r109 = (String) r108.put("product_view_num", String.valueOf(r104.intValue()));
    L5:
        if (r105 == null) goto L7;
        String r110 = (String) r108.put("product_total_num", String.valueOf(r105.intValue()));
    L7:
        if (r106 == null) goto L9;
        r108.put("product_click_index", String.valueOf(r106.intValue()));
    L9:
        return r108;
    }

    public static /* synthetic */ Map c(Map r110, q r111, String r112, int r113, PageFinder r114, Integer r115, Integer r116, Integer r117, int r118) {
        if ((r118 & 32) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r118 & 64) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r118 & 128) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r118 & 256) == 0) goto L17;
        Map r119 = r110;
    L19:
        return b(r111, r112, r113, r114, r100, r101, r102, r119);
    L17:
        r119 = null;
        goto L19
    L13:
        r102 = r117;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
