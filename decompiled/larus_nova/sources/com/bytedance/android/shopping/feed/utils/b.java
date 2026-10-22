package com.bytedance.android.shopping.feed.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175437a = 0;

    public b() {
    }

    static {
    }

    public static String d(String r100) {
        JSONObject r101 = z1.g(r100);
        if (r101 == null) goto L11;
        JSONObject r102 = z1.g(r101.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        if (r102 == null) goto L7;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
    L7:
        if (r102 == null) goto L9;
        String r103 = r102.toString();
    L10:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r103);
        goto L11
    L9:
        r103 = null;
    L11:
        if (r101 != null) goto L13;
        return null;
    L13:
        return r101.toString();
    }

    public static boolean e(String r100) {
        if (r100 == null) goto L10;
        JSONObject r101 = z1.g(r100);
        if (r101 == null) goto L10;
        if (Intrinsics.areEqual(r101.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL), "guess_you_like_product") == false) goto L10;
        if (r101.optBoolean("is_product_flow_page") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static String b(String r100, rd3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        r102.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "product_flow_page_store_card");
        if (r101 == null) goto L12;
        ProductFeedViewModel r103 = r101.f537236c;
        if (r103 == null) goto L12;
        AnchorV3Param r104 = r103.m8290getAnchorV3Param();
        if (r104 == null) goto L12;
        ECLogExtraData r105 = r104.getLogExtraData();
        if (r105 == null) goto L12;
        String r106 = r105.getEnterFrom();
        if (r106 == null) goto L12;
    L13:
        r102.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r106);
        if (r101 == null) goto L24;
        ProductFeedViewModel r107 = r101.f537236c;
        if (r107 == null) goto L24;
        AnchorV3Param r108 = r107.m8290getAnchorV3Param();
        if (r108 == null) goto L24;
        String r109 = r108.getEntranceInfo();
        if (r109 == null) goto L24;
        JSONObject r110 = z1.g(r109);
        if (r110 == null) goto L24;
        String r111 = r110.optString(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, "");
    L25:
        r102.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r111);
        r102.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "video");
        r102.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        return r102.toString();
    L24:
        r111 = null;
    L12:
        r106 = "";
        goto L13
    }

    public static String a(rd3.a r110, String r111, AnchorV3Param r112) {
        JSONObject r100 = new JSONObject();
        if (r110 == null) goto L5;
        boolean r101 = r110.f537238e;
    L6:
        String r102 = null;
        if (r110 == null) goto L11;
        Promotion r103 = r110.f();
        if (r103 == null) goto L11;
        PromotionProductStruct r104 = r103.getPromotionInfo();
    L13:
        if (r101 == false) goto L45;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, "guess_you_like_product");
        if (r110 == null) goto L19;
        rd3.g r105 = r110.d();
        if (r105 == null) goto L19;
        String r106 = r105.a();
    L20:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r106);
        if (r110 == null) goto L23;
        String r107 = r110.f537237d;
    L24:
        r100.put("request_id", r107);
        if (r110 == null) goto L27;
        Integer r108 = Integer.valueOf(r110.f537239f);
    L28:
        r100.put("display_rank", r108);
        if (r110 == null) goto L31;
        String r109 = r110.c();
    L32:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r109);
        r100.put("is_product_flow_page", true);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
        ArrayList r113 = new ArrayList();
        if (a2.b(r111) == false) goto L42;
        if (r111 == null) goto L42;
        List r114 = StringsKt.split$default(r111, new String[]{","}, false, 0, 6, null);
        if (r114 == null) goto L42;
        Iterator r115 = r114.iterator();
    L39:
        if (r115.hasNext() == false) goto L42;
        r113.add((String) r115.next());
    L42:
        if (r113.contains("1064") == true) goto L44;
        r113.add("1061");
    L44:
        r100.put("ecom_scene_id", CollectionsKt.joinToString$default(r113, ",", null, null, 0, null, null, 62, null));
    L46:
        if (r110 == null) goto L51;
        ProductFeedViewModel r116 = r110.f537236c;
        if (r116 == null) goto L51;
        AnchorV3Param r117 = r116.m8290getAnchorV3Param();
        if (r117 == null) goto L51;
    L52:
        if (r117 == null) goto L54;
        String r118 = r117.getAuthorId();
    L55:
        r100.put("author_id", r118);
        if (r110 == null) goto L58;
        String r119 = r110.f537247m;
    L59:
        r100.put("inflow_product_card_mode", r119);
        if (r110 == null) goto L65;
        ProductFeedViewModel r120 = r110.f537236c;
        if (r120 == null) goto L65;
        AnchorV3Param r121 = r120.m8290getAnchorV3Param();
        if (r121 == null) goto L65;
    L66:
        if (r121 == null) goto L70;
        ECLogExtraData r122 = r121.getLogExtraData();
        if (r122 == null) goto L70;
        r102 = r122.getInflowRecommendType();
    L70:
        r100.put("inflow_recommend_type", r102);
        if (r104 == null) goto L84;
        PromotionProductExtraStruct r123 = r104.getExtraInfo();
        if (r123 == null) goto L84;
        String r124 = r123.getEntranceInfo();
        if (r124 == null) goto L84;
        JSONObject r125 = z1.g(r124);
        if (r125 == null) goto L84;
        Iterator<String> r126 = r125.keys();
        if (r126 == null) goto L84;
    L81:
        if (r126.hasNext() == false) goto L84;
        String r127 = r126.next();
        r100.put(r127, r125.get(r127));
    L84:
        return r100.toString();
    L65:
        r121 = r112;
        goto L66
    L58:
        r119 = null;
        goto L59
    L54:
        r118 = null;
    L51:
        r117 = r112;
        goto L52
    L31:
        r109 = null;
        goto L32
    L27:
        r108 = null;
        goto L28
    L23:
        r107 = null;
    L19:
        r106 = null;
        goto L20
    L45:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "video");
    L11:
        r104 = null;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public static String c(PromotionProductStruct r100, AnchorV3Param r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "promotionProductStruct");
        Object r103 = null;
        if (r101 == null) goto L17;
        String r104 = r101.getEntranceInfo();
        if (r104 == null) goto L17;
        JSONObject r105 = z1.g(r104);
        if (r105 == null) goto L17;
        if (r102 == false) goto L11;
        r105.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
        r105.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, "guess_you_like_product");
    L12:
        PromotionProductBaseStruct r106 = r100.getBaseInfo();
        if (r106 == null) goto L15;
        r103 = r106.getPromotionId();
    L15:
        r103 = r105.put("promotion_id", r103);
        goto L17
    L11:
        r105.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "video");
    L17:
        return String.valueOf(r103);
    }
}
