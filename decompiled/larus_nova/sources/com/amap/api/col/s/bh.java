package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.byted.cast.common.source.ISendResultListener;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;

/* JADX INFO: loaded from: classes28.dex */
public final class bh extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f26192g;

    public final void g() {
        this.f26192g = true;
    }

    public final String a() {
        return this.f26186a;
    }

    public final String b() {
        return this.f26189d;
    }

    public final String c() {
        return this.f26190e;
    }

    public final String d() {
        return this.f26187b;
    }

    public final String e() {
        return this.f26188c;
    }

    public final boolean f() {
        return this.f26192g;
    }

    public bh(String r100) {
        super(r100);
        this.f26186a = "未知的错误";
        this.f26187b = "";
        this.f26188c = "";
        this.f26189d = "1900";
        this.f26190e = "UnknownError";
        this.f26191f = -1;
        this.f26192g = false;
        this.f26186a = r100;
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(r100) == false) goto L7;
        this.f26191f = 21;
        this.f26189d = "1902";
        this.f26190e = "IOException";
        return;
    L7:
        if ("socket 连接异常 - SocketException".equals(r100) == false) goto L11;
        this.f26191f = 22;
        return;
    L11:
        if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(r100) == false) goto L15;
        this.f26191f = 23;
        this.f26189d = "1802";
        this.f26190e = "SocketTimeoutException";
        return;
    L15:
        if (AMapException.AMAP_CLIENT_INVALID_PARAMETER.equals(r100) == false) goto L19;
        this.f26191f = 24;
        this.f26189d = "1901";
        this.f26190e = "IllegalArgumentException";
        return;
    L19:
        if (AMapException.AMAP_CLIENT_NULLPOINT_EXCEPTION.equals(r100) == false) goto L23;
        this.f26191f = 25;
        this.f26189d = "1903";
        this.f26190e = "NullPointException";
        return;
    L23:
        if (AMapException.AMAP_CLIENT_URL_EXCEPTION.equals(r100) == false) goto L27;
        this.f26191f = 26;
        this.f26189d = "1803";
        this.f26190e = "MalformedURLException";
        return;
    L27:
        if (AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(r100) == false) goto L31;
        this.f26191f = 27;
        this.f26189d = "1804";
        this.f26190e = "UnknownHostException";
        return;
    L31:
        if ("服务器连接失败 - UnknownServiceException".equals(r100) == false) goto L35;
        this.f26191f = 28;
        this.f26189d = "1805";
        this.f26190e = "CannotConnectToHostException";
        return;
    L35:
        if (AMapException.AMAP_CLIENT_ERROR_PROTOCOL.equals(r100) == false) goto L39;
        this.f26191f = 29;
        this.f26189d = "1801";
        this.f26190e = "ProtocolException";
        return;
    L39:
        if ("http连接失败 - ConnectionException".equals(r100) == false) goto L43;
        this.f26191f = 30;
        this.f26189d = "1806";
        this.f26190e = "ConnectionException";
        return;
    L43:
        if ("服务QPS超限".equalsIgnoreCase(r100) == false) goto L47;
        this.f26191f = 30;
        this.f26189d = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
        this.f26190e = "ConnectionException";
        return;
    L47:
        if ("未知的错误".equals(r100) == false) goto L51;
        this.f26191f = 31;
        return;
    L51:
        if ("key鉴权失败".equals(r100) == false) goto L55;
        this.f26191f = 32;
        return;
    L55:
        if ("requeust is null".equals(r100) == false) goto L59;
        this.f26191f = 1;
        return;
    L59:
        if ("request url is empty".equals(r100) == false) goto L63;
        this.f26191f = 2;
        return;
    L63:
        if (ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL.equals(r100) == false) goto L67;
        this.f26191f = 3;
        return;
    L67:
        if ("thread pool has exception".equals(r100) == false) goto L71;
        this.f26191f = 4;
        return;
    L71:
        if ("sdk name is invalid".equals(r100) == false) goto L75;
        this.f26191f = 5;
        return;
    L75:
        if ("sdk info is null".equals(r100) == false) goto L79;
        this.f26191f = 6;
        return;
    L79:
        if ("sdk packages is null".equals(r100) == false) goto L83;
        this.f26191f = 7;
        return;
    L83:
        if ("线程池为空".equals(r100) == false) goto L87;
        this.f26191f = 8;
        return;
    L87:
        if ("获取对象错误".equals(r100) == false) goto L90;
        this.f26191f = 101;
        return;
    L90:
        this.f26191f = -1;
    }

    public final void a(int r100) {
        this.f26191f = r100;
    }

    public bh(String r100, String r101, String r102) {
        this(r100);
        this.f26187b = r101;
        this.f26188c = r102;
    }
}
