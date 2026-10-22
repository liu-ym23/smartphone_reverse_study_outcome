package com.amap.api.services.core;

/* JADX INFO: loaded from: classes28.dex */
public class AMapException extends Exception {
    public static final String AMAP_ACCESS_TOO_FREQUENT = "用户访问过于频繁";
    public static final String AMAP_CLIENT_ERRORCODE_MISSSING = "没有对应的错误";
    public static final String AMAP_CLIENT_ERRORCODE_MISSSING_TPPE = "AMAP_CLIENT_ERRORCODE_MISSSING";
    public static final String AMAP_CLIENT_ERROR_PROTOCOL = "协议解析错误 - ProtocolException";
    public static final String AMAP_CLIENT_INVALID_PARAMETER = "无效的参数 - IllegalArgumentException";
    public static final String AMAP_CLIENT_IO_EXCEPTION = "IO 操作异常 - IOException";
    public static final String AMAP_CLIENT_NEARBY_NULL_RESULT = "NearbyInfo对象为空";
    public static final String AMAP_CLIENT_NETWORK_EXCEPTION = "http或socket连接失败 - ConnectionException";
    public static final String AMAP_CLIENT_NULLPOINT_EXCEPTION = "空指针异常 - NullPointException";
    public static final String AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION = "关键字过长";
    public static final String AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION = "避让区域点个数超限";
    public static final String AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION = "避让区域大小超限";
    public static final String AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION = "避让区域个数超限";
    public static final String AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION = "途经点个数超限";
    public static final String AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION = "socket 连接超时 - SocketTimeoutException";
    public static final String AMAP_CLIENT_UNKNOWHOST_EXCEPTION = "未知主机 - UnKnowHostException";
    public static final String AMAP_CLIENT_UNKNOWN_ERROR = "未知错误";
    public static final String AMAP_CLIENT_UNKNOWN_ERROR_TYPE = "CLIENT_UNKNOWN_ERROR";
    public static final String AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR = "已开启自动上传";
    public static final String AMAP_CLIENT_UPLOAD_LOCATION_ERROR = "Point为空，或与前次上传的相同";
    public static final String AMAP_CLIENT_UPLOAD_TOO_FREQUENT = "两次单次上传的间隔低于7秒";
    public static final String AMAP_CLIENT_URL_EXCEPTION = "url异常 - MalformedURLException";
    public static final String AMAP_CLIENT_USERID_ILLEGAL = "USERID非法";
    public static final String AMAP_DAILY_QUERY_OVER_LIMIT = "访问已超出日访问量";
    public static final String AMAP_ENGINE_CONNECT_TIMEOUT = "服务端请求链接超时";
    public static final String AMAP_ENGINE_RESPONSE_DATA_ERROR = "引擎返回数据异常";
    public static final String AMAP_ENGINE_RESPONSE_ERROR = "请求服务响应错误";
    public static final String AMAP_ENGINE_RETURN_TIMEOUT = "读取服务结果超时";
    public static final String AMAP_ENGINE_TABLEID_NOT_EXIST = "key对应的tableID不存在";
    public static final int AMAP_ERROR_CORE = 1;
    public static final int AMAP_ERROR_LOCAL = 0;
    public static final int AMAP_ERROR_LOCAL_STANDARDIZED = 4;
    public static final int AMAP_ERROR_REST = 2;
    public static final String AMAP_ID_NOT_EXIST = "ID不存在";
    public static final String AMAP_INSUFFICIENT_PRIVILEGES = "权限不足，服务请求被拒绝";
    public static final String AMAP_INVALID_USER_DOMAIN = "用户域名无效";
    public static final String AMAP_INVALID_USER_IP = "用户IP无效";
    public static final String AMAP_INVALID_USER_KEY = "用户key不正确或过期";
    public static final String AMAP_INVALID_USER_SCODE = "用户MD5安全码未通过";
    public static final String AMAP_IP_QUERY_OVER_LIMIT = "IP访问超限";
    public static final String AMAP_NEARBY_INVALID_USERID = "找不到对应的userid信息,请检查您提供的userid是否存在";
    public static final String AMAP_NEARBY_KEY_NOT_BIND = "App key未开通“附近”功能,请注册附近KEY";
    public static final String AMAP_NOT_SUPPORT_HTTPS = "服务不支持https请求";
    public static final String AMAP_OVER_DIRECTION_RANGE = "起点终点距离过长";
    public static final String AMAP_ROUTE_FAIL = "路线计算失败，通常是由于道路连通关系导致";
    public static final String AMAP_ROUTE_NO_ROADS_NEARBY = "规划点（起点、终点、途经点）附近搜不到路";
    public static final String AMAP_ROUTE_OUT_OF_SERVICE = "规划点（包括起点、终点、途经点）不在中国陆地范围内";
    public static final String AMAP_SERVICE_ILLEGAL_REQUEST = "请求协议非法";
    public static final String AMAP_SERVICE_INVALID_PARAMS = "请求参数非法";
    public static final String AMAP_SERVICE_MAINTENANCE = "服务器维护中";
    public static final String AMAP_SERVICE_MISSING_REQUIRED_PARAMS = "缺少必填参数";
    public static final String AMAP_SERVICE_NOT_AVAILBALE = "请求服务不存在";
    public static final String AMAP_SERVICE_TABLEID_NOT_EXIST = "tableID格式不正确不存在";
    public static final String AMAP_SERVICE_UNKNOWN_ERROR = "其他未知错误";
    public static final String AMAP_SHARE_FAILURE = "短串请求失败";
    public static final String AMAP_SHARE_LICENSE_IS_EXPIRED = "短串分享认证失败";
    public static final String AMAP_SHARE_SIGNATURE_FAILURE = "用户签名未通过";
    public static final String AMAP_SIGNATURE_ERROR = "用户签名未通过";
    public static final String AMAP_USERKEY_PLAT_NOMATCH = "请求key与绑定平台不符";
    public static final String AMAP_USER_KEY_RECYCLED = "开发者删除了key，key被删除后无法正常使用";
    public static final int CODE_AMAP_ACCESS_TOO_FREQUENT = 1005;
    public static final int CODE_AMAP_CLIENT_ERRORCODE_MISSSING = 1800;
    public static final int CODE_AMAP_CLIENT_ERROR_PROTOCOL = 1801;
    public static final int CODE_AMAP_CLIENT_INVALID_PARAMETER = 1901;
    public static final int CODE_AMAP_CLIENT_IO_EXCEPTION = 1902;
    public static final int CODE_AMAP_CLIENT_NEARBY_NULL_RESULT = 2202;
    public static final int CODE_AMAP_CLIENT_NETWORK_EXCEPTION = 1806;
    public static final int CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION = 1903;
    public static final int CODE_AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION = 1813;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION = 1812;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION = 1811;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION = 1810;
    public static final int CODE_AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION = 1809;
    public static final int CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION = 1802;
    public static final int CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION = 1804;
    public static final int CODE_AMAP_CLIENT_UNKNOWN_ERROR = 1900;
    public static final int CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR = 2200;
    public static final int CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR = 2204;
    public static final int CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT = 2203;
    public static final int CODE_AMAP_CLIENT_URL_EXCEPTION = 1803;
    public static final int CODE_AMAP_CLIENT_USERID_ILLEGAL = 2201;
    public static final int CODE_AMAP_DAILY_QUERY_OVER_LIMIT = 1004;
    public static final int CODE_AMAP_ENGINE_CONNECT_TIMEOUT = 1102;
    public static final int CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR = 1101;
    public static final int CODE_AMAP_ENGINE_RESPONSE_ERROR = 1100;
    public static final int CODE_AMAP_ENGINE_RETURN_TIMEOUT = 1103;
    public static final int CODE_AMAP_ENGINE_TABLEID_NOT_EXIST = 2003;
    public static final int CODE_AMAP_ID_NOT_EXIST = 2001;
    public static final int CODE_AMAP_INSUFFICIENT_PRIVILEGES = 1012;
    public static final int CODE_AMAP_INVALID_USER_DOMAIN = 1007;
    public static final int CODE_AMAP_INVALID_USER_IP = 1006;
    public static final int CODE_AMAP_INVALID_USER_KEY = 1002;
    public static final int CODE_AMAP_INVALID_USER_SCODE = 1008;
    public static final int CODE_AMAP_IP_QUERY_OVER_LIMIT = 1010;
    public static final int CODE_AMAP_NEARBY_INVALID_USERID = 2100;
    public static final int CODE_AMAP_NEARBY_KEY_NOT_BIND = 2101;
    public static final int CODE_AMAP_NOT_SUPPORT_HTTPS = 1011;
    public static final int CODE_AMAP_OVER_DIRECTION_RANGE = 3003;
    public static final int CODE_AMAP_ROUTE_FAIL = 3002;
    public static final int CODE_AMAP_ROUTE_NO_ROADS_NEARBY = 3001;
    public static final int CODE_AMAP_ROUTE_OUT_OF_SERVICE = 3000;
    public static final int CODE_AMAP_SERVICE_ILLEGAL_REQUEST = 1202;
    public static final int CODE_AMAP_SERVICE_INVALID_PARAMS = 1200;
    public static final int CODE_AMAP_SERVICE_MAINTENANCE = 2002;
    public static final int CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS = 1201;
    public static final int CODE_AMAP_SERVICE_NOT_AVAILBALE = 1003;
    public static final int CODE_AMAP_SERVICE_TABLEID_NOT_EXIST = 2000;
    public static final int CODE_AMAP_SERVICE_UNKNOWN_ERROR = 1203;
    public static final int CODE_AMAP_SHARE_FAILURE = 4001;
    public static final int CODE_AMAP_SHARE_LICENSE_IS_EXPIRED = 4000;
    public static final int CODE_AMAP_SHARE_SIGNATURE_FAILURE = 4002;
    public static final int CODE_AMAP_SIGNATURE_ERROR = 1001;
    public static final int CODE_AMAP_SUCCESS = 1000;
    public static final int CODE_AMAP_USERKEY_PLAT_NOMATCH = 1009;
    public static final int CODE_AMAP_USER_KEY_RECYCLED = 1013;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28835d;

    public AMapException() {
        this.f28832a = 0;
        this.f28833b = null;
        this.f28834c = "";
        this.f28835d = 1000;
    }

    public int getErrorCode() {
        return this.f28835d;
    }

    public int getErrorLevel() {
        return this.f28832a;
    }

    public String getErrorMessage() {
        return this.f28834c;
    }

    public String getErrorType() {
        return this.f28833b;
    }

    public AMapException(String r100) {
        super(r100);
        this.f28833b = null;
        this.f28835d = 1000;
        this.f28834c = r100;
        this.f28832a = 0;
        a(r100);
    }

    private void a(String r100) {
        if ("用户签名未通过".equals(r100) == false) goto L7;
        this.f28835d = 1001;
        return;
    L7:
        if (AMAP_INVALID_USER_KEY.equals(r100) == false) goto L11;
        this.f28835d = 1002;
        return;
    L11:
        if (AMAP_SERVICE_NOT_AVAILBALE.equals(r100) == false) goto L15;
        this.f28835d = 1003;
        return;
    L15:
        if (AMAP_DAILY_QUERY_OVER_LIMIT.equals(r100) == false) goto L19;
        this.f28835d = 1004;
        return;
    L19:
        if (AMAP_ACCESS_TOO_FREQUENT.equals(r100) == false) goto L23;
        this.f28835d = 1005;
        return;
    L23:
        if (AMAP_INVALID_USER_IP.equals(r100) == false) goto L27;
        this.f28835d = 1006;
        return;
    L27:
        if (AMAP_INVALID_USER_DOMAIN.equals(r100) == false) goto L31;
        this.f28835d = 1007;
        return;
    L31:
        if (AMAP_INVALID_USER_SCODE.equals(r100) == false) goto L35;
        this.f28835d = 1008;
        return;
    L35:
        if (AMAP_USERKEY_PLAT_NOMATCH.equals(r100) == false) goto L39;
        this.f28835d = 1009;
        return;
    L39:
        if (AMAP_IP_QUERY_OVER_LIMIT.equals(r100) == false) goto L43;
        this.f28835d = 1010;
        return;
    L43:
        if (AMAP_NOT_SUPPORT_HTTPS.equals(r100) == false) goto L47;
        this.f28835d = 1011;
        return;
    L47:
        if (AMAP_INSUFFICIENT_PRIVILEGES.equals(r100) == false) goto L51;
        this.f28835d = 1012;
        return;
    L51:
        if (AMAP_USER_KEY_RECYCLED.equals(r100) == false) goto L55;
        this.f28835d = 1013;
        return;
    L55:
        if (AMAP_ENGINE_RESPONSE_ERROR.equals(r100) == false) goto L59;
        this.f28835d = 1100;
        return;
    L59:
        if (AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(r100) == false) goto L63;
        this.f28835d = 1101;
        return;
    L63:
        if (AMAP_ENGINE_CONNECT_TIMEOUT.equals(r100) == false) goto L67;
        this.f28835d = 1102;
        return;
    L67:
        if (AMAP_ENGINE_RETURN_TIMEOUT.equals(r100) == false) goto L71;
        this.f28835d = 1103;
        return;
    L71:
        if (AMAP_SERVICE_INVALID_PARAMS.equals(r100) == false) goto L75;
        this.f28835d = 1200;
        return;
    L75:
        if (AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(r100) == false) goto L79;
        this.f28835d = 1201;
        return;
    L79:
        if (AMAP_SERVICE_ILLEGAL_REQUEST.equals(r100) == false) goto L83;
        this.f28835d = 1202;
        return;
    L83:
        if (AMAP_SERVICE_UNKNOWN_ERROR.equals(r100) == false) goto L87;
        this.f28835d = 1203;
        return;
    L87:
        if (AMAP_CLIENT_ERROR_PROTOCOL.equals(r100) == false) goto L91;
        this.f28835d = 1801;
        return;
    L91:
        if (AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(r100) == false) goto L95;
        this.f28835d = 1802;
        return;
    L95:
        if (AMAP_CLIENT_URL_EXCEPTION.equals(r100) == false) goto L99;
        this.f28835d = 1803;
        return;
    L99:
        if (AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(r100) == false) goto L103;
        this.f28835d = 1804;
        return;
    L103:
        if (AMAP_CLIENT_INVALID_PARAMETER.equals(r100) == false) goto L107;
        this.f28835d = 1901;
        return;
    L107:
        if (AMAP_CLIENT_NETWORK_EXCEPTION.equals(r100) == false) goto L111;
        this.f28835d = 1806;
        return;
    L111:
        if (AMAP_CLIENT_IO_EXCEPTION.equals(r100) == false) goto L115;
        this.f28835d = 1902;
        return;
    L115:
        if (AMAP_CLIENT_NULLPOINT_EXCEPTION.equals(r100) == false) goto L119;
        this.f28835d = CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION;
        return;
    L119:
        if (AMAP_SERVICE_TABLEID_NOT_EXIST.equals(r100) == false) goto L123;
        this.f28835d = 2000;
        return;
    L123:
        if (AMAP_ID_NOT_EXIST.equals(r100) == false) goto L127;
        this.f28835d = 2001;
        return;
    L127:
        if (AMAP_SERVICE_MAINTENANCE.equals(r100) == false) goto L131;
        this.f28835d = 2002;
        return;
    L131:
        if (AMAP_ENGINE_TABLEID_NOT_EXIST.equals(r100) == false) goto L135;
        this.f28835d = 2003;
        return;
    L135:
        if (AMAP_NEARBY_INVALID_USERID.equals(r100) == false) goto L139;
        this.f28835d = 2100;
        return;
    L139:
        if (AMAP_NEARBY_KEY_NOT_BIND.equals(r100) == false) goto L143;
        this.f28835d = 2101;
        return;
    L143:
        if (AMAP_ROUTE_OUT_OF_SERVICE.equals(r100) == false) goto L147;
        this.f28835d = 3000;
        return;
    L147:
        if (AMAP_ROUTE_NO_ROADS_NEARBY.equals(r100) == false) goto L151;
        this.f28835d = 3001;
        return;
    L151:
        if (AMAP_ROUTE_FAIL.equals(r100) == false) goto L155;
        this.f28835d = 3002;
        return;
    L155:
        if (AMAP_OVER_DIRECTION_RANGE.equals(r100) == false) goto L159;
        this.f28835d = 3003;
        return;
    L159:
        if (AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR.equals(r100) == false) goto L163;
        this.f28835d = CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR;
        return;
    L163:
        if (AMAP_CLIENT_USERID_ILLEGAL.equals(r100) == false) goto L167;
        this.f28835d = CODE_AMAP_CLIENT_USERID_ILLEGAL;
        return;
    L167:
        if (AMAP_CLIENT_NEARBY_NULL_RESULT.equals(r100) == false) goto L171;
        this.f28835d = CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
        return;
    L171:
        if (AMAP_CLIENT_UPLOAD_TOO_FREQUENT.equals(r100) == false) goto L175;
        this.f28835d = CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
        return;
    L175:
        if (AMAP_CLIENT_UPLOAD_LOCATION_ERROR.equals(r100) == false) goto L179;
        this.f28835d = CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
        return;
    L179:
        if (AMAP_SHARE_LICENSE_IS_EXPIRED.equals(r100) == false) goto L183;
        this.f28835d = 4000;
        return;
    L183:
        if (AMAP_SHARE_FAILURE.equals(r100) == false) goto L187;
        this.f28835d = 4001;
        return;
    L187:
        if ("用户签名未通过".equals(r100) == false) goto L191;
        this.f28835d = 4002;
        return;
    L191:
        if (AMAP_CLIENT_UNKNOWN_ERROR.equals(r100) == false) goto L195;
        this.f28835d = 1900;
        this.f28833b = AMAP_CLIENT_UNKNOWN_ERROR_TYPE;
        return;
    L195:
        if (AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION.equals(r100) == false) goto L199;
        this.f28835d = CODE_AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION;
        return;
    L199:
        if (AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION.equals(r100) == false) goto L203;
        this.f28835d = CODE_AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION;
        return;
    L203:
        if (AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION.equals(r100) == false) goto L207;
        this.f28835d = CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION;
        return;
    L207:
        if (AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION.equals(r100) == false) goto L211;
        this.f28835d = CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION;
        return;
    L211:
        if (AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION.equals(r100) == false) goto L214;
        this.f28835d = CODE_AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION;
        return;
    L214:
        this.f28835d = 1800;
        this.f28833b = AMAP_CLIENT_ERRORCODE_MISSSING_TPPE;
    }

    public AMapException(String r100, int r101, String r102) {
        super(r100);
        this.f28835d = 1000;
        this.f28834c = r100;
        this.f28832a = r101;
        this.f28833b = r102;
        a(r100);
    }

    public AMapException(String r100, int r101, String r102, int r103) {
        this(r100);
        this.f28834c = r100;
        this.f28832a = r101;
        this.f28833b = r102;
        this.f28835d = r103;
    }
}
