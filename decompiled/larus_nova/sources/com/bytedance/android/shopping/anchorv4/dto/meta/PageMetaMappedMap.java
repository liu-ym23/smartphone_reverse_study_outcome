package com.bytedance.android.shopping.anchorv4.dto.meta;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import h73.b;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u0004:\u0001\u000fB\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMetaMappedMap;", "Ljava/util/HashMap;", "", "", "Ljava/io/Serializable;", "key", MonitorConstants.CONNECT_TYPE_GET, "", "containsKey", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;", "originalPageMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageMetaMappedMap extends HashMap<String, Object> implements Serializable {
    public static final String COMMON_META_KEY = "common_meta";
    public static final String COMMON_META_V2_KEY = "common_meta_v2";
    public static final a Companion = null;
    public static final String PAGE_META_KEY = "page_meta";
    public static final String SERVER_MONITOR_META_KEY = "server_monitor_meta";
    public static final String SKU_META_KEY = "sku_meta";
    public static final String TRACK_META_KEY = "track_meta";

    @SerializedName(PAGE_META_KEY)
    private final PageMeta originalPageMeta;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public PageMetaMappedMap(PageMeta r100) {
        this.originalPageMeta = r100;
    }

    public boolean containsKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.hashCode() == 883666357) goto L6;
    L8:
        return false;
    L6:
        if (r100.equals(PAGE_META_KEY) == false) goto L8;
        return true;
    }

    public Object get(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Map<String, Object> r100 = null;
        if (r110.hashCode() == 883666357) goto L6;
        return null;
    L6:
        if (r110.equals(PAGE_META_KEY) == false) goto L30;
        Pair[] r101 = new Pair[5];
        PageMeta r102 = this.originalPageMeta;
        if (r102 == null) goto L12;
        CommonMeta r103 = r102.getCommonMeta();
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(r103, "$this$toCommonMetaMap");
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("transmissible_json", r103.getTransmissibleJson()), TuplesKt.to("source_page", r103.getSourcePage()), TuplesKt.to("enter_method", r103.getEnterMethod()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r103.getEntranceInfo()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_META_PARAM, r103.getMetaParam()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r103.getEComEntranceForm()), TuplesKt.to("from_live", Boolean.valueOf(r103.getFromLive())), TuplesKt.to("from_video", Boolean.valueOf(r103.getFromVideo())), TuplesKt.to("search_id", r103.getSearchId()), TuplesKt.to("search_params", r103.getSearchParams()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r103.getSourceMethod()), TuplesKt.to("normal_sku_id", r103.getNormalSkuId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r103.getCarrierSource()), TuplesKt.to("product_id", r103.getProductId()), TuplesKt.to("promotion_id", r103.getPromotionId()), TuplesKt.to(PriorityModule.SCENE_THIRD_PARTY, Boolean.valueOf(r103.getThirdParty())), TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, Long.valueOf(r103.getPromotionSource())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r103.getShopId()), TuplesKt.to("group_id", r103.getGroupId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r103.getBrandVerified()), TuplesKt.to("is_cross_border_product", Boolean.valueOf(r103.isCrossBorderProduct())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS, r103.getRequestAdditions()), TuplesKt.to("pay_type", r103.getPayType()), TuplesKt.to("presell_type", Integer.valueOf(r103.getPresellType())), TuplesKt.to("product_type", Integer.valueOf(r103.getProductType())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DISCOUNT_MIN_PRICE, r103.getDiscountMinPrice()), TuplesKt.to("product_min_price", r103.getProductMinPrice()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE, r103.getRegularPrice()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SUBSIDY_PRICE, r103.getSubsidyPrice()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SUBSIDY_MARKET_PRICE, r103.getSubsidyMarketPrice()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r103.getSkuId()), TuplesKt.to(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, r103.getLiveRoomId()), TuplesKt.to("item_id", r103.getItemId()), TuplesKt.to("author_id", r103.getAuthorId()), TuplesKt.to("product_is_invalid", Boolean.valueOf(r103.getProductIsInvalid())), TuplesKt.to("comment_enter_from", Integer.valueOf(r103.getCommentEnterFrom())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, r103.getButtonStatus()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_BUY_STATUS, r103.getProductBuyStatus()), TuplesKt.to("channel_id", r103.getChannelId()), TuplesKt.to(WsConstants.KEY_CHANNEL_TYPE, r103.getChannelType())});
    L13:
        r101[0] = TuplesKt.to(COMMON_META_KEY, r111);
        PageMeta r112 = this.originalPageMeta;
        if (r112 == null) goto L16;
        LinkedTreeMap<String, Object> r113 = r112.getTrackMeta();
    L17:
        r101[1] = TuplesKt.to(TRACK_META_KEY, r113);
        PageMeta r114 = this.originalPageMeta;
        if (r114 == null) goto L20;
        b r115 = r114.getSkuMeta();
    L21:
        r101[2] = TuplesKt.to(SKU_META_KEY, r115);
        PageMeta r116 = this.originalPageMeta;
        if (r116 == null) goto L24;
        Map<String, String> r117 = r116.getServerMonitorMeta();
    L25:
        r101[3] = TuplesKt.to(SERVER_MONITOR_META_KEY, r117);
        PageMeta r118 = this.originalPageMeta;
        if (r118 == null) goto L28;
        r100 = r118.getCommonMetaV2();
    L28:
        r101[4] = TuplesKt.to(COMMON_META_V2_KEY, r100);
        return MapsKt.mapOf(r101);
    L24:
        r117 = null;
        goto L25
    L20:
        r115 = null;
        goto L21
    L16:
        r113 = null;
    L12:
        r111 = null;
        goto L13
    L30:
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    public /* bridge */ Object remove(String r100) {
        return super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if (r100 == null) goto L4;
        boolean r102 = r100 instanceof String;
    L5:
        if (r102 == true) goto L8;
        return r101;
    L8:
        return getOrDefault((String) r100, r101);
    L4:
        r102 = true;
        goto L5
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if (r100 == null) goto L4;
        boolean r102 = r100 instanceof String;
    L5:
        if (r102 == true) goto L9;
        return false;
    L9:
        return remove((String) r100, r101);
    L4:
        r102 = true;
        goto L5
    }

    public /* bridge */ Object getOrDefault(String r100, Object r101) {
        return super.getOrDefault(r100, r101);
    }

    public /* bridge */ boolean remove(String r100, Object r101) {
        return super.remove(r100, r101);
    }
}
