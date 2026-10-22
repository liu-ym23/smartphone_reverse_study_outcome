package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 H2\u00020\u0001:\u0001HJA\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\bH&J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0014H&JÙ\u0001\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\bH&J\u001c\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0016H&J&\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010.H&J\u001c\u0010/\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0016H&J&\u0010/\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010.H&J\u0012\u00100\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0005H&J.\u00101\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00112\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f032\u0006\u0010\u0006\u001a\u000204H&J\"\u00105\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\u0016H&J\u001c\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010<\u001a\u00020\u0003H&J0\u0010=\u001a\u00020\u00032&\u0010>\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010?j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`@H&J\u0012\u0010A\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0016H&J0\u0010B\u001a\u00020\u00032&\u0010C\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010?j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`@H&J2\u0010D\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u00010\u00162\u0006\u0010E\u001a\u00020\u000f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u000fH&¨\u0006I"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "callCameraPermission", "", "ctx", "Landroid/app/Activity;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "granted", "showFailToast", "cameraPermissionAvailable", "Landroid/util/Pair;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dismissDialog", "getClientSource", "", "getFaceVerifyParams", "Lorg/json/JSONObject;", "orderId", "clientSource", "serverSource", "liveRoute", "hostInfo", "isShowDialog", "showStyle", "newStyleButtonDesc", "uid", "faceScene", "logSource", "skipCheckAgreement", "title", "iconUrl", "isSigned", "enterFrom", "configurationParams", "extParams", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "getIsSigned", "gotoCheckFace", "activity", "params", "Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback;", "gotoCheckFaceAgain", "gotoCheckFaceByCache", "invokeFace", "initMap", "", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive$TTCJPayFaceLiveCallback;", "logFaceResultEvent", "type", "jsonObject", "logFullPageRequest", "status", "failReason", "preLoadFaceVerifyResource", "release", "setBusinessParams", "paramMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setCounterCommonParams", "setLogParams", "logParamMap", "uploadFaceVideo", "from", "noLoginTicket", "aid", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayFaceCheckService extends ICJPayService {
    public static final Companion Companion = null;
    public static final String DY_VERIFY_INVOKE_FACE_VERIFY_ID = "dy_verify_invoke_face_verify_id";
    public static final String ENTER_FROM_FACE_VERIFY_BULLET = "enter_from_face_verify_bullet";
    public static final String ENTER_FROM_FACE_VERIFY_H5 = "enter_from_face_verify_h5";
    public static final String ENTER_FROM_FACE_VERIFY_NATIVE = "enter_from_face_verify_native";
    public static final String KEY_CLIENT_SOURCE = "clientSource";
    public static final String KEY_CONFIGURATION_PARAMS = "configurationParams";
    public static final String KEY_ENTER_FROM = "enterFrom";
    public static final String KEY_EXT_PARAMS = "extParams";
    public static final String KEY_FACE_SCENE = "faceScene";
    public static final String KEY_HOST_INFO = "hostInfo";
    public static final String KEY_ICON_URL = "iconUrl";
    public static final String KEY_IS_SHOW_DIALOG = "isShowDialog";
    public static final String KEY_IS_SIGNED = "isSigned";
    public static final String KEY_IS_SKIP_BASIC_VERIFY = "isSkipBasicVerify";
    public static final String KEY_LIVE_ROUTE = "liveRoute";
    public static final String KEY_LOG_SOURCE = "logSource";
    public static final String KEY_ORDER_ID = "orderId";
    public static final String KEY_SCENE = "scene";
    public static final String KEY_SERVER_SOURCE = "serverSource";
    public static final String KEY_SHOW_DIALOG_BUTTON_DESC = "buttonDesc";
    public static final String KEY_SHOW_DIALOG_STYLE = "showStyle";
    public static final String KEY_SKIP_CHECK_AGREEMENT = "skipCheckAgreement";
    public static final String KEY_TITLE = "title";
    public static final String KEY_UID = "uid";
    public static final String LOG_SOURCE_DEFAULT_FACE_VERIFY = "默认核验-刷脸支付";
    public static final String LOG_SOURCE_DIRECT_VERIFY = "直连银行";
    public static final String LOG_SOURCE_FAST_PAY = "极速付-加验";
    public static final String LOG_SOURCE_FINGERPRINT_ADD_VERIFY = "指纹-加验";
    public static final String LOG_SOURCE_FORGET_PASSWORD = "忘记密码/重置密码";
    public static final String LOG_SOURCE_IN_PAY_FACE_VERIFY_NOT_WRONG = "未输错密码-刷脸支付";
    public static final String LOG_SOURCE_IN_PAY_FACE_VERIFY_WRONG = "输错密码-刷脸支付";
    public static final String LOG_SOURCE_LARGEAMOUNT_ADD_VERIFY = "大额支付";
    public static final String LOG_SOURCE_NOPWD_ADD_VERIFY = "免密-加验";
    public static final String LOG_SOURCE_NORMAL_BIND_CARD = "普通绑卡";
    public static final String LOG_SOURCE_NOTHING_ADD_VERIFY = "免验证-加验";
    public static final String LOG_SOURCE_ONE_KEY_BIND_CARD = "一键绑卡";
    public static final String LOG_SOURCE_PASSWORD_ADD_VERIFY = "密码-加验";
    public static final String LOG_SOURCE_PASSWORD_CVV_VERIFY = "CVV-加验";
    public static final String LOG_SOURCE_PASSWORD_KEEP_DIALOG = "密码页挽留弹窗";
    public static final String LOG_SOURCE_PAY_NEW_CARD = "绑卡并支付-加验";
    public static final String LOG_SOURCE_PWD_ERROR_FACE_PAY = "修改密码并支付";
    public static final String LOG_SOURCE_PWD_FORGET_PWD_FACE_PAY = "忘记密码-刷脸支付";
    public static final String LOG_SOURCE_PWD_FORGET_PWD_SMS_PAY = "忘记密码-短信支付";
    public static final String LOG_SOURCE_PWD_PWD_ERROR_FACE_PAY = "密码未锁定-刷脸支付";
    public static final String LOG_SOURCE_PWD_PWD_ERROR_SMS_PAY = "密码未锁定-短信支付";
    public static final String LOG_SOURCE_PWD_PWD_LOCK_FACE_PAY = "密码锁定-刷脸支付";
    public static final String LOG_SOURCE_PWD_PWD_LOCK_SMS_PAY = "密码锁定-短信支付";
    public static final String LOG_SOURCE_PWD_RESET_PWD_FACE_PAY = "修改密码并支付";
    public static final String LOG_SOURCE_PWD_RETAIN_FACE_PAY = "挽留弹窗-刷脸支付";
    public static final String LOG_SOURCE_PWD_RETAIN_SMS_PAY = "挽留弹窗-短信支付";
    public static final String LOG_SOURCE_PWD_SET_PWD_FACE_PAY = "设置密码并支付";
    public static final String LOG_SOURCE_PWD_TOP_RIGHT_FACE_PAY = "右上角-刷脸支付";
    public static final String LOG_SOURCE_PWD_TOP_RIGHT_SMS_PAY = "右上角-短信支付";
    public static final String LOG_SOURCE_SIGN_VERIFY = "补签约-加验";
    public static final String LOG_SOURCE_TRANSFER_ADD_VERIFY = "对公转账";
    public static final String LOG_SOURCE_UNION_PAY = "云闪付绑卡";
    public static final String NOT_NOTIFY_BACK_TO_PAY_HOME_EVENT = "not_notify_back_to_pay_home_event";
    public static final String RESPONSE_OK = "MP000000";
    public static final int SOURCE_BULLET = 1003;
    public static final String SOURCE_CARD_SIGN = "card_sign";
    public static final String SOURCE_CASHDESK_PAY = "cashdesk_pay";
    public static final String SOURCE_DIRECT_BANK_PAY = "direct_bank_pay";
    public static final String SOURCE_ENABLE_BIOMETRICS_PAY = "enable_biometrics_pay";
    public static final int SOURCE_H5 = 4000;
    public static final String SOURCE_LARGEAMOUNT_PAY = "transfer_pay";
    public static final int SOURCE_NORMAL_BIND_CARD = 1008;
    public static final String SOURCE_ONE_KEY_SIGN = "one_key_sign";
    public static final int SOURCE_OPEN_FINGERPRINT_IN_PAYMENT_MANAGER = 1009;
    public static final int SOURCE_PAY_BIND_CARD = 1001;
    public static final int SOURCE_PAY_PWD_WRONG_VERIFY = 1004;
    public static final int SOURCE_PAY_PWD_WRONG_VERIFY_FROM_PAY_AGAIN = 2004;
    public static final int SOURCE_PAY_VERIFY = 1000;
    public static final int SOURCE_PAY_VERIFY_FROM_PAYMENT_METHOD_PAGE = 3000;
    public static final int SOURCE_PAY_VERIFY_FROM_PAY_AGAIN = 2000;
    public static final String SOURCE_RESET_PWD = "reset_pay_password";
    public static final int SOURCE_SET_PAY_VERIFY = 5000;
    public static final int SOURCE_SET_PAY_VERIFY_FROM_PAY_AGAIN = 6000;
    public static final int SOURCE_UNION_PAY_BIND_CARD = 1005;
    public static final int SOURCE_UNION_PAY_BIND_CARD_Front_Page = 1010;
    public static final int SOURCE_UNION_PAY_COUNTER = 1006;
    public static final int SOURCE_UNION_PAY_TWO_AUTH = 1007;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\bC\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR-\u0010\f\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR-\u0010\u000e\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020KX\u0086T¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckService$Companion;", "", "()V", "CJ_FACE_CAMERA_PERMISSION_DENIED_UNKNOWN", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "", "getCJ_FACE_CAMERA_PERMISSION_DENIED_UNKNOWN", "()Landroid/util/Pair;", "CJ_FACE_CAMERA_PERMISSION_EVER_REFUSED", "getCJ_FACE_CAMERA_PERMISSION_EVER_REFUSED", "CJ_FACE_CAMERA_PERMISSION_FIRST_REQUEST_OR_PERMANENT_REFUSED", "getCJ_FACE_CAMERA_PERMISSION_FIRST_REQUEST_OR_PERMANENT_REFUSED", "CJ_FACE_CAMERA_PERMISSION_GRANTED", "getCJ_FACE_CAMERA_PERMISSION_GRANTED", "DY_VERIFY_INVOKE_FACE_VERIFY_ID", "ENTER_FROM_FACE_VERIFY_BULLET", "ENTER_FROM_FACE_VERIFY_H5", "ENTER_FROM_FACE_VERIFY_NATIVE", "KEY_CLIENT_SOURCE", "KEY_CONFIGURATION_PARAMS", "KEY_ENTER_FROM", "KEY_EXT_PARAMS", "KEY_FACE_SCENE", "KEY_HOST_INFO", "KEY_ICON_URL", "KEY_IS_SHOW_DIALOG", "KEY_IS_SIGNED", "KEY_IS_SKIP_BASIC_VERIFY", "KEY_LIVE_ROUTE", "KEY_LOG_SOURCE", "KEY_ORDER_ID", "KEY_SCENE", "KEY_SERVER_SOURCE", "KEY_SHOW_DIALOG_BUTTON_DESC", "KEY_SHOW_DIALOG_STYLE", "KEY_SKIP_CHECK_AGREEMENT", "KEY_TITLE", "KEY_UID", "LOG_SOURCE_DEFAULT_FACE_VERIFY", "LOG_SOURCE_DIRECT_VERIFY", "LOG_SOURCE_FAST_PAY", "LOG_SOURCE_FINGERPRINT_ADD_VERIFY", "LOG_SOURCE_FORGET_PASSWORD", "LOG_SOURCE_IN_PAY_FACE_VERIFY_NOT_WRONG", "LOG_SOURCE_IN_PAY_FACE_VERIFY_WRONG", "LOG_SOURCE_LARGEAMOUNT_ADD_VERIFY", "LOG_SOURCE_NOPWD_ADD_VERIFY", "LOG_SOURCE_NORMAL_BIND_CARD", "LOG_SOURCE_NOTHING_ADD_VERIFY", "LOG_SOURCE_ONE_KEY_BIND_CARD", "LOG_SOURCE_PASSWORD_ADD_VERIFY", "LOG_SOURCE_PASSWORD_CVV_VERIFY", "LOG_SOURCE_PASSWORD_KEEP_DIALOG", "LOG_SOURCE_PAY_NEW_CARD", "LOG_SOURCE_PWD_ERROR_FACE_PAY", "LOG_SOURCE_PWD_FORGET_PWD_FACE_PAY", "LOG_SOURCE_PWD_FORGET_PWD_SMS_PAY", "LOG_SOURCE_PWD_PWD_ERROR_FACE_PAY", "LOG_SOURCE_PWD_PWD_ERROR_SMS_PAY", "LOG_SOURCE_PWD_PWD_LOCK_FACE_PAY", "LOG_SOURCE_PWD_PWD_LOCK_SMS_PAY", "LOG_SOURCE_PWD_RESET_PWD_FACE_PAY", "LOG_SOURCE_PWD_RETAIN_FACE_PAY", "LOG_SOURCE_PWD_RETAIN_SMS_PAY", "LOG_SOURCE_PWD_SET_PWD_FACE_PAY", "LOG_SOURCE_PWD_TOP_RIGHT_FACE_PAY", "LOG_SOURCE_PWD_TOP_RIGHT_SMS_PAY", "LOG_SOURCE_SIGN_VERIFY", "LOG_SOURCE_TRANSFER_ADD_VERIFY", "LOG_SOURCE_UNION_PAY", "NOT_NOTIFY_BACK_TO_PAY_HOME_EVENT", "RESPONSE_OK", "SOURCE_BULLET", "", "SOURCE_CARD_SIGN", "SOURCE_CASHDESK_PAY", "SOURCE_DIRECT_BANK_PAY", "SOURCE_ENABLE_BIOMETRICS_PAY", "SOURCE_H5", "SOURCE_LARGEAMOUNT_PAY", "SOURCE_NORMAL_BIND_CARD", "SOURCE_ONE_KEY_SIGN", "SOURCE_OPEN_FINGERPRINT_IN_PAYMENT_MANAGER", "SOURCE_PAY_BIND_CARD", "SOURCE_PAY_PWD_WRONG_VERIFY", "SOURCE_PAY_PWD_WRONG_VERIFY_FROM_PAY_AGAIN", "SOURCE_PAY_VERIFY", "SOURCE_PAY_VERIFY_FROM_PAYMENT_METHOD_PAGE", "SOURCE_PAY_VERIFY_FROM_PAY_AGAIN", "SOURCE_RESET_PWD", "SOURCE_SET_PAY_VERIFY", "SOURCE_SET_PAY_VERIFY_FROM_PAY_AGAIN", "SOURCE_UNION_PAY_BIND_CARD", "SOURCE_UNION_PAY_BIND_CARD_Front_Page", "SOURCE_UNION_PAY_COUNTER", "SOURCE_UNION_PAY_TWO_AUTH", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Pair<Boolean, String> CJ_FACE_CAMERA_PERMISSION_DENIED_UNKNOWN = null;
        private static final Pair<Boolean, String> CJ_FACE_CAMERA_PERMISSION_EVER_REFUSED = null;
        private static final Pair<Boolean, String> CJ_FACE_CAMERA_PERMISSION_FIRST_REQUEST_OR_PERMANENT_REFUSED = null;
        private static final Pair<Boolean, String> CJ_FACE_CAMERA_PERMISSION_GRANTED = null;
        public static final String DY_VERIFY_INVOKE_FACE_VERIFY_ID = "dy_verify_invoke_face_verify_id";
        public static final String ENTER_FROM_FACE_VERIFY_BULLET = "enter_from_face_verify_bullet";
        public static final String ENTER_FROM_FACE_VERIFY_H5 = "enter_from_face_verify_h5";
        public static final String ENTER_FROM_FACE_VERIFY_NATIVE = "enter_from_face_verify_native";
        public static final String KEY_CLIENT_SOURCE = "clientSource";
        public static final String KEY_CONFIGURATION_PARAMS = "configurationParams";
        public static final String KEY_ENTER_FROM = "enterFrom";
        public static final String KEY_EXT_PARAMS = "extParams";
        public static final String KEY_FACE_SCENE = "faceScene";
        public static final String KEY_HOST_INFO = "hostInfo";
        public static final String KEY_ICON_URL = "iconUrl";
        public static final String KEY_IS_SHOW_DIALOG = "isShowDialog";
        public static final String KEY_IS_SIGNED = "isSigned";
        public static final String KEY_IS_SKIP_BASIC_VERIFY = "isSkipBasicVerify";
        public static final String KEY_LIVE_ROUTE = "liveRoute";
        public static final String KEY_LOG_SOURCE = "logSource";
        public static final String KEY_ORDER_ID = "orderId";
        public static final String KEY_SCENE = "scene";
        public static final String KEY_SERVER_SOURCE = "serverSource";
        public static final String KEY_SHOW_DIALOG_BUTTON_DESC = "buttonDesc";
        public static final String KEY_SHOW_DIALOG_STYLE = "showStyle";
        public static final String KEY_SKIP_CHECK_AGREEMENT = "skipCheckAgreement";
        public static final String KEY_TITLE = "title";
        public static final String KEY_UID = "uid";
        public static final String LOG_SOURCE_DEFAULT_FACE_VERIFY = "默认核验-刷脸支付";
        public static final String LOG_SOURCE_DIRECT_VERIFY = "直连银行";
        public static final String LOG_SOURCE_FAST_PAY = "极速付-加验";
        public static final String LOG_SOURCE_FINGERPRINT_ADD_VERIFY = "指纹-加验";
        public static final String LOG_SOURCE_FORGET_PASSWORD = "忘记密码/重置密码";
        public static final String LOG_SOURCE_IN_PAY_FACE_VERIFY_NOT_WRONG = "未输错密码-刷脸支付";
        public static final String LOG_SOURCE_IN_PAY_FACE_VERIFY_WRONG = "输错密码-刷脸支付";
        public static final String LOG_SOURCE_LARGEAMOUNT_ADD_VERIFY = "大额支付";
        public static final String LOG_SOURCE_NOPWD_ADD_VERIFY = "免密-加验";
        public static final String LOG_SOURCE_NORMAL_BIND_CARD = "普通绑卡";
        public static final String LOG_SOURCE_NOTHING_ADD_VERIFY = "免验证-加验";
        public static final String LOG_SOURCE_ONE_KEY_BIND_CARD = "一键绑卡";
        public static final String LOG_SOURCE_PASSWORD_ADD_VERIFY = "密码-加验";
        public static final String LOG_SOURCE_PASSWORD_CVV_VERIFY = "CVV-加验";
        public static final String LOG_SOURCE_PASSWORD_KEEP_DIALOG = "密码页挽留弹窗";
        public static final String LOG_SOURCE_PAY_NEW_CARD = "绑卡并支付-加验";
        public static final String LOG_SOURCE_PWD_ERROR_FACE_PAY = "修改密码并支付";
        public static final String LOG_SOURCE_PWD_FORGET_PWD_FACE_PAY = "忘记密码-刷脸支付";
        public static final String LOG_SOURCE_PWD_FORGET_PWD_SMS_PAY = "忘记密码-短信支付";
        public static final String LOG_SOURCE_PWD_PWD_ERROR_FACE_PAY = "密码未锁定-刷脸支付";
        public static final String LOG_SOURCE_PWD_PWD_ERROR_SMS_PAY = "密码未锁定-短信支付";
        public static final String LOG_SOURCE_PWD_PWD_LOCK_FACE_PAY = "密码锁定-刷脸支付";
        public static final String LOG_SOURCE_PWD_PWD_LOCK_SMS_PAY = "密码锁定-短信支付";
        public static final String LOG_SOURCE_PWD_RESET_PWD_FACE_PAY = "修改密码并支付";
        public static final String LOG_SOURCE_PWD_RETAIN_FACE_PAY = "挽留弹窗-刷脸支付";
        public static final String LOG_SOURCE_PWD_RETAIN_SMS_PAY = "挽留弹窗-短信支付";
        public static final String LOG_SOURCE_PWD_SET_PWD_FACE_PAY = "设置密码并支付";
        public static final String LOG_SOURCE_PWD_TOP_RIGHT_FACE_PAY = "右上角-刷脸支付";
        public static final String LOG_SOURCE_PWD_TOP_RIGHT_SMS_PAY = "右上角-短信支付";
        public static final String LOG_SOURCE_SIGN_VERIFY = "补签约-加验";
        public static final String LOG_SOURCE_TRANSFER_ADD_VERIFY = "对公转账";
        public static final String LOG_SOURCE_UNION_PAY = "云闪付绑卡";
        public static final String NOT_NOTIFY_BACK_TO_PAY_HOME_EVENT = "not_notify_back_to_pay_home_event";
        public static final String RESPONSE_OK = "MP000000";
        public static final int SOURCE_BULLET = 1003;
        public static final String SOURCE_CARD_SIGN = "card_sign";
        public static final String SOURCE_CASHDESK_PAY = "cashdesk_pay";
        public static final String SOURCE_DIRECT_BANK_PAY = "direct_bank_pay";
        public static final String SOURCE_ENABLE_BIOMETRICS_PAY = "enable_biometrics_pay";
        public static final int SOURCE_H5 = 4000;
        public static final String SOURCE_LARGEAMOUNT_PAY = "transfer_pay";
        public static final int SOURCE_NORMAL_BIND_CARD = 1008;
        public static final String SOURCE_ONE_KEY_SIGN = "one_key_sign";
        public static final int SOURCE_OPEN_FINGERPRINT_IN_PAYMENT_MANAGER = 1009;
        public static final int SOURCE_PAY_BIND_CARD = 1001;
        public static final int SOURCE_PAY_PWD_WRONG_VERIFY = 1004;
        public static final int SOURCE_PAY_PWD_WRONG_VERIFY_FROM_PAY_AGAIN = 2004;
        public static final int SOURCE_PAY_VERIFY = 1000;
        public static final int SOURCE_PAY_VERIFY_FROM_PAYMENT_METHOD_PAGE = 3000;
        public static final int SOURCE_PAY_VERIFY_FROM_PAY_AGAIN = 2000;
        public static final String SOURCE_RESET_PWD = "reset_pay_password";
        public static final int SOURCE_SET_PAY_VERIFY = 5000;
        public static final int SOURCE_SET_PAY_VERIFY_FROM_PAY_AGAIN = 6000;
        public static final int SOURCE_UNION_PAY_BIND_CARD = 1005;
        public static final int SOURCE_UNION_PAY_BIND_CARD_Front_Page = 1010;
        public static final int SOURCE_UNION_PAY_COUNTER = 1006;
        public static final int SOURCE_UNION_PAY_TWO_AUTH = 1007;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            CJ_FACE_CAMERA_PERMISSION_GRANTED = new Pair(Boolean.TRUE, "已有权限");
            Boolean r100 = Boolean.FALSE;
            CJ_FACE_CAMERA_PERMISSION_EVER_REFUSED = new Pair(r100, "拒绝过且未勾选不再询问");
            CJ_FACE_CAMERA_PERMISSION_FIRST_REQUEST_OR_PERMANENT_REFUSED = new Pair(r100, "首次请求或拒绝过且勾选不再询问");
            CJ_FACE_CAMERA_PERMISSION_DENIED_UNKNOWN = new Pair(r100, "未知原因");
        }

        public final Pair<Boolean, String> getCJ_FACE_CAMERA_PERMISSION_DENIED_UNKNOWN() {
            return CJ_FACE_CAMERA_PERMISSION_DENIED_UNKNOWN;
        }

        public final Pair<Boolean, String> getCJ_FACE_CAMERA_PERMISSION_EVER_REFUSED() {
            return CJ_FACE_CAMERA_PERMISSION_EVER_REFUSED;
        }

        public final Pair<Boolean, String> getCJ_FACE_CAMERA_PERMISSION_FIRST_REQUEST_OR_PERMANENT_REFUSED() {
            return CJ_FACE_CAMERA_PERMISSION_FIRST_REQUEST_OR_PERMANENT_REFUSED;
        }

        public final Pair<Boolean, String> getCJ_FACE_CAMERA_PERMISSION_GRANTED() {
            return CJ_FACE_CAMERA_PERMISSION_GRANTED;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void logFullPageRequest$default(ICJPayFaceCheckService r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.logFullPageRequest(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logFullPageRequest");
        }

        public static /* synthetic */ void callCameraPermission$default(ICJPayFaceCheckService r100, Activity r101, Function1 r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            r100.callCameraPermission(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callCameraPermission");
        }

        public static /* synthetic */ void uploadFaceVideo$default(ICJPayFaceCheckService r100, JSONObject r101, String r102, String r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L12;
            if ((r105 & 4) == 0) goto L7;
            r103 = null;
        L7:
            if ((r105 & 8) == 0) goto L9;
            r104 = null;
        L9:
            r100.uploadFaceVideo(r101, r102, r103, r104);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFaceVideo");
        }

        public static /* synthetic */ JSONObject getFaceVerifyParams$default(ICJPayFaceCheckService r210, String r211, Integer r212, String r213, String r214, JSONObject r215, Boolean r216, String r217, String r310, String r311, String r312, String r313, Boolean r314, String r315, String r316, Boolean r317, String r318, String r319, String r410, int r411, Object r412) {
            if (r412 != null) goto L55;
            if ((r411 & 64) == 0) goto L7;
            String r110 = "";
        L9:
            if ((r411 & 128) == 0) goto L11;
            String r111 = "";
        L13:
            if ((r411 & 256) == 0) goto L15;
            String r112 = "";
        L17:
            if ((r411 & 512) == 0) goto L19;
            String r113 = "";
        L21:
            if ((r411 & 1024) == 0) goto L23;
            String r114 = "";
        L25:
            if ((r411 & 2048) == 0) goto L27;
            Boolean r115 = Boolean.FALSE;
        L29:
            if ((r411 & 4096) == 0) goto L31;
            String r116 = "";
        L33:
            if ((r411 & 8192) == 0) goto L35;
            String r117 = "";
        L37:
            if ((r411 & 16384) == 0) goto L39;
            Boolean r118 = Boolean.FALSE;
        L41:
            if ((32768 & r411) == 0) goto L43;
            String r119 = "";
        L45:
            if ((65536 & r411) == 0) goto L47;
            String r218 = "";
        L49:
            if ((r411 & 131072) == 0) goto L51;
            String r219 = "";
        L53:
            return r210.getFaceVerifyParams(r211, r212, r213, r214, r215, r216, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r218, r219);
        L51:
            r219 = r410;
            goto L53
        L47:
            r218 = r319;
            goto L49
        L43:
            r119 = r318;
            goto L45
        L39:
            r118 = r317;
            goto L41
        L35:
            r117 = r316;
            goto L37
        L31:
            r116 = r315;
            goto L33
        L27:
            r115 = r314;
            goto L29
        L23:
            r114 = r313;
            goto L25
        L19:
            r113 = r312;
            goto L21
        L15:
            r112 = r311;
            goto L17
        L11:
            r111 = r310;
            goto L13
        L7:
            r110 = r217;
            goto L9
        L55:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFaceVerifyParams");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void callCameraPermission(Activity r100, Function1<? super Boolean, Unit> r101, boolean r102);

    Pair<Boolean, String> cameraPermissionAvailable(Context r100);

    void dismissDialog();

    int getClientSource();

    JSONObject getFaceVerifyParams(String r100, Integer r101, String r102, String r103, JSONObject r104, Boolean r105, String r106, String r107, String r108, String r110, String r111, Boolean r112, String r113, String r114, Boolean r115, String r116, String r117, String r118);

    boolean getIsSigned();

    void gotoCheckFace(Activity r100, JSONObject r101);

    void gotoCheckFace(Activity r100, JSONObject r101, ICJPayFaceCheckCallback r102);

    void gotoCheckFaceAgain(Activity r100, JSONObject r101);

    void gotoCheckFaceAgain(Activity r100, JSONObject r101, ICJPayFaceCheckCallback r102);

    void gotoCheckFaceByCache(Activity r100);

    void invokeFace(Context r100, Map<String, String> r101, TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r102);

    void logFaceResultEvent(Context r100, String r101, JSONObject r102);

    void logFullPageRequest(String r100, String r101);

    void preLoadFaceVerifyResource(Context r100);

    void release();

    void setBusinessParams(HashMap<String, String> r100);

    void setCounterCommonParams(JSONObject r100);

    void setLogParams(HashMap<String, String> r100);

    void uploadFaceVideo(JSONObject r100, String r101, String r102, String r103);
}
