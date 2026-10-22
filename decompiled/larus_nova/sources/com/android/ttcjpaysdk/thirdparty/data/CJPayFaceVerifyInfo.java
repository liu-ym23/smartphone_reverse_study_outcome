package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.CJUnifyPreVerifyManager;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyFaceVM;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00012Bá\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\fJ\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\fJ\u001a\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\fH\u0002J\u0006\u0010(\u001a\u00020\fJ\u0010\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010-J\u0016\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020-R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "verify_type", "", "face_content", "agreement_url", "agreement_desc", "name_mask", "uid", DyVerifyReqConstants.Key.SMCH_ID, "need_live_detection", "", BytedCertConstant.CertKey.VERIFY_CHANNEL, "show_style", "button_desc", "face_scene", "skip_check_agreement", "merchant_app_id", "merchant_id", "face_pay_scene", "title", "icon_url", "verify_params", "std_verify_tag", "verify_id", "verify_token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "getConfigurationParams", "getIsSigned", "getIsSignedValue", "getLiveRoute", "getMerchantId", "getOrderNo", "hasSrc", "hitStdForFace", "isConfigurationParamsValid", "params", "isSigned", "isContainsVerifyParams", "isHitFullPage", "serverSource", "parseJSON", "json", "Lorg/json/JSONObject;", "setNameAndUId", "name", "id", "toJSON", "FacePayScene", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceVerifyInfo implements Serializable, CJPayObject {
    public String agreement_desc;
    public String agreement_url;
    public String button_desc;
    public String face_content;
    public String face_pay_scene;
    public String face_scene;
    public String icon_url;
    public String merchant_app_id;
    public String merchant_id;
    public String name_mask;
    public boolean need_live_detection;
    public String show_style;
    public boolean skip_check_agreement;
    public String smch_id;
    public String std_verify_tag;
    public String title;
    public String uid;
    public String verify_channel;
    public String verify_id;
    public String verify_params;
    public String verify_token;
    public String verify_type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo$FacePayScene;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "DEFAULT_LIVE", "FORGET_PWD_FACE_PAY", "FORGET_PWD_SMS_PAY", "FORGET_PWD_BIO_PAY", "PWD_LOCK_FACE_PAY", "PWD_LOCK_SMS_PAY", "PWD_LOCK_BIO_PAY", "RETAIN_FACE_PAY", "RETAIN_SMS_PAY", "RETAIN_BIO_PAY", "PWD_ERROR_FACE_PAY", "PWD_ERROR_SMS_PAY", "PWD_ERROR_BIO_PAY", "TOP_RIGHT_FACE_PAY", "SET_PWD_FACE_PAY", "RESET_PWD_FACE_PAY", "PWD_ERROR_JUMP_FACE_PAY", "TOP_RIGHT_SMS_PAY", "TOP_RIGHT_BIO_PAY", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum FacePayScene extends Enum<FacePayScene> {
        private static final /* synthetic */ FacePayScene[] $VALUES = null;
        public static final FacePayScene DEFAULT_LIVE = null;
        public static final FacePayScene FORGET_PWD_BIO_PAY = null;
        public static final FacePayScene FORGET_PWD_FACE_PAY = null;
        public static final FacePayScene FORGET_PWD_SMS_PAY = null;
        public static final FacePayScene PWD_ERROR_BIO_PAY = null;
        public static final FacePayScene PWD_ERROR_FACE_PAY = null;
        public static final FacePayScene PWD_ERROR_JUMP_FACE_PAY = null;
        public static final FacePayScene PWD_ERROR_SMS_PAY = null;
        public static final FacePayScene PWD_LOCK_BIO_PAY = null;
        public static final FacePayScene PWD_LOCK_FACE_PAY = null;
        public static final FacePayScene PWD_LOCK_SMS_PAY = null;
        public static final FacePayScene RESET_PWD_FACE_PAY = null;
        public static final FacePayScene RETAIN_BIO_PAY = null;
        public static final FacePayScene RETAIN_FACE_PAY = null;
        public static final FacePayScene RETAIN_SMS_PAY = null;
        public static final FacePayScene SET_PWD_FACE_PAY = null;
        public static final FacePayScene TOP_RIGHT_BIO_PAY = null;
        public static final FacePayScene TOP_RIGHT_FACE_PAY = null;
        public static final FacePayScene TOP_RIGHT_SMS_PAY = null;
        private final String desc;

        private static final /* synthetic */ FacePayScene[] $values() {
            return new FacePayScene[]{DEFAULT_LIVE, FORGET_PWD_FACE_PAY, FORGET_PWD_SMS_PAY, FORGET_PWD_BIO_PAY, PWD_LOCK_FACE_PAY, PWD_LOCK_SMS_PAY, PWD_LOCK_BIO_PAY, RETAIN_FACE_PAY, RETAIN_SMS_PAY, RETAIN_BIO_PAY, PWD_ERROR_FACE_PAY, PWD_ERROR_SMS_PAY, PWD_ERROR_BIO_PAY, TOP_RIGHT_FACE_PAY, SET_PWD_FACE_PAY, RESET_PWD_FACE_PAY, PWD_ERROR_JUMP_FACE_PAY, TOP_RIGHT_SMS_PAY, TOP_RIGHT_BIO_PAY};
        }

        public static FacePayScene valueOf(String r100) {
            return (FacePayScene) a.a(FacePayScene.class, r100);
        }

        public static FacePayScene[] values() {
            return (FacePayScene[]) $VALUES.clone();
        }

        static {
            DEFAULT_LIVE = new FacePayScene("DEFAULT_LIVE", 0, VerifyFaceVM.DEFAULT_FACE_SCENE);
            FORGET_PWD_FACE_PAY = new FacePayScene("FORGET_PWD_FACE_PAY", 1, "forget_pwd_face_pay");
            FORGET_PWD_SMS_PAY = new FacePayScene("FORGET_PWD_SMS_PAY", 2, "forget_pwd_sms_pay");
            FORGET_PWD_BIO_PAY = new FacePayScene("FORGET_PWD_BIO_PAY", 3, "forget_pwd_bio_pay");
            PWD_LOCK_FACE_PAY = new FacePayScene("PWD_LOCK_FACE_PAY", 4, "pwd_lock_face_pay");
            PWD_LOCK_SMS_PAY = new FacePayScene("PWD_LOCK_SMS_PAY", 5, "pwd_lock_sms_pay");
            PWD_LOCK_BIO_PAY = new FacePayScene("PWD_LOCK_BIO_PAY", 6, "pwd_lock_bio_pay");
            RETAIN_FACE_PAY = new FacePayScene("RETAIN_FACE_PAY", 7, "retain_face_pay");
            RETAIN_SMS_PAY = new FacePayScene("RETAIN_SMS_PAY", 8, "retain_sms_pay");
            RETAIN_BIO_PAY = new FacePayScene("RETAIN_BIO_PAY", 9, "retain_bio_pay");
            PWD_ERROR_FACE_PAY = new FacePayScene("PWD_ERROR_FACE_PAY", 10, "pwd_error_face_pay");
            PWD_ERROR_SMS_PAY = new FacePayScene("PWD_ERROR_SMS_PAY", 11, "pwd_error_sms_pay");
            PWD_ERROR_BIO_PAY = new FacePayScene("PWD_ERROR_BIO_PAY", 12, "pwd_error_bio_pay");
            TOP_RIGHT_FACE_PAY = new FacePayScene("TOP_RIGHT_FACE_PAY", 13, "top_right_face_pay");
            SET_PWD_FACE_PAY = new FacePayScene("SET_PWD_FACE_PAY", 14, CJUnifyPreVerifyManager.POP_SOURCE_SET_PWD);
            RESET_PWD_FACE_PAY = new FacePayScene("RESET_PWD_FACE_PAY", 15, CJUnifyPreVerifyManager.POP_SOURCE_RESET_PWD);
            PWD_ERROR_JUMP_FACE_PAY = new FacePayScene("PWD_ERROR_JUMP_FACE_PAY", 16, "direct_pwd_error_face_pay");
            TOP_RIGHT_SMS_PAY = new FacePayScene("TOP_RIGHT_SMS_PAY", 17, "top_right_sms_pay");
            TOP_RIGHT_BIO_PAY = new FacePayScene("TOP_RIGHT_BIO_PAY", 18, "top_right_bio_pay");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        private FacePayScene(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    public CJPayFaceVerifyInfo() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    private final String getIsSignedValue() {
        return KtSafeMethodExtensionKt.safeCreate(this.verify_params).optString("is_signed");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#getIsSignedValue", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#getIsSignedValue", e);
        return "";
    }

    public final String getAppId() {
        return KtSafeMethodExtensionKt.safeCreate(this.verify_params).optString("app_id");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#getAppId", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#getAppId", e);
        return "";
    }

    public final String getConfigurationParams() {
        return KtSafeMethodExtensionKt.safeCreate(this.verify_params).optString("configuration_params");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#getConfigurationParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#getConfigurationParams", e);
        return "";
    }

    public final String getLiveRoute() {
        return KtSafeMethodExtensionKt.safeCreate(this.verify_params).optString("live_route");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#getLiveRoute", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#getLiveRoute", e);
        return "";
    }

    public final String getMerchantId() {
        return KtSafeMethodExtensionKt.safeCreate(this.verify_params).optString("merchant_id");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#getMerchantId", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#getMerchantId", e);
        return "";
    }

    public final String getOrderNo() {
        return KtSafeMethodExtensionKt.safeCreate(this.verify_params).optString("member_biz_order_no");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#getOrderNo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#getOrderNo", e);
        return "";
    }

    public final boolean hasSrc() {
        return Intrinsics.areEqual(this.verify_type, "1");
    }

    public final boolean hitStdForFace() {
        if (Intrinsics.areEqual("1", this.std_verify_tag) == true) goto L5;
    L9:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.verify_id)) == false) goto L9;
        if ((!StringsKt.isBlank(this.verify_token)) == false) goto L9;
        return true;
    }

    public final boolean isContainsVerifyParams() {
        return !StringsKt.isBlank(this.verify_params);
    }

    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("verify_type", this.verify_type);
        r100.put("face_content", this.face_content);
        r100.put("agreement_url", this.agreement_url);
        r100.put("agreement_desc", this.agreement_desc);
        r100.put("name_mask", this.name_mask);
        r100.put("uid", this.uid);
        return r100;
    }

    public final boolean getIsSigned() {
        return Intrinsics.areEqual(getIsSignedValue(), "1");
    }

    public final boolean isHitFullPage(String r100) {
        if ((!StringsKt.isBlank(getOrderNo())) == true) goto L5;
    L18:
        return false;
    L5:
        if ((!StringsKt.isBlank(getLiveRoute())) == false) goto L18;
        if ((!StringsKt.isBlank(getIsSignedValue())) == false) goto L18;
        if (r100 == null) goto L10;
        Boolean r101 = Boolean.valueOf(!StringsKt.isBlank(r100));
    L11:
        if (r101 == null) goto L13;
        boolean r102 = r101.booleanValue();
    L14:
        if (r102 == false) goto L18;
        if (isConfigurationParamsValid(getConfigurationParams(), getIsSigned()) == false) goto L18;
        return true;
    L13:
        r102 = false;
        goto L14
    L10:
        r101 = null;
        goto L11
    }

    public final CJPayFaceVerifyInfo parseJSON(JSONObject r100) {
        if (r100 == null) goto L23;
        String r101 = r100.optString("verify_type");
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        this.verify_type = r101;
        String r103 = r100.optString("face_content");
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        this.face_content = r103;
        String r104 = r100.optString("agreement_url");
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        this.agreement_url = r104;
        String r105 = r100.optString("agreement_desc");
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        this.agreement_desc = r105;
        String r106 = r100.optString("name_mask");
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        this.name_mask = r106;
        String r107 = r100.optString("uid");
        if (r107 == null) goto L22;
        r102 = r107;
    L22:
        this.uid = r102;
    L23:
        return this;
    }

    private final boolean isConfigurationParamsValid(String r100, boolean r101) {
        if (r100 != null) goto L39;
    L38:
        return false;
    L39:
        Boolean r102 = null;
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r103 = r100;
    L8:
        if (r103 == null) goto L38;
        if (r101 == false) goto L11;
        return true;
    L11:
        String r104 = new JSONObject(r100).optString("agreement_desc");     // Catch: Exception -> L36
        String r105 = new JSONObject(r100).optString("agreement_url");     // Catch: Exception -> L36
        if (r104 != null) goto L14;
        Boolean r106 = null;
    L19:
        if (r106 == null) goto L21;
        boolean r107 = r106.booleanValue();     // Catch: Exception -> L36
    L22:
        if (r107 == false) goto L41;
        if (r105 != null) goto L25;
    L29:
        if (r102 == null) goto L32;
        boolean r108 = r102.booleanValue();     // Catch: Exception -> L36
    L33:
        if (r108 == false) goto L42;
        return true;
    L42:
        return false;
    L32:
        r108 = false;
        goto L33
    L25:
        if (StringsKt.isBlank(r105) == true) goto L27;
        boolean r109 = true;
    L28:
        r102 = Boolean.valueOf(r109);     // Catch: Exception -> L36
        goto L29
    L27:
        r109 = false;
        goto L28
    L41:
        return false;
    L21:
        r107 = false;
        goto L22
    L14:
        if (StringsKt.isBlank(r104) == true) goto L16;
        boolean r110 = true;
    L17:
        r106 = Boolean.valueOf(r110);     // Catch: Exception -> L36
        goto L19
    L16:
        r110 = false;
        goto L17
    L7:
        r103 = null;
    L36:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceVerifyInfo#isConfigurationParamsValid", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceVerifyInfo#isConfigurationParamsValid", e);
        goto L38
    }

    public final CJPayFaceVerifyInfo setNameAndUId(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.name_mask = r100;
        this.uid = r101;
        return this;
    }

    public CJPayFaceVerifyInfo(String r110, String r111, String r112, String r210, String r211, String r212, String r213, boolean r214, String r215, String r216, String r217, String r218, boolean r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318) {
        Intrinsics.checkNotNullParameter(r110, "verify_type");
        Intrinsics.checkNotNullParameter(r111, "face_content");
        Intrinsics.checkNotNullParameter(r112, "agreement_url");
        Intrinsics.checkNotNullParameter(r210, "agreement_desc");
        Intrinsics.checkNotNullParameter(r211, "name_mask");
        Intrinsics.checkNotNullParameter(r212, "uid");
        Intrinsics.checkNotNullParameter(r213, DyVerifyReqConstants.Key.SMCH_ID);
        Intrinsics.checkNotNullParameter(r215, BytedCertConstant.CertKey.VERIFY_CHANNEL);
        Intrinsics.checkNotNullParameter(r216, "show_style");
        Intrinsics.checkNotNullParameter(r217, "button_desc");
        Intrinsics.checkNotNullParameter(r218, "face_scene");
        Intrinsics.checkNotNullParameter(r310, "merchant_app_id");
        Intrinsics.checkNotNullParameter(r311, "merchant_id");
        Intrinsics.checkNotNullParameter(r312, "face_pay_scene");
        Intrinsics.checkNotNullParameter(r313, "title");
        Intrinsics.checkNotNullParameter(r314, "icon_url");
        Intrinsics.checkNotNullParameter(r315, "verify_params");
        Intrinsics.checkNotNullParameter(r316, "std_verify_tag");
        Intrinsics.checkNotNullParameter(r317, "verify_id");
        Intrinsics.checkNotNullParameter(r318, "verify_token");
        this.verify_type = r110;
        this.face_content = r111;
        this.agreement_url = r112;
        this.agreement_desc = r210;
        this.name_mask = r211;
        this.uid = r212;
        this.smch_id = r213;
        this.need_live_detection = r214;
        this.verify_channel = r215;
        this.show_style = r216;
        this.button_desc = r217;
        this.face_scene = r218;
        this.skip_check_agreement = r219;
        this.merchant_app_id = r310;
        this.merchant_id = r311;
        this.face_pay_scene = r312;
        this.title = r313;
        this.icon_url = r314;
        this.verify_params = r315;
        this.std_verify_tag = r316;
        this.verify_id = r317;
        this.verify_token = r318;
    }

    public /* synthetic */ CJPayFaceVerifyInfo(String r210, String r211, String r212, String r213, String r214, String r215, String r310, boolean r311, String r312, String r313, String r314, String r315, boolean r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, int r416, DefaultConstructorMarker r417) {
        if ((r416 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r416 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r416 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r416 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r416 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r416 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r106 = "";
    L30:
        boolean r110 = false;
        if ((r416 & 128) == 0) goto L33;
        boolean r107 = false;
    L35:
        if ((r416 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r416 & 512) == 0) goto L41;
        String r112 = "0";
    L43:
        if ((r416 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r416 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r416 & 4096) != 0) goto L55;
        r110 = r316;
    L55:
        if ((r416 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r416 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r416 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r416 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r416 & 131072) == 0) goto L73;
        String r118 = "";
    L75:
        if ((r416 & 262144) == 0) goto L77;
        String r119 = "";
    L79:
        if ((r416 & 524288) == 0) goto L81;
        String r216 = "";
    L83:
        if ((r416 & 1048576) == 0) goto L85;
        String r217 = "";
    L87:
        if ((r416 & 2097152) == 0) goto L89;
        String r109 = "";
    L90:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r110, r115, r108, r116, r117, r118, r119, r216, r217, r109);
        return;
    L89:
        r109 = r415;
        goto L90
    L85:
        r217 = r414;
        goto L87
    L81:
        r216 = r413;
        goto L83
    L77:
        r119 = r412;
        goto L79
    L73:
        r118 = r411;
        goto L75
    L69:
        r117 = r410;
        goto L71
    L65:
        r116 = r319;
        goto L67
    L61:
        r108 = r318;
        goto L63
    L57:
        r115 = r317;
        goto L59
    L49:
        r114 = r315;
        goto L51
    L45:
        r113 = r314;
        goto L47
    L41:
        r112 = r313;
        goto L43
    L37:
        r111 = r312;
        goto L39
    L33:
        r107 = r311;
        goto L35
    L29:
        r106 = r310;
        goto L30
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
