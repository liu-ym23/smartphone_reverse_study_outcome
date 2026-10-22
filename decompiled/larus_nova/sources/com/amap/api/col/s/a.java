package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class a<T, V> extends bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f25990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected T f25991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f25992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f25993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Context f25994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f25995f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f25996j;

    public abstract V a(String r100) throws AMapException;

    public abstract String a();

    @Override // com.amap.api.col.s.cy
    public final String c() {
        return "sea";
    }

    public ad.b d() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public Map<String, String> f() {
        return null;
    }

    private V l() throws AMapException {
        ad.b r100 = d();     // Catch: Throwable -> L92 AMapException -> L95
        boolean r101 = ad.a().b(r100);     // Catch: Throwable -> L92 AMapException -> L95
        boolean r102 = false;
        int r103 = 0;
        V r104 = null;
        boolean r105 = false;
    L5:
        if (r103 >= this.f25992c) goto L91;
        long r106 = System.currentTimeMillis();     // Catch: Throwable -> L92 AMapException -> L95
        int r107 = ServiceSettings.getInstance().getProtocol();     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        bo.a().a(this.f25994e);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        cx r110 = cx.b();     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        if (r101 == false) goto L22;
        ad.c r111 = ad.a().a(r100);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        if (r111 == null) goto L22;
        Object r112 = r111.f26010a;     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        if (r112 == null) goto L22;
        am.a(this.f25994e, r100.f26008a, r111.f26011b);     // Catch: Throwable -> L16 AMapException -> L18 bh -> L20
        r104 = (V) r112;
        r105 = true;
        goto L22
    L20:
        e = e;
        r104 = (V) r112;
        r105 = true;
    L55:
        am.a(this.f25994e, i(), System.currentTimeMillis() - r106, r102);     // Catch: Throwable -> L42
        r103 = r103 + 1;     // Catch: Throwable -> L42
        if (r103 >= this.f25992c) goto L75;
        Thread.sleep(this.f25996j * 1000);     // Catch: Throwable -> L42 InterruptedException -> L63
        if (r101 == false) goto L62;
        if (r105 == true) goto L62;
        ad.a().a(r100, r104);     // Catch: Throwable -> L92 AMapException -> L95
    L62:
        r102 = false;
        goto L5
    L64:
        if ("http连接失败 - ConnectionException".equals(e.getMessage()) == true) goto L73;
        if ("socket 连接异常 - SocketException".equals(e.getMessage()) == true) goto L73;
        if ("服务器连接失败 - UnknownServiceException".equals(e.getMessage()) == true) goto L73;
        throw new AMapException(e.a(), 1, e.c());     // Catch: Throwable -> L42
    L73:
        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());     // Catch: Throwable -> L42
    L75:
        if ("http连接失败 - ConnectionException".equals(e.getMessage()) == true) goto L86;
        if ("socket 连接异常 - SocketException".equals(e.getMessage()) == true) goto L86;
        if ("未知的错误".equals(e.a()) == true) goto L86;
        if ("服务器连接失败 - UnknownServiceException".equals(e.getMessage()) == true) goto L86;
        throw new AMapException(e.a(), 1, e.c());     // Catch: Throwable -> L52
    L86:
        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());     // Catch: Throwable -> L52
    L18:
        e = e;
        r104 = (V) r112;
        r105 = true;
    L45:
        am.a(this.f25994e, i(), System.currentTimeMillis() - r106, r102);     // Catch: Throwable -> L42
        r103 = r103 + 1;     // Catch: Throwable -> L42
        if (r103 >= this.f25992c) goto L51;
        if (r101 == false) goto L62;
        if (r105 == true) goto L62;
        ad r108 = ad.a();     // Catch: Throwable -> L92 AMapException -> L95
    L40:
        r108.a(r100, r104);     // Catch: Throwable -> L92 AMapException -> L95
        goto L5
    L51:
        throw e;     // Catch: Throwable -> L52
    L16:
        th = th;
        Object r109 = r112;
        r105 = true;
    L87:
        if (r101 == false) goto L90;
        if (r105 == true) goto L90;
        ad.a().a(r100, r109);     // Catch: Throwable -> L92 AMapException -> L95
    L90:
        throw th;     // Catch: Throwable -> L92 AMapException -> L95
    L22:
        if (r104 != null) goto L36;
        if (r107 != 1) goto L29;
        if (this.f25990a == false) goto L27;
        byte[] r113 = r110.b(this);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
    L35:
        long r114 = System.currentTimeMillis();     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        r104 = a(r113);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        am.a(this.f25994e, i(), r114 - r106, true);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        goto L36
    L27:
        r113 = cx.d(this);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        goto L35
    L29:
        if (r107 == 2) goto L31;
        r113 = null;
        goto L35
    L31:
        if (this.f25990a == false) goto L33;
        r113 = cs.a(this);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        goto L35
    L33:
        r113 = cx.e(this);     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
    L36:
        r103 = this.f25992c;     // Catch: Throwable -> L42 AMapException -> L44 bh -> L54
        if (r101 == false) goto L62;
        if (r105 == true) goto L62;
        r108 = ad.a();     // Catch: Throwable -> L92 AMapException -> L95
        goto L40
    L52:
        th = th;
        r109 = null;
    L42:
        th = th;
        r109 = r104;
    L54:
        e = e;
    L44:
        e = e;
        goto L45
    L91:
        return r104;
    L95:
        e = move-exception;
        throw e;
    L92:
        th = move-exception;
        th.printStackTrace();
        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
    }

    public final V b() throws AMapException {
        if (this.f25991b != null) goto L24;
        return null;
    L24:
        return l();
    L6:
        e = move-exception;
        String r100 = i();
        String r101 = this.f25995f;
        if (r100 == null) goto L21;
        String r102 = e.getErrorType();
        if (e.getErrorLevel() != 0) goto L15;
        int r103 = e.getErrorCode();
        if (r103 != 0) goto L14;
        String r104 = "4";
    L16:
        if (r104 == null) goto L21;
        if (r104.length() <= 0) goto L21;
        cg.a(h.a(true), r100, r102, r101, r104);
        goto L21
    L14:
        int r105 = (int) Math.pow(10.0d, Math.floor(Math.log10(r103)));
        r104 = String.valueOf((r103 % r105) + (r105 * 4));
        goto L16
    L15:
        StringBuilder r106 = new StringBuilder();
        r106.append(e.getErrorCode());
        r104 = r106.toString();
    L21:
        throw e;
    }

    private String i() {
        String r100 = a_();
        if (r100 != null) goto L13;
        return null;
    L13:
        int r101 = r100.indexOf(".com/");     // Catch: Throwable -> L12
        int r102 = r100.indexOf("?");     // Catch: Throwable -> L12
        if (r102 != (-1)) goto L9;
        return r100.substring(r101 + 5);
    L9:
        return r100.substring(r101 + 5, r102);
    L14:
        return null;
    }

    public V a(byte[] r100) throws AMapException {
        String r101 = new String(r100, XML.CHARSET_UTF8);     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L9;
    L13:
        return null;
    L9:
        if (r101.equals("") == true) goto L13;
        i.b(r101);
        return a(r101);
    L5:
        e = move-exception;
        i.a(e, "ProtocalHandler", "loadData");
        r101 = null;
        goto L7
    }

    public a(Context r100, T r101) {
        this.f25990a = true;
        this.f25993d = "";
        this.f25996j = 1;
        this.f25995f = "";
        this.f25994e = r100;
        this.f25991b = r101;
        this.f25992c = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }
}
