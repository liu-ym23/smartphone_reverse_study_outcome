package com.android.ttcjpaysdk.integrated.counter.model;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkRawCallback;
import com.android.ttcjpaysdk.base.network.ICJPayParserCallback;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.android.ttcjpaysdk.base.network.ICJPayResponseCallback;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.BizContentRequestParams;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeConfirmBizContentParams;
import com.android.ttcjpaysdk.integrated.counter.data.IntegratedCounterResponseData;
import com.android.ttcjpaysdk.integrated.counter.data.RiskInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TradeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TradeQueryBizContentParams;
import com.android.ttcjpaysdk.integrated.counter.pb.service.ICJPayPbService;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayCommonParamsBuildUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants.CJUnifyPayConstants;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ.\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ.\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bJL\u0010\u0012\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J*\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bJ:\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bJ:\u0010\u001e\u001a\u0004\u0018\u00010\u001f\"\u0004\b\u0000\u0010\u00052\u0006\u0010 \u001a\u00020!2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J8\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/model/CJPayCounterModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "getOuterCounterData", "", ExifInterface.GPS_DIRECTION_TRUE, "token", "", "extra", "Lorg/json/JSONObject;", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "parserCallback", "Lcom/android/ttcjpaysdk/base/network/ICJPayParserCallback;", "getSignInfo", "getTradeConfirmData", "params", "", "getTradeCreateData", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkRawCallback;", "responseCallback", "Lcom/android/ttcjpaysdk/base/network/ICJPayResponseCallback;", "isPbRequest", "", "getTradeQueryData", "papiId", "tradeNo", "bdPayParamJson", "pbTradeCreate", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "bizContentParams", "Lcom/android/ttcjpaysdk/integrated/counter/data/BizContentRequestParams;", "refreshTradeCreateData", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCounterModel extends MvpModel {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/model/CJPayCounterModel$Companion;", "", "()V", "getPbTestVid", "", "usePbRequest", "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getPbTestVid() {
            CJPayHostInfo r100 = ShareData.hostInfo;
            if (r100 == null) goto L8;
            Map<String, String> r101 = r100.getRequestParams();
            if (r101 == null) goto L8;
            String r102 = r101.get("use_protobuf_group");
            if (r102 == null) goto L8;
            return r102;
        L8:
            return "";
        }

        public final boolean usePbRequest() {
            if (CJPayNetworkManager.isUsingTTNet() == false) goto L13;
            CJPayHostInfo r100 = ShareData.hostInfo;
            if (r100 == null) goto L9;
            Map<String, String> r101 = r100.getRequestParams();
            if (r101 == null) goto L9;
            boolean r102 = Intrinsics.areEqual(r101.get("use_protobuf"), "true");
        L10:
            if (r102 == false) goto L14;
            return true;
        L14:
            return false;
        L9:
            r102 = false;
            goto L10
        L13:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayCounterModel() {
    }

    public final <T> void getTradeConfirmData(Map<String, String> r110, ICJPayNetWorkCallback<T> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (ShareData.checkoutResponseBean != null) goto L5;
        return;
    L5:
        CJPayCommonParamsBuildUtils.Companion r100 = CJPayCommonParamsBuildUtils.Companion;
        CounterTradeConfirmBizContentParams r112 = r100.getTradeConfirmBizContentParams(ShareData.checkoutResponseBean, r110);
        String r101 = r100.getHostHttpUrl(true, "/gateway-cashier2/tp/cashier/trade_confirm");
        if (r112 == null) goto L8;
        String r102 = r112.toJsonString();
    L9:
        addRequest(CJPayNetworkManager.postForm(r101, CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r100, CJUnifyPayConstants.Method.TRADE_CONFIRM_INTEGRATED, r102, null, null, 8, null), r100.getNetHeaderData(r101, CJUnifyPayConstants.Method.TRADE_CONFIRM_INTEGRATED), r111));
        String r103 = CJEnv.e();
        String r104 = CJEnv.c();
        CJPayHostInfo r113 = ShareData.hostInfo;
        if (r113 == null) goto L12;
        String r105 = r113.merchantId;
    L13:
        r100.monitorInterfaceParams("聚合_confirm", "wallet_rd_confirm_interface_params_verify", r103, r104, r105);
        return;
    L12:
        r105 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    public final <T> void getSignInfo(String r110, ICJPayNetWorkCallback<T> r111, ICJPayParserCallback r112) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        CJPayCallBackCenter.getInstance().setTraceId("");
        JSONObject r100 = new JSONObject();
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        r100.put("token", r110);
        CJPayCommonParamsBuildUtils.Companion r113 = CJPayCommonParamsBuildUtils.Companion;
        String r101 = r113.getHostHttpUrl(true, "/gateway-cashier2/tp/cashier/query_sign_info");
        addRequest(CJPayNetworkManager.postForm(r101, CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r113, "tp.cashier.query_sign_info", r100.toString(), null, null, 8, null), r113.getNetHeaderData(r101, "tp.cashier.query_sign_info"), r111, r112));
    }

    public final <T> void getTradeQueryData(String r110, String r111, ICJPayNetWorkCallback<T> r112) {
        Intrinsics.checkNotNullParameter(r110, "papiId");
        Intrinsics.checkNotNullParameter(r111, "tradeNo");
        Intrinsics.checkNotNullParameter(r112, "callback");
        TradeQueryBizContentParams r100 = new TradeQueryBizContentParams();
        r100.trade_no = r111;
        CJPayCommonParamsBuildUtils.Companion r113 = CJPayCommonParamsBuildUtils.Companion;
        boolean r101 = false;
        String r102 = r113.getHostHttpUrl(false, "/gateway-cashier2/tp/cashier/trade_query");
        Map r103 = CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r113, CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED, r100.toJsonString(), null, null, 8, null);
        if (r110.length() <= 0) goto L5;
        r101 = true;
    L5:
        if (r101 == false) goto L7;
        r103.put("papi_id", r110);
    L7:
        addRequest(CJPayNetworkManager.postForm(r102, r103, r113.getNetHeaderData(r102, CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED), r112));
        String r104 = CJEnv.e();
        String r105 = CJEnv.c();
        CJPayHostInfo r114 = ShareData.hostInfo;
        if (r114 == null) goto L10;
        String r115 = r114.merchantId;
    L11:
        r113.monitorInterfaceParams("聚合_query", "wallet_rd_query_interface_params_verify", r104, r105, r115);
        return;
    L10:
        r115 = null;
        goto L11
    }

    public final <T> void getTradeQueryData(Map<String, String> r100, JSONObject r110, ICJPayNetWorkCallback<T> r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (ShareData.checkoutResponseBean != null) goto L5;
        return;
    L5:
        TradeQueryBizContentParams r101 = new TradeQueryBizContentParams();
        CounterResponseBean r102 = ShareData.checkoutResponseBean;
        if (r102 == null) goto L13;
        IntegratedCounterResponseData r103 = r102.data;
        if (r103 == null) goto L13;
        TradeInfo r104 = r103.trade_info;
        if (r104 == null) goto L13;
        String r105 = r104.trade_no;
        if (r105 == null) goto L13;
    L14:
        r101.trade_no = r105;
        r101.byte_pay_param = r110;
        CJPayCommonParamsBuildUtils.Companion r112 = CJPayCommonParamsBuildUtils.Companion;
        String r106 = r112.getHostHttpUrl(false, "/gateway-cashier2/tp/cashier/trade_query");
        addRequest(CJPayNetworkManager.postForm(r106, CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r112, CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED, r101.toJsonString(), null, null, 8, null), r112.getNetHeaderData(r106, CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED), r111));
        String r107 = CJEnv.e();
        String r108 = CJEnv.c();
        CJPayHostInfo r109 = ShareData.hostInfo;
        if (r109 == null) goto L17;
        String r113 = r109.merchantId;
    L18:
        r112.monitorInterfaceParams("聚合_query", "wallet_rd_query_interface_params_verify", r107, r108, r113);
        return;
    L17:
        r113 = null;
    L13:
        r105 = "";
        goto L14
    }

    private final <T> ICJPayRequest pbTradeCreate(BizContentRequestParams r110, ICJPayNetWorkRawCallback<T> r111, ICJPayParserCallback r112, ICJPayResponseCallback r113) {
        CJPayCommonParamsBuildUtils.Companion r100 = CJPayCommonParamsBuildUtils.Companion;
        String r101 = r100.getHostHttpUrl(true, "/gateway-cashier2/tp/cashier/trade_create_pb");
        Map<String, String> r102 = CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r100, "tp.cashier.trade_create_pb", r110.toJsonString(), null, null, 8, null);
        Map<String, String> r114 = r100.getNetHeaderData(r101, "tp.cashier.trade_create_pb");
        r114.put("Device-Group", CJPaySettingsManager.getInstance().getDeviceGroup());
        r114.put("Network-Quality", String.valueOf(CJEnv.f().getNetworkQuality()));
        RiskInfo r103 = r110.risk_info;
        if (r103 == null) goto L7;
        JSONObject r104 = r103.toJson();
        if (r104 == null) goto L7;
        String r105 = r104.toString();
    L8:
        r114.put("Risk-Info", r105);
        r114.put("pb_test_vid", Companion.getPbTestVid());
        a.f554342a.getClass();
        Intrinsics.checkNotNullParameter(ICJPayPbService.class, "clazz");
        ICJPayPbService r106 = (ICJPayPbService) a.c(ICJPayPbService.class);
        if (r106 == null) goto L14;
        byte[] r115 = r106.getTradeCreateRequestDataArray(r110, r102);
        if (r115 == null) goto L14;
        return CJPayNetworkManager.postPb(r101, r115, r114, r111, r112, r113);
    L14:
        r111.onFailure("", "icjpayservice is null");
        return null;
    L7:
        r105 = null;
        goto L8
    }

    public final <T> void getOuterCounterData(String r100, JSONObject r110, ICJPayNetWorkCallback<T> r111, ICJPayParserCallback r112) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        CJPayCallBackCenter.getInstance().setTraceId("");
        JSONObject r101 = new JSONObject();
        r101.put("host_app_name", ShareData.outerPayInfo.fromAppName);
        if (r110 == null) goto L9;
        Iterator<String> r102 = r110.keys();
        if (r102 == null) goto L9;
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        r101.put(r103, r110.optString(r103));
    L9:
        JSONObject r113 = new JSONObject();
        if (r100 != null) goto L12;
        r100 = "";
    L12:
        r113.put("token", r100);
        r113.put("params", r101);
        CJPayCommonParamsBuildUtils.Companion r104 = CJPayCommonParamsBuildUtils.Companion;
        String r105 = r104.getHostHttpUrl(true, "/gateway-cashier2/tp/cashier/trade_create_by_token");
        addRequest(CJPayNetworkManager.postForm(r105, CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r104, "tp.cashier.trade_create_by_token", r113.toString(), null, null, 8, null), r104.getNetHeaderData(r105, "tp.cashier.trade_create_by_token"), r111, r112));
    }

    public final <T> void refreshTradeCreateData(JSONObject r100, final ICJPayNetWorkCallback<T> r101, ICJPayResponseCallback r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        BizContentRequestParams r102 = new BizContentRequestParams();
        CJPayHostInfo r103 = ShareData.hostInfo;
        if (r103 == null) goto L7;
        Map<String, String> r104 = r103.getRequestParams();
        if (r104 == null) goto L7;
        JSONObject r105 = new JSONObject(r104);
    L8:
        r102.params = r105;
        r102.risk_info = CJPayCommonParamsBuildUtils.Companion.getHttpRiskInfo();
        if (r100 == null) goto L14;
        if (TextUtils.isEmpty(r100.optString("service")) == false) goto L14;
        r102.service = r100.optString("service");
    L14:
        if (r100 == null) goto L27;
        Iterator<String> r106 = r100.keys();
        if (r106 == null) goto L27;
    L18:
        if (r106.hasNext() == false) goto L27;
        String r107 = r106.next();
        if (Intrinsics.areEqual(r107, "service") == true) goto L18;
        if (r107.length() <= 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L18;
        KtSafeMethodExtensionKt.safePut(r102.params, r107, r100.get(r107));
        goto L18
    L24:
        r108 = false;
    L27:
        String r109 = null;
        if (r111 == false) goto L32;
        a.f554342a.getClass();
        Intrinsics.checkNotNullParameter(ICJPayPbService.class, "clazz");
        if (a.c(ICJPayPbService.class) == null) goto L32;
        ICJPayRequest r112 = pbTradeCreate(r102, new CJPayCounterModel$refreshTradeCreateData$request$1(r101), null, r110);
    L33:
        addRequest(r112);
        CJPayCommonParamsBuildUtils.Companion r113 = CJPayCommonParamsBuildUtils.Companion;
        String r114 = CJEnv.e();
        String r115 = CJEnv.c();
        CJPayHostInfo r116 = ShareData.hostInfo;
        if (r116 == null) goto L36;
        r109 = r116.merchantId;
    L36:
        r113.monitorInterfaceParams("聚合_create", "wallet_rd_create_interface_params_verify", r114, r115, r109);
        return;
    L32:
        CJPayCommonParamsBuildUtils.Companion r117 = CJPayCommonParamsBuildUtils.Companion;
        String r118 = r117.getHostHttpUrl(true, "/gateway-cashier2/tp/cashier/trade_create");
        Map r119 = CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r117, "tp.cashier.trade_create", r102.toJsonString(), null, null, 8, null);
        Map<String, String> r120 = r117.getNetHeaderData(r118, "tp.cashier.trade_create");
        r120.put("pb_test_vid", Companion.getPbTestVid());
        Unit r121 = Unit.INSTANCE;
        r112 = CJPayNetworkManager.postForm(r118, r119, r120, r101);
    L7:
        r105 = new JSONObject();
        goto L8
    }

    public final <T> void getTradeCreateData(CJContext r100, JSONObject r110, ICJPayNetWorkRawCallback<T> r111, ICJPayParserCallback r112, ICJPayResponseCallback r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        CJPayCallBackCenter.getInstance().setTraceId("");
        BizContentRequestParams r101 = new BizContentRequestParams();
        CJPayHostInfo r102 = ShareData.hostInfo;
        if (r102 == null) goto L7;
        Map<String, String> r103 = r102.getRequestParams();
        if (r103 == null) goto L7;
        JSONObject r104 = new JSONObject(r103);
    L8:
        r101.params = r104;
        r101.risk_info = CJPayCommonParamsBuildUtils.Companion.getHttpRiskInfo();
        if (r110 != null) goto L11;
    L13:
        boolean r105 = false;
        if (r110 == null) goto L27;
        Iterator<String> r106 = r110.keys();
        if (r106 == null) goto L27;
    L18:
        if (r106.hasNext() == false) goto L27;
        String r107 = r106.next();
        if (Intrinsics.areEqual(r107, "service") == true) goto L18;
        if (r107.length() <= 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L18;
        KtSafeMethodExtensionKt.safePut(r101.params, r107, r110.get(r107));
        goto L18
    L24:
        r108 = false;
    L27:
        String r109 = null;
        if (CJPaySettingsManager.getInstance().isDegradeNativeFromQrcode() == true) goto L42;
        CJPayHostInfo r115 = ShareData.hostInfo;
        if (r115 == null) goto L32;
        String r116 = r115.invokeType;
    L34:
        if (Intrinsics.areEqual(r116, "SCAN") == true) goto L41;
        CJPayHostInfo r117 = ShareData.hostInfo;
        if (r117 != null) goto L38;
    L40:
        if (r105 == false) goto L42;
    L38:
        if (r117.isFromScan != true) goto L40;
        r105 = true;
    L41:
        KtSafeMethodExtensionKt.safePut(r101.params, "native_from_qrcode", "1");
        goto L42
    L32:
        r116 = null;
    L42:
        if (r114 == false) goto L46;
        a.f554342a.getClass();
        Intrinsics.checkNotNullParameter(ICJPayPbService.class, "clazz");
        if (a.c(ICJPayPbService.class) == null) goto L46;
        ICJPayRequest r118 = pbTradeCreate(r101, r111, r112, r113);
    L47:
        addRequest(r118);
        CJPayCommonParamsBuildUtils.Companion r119 = CJPayCommonParamsBuildUtils.Companion;
        String r120 = CJEnv.e();
        String r121 = CJEnv.c();
        CJPayHostInfo r122 = ShareData.hostInfo;
        if (r122 == null) goto L50;
        r109 = r122.merchantId;
    L50:
        r119.monitorInterfaceParams("聚合_create", "wallet_rd_create_interface_params_verify", r120, r121, r109);
        return;
    L46:
        CJPayCommonParamsBuildUtils.Companion r123 = CJPayCommonParamsBuildUtils.Companion;
        String r124 = r123.getHostHttpUrl(true, "/gateway-cashier2/tp/cashier/trade_create");
        Map r125 = CJPayCommonParamsBuildUtils.Companion.getHttpData$default(r123, "tp.cashier.trade_create", r101.toJsonString(), null, null, 8, null);
        Map<String, String> r126 = r123.getNetHeaderData(r124, "tp.cashier.trade_create");
        r126.put("pb_test_vid", Companion.getPbTestVid());
        r118 = CJPayNetworkManager.postForm(r124, r125, r126, r111, r112);
        goto L47
    L11:
        if (TextUtils.isEmpty(r110.optString("service")) == false) goto L13;
        r101.service = r110.optString("service");
    L7:
        r104 = new JSONObject();
        goto L8
    }

    public static /* synthetic */ void refreshTradeCreateData$default(CJPayCounterModel r100, JSONObject r101, ICJPayNetWorkCallback r102, ICJPayResponseCallback r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = false;
    L5:
        r100.refreshTradeCreateData(r101, r102, r103, r104);
    }

    public static /* synthetic */ void getTradeCreateData$default(CJPayCounterModel r100, CJContext r101, JSONObject r102, ICJPayNetWorkRawCallback r110, ICJPayParserCallback r111, ICJPayResponseCallback r112, boolean r113, int r114, Object r115) {
        if ((r114 & 32) == 0) goto L5;
        boolean r103 = false;
    L6:
        r100.getTradeCreateData(r101, r102, r110, r111, r112, r103);
        return;
    L5:
        r103 = r113;
        goto L6
    }
}
