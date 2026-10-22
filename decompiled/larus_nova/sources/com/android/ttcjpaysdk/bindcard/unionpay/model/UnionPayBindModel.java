package com.android.ttcjpaysdk.bindcard.unionpay.model;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.BindCardBaseModel;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRiskInfo;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPaySignInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ.\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ\"\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ\"\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ$\u0010\u0010\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJF\u0010\u0012\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0013\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\n2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J.\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n2\b\b\u0002\u0010\u001a\u001a\u00020\bJ\u001a\u0010\u001b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ\u001a\u0010\u001c\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ\"\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u001e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nJ\"\u0010\u001f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u001e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/model/UnionPayBindModel;", "Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseModel;", "()V", "createUnionPaySignOrder", "", ExifInterface.GPS_DIRECTION_TRUE, "params", "", "", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "fetchAuthProtocol", "fetchUnionPayAuthInfo", "unionPaySignInfo", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignInfo;", "fetchUnionPayBankList", "fetchUnionPaySignInfo", "orderNo", "sendRequest", "methodName", "Ljava/util/HashMap;", "needRiskInfo", "", "sendSMSForUnionPayBindCard", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "bankCardId", "unionCreateBizOrder", "unionFetchUrl", "unionPayBindCard", "Lorg/json/JSONObject;", "uploadTwoElements", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindModel extends BindCardBaseModel {
    public UnionPayBindModel() {
    }

    public final <T> void unionCreateBizOrder(ICJPayNetWorkCallback<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
        r101.put("biz_order_type", "card_sign");     // Catch: JSONException -> L5
        addRequest(r101, "bytepay.member_product.create_biz_order", null, null, true, r100);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#unionCreateBizOrder", e);
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#unionCreateBizOrder", e);
    }

    public final <T> void unionFetchUrl(ICJPayNetWorkCallback<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        HashMap<String, String> r101 = new HashMap();     // Catch: JSONException -> L18
        r101.put("biz_order_type", "card_sign");     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(CJPayBindCardLogUtils.getSource()) == false) goto L6;
        String r102 = "payment_manage";
    L7:
        r101.put("source", r102);     // Catch: JSONException -> L18
        String r103 = "";
        if (CJEnv.e() != null) goto L11;
        String r104 = "";
    L12:
        r101.put("aid", r104);     // Catch: JSONException -> L18
        if (CJEnv.h() == null) goto L16;
        r103 = CJEnv.h();     // Catch: JSONException -> L18
    L16:
        r101.put("uid", r103);     // Catch: JSONException -> L18
        r101.put("merchant_id", CJPaySettingsManager.getInstance().getCJPayJhInfo().jh_merchant_id);     // Catch: JSONException -> L18
        r101.put("merchant_app_id", CJPaySettingsManager.getInstance().getCJPayJhInfo().jh_app_id);     // Catch: JSONException -> L18
        sendRequest("tp.customer.fetch_url", r100, r101, true);     // Catch: JSONException -> L18
        return;
    L11:
        r104 = CJEnv.e();     // Catch: JSONException -> L18
        goto L12
    L6:
        r102 = CJPayBindCardLogUtils.getSource();     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#unionFetchUrl", e);
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#unionFetchUrl", e);
    }

    public final <T> void createUnionPaySignOrder(Map<String, String> r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        addRequest(new JSONObject(r100), "bytepay.member_product.create_union_pay_sign_order", null, null, true, r110);
    }

    public final <T> void fetchAuthProtocol(Map<String, String> r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        addRequest(new JSONObject(r100), "bytepay.member_product.query_protocol_list", null, null, true, r110);
    }

    public final <T> void fetchUnionPayAuthInfo(UnionPaySignInfo r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "unionPaySignInfo");
        Intrinsics.checkNotNullParameter(r110, "callback");
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("member_biz_order_no", r100.signOrderNo);     // Catch: Exception -> L5
        addRequest(r101, "bytepay.member_product.query_union_pay_authorization", null, null, true, r110);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#fetchUnionPayAuthInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#fetchUnionPayAuthInfo", e);
    }

    public final <T> void fetchUnionPayBankList(UnionPaySignInfo r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "unionPaySignInfo");
        Intrinsics.checkNotNullParameter(r110, "callback");
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("member_biz_order_no", r100.signOrderNo);     // Catch: Exception -> L5
        addRequest(r101, "bytepay.member_product.get_union_pay_bank_list", null, null, true, r110);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#fetchUnionPayBankList", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#fetchUnionPayBankList", e);
    }

    public final <T> void fetchUnionPaySignInfo(String r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("member_biz_order_no", r100);     // Catch: Exception -> L5
        addRequest(r101, "bytepay.member_product.union_pay_sign", null, null, true, r110);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#fetchUnionPaySignInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#fetchUnionPaySignInfo", e);
    }

    public final <T> void unionPayBindCard(JSONObject r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        addRequest(r100, "bytepay.member_product.bind_union_pay_bank_card", null, null, true, r110);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#unionPayBindCard", e);
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#unionPayBindCard", e);
    }

    public final <T> void uploadTwoElements(JSONObject r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        addRequest(r100, "bytepay.member_product.verify_identity_info", null, null, true, r110);
    }

    public final <T> void sendSMSForUnionPayBindCard(CJPayRealNameBean r110, ICJPayNetWorkCallback<T> r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "bankCardId");
        JSONObject r100 = new JSONObject();
        if (r110 != null) goto L10;
    L5:
        addRequest(r100, "bytepay.member_product.send_sign_sms", null, null, true, r111);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UnionPayBindModel#sendSMSForUnionPayBindCard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindModel#sendSMSForUnionPayBindCard", e);
        return;
    L10:
        r110.secure_request_params = new CJPaySecureRequestParams();     // Catch: JSONException -> L7
        r100.put("sign_order_no", r110.commonBean.signOrderNo);     // Catch: JSONException -> L7
        r100.put(DyVerifyReqConstants.Key.SMCH_ID, r110.commonBean.smchId);     // Catch: JSONException -> L7
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L7
        CJEncryptScene r102 = CJEncryptScene.TRADE_VERIFY;     // Catch: JSONException -> L7
        r101.put("card_no", CJPayEncryptHelper.Companion.getEncryptDataSM(r102, r110.card_no, "云闪付-短验", "card_no"));     // Catch: JSONException -> L7
        r110.secure_request_params.fields.add("enc_params.card_no");     // Catch: JSONException -> L7
        r100.put(DyVerifyReqConstants.Key.ENC_PARAMS, r101);     // Catch: JSONException -> L7
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r110.secure_request_params.toJson(r102));     // Catch: JSONException -> L7
        r100.put("bank_card_id", r112);     // Catch: JSONException -> L7
        goto L5
    }

    private final <T> void sendRequest(String r100, ICJPayNetWorkCallback<T> r101, HashMap<String, String> r102, boolean r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        BindCardCommonInfoUtil r104 = BindCardCommonInfoUtil.INSTANCE;
        CJPayHostInfo r105 = r104.getHostInfo();
        if (r103 == false) goto L11;
        CJPayRiskInfo r106 = new CJPayRiskInfo();
        if (r105 == null) goto L9;
        Map<String, String> r107 = r105.getRiskInfoParams();
    L10:
        r106.riskInfoParamsMap = r107;
        r102.put(DyVerifyReqConstants.Key.RISK_INFO, r106.toJsonNew().toString());
        goto L11
    L9:
        r107 = null;
    L11:
        String r108 = r104.getAppId();
        String r109 = r104.getMerchantId();
        ICJPayIntegratedCounterService r110 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r110 != null) goto L14;
        return;
    L14:
        String r111 = r110.getIntegratedCounterUrl("gateway-u", r100);
        addRequest(CJPayNetworkManager.postForm(r111, r110.getIntegratedCounterHttpData(r102, r100, r108, r109), r110.getIntegratedCounterHttpHeader(r111, r100), r101));
    }

    public static /* synthetic */ void sendSMSForUnionPayBindCard$default(UnionPayBindModel r100, CJPayRealNameBean r101, ICJPayNetWorkCallback r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = "";
    L5:
        r100.sendSMSForUnionPayBindCard(r101, r102, r103);
    }
}
