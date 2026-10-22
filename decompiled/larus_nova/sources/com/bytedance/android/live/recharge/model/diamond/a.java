package com.bytedance.android.live.recharge.model.diamond;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.recharge.platform.business.model.diamond.g;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\bI\u0010JR\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\n8\u0006X\u0087D¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010\u000eR\u001c\u0010*\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013R\u001c\u00104\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010\u0007R\u001a\u0010:\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0013R&\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020=0<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\bB\u0010\u0005\u001a\u0004\bC\u0010\u0007R&\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020D0<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010?\u001a\u0004\bF\u0010AR\u001c\u0010G\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010%\u001a\u0004\bH\u0010'¨\u0006K"}, d2 = {"Lcom/bytedance/android/live/recharge/model/diamond/a;", "Lcom/bytedance/android/live/base/model/Extra;", "Lcom/bytedance/revenue/platform/api/network/Extra;", "", "defaultChosenId", "J", "getDefaultChosenId", "()J", "firstPacketId", "getFirstPacketId", "", "recentlyPurchasedPacketId", "I", "getRecentlyPurchasedPacketId", "()I", "", "allowDiamondExchange", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/e;", "customChargeDeals", "Ljava/util/List;", "f", "()Ljava/util/List;", "customRecommendPrices", ce.f26391f, "defaultDiamondId", "h", "Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "cashierInfo", "Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "e", "()Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "", "bannerLynxUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "needManuallyAcceptAgreement", ce.f26396k, "diamondExtraSignInfo", ce.f26395j, "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "topPanelDiamond", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "allowedCombinationPay", "b", "Lcom/bytedance/android/livesdkapi/depend/model/IOneKeyPay;", "oneKeyPay", "Lcom/bytedance/android/livesdkapi/depend/model/IOneKeyPay;", "l", "()Lcom/bytedance/android/livesdkapi/depend/model/IOneKeyPay;", "recommendedDiamondId", "m", "isFirstRecharge", "o", "", "Lcom/bytedance/android/live/recharge/model/diamond/e;", "diamondExtraInfo", "Ljava/util/Map;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/Map;", "cacheStrategy", "d", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/g;", "panelExtraInfo", "getPanelExtraInfo", "bizExtra", "getBizExtra", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a extends Extra implements h {

    @SerializedName("allow_diamond_exchange")
    protected boolean allowDiamondExchange;

    @SerializedName("allowed_combination_pay")
    protected boolean allowedCombinationPay;

    @SerializedName("banner_lynx_url")
    protected String bannerLynxUrl;

    @SerializedName("biz_extra")
    protected String bizExtra;

    @SerializedName("cache_strategy")
    protected long cacheStrategy;

    @SerializedName("cashier_info")
    protected IPrePayCashierInfo cashierInfo;

    @SerializedName("customized_diamonds")
    protected List<com.bytedance.android.live.recharge.platform.business.model.diamond.e> customChargeDeals;

    @SerializedName("recommend_customed_price")
    protected List<Long> customRecommendPrices;

    @SerializedName("default_packet_id")
    protected long defaultChosenId;

    @SerializedName("default_diamond_id")
    protected long defaultDiamondId;

    @SerializedName("diamond_extra_info")
    protected Map<Long, e> diamondExtraInfo;

    @SerializedName("diamond_extra_for_create_order")
    protected String diamondExtraSignInfo;

    @SerializedName("first_charge_packet_id")
    protected long firstPacketId;

    @SerializedName("is_first_charge")
    protected boolean isFirstRecharge;

    @SerializedName("need_manually_accept_agreement")
    protected int needManuallyAcceptAgreement;

    @SerializedName("one_key_pay")
    protected IOneKeyPay oneKeyPay;

    @SerializedName("panel_extra_info_map")
    protected Map<Long, g> panelExtraInfo;

    @SerializedName("recently_purchased_packet_id")
    protected int recentlyPurchasedPacketId;

    @SerializedName("describe_recommended_diamond_id")
    protected long recommendedDiamondId;

    @SerializedName("top_panel_diamond")
    protected IChargeDeal topPanelDiamond;

    public a() {
        this.customChargeDeals = CollectionsKt.emptyList();
        this.customRecommendPrices = CollectionsKt.emptyList();
        this.diamondExtraInfo = MapsKt.emptyMap();
        this.panelExtraInfo = MapsKt.emptyMap();
    }

    public final boolean a() {
        return this.allowDiamondExchange;
    }

    public final boolean b() {
        return this.allowedCombinationPay;
    }

    public final String c() {
        return this.bannerLynxUrl;
    }

    public final long d() {
        return this.cacheStrategy;
    }

    public final IPrePayCashierInfo e() {
        return this.cashierInfo;
    }

    public final List<com.bytedance.android.live.recharge.platform.business.model.diamond.e> f() {
        return this.customChargeDeals;
    }

    public final List<Long> g() {
        return this.customRecommendPrices;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }

    public final Map<Long, g> getPanelExtraInfo() {
        return this.panelExtraInfo;
    }

    public final long h() {
        return this.defaultDiamondId;
    }

    public final Map<Long, e> i() {
        return this.diamondExtraInfo;
    }

    public final String j() {
        return this.diamondExtraSignInfo;
    }

    public final int k() {
        return this.needManuallyAcceptAgreement;
    }

    public final IOneKeyPay l() {
        return this.oneKeyPay;
    }

    public final long m() {
        return this.recommendedDiamondId;
    }

    public final IChargeDeal n() {
        return this.topPanelDiamond;
    }

    public final boolean o() {
        return this.isFirstRecharge;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.livesdkapi.depend.model.IChargeDeal, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.livesdkapi.depend.model.IOneKeyPay, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo, java.lang.Object] */
    public a(am3.g r110) {
        this.customChargeDeals = new ArrayList();
        this.customRecommendPrices = new ArrayList();
        this.diamondExtraInfo = new HashMap();
        this.panelExtraInfo = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L59;
        Long r102 = null;
        switch(r101) {
            case 2: goto L58;
            case 3: goto L57;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L56;
            case 11: goto L55;
            case 12: goto L53;
            case 13: goto L7;
            case 14: goto L52;
            case 15: goto L51;
            case 16: goto L50;
            case 17: goto L49;
            case 18: goto L48;
            case 19: goto L47;
            case 20: goto L46;
            case 21: goto L7;
            case 22: goto L7;
            case 23: goto L45;
            case 24: goto L44;
            case 25: goto L28;
            case 26: goto L27;
            case 27: goto L26;
            case 28: goto L7;
            case 29: goto L10;
            case 30: goto L7;
            case 31: goto L9;
            case 32: goto L8;
            default: goto L7;
        };
    L8:
        this.bizExtra = am3.h.c(r110);
        goto L3
    L9:
        this.diamondExtraSignInfo = am3.h.c(r110);
        goto L3
    L10:
        long r103 = r110.c();
        Object r104 = null;
    L11:
        int r111 = r110.f();
        if (r111 == (-1)) goto L18;
        if (r111 != 1) goto L14;
        r102 = Long.valueOf(r110.j());
        goto L11
    L14:
        if (r111 != 2) goto L15;
        r104 = f.a(r110, g.class);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map r105 = this.panelExtraInfo;
        if (r102 == null) goto L25;
        if (r104 == null) goto L23;
    L39:
        r105.put(r102, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.needManuallyAcceptAgreement = r110.i();
        goto L3
    L27:
        this.cacheStrategy = r110.j();
        goto L3
    L28:
        long r106 = r110.c();
        r104 = null;
    L29:
        int r112 = r110.f();
        if (r112 == (-1)) goto L36;
        if (r112 != 1) goto L32;
        r102 = Long.valueOf(r110.j());
        goto L29
    L32:
        if (r112 != 2) goto L33;
        r104 = f.a(r110, e.class);
        goto L29
    L33:
        am3.h.e(r110);
        goto L29
    L36:
        r110.d(r106);
        r105 = this.diamondExtraInfo;
        if (r102 == null) goto L43;
        if (r104 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L44:
        this.cashierInfo = f.a(r110, IPrePayCashierInfo.class);
        goto L3
    L45:
        this.isFirstRecharge = am3.h.a(r110);
        goto L3
    L46:
        this.recommendedDiamondId = r110.j();
        goto L3
    L47:
        this.allowedCombinationPay = am3.h.a(r110);
        goto L3
    L48:
        this.bannerLynxUrl = am3.h.c(r110);
        goto L3
    L49:
        this.oneKeyPay = f.a(r110, IOneKeyPay.class);
        goto L3
    L50:
        this.topPanelDiamond = f.a(r110, IChargeDeal.class);
        goto L3
    L51:
        this.defaultDiamondId = r110.j();
        goto L3
    L52:
        List r107 = this.customRecommendPrices;
        Object r108 = Long.valueOf(r110.j());
    L54:
        r107.add(r108);
        goto L3
    L53:
        r107 = this.customChargeDeals;
        r108 = f.a(r110, com.bytedance.android.live.recharge.platform.business.model.diamond.e.class);
        goto L54
    L55:
        this.recentlyPurchasedPacketId = (int) r110.j();
        goto L3
    L56:
        this.allowDiamondExchange = am3.h.a(r110);
        goto L3
    L57:
        this.firstPacketId = r110.j();
        goto L3
    L58:
        this.defaultChosenId = r110.j();
        goto L3
    L7:
        am3.h.e(r110);
        goto L3
    L59:
        r110.d(r100);
        if (this.customChargeDeals.isEmpty() == false) goto L63;
        this.customChargeDeals = CollectionsKt.emptyList();
    L63:
        if (this.customRecommendPrices.isEmpty() == false) goto L66;
        this.customRecommendPrices = CollectionsKt.emptyList();
    L66:
        if (this.diamondExtraInfo != null) goto L69;
        this.diamondExtraInfo = MapsKt.emptyMap();
    L69:
        if (this.panelExtraInfo != null) goto L136;
        this.panelExtraInfo = MapsKt.emptyMap();
        return;
    }
}
