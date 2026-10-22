package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes28.dex */
public final class q implements Callable<u> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HttpRequestRetryHandler f25051e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f25052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f25053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f25054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25055d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HttpUriRequest f25056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HttpContext f25057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CookieStore f25058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CookieManager f25059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AbstractHttpEntity f25060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HttpHost f25061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public URL f25062l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25063m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f25064n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f25065o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f25066p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f25067q;

    static {
        f25051e = new ad();
    }

    public q(l r100, o r101) {
        this.f25057g = new BasicHttpContext();
        this.f25058h = new BasicCookieStore();
        this.f25063m = 0;
        this.f25064n = false;
        this.f25065o = false;
        this.f25066p = null;
        this.f25052a = r100;
        this.f25053b = r100.f25029a;
        this.f25054c = r101;
    }

    public static long a(String[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L12;
        if (HTTP.MAX_AGE.equalsIgnoreCase(r100[r101]) == false) goto L11;
        String r102 = r100[r101 + 1];
        if (r102 == null) goto L11;
        return CastLongProtector.parseLong(r102);
    L11:
        r101 = r101 + 1;
        goto L4
    L12:
        return 0;
    }

    public static HttpUrlHeader a(HttpResponse r100) {
        HttpUrlHeader r101 = new HttpUrlHeader();
        Header[] r102 = r100.getAllHeaders();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Header r105 = r102[r104];
        r101.setHead(r105.getName(), r105.getValue());
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    private u a(HttpResponse r110, int r111, String r112) {
        ThreadMethodProxy.currentThread().getId();
        HttpEntity r100 = r110.getEntity();
        ByteArrayOutputStream r101 = null;
        String r102 = null;
        if (r100 != null) goto L5;
    L28:
        if (r100 != null) goto L40;
        r110.getStatusLine().getStatusCode();
        return null;
    L40:
        return null;
    L5:
        if (r110.getStatusLine().getStatusCode() != 200) goto L28;
        ThreadMethodProxy.currentThread().getId();
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L20
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L18
        a(r100, r103);     // Catch: Throwable -> L18
        byte[] r105 = r103.toByteArray();     // Catch: Throwable -> L18
        this.f25065o = false;     // Catch: Throwable -> L18
        this.f25052a.c(System.currentTimeMillis() - r104);     // Catch: Throwable -> L18
        this.f25052a.a(r105.length);     // Catch: Throwable -> L18
        p r106 = new p(a(r110), r111, r112, r105);     // Catch: Throwable -> L18
        long r113 = b(r110);     // Catch: Throwable -> L18
        Header r114 = r110.getEntity().getContentType();     // Catch: Throwable -> L18
        if (r114 == null) goto L11;
        HashMap<String, String> r115 = a(r114.getValue());     // Catch: Throwable -> L18
        r102 = r115.get("charset");     // Catch: Throwable -> L18
        String r116 = r115.get("Content-Type");     // Catch: Throwable -> L18
    L12:
        r106.b(r116);     // Catch: Throwable -> L18
        r106.a(r102);     // Catch: Throwable -> L18
        r106.a(System.currentTimeMillis());     // Catch: Throwable -> L18
        r106.b(r113);     // Catch: Throwable -> L18
        r103.close();     // Catch: IOException -> L15
        return r106;
    L15:
        e = move-exception;
        throw new RuntimeException("ArrayOutputStream close error!", e.getCause());
    L11:
        r116 = null;
    L18:
        th = th;
        r101 = r103;
    L21:
        if (r101 != null) goto L31;
    L27:
        throw th;
    L31:
        r101.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        throw new RuntimeException("ArrayOutputStream close error!", e.getCause());
    L20:
        th = th;
        goto L21
    }

    public static HashMap<String, String> a(String r100) {
        HashMap<String, String> r101 = new HashMap();
        String[] r102 = r100.split(com.alipay.sdk.m.u.i.f25853b);
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        String r105 = r102[r104];
        if (r105.indexOf(61) != (-1)) goto L7;
        String[] r106 = {"Content-Type", r105};
    L8:
        r101.put(r106[0], r106[1]);
        r104 = r104 + 1;
        goto L3
    L7:
        r106 = r105.split(ContainerUtils.KEY_VALUE_DELIMITER);
        goto L8
    L9:
        return r101;
    }

    private void a(HttpEntity r100, OutputStream r101) {
        InputStream r102 = b.a(r100);
        r100.getContentLength();
        byte[] r103 = new byte[2048];     // Catch: Throwable -> L12 Exception -> L14
    L4:
        int r104 = r102.read(r103);     // Catch: Throwable -> L12 Exception -> L14
        if (r104 == (-1)) goto L9;
        if (this.f25054c.h() == true) goto L9;
        r101.write(r103, 0, r104);     // Catch: Throwable -> L12 Exception -> L14
        this.f25054c.f();     // Catch: Throwable -> L12 Exception -> L14
    L9:
        r101.flush();     // Catch: Throwable -> L12 Exception -> L14
        r.a(r102);
        return;
    L14:
        e = move-exception;
        e.getCause();     // Catch: Throwable -> L12
        throw new IOException("HttpWorker Request Error!" + e.getLocalizedMessage());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r.a(r102);
        throw th;
    }

    public static long b(HttpResponse r100) {
        Header r101 = r100.getFirstHeader("Cache-Control");
        if (r101 == null) goto L9;
        String[] r102 = r101.getValue().split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r102.length < 2) goto L9;
        return a(r102);
    L9:
        Header r103 = r100.getFirstHeader("Expires");
        if (r103 != null) goto L16;
        return 0;
    L16:
        return b.b(r103.getValue()) - System.currentTimeMillis();
    }

    private URI b() {
        String r100 = this.f25054c.a();
        String r101 = this.f25055d;
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        if (r100 == null) goto L9;
        return new URI(r100);
    L9:
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest r100 = this.f25056f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f25060j != null) goto L14;
        byte[] r101 = this.f25054c.b();
        String r102 = this.f25054c.b(DownloadHelper.GZIP);
        if (r101 == null) goto L14;
        if (TextUtils.equals(r102, "true") == false) goto L12;
        this.f25060j = b.a(r101);
    L13:
        this.f25060j.setContentType(this.f25054c.c());
        goto L14
    L12:
        this.f25060j = new ByteArrayEntity(r101);
    L14:
        AbstractHttpEntity r103 = this.f25060j;
        if (r103 == null) goto L17;
        HttpPost r104 = new HttpPost(b());
        r104.setEntity(r103);
        this.f25056f = r104;
    L19:
        return this.f25056f;
    L17:
        this.f25056f = new HttpGet(b());
        goto L19
    }

    private u d() {
    L183:
        NetworkInfo[] r100 = ((ConnectivityManager) this.f25053b.getSystemService("connectivity")).getAllNetworkInfo();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        boolean r101 = true;
        if (r100 != null) goto L7;
    L6:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L98;
        ArrayList<Header> r103 = this.f25054c.d();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r103 != null) goto L21;
    L26:
        b.a(c());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        b.b(c());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        c().addHeader(BaseHttpRequestInfo.KEY_COOKIE, i().getCookie(this.f25054c.a()));     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        this.f25057g.setAttribute("http.cookie-store", this.f25058h);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        this.f25052a.a().a(f25051e);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        f();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        this.f25056f.getURI().toString();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        HttpParams r105 = this.f25052a.a().getParams();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        NetworkInfo r110 = ((ConnectivityManager) this.f25053b.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        HttpHost r111 = null;
        if (r110 != null) goto L35;
    L39:
        HttpHost r112 = null;
    L40:
        if (r112 != null) goto L42;
    L46:
        r111 = r112;
    L47:
        r105.setParameter("http.route.default-proxy", r111);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        HttpHost r106 = this.f25061k;     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r106 != null) goto L52;
        URL r107 = h();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        HttpHost r108 = new HttpHost(r107.getHost(), g(), r107.getProtocol());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        this.f25061k = r108;     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        r106 = r108;
    L52:
        if (g() != 80) goto L54;
        r106 = new HttpHost(h().getHost());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L54:
        HttpResponse r109 = this.f25052a.a().execute(r106, this.f25056f, this.f25057g);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        this.f25052a.b(System.currentTimeMillis() - r104);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        List<Cookie> r113 = this.f25058h.getCookies();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (this.f25054c.e() == false) goto L58;
        i().removeAllCookie();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L58:
        if (r113.isEmpty() == true) goto L69;
        Iterator<Cookie> r114 = r113.iterator();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L61:
        if (r114.hasNext() == false) goto L69;
        Cookie r115 = r114.next();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r115.getDomain() == null) goto L61;
        StringBuilder r116 = new StringBuilder();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        r116.append(r115.getName());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        r116.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        r116.append(r115.getValue());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        r116.append("; domain=");     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        r116.append(r115.getDomain());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r115.isSecure() == false) goto L67;
        String r117 = "; Secure";
    L68:
        r116.append(r117);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        i().setCookie(this.f25054c.a(), r116.toString());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        CookieSyncManager.getInstance().sync();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        goto L61
    L67:
        r117 = "";
    L69:
        int r118 = r109.getStatusLine().getStatusCode();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        String r119 = r109.getStatusLine().getReasonPhrase();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r118 != 200) goto L72;
    L79:
        u r120 = a(r109, r118, r119);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r120 != null) goto L82;
    L84:
        long r121 = -1;
    L86:
        if (r121 != (-1)) goto L92;
        if ((r120 instanceof p) == false) goto L92;
        CastLongProtector.parseLong(((p) r120).a().getHead("Content-Length"));     // Catch: Exception -> L180
    L92:
        if (this.f25054c.a() != null) goto L94;
    L96:
        return r120;
    L94:
        if (TextUtils.isEmpty(f()) == true) goto L96;
        f();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        goto L96
    L82:
        if (r120.b() == null) goto L84;
        r121 = r120.b().length;     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        goto L86
    L72:
        if (r118 == 304) goto L75;
        r101 = false;
    L75:
        if (r101 == true) goto L79;
        throw new HttpException(Integer.valueOf(r109.getStatusLine().getStatusCode()), r109.getStatusLine().getReasonPhrase());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L42:
        if (TextUtils.equals(r112.getHostName(), "127.0.0.1") == false) goto L46;
        if (r112.getPort() != 8087) goto L46;
    L35:
        if (r110.isAvailable() == false) goto L39;
        String r122 = Proxy.getDefaultHost();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        int r123 = Proxy.getDefaultPort();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r122 == null) goto L39;
        r112 = new HttpHost(r122, r123);     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        goto L40
    L21:
        if (r103.isEmpty() == true) goto L26;
        Iterator<Header> r124 = r103.iterator();     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L24:
        if (r124.hasNext() == false) goto L26;
        c().addHeader(r124.next());     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        goto L24
    L98:
        throw new HttpException(1, "The network is not available");     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L7:
        int r125 = r100.length;     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        int r126 = 0;
    L8:
        if (r126 >= r125) goto L6;
        NetworkInfo r127 = r100[r126];     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
        if (r127 == null) goto L16;
        if (r127.isAvailable() == false) goto L16;
        if (r127.isConnectedOrConnecting() == false) goto L16;
        r102 = true;
    L16:
        r126 = r126 + 1;     // Catch: Exception -> L99 NullPointerException -> L105 IOException -> L111 UnknownHostException -> L117 HttpHostConnectException -> L123 NoHttpResponseException -> L129 SocketTimeoutException -> L135 ConnectTimeoutException -> L141 ConnectionPoolTimeoutException -> L147 SSLException -> L153 SSLPeerUnverifiedException -> L159 SSLHandshakeException -> L165 URISyntaxException -> L171 HttpException -> L174
    L174:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L178;
        e.getCode();
        e.getMsg();
    L178:
        e.toString();
        throw e;
    L105:
        e = move-exception;
        e();
        int r128 = this.f25063m;
        if (r128 > 0) goto L109;
        this.f25063m = r128 + 1;
        goto L183
    L109:
        e.toString();
        throw new HttpException(0, String.valueOf(e));
    L135:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L139;
        e.toString();
    L139:
        e.toString();
        throw new HttpException(4, String.valueOf(e));
    L171:
        e = move-exception;
        throw new RuntimeException("Url parser error!", e.getCause());
    L117:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L121;
        e.toString();
    L121:
        e.toString();
        throw new HttpException(9, String.valueOf(e));
    L165:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L169;
        e.toString();
    L169:
        e.toString();
        throw new HttpException(2, String.valueOf(e));
    L159:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L163;
        e.toString();
    L163:
        e.toString();
        throw new HttpException(2, String.valueOf(e));
    L153:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L157;
        e.toString();
    L157:
        e.toString();
        throw new HttpException(6, String.valueOf(e));
    L129:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L133;
        e.toString();
    L133:
        e.toString();
        throw new HttpException(5, String.valueOf(e));
    L147:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L151;
        e.toString();
    L151:
        e.toString();
        throw new HttpException(3, String.valueOf(e));
    L141:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L145;
        e.toString();
    L145:
        e.toString();
        throw new HttpException(3, String.valueOf(e));
    L123:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L128;
        e.toString();
    L128:
        throw new HttpException(8, String.valueOf(e));
    L111:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L115;
        e.toString();
    L115:
        e.toString();
        throw new HttpException(6, String.valueOf(e));
    L99:
        e = move-exception;
        e();
        if (this.f25054c.f() == null) goto L104;
        e.toString();
    L104:
        throw new HttpException(0, String.valueOf(e));
    }

    private void e() {
        HttpUriRequest r100 = this.f25056f;
        if (r100 == null) goto L6;
        r100.abort();
        return;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f25067q) == false) goto L5;
        String r100 = this.f25054c.b("operationType");
        this.f25067q = r100;
        return r100;
    L5:
        return this.f25067q;
    }

    private int g() {
        URL r100 = h();
        if (r100.getPort() != (-1)) goto L7;
        return r100.getDefaultPort();
    L7:
        return r100.getPort();
    }

    private URL h() {
        URL r100 = this.f25062l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        URL r101 = new URL(this.f25054c.a());
        this.f25062l = r101;
        return r101;
    }

    private CookieManager i() {
        CookieManager r100 = this.f25059i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CookieManager r101 = CookieManager.getInstance();
        this.f25059i = r101;
        return r101;
    }

    public final o a() {
        return this.f25054c;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ u call() {
        return d();
    }
}
