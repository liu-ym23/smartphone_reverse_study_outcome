package com.android.ttcjpaysdk.verify.model;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.android.ttcjpaysdk.verify.data.DyVerifyToken;
import com.android.ttcjpaysdk.verify.data.product.DyVerifyMsg;
import com.android.ttcjpaysdk.verify.data.product.DyVerifyPassword;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tJ6\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\b\b\u0002\u0010\r\u001a\u00020\u000eJ.\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/verify/model/DyVerifyModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "sendSmsCode", "", ExifInterface.GPS_DIRECTION_TRUE, "verifyToken", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "verifyPassword", "password", "", "isDegradeInvoke", "", "verifySmsCode", "sms", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyModel extends MvpModel {
    public DyVerifyModel() {
    }

    public final <T> void sendSmsCode(DyVerifyToken r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100 != null) goto L12;
        r101.onFailure("", "RequestParams is null");
        return;
    L12:
        Map<String, String> r102 = CJPayBasicUtils.getBasicRiskInfo("");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L8
        JSONObject r103 = new JSONObject(r102);     // Catch: Exception -> L8
    L10:
        DyVerifyMsg r104 = r100.product.MSG;
        JSONObject r105 = new JSONObject();
        r105.put(DyVerifyReqConstants.Key.RISK_INFO, r103);
        r105.put(DyVerifyReqConstants.Key.SMCH_ID, DyVerifyReqConstants.Value.DIAMOND);
        r105.put("member_biz_order_no", r104.member_biz_order_no);
        String r106 = CJPayParamsUtils.getHttpUrl(DyVerifyReqConstants.Method.ACQUIRE_SMS, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r107 = CJPayParamsUtils.getHttpData(DyVerifyReqConstants.Method.ACQUIRE_SMS, r105.toString(), r104.app_id, r104.merchant_id);
        r107.put("timestamp", String.valueOf(System.currentTimeMillis()));
        addRequest(CJPayNetworkManager.postForm(r106, r107, CJPayParamsUtils.getNetHeaderData(r106, DyVerifyReqConstants.Method.ACQUIRE_SMS, null), r101));
        return;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyModel#unknown", e);
        r103 = new JSONObject();
        goto L10
    }

    public final <T> void verifySmsCode(String r100, DyVerifyToken r110, ICJPayNetWorkCallback<T> r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r110 != null) goto L19;
        r111.onFailure("", "RequestParams is null");
        return;
    L19:
        Map<String, String> r101 = CJPayBasicUtils.getBasicRiskInfo("");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L8
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L8
    L10:
        JSONObject r103 = new JSONObject();
        DyVerifyMsg r112 = r110.product.MSG;
        CJEncryptScene r104 = CJEncryptScene.TRADE_VERIFY;     // Catch: Exception -> L13
        String r105 = CJPayEncryptHelper.Companion.getEncryptDataSM(r104, r100, DyVerifyReqConstants.Value.VERIFY_SDK, "sms");     // Catch: Exception -> L13
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L13
        r106.put("sms", r105);     // Catch: Exception -> L13
        CJPaySecureRequestParams r107 = new CJPaySecureRequestParams();     // Catch: Exception -> L13
        r107.fields.add("enc_params.sms");     // Catch: Exception -> L13
        JSONObject r108 = r107.toJson(r104);     // Catch: Exception -> L13
        r103.put(DyVerifyReqConstants.Key.RISK_INFO, r102);     // Catch: Exception -> L13
        r103.put("member_biz_order_no", r112.member_biz_order_no);     // Catch: Exception -> L13
        r103.put(DyVerifyReqConstants.Key.ENC_PARAMS, r106);     // Catch: Exception -> L13
        r103.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r108);     // Catch: Exception -> L13
    L15:
        String r109 = CJPayParamsUtils.getHttpUrl(DyVerifyReqConstants.Method.VERIFY_SMS, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r113 = CJPayParamsUtils.getHttpData(DyVerifyReqConstants.Method.VERIFY_SMS, r103.toString(), r112.app_id, r112.merchant_id);
        r113.put("timestamp", String.valueOf(System.currentTimeMillis()));
        addRequest(CJPayNetworkManager.postForm(r109, r113, CJPayParamsUtils.getNetHeaderData(r109, DyVerifyReqConstants.Method.VERIFY_SMS, null), r111));
        return;
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyModel#unknown", e);
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyModel#unknown", e);
        r102 = new JSONObject();
        goto L10
    }

    public final <T> void verifyPassword(String r100, DyVerifyToken r110, ICJPayNetWorkCallback<T> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "password");
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L24;
        if (r110 == null) goto L24;
        DyVerifyPassword r113 = r110.product.PASSWORD;
        String r102 = r113.merchant_id;
        Map<String, String> r103 = CJPayBasicUtils.getBasicRiskInfo("");     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L13
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L13
    L15:
        if (r112 == false) goto L17;
        JSONObject r114 = CJPayBasicUtils.getJsonDeviceInfo(r102);
        KtSafeMethodExtensionKt.safePut(r114, a.KEY_DID, CJEnv.c());
        KtSafeMethodExtensionKt.safePut(r114, "aid", CJEnv.e());
        KtSafeMethodExtensionKt.safePut(r114, a.KEY_BIO_TYPE, String.valueOf(KtSafeMethodExtensionKt.safeCreate(CJPayBasicUtils.getBiometricsInfo(CJEnv.h())).optInt(a.KEY_BIO_TYPE)));
        Unit r105 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r104, "dev_info", r114);
    L17:
        JSONObject r115 = new JSONObject();
        Map<String, String> r106 = CJPayBasicUtils.getBasicRiskInfo(r102);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        KtSafeMethodExtensionKt.safePut(r115, "risk_str", new JSONObject(r106));
        Unit r107 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r104, DyVerifyReqConstants.Key.RISK_INFO, r115);
        r104.put("member_biz_order_no", r113.member_biz_order_no);
        CJEncryptScene r116 = CJEncryptScene.TRADE_VERIFY;
        r104.put("password", CJPayEncryptHelper.Companion.getEncryptDataWithoutSalt(r116, r100, DyVerifyReqConstants.Value.VERIFY_SDK));     // Catch: Exception -> L20
        CJPaySecureRequestParams r108 = new CJPaySecureRequestParams();     // Catch: Exception -> L20
        r108.fields.add("password");     // Catch: Exception -> L20
        r104.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r108.toJson(r116));     // Catch: Exception -> L20
    L22:
        String r109 = CJPayParamsUtils.getHttpUrl(DyVerifyReqConstants.Method.VERIFY_PASSWORD, CJPayParamsUtils.HostAPI.BDPAY);
        addRequest(CJPayNetworkManager.postForm(r109, CJPayParamsUtils.getHttpData(DyVerifyReqConstants.Method.VERIFY_PASSWORD, r104.toString(), r113.app_id, r102), CJPayParamsUtils.getNetHeaderData(r109, DyVerifyReqConstants.Method.VERIFY_PASSWORD, null), r111));
        return;
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyModel#unknown", e);
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyModel#unknown", e);
        r104 = new JSONObject();
    L24:
        r111.onFailure("", "RequestParams is null");
        return;
    L5:
        r101 = false;
        goto L7
    }

    public static /* synthetic */ void verifyPassword$default(DyVerifyModel r100, String r101, DyVerifyToken r102, ICJPayNetWorkCallback r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = false;
    L5:
        r100.verifyPassword(r101, r102, r103, r104);
    }
}
