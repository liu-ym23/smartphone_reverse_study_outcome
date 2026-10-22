package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoCard;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static final Map<String, Object> a(BaseViewHolder r100, FeedbackData r110) {
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = 0;
        String r103 = "1";
        String r104 = "";
        CommonData.CardCommon r105 = null;
        if ((r100 instanceof NativeVideoCard) == false) goto L45;
        FeedbackData.NegFeedbackStyles r106 = r110.getNegFeedbackStyles();
        if (r106 == null) goto L11;
        FeedbackData.NegFeedbackElement r107 = r106.getType4();
        if (r107 == null) goto L11;
        List<FeedbackData.Item> r108 = r107.getItems();
        if (r108 == null) goto L11;
        int r109 = r108.size();
    L12:
        FeedbackData.NegFeedbackStyles r111 = r110.getNegFeedbackStyles();
        if (r111 == null) goto L19;
        FeedbackData.NegFeedbackElement r112 = r111.getType4();
        if (r112 == null) goto L19;
        Integer r113 = r112.getFirstPageLimit();
        if (r113 == null) goto L19;
        r102 = r113.intValue();
    L19:
        if (r109 > r102) goto L22;
        r103 = "0";
    L22:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_WITH_MORE, r103);
        NativeVideoCard r114 = (NativeVideoCard) r100;
        VideoCardData r115 = r114.O;
        if (r115 == null) goto L28;
        VideoCardData.Video r116 = r115.getVideo();
        if (r116 == null) goto L28;
        String r117 = r116.getItemId();
        if (r117 == null) goto L28;
    L29:
        r101.put("group_id", r117);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, "video");
        VideoCardData r118 = r114.O;
        if (r118 == null) goto L32;
        CommonData.Product r119 = r118.getProduct();
    L33:
        if (r119 == null) goto L35;
        String r120 = r119.getProductId();
    L36:
        VideoCardData r121 = r114.O;
        if (r121 == null) goto L39;
        String r122 = r121.rcPriorityFromProduct();
    L40:
        VideoCardData r123 = r114.O;
        if (r123 == null) goto L93;
        CommonData.CardCommon r124 = r123.getCardCommon();
    L43:
        r105 = r124;
    L93:
        if (r105 == null) goto L96;
        String r125 = r105.getResourceId();
        if (r125 == null) goto L96;
    L97:
        r101.put("resource_id", r125);
        if (r120 != null) goto L100;
        r120 = "";
    L100:
        r101.put("product_id", r120);
        if (r122 == null) goto L104;
        r104 = r122;
    L104:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r104);
        r101.put("enter_method", com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
        r101.put("outflow_order", Integer.valueOf(ToolsKt.g(r100)));
        r101.put("btm_index", Integer.valueOf(ToolsKt.g(r100) + 1));
        r101.put("request_id", ToolsKt.l(r100));
        r101.put("tab_id", ToolsKt.r(r100));
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, ToolsKt.s(r100));
        ECHybridListItemVO r126 = r100.f47152c;
        if (r126 == null) goto L111;
        n r127 = r126.f47041o;
        if (r127 == null) goto L111;
        Map<String, ? extends Object> r128 = r127.f47144f;
        if (r128 == null) goto L111;
        r101.putAll(r128);
    L111:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        return r101;
    L96:
        r125 = "";
        goto L97
    L39:
        r122 = null;
        goto L40
    L35:
        r120 = null;
        goto L36
    L32:
        r119 = null;
    L28:
        r117 = "";
    L11:
        r109 = 0;
        goto L12
    L45:
        if ((r100 instanceof BaseLiveViewHolder) == false) goto L92;
        FeedbackData.NegFeedbackStyles r129 = r110.getNegFeedbackStyles();
        if (r129 == null) goto L53;
        FeedbackData.NegFeedbackElement r130 = r129.getType1();
        if (r130 == null) goto L53;
        List<FeedbackData.Item> r131 = r130.getItems();
        if (r131 == null) goto L53;
        int r132 = r131.size();
    L54:
        FeedbackData.NegFeedbackStyles r133 = r110.getNegFeedbackStyles();
        if (r133 == null) goto L61;
        FeedbackData.NegFeedbackElement r134 = r133.getType1();
        if (r134 == null) goto L61;
        Integer r135 = r134.getFirstPageLimit();
        if (r135 == null) goto L61;
        r102 = r135.intValue();
    L61:
        if (r132 > r102) goto L64;
        r103 = "0";
    L64:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_WITH_MORE, r103);
        BaseLiveViewHolder r136 = (BaseLiveViewHolder) r100;
        LiveCardData r137 = r136.f177947u;
        if (r137 == null) goto L70;
        LiveCardData.Live r138 = r137.getLive();
        if (r138 == null) goto L70;
        String r139 = r138.getRoomId();
        if (r139 == null) goto L70;
    L71:
        r101.put("room_id", r139);
        LiveCardData r140 = r136.f177947u;
        if (r140 == null) goto L77;
        CommonData.User r141 = r140.getUser();
        if (r141 == null) goto L77;
        String r142 = r141.getId();
        if (r142 == null) goto L77;
    L78:
        r101.put("anchor_id", r142);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, "live");
        LiveCardData r143 = r136.f177947u;
        if (r143 == null) goto L81;
        CommonData.Product r144 = r143.getProduct();
    L82:
        if (r144 == null) goto L84;
        r120 = r144.getProductId();
    L85:
        LiveCardData r145 = r136.f177947u;
        if (r145 == null) goto L88;
        r122 = r145.rcPriorityFromProduct();
    L89:
        LiveCardData r146 = r136.f177947u;
        if (r146 == null) goto L93;
        r124 = r146.getCardCommon();
        goto L43
    L88:
        r122 = null;
        goto L89
    L84:
        r120 = null;
        goto L85
    L81:
        r144 = null;
    L77:
        r142 = "";
    L70:
        r139 = "";
    L53:
        r132 = 0;
        goto L54
    L92:
        r120 = null;
        r122 = null;
        goto L93
    }

    public static final void c(BaseViewHolder r100, FeedbackData r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$reportFeedbackClose");
        Intrinsics.checkNotNullParameter(r101, "feedbackData");
        Intrinsics.checkNotNullParameter(r102, "closeType");
        Map<String, Object> r103 = a(r100, r101);
        r103.put("close_type", r102);
        ToolsKt.x(r100, "close_ecom_dislike", null, r103, null);
    }

    public static final void b(BaseViewHolder r100, FeedbackData r101, String r102, FeedbackData.Item r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$reportFeedbackClick");
        Intrinsics.checkNotNullParameter(r101, "feedbackData");
        Intrinsics.checkNotNullParameter(r102, "clickArea");
        Map<String, Object> r104 = a(r100, r101);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r102);
        if (r103 == null) goto L5;
        Integer r105 = r103.getType();
    L6:
        if (r105 == null) goto L11;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CONFIRM_CONTENT, String.valueOf(r103.getType().intValue()));
        String r106 = r103.getText();
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r104.put("confirm_content_text", r106);
    L11:
        ToolsKt.x(r100, "click_ecom_dislike", "c9582.d09069", r104, null);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
