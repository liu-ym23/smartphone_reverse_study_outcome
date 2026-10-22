package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\u0006\u0010$\u001a\u00020%R*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u0006&"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuExtraData;", "Ljava/io/Serializable;", "productTypeVerified", "", "brandVerified", "isCrossborderProduct", "", "goodsType", "isAuthenticInsure", "labelName", "labelNameLive", "hasReplay", "sourcePage", "withVideo", "marketChannel", "transitionTrackerData", "addCartTrackMeta", "", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAddCartTrackMeta", "()Ljava/util/Map;", "setAddCartTrackMeta", "(Ljava/util/Map;)V", "getBrandVerified", "()Ljava/lang/String;", "getGoodsType", "getHasReplay", "()Z", "getLabelName", "getLabelNameLive", "getMarketChannel", "getProductTypeVerified", "getSourcePage", "getTransitionTrackerData", "getWithVideo", "asJSONDescription", "Lorg/json/JSONObject;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuExtraData implements Serializable {
    private Map<String, ? extends Object> addCartTrackMeta;
    private final String brandVerified;
    private final String goodsType;
    private final String hasReplay;
    private final String isAuthenticInsure;
    private final boolean isCrossborderProduct;
    private final String labelName;
    private final String labelNameLive;
    private final String marketChannel;
    private final String productTypeVerified;
    private final String sourcePage;
    private final String transitionTrackerData;
    private final String withVideo;

    public SkuExtraData() {
        this(null, null, false, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("product_type_verified", this.productTypeVerified);
        r100.put(a.KEY_BRAND_VERIFIED, this.brandVerified);
        r100.put("is_cross_border_product", this.isCrossborderProduct);
        r100.put(a.KEY_GOODS_TYPE, this.goodsType);
        r100.put(a.KEY_IS_AUTHENTIC_INSURE, this.isAuthenticInsure);
        r100.put(a.KEY_LABEL_NAME, this.labelName);
        r100.put(a.KEY_LABEL_NAME_LIVE, this.labelNameLive);
        r100.put("has_replay", this.hasReplay);
        r100.put("source_page", this.sourcePage);
        r100.put("with_video", this.withVideo);
        r100.put("market_channel", this.marketChannel);
        r100.put("transition_tracker_data", this.transitionTrackerData);
        return r100;
    }

    public final Map<String, Object> getAddCartTrackMeta() {
        return this.addCartTrackMeta;
    }

    public final String getBrandVerified() {
        return this.brandVerified;
    }

    public final String getGoodsType() {
        return this.goodsType;
    }

    public final String getHasReplay() {
        return this.hasReplay;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final String getMarketChannel() {
        return this.marketChannel;
    }

    public final String getProductTypeVerified() {
        return this.productTypeVerified;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getTransitionTrackerData() {
        return this.transitionTrackerData;
    }

    public final String getWithVideo() {
        return this.withVideo;
    }

    public final String isAuthenticInsure() {
        return this.isAuthenticInsure;
    }

    public final boolean isCrossborderProduct() {
        return this.isCrossborderProduct;
    }

    public final void setAddCartTrackMeta(Map<String, ? extends Object> r100) {
        this.addCartTrackMeta = r100;
    }

    public SkuExtraData(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, Map<String, ? extends Object> r113) {
        this.productTypeVerified = r100;
        this.brandVerified = r101;
        this.isCrossborderProduct = r102;
        this.goodsType = r103;
        this.isAuthenticInsure = r104;
        this.labelName = r105;
        this.labelNameLive = r106;
        this.hasReplay = r107;
        this.sourcePage = r108;
        this.withVideo = r110;
        this.marketChannel = r111;
        this.transitionTrackerData = r112;
        this.addCartTrackMeta = r113;
    }

    public /* synthetic */ SkuExtraData(String r110, String r111, boolean r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, Map r217, int r218, DefaultConstructorMarker r219) {
        Map r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
