package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b*\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00061"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/openapi/OpenApiErrorInfo;", "", "", "errorCode", "I", "getErrorCode", "()I", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", AppConstants.BUNDLE_TIP, "getTip", "NETWORK_ERROR", "INCORRECT_PARAMS", "NO_REQUEST_PERMISSION", "DATA_ALREADY_EXIST", "INVALID_ACCESS_TOKEN", "NOT_LOGIN", "EXCEED_FREQ_LIMIT", "SENSITIVE_WORD_DETECTED", "NO_SUFFICIENT_BALANCE", "ILLEGAL_APP_ID", "NET_REQUEST_PRE_VERIFY_URL_ILLEGAL", "NET_REQUEST_PRE_VERIFY_NOT_HTTPS", "NET_REQUEST_PRE_VERIFY_HOST_ILLEGAL", "NET_REQUEST_PRE_VERIFY_NON_LAN_IP", "NET_REQUEST_PRE_VERIFY_METHOD_UN_SUPPORT", "NET_REQUEST_RESPONSE_INCOMPATIBLE", "NET_REQUEST_TIMEOUT", "LOGIN_OUT_DATE", "NET_REQUEST_CONCURRENCY_EXCEED_LIMIT", "AUTHORIZE_USER_DENY", "AUTHORIZE_SYS_DENY", "INTERNAL_ERROR", "SIGNATURE_ERROR", "INVALID_URL_PARAMS", "ACCOUNT_EXCEPTION", "REWARD_REACH_LIMIT", "APP_NOT_LAUNCH", "USER_NOT_IN_ROOM", "PAY_DIAMONDS_REACH_LIMIT", "PAY_CANCEL", "DATA_NOT_EXIST", "UNKNOWN_ORDER_STATUS", "ORDER_STATUS_ERROR", "ORDER_PAID", "ORDER_EXPIRED", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenApiErrorInfo extends Enum<OpenApiErrorInfo> {
    public static final OpenApiErrorInfo ACCOUNT_EXCEPTION = null;
    public static final OpenApiErrorInfo APP_NOT_LAUNCH = null;
    public static final OpenApiErrorInfo AUTHORIZE_SYS_DENY = null;
    public static final OpenApiErrorInfo AUTHORIZE_USER_DENY = null;
    public static final OpenApiErrorInfo DATA_ALREADY_EXIST = null;
    public static final OpenApiErrorInfo DATA_NOT_EXIST = null;
    public static final OpenApiErrorInfo EXCEED_FREQ_LIMIT = null;
    public static final OpenApiErrorInfo ILLEGAL_APP_ID = null;
    public static final OpenApiErrorInfo INCORRECT_PARAMS = null;
    public static final OpenApiErrorInfo INTERNAL_ERROR = null;
    public static final OpenApiErrorInfo INVALID_ACCESS_TOKEN = null;
    public static final OpenApiErrorInfo INVALID_URL_PARAMS = null;
    public static final OpenApiErrorInfo LOGIN_OUT_DATE = null;
    public static final OpenApiErrorInfo NETWORK_ERROR = null;
    public static final OpenApiErrorInfo NET_REQUEST_CONCURRENCY_EXCEED_LIMIT = null;
    public static final OpenApiErrorInfo NET_REQUEST_PRE_VERIFY_HOST_ILLEGAL = null;
    public static final OpenApiErrorInfo NET_REQUEST_PRE_VERIFY_METHOD_UN_SUPPORT = null;
    public static final OpenApiErrorInfo NET_REQUEST_PRE_VERIFY_NON_LAN_IP = null;
    public static final OpenApiErrorInfo NET_REQUEST_PRE_VERIFY_NOT_HTTPS = null;
    public static final OpenApiErrorInfo NET_REQUEST_PRE_VERIFY_URL_ILLEGAL = null;
    public static final OpenApiErrorInfo NET_REQUEST_RESPONSE_INCOMPATIBLE = null;
    public static final OpenApiErrorInfo NET_REQUEST_TIMEOUT = null;
    public static final OpenApiErrorInfo NOT_LOGIN = null;
    public static final OpenApiErrorInfo NO_REQUEST_PERMISSION = null;
    public static final OpenApiErrorInfo NO_SUFFICIENT_BALANCE = null;
    public static final OpenApiErrorInfo ORDER_EXPIRED = null;
    public static final OpenApiErrorInfo ORDER_PAID = null;
    public static final OpenApiErrorInfo ORDER_STATUS_ERROR = null;
    public static final OpenApiErrorInfo PAY_CANCEL = null;
    public static final OpenApiErrorInfo PAY_DIAMONDS_REACH_LIMIT = null;
    public static final OpenApiErrorInfo REWARD_REACH_LIMIT = null;
    public static final OpenApiErrorInfo SENSITIVE_WORD_DETECTED = null;
    public static final OpenApiErrorInfo SIGNATURE_ERROR = null;
    public static final OpenApiErrorInfo UNKNOWN_ORDER_STATUS = null;
    public static final OpenApiErrorInfo USER_NOT_IN_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenApiErrorInfo[] f60311a = null;
    private final int errorCode;
    private final String errorMsg;
    private final String tip;

    public static OpenApiErrorInfo valueOf(String r100) {
        return (OpenApiErrorInfo) r27.a.a(OpenApiErrorInfo.class, r100);
    }

    public static OpenApiErrorInfo[] values() {
        return (OpenApiErrorInfo[]) f60311a.clone();
    }

    static {
        OpenApiErrorInfo r100 = new OpenApiErrorInfo("NETWORK_ERROR", 0, 40000, "Network Error Occur", "网络错误");
        NETWORK_ERROR = r100;
        OpenApiErrorInfo r101 = new OpenApiErrorInfo("INCORRECT_PARAMS", 1, 40001, "User Incorrect Params", "参数错误");
        INCORRECT_PARAMS = r101;
        OpenApiErrorInfo r102 = new OpenApiErrorInfo("NO_REQUEST_PERMISSION", 2, 40002, "No Request Permission", "没有调用权限");
        NO_REQUEST_PERMISSION = r102;
        OpenApiErrorInfo r103 = new OpenApiErrorInfo("DATA_ALREADY_EXIST", 3, 40003, "Data Already Exist", "数据已经存在");
        DATA_ALREADY_EXIST = r103;
        OpenApiErrorInfo r104 = new OpenApiErrorInfo("INVALID_ACCESS_TOKEN", 4, 40004, "Invalid Access Token", "accessToken不合法");
        INVALID_ACCESS_TOKEN = r104;
        OpenApiErrorInfo r105 = new OpenApiErrorInfo("NOT_LOGIN", 5, 40006, "User Doesn't Login", "用户未登录");
        NOT_LOGIN = r105;
        OpenApiErrorInfo r106 = new OpenApiErrorInfo("EXCEED_FREQ_LIMIT", 6, 40007, "Api Call Exceeds Limit Frequency", "接口调用频率过高");
        EXCEED_FREQ_LIMIT = r106;
        OpenApiErrorInfo r107 = new OpenApiErrorInfo("SENSITIVE_WORD_DETECTED", 7, 40008, "Sensitive Word Detected", "检测到敏感词");
        SENSITIVE_WORD_DETECTED = r107;
        OpenApiErrorInfo r108 = new OpenApiErrorInfo("NO_SUFFICIENT_BALANCE", 8, 40009, "User Has No Sufficient Balance", "余额不足");
        NO_SUFFICIENT_BALANCE = r108;
        OpenApiErrorInfo r109 = new OpenApiErrorInfo("ILLEGAL_APP_ID", 9, 40011, "Illegal App Id", "appId不合法");
        ILLEGAL_APP_ID = r109;
        OpenApiErrorInfo r110 = new OpenApiErrorInfo("NET_REQUEST_PRE_VERIFY_URL_ILLEGAL", 10, 40013, "Network Request Pre-Verification Failed, The URL Illegal", "URL格式错误");
        NET_REQUEST_PRE_VERIFY_URL_ILLEGAL = r110;
        OpenApiErrorInfo r111 = new OpenApiErrorInfo("NET_REQUEST_PRE_VERIFY_NOT_HTTPS", 11, 40013, "Network Request Pre-Verification Failed, Schema Not HTTPS", "不是https协议");
        NET_REQUEST_PRE_VERIFY_NOT_HTTPS = r111;
        OpenApiErrorInfo r112 = new OpenApiErrorInfo("NET_REQUEST_PRE_VERIFY_HOST_ILLEGAL", 12, 40013, "Network Request Pre-Verification Failed, Host Not In  White List", "域名不在白名单");
        NET_REQUEST_PRE_VERIFY_HOST_ILLEGAL = r112;
        OpenApiErrorInfo r113 = new OpenApiErrorInfo("NET_REQUEST_PRE_VERIFY_NON_LAN_IP", 13, 40013, "Network Request Pre-Verification Failed, Use Non-LAN Raw IP", "非本地局域网IP");
        NET_REQUEST_PRE_VERIFY_NON_LAN_IP = r113;
        OpenApiErrorInfo r114 = new OpenApiErrorInfo("NET_REQUEST_PRE_VERIFY_METHOD_UN_SUPPORT", 14, 40013, "Network Request Pre-Verification Failed, HTTP Method Not Support", "http方法不支持");
        NET_REQUEST_PRE_VERIFY_METHOD_UN_SUPPORT = r114;
        OpenApiErrorInfo r115 = new OpenApiErrorInfo("NET_REQUEST_RESPONSE_INCOMPATIBLE", 15, 40014, "Network Request Response Incompatible", "网络请求返回数据不符合要求");
        NET_REQUEST_RESPONSE_INCOMPATIBLE = r115;
        OpenApiErrorInfo r116 = new OpenApiErrorInfo("NET_REQUEST_TIMEOUT", 16, 40015, "Network Request Timeout", "网络请求超时");
        NET_REQUEST_TIMEOUT = r116;
        OpenApiErrorInfo r117 = new OpenApiErrorInfo("LOGIN_OUT_DATE", 17, 40017, "Login Out Of Date", "登陆code已过期");
        LOGIN_OUT_DATE = r117;
        OpenApiErrorInfo r118 = new OpenApiErrorInfo("NET_REQUEST_CONCURRENCY_EXCEED_LIMIT", 18, 40018, "Concurrency Network Request Exceeds Limit", "网络请求并发超过限制，最大并发数为10");
        NET_REQUEST_CONCURRENCY_EXCEED_LIMIT = r118;
        OpenApiErrorInfo r119 = new OpenApiErrorInfo("AUTHORIZE_USER_DENY", 19, 40019, "User Deny Authorization", "用户拒绝进行授权");
        AUTHORIZE_USER_DENY = r119;
        OpenApiErrorInfo r120 = new OpenApiErrorInfo("AUTHORIZE_SYS_DENY", 20, 40020, "System Deny Authorization", "系统拒绝进行授权");
        AUTHORIZE_SYS_DENY = r120;
        OpenApiErrorInfo r121 = new OpenApiErrorInfo("INTERNAL_ERROR", 21, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, "Internal Error Occur", "内部错误");
        INTERNAL_ERROR = r121;
        OpenApiErrorInfo r122 = new OpenApiErrorInfo("SIGNATURE_ERROR", 22, TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_EXITED_LC, "Signature Error", "验签失败");
        SIGNATURE_ERROR = r122;
        OpenApiErrorInfo r123 = new OpenApiErrorInfo("INVALID_URL_PARAMS", 23, TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_ORIGIN_LC, "Invalid Url Params", "无效的URL参数");
        INVALID_URL_PARAMS = r123;
        OpenApiErrorInfo r124 = new OpenApiErrorInfo("ACCOUNT_EXCEPTION", 24, TTVideoEngineInterface.ALGO_OPTION_INT_SELECT_BITRATE_MODE, "Account Exception", "账户异常");
        ACCOUNT_EXCEPTION = r124;
        OpenApiErrorInfo r125 = new OpenApiErrorInfo("REWARD_REACH_LIMIT", 25, TTVideoEngineInterface.ALGO_OPTION_INT_ALL_PRELOAD_FINISH_MESSAGE, "Acquired Reward Reach Upper Limit", "已达到道具奖励获取上限");
        REWARD_REACH_LIMIT = r125;
        OpenApiErrorInfo r126 = new OpenApiErrorInfo("APP_NOT_LAUNCH", 26, TTVideoEngineInterface.ALGO_OPTION_ENABLE_IO_DECISION, "App Not Launch", "游戏未启动");
        APP_NOT_LAUNCH = r126;
        OpenApiErrorInfo r127 = new OpenApiErrorInfo("USER_NOT_IN_ROOM", 27, TTVideoEngineInterface.ALGO_OPTION_AUTO_RESUME_TASK_WHEN_PLAY, "User Not In Room", "用户不在房间内");
        USER_NOT_IN_ROOM = r127;
        OpenApiErrorInfo r128 = new OpenApiErrorInfo("PAY_DIAMONDS_REACH_LIMIT", 28, TTVideoEngineInterface.ALGO_OPTION_PAUSE_IO_WHEN_REQ_END, "Pay Diamonds Reach Upper Limit", "超过" + r3.c() + "支付额上限");
        PAY_DIAMONDS_REACH_LIMIT = r128;
        OpenApiErrorInfo r129 = new OpenApiErrorInfo("PAY_CANCEL", 29, TTVideoEngineInterface.ALGO_OPTION_ENABLE_USE_CACHE_FLAG, "User Payment Cancel", "用户取消支付");
        PAY_CANCEL = r129;
        OpenApiErrorInfo r130 = new OpenApiErrorInfo("DATA_NOT_EXIST", 30, TTVideoEngineInterface.ALGO_OPTION_PLAYER_CONTEXT_INFO, "Data Not Exists", "数据不存在");
        DATA_NOT_EXIST = r130;
        OpenApiErrorInfo r131 = new OpenApiErrorInfo("UNKNOWN_ORDER_STATUS", 31, 50013, "Unknown Order Status", "订单状态未知");
        UNKNOWN_ORDER_STATUS = r131;
        OpenApiErrorInfo r132 = new OpenApiErrorInfo("ORDER_STATUS_ERROR", 32, 50014, "Order Status Abnormal", "订单状态错误");
        ORDER_STATUS_ERROR = r132;
        OpenApiErrorInfo r133 = new OpenApiErrorInfo("ORDER_PAID", 33, 50015, "Order Paid", "订单已支付");
        ORDER_PAID = r133;
        OpenApiErrorInfo r134 = new OpenApiErrorInfo("ORDER_EXPIRED", 34, 50016, "Order Expired", "订单已超时");
        ORDER_EXPIRED = r134;
        f60311a = new OpenApiErrorInfo[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134};
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getTip() {
        return this.tip;
    }

    public OpenApiErrorInfo(String r100, int r101, int r102, String r103, String r104) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMsg = r103;
        this.tip = r104;
    }
}
