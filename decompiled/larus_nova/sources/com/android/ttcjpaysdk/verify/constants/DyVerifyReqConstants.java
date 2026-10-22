package com.android.ttcjpaysdk.verify.constants;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyReqConstants;", "", "()V", "BioFailMsg", "Key", "Method", "Value", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyReqConstants {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyReqConstants$BioFailMsg;", "", "()V", "DEVICE_NOT_ENABLE", "", "DEVICE_NOT_OPEN", "DEVICE_NOT_SUPPORT", "ERROR_ASYNC_TOKEN_EMPTY_MSG", BioFailMsg.ERROR_BIO_ID_CHANGE, BioFailMsg.ERROR_BIO_ID_EMPTY, BioFailMsg.OVER_LIMIT_OR_ELSE, "REQUEST_RETURN_ERROR", "REQUEST_RETURN_FAIL", "SYSTEM_VERSION_NOT_SUPPORT", "UNKNOWN_ERROR", "USER_CANCEL", "USER_CHOOSE_PASSWORD", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BioFailMsg {
        public static final String DEVICE_NOT_ENABLE = "设备当前不能验证指纹（未开通指纹或者卸载重装本地没有token）";
        public static final String DEVICE_NOT_OPEN = "该设备未开通指纹";
        public static final String DEVICE_NOT_SUPPORT = "设备不支持指纹或者未录入指纹";
        public static final String ERROR_ASYNC_TOKEN_EMPTY_MSG = "ERROR_ASYNC_TOKEN_EMPTY";
        public static final String ERROR_BIO_ID_CHANGE = "ERROR_BIO_ID_CHANGE";
        public static final String ERROR_BIO_ID_EMPTY = "ERROR_BIO_ID_EMPTY";
        public static final BioFailMsg INSTANCE = null;
        public static final String OVER_LIMIT_OR_ELSE = "OVER_LIMIT_OR_ELSE";
        public static final String REQUEST_RETURN_ERROR = "OTP接口返回code非MP000000";
        public static final String REQUEST_RETURN_FAIL = "OTP接口请求异常";
        public static final String SYSTEM_VERSION_NOT_SUPPORT = "系统版本不支持指纹";
        public static final String UNKNOWN_ERROR = "未知异常";
        public static final String USER_CANCEL = "用户取消指纹验证";
        public static final String USER_CHOOSE_PASSWORD = "用户选择输入密码";

        static {
            INSTANCE = new BioFailMsg();
        }

        private BioFailMsg() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyReqConstants$Key;", "", "()V", "ENC_PARAMS", "", "MEMBER_BIZ_ORDER_NO", "PASSWORD", "RISK_INFO", "SECURE_REQUEST_PARAMS", "SMCH_ID", CancelRetainContactInfoFunctions.SMS, "TIMESTAMP", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Key {
        public static final String ENC_PARAMS = "enc_params";
        public static final Key INSTANCE = null;
        public static final String MEMBER_BIZ_ORDER_NO = "member_biz_order_no";
        public static final String PASSWORD = "password";
        public static final String RISK_INFO = "risk_info";
        public static final String SECURE_REQUEST_PARAMS = "secure_request_params";
        public static final String SMCH_ID = "smch_id";
        public static final String SMS = "sms";
        public static final String TIMESTAMP = "timestamp";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyReqConstants$Method;", "", "()V", "ACQUIRE_SMS", "", "GENPARTCSR", "GETERT", "GETSIGNFACTOR", "INITIALCSR", "INVALIDCERT", "QUERYCERT", "QUERY_BIO_STATUS", "VERIFY_OTP", "VERIFY_PASSWORD", "VERIFY_SMS", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Method {
        public static final String ACQUIRE_SMS = "bytepay.member_product.send_sms";
        public static final String GENPARTCSR = "bytepay.member_verify.gen_part_csr";
        public static final String GETERT = "bytepay.member_verify.get_cert";
        public static final String GETSIGNFACTOR = "bytepay.member_verify.get_sign_factor";
        public static final String INITIALCSR = "bytepay.member_verify.initial_csr";
        public static final Method INSTANCE = null;
        public static final String INVALIDCERT = "bytepay.member_verify.invalid_cert";
        public static final String QUERYCERT = "bytepay.member_verify.query_cert";
        public static final String QUERY_BIO_STATUS = "bytepay.member_product.query_biometrics_pay_status";
        public static final String VERIFY_OTP = "bytepay.member_product.verify_o_t_p";
        public static final String VERIFY_PASSWORD = "bytepay.member_product.verify_password";
        public static final String VERIFY_SMS = "bytepay.member_product.verify_sms";

        static {
            INSTANCE = new Method();
        }

        private Method() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyReqConstants$Value;", "", "()V", "CERT_BOTTOM_BTN_CANCEL_ACTION", "", "CERT_BOTTOM_BTN_CHANGE_ACTION", "DIAMOND", "VERIFY_SDK", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Value {
        public static final String CERT_BOTTOM_BTN_CANCEL_ACTION = "cancel";
        public static final String CERT_BOTTOM_BTN_CHANGE_ACTION = "change";
        public static final String DIAMOND = "diamond";
        public static final Value INSTANCE = null;
        public static final String VERIFY_SDK = "核身SDK";

        static {
            INSTANCE = new Value();
        }

        private Value() {
        }
    }

    public DyVerifyReqConstants() {
    }
}
