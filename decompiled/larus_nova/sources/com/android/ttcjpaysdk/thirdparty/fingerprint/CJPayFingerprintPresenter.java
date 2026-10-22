package com.android.ttcjpaysdk.thirdparty.fingerprint;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.utils.CJPayFingerprintLogUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.utils.FingerprintParamsBuilder;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayFingerprintPresenter {
    private static final String DISABLE_BIOMETRICS_PAY_BY_USERINFO = "bytepay.member_product.disable_biometrics_pay_by_userinfo";
    private static final String METHOD_DISABLE_BIOMETRICS_PAY = "bytepay.member_product.disable_biometrics_pay";
    private static final String METHOD_ENABLE_BIOMETRICS_PAY = "bytepay.member_product.enable_biometrics_pay";
    private static final String METHOD_ENABLE_BIOMETRICS_PAY_WITHOUT_PWD = "bytepay.cashdesk.enable_biometrics_pay";
    private static final String METHOD_QUERY_BIOMETRICS_PAY_STATUS = "bytepay.member_product.query_biometrics_pay_status";
    private static final String METHOD_UPLOAD_BIOMETRICS = "bytepay.member_product.set_payment_security";
    private static final String METHOD_VERIFY_O_T_P = "bytepay.member_product.verify_o_t_p";
    private static final String METHOD_VERIFY_PASSWORD = "bytepay.member_product.verify_password";

    public static final enum PwdType extends Enum<PwdType> {
        private static final /* synthetic */ PwdType[] $VALUES = null;
        public static final PwdType FACE = null;
        public static final PwdType FINGERPRINT = null;
        private String type;

        private static /* synthetic */ PwdType[] $values() {
            return new PwdType[]{FINGERPRINT, FACE};
        }

        static {
            FINGERPRINT = new PwdType("FINGERPRINT", 0, "1");
            FACE = new PwdType("FACE", 1, "2");
            $VALUES = $values();
        }

        public static PwdType[] values() {
            return (PwdType[]) $VALUES.clone();
        }

        public String getType() {
            return this.type;
        }

        public static PwdType valueOf(String r100) {
            return (PwdType) a.a(PwdType.class, r100);
        }

        private PwdType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public CJPayFingerprintPresenter() {
    }

    public static String massageBase64Str(String r100) {
        return r100;
    }

    public static JSONObject buildCommonParams(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("uid", r100);     // Catch: JSONException -> L18
        CJPayHostInfo r102 = CJPayFingerprintService.hostInfo;     // Catch: JSONException -> L18
        String r103 = "";
        if (r102 == null) goto L7;
        String r104 = r102.merchantId;     // Catch: JSONException -> L18
    L8:
        r101.put("merchant_id", r104);     // Catch: JSONException -> L18
        CJPayHostInfo r105 = CJPayFingerprintService.hostInfo;     // Catch: JSONException -> L18
        if (r105 == null) goto L11;
        r103 = r105.appId;     // Catch: JSONException -> L18
    L11:
        r101.put("app_id", r103);     // Catch: JSONException -> L18
        r101.put(com.bytedance.android.ec.core.event.a.KEY_DID, CJEnv.c());     // Catch: JSONException -> L18
        r101.put("pwd_type", PwdType.FINGERPRINT.getType());     // Catch: JSONException -> L18
        r101.put("aid", CJEnv.e());     // Catch: JSONException -> L18
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L18
        CJPayHostInfo r107 = CJPayFingerprintService.hostInfo;     // Catch: JSONException -> L18
        if (r107 != null) goto L14;
    L16:
        r101.put(DyVerifyReqConstants.Key.RISK_INFO, r106);     // Catch: JSONException -> L18
    L20:
        return r101;
    L14:
        if (r107.getRiskInfoParams() == null) goto L16;
        r106.put("risk_str", new JSONObject(CJPayFingerprintService.hostInfo.getRiskInfoParams()));     // Catch: JSONException -> L18
        goto L16
    L7:
        r104 = "";
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public static JSONObject mapToJSONObj(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L12
    L8:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, String> r103 = r102.next();     // Catch: JSONException -> L12
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L12
        goto L8
    L11:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String buildDisableBiometricsPayParams(String r100, String r101) {
        JSONObject r102 = buildCommonParams(r101);
        r102.put(CJPayFingerprintSharedPrefUtils.KEY_SERIAL_NUM, r100);     // Catch: JSONException -> L5
        ArrayList r103 = new ArrayList();     // Catch: JSONException -> L5
        r103.add(CJPayFingerprintSharedPrefUtils.KEY_SERIAL_NUM);     // Catch: JSONException -> L5
        buildSecureParams(r102, r103);     // Catch: JSONException -> L5
    L8:
        return massageBase64Str(r102.toString());
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static void buildSecureParams(JSONObject r100, List<String> r101) {
        CJPaySecureRequestParams r102 = new CJPaySecureRequestParams();     // Catch: JSONException -> L9
        if (r101 != null) goto L5;
    L7:
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r102.toJson(CJEncryptScene.UNKNOWN));     // Catch: JSONException -> L9
        return;
    L5:
        if (r101.size() <= 0) goto L7;
        r102.fields.addAll(r101);     // Catch: JSONException -> L9
    }

    private static void buildSecureParamsWithoutPwd(JSONObject r100, List<String> r101) {
        CJPaySecureRequestParams r102 = new CJPaySecureRequestParams();     // Catch: JSONException -> L9
        r102.check = 1;     // Catch: JSONException -> L9
        if (r101 != null) goto L5;
    L7:
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r102.toJson(CJEncryptScene.UNKNOWN));     // Catch: JSONException -> L9
        return;
    L5:
        if (r101.size() <= 0) goto L7;
        r102.fields.addAll(r101);     // Catch: JSONException -> L9
    }

    public static void disableBiometricsPayByUser(String r100, ICJPayCallback r101) {
        String r102 = CJPayParamsUtils.getHttpUrl(DISABLE_BIOMETRICS_PAY_BY_USERINFO, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r103 = CJPayFingerprintService.hostInfo;
        if (r103 == null) goto L5;
        HashMap<String, String> r104 = r103.extraHeaderMap;
    L6:
        String r105 = "";
        if (r103 == null) goto L9;
        String r106 = r103.appId;
    L10:
        if (r103 == null) goto L12;
        r105 = r103.merchantId;
    L12:
        CJPayNetworkManager.postForm(r102, CJPayParamsUtils.getHttpData(DISABLE_BIOMETRICS_PAY_BY_USERINFO, buildCommonParams(r100).toString(), r106, r105), CJPayParamsUtils.getNetHeaderData(r102, DISABLE_BIOMETRICS_PAY_BY_USERINFO, r104), r101);
        return;
    L9:
        r106 = "";
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static void enableFingerprint(String r100, ICJPayCallback r101) {
        String r102 = CJPayParamsUtils.getHttpUrl(METHOD_ENABLE_BIOMETRICS_PAY, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r103 = CJPayFingerprintService.hostInfo;
        if (r103 == null) goto L5;
        HashMap<String, String> r104 = r103.extraHeaderMap;
    L6:
        String r105 = "";
        if (r103 == null) goto L9;
        String r106 = r103.appId;
    L10:
        if (r103 == null) goto L12;
        r105 = r103.merchantId;
    L12:
        CJPayNetworkManager.postForm(r102, CJPayParamsUtils.getHttpData(METHOD_ENABLE_BIOMETRICS_PAY, r100, r106, r105), CJPayParamsUtils.getNetHeaderData(r102, METHOD_ENABLE_BIOMETRICS_PAY, r104), r101);
        return;
    L9:
        r106 = "";
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static void queryFingerprintState(String r100, ICJPayCallback r101) {
        String r102 = CJPayParamsUtils.getHttpUrl("bytepay.member_product.query_biometrics_pay_status", CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r103 = CJPayFingerprintService.hostInfo;
        if (r103 == null) goto L5;
        HashMap<String, String> r104 = r103.extraHeaderMap;
    L6:
        String r105 = "";
        if (r103 == null) goto L9;
        String r106 = r103.appId;
    L10:
        if (r103 == null) goto L12;
        r105 = r103.merchantId;
    L12:
        CJPayNetworkManager.postForm(r102, CJPayParamsUtils.getHttpData("bytepay.member_product.query_biometrics_pay_status", buildCommonParams(r100).toString(), r106, r105), CJPayParamsUtils.getNetHeaderData(r102, "bytepay.member_product.query_biometrics_pay_status", r104), r101);
        return;
    L9:
        r106 = "";
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    private static String buildFingerprintParamsWhenWithoutPwd(JSONObject r100, String r101, String r102) {
        JSONObject r103 = buildCommonParams(r101);
        r103.put("process_info", r100);     // Catch: JSONException -> L15
        r103.put("is_jail_broken", CJPayBasicUtils.isJailBroken());     // Catch: JSONException -> L15
        r103.put(b.B0, r102);     // Catch: JSONException -> L15
        CJPayHostInfo r104 = CJPayFingerprintService.hostInfo;     // Catch: JSONException -> L15
        if (r104 == null) goto L6;
        String r105 = r104.enableBioSource;     // Catch: JSONException -> L15
    L7:
        HashMap r106 = new HashMap();     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r105) == true) goto L11;
        r106.put("source", r105);     // Catch: JSONException -> L15
    L11:
        if (r106.isEmpty() == true) goto L13;
        r103.put("exts", mapToJSONObj(r106));     // Catch: JSONException -> L15
    L13:
        ArrayList r107 = new ArrayList();     // Catch: JSONException -> L15
        r107.add(b.B0);     // Catch: JSONException -> L15
        buildSecureParamsWithoutPwd(r103, r107);     // Catch: JSONException -> L15
    L18:
        return massageBase64Str(r103.toString());
    L6:
        r105 = "";
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static void disableBiometricsPay(String r100, String r101, ICJPayCallback r102) {
        String r103 = CJPayParamsUtils.getHttpUrl(METHOD_DISABLE_BIOMETRICS_PAY, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r104 = CJPayFingerprintService.hostInfo;
        if (r104 == null) goto L5;
        HashMap<String, String> r105 = r104.extraHeaderMap;
    L6:
        String r106 = "";
        if (r104 == null) goto L9;
        String r107 = r104.appId;
    L10:
        if (r104 == null) goto L12;
        r106 = r104.merchantId;
    L12:
        CJPayNetworkManager.postForm(r103, CJPayParamsUtils.getHttpData(METHOD_DISABLE_BIOMETRICS_PAY, buildDisableBiometricsPayParams(r100, r101), r107, r106), CJPayParamsUtils.getNetHeaderData(r103, METHOD_DISABLE_BIOMETRICS_PAY, r105), r102);
        return;
    L9:
        r107 = "";
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public static void uploadFingerId(String r110, String r111, ICJPayCallback r112) {
        String r100 = CJPayParamsUtils.getHttpUrl(METHOD_UPLOAD_BIOMETRICS, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r101 = CJPayFingerprintService.hostInfo;
        if (r101 == null) goto L5;
        HashMap<String, String> r102 = r101.extraHeaderMap;
    L6:
        if (r101 == null) goto L8;
        String r103 = r101.appId;
    L9:
        if (r101 == null) goto L11;
        String r104 = r101.merchantId;
    L16:
        String r105 = new String(Base64.decode(CJPayFingerprintSharedPrefUtils.getInstance().getSerialNum(r110, CJEnv.e()), 2));     // Catch: Exception -> L14
        CJEncryptScene r106 = CJEncryptScene.UNKNOWN;     // Catch: Exception -> L14
        String r107 = CJPayEncryptHelper.getEncryptDataSM(r106, r105, "核身-指纹upload", "biometrics_serial_num");     // Catch: Exception -> L14
        JSONObject r113 = buildCommonParams(r110);     // Catch: Exception -> L14
        r113.put("security_type", "UploadBioIds");     // Catch: Exception -> L14
        r113.put("bio_ids", Base64.encodeToString(r111.getBytes(), 2));     // Catch: Exception -> L14
        r113.put("action", "update");     // Catch: Exception -> L14
        r113.put("biometrics_serial_num", r107);     // Catch: Exception -> L14
        CJPaySecureRequestParams r114 = new CJPaySecureRequestParams();     // Catch: Exception -> L14
        r114.fields.add("biometrics_serial_num");     // Catch: Exception -> L14
        r113.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r114.toJson(r106));     // Catch: Exception -> L14
        CJPayNetworkManager.postForm(r100, CJPayParamsUtils.getHttpData(METHOD_UPLOAD_BIOMETRICS, massageBase64Str(r113.toString()), r103, r104), CJPayParamsUtils.getNetHeaderData(r100, METHOD_UPLOAD_BIOMETRICS, r102), r112);     // Catch: Exception -> L14
        return;
    L14:
        CJPayFingerprintLogUtils.walletFingerprintUpload("uploadFingerId Exception");
        return;
    L11:
        r104 = "800010000160013";
        goto L16
    L8:
        r103 = "NA202008272032554177543173";
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    private static String buildVerifyPasswordParams(String r100, String r101, String r102, CJEncryptScene r103) {
        JSONObject r104 = buildCommonParams(r101);
        r104.put("member_biz_order_no", r102);     // Catch: JSONException -> L5
        r104.put("password", r100);     // Catch: JSONException -> L5
        CJPaySecureRequestParams r105 = new CJPaySecureRequestParams();     // Catch: JSONException -> L5
        r105.fields.add("password");     // Catch: JSONException -> L5
        r104.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r105.toJson(r103));     // Catch: JSONException -> L5
    L8:
        return massageBase64Str(r104.toString());
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static void enableFingerprintWithoutPwd(JSONObject r100, String r101, String r102, ICJPayCallback r103) {
        String r104 = CJPayParamsUtils.getHttpUrl(METHOD_ENABLE_BIOMETRICS_PAY_WITHOUT_PWD, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r105 = CJPayFingerprintService.hostInfo;
        if (r105 == null) goto L5;
        HashMap<String, String> r106 = r105.extraHeaderMap;
    L6:
        String r107 = "";
        if (r105 == null) goto L9;
        String r108 = r105.appId;
    L10:
        if (r105 == null) goto L12;
        r107 = r105.merchantId;
    L12:
        CJPayNetworkManager.postForm(r104, CJPayParamsUtils.getHttpData(METHOD_ENABLE_BIOMETRICS_PAY_WITHOUT_PWD, buildFingerprintParamsWhenWithoutPwd(r100, r101, r102), r108, r107), CJPayParamsUtils.getNetHeaderData(r104, METHOD_ENABLE_BIOMETRICS_PAY_WITHOUT_PWD, r106), r103);
        return;
    L9:
        r108 = "";
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public static void verifyPasswordForOpenFingerprint(String r100, String r101, String r102, CJEncryptScene r103, ICJPayCallback r110) {
        String r104 = CJPayParamsUtils.getHttpUrl("bytepay.member_product.verify_password", CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r105 = CJPayFingerprintService.hostInfo;
        if (r105 == null) goto L5;
        HashMap<String, String> r106 = r105.extraHeaderMap;
    L6:
        String r107 = "";
        if (r105 == null) goto L9;
        String r108 = r105.appId;
    L10:
        if (r105 == null) goto L12;
        r107 = r105.merchantId;
    L12:
        CJPayNetworkManager.postForm(r104, CJPayParamsUtils.getHttpData("bytepay.member_product.verify_password", buildVerifyPasswordParams(r100, r101, r102, r103), r108, r107), CJPayParamsUtils.getNetHeaderData(r104, "bytepay.member_product.verify_password", r106), r110);
        return;
    L9:
        r108 = "";
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public static void enableFingerprint(String r100, String r101, String r102, String r110, String r111, ICJPayCallback r112) {
        if (TextUtils.equals(CJPayABExperimentKeys.getVerifyBioOpt().value(false), "1") == false) goto L9;
        FingerprintParamsBuilder r103 = new FingerprintParamsBuilder().setEncryptedPwd(r100).setKey(r101).setUid(r102).setTradeNo(r110).setMemberBizOrderNo(r111);
        CJPayHostInfo r104 = CJPayFingerprintService.hostInfo;
        if (r104 == null) goto L7;
        String r105 = r104.enableBioSource;
    L8:
        enableFingerprint(r103.setSource(r105).setBioIdArray(CJPayBasicUtils.getBiometricIds()).build(), r112);
        return;
    L7:
        r105 = "";
        goto L8
    L9:
        enableFingerprint(r100, r101, r102, r110, r111, "", r112);
    }

    private static String buildFingerprintParams(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        JSONObject r107 = buildCommonParams(r102);
        r107.put("mobile_pwd", r100);     // Catch: JSONException -> L21
        r107.put("key", r101);     // Catch: JSONException -> L21
        r107.put("token", r105);     // Catch: JSONException -> L21
        r107.put("member_biz_order_no", r104);     // Catch: JSONException -> L21
        r107.put("is_jail_broken", CJPayBasicUtils.isJailBroken());     // Catch: JSONException -> L21
        HashMap r108 = new HashMap();     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r108.put(b.B0, r103);     // Catch: JSONException -> L21
    L7:
        if (TextUtils.isEmpty(r106) == true) goto L10;
        r108.put("source", r106);     // Catch: JSONException -> L21
    L10:
        if (r108.isEmpty() == true) goto L12;
        r107.put("exts", mapToJSONObj(r108));     // Catch: JSONException -> L21
    L12:
        ArrayList r109 = new ArrayList();     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r105) == true) goto L16;
        r109.add("key");     // Catch: JSONException -> L21
    L19:
        buildSecureParams(r107, r109);     // Catch: JSONException -> L21
    L24:
        return massageBase64Str(r107.toString());
    L16:
        if (TextUtils.isEmpty(r104) == false) goto L18;
        r109.add("mobile_pwd");     // Catch: JSONException -> L21
        goto L19
    L18:
        r109.add("key");     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static void enableFingerprint(String r110, String r111, String r112, String r113, String r114, String r115, ICJPayCallback r210) {
        String r100 = CJPayParamsUtils.getHttpUrl(METHOD_ENABLE_BIOMETRICS_PAY, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo r101 = CJPayFingerprintService.hostInfo;
        if (r101 == null) goto L5;
        HashMap<String, String> r102 = r101.extraHeaderMap;
    L6:
        String r103 = "";
        if (r101 == null) goto L9;
        String r104 = r101.appId;
    L10:
        if (r101 == null) goto L12;
        String r105 = r101.merchantId;
    L13:
        if (r101 == null) goto L15;
        r103 = r101.enableBioSource;
    L15:
        CJPayNetworkManager.postForm(r100, CJPayParamsUtils.getHttpData(METHOD_ENABLE_BIOMETRICS_PAY, buildFingerprintParams(r110, r111, r112, r113, r114, r115, r103), r104, r105), CJPayParamsUtils.getNetHeaderData(r100, METHOD_ENABLE_BIOMETRICS_PAY, r102), r210);
        return;
    L12:
        r105 = "";
        goto L13
    L9:
        r104 = "";
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
