package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.CJUnifyPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.adapter.CJUnifyPayAdapterModel;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.adapter.CJUnifyPayAdapterProxy;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants.CJUnifyPayConstants;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b-\u0018\u00002\u00020\u0001Bë\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\u0006\u0010G\u001a\u00020\u0003J\u0006\u0010H\u001a\u00020\u0003J\u0006\u0010I\u001a\u00020\u0003J\u0006\u0010J\u001a\u00020\u0003J\b\u0010K\u001a\u0004\u0018\u00010\u0005J\u0006\u0010L\u001a\u00020\u0003R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010)\"\u0004\b0\u00101R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010)\"\u0004\b8\u00101R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010;R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayProcessParams;", "", e.f25671s, "", "verifyParams", "Lorg/json/JSONObject;", "currentMethod", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "currentAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "integratedProcessInfo", "payNewCardParams", "processPassThrough", "jhSignToken", "jhConfirmExts", "promotionParams", "payAndXTypeList", "", "unifyPayAdapter", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;", "unifyCashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "jhPassThrough", "specifiedPayMethod", "standardProcessInfo", "standardTradeInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeInfo;", "voucherExpandResult", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "isStandardFlow", "", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/util/List;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeInfo;Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;Z)V", "getCurrentAssetInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "getCurrentMethod", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "getHostInfo", "()Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "getIntegratedProcessInfo", "()Ljava/lang/String;", "()Z", "getJhConfirmExts", "()Lorg/json/JSONObject;", "getJhPassThrough", "getJhSignToken", "getMethod", "setMethod", "(Ljava/lang/String;)V", "getPayAndXTypeList", "()Ljava/util/List;", "setPayAndXTypeList", "(Ljava/util/List;)V", "getPayNewCardParams", "getProcessPassThrough", "setProcessPassThrough", "getPromotionParams", "setPromotionParams", "(Lorg/json/JSONObject;)V", "getSpecifiedPayMethod", "getStandardProcessInfo", "getStandardTradeInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeInfo;", "getUnifyCashierRenderInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "getUnifyPayAdapter", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;", "getVerifyParams", "getVoucherExpandResult", "()Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "getAppId", "getIntegratedAppId", "getIntegratedMerchantId", "getMerchantId", "getProcessInfo", "getTradeNo", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayProcessParams {
    private final AssetInfoBean currentAssetInfo;
    private final CJUnifyPayMethodTuple currentMethod;
    private final CJPayHostInfo hostInfo;
    private final String integratedProcessInfo;
    private final boolean isStandardFlow;
    private final JSONObject jhConfirmExts;
    private final String jhPassThrough;
    private final String jhSignToken;
    private String method;
    private List<String> payAndXTypeList;
    private final JSONObject payNewCardParams;
    private String processPassThrough;
    private JSONObject promotionParams;
    private final CJUnifyPayMethodTuple specifiedPayMethod;
    private final JSONObject standardProcessInfo;
    private final CJPayTradeInfo standardTradeInfo;
    private final UnifyCashierRenderInfo unifyCashierRenderInfo;
    private final CJUnifyPayAdapterProxy unifyPayAdapter;
    private final JSONObject verifyParams;
    private final VoucherDialogExpandResult voucherExpandResult;

    public final String getAppId() {
        UnifyCashierRenderInfo r100 = this.unifyCashierRenderInfo;
        if (r100 == null) goto L8;
        CJPayMerchantInfo r101 = r100.merchant_info;
        if (r101 == null) goto L8;
        String r102 = r101.app_id;
        if (r102 == null) goto L8;
        return r102;
    L8:
        CJPayHostInfo r103 = this.hostInfo;
        if (r103 == null) goto L11;
        String r104 = r103.appId;
    L12:
        if (r104 != null) goto L16;
        return "";
    L16:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final String getIntegratedAppId() {
        CJUnifyPayAdapterProxy r100 = this.unifyPayAdapter;
        if (r100 == null) goto L11;
        CJUnifyPayAdapterModel r101 = r100.getAdapterModel();
        if (r101 == null) goto L11;
        UnifyCashierRenderInfo r102 = r101.initRenderData;
        if (r102 == null) goto L11;
        CJPayMerchantInfo r103 = r102.merchant_info;
        if (r103 == null) goto L11;
        String r104 = r103.app_id;
    L12:
        if (r104 != null) goto L15;
        return "";
    L15:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final String getIntegratedMerchantId() {
        CJUnifyPayAdapterProxy r100 = this.unifyPayAdapter;
        if (r100 == null) goto L11;
        CJUnifyPayAdapterModel r101 = r100.getAdapterModel();
        if (r101 == null) goto L11;
        UnifyCashierRenderInfo r102 = r101.initRenderData;
        if (r102 == null) goto L11;
        CJPayMerchantInfo r103 = r102.merchant_info;
        if (r103 == null) goto L11;
        String r104 = r103.merchant_id;
    L12:
        if (r104 != null) goto L15;
        return "";
    L15:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final String getMerchantId() {
        UnifyCashierRenderInfo r100 = this.unifyCashierRenderInfo;
        if (r100 == null) goto L8;
        CJPayMerchantInfo r101 = r100.merchant_info;
        if (r101 == null) goto L8;
        String r102 = r101.merchant_id;
        if (r102 == null) goto L8;
        return r102;
    L8:
        CJPayHostInfo r103 = this.hostInfo;
        if (r103 == null) goto L11;
        String r104 = r103.merchantId;
    L12:
        if (r104 != null) goto L16;
        return "";
    L16:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final JSONObject getProcessInfo() {
        UnifyCashierRenderInfo r100 = this.unifyCashierRenderInfo;
        if (r100 == null) goto L7;
        JSONObject r101 = r100.process_info;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.standardProcessInfo;
    }

    public final String getTradeNo() {
        CJUnifyPayAdapterProxy r100 = this.unifyPayAdapter;
        if (r100 == null) goto L8;
        CJUnifyPayTradeInfo r101 = r100.adapterUnifyPayTradeInfo();
        if (r101 == null) goto L8;
        String r102 = r101.getTradeNo();
        if (r102 == null) goto L8;
        return r102;
    L8:
        CJPayTradeInfo r103 = this.standardTradeInfo;
        if (r103 == null) goto L11;
        String r104 = r103.trade_no;
    L12:
        if (r104 != null) goto L16;
        return "";
    L16:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final AssetInfoBean getCurrentAssetInfo() {
        return this.currentAssetInfo;
    }

    public final CJUnifyPayMethodTuple getCurrentMethod() {
        return this.currentMethod;
    }

    public final CJPayHostInfo getHostInfo() {
        return this.hostInfo;
    }

    public final String getIntegratedProcessInfo() {
        return this.integratedProcessInfo;
    }

    public final JSONObject getJhConfirmExts() {
        return this.jhConfirmExts;
    }

    public final String getJhPassThrough() {
        return this.jhPassThrough;
    }

    public final String getJhSignToken() {
        return this.jhSignToken;
    }

    public final String getMethod() {
        return this.method;
    }

    public final List<String> getPayAndXTypeList() {
        return this.payAndXTypeList;
    }

    public final JSONObject getPayNewCardParams() {
        return this.payNewCardParams;
    }

    public final String getProcessPassThrough() {
        return this.processPassThrough;
    }

    public final JSONObject getPromotionParams() {
        return this.promotionParams;
    }

    public final CJUnifyPayMethodTuple getSpecifiedPayMethod() {
        return this.specifiedPayMethod;
    }

    public final JSONObject getStandardProcessInfo() {
        return this.standardProcessInfo;
    }

    public final CJPayTradeInfo getStandardTradeInfo() {
        return this.standardTradeInfo;
    }

    public final UnifyCashierRenderInfo getUnifyCashierRenderInfo() {
        return this.unifyCashierRenderInfo;
    }

    public final CJUnifyPayAdapterProxy getUnifyPayAdapter() {
        return this.unifyPayAdapter;
    }

    public final JSONObject getVerifyParams() {
        return this.verifyParams;
    }

    public final VoucherDialogExpandResult getVoucherExpandResult() {
        return this.voucherExpandResult;
    }

    public final boolean isStandardFlow() {
        return this.isStandardFlow;
    }

    public final void setMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.method = r100;
    }

    public final void setPayAndXTypeList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.payAndXTypeList = r100;
    }

    public final void setProcessPassThrough(String r100) {
        this.processPassThrough = r100;
    }

    public final void setPromotionParams(JSONObject r100) {
        this.promotionParams = r100;
    }

    public CJUnifyPayProcessParams(String r100, JSONObject r101, CJUnifyPayMethodTuple r102, AssetInfoBean r110, String r111, JSONObject r112, String r113, String r114, JSONObject r115, JSONObject r116, List<String> r117, CJUnifyPayAdapterProxy r118, UnifyCashierRenderInfo r119, CJPayHostInfo r210, String r211, CJUnifyPayMethodTuple r212, JSONObject r213, CJPayTradeInfo r214, VoucherDialogExpandResult r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "verifyParams");
        Intrinsics.checkNotNullParameter(r111, "integratedProcessInfo");
        Intrinsics.checkNotNullParameter(r117, "payAndXTypeList");
        this.method = r100;
        this.verifyParams = r101;
        this.currentMethod = r102;
        this.currentAssetInfo = r110;
        this.integratedProcessInfo = r111;
        this.payNewCardParams = r112;
        this.processPassThrough = r113;
        this.jhSignToken = r114;
        this.jhConfirmExts = r115;
        this.promotionParams = r116;
        this.payAndXTypeList = r117;
        this.unifyPayAdapter = r118;
        this.unifyCashierRenderInfo = r119;
        this.hostInfo = r210;
        this.jhPassThrough = r211;
        this.specifiedPayMethod = r212;
        this.standardProcessInfo = r213;
        this.standardTradeInfo = r214;
        this.voucherExpandResult = r215;
        this.isStandardFlow = r216;
    }

    public /* synthetic */ CJUnifyPayProcessParams(String r210, JSONObject r211, CJUnifyPayMethodTuple r212, AssetInfoBean r213, String r214, JSONObject r215, String r310, String r311, JSONObject r312, JSONObject r313, List r314, CJUnifyPayAdapterProxy r315, UnifyCashierRenderInfo r316, CJPayHostInfo r317, String r318, CJUnifyPayMethodTuple r319, JSONObject r410, CJPayTradeInfo r411, VoucherDialogExpandResult r412, boolean r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        String r100 = CJUnifyPayConstants.Method.TRADE_CONFIRM;
    L7:
        if ((r414 & 8) == 0) goto L9;
        AssetInfoBean r101 = null;
    L11:
        if ((r414 & 32) == 0) goto L13;
        JSONObject r102 = null;
    L15:
        if ((r414 & 64) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r414 & 128) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r414 & 256) == 0) goto L25;
        JSONObject r111 = null;
    L27:
        if ((r414 & 512) == 0) goto L29;
        JSONObject r112 = null;
    L31:
        if ((r414 & 1024) == 0) goto L33;
        List r113 = new ArrayList();
    L35:
        if ((r414 & 2048) == 0) goto L37;
        CJUnifyPayAdapterProxy r114 = null;
    L39:
        if ((r414 & 4096) == 0) goto L41;
        UnifyCashierRenderInfo r115 = null;
    L43:
        if ((r414 & 8192) == 0) goto L45;
        CJPayHostInfo r116 = null;
    L47:
        if ((r414 & 16384) == 0) goto L49;
        String r117 = null;
    L51:
        if ((32768 & r414) == 0) goto L53;
        CJUnifyPayMethodTuple r118 = null;
    L55:
        if ((65536 & r414) == 0) goto L57;
        JSONObject r119 = null;
    L59:
        if ((131072 & r414) == 0) goto L61;
        CJPayTradeInfo r216 = null;
    L63:
        if ((262144 & r414) == 0) goto L65;
        VoucherDialogExpandResult r217 = null;
    L67:
        if ((r414 & 524288) == 0) goto L69;
        boolean r218 = false;
    L70:
        this(r100, r211, r212, r101, r214, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217, r218);
        return;
    L69:
        r218 = r413;
        goto L70
    L65:
        r217 = r412;
        goto L67
    L61:
        r216 = r411;
        goto L63
    L57:
        r119 = r410;
        goto L59
    L53:
        r118 = r319;
        goto L55
    L49:
        r117 = r318;
        goto L51
    L45:
        r116 = r317;
        goto L47
    L41:
        r115 = r316;
        goto L43
    L37:
        r114 = r315;
        goto L39
    L33:
        r113 = r314;
        goto L35
    L29:
        r112 = r313;
        goto L31
    L25:
        r111 = r312;
        goto L27
    L21:
        r110 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r215;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
