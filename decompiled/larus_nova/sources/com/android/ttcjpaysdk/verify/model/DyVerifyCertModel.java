package com.android.ttcjpaysdk.verify.model;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.android.ttcjpaysdk.verify.data.DyVerifyCertBaseReq;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002JB\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015H\u0002J8\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015J.\u0010\u0017\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015J$\u0010\u0018\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015J$\u0010\u0019\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015J$\u0010\u001a\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015J$\u0010\u001b\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/verify/model/DyVerifyCertModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "buildCertBaseParams", "Lorg/json/JSONObject;", "reqParams", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyCertBaseReq;", "buildGenPartCsrParams", "signFactorId", "", "genPartCsrData", "buildGetCertParams", "csrData", "doRequest", "", ExifInterface.GPS_DIRECTION_TRUE, e.f25671s, "params", "appId", "merchantId", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "genPartCsr", "getCert", "getSignFactor", "initialCsr", "invalidCert", "queryCert", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyCertModel extends MvpModel {
    public DyVerifyCertModel() {
    }

    private final JSONObject buildCertBaseParams(DyVerifyCertBaseReq r100) {
        if (r100 == null) goto L11;
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L6
        KtSafeMethodExtensionKt.safePutAll(r101, CJPayJsonParser.toJsonObject(r100));     // Catch: Throwable -> L6
        KtSafeMethodExtensionKt.safePut(r101, "dev_info", CJPayBasicUtils.getJsonDeviceInfo(r100.merchant_id));     // Catch: Throwable -> L6
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L6
        Map<String, String> r103 = CJPayBasicUtils.getBasicRiskInfo(r100.merchant_id);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Throwable -> L6
        KtSafeMethodExtensionKt.safePut(r102, "risk_str", new JSONObject(r103));     // Catch: Throwable -> L6
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L6
        KtSafeMethodExtensionKt.safePut(r101, DyVerifyReqConstants.Key.RISK_INFO, r102);     // Catch: Throwable -> L6
        return r101;
    L6:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyCertModel#buildCertBaseParams", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyCertModel#buildCertBaseParams", th);
        return null;
    L11:
        return null;
    }

    private final JSONObject buildGetCertParams(String r100, DyVerifyCertBaseReq r101) {
        if (r101 == null) goto L24;
        boolean r102 = false;
        if (r100 != null) goto L7;
    L9:
        if (r102 == false) goto L11;
        DyVerifyCertBaseReq r103 = r101;
    L12:
        if (r103 == null) goto L25;
        JSONObject r104 = buildCertBaseParams(r101);     // Catch: Throwable -> L19
        if (r104 == null) goto L26;
        KtSafeMethodExtensionKt.safePut(r104, "csr_data", r100);     // Catch: Throwable -> L19
        CJPayEncryptHelper.Companion r105 = CJPayEncryptHelper.Companion;     // Catch: Throwable -> L19
        CJEncryptScene r106 = CJEncryptScene.UNKNOWN;     // Catch: Throwable -> L19
        String r107 = r105.getEncryptDataSM(r106, r101.member_biz_order_no, DyVerifyReqConstants.Value.VERIFY_SDK, "member_biz_order_no");     // Catch: Throwable -> L19
        if ((!StringsKt.isBlank(r107)) == false) goto L27;
        CJPaySecureRequestParams r108 = new CJPaySecureRequestParams();     // Catch: Throwable -> L19
        r108.fields.add("member_biz_order_no");     // Catch: Throwable -> L19
        KtSafeMethodExtensionKt.safePut(r104, "member_biz_order_no", r107);     // Catch: Throwable -> L19
        KtSafeMethodExtensionKt.safePut(r104, DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r108.toJson(r106));     // Catch: Throwable -> L19
    L27:
        return r104;
    L26:
        return null;
    L19:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyCertModel#buildGetCertParams", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyCertModel#buildGetCertParams", th);
        return null;
    L25:
        return null;
    L11:
        r103 = null;
        goto L12
    L7:
        if ((!StringsKt.isBlank(r100)) != true) goto L9;
        r102 = true;
        goto L9
    L24:
        return null;
    }

    public final <T> void getSignFactor(DyVerifyCertBaseReq r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r102 = buildCertBaseParams(r100);
        if (r100 == null) goto L5;
        String r103 = r100.app_id;
    L6:
        if (r100 == null) goto L8;
        String r104 = r100.merchant_id;
    L9:
        doRequest(DyVerifyReqConstants.Method.GETSIGNFACTOR, r102, r103, r104, r101);
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final <T> void initialCsr(DyVerifyCertBaseReq r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r102 = buildCertBaseParams(r100);
        if (r100 == null) goto L5;
        String r103 = r100.app_id;
    L6:
        if (r100 == null) goto L8;
        String r104 = r100.merchant_id;
    L9:
        doRequest(DyVerifyReqConstants.Method.INITIALCSR, r102, r103, r104, r101);
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final <T> void invalidCert(DyVerifyCertBaseReq r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r102 = buildCertBaseParams(r100);
        if (r100 == null) goto L5;
        String r103 = r100.app_id;
    L6:
        if (r100 == null) goto L8;
        String r104 = r100.merchant_id;
    L9:
        doRequest(DyVerifyReqConstants.Method.INVALIDCERT, r102, r103, r104, r101);
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final <T> void queryCert(DyVerifyCertBaseReq r100, ICJPayNetWorkCallback<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r102 = buildCertBaseParams(r100);
        if (r100 == null) goto L5;
        String r103 = r100.app_id;
    L6:
        if (r100 == null) goto L8;
        String r104 = r100.merchant_id;
    L9:
        doRequest(DyVerifyReqConstants.Method.QUERYCERT, r102, r103, r104, r101);
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    private final JSONObject buildGenPartCsrParams(String r100, String r101, DyVerifyCertBaseReq r102) {
        if (r102 == null) goto L31;
        boolean r103 = false;
        if (r101 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L18;
        if (r100 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        r103 = true;
        goto L18
    L13:
        if ((!StringsKt.isBlank(r100)) != true) goto L15;
        r105 = true;
    L18:
        if (r103 == false) goto L20;
        DyVerifyCertBaseReq r106 = r102;
    L21:
        if (r106 == null) goto L32;
        JSONObject r107 = buildCertBaseParams(r102);     // Catch: Throwable -> L26
        if (r107 == null) goto L33;
        KtSafeMethodExtensionKt.safePut(r107, "gen_part_csr_data", r101);     // Catch: Throwable -> L26
        KtSafeMethodExtensionKt.safePut(r107, "sign_factor_id", r100);     // Catch: Throwable -> L26
        return r107;
    L33:
        return null;
    L26:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyCertModel#buildGenPartCsrParams", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyCertModel#buildGenPartCsrParams", th);
        return null;
    L32:
        return null;
    L20:
        r106 = null;
        goto L21
    L7:
        if ((!StringsKt.isBlank(r101)) != true) goto L9;
        r104 = true;
        goto L10
    L31:
        return null;
    }

    public final <T> void getCert(String r100, DyVerifyCertBaseReq r101, ICJPayNetWorkCallback<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        JSONObject r102 = buildGetCertParams(r100, r101);
        String r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.app_id;
    L6:
        if (r101 == null) goto L8;
        r103 = r101.merchant_id;
    L8:
        doRequest(DyVerifyReqConstants.Method.GETERT, r102, r104, r103, r110);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final <T> void genPartCsr(String r100, String r101, DyVerifyCertBaseReq r110, ICJPayNetWorkCallback<T> r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        JSONObject r102 = buildGenPartCsrParams(r100, r101, r110);
        String r103 = null;
        if (r110 == null) goto L5;
        String r104 = r110.app_id;
    L6:
        if (r110 == null) goto L8;
        r103 = r110.merchant_id;
    L8:
        doRequest(DyVerifyReqConstants.Method.GENPARTCSR, r102, r104, r103, r111);
        return;
    L5:
        r104 = null;
        goto L6
    }

    private final <T> void doRequest(String r100, JSONObject r101, String r102, String r103, ICJPayNetWorkCallback<T> r104) {
        Unit r105 = null;
        if (r101 == null) goto L5;
        String r106 = CJPayParamsUtils.getHttpUrl(r100, CJPayParamsUtils.HostAPI.BDPAY);
        addRequest(CJPayNetworkManager.postForm(r106, CJPayParamsUtils.getHttpData(r100, r101.toString(), r102, r103), CJPayParamsUtils.getNetHeaderData(r106, r100, null), r104));
        r105 = Unit.INSTANCE;
    L5:
        if (r105 != null) goto L8;
        r104.onFailure("", "reqParams is null");
        return;
    }
}
