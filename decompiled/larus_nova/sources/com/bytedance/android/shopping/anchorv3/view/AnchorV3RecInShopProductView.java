package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.shopping.anchorv3.repository.dto.AdditionalInfoStruct;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionReInShopProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendLogInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.facebook.drawee.view.GenericDraweeView;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002R0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3RecInShopProductView;", "Landroid/widget/FrameLayout;", "", "getBtm", "Lkotlin/Function1;", "", "", "c", "Lkotlin/jvm/functions/Function1;", "getLogScanCb", "()Lkotlin/jvm/functions/Function1;", "setLogScanCb", "(Lkotlin/jvm/functions/Function1;)V", "logScanCb", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3RecInShopProductView extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f165464e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f165465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommonMeta f165466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f165467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f165468d;

    public AnchorV3RecInShopProductView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3RecInShopProductView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getBtm() {
        return "a1.b8094.c14667.d7374_i" + (this.f165468d + 1);
    }

    public final Function1<Integer, Unit> getLogScanCb() {
        return this.f165467c;
    }

    public static final /* synthetic */ String b(AnchorV3RecInShopProductView r100) {
        return r100.getBtm();
    }

    public final View a(int r100) {
        if (this.f165465a != null) goto L5;
        this.f165465a = new LinkedHashMap();
    L5:
        View r101 = this.f165465a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f165465a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setLogScanCb(Function1<? super Integer, Unit> r100) {
        this.f165467c = r100;
    }

    public AnchorV3RecInShopProductView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165465a = new LinkedHashMap();
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v3_rec_in_shop_product_layout, this, true);
    }

    public /* synthetic */ AnchorV3RecInShopProductView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void c(AnchorV3RecInShopProductView r110, RecommendInShopProductStruct r111, AnchorV4VM r112, int r113) {
        r110.getClass();
        if (r112 == null) goto L59;
        BtmItemBuilder r100 = new BtmItemBuilder(r110.getBtm(), Boolean.FALSE).withView(r110);
        r100.internalSetUnitParams("description", new BcmParams());
        String r101 = r100.createBtmId();
        int r102 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r103 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r112);
        if (r103 == null) goto L60;
        String r104 = null;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r110) == false) goto L9;
        AnchorV4TrackerImpl r105 = r103;
    L10:
        if (r105 == null) goto L61;
        Pair[] r114 = new Pair[15];
        r114[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
        CommonMeta r106 = r112.commonMeta();
        if (r106 == null) goto L14;
        String r107 = r106.getSourceMethod();
    L15:
        r114[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r107);
        CommonMeta r108 = r112.commonMeta();
        if (r108 == null) goto L18;
        String r109 = r108.getCarrierSource();
    L19:
        r114[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r109);
        r114[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        r114[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        r114[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        r114[6] = TuplesKt.to("source_page", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        AdditionalInfoStruct r115 = r111.getAdditionalInfo();
        if (r115 == null) goto L24;
        RecommendLogInfo r116 = r115.getRecommendLogInfo();
        if (r116 == null) goto L24;
        Integer r117 = r116.getCommodityType();
    L25:
        r114[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, String.valueOf(r117));
        PromotionReInShopProductStruct r118 = r111.getBaseInfo();
        if (r118 == null) goto L28;
        String r119 = r118.getProductId();
    L29:
        r114[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r119);
        PromotionReInShopProductStruct r120 = r111.getBaseInfo();
        if (r120 == null) goto L32;
        String r121 = r120.getProductId();
    L33:
        r114[9] = TuplesKt.to("product_id", r121);
        AdditionalInfoStruct r122 = r111.getAdditionalInfo();
        if (r122 == null) goto L38;
        RecommendLogInfo r123 = r122.getRecommendLogInfo();
        if (r123 == null) goto L38;
        String r124 = r123.getRequestId();
    L39:
        r114[10] = TuplesKt.to("request_id", r124);
        AdditionalInfoStruct r125 = r111.getAdditionalInfo();
        if (r125 == null) goto L44;
        RecommendLogInfo r126 = r125.getRecommendLogInfo();
        if (r126 == null) goto L44;
        String r127 = r126.getRecommendInfo();
    L45:
        r114[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r127);
        LinkedTreeMap<String, Object> r128 = r112.trackMeta();
        if (r128 == null) goto L48;
        Object r129 = r128.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L50:
        if ((r129 instanceof String) == true) goto L52;
        r129 = null;
    L52:
        String r130 = (String) r129;
        if (r130 == null) goto L57;
        JSONObject r131 = com.bytedance.android.shopping.extensions.k.w(r130);
        if (r131 == null) goto L57;
        r131.remove("creative_id");
        r131.remove("is_other_channel");
        r131.remove("log_extra");
        Unit r132 = Unit.INSTANCE;
        r104 = r131.toString();
    L57:
        r114[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r104);
        r114[13] = TuplesKt.to("is_other_channel", "");
        r114[14] = TuplesKt.to("btm_id", r101);
        Map<String, ? extends Object> r133 = MapsKt.mutableMapOf(r114);
        com.bytedance.android.bst.api.f.f(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        Unit r134 = Unit.INSTANCE;
        r105.f167498c = r133;
        AnchorV4TrackerImpl.b(r105, com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT, false, String.valueOf(r113), false, null, 24);
        return;
    L48:
        r129 = null;
    L44:
        r127 = null;
    L38:
        r124 = null;
        goto L39
    L32:
        r121 = null;
        goto L33
    L28:
        r119 = null;
    L24:
        r117 = null;
        goto L25
    L18:
        r109 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L61:
        return;
    L9:
        r105 = null;
        goto L10
    L60:
        return;
    }

    public final void d(int r210, final RecommendInShopProductStruct r310, CommonMeta r311, final AnchorV4VM r312) {
        Intrinsics.checkNotNullParameter(r310, MapController.ITEM_LAYER_TAG);
        this.f165468d = r210;
        RoundedFrameLayout r100 = (RoundedFrameLayout) a(R.id.rec_in_shop_image_container);
        if (r312 == null) goto L7;
        CommonMeta r101 = r312.commonMeta();
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.getEnablePDPOptimize());
    L9:
        if (com.bytedance.android.shopping.extensions.k.i(r102) == false) goto L11;
        int r103 = 8;
    L12:
        r100.setRadius(vf4.a.b(r103));
        a(R.id.anchor_v3_tv_rec_in_shop_sales).setVisibility(8);
        ViewGroup.LayoutParams r104 = ((TextView) a(R.id.tv_rec_in_shop_title)).getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        r104 = null;
    L15:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L18;
        r105.setMargins(0, vf4.a.b(8), 0, 0);
    L18:
        this.f165466b = r311;
        PromotionReInShopProductStruct r106 = r310.getBaseInfo();
        if (r106 == null) goto L23;
        List<ECUrlModel> r107 = r106.getImages();
        if (r107 == null) goto L23;
        ECUrlModel r108 = (ECUrlModel) CollectionsKt.getOrNull(r107, 0);
    L24:
        PromotionReInShopProductStruct r110 = r310.getBaseInfo();
        if (r110 == null) goto L27;
        ImageMonitorMeta r111 = r110.getImageMonitorMeta();
    L28:
        ((SquareImageView) a(R.id.rec_in_shop_image)).setLayoutParams(((SquareImageView) a(R.id.rec_in_shop_image)).getLayoutParams());
        if (r111 == null) goto L31;
        ImageExtensionsKt.D((GenericDraweeView) a(R.id.rec_in_shop_image), q73.b.a(r111));
    L31:
        if (r108 == null) goto L33;
        com.bytedance.android.ec.core.utils.y.c((GenericDraweeView) a(R.id.rec_in_shop_image), r108, -1, -1, new z53.a(r108.getUrlList(), ImagePosition.STORE_RECOMMEND_GOODS.getValue(), null, false, 28));
    L33:
        PromotionReInShopProductStruct r109 = r310.getBaseInfo();
        if (r109 == null) goto L36;
        String r112 = r109.getTitle();
    L37:
        ((TextView) a(R.id.tv_rec_in_shop_title)).setText(r112);
        PromotionProductPrice r113 = r310.getPrice();
        PromotionReInShopProductStruct r114 = r310.getBaseInfo();
        if (r114 == null) goto L42;
        Long r115 = r114.getSales();
        if (r115 == null) goto L42;
        long r116 = r115.longValue();
    L43:
        if (r312 == null) goto L47;
        CommonMeta r117 = r312.commonMeta();
        if (r117 == null) goto L47;
        Boolean r118 = Boolean.valueOf(r117.getEnablePDPOptimize());
    L48:
        final boolean r119 = com.bytedance.android.shopping.extensions.k.i(r118);
        if (r113 == null) goto L51;
        final Long r120 = r113.getMinPrice();
    L52:
        TextView r121 = (TextView) a(R.id.anchor_v3_tv_rec_in_shop_sales);
        int r122 = g1.f45599a;
        r121.setText(g1.a.c(getContext(), R.string.commerce_seeds_sell_count, new Object[]{k0.a(r116)}));
        ((PriceView) a(R.id.anchor_v3_rec_in_shop_price)).C(new AnchorV3RecInShopProductView$bindPriceAndSales$1(this, r119, r120));
        CommonMeta r123 = this.f165466b;
        if (r123 == null) goto L83;
        String r124 = r123.getEntranceInfo();
        if (r124 == null) goto L83;
        JSONObject r125 = com.bytedance.android.shopping.extensions.k.w(r124);
        if (r125 == null) goto L83;
        r125.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        r125.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        if (r312 == null) goto L63;
        CommonMeta r126 = r312.commonMeta();
        if (r126 == null) goto L63;
        String r127 = r126.getButtonStatus();
    L64:
        r125.put(com.bytedance.android.ec.core.event.a.KEY_PD_BUTTON_STATUS, r127);
        AdditionalInfoStruct r128 = r310.getAdditionalInfo();
        if (r128 == null) goto L69;
        RecommendLogInfo r129 = r128.getRecommendLogInfo();
        if (r129 == null) goto L69;
        String r130 = r129.getRecommendInfo();
    L70:
        r125.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r130);
        r125.remove("author_id");
        r125.remove("sec_author_id");
        r125.remove(com.bytedance.android.ec.core.event.a.KEY_APT_PATH_ID);
        String r131 = r125.optString("ecom_scene_id");
        if (r131 != null) goto L73;
    L76:
        boolean r132 = true;
    L77:
        String r133 = "1063";
        if (r132 == true) goto L81;
        List r134 = CollectionsKt.toMutableList(StringsKt.split$default(r131, new String[]{","}, false, 0, 6, null));
        r134.remove("1063");
        r134.add("1063");
        r133 = CollectionsKt.joinToString$default(r134, ",", null, null, 0, null, null, 62, null);
    L81:
        r125.put("ecom_scene_id", r133);
        final String r135 = r125.toString();
        if (r135 == null) goto L83;
    L87:
        final Function0<Unit> r136 = new AnchorV3RecInShopProductView$fillWithCommonMeta$clickItemListener$1(this, r310, r135, r312);
        com.bytedance.android.ec.core.widget.f.c(a(R.id.item_round), null, null, new AnchorV3RecInShopProductView$fillWithCommonMeta$1(this, r136, r310, r312), 3);
        this.f165467c = new AnchorV3RecInShopProductView$fillWithCommonMeta$2(this, r310, r312);
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == false) goto L186;
        PromotionReInShopProductStruct r137 = r310.getBaseInfo();
        if (r137 == null) goto L92;
        String r138 = r137.getProductId();
    L93:
        int r139 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
        AnchorV4TrackerImpl r140 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r312);
        if (r138 != null) goto L96;
    L99:
        boolean r141 = true;
    L100:
        if (r141 == true) goto L178;
        if (r140 == null) goto L178;
        if (r312 == null) goto L178;
        LinkedHashMap r142 = new LinkedHashMap();
        com.bytedance.android.shopping.base.event.b r143 = r140.f167496a;
        if (r143 == null) goto L109;
        Map<String, Object> r144 = r143.getEventParams();
        if (r144 == null) goto L109;
        r142.putAll(r144);
    L109:
        LinkedHashMap r145 = new LinkedHashMap();
        Map<String, ? extends Object> r146 = r140.f167499d;
        if (r146 == null) goto L112;
        r145.putAll(r146);
    L112:
        Pair[] r147 = new Pair[14];
        r147[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
        CommonMeta r148 = r312.commonMeta();
        if (r148 == null) goto L115;
        String r149 = r148.getSourceMethod();
    L116:
        r147[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r149);
        CommonMeta r150 = r312.commonMeta();
        if (r150 == null) goto L119;
        String r151 = r150.getCarrierSource();
    L120:
        r147[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r151);
        r147[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        r147[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        r147[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, com.bytedance.android.ec.core.event.a.VALUE_STORE_RECOMMEND);
        r147[6] = TuplesKt.to("source_page", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        AdditionalInfoStruct r152 = r310.getAdditionalInfo();
        if (r152 == null) goto L125;
        RecommendLogInfo r153 = r152.getRecommendLogInfo();
        if (r153 == null) goto L125;
        Integer r154 = r153.getCommodityType();
    L126:
        r147[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, String.valueOf(r154));
        PromotionReInShopProductStruct r155 = r310.getBaseInfo();
        if (r155 == null) goto L129;
        String r156 = r155.getProductId();
    L130:
        r147[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r156);
        PromotionReInShopProductStruct r157 = r310.getBaseInfo();
        if (r157 == null) goto L133;
        String r158 = r157.getProductId();
    L134:
        r147[9] = TuplesKt.to("product_id", r158);
        AdditionalInfoStruct r159 = r310.getAdditionalInfo();
        if (r159 == null) goto L139;
        RecommendLogInfo r160 = r159.getRecommendLogInfo();
        if (r160 == null) goto L139;
        String r161 = r160.getRequestId();
    L140:
        r147[10] = TuplesKt.to("request_id", r161);
        AdditionalInfoStruct r162 = r310.getAdditionalInfo();
        if (r162 == null) goto L145;
        RecommendLogInfo r163 = r162.getRecommendLogInfo();
        if (r163 == null) goto L145;
        String r164 = r163.getRecommendInfo();
    L146:
        r147[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r164);
        LinkedTreeMap<String, Object> r165 = r312.trackMeta();
        if (r165 == null) goto L149;
        Object r166 = r165.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L151:
        if ((r166 instanceof String) == true) goto L153;
        r166 = null;
    L153:
        String r167 = (String) r166;
        if (r167 == null) goto L158;
        JSONObject r168 = com.bytedance.android.shopping.extensions.k.w(r167);
        if (r168 == null) goto L158;
        r168.remove("creative_id");
        r168.remove("is_other_channel");
        r168.remove("log_extra");
        Unit r169 = Unit.INSTANCE;
        String r170 = r168.toString();
    L159:
        r147[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r170);
        r147[13] = TuplesKt.to("is_other_channel", "");
        r145.putAll(MapsKt.mutableMapOf(r147));
        LinkedHashMap r171 = new LinkedHashMap();
        Iterator r172 = r145.entrySet().iterator();
    L161:
        if (r172.hasNext() == false) goto L168;
        Map.Entry r173 = (Map.Entry) r172.next();
        if (r173.getValue() == null) goto L165;
        boolean r174 = true;
    L166:
        if (r174 == false) goto L161;
        r171.put(r173.getKey(), r173.getValue());
        goto L161
    L165:
        r174 = false;
        goto L166
    L168:
        ArrayList r175 = new ArrayList(r171.size());
        Iterator r176 = r171.entrySet().iterator();
    L170:
        if (r176.hasNext() == false) goto L172;
        Map.Entry r177 = (Map.Entry) r176.next();
        Object r178 = r177.getKey();
        int r179 = ga3.a.f480548a;
        r175.add(TuplesKt.to(r178, ga3.a.a(r177.getValue())));
        goto L170
    L172:
        MapsKt.putAll(r142, r175);
        Intrinsics.checkNotNull(r138);
        wc.c r180 = new wc.c(r138, 0, "product", 1);
        r180.getExtraInfo().putAll(r142);
        ArrayList r181 = new ArrayList();
        LinkedHashMap r182 = new LinkedHashMap();
        ArrayList r183 = new ArrayList();
        String r184 = getBtm();
        r182.put("description", new BcmParams());
        if (r184 == null) goto L175;
        com.bytedance.android.bst.api.b r185 = new com.bytedance.android.bst.api.b(this, r184);
        r185.f41899a = r180;
        r185.f41900b = r310;
        r185.f41901c.addAll(r183);
        r185.f41902d.putAll(r182);
        ((ArrayList) r185.f41903e).addAll(r181);
        com.bytedance.android.bst.api.b r186 = r185;
    L176:
        if (r186 == null) goto L187;
        com.bytedance.android.bst.api.f.b(r186);
        return;
    L187:
        return;
    L175:
        r186 = null;
    L158:
        r170 = null;
        goto L159
    L149:
        r166 = null;
    L145:
        r164 = null;
    L139:
        r161 = null;
        goto L140
    L133:
        r158 = null;
        goto L134
    L129:
        r156 = null;
    L125:
        r154 = null;
        goto L126
    L119:
        r151 = null;
        goto L120
    L115:
        r149 = null;
    L178:
        ExtKt.b("AnchorV3RecInShopProductView", "info error!! productId:" + r138 + "  tracker:" + r140 + " viewModel:" + r312);
        return;
    L96:
        if (r138.length() == 0) goto L99;
        r141 = false;
        goto L100
    L92:
        r138 = null;
        goto L93
    L186:
        return;
    L73:
        if (r131.length() == 0) goto L76;
        r132 = false;
    L69:
        r130 = null;
    L63:
        r127 = null;
    L83:
        CommonMeta r187 = this.f165466b;
        if (r187 == null) goto L86;
        r135 = r187.getEntranceInfo();
        goto L87
    L86:
        r135 = null;
        goto L87
    L51:
        r120 = null;
    L47:
        r118 = null;
    L42:
        r116 = 0;
        goto L43
    L36:
        r112 = null;
        goto L37
    L27:
        r111 = null;
    L23:
        r108 = null;
        goto L24
    L11:
        r103 = 4;
    L7:
        r102 = null;
        goto L9
    }
}
