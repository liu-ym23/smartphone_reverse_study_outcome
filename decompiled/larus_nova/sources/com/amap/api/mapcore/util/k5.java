package com.amap.api.mapcore.util;

import com.amap.api.services.core.AMapException;
import com.byted.cast.common.source.ISendResultListener;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;

/* JADX INFO: loaded from: classes28.dex */
public class k5 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f27493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f27498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f27499h;

    public int a() {
        return this.f27498g;
    }

    public String b() {
        return this.f27494c;
    }

    public int c() {
        return this.f27497f;
    }

    public String d() {
        return this.f27492a;
    }

    public String e() {
        return this.f27493b;
    }

    public String f() {
        return this.f27495d;
    }

    public String g() {
        return this.f27496e;
    }

    public boolean h() {
        return this.f27499h;
    }

    public k5(String r110) {
        super(r110);
        this.f27492a = "未知的错误";
        this.f27493b = "";
        this.f27494c = "";
        this.f27495d = "1900";
        this.f27496e = "UnknownError";
        this.f27497f = -1;
        this.f27498g = -1;
        this.f27499h = false;
        this.f27492a = r110;
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(r110) == false) goto L6;
        this.f27497f = 21;
        this.f27495d = "1902";
        this.f27496e = "IOException";
    L76:
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(r110) == false) goto L80;
        this.f27498g = 7;
        return;
    L80:
        if ("socket 连接异常 - SocketException".equals(r110) == false) goto L84;
        this.f27498g = 6;
        return;
    L84:
        if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(r110) == false) goto L88;
        this.f27498g = 2;
        return;
    L88:
        if (AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(r110) == false) goto L90;
    L99:
        this.f27498g = 9;
        return;
    L90:
        if ("http连接失败 - ConnectionException".equals(r110) == false) goto L94;
        this.f27498g = 6;
        return;
    L94:
        if ("未知的错误".equals(r110) == true) goto L99;
        if ("DNS解析失败".equals(r110) == false) goto L99;
        this.f27498g = 3;
        return;
    L6:
        if ("socket 连接异常 - SocketException".equals(r110) == false) goto L9;
        this.f27497f = 22;
        goto L76
    L9:
        if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(r110) == false) goto L12;
        this.f27497f = 23;
        this.f27495d = "1802";
        this.f27496e = "SocketTimeoutException";
        goto L76
    L12:
        if (AMapException.AMAP_CLIENT_INVALID_PARAMETER.equals(r110) == false) goto L15;
        this.f27497f = 24;
        this.f27495d = "1901";
        this.f27496e = "IllegalArgumentException";
        goto L76
    L15:
        if (AMapException.AMAP_CLIENT_NULLPOINT_EXCEPTION.equals(r110) == false) goto L18;
        this.f27497f = 25;
        this.f27495d = "1903";
        this.f27496e = "NullPointException";
        goto L76
    L18:
        if (AMapException.AMAP_CLIENT_URL_EXCEPTION.equals(r110) == false) goto L21;
        this.f27497f = 26;
        this.f27495d = "1803";
        this.f27496e = "MalformedURLException";
        goto L76
    L21:
        if (AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(r110) == false) goto L24;
        this.f27497f = 27;
        this.f27495d = "1804";
        this.f27496e = "UnknownHostException";
        goto L76
    L24:
        if ("服务器连接失败 - UnknownServiceException".equals(r110) == false) goto L27;
        this.f27497f = 28;
        this.f27495d = "1805";
        this.f27496e = "CannotConnectToHostException";
        goto L76
    L27:
        if (AMapException.AMAP_CLIENT_ERROR_PROTOCOL.equals(r110) == false) goto L30;
        this.f27497f = 29;
        this.f27495d = "1801";
        this.f27496e = "ProtocolException";
        goto L76
    L30:
        if ("http连接失败 - ConnectionException".equals(r110) == false) goto L33;
        this.f27497f = 30;
        this.f27495d = "1806";
        this.f27496e = "ConnectionException";
        goto L76
    L33:
        if ("服务QPS超限".equalsIgnoreCase(r110) == false) goto L36;
        this.f27497f = 30;
        this.f27495d = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
        this.f27496e = "ConnectionException";
        goto L76
    L36:
        if ("未知的错误".equals(r110) == false) goto L39;
        this.f27497f = 31;
        goto L76
    L39:
        if ("key鉴权失败".equals(r110) == false) goto L42;
        this.f27497f = 32;
        goto L76
    L42:
        if ("限制访问的接口".equals(r110) == false) goto L45;
        this.f27497f = 33;
        goto L76
    L45:
        if ("requeust is null".equals(r110) == false) goto L48;
        this.f27497f = 1;
        goto L76
    L48:
        if ("request url is empty".equals(r110) == false) goto L51;
        this.f27497f = 2;
        goto L76
    L51:
        if (ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL.equals(r110) == false) goto L54;
        this.f27497f = 3;
        goto L76
    L54:
        if ("thread pool has exception".equals(r110) == false) goto L57;
        this.f27497f = 4;
        goto L76
    L57:
        if ("sdk name is invalid".equals(r110) == false) goto L60;
        this.f27497f = 5;
        goto L76
    L60:
        if ("sdk info is null".equals(r110) == false) goto L63;
        this.f27497f = 6;
        goto L76
    L63:
        if ("sdk packages is null".equals(r110) == false) goto L66;
        this.f27497f = 7;
        goto L76
    L66:
        if ("线程池为空".equals(r110) == false) goto L69;
        this.f27497f = 8;
        goto L76
    L69:
        if ("获取对象错误".equals(r110) == false) goto L72;
        this.f27497f = 101;
        goto L76
    L72:
        if ("DNS解析失败".equals(r110) == false) goto L74;
        this.f27497f = 3;
        goto L76
    L74:
        this.f27497f = -1;
        goto L76
    }

    public int a(int r100) {
        this.f27498g = r100;
        return r100;
    }

    public void b(int r100) {
        this.f27497f = r100;
    }

    public void a(boolean r100) {
        this.f27499h = r100;
    }

    public k5(String r100, String r101, String r102) {
        this(r100);
        this.f27493b = r101;
        this.f27494c = r102;
    }
}
