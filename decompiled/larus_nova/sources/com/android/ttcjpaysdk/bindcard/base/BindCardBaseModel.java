package com.android.ttcjpaysdk.bindcard.base;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.CertSignParams;
import com.android.ttcjpaysdk.base.service.ICJPayDyVerifyService;
import com.android.ttcjpaysdk.base.service.ICJPayNewCardCallback;
import com.android.ttcjpaysdk.base.service.ICertSignCallback;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.ui.data.CJPayRiskControlInfoKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNewCardBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRiskInfo;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPaySetPasswordResponse;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayVerifyPasswordResponse;
import com.android.ttcjpaysdk.bindcard.base.ui.BankCardListFragment;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants.CJUnifyPayConstants;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fJF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011JR\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0002JJ\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0002Jl\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000f2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J.\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011J.\u0010\u001e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fJ:\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fJJ\u0010%\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020'0\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007Jb\u0010)\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000f2\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\tH\u0002Jd\u0010,\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010-\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011J\u001c\u0010.\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020/0\u000fJ.\u00100\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fJ\u001c\u00101\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002020\u000f¨\u00063"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/BindCardBaseModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "addRequest", "", ExifInterface.GPS_DIRECTION_TRUE, "params", "Lorg/json/JSONObject;", e.f25671s, "", "merchantId", "appId", "isIncludeRiskStr", "", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "timestamp", "Lcom/android/ttcjpaysdk/base/network/ICJPayCallback;", "bizContentParams", "", "needCert", "certData", "Lcom/android/ttcjpaysdk/base/service/CertSignParams;", "payNewCardLoadingCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayNewCardCallback;", "checkSMSForBindCard", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "smsCode", "smsToken", "memberCreateBizOrder", "", "nameAndIdentifyCodeVerify", "bizOrderNo", "name", "identityType", "identityCode", "payWithNewCard", "certSignParams", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayNewCardBean;", "payNewCardConfigsBackup", "request", "partCoSignData", "signFactorId", "requestWithSignData", "sendSMSForBindCard", "setPassword", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPaySetPasswordResponse;", "verifyLiveDetect", "verifyPasswod", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayVerifyPasswordResponse;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BindCardBaseModel extends MvpModel {
    public BindCardBaseModel() {
    }

    public final <T> void memberCreateBizOrder(Map<String, String> r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        addRequest(new JSONObject(r100), "bytepay.member_product.create_biz_order", null, null, false, r110);
    }

    public final void sendSMSForBindCard(CJPayRealNameBean r110, ICJPayCallback r111) {
        JSONObject r100 = new JSONObject();
        if (r110 != null) goto L29;
    L27:
        addRequest(r100, "bytepay.member_product.send_sign_sms", null, null, true, null, r111);
        return;
    L29:
        CJEncryptScene r101 = CJEncryptScene.TRADE_VERIFY;     // Catch: JSONException -> L25
        r110.secure_request_params = new CJPaySecureRequestParams();     // Catch: JSONException -> L25
        r100.put("sign_order_no", r110.commonBean.signOrderNo);     // Catch: JSONException -> L25
        r100.put(DyVerifyReqConstants.Key.SMCH_ID, r110.commonBean.smchId);     // Catch: JSONException -> L25
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L25
        CJPayEncryptHelper.Companion r103 = CJPayEncryptHelper.Companion;     // Catch: JSONException -> L25
        r102.put("card_no", r103.getEncryptDataSM(r101, r110.card_no, "绑卡-短验", "card_no"));     // Catch: JSONException -> L25
        if (TextUtils.isEmpty(r110.encryptedMobileNumber) == true) goto L8;
        r102.put("mobile", r103.getEncryptDataSM(r101, r110.encryptedMobileNumber, "绑卡-短验", "mobile"));     // Catch: JSONException -> L25
    L10:
        if ((!StringsKt.isBlank(r110.bankCardId)) == false) goto L13;
        r100.put("bank_card_id", r110.bankCardId);     // Catch: JSONException -> L25
    L13:
        if (TextUtils.isEmpty(r110.user_name) == true) goto L20;
        r102.put("name", r103.getEncryptDataSM(r101, r110.user_name, "绑卡-短验", "name"));     // Catch: JSONException -> L25
        r102.put("identity_type", r110.id_type.key);     // Catch: JSONException -> L25
        r102.put(BytedCertConstant.CertKey.IDENTITY_CODE, r103.getEncryptDataSM(r101, r110.id_no, "绑卡-短验", BytedCertConstant.CertKey.IDENTITY_CODE));     // Catch: JSONException -> L25
        if (TextUtils.isEmpty(r110.country) == true) goto L17;
        r102.put(DistrictSearchQuery.KEYWORDS_COUNTRY, r110.country);     // Catch: JSONException -> L25
    L17:
        r110.secure_request_params.fields.add("enc_params.name");     // Catch: JSONException -> L25
        r110.secure_request_params.fields.add("enc_params.identity_code");     // Catch: JSONException -> L25
    L20:
        if (r110.isUnionPay == false) goto L22;
        r110.secure_request_params.fields.add("enc_params.card_no");     // Catch: JSONException -> L25
        r110.secure_request_params.fields.add("enc_params.mobile");     // Catch: JSONException -> L25
    L23:
        r100.put(DyVerifyReqConstants.Key.ENC_PARAMS, r102);     // Catch: JSONException -> L25
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r110.secure_request_params.toJson(r101));     // Catch: JSONException -> L25
        goto L27
    L22:
        r110.secure_request_params.fields.add("enc_params.mobile");     // Catch: JSONException -> L25
        r110.secure_request_params.fields.add("enc_params.card_no");     // Catch: JSONException -> L25
        goto L23
    L8:
        r102.put("mobile", r103.getEncryptDataSM(r101, r110.bank_mobile_no, "绑卡-短验", "mobile"));     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#sendSMSForBindCard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#sendSMSForBindCard", e);
        goto L27
    }

    public final void setPassword(JSONObject r110, ICJPayNetWorkCallback<CJPaySetPasswordResponse> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        addRequest(r110, "bytepay.member_product.set_password", null, null, false, String.valueOf(System.currentTimeMillis() / ((long) 1000)), r111);
    }

    public final <T> void verifyLiveDetect(Map<String, ? extends Object> r100, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        JSONObject r101 = new JSONObject(MapsKt.toMap(r100));     // Catch: Exception -> L5
    L7:
        addRequest(r101, "bytepay.member_product.verify_live_detection_result", null, null, false, r110);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#unknown", e);
        r101 = new JSONObject();
        goto L7
    }

    public final void verifyPasswod(JSONObject r110, ICJPayNetWorkCallback<CJPayVerifyPasswordResponse> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        addRequest(r110, DyVerifyReqConstants.Method.VERIFY_PASSWORD, null, null, false, String.valueOf(System.currentTimeMillis() / ((long) 1000)), r111);
    }

    public final void checkSMSForBindCard(CJPayRealNameBean r100, String r110, String r111, ICJPayCallback r112) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L11;
    L5:
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
        r102.put("sms", r110);     // Catch: JSONException -> L7
        r101.put(DyVerifyReqConstants.Key.ENC_PARAMS, r102);     // Catch: JSONException -> L7
        r101.put("sms_token", r111);     // Catch: JSONException -> L7
    L9:
        addRequest(r101, "bytepay.member_product.sign_card", null, null, true, null, r112);
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#checkSMSForBindCard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#checkSMSForBindCard", e);
        goto L9
    L11:
        r101.put("sign_order_no", r100.commonBean.signOrderNo);     // Catch: JSONException -> L7
        r101.put(DyVerifyReqConstants.Key.SMCH_ID, r100.commonBean.smchId);     // Catch: JSONException -> L7
        r101.put(BankCardListFragment.IS_NEED_CARD_INFO_KEY, r100.is_need_card_info);     // Catch: JSONException -> L7
        goto L5
    }

    public final <T> void nameAndIdentifyCodeVerify(String r110, String r111, String r112, String r210, ICJPayNetWorkCallback<T> r211) {
        Intrinsics.checkNotNullParameter(r110, "bizOrderNo");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "identityType");
        Intrinsics.checkNotNullParameter(r210, "identityCode");
        Intrinsics.checkNotNullParameter(r211, "callback");
        JSONObject r100 = new JSONObject();
        r100.put("member_biz_order_no", r110);     // Catch: Exception -> L5
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        CJPayEncryptHelper.Companion r113 = CJPayEncryptHelper.Companion;     // Catch: Exception -> L5
        CJEncryptScene r114 = CJEncryptScene.UNKNOWN;     // Catch: Exception -> L5
        r101.put("name", r113.getEncryptDataSM(r114, r111, "绑卡-二要素", "name"));     // Catch: Exception -> L5
        r101.put("identity_type", r112);     // Catch: Exception -> L5
        r101.put(BytedCertConstant.CertKey.IDENTITY_CODE, r113.getEncryptDataSM(r114, StringsKt.replace$default(r210, " ", "", false, 4, null), "绑卡-二要素", BytedCertConstant.CertKey.IDENTITY_CODE));     // Catch: Exception -> L5
        r100.put(DyVerifyReqConstants.Key.ENC_PARAMS, r101);     // Catch: Exception -> L5
        CJPaySecureRequestParams r102 = new CJPaySecureRequestParams();     // Catch: Exception -> L5
        r102.fields.add("enc_params.name");     // Catch: Exception -> L5
        r102.fields.add("enc_params.identity_code");     // Catch: Exception -> L5
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r102.toJson(r114));     // Catch: Exception -> L5
    L7:
        addRequest(r100, "bytepay.member_product.verify_identity_info", null, null, null, r211);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#unknown", e);
        goto L7
    }

    private final <T> void addRequest(JSONObject r110, String r111, String r112, String r113, String r114, ICJPayNetWorkCallback<T> r115) {
        CJPayRiskInfo r100 = new CJPayRiskInfo();
        Map<String, String> r101 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().getRiskInfoParams();
        HashMap<String, String> r102 = null;
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        r100.riskInfoParamsMap = r101;
        if (r101 == null) goto L27;
        r101.put("finance_risk", CJPayJsonParser.toJsonObject(CJPayRiskControlInfoKt.financeRiskWrapUp$default("cj_bindcard", null, null, false, 14, null)).toString());
    L27:
        KtSafeMethodExtensionKt.safePut(r110, DyVerifyReqConstants.Key.RISK_INFO, r100.toJsonNew());     // Catch: Exception -> L10
    L13:
        if (TextUtils.isEmpty(r112) == false) goto L16;
        r112 = BindCardCommonInfoUtil.INSTANCE.getMerchantId();
    L16:
        if (TextUtils.isEmpty(r113) == false) goto L18;
        r113 = BindCardCommonInfoUtil.INSTANCE.getAppId();
    L18:
        HashMap<String, String> r103 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().extraHeaderMap;
        if (r103 == null) goto L22;
        r102 = r103;
    L22:
        String r104 = CJPayParamsUtils.getHttpUrl(r111, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r116 = CJPayParamsUtils.getHttpData(r111, r110.toString(), r113, r112);
        if (TextUtils.isEmpty(r114) == true) goto L25;
        r116.put("timestamp", r114);
    L25:
        addRequest(CJPayNetworkManager.postForm(r104, r116, CJPayParamsUtils.getNetHeaderData(r104, r111, r102), r115));
        return;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#getSignParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#getSignParams", e);
        goto L13
    }

    public final void payWithNewCard(JSONObject r110, boolean r111, CertSignParams r112, ICJPayNewCardCallback r113, ICJPayNetWorkCallback<CJPayNewCardBean> r114, JSONObject r115) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r114, "callback");
        ICJPayNewCardCallback r100 = BindCardCommonInfoUtil.INSTANCE.getPayNewCardCallback();
        if (r100 == null) goto L5;
        JSONObject r101 = r100.getPayNewCardConfigs();
    L7:
        if (Intrinsics.areEqual(CJPayABExperimentKeys.getPayNewCardConfigsOpt().value(true), "1") == false) goto L10;
        if (r101 != null) goto L10;
        r101 = r115;
    L10:
        if (r101 == null) goto L12;
        boolean r102 = r101.optBoolean("isAssetStandartProcess");
    L14:
        if (r102 == false) goto L16;
        addRequest(r110, CJUnifyPayConstants.Method.TRADE_CONFIRM, null, null, String.valueOf(System.currentTimeMillis() / ((long) 1000)), r114, r111, r112, r113);
        return;
    L16:
        addRequest(r110, "bytepay.cashdesk.pay_new_card", null, null, String.valueOf(System.currentTimeMillis() / ((long) 1000)), r114);
        return;
    L12:
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public final <T> void addRequest(JSONObject r110, String r111, String r112, String r113, boolean r114, ICJPayNetWorkCallback<T> r115) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, e.f25671s);
        Intrinsics.checkNotNullParameter(r115, "callback");
        addRequest(r110, r111, r112, r113, r114, null, r115);
    }

    public final void addRequest(JSONObject r100, String r101, String r102, String r103, boolean r104, String r105, ICJPayCallback r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        HashMap<String, String> r106 = null;
        if (r104 == false) goto L13;
        CJPayRiskInfo r107 = new CJPayRiskInfo();
        Map<String, String> r108 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().getRiskInfoParams();
        if (r108 != null) goto L7;
        r108 = null;
    L7:
        r107.riskInfoParamsMap = r108;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r107.toJsonNew());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#addRequest", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#addRequest", e);
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L16;
        r102 = BindCardCommonInfoUtil.INSTANCE.getMerchantId();
    L16:
        if (TextUtils.isEmpty(r103) == false) goto L18;
        r103 = BindCardCommonInfoUtil.INSTANCE.getAppId();
    L18:
        HashMap<String, String> r109 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().extraHeaderMap;
        if (r109 == null) goto L22;
        r106 = r109;
    L22:
        String r111 = CJPayParamsUtils.getHttpUrl(r101, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r112 = CJPayParamsUtils.getHttpData(r101, r100.toString(), r103, r102);
        if (TextUtils.isEmpty(r105) == true) goto L25;
        r112.put("timestamp", r105);
    L25:
        addRequest(CJPayNetworkManager.postForm(r111, r112, CJPayParamsUtils.getNetHeaderData(r111, r101, r106), r110));
    }

    private final <T> void addRequest(JSONObject r100, String r101, String r102, String r103, boolean r104, String r105, ICJPayNetWorkCallback<T> r110) {
        CJPayRiskInfo r106 = new CJPayRiskInfo();
        Map<String, String> r107 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().getRiskInfoParams();
        HashMap<String, String> r108 = null;
        if (r107 != null) goto L5;
        r107 = null;
    L5:
        r106.riskInfoParamsMap = r107;
        if (r104 == false) goto L10;
        JSONObject r109 = r106.toJsonNew();     // Catch: Exception -> L13
    L11:
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r109.toString());     // Catch: Exception -> L13
    L16:
        if (TextUtils.isEmpty(r102) == false) goto L19;
        r102 = BindCardCommonInfoUtil.INSTANCE.getMerchantId();
    L19:
        if (TextUtils.isEmpty(r103) == false) goto L21;
        r103 = BindCardCommonInfoUtil.INSTANCE.getAppId();
    L21:
        HashMap<String, String> r111 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().extraHeaderMap;
        if (r111 == null) goto L25;
        r108 = r111;
    L25:
        String r112 = CJPayParamsUtils.getHttpUrl(r101, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r113 = CJPayParamsUtils.getHttpData(r101, r100.toString(), r103, r102);
        if (TextUtils.isEmpty(r105) == true) goto L28;
        r113.put("timestamp", r105);
    L28:
        addRequest(CJPayNetworkManager.postForm(r112, r113, CJPayParamsUtils.getNetHeaderData(r112, r101, r108), r110));
        return;
    L10:
        r109 = r106.toJson();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardBaseModel#getSignParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardBaseModel#getSignParams", e);
        goto L16
    }

    private final <T> void request(String r110, String r111, String r112, String r113, JSONObject r114, ICJPayNetWorkCallback<T> r115, String r116, String r117) {
        HashMap<String, String> r100 = BindCardCommonInfoUtil.INSTANCE.getHostInfo().extraHeaderMap;
        String r101 = CJPayParamsUtils.getHttpUrl(r110, CJPayParamsUtils.HostAPI.BDPAY);
        addRequest(CJPayNetworkManager.postForm(r101, CJPayParamsUtils.getHttpData(r110, r112, r111, r114.toString(), r113, r116, r117), CJPayParamsUtils.getNetHeaderData(r101, r110, r100), r115));
    }

    private final <T> void requestWithSignData(final String r110, final String r111, final String r112, final String r113, final JSONObject r114, final CertSignParams r210, final ICJPayNetWorkCallback<T> r211, final ICJPayNewCardCallback r212) {
        final String r115 = "000000";
        ICJPayDyVerifyService r116 = (ICJPayDyVerifyService) CJPayServiceManager.getInstance().getIService(ICJPayDyVerifyService.class);
        ICertSignCallback r117 = new BindCardBaseModel$requestWithSignData$signCallback$1(r212, r210, this, r110, r111, r112, r113, r114, r211, r115);
        if (r116 == null) goto L5;
        r116.certSign(CJPayBasicExtensionKt.getContext(), r117);
        Unit r100 = Unit.INSTANCE;
    L6:
        if (r100 != null) goto L9;
        request(r110, r111, r112, r113, r114, r211, "000000", "");
        return;
    L9:
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static final /* synthetic */ void access$request(BindCardBaseModel r100, String r101, String r102, String r103, String r104, JSONObject r105, ICJPayNetWorkCallback r106, String r107, String r108) {
        r100.request(r101, r102, r103, r104, r105, r106, r107, r108);
    }

    private final <T> void addRequest(JSONObject r110, String r111, String r112, String r113, String r114, ICJPayNetWorkCallback<T> r115, boolean r116, CertSignParams r210, ICJPayNewCardCallback r211) {
        CJPayRiskInfo r100 = new CJPayRiskInfo();
        BindCardCommonInfoUtil r101 = BindCardCommonInfoUtil.INSTANCE;
        Map<String, String> r102 = r101.getHostInfo().getRiskInfoParams();
        r100.riskInfoParamsMap = r102;
        if (r102 == null) goto L5;
        r102.put("finance_risk", CJPayJsonParser.toJsonObject(CJPayRiskControlInfoKt.financeRiskWrapUp$default("cj_bindcard", null, null, false, 14, null)).toString());
    L5:
        KtSafeMethodExtensionKt.safePut(r110, DyVerifyReqConstants.Key.RISK_INFO, r100.toJsonNew());
        if (TextUtils.isEmpty(r112) == false) goto L8;
        String r103 = r101.getMerchantId();
    L10:
        if (TextUtils.isEmpty(r113) == false) goto L12;
        String r104 = r101.getAppId();
    L13:
        if (r116 == false) goto L15;
        requestWithSignData(r111, r103, r104, r114, r110, r210, r115, r211);
        return;
    L15:
        request(r111, r103, r104, r114, r110, r115, "", "");
        return;
    L12:
        r104 = r113;
        goto L13
    L8:
        r103 = r112;
        goto L10
    }

    public static /* synthetic */ void payWithNewCard$default(BindCardBaseModel r100, JSONObject r101, boolean r102, CertSignParams r110, ICJPayNewCardCallback r111, ICJPayNetWorkCallback r112, JSONObject r113, int r114, Object r115) {
        if (r115 != null) goto L22;
        if ((r114 & 2) == 0) goto L6;
        boolean r103 = false;
    L8:
        if ((r114 & 4) == 0) goto L10;
        CertSignParams r104 = null;
    L12:
        if ((r114 & 8) == 0) goto L14;
        ICJPayNewCardCallback r105 = null;
    L16:
        if ((r114 & 32) == 0) goto L18;
        JSONObject r106 = null;
    L19:
        r100.payWithNewCard(r101, r103, r104, r105, r112, r106);
        return;
    L18:
        r106 = r113;
        goto L19
    L14:
        r105 = r111;
        goto L16
    L10:
        r104 = r110;
        goto L12
    L6:
        r103 = r102;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payWithNewCard");
    }

    public static /* synthetic */ void requestWithSignData$default(BindCardBaseModel r110, String r111, String r112, String r113, String r114, JSONObject r115, CertSignParams r116, ICJPayNetWorkCallback r117, ICJPayNewCardCallback r118, int r119, Object r210) {
        if (r210 != null) goto L10;
        if ((r119 & 128) == 0) goto L6;
        ICJPayNewCardCallback r100 = null;
    L7:
        r110.requestWithSignData(r111, r112, r113, r114, r115, r116, r117, r100);
        return;
    L6:
        r100 = r118;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestWithSignData");
    }

    public static /* synthetic */ void addRequest$default(BindCardBaseModel r110, JSONObject r111, String r112, String r113, String r114, String r115, ICJPayNetWorkCallback r116, boolean r117, CertSignParams r118, ICJPayNewCardCallback r210, int r211, Object r212) {
        if (r212 != null) goto L10;
        if ((r211 & 256) == 0) goto L6;
        ICJPayNewCardCallback r119 = null;
    L7:
        r110.addRequest(r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L6:
        r119 = r210;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRequest");
    }
}
