package com.amap.api.col.jmsl;

import com.amap.api.maps.model.AMapException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class g5 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public String f16634a;

    /* renamed from: b, reason: collision with root package name */
    public String f16635b;

    /* renamed from: c, reason: collision with root package name */
    public String f16636c;

    /* renamed from: d, reason: collision with root package name */
    public String f16637d;

    /* renamed from: e, reason: collision with root package name */
    public String f16638e;

    /* renamed from: f, reason: collision with root package name */
    public int f16639f;

    /* renamed from: g, reason: collision with root package name */
    public int f16640g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f16641h;

    /* renamed from: i, reason: collision with root package name */
    public String f16642i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, List<String>> f16643j;

    public g5(String str) {
        super(str);
        this.f16634a = AMapException.ERROR_UNKNOWN;
        this.f16635b = "";
        this.f16636c = "";
        this.f16637d = "1900";
        this.f16638e = "UnknownError";
        this.f16639f = -1;
        this.f16640g = -1;
        this.f16641h = false;
        this.f16634a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f16639f = 21;
            this.f16637d = "1902";
            this.f16638e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f16639f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f16639f = 23;
            this.f16637d = "1802";
            this.f16638e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f16639f = 24;
            this.f16637d = "1901";
            this.f16638e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f16639f = 25;
            this.f16637d = "1903";
            this.f16638e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f16639f = 26;
            this.f16637d = "1803";
            this.f16638e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f16639f = 27;
            this.f16637d = "1804";
            this.f16638e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f16639f = 28;
            this.f16637d = "1805";
            this.f16638e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f16639f = 29;
            this.f16637d = "1801";
            this.f16638e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f16639f = 30;
            this.f16637d = "1806";
            this.f16638e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f16639f = 30;
            this.f16637d = "2001";
            this.f16638e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f16639f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f16639f = 32;
        } else if ("限制访问的接口".equals(str)) {
            this.f16639f = 33;
        } else if ("requeust is null".equals(str)) {
            this.f16639f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f16639f = 2;
        } else if ("response is null".equals(str)) {
            this.f16639f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f16639f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f16639f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f16639f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f16639f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f16639f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f16639f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f16639f = 3;
        } else {
            this.f16639f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f16640g = 7;
            return;
        }
        if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f16640g = 6;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f16640g = 2;
            return;
        }
        if (!"未知主机 - UnKnowHostException".equals(str)) {
            if (AMapException.ERROR_CONNECTION.equals(str)) {
                this.f16640g = 6;
                return;
            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.f16640g = 3;
                return;
            }
        }
        this.f16640g = 9;
    }

    public int a() {
        return this.f16640g;
    }

    public int b(int i10) {
        this.f16640g = i10;
        return i10;
    }

    public void c(String str) {
        this.f16642i = str;
    }

    public void d(Map<String, List<String>> map) {
        this.f16643j = map;
    }

    public void e(boolean z10) {
        this.f16641h = z10;
    }

    public String f() {
        return this.f16636c;
    }

    public int g() {
        return this.f16639f;
    }

    public String h() {
        return this.f16634a;
    }

    public String i() {
        return this.f16635b;
    }

    public String j() {
        return this.f16637d;
    }

    public String k() {
        return this.f16638e;
    }

    public Map<String, List<String>> l() {
        return this.f16643j;
    }

    public String m() {
        return this.f16642i;
    }

    public boolean n() {
        return this.f16641h;
    }

    public g5(String str, String str2, String str3) {
        this(str);
        this.f16635b = str2;
        this.f16636c = str3;
    }
}
