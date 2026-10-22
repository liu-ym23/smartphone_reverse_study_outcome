package com.bytedance.android.live.recharge.deal.aio;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.recharge.platform.business.model.diamond.g;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/c;", "", "", "defaultDealId", "J", "getDefaultDealId", "()J", "f", "(J)V", "", "Lcom/bytedance/android/live/recharge/deal/aio/b;", "deals", "Ljava/util/List;", "getDeals", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/recharge/deal/aio/a;", "customDeals", "getCustomDeals", "d", "", "isCombinationPay", "Z", "()Z", "c", "(Z)V", "needManuallyAcceptAgreement", "getNeedManuallyAcceptAgreement", ce.f26391f, "allowDiamondExchange", "getAllowDiamondExchange", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "recommendDiamondId", "Ljava/lang/Long;", "getRecommendDiamondId", "()Ljava/lang/Long;", ce.f26396k, "(Ljava/lang/Long;)V", "", "recommendCustomPrices", "getRecommendCustomPrices", ce.f26395j, "", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/g;", "panelExtraInfoMap", "Ljava/util/Map;", "getPanelExtraInfoMap", "()Ljava/util/Map;", "h", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "prePayCashierInfo", "Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "getPrePayCashierInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", RXScreenCaptureService.KEY_INDEX, "(Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;)V", "", "bizExtra", "Ljava/lang/String;", "getBizExtra", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.deal.DealSet")
public final class c {

    @SerializedName("allow_diamond_exchange")
    private boolean allowDiamondExchange;

    @SerializedName("biz_extra")
    private String bizExtra;

    @SerializedName("custom_deals")
    private List<a> customDeals;

    @SerializedName("regular_deals")
    private List<? extends b> deals;

    @SerializedName("default_id")
    private long defaultDealId;

    @SerializedName("is_combination_pay")
    private boolean isCombinationPay;

    @SerializedName("need_manually_accept_agreement")
    private boolean needManuallyAcceptAgreement;

    @SerializedName("panel_extra_info_map")
    private Map<Long, ? extends g> panelExtraInfoMap;

    @SerializedName("pre_pay_cashier_info")
    private IPrePayCashierInfo prePayCashierInfo;

    @SerializedName("recommend_custom_prices")
    private List<Integer> recommendCustomPrices;

    @SerializedName("recommend_diamond_id")
    private Long recommendDiamondId;

    public c() {
    }

    public final void a(boolean r100) {
        this.allowDiamondExchange = r100;
    }

    public final void b(String r100) {
        this.bizExtra = r100;
    }

    public final void c(boolean r100) {
        this.isCombinationPay = r100;
    }

    public final void d(List<a> r100) {
        this.customDeals = r100;
    }

    public final void e(List<? extends b> r100) {
        this.deals = r100;
    }

    public final void f(long r100) {
        this.defaultDealId = r100;
    }

    public final void g(boolean r100) {
        this.needManuallyAcceptAgreement = r100;
    }

    public final void h(Map<Long, ? extends g> r100) {
        this.panelExtraInfoMap = r100;
    }

    public final void i(IPrePayCashierInfo r100) {
        this.prePayCashierInfo = r100;
    }

    public final void j(List<Integer> r100) {
        this.recommendCustomPrices = r100;
    }

    public final void k(Long r100) {
        this.recommendDiamondId = r100;
    }
}
