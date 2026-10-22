package com.amap.api.col.jmsl;

import com.amap.api.services.core.AMapException;

/* renamed from: com.amap.api.col.jmsl.r1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1599r1 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public String f16809a;

    public C1599r1(String str) {
        super(str);
        this.f16809a = str;
        b(str);
    }

    public String a() {
        return this.f16809a;
    }

    public final void b(String str) {
        if ("用户签名未通过".equals(str) || AMapException.AMAP_INVALID_USER_KEY.equals(str) || AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str) || AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str) || AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str) || AMapException.AMAP_INVALID_USER_IP.equals(str) || AMapException.AMAP_INVALID_USER_DOMAIN.equals(str) || AMapException.AMAP_INVALID_USER_SCODE.equals(str) || AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str) || AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str) || AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str) || AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str) || AMapException.AMAP_USER_KEY_RECYCLED.equals(str) || AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str) || AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str) || AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str) || AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str) || AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str) || AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str) || AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str) || AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str) || "协议解析错误 - ProtocolException".equals(str) || "socket 连接超时 - SocketTimeoutException".equals(str) || "url异常 - MalformedURLException".equals(str) || "未知主机 - UnKnowHostException".equals(str) || AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str) || "无效的参数 - IllegalArgumentException".equals(str) || AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str) || "IO 操作异常 - IOException".equals(str)) {
            return;
        }
        "空指针异常 - NullPointException".equals(str);
    }
}
