package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class v7 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static SoftReference<SSLContext> f28196s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static SoftReference<w7> f28197t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f28198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLContext f28199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Proxy f28200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f28201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f28202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f28203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private r7.a f28205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f28206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f28207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f28208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f28209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f28210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f28211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f28212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f28213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f28214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private f f28215r;

    public static class a implements Cloneable, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f28217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f28218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f28219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f28220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f28221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f28222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f28223h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile AtomicInteger f28224i;

        public String b() {
            String r100 = this.f28220e + "#";     // Catch: Exception -> L22
            if (TextUtils.isEmpty(this.f28219d) == true) goto L7;
            String r101 = r100 + this.f28219d + "#";     // Catch: Exception -> L22
        L8:
            String r102 = (r101 + this.f28222g + "#") + this.f28224i + "#";     // Catch: Exception -> L22
            if (TextUtils.isEmpty(this.f28216a) == true) goto L11;
            String r103 = r102 + this.f28216a + "#";     // Catch: Exception -> L22
        L13:
            if (this.f28220e != 1) goto L15;
            String r104 = r103 + this.f28218c + "#";     // Catch: Exception -> L22
        L17:
            if (this.f28220e != 1) goto L19;
            String r105 = r104 + this.f28223h + "#";     // Catch: Exception -> L22
        L20:
            String r106 = (r105 + this.f28217b + "#") + this.f28221f;     // Catch: Exception -> L22
            String r107 = q5.c(n7.a(r106.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Exception -> L22
            v7.a("上报异常数据" + r106 + "加密后：" + r107);     // Catch: Exception -> L22
            return r107;
        L19:
            r105 = r104 + "-#";     // Catch: Exception -> L22
            goto L20
        L15:
            r104 = r103 + "-#";     // Catch: Exception -> L22
            goto L17
        L11:
            r103 = r102 + "-#";     // Catch: Exception -> L22
            goto L13
        L7:
            r101 = r100 + "-#";     // Catch: Exception -> L22
        L22:
            return null;
        }

        public a a() {
            return (a) super.clone();
        L4:
            return null;
        }

        public Object clone() throws CloneNotSupportedException {
            return (a) super.clone();
        L4:
            return null;
        }

        public a(c r100) {
            this.f28216a = r100.f28229c;
            this.f28217b = r100.f28231e;
            this.f28219d = r100.f28230d;
            this.f28220e = r100.f28239m;
            this.f28221f = r100.f28240n;
            this.f28222g = r100.f28228b.a();
            this.f28218c = r100.f28227a;
            this.f28223h = r100.f28232f;
            this.f28224i = new AtomicInteger(1);
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r100) {
            ((a) r100).getClass();
            return 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpURLConnection f28225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f28226b;

        public b(HttpURLConnection r100) {
            this.f28225a = r100;
            this.f28226b = this.f28226b;
        }
    }

    public static class c implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y7.b f28228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f28229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f28230d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f28231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f28232f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f28233g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f28234h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f28235i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f28236j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f28237k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f28238l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f28239m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f28240n;

        public String b() {
            if (TextUtils.isEmpty(this.f28229c) == true) goto L5;
            String r100 = this.f28229c + "#";
        L7:
            if (TextUtils.isEmpty(this.f28230d) == true) goto L9;
            String r101 = r100 + this.f28230d + "#";
        L10:
            String r102 = (((r101 + this.f28228b.a() + "#") + this.f28234h + "#") + this.f28236j + "#") + this.f28232f;
            String r103 = q5.c(n7.a(r102.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            v7.a("上报耗时数据" + r102 + "加密后：" + r103);
            return r103;
        L9:
            r101 = r100 + "-#";
            goto L10
        L5:
            r100 = "-#";
            goto L7
        }

        public String toString() {
            return "RequestInfo{csid='" + this.f28227a + "', degradeType=" + this.f28228b + ", serverIp='" + this.f28229c + "', path='" + this.f28230d + "', hostname='" + this.f28231e + "', totalTime=" + this.f28232f + ", DNSTime=" + this.f28233g + ", connectionTime=" + this.f28234h + ", writeTime=" + this.f28235i + ", readTime=" + this.f28236j + ", serverTime='" + this.f28237k + "', datasize='" + this.f28238l + "', errorcode=" + this.f28239m + ", errorcodeSub=" + this.f28240n + '}';
        }

        public c() {
            this.f28227a = "";
            this.f28228b = y7.b.f28458b;
            this.f28229c = "";
            this.f28230d = "";
            this.f28231e = "";
            this.f28232f = 0;
            this.f28233g = 0;
            this.f28234h = 0;
            this.f28235i = 0;
            this.f28236j = 0;
            this.f28237k = "-";
            this.f28238l = "-";
            this.f28239m = 0;
            this.f28240n = 0;
        }

        public c a() {
            return (c) super.clone();
        L4:
            return null;
        }

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return a();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Vector<e> f28241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile e f28242b;

        private d() {
            this.f28241a = new Vector();
            this.f28242b = new e(0);
        }

        public /* synthetic */ d(byte r100) {
            this();
        }

        public final e a(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            byte r101 = 0;
            int r102 = 0;
        L8:
            if (r102 >= this.f28241a.size()) goto L15;
            e r103 = this.f28241a.get(r102);
            if (r103 == null) goto L14;
            if (r103.a().equals(r100) == false) goto L14;
            return r103;
        L14:
            r102 = r102 + 1;
            goto L8
        L15:
            e r104 = new e(r101);
            r104.b(r100);
            this.f28241a.add(r104);
            return r104;
        L5:
            return this.f28242b;
        }
    }

    public static class e implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f28244b;

        private e() {
        }

        public final String a() {
            return this.f28244b;
        }

        public /* synthetic */ e(byte r100) {
            this();
        }

        public final void a(String r100) {
            if (TextUtils.isEmpty(this.f28243a) == false) goto L5;
        L12:
            this.f28243a = r100;
            return;
        L5:
            if (r100.contains(":") == false) goto L12;
            String[] r101 = r100.split(":");
            if (r101 == null) goto L12;
            if (r101.length <= 0) goto L12;
            this.f28243a = r101[0];
        }

        public final void b(String r100) {
            this.f28244b = r100;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r100, SSLSession r101) {
            HostnameVerifier r102 = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.f28243a) == true) goto L7;
            return this.f28243a.equals(r100);
        L7:
            if (TextUtils.isEmpty(this.f28244b) == true) goto L11;
            return r102.verify(this.f28244b, r101);
        L11:
            return r102.verify(r100, r101);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f28245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f28246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f28247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a f28248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f28249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f28250f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        URL f28251g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ v7 f28252h;

        public final void a() {
            c r100 = this.f28247c;
            r100.f28234h = SystemClock.elapsedRealtime() - this.f28246b;
        }

        public final void b() {
            c r100 = this.f28247c;
            r100.f28235i = SystemClock.elapsedRealtime() - this.f28246b;
        }

        public final void c() {
            c r100 = this.f28247c;
            r100.f28236j = SystemClock.elapsedRealtime() - this.f28246b;
        }

        public final void d() {
            c r100 = this.f28247c.a();
            if (this.f28247c.f28232f <= m5.f27576o) goto L5;
            r100.f28239m = 1;
        L5:
            if (r100 != null) goto L7;
            return;
        L7:
            if (m5.f27564c == null) goto L18;
            HashMap r101 = new HashMap();
            r101.put("serverip", r100.f28229c);
            r101.put("hostname", r100.f28231e);
            r101.put("path", r100.f28230d);
            r101.put("csid", r100.f28227a);
            r101.put("degrade", String.valueOf(r100.f28228b.a()));
            r101.put("errorcode", String.valueOf(r100.f28239m));
            r101.put("errorsubcode", String.valueOf(r100.f28240n));
            r101.put("connecttime", String.valueOf(r100.f28234h));
            r101.put("writetime", String.valueOf(r100.f28235i));
            r101.put("readtime", String.valueOf(r100.f28236j));
            r101.put("datasize", String.valueOf(r100.f28238l));
            r101.put("totaltime", String.valueOf(r100.f28232f));
            String r102 = new JSONObject(r101).toString();
            v7.a("--埋点--".concat(String.valueOf(r102)));
            if (TextUtils.isEmpty(r102) == true) goto L19;
            h8 r103 = new h8(m5.f27564c, "core", EventConstant.Value.AUTH_VERSION_2, "O008");     // Catch: k5 -> L14
            r103.a(r102);     // Catch: k5 -> L14
            i8.a(r103, m5.f27564c);     // Catch: k5 -> L14
            return;
        L20:
            return;
        L19:
            return;
        }

        public f(v7 r100) {
            this.f28252h = r100;
            this.f28245a = 0;
            this.f28246b = 0;
            this.f28247c = new c();
        }

        public final void a(int r100) {
            v7.a("----errorcode-----".concat(String.valueOf(r100)));
            this.f28247c.f28232f = SystemClock.elapsedRealtime() - this.f28245a;     // Catch: Throwable -> L21
            c r101 = this.f28247c;     // Catch: Throwable -> L21
            r101.f28239m = r100;     // Catch: Throwable -> L21
            if (r101.f28228b.d() == false) goto L6;
            m5.a(false, this.f28247c.f28231e);     // Catch: Throwable -> L21
        L6:
            boolean r102 = v7.a(this.f28252h, this.f28247c.f28231e);     // Catch: Throwable -> L21
            if (r102 == true) goto L9;
        L19:
            m5.a(this.f28251g.toString(), this.f28247c.f28228b.b(), true, r102);     // Catch: Throwable -> L21
            v7.a("!!!error-" + this.f28247c.toString());     // Catch: Throwable -> L21
            return;
        L9:
            if (v7.b(this.f28252h) == false) goto L16;
            if (TextUtils.isEmpty(v7.a(this.f28252h)) == true) goto L16;
            if (this.f28247c.f28228b.e() == false) goto L16;
            m5.b();     // Catch: Throwable -> L21
        L16:
            if (this.f28247c.f28228b.b() == false) goto L18;
            m5.a(this.f28247c.f28228b.b(), this.f28247c.f28231e);     // Catch: Throwable -> L21
        L18:
            m5.b(this.f28249e);     // Catch: Throwable -> L21
            m5.a(false, this.f28248d);     // Catch: Throwable -> L21
            m5.a(this.f28247c);     // Catch: Throwable -> L21
        }

        public final void b(int r100) {
            this.f28247c.f28240n = r100;
        }

        public final void a(z7 r100) {
            this.f28247c.f28232f = SystemClock.elapsedRealtime() - this.f28245a;     // Catch: Throwable -> L22
            if (r100 == null) goto L6;
            this.f28247c.f28228b.b();     // Catch: Throwable -> L22
        L6:
            if (this.f28247c.f28228b.e() == false) goto L11;
            c r101 = this.f28247c;     // Catch: Throwable -> L22
            if (r101.f28232f <= 10000) goto L11;
            m5.a(false, r101.f28231e);     // Catch: Throwable -> L22
        L11:
            if (this.f28247c.f28228b.c() == false) goto L13;
            m5.a(false, this.f28250f);     // Catch: Throwable -> L22
        L13:
            boolean r102 = v7.a(this.f28252h, this.f28247c.f28231e);     // Catch: Throwable -> L22
            if (r102 == false) goto L20;
            m5.b(this.f28247c);     // Catch: Throwable -> L22
            m5.a(true, this.f28248d);     // Catch: Throwable -> L22
            c r103 = this.f28247c;     // Catch: Throwable -> L22
            if (r103.f28232f <= m5.f27576o) goto L20;
            c r104 = r103.a();     // Catch: Throwable -> L22
            if (r104 == null) goto L20;
            r104.f28239m = 1;     // Catch: Throwable -> L22
            m5.a(r104);     // Catch: Throwable -> L22
            v7.a("!!!finish&error-" + r104.toString());     // Catch: Throwable -> L22
        L20:
            m5.a(this.f28251g.toString(), this.f28247c.f28228b.b(), false, r102);     // Catch: Throwable -> L22
            v7.a("!!!finish-" + this.f28247c.toString());     // Catch: Throwable -> L22
            return;
        }

        public final void a(long r100) {
            DecimalFormat r101 = new DecimalFormat("0.00");
            this.f28247c.f28238l = r101.format(r100 / 1024.0f);
        }
    }

    public final void a() {
        this.f28201d = true;
    }

    public v7() {
        this.f28201d = false;
        this.f28202e = -1;
        this.f28203f = 0;
        this.f28207j = "";
        this.f28211n = false;
        this.f28212o = false;
        this.f28213p = false;
        this.f28214q = "";
        this.f28215r = new f(this);
        m5.g();
        this.f28204g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        p6.a(th, "ht", "ic");
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_amap_api_mapcore_util_v7_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private void d(y7 r100) throws k5 {
        this.f28206i = new d(0);
        this.f28212o = r100.isIPV6Request();
        this.f28200c = r100.getProxy();
        this.f28205h = r100.getUrlConnectionImpl();
        this.f28208k = r100.isBinary();
        this.f28207j = r100.parseSdkNameFromRequest();
        this.f28198a = r5.a().a(r100.isHttps());
        if (r100.getDegradeType().e() == false) goto L5;
        String r101 = r100.b();
    L6:
        this.f28209l = r101;
        String r102 = u7.b(r101, this.f28207j);
        this.f28209l = r102;
        a("restrictionURLTest: ".concat(String.valueOf(r102)));
        if (b8.a().a(r102) == true) goto L22;
        this.f28213p = r100.isTLSv3();
        this.f28210m = r100.getIPDNSName();
        if ("loc".equals(this.f28207j) == false) goto L29;
        String r103 = r100.a();
        String r104 = r100.b();
        if (TextUtils.isEmpty(r103) == true) goto L16;
        new URL(r103).getHost();     // Catch: Exception -> L14
    L16:
        if (TextUtils.isEmpty(r104) == true) goto L30;
        if (TextUtils.isEmpty(this.f28210m) == true) goto L20;
        return;
    L20:
        new URL(r104).getHost();     // Catch: Exception -> L24
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L22:
        a("restriction hit: ".concat(String.valueOf(r102)));
        throw new k5("限制访问的接口");
    L5:
        r101 = r100.a();
        goto L6
    }

    public final Map<String, String> a(y7 r110) throws k5 {
        a("makeGetRequestForHeaders");
        HttpURLConnection r100 = null;
        d(r110);     // Catch: Throwable -> L39 k5 -> L42 IOException -> L76 InterruptedIOException -> L77 SocketTimeoutException -> L49 SocketException -> L52 UnknownHostException -> L78 MalformedURLException -> L79 ConnectTimeoutException -> L59 SSLException -> L62 ConnectException -> L65
        this.f28209l = a(this.f28209l, r110.getParams());     // Catch: Throwable -> L39 k5 -> L42 IOException -> L76 InterruptedIOException -> L77 SocketTimeoutException -> L49 SocketException -> L52 UnknownHostException -> L78 MalformedURLException -> L79 ConnectTimeoutException -> L59 SSLException -> L62 ConnectException -> L65
        int r101 = 0;
        HttpURLConnection r111 = a(r110, false, false).f28225a;     // Catch: Throwable -> L39 k5 -> L42 IOException -> L76 InterruptedIOException -> L77 SocketTimeoutException -> L49 SocketException -> L52 UnknownHostException -> L78 MalformedURLException -> L79 ConnectTimeoutException -> L59 SSLException -> L62 ConnectException -> L65
    L86:
        f r112 = this.f28215r;     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        r112.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        r111.connect();     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        this.f28215r.a();     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        int r113 = r111.getResponseCode();     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        if (r113 >= 400) goto L19;
        HashMap r114 = new HashMap();     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
    L8:
        if (r101 >= 50) goto L12;
        String r115 = r111.getHeaderFieldKey(r101);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        if (r115 == null) goto L12;
        String r116 = r111.getHeaderField(r115);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        r114.put(r115.toLowerCase(), r116);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        r101 = r101 + 1;     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
    L12:
        this.f28215r.a(null);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        r111.disconnect();     // Catch: Throwable -> L15
    L17:
        this.f28215r.d();
        return r114;
    L15:
        th = move-exception;
        p6.a(th, "hth", "mgr");
        goto L17
    L19:
        this.f28215r.b(r113);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        this.f28215r.a(10);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        k5 r102 = new k5("http读取header失败");     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        r102.b(r113);     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
        throw r102;     // Catch: Throwable -> L21 k5 -> L23 IOException -> L25 InterruptedIOException -> L26 SocketTimeoutException -> L27 SocketException -> L29 UnknownHostException -> L31 MalformedURLException -> L32 ConnectTimeoutException -> L33 SSLException -> L35 ConnectException -> L37
    L23:
        e = e;
    L43:
        this.f28215r.a(e.a());     // Catch: Throwable -> L68
        throw e;     // Catch: Throwable -> L68
    L37:
        e = e;
    L66:
        f r117 = this.f28215r;     // Catch: Throwable -> L68
        r117.f28247c.f28240n = a(e);     // Catch: Throwable -> L68
        this.f28215r.a(6);     // Catch: Throwable -> L68
        throw new k5("http连接失败 - ConnectionException");     // Catch: Throwable -> L68
    L27:
        e = e;
    L50:
        f r118 = this.f28215r;     // Catch: Throwable -> L68
        r118.f28247c.f28240n = a(e);     // Catch: Throwable -> L68
        this.f28215r.a(2);     // Catch: Throwable -> L68
        throw new k5(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);     // Catch: Throwable -> L68
    L29:
        e = e;
    L53:
        f r119 = this.f28215r;     // Catch: Throwable -> L68
        r119.f28247c.f28240n = a(e);     // Catch: Throwable -> L68
        this.f28215r.a(6);     // Catch: Throwable -> L68
        throw new k5("socket 连接异常 - SocketException");     // Catch: Throwable -> L68
    L35:
        e = e;
    L63:
        e.printStackTrace();     // Catch: Throwable -> L68
        f r120 = this.f28215r;     // Catch: Throwable -> L68
        r120.f28247c.f28240n = a(e);     // Catch: Throwable -> L68
        this.f28215r.a(4);     // Catch: Throwable -> L68
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L68
    L33:
        e = e;
    L60:
        e.printStackTrace();     // Catch: Throwable -> L68
        f r121 = this.f28215r;     // Catch: Throwable -> L68
        r121.f28247c.f28240n = a(e);     // Catch: Throwable -> L68
        this.f28215r.a(2);     // Catch: Throwable -> L68
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L68
    L21:
        th = th;
    L40:
        this.f28215r.a(9);     // Catch: Throwable -> L68
        th.printStackTrace();     // Catch: Throwable -> L68
        throw new k5("未知的错误");     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        if (0 != 0) goto L83;
    L74:
        this.f28215r.d();
        throw th;
    L83:
        r100.disconnect();     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        p6.a(th, "hth", "mgr");
    L42:
        e = e;
    L65:
        e = e;
    L49:
        e = e;
    L52:
        e = e;
    L62:
        e = e;
    L59:
        e = e;
    L39:
        th = th;
    L47:
        f r122 = this.f28215r;     // Catch: Throwable -> L68
        r122.f28247c.f28240n = 7101;     // Catch: Throwable -> L68
        r122.a(7);     // Catch: Throwable -> L68
        throw new k5("未知的错误");     // Catch: Throwable -> L68
    L57:
        this.f28215r.a(8);     // Catch: Throwable -> L68
        throw new k5(AMapException.AMAP_CLIENT_URL_EXCEPTION);     // Catch: Throwable -> L68
    L55:
        this.f28215r.a(9);     // Catch: Throwable -> L68
        throw new k5(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);     // Catch: Throwable -> L68
    L45:
        this.f28215r.a(7);     // Catch: Throwable -> L68
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L68
    }

    public final z7 b(y7 r110) throws k5 {
        a("makeGetRequest");
        HttpURLConnection r100 = null;
        d(r110);     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        String r101 = a(this.f28209l, r110.getParams());     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        this.f28209l = r101;     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        z7 r102 = u7.a(r101, this.f28207j);     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        if (r102 == null) goto L8;
        this.f28215r.d();
        return r102;
    L8:
        b r103 = a(r110, false, true);     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        r100 = r103.f28225a;     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        f r111 = this.f28215r;     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        r111.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        r100.connect();     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        this.f28215r.a();     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        z7 r112 = a(r103, r110.isIgnoreGZip());     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
        this.f28215r.a(r112);     // Catch: Throwable -> L15 k5 -> L18 IOException -> L25 InterruptedIOException -> L27 SocketTimeoutException -> L29 SocketException -> L32 UnknownHostException -> L35 MalformedURLException -> L37 ConnectTimeoutException -> L39 SSLException -> L42 ConnectException -> L45
    L60:
        r100.disconnect();     // Catch: Throwable -> L11
    L13:
        this.f28215r.d();
        return r112;
    L11:
        th = move-exception;
        p6.a(th, "ht", "mgr");
    L48:
        th = move-exception;
        if (r100 != null) goto L58;
    L54:
        this.f28215r.d();
        throw th;
    L58:
        r100.disconnect();     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        p6.a(th, "ht", "mgr");
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L48
        this.f28215r.a(9);     // Catch: Throwable -> L48
        throw new k5("未知的错误");     // Catch: Throwable -> L48
    L37:
        this.f28215r.a(8);     // Catch: Throwable -> L48
        throw new k5(AMapException.AMAP_CLIENT_URL_EXCEPTION);     // Catch: Throwable -> L48
    L32:
        e = move-exception;
        f r104 = this.f28215r;     // Catch: Throwable -> L48
        r104.f28247c.f28240n = a(e);     // Catch: Throwable -> L48
        this.f28215r.a(6);     // Catch: Throwable -> L48
        throw new k5("socket 连接异常 - SocketException");     // Catch: Throwable -> L48
    L29:
        e = move-exception;
        f r105 = this.f28215r;     // Catch: Throwable -> L48
        r105.f28247c.f28240n = a(e);     // Catch: Throwable -> L48
        this.f28215r.a(2);     // Catch: Throwable -> L48
        throw new k5(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);     // Catch: Throwable -> L48
    L25:
        this.f28215r.a(7);     // Catch: Throwable -> L48
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L48
    L27:
        f r113 = this.f28215r;     // Catch: Throwable -> L48
        r113.f28247c.f28240n = 7101;     // Catch: Throwable -> L48
        r113.a(7);     // Catch: Throwable -> L48
        throw new k5("未知的错误");     // Catch: Throwable -> L48
    L35:
        this.f28215r.a(9);     // Catch: Throwable -> L48
        throw new k5(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);     // Catch: Throwable -> L48
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L48
        f r106 = this.f28215r;     // Catch: Throwable -> L48
        r106.f28247c.f28240n = a(e);     // Catch: Throwable -> L48
        this.f28215r.a(2);     // Catch: Throwable -> L48
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L48
    L45:
        e = move-exception;
        f r107 = this.f28215r;     // Catch: Throwable -> L48
        r107.f28247c.f28240n = a(e);     // Catch: Throwable -> L48
        this.f28215r.a(6);     // Catch: Throwable -> L48
        throw new k5("http连接失败 - ConnectionException");     // Catch: Throwable -> L48
    L18:
        e = move-exception;
        if (e.h() == false) goto L22;
    L24:
        throw e;     // Catch: Throwable -> L48
    L22:
        if (e.a() == 10) goto L24;
        this.f28215r.a(e.c());     // Catch: Throwable -> L48
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L48
        f r108 = this.f28215r;     // Catch: Throwable -> L48
        r108.f28247c.f28240n = a(e);     // Catch: Throwable -> L48
        this.f28215r.a(4);     // Catch: Throwable -> L48
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L48
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    public final z7 c(y7 r110) throws k5 {
        a("makePostReqeust");
        ?? r100 = 0;
        r100 = 0;
        d(r110);     // Catch: Throwable -> L63 k5 -> L66 IOException -> L105 InterruptedIOException -> L106 SocketTimeoutException -> L78 SocketException -> L81 UnknownHostException -> L107 MalformedURLException -> L108 ConnectTimeoutException -> L88 ConnectException -> L91 SSLException -> L94
        z7 r101 = u7.a(this.f28209l, this.f28207j);     // Catch: Throwable -> L63 k5 -> L66 IOException -> L105 InterruptedIOException -> L106 SocketTimeoutException -> L78 SocketException -> L81 UnknownHostException -> L107 MalformedURLException -> L108 ConnectTimeoutException -> L88 ConnectException -> L91 SSLException -> L94
        if (r101 == null) goto L8;
        this.f28215r.d();
        return r101;
    L8:
        b r102 = a(r110, true, true);     // Catch: Throwable -> L63 k5 -> L66 IOException -> L105 InterruptedIOException -> L106 SocketTimeoutException -> L78 SocketException -> L81 UnknownHostException -> L107 MalformedURLException -> L108 ConnectTimeoutException -> L88 ConnectException -> L91 SSLException -> L94
        HttpURLConnection r103 = r102.f28225a;     // Catch: Throwable -> L63 k5 -> L66 IOException -> L105 InterruptedIOException -> L106 SocketTimeoutException -> L78 SocketException -> L81 UnknownHostException -> L107 MalformedURLException -> L108 ConnectTimeoutException -> L88 ConnectException -> L91 SSLException -> L94
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        r103.connect();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        this.f28215r.a();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        byte[] r111 = r110.getEntityBytes();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        if (r111 != null) goto L12;
    L13:
        String r112 = a(r110.getParams());     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        if (TextUtils.isEmpty(r112) == true) goto L16;
        r111 = x5.e(r112);     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
    L16:
        if (r111 != null) goto L18;
    L38:
        z7 r113 = a(r102, r110.isIgnoreGZip());     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        this.f28215r.a(r113);     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        this.f28215r.f28247c.toString();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        r103.disconnect();     // Catch: Throwable -> L41
    L43:
        this.f28215r.d();
        return r113;
    L41:
        th = move-exception;
        p6.a(th, "ht", "mPt");
        goto L43
    L18:
        if (r111.length <= 0) goto L38;
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L30
        OutputStream r114 = r103.getOutputStream();     // Catch: Throwable -> L30
        DataOutputStream r115 = new DataOutputStream(r114);     // Catch: Throwable -> L28
        r115.write(r111);     // Catch: Throwable -> L26
        r115.close();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        if (r114 == null) goto L25;
        r114.close();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
    L25:
        this.f28215r.b();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
    L26:
        th = th;
        r100 = r115;
    L32:
        if (r100 == 0) goto L34;
        r100.close();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
    L34:
        if (r114 == null) goto L36;
        r114.close();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
    L36:
        this.f28215r.b();     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
        throw th;     // Catch: Throwable -> L45 k5 -> L47 IOException -> L49 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L56 ConnectTimeoutException -> L57 ConnectException -> L59 SSLException -> L61
    L28:
        th = th;
    L30:
        th = th;
        r114 = null;
        goto L32
    L12:
        if (r111.length != 0) goto L16;
    L47:
        e = e;
    L68:
        if (e.h() == false) goto L70;
    L72:
        p6.a(e, "ht", "mPt");     // Catch: Throwable -> L97
        throw e;     // Catch: Throwable -> L97
    L70:
        if (e.a() == 10) goto L72;
        this.f28215r.a(e.a());     // Catch: Throwable -> L97
    L57:
        e = e;
    L89:
        this.f28215r.f28247c.f28240n = a(e);     // Catch: Throwable -> L97
        this.f28215r.a(2);     // Catch: Throwable -> L97
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L97
    L59:
        e = e;
    L92:
        this.f28215r.f28247c.f28240n = a(e);     // Catch: Throwable -> L97
        this.f28215r.a(6);     // Catch: Throwable -> L97
        throw new k5("http连接失败 - ConnectionException");     // Catch: Throwable -> L97
    L53:
        e = e;
    L82:
        this.f28215r.f28247c.f28240n = a(e);     // Catch: Throwable -> L97
        this.f28215r.a(6);     // Catch: Throwable -> L97
        throw new k5("socket 连接异常 - SocketException");     // Catch: Throwable -> L97
    L51:
        e = e;
    L79:
        this.f28215r.f28247c.f28240n = a(e);     // Catch: Throwable -> L97
        this.f28215r.a(2);     // Catch: Throwable -> L97
        throw new k5(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);     // Catch: Throwable -> L97
    L61:
        e = e;
    L95:
        this.f28215r.f28247c.f28240n = a(e);     // Catch: Throwable -> L97
        this.f28215r.a(4);     // Catch: Throwable -> L97
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L97
    L45:
        th = th;
    L64:
        p6.a(th, "ht", "mPt");     // Catch: Throwable -> L97
        this.f28215r.a(9);     // Catch: Throwable -> L97
        throw new k5("未知的错误");     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        if (0 != 0) goto L112;
    L103:
        this.f28215r.d();
        throw th;
    L112:
        r100.disconnect();     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        p6.a(th, "ht", "mPt");
    L66:
        e = e;
    L91:
        e = e;
    L81:
        e = e;
    L78:
        e = e;
    L94:
        e = e;
    L88:
        e = e;
    L63:
        th = th;
    L76:
        f r116 = this.f28215r;     // Catch: Throwable -> L97
        r116.f28247c.f28240n = 7101;     // Catch: Throwable -> L97
        r116.a(7);     // Catch: Throwable -> L97
        throw new k5("未知的错误");     // Catch: Throwable -> L97
    L86:
        this.f28215r.a(8);     // Catch: Throwable -> L97
        throw new k5(AMapException.AMAP_CLIENT_URL_EXCEPTION);     // Catch: Throwable -> L97
    L84:
        this.f28215r.a(5);     // Catch: Throwable -> L97
        throw new k5(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);     // Catch: Throwable -> L97
    L74:
        this.f28215r.a(7);     // Catch: Throwable -> L97
        throw new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L97
    }

    public static String a(Map<String, String> r100) {
        if (r100 == null) goto L15;
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        if (r101.length() <= 0) goto L12;
        r101.append("&");
    L12:
        r101.append(URLEncoder.encode(r104));
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(URLEncoder.encode(r105));
        goto L5
    L14:
        return r101.toString();
    L15:
        return null;
    }

    private static String b(Map<String, List<String>> r100) {
        List<String> r101 = r100.get(SRStrategy.KEY_SR_STRATEGY_CONFIG);     // Catch: Throwable -> L18
        if (r101 == null) goto L16;
        if (r101.size() <= 0) goto L16;
        String r102 = r101.get(0);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r102) == true) goto L16;
        if (r102.contains("#") == false) goto L21;
        String[] r103 = r102.split("#");     // Catch: Throwable -> L18
        if (r103.length <= 1) goto L16;
        return r103[0];
    L21:
        return r102;
    L16:
        return "";
    }

    private static boolean c(String r100) {
        if (r100.contains("rest") == false) goto L5;
        return true;
    L5:
        if (r100.contains("apilocate") == true) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean b(String r100) {
        if (this.f28208k == false) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(this.f28210m) == true) goto L11;
        if (this.f28210m.contains("rest") == false) goto L9;
        return true;
    L9:
        if (this.f28210m.contains("apilocate") == false) goto L11;
        return true;
    L11:
        if (c(r100) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public int a(Exception r100) {
        if ((r100 instanceof SSLHandshakeException) == false) goto L7;
        return 4101;
    L7:
        if ((r100 instanceof SSLKeyException) == false) goto L11;
        return 4102;
    L11:
        if ((r100 instanceof SSLProtocolException) == false) goto L15;
        return 4103;
    L15:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L19;
        return 4104;
    L19:
        if ((r100 instanceof ConnectException) == false) goto L23;
        return 6101;
    L23:
        if ((r100 instanceof SocketException) == false) goto L27;
        return 6102;
    L27:
        if ((r100 instanceof ConnectTimeoutException) == false) goto L31;
        return 2101;
    L31:
        if ((r100 instanceof SocketTimeoutException) == false) goto L34;
        return DataLoaderHelper.DATALOADER_KEY_INT_DEV_DISK_SIZE_MB;
    L34:
        return 0;
    }

    private static String a(HttpURLConnection r100) {
        Map<String, List<String>> r101 = r100.getHeaderFields();     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
        return "";
    L6:
        List<String> r102 = r101.get("gsid");     // Catch: Throwable -> L13
        if (r102 == null) goto L12;
        if (r102.size() <= 0) goto L12;
        return r102.get(0);
    L12:
        return "";
    }

    public final void b(long r100) {
        this.f28202e = r100;
    }

    public static void a(String r100) {
        n0.a("httpUrlutil", r100, false);
    }

    public static /* synthetic */ boolean b(v7 r100) {
        return r100.f28212o;
    }

    public static /* synthetic */ String a(v7 r100) {
        return r100.f28210m;
    }

    public final void a(long r100) {
        this.f28203f = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v28 */
    /* JADX WARN: Type inference failed for: r16v29 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v30 */
    /* JADX WARN: Type inference failed for: r16v31 */
    /* JADX WARN: Type inference failed for: r16v32 */
    /* JADX WARN: Type inference failed for: r16v33 */
    /* JADX WARN: Type inference failed for: r16v34 */
    /* JADX WARN: Type inference failed for: r16v35 */
    /* JADX WARN: Type inference failed for: r16v36 */
    /* JADX WARN: Type inference failed for: r16v37 */
    /* JADX WARN: Type inference failed for: r16v38 */
    /* JADX WARN: Type inference failed for: r16v39 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v40 */
    /* JADX WARN: Type inference failed for: r16v41 */
    /* JADX WARN: Type inference failed for: r16v42 */
    /* JADX WARN: Type inference failed for: r16v43 */
    /* JADX WARN: Type inference failed for: r16v44 */
    /* JADX WARN: Type inference failed for: r16v45 */
    /* JADX WARN: Type inference failed for: r16v46 */
    /* JADX WARN: Type inference failed for: r16v47 */
    /* JADX WARN: Type inference failed for: r16v48 */
    /* JADX WARN: Type inference failed for: r16v49 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v50 */
    /* JADX WARN: Type inference failed for: r16v51 */
    /* JADX WARN: Type inference failed for: r16v52 */
    /* JADX WARN: Type inference failed for: r16v53 */
    /* JADX WARN: Type inference failed for: r16v54 */
    /* JADX WARN: Type inference failed for: r16v55 */
    /* JADX WARN: Type inference failed for: r16v56 */
    /* JADX WARN: Type inference failed for: r16v57 */
    /* JADX WARN: Type inference failed for: r16v58 */
    /* JADX WARN: Type inference failed for: r16v59 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v60 */
    /* JADX WARN: Type inference failed for: r16v61 */
    /* JADX WARN: Type inference failed for: r16v62 */
    /* JADX WARN: Type inference failed for: r16v63 */
    /* JADX WARN: Type inference failed for: r16v64 */
    /* JADX WARN: Type inference failed for: r16v65 */
    /* JADX WARN: Type inference failed for: r16v66 */
    /* JADX WARN: Type inference failed for: r16v67 */
    /* JADX WARN: Type inference failed for: r16v68 */
    /* JADX WARN: Type inference failed for: r16v69 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v70 */
    /* JADX WARN: Type inference failed for: r16v71 */
    /* JADX WARN: Type inference failed for: r16v72 */
    /* JADX WARN: Type inference failed for: r16v73 */
    /* JADX WARN: Type inference failed for: r16v74 */
    /* JADX WARN: Type inference failed for: r16v75 */
    /* JADX WARN: Type inference failed for: r16v76 */
    /* JADX WARN: Type inference failed for: r16v77 */
    /* JADX WARN: Type inference failed for: r16v78 */
    /* JADX WARN: Type inference failed for: r16v79 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v80 */
    /* JADX WARN: Type inference failed for: r16v81 */
    /* JADX WARN: Type inference failed for: r16v83 */
    /* JADX WARN: Type inference failed for: r16v84 */
    /* JADX WARN: Type inference failed for: r16v85 */
    /* JADX WARN: Type inference failed for: r16v86 */
    /* JADX WARN: Type inference failed for: r16v87 */
    /* JADX WARN: Type inference failed for: r16v88 */
    /* JADX WARN: Type inference failed for: r16v89 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r16v90 */
    /* JADX WARN: Type inference failed for: r16v91 */
    /* JADX WARN: Type inference failed for: r16v92 */
    /* JADX WARN: Type inference failed for: r16v93 */
    /* JADX WARN: Type inference failed for: r16v94 */
    /* JADX WARN: Type inference failed for: r16v95 */
    /* JADX WARN: Type inference failed for: r16v96 */
    /* JADX WARN: Type inference failed for: r16v97 */
    /* JADX WARN: Type inference failed for: r16v98 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.amap.api.mapcore.util.v7] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.amap.api.mapcore.util.t7$a] */
    /* JADX WARN: Type inference failed for: r7v100 */
    /* JADX WARN: Type inference failed for: r7v101 */
    /* JADX WARN: Type inference failed for: r7v102 */
    /* JADX WARN: Type inference failed for: r7v103 */
    /* JADX WARN: Type inference failed for: r7v104 */
    /* JADX WARN: Type inference failed for: r7v105 */
    /* JADX WARN: Type inference failed for: r7v106 */
    /* JADX WARN: Type inference failed for: r7v107 */
    /* JADX WARN: Type inference failed for: r7v108 */
    /* JADX WARN: Type inference failed for: r7v109 */
    /* JADX WARN: Type inference failed for: r7v110 */
    /* JADX WARN: Type inference failed for: r7v113 */
    /* JADX WARN: Type inference failed for: r7v114 */
    /* JADX WARN: Type inference failed for: r7v115 */
    /* JADX WARN: Type inference failed for: r7v116 */
    /* JADX WARN: Type inference failed for: r7v39, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r7v75, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r7v76 */
    /* JADX WARN: Type inference failed for: r7v77 */
    /* JADX WARN: Type inference failed for: r7v78 */
    /* JADX WARN: Type inference failed for: r7v79 */
    /* JADX WARN: Type inference failed for: r7v80 */
    /* JADX WARN: Type inference failed for: r7v81 */
    /* JADX WARN: Type inference failed for: r7v82 */
    /* JADX WARN: Type inference failed for: r7v83 */
    /* JADX WARN: Type inference failed for: r7v84 */
    /* JADX WARN: Type inference failed for: r7v85 */
    /* JADX WARN: Type inference failed for: r7v86 */
    /* JADX WARN: Type inference failed for: r7v87 */
    /* JADX WARN: Type inference failed for: r7v99 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v50 */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r8v52 */
    /* JADX WARN: Type inference failed for: r8v53 */
    /* JADX WARN: Type inference failed for: r8v54 */
    /* JADX WARN: Type inference failed for: r8v55 */
    /* JADX WARN: Type inference failed for: r8v56 */
    /* JADX WARN: Type inference failed for: r8v57 */
    /* JADX WARN: Type inference failed for: r8v58 */
    /* JADX WARN: Type inference failed for: r8v59 */
    /* JADX WARN: Type inference failed for: r8v60 */
    /* JADX WARN: Type inference failed for: r8v61, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v62 */
    /* JADX WARN: Type inference failed for: r8v63 */
    /* JADX WARN: Type inference failed for: r8v64 */
    /* JADX WARN: Type inference failed for: r8v65 */
    /* JADX WARN: Type inference failed for: r8v66 */
    /* JADX WARN: Type inference failed for: r8v67 */
    /* JADX WARN: Type inference failed for: r8v68 */
    /* JADX WARN: Type inference failed for: r8v69 */
    /* JADX WARN: Type inference failed for: r8v70 */
    /* JADX WARN: Type inference failed for: r8v71 */
    /* JADX WARN: Type inference failed for: r8v72 */
    public final void a(y7 r210, t7.a r211) {
        a("makeDownloadRequest");
        if (r211 != 0) goto L541;
        return;
    L541:
        d(r210);     // Catch: Throwable -> L245 k5 -> L263 IOException -> L281 InterruptedIOException -> L299 SocketTimeoutException -> L317 SocketException -> L335 UnknownHostException -> L353 MalformedURLException -> L371 ConnectTimeoutException -> L389 SSLException -> L407 ConnectException -> L425
        this.f28209l = a(this.f28209l, r210.getParams());     // Catch: Throwable -> L245 k5 -> L263 IOException -> L281 InterruptedIOException -> L299 SocketTimeoutException -> L317 SocketException -> L335 UnknownHostException -> L353 MalformedURLException -> L371 ConnectTimeoutException -> L389 SSLException -> L407 ConnectException -> L425
        byte[] r100 = r210.getEntityBytes();     // Catch: Throwable -> L245 k5 -> L263 IOException -> L281 InterruptedIOException -> L299 SocketTimeoutException -> L317 SocketException -> L335 UnknownHostException -> L353 MalformedURLException -> L371 ConnectTimeoutException -> L389 SSLException -> L407 ConnectException -> L425
        boolean r110 = true;
        if (r100 != null) goto L545;
    L33:
        boolean r111 = false;
    L34:
        HttpURLConnection r112 = a(r210, r111, false).f28225a;     // Catch: Throwable -> L245 k5 -> L263 IOException -> L281 InterruptedIOException -> L299 SocketTimeoutException -> L317 SocketException -> L335 UnknownHostException -> L353 MalformedURLException -> L371 ConnectTimeoutException -> L389 SSLException -> L407 ConnectException -> L425
    L543:
        r112.setRequestProperty("RANGE", "bytes=" + this.f28203f + "-");     // Catch: Throwable -> L223 k5 -> L225 IOException -> L227 InterruptedIOException -> L229 SocketTimeoutException -> L231 SocketException -> L233 UnknownHostException -> L235 MalformedURLException -> L237 ConnectTimeoutException -> L239 SSLException -> L241 ConnectException -> L243
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L223 k5 -> L225 IOException -> L227 InterruptedIOException -> L229 SocketTimeoutException -> L231 SocketException -> L233 UnknownHostException -> L235 MalformedURLException -> L237 ConnectTimeoutException -> L239 SSLException -> L241 ConnectException -> L243
        r112.connect();     // Catch: Throwable -> L223 k5 -> L225 IOException -> L227 InterruptedIOException -> L229 SocketTimeoutException -> L231 SocketException -> L233 UnknownHostException -> L235 MalformedURLException -> L237 ConnectTimeoutException -> L239 SSLException -> L241 ConnectException -> L243
        this.f28215r.a();     // Catch: Throwable -> L223 k5 -> L225 IOException -> L227 InterruptedIOException -> L229 SocketTimeoutException -> L231 SocketException -> L233 UnknownHostException -> L235 MalformedURLException -> L237 ConnectTimeoutException -> L239 SSLException -> L241 ConnectException -> L243
        if (r111 == true) goto L533;
        ?? r101 = 0;
    L531:
        String r102 = a(r112);     // Catch: Throwable -> L201 k5 -> L203 IOException -> L205 InterruptedIOException -> L207 SocketTimeoutException -> L209 SocketException -> L211 UnknownHostException -> L213 MalformedURLException -> L215 ConnectTimeoutException -> L217 SSLException -> L219 ConnectException -> L221
        int r103 = r112.getResponseCode();     // Catch: Throwable -> L201 k5 -> L203 IOException -> L205 InterruptedIOException -> L207 SocketTimeoutException -> L209 SocketException -> L211 UnknownHostException -> L213 MalformedURLException -> L215 ConnectTimeoutException -> L217 SSLException -> L219 ConnectException -> L221
        if (r103 == 200) goto L89;
        boolean r104 = true;
    L91:
        if (r103 != 206) goto L95;
        r110 = false;
    L95:
        if ((r104 & r110) == false) goto L103;
        this.f28215r.b(r103);     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        this.f28215r.a(10);     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        ?? r105 = "网络异常原因：" + r112.getResponseMessage() + " 网络异常状态码：" + r103;     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        r211.onException(new k5(r105, r102, this.f28204g));     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        r112.disconnect();     // Catch: Throwable -> L99
    L101:
        if (r101 == 0) goto L447;
        ?? r113 = r101;
    L482:
        r113.close();     // Catch: Throwable -> L445
    L486:
    L445:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L447:
        this.f28215r.d();
        return;
    L99:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L101
    L42:
        e = move-exception;
        k5 r106 = e;
        r113 = r101;
        r105 = 0;
    L266:
        this.f28215r.a(r106.a());     // Catch: Throwable -> L449
        r211.onException(r106);     // Catch: Throwable -> L449
        if (r105 != 0) goto L523;
    L274:
        if (r112 != null) goto L484;
    L279:
        if (r113 == 0) goto L486;
    L484:
        r112.disconnect();     // Catch: Throwable -> L277
    L277:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L279
    L523:
        r105.close();     // Catch: Throwable -> L270 IOException -> L272
    L272:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L270:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L48:
        e = move-exception;
        SocketTimeoutException r107 = e;
        r113 = r101;
        r105 = 0;
    L320:
        this.f28215r.b(a(r107));     // Catch: Throwable -> L449
        this.f28215r.a(2);     // Catch: Throwable -> L449
        r211.onException(r107);     // Catch: Throwable -> L449
        if (r105 != 0) goto L515;
    L328:
        if (r112 != null) goto L470;
    L333:
        if (r113 == 0) goto L486;
    L470:
        r112.disconnect();     // Catch: Throwable -> L331
    L331:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L333
    L515:
        r105.close();     // Catch: Throwable -> L324 IOException -> L326
    L326:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L324:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L46:
        e = move-exception;
        InterruptedIOException r108 = e;
        r113 = r101;
        r105 = 0;
    L302:
        this.f28215r.b(7101);     // Catch: Throwable -> L449
        this.f28215r.a(7);     // Catch: Throwable -> L449
        r211.onException(r108);     // Catch: Throwable -> L449
        if (r105 != 0) goto L527;
    L310:
        if (r112 != null) goto L501;
    L315:
        if (r113 == 0) goto L486;
    L501:
        r112.disconnect();     // Catch: Throwable -> L313
    L313:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L315
    L527:
        r105.close();     // Catch: Throwable -> L306 IOException -> L308
    L308:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L306:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L60:
        e = move-exception;
        ConnectException r109 = e;
        r113 = r101;
        r105 = 0;
    L428:
        this.f28215r.b(a(r109));     // Catch: Throwable -> L449
        this.f28215r.a(6);     // Catch: Throwable -> L449
        r211.onException(r109);     // Catch: Throwable -> L449
        if (r105 != 0) goto L519;
    L436:
        if (r112 != null) goto L480;
    L441:
        if (r113 == 0) goto L486;
    L480:
        r112.disconnect();     // Catch: Throwable -> L439
    L439:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L441
    L519:
        r105.close();     // Catch: Throwable -> L432 IOException -> L434
    L434:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L432:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L54:
        e = move-exception;
        MalformedURLException r114 = e;
        r113 = r101;
        r105 = 0;
    L374:
        this.f28215r.a(8);     // Catch: Throwable -> L449
        r211.onException(r114);     // Catch: Throwable -> L449
        if (r105 != 0) goto L517;
    L382:
        if (r112 != null) goto L499;
    L387:
        if (r113 == 0) goto L486;
    L499:
        r112.disconnect();     // Catch: Throwable -> L385
    L385:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L387
    L517:
        r105.close();     // Catch: Throwable -> L378 IOException -> L380
    L380:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L378:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L50:
        e = move-exception;
        SocketException r115 = e;
        r113 = r101;
        r105 = 0;
    L338:
        this.f28215r.b(a(r115));     // Catch: Throwable -> L449
        this.f28215r.a(6);     // Catch: Throwable -> L449
        r211.onException(r115);     // Catch: Throwable -> L449
        if (r105 != 0) goto L513;
    L346:
        if (r112 != null) goto L478;
    L351:
        if (r113 == 0) goto L486;
    L478:
        r112.disconnect();     // Catch: Throwable -> L349
    L349:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L351
    L513:
        r105.close();     // Catch: Throwable -> L342 IOException -> L344
    L344:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L342:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L52:
        e = move-exception;
        UnknownHostException r116 = e;
        r113 = r101;
        r105 = 0;
    L356:
        this.f28215r.a(5);     // Catch: Throwable -> L449
        r211.onException(r116);     // Catch: Throwable -> L449
        if (r105 != 0) goto L525;
    L364:
        if (r112 != null) goto L489;
    L369:
        if (r113 == 0) goto L486;
    L489:
        r112.disconnect();     // Catch: Throwable -> L367
    L367:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L369
    L525:
        r105.close();     // Catch: Throwable -> L360 IOException -> L362
    L362:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L360:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L58:
        e = move-exception;
        SSLException r117 = e;
        r113 = r101;
        r105 = 0;
    L410:
        r117.printStackTrace();     // Catch: Throwable -> L449
        this.f28215r.b(a(r117));     // Catch: Throwable -> L449
        this.f28215r.a(4);     // Catch: Throwable -> L449
        r211.onException(r117);     // Catch: Throwable -> L449
        if (r105 != 0) goto L509;
    L418:
        if (r112 != null) goto L474;
    L423:
        if (r113 == 0) goto L486;
    L474:
        r112.disconnect();     // Catch: Throwable -> L421
    L421:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L423
    L509:
        r105.close();     // Catch: Throwable -> L414 IOException -> L416
    L416:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L414:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L56:
        e = move-exception;
        ConnectTimeoutException r118 = e;
        r113 = r101;
        r105 = 0;
    L392:
        r118.printStackTrace();     // Catch: Throwable -> L449
        this.f28215r.b(a(r118));     // Catch: Throwable -> L449
        this.f28215r.a(2);     // Catch: Throwable -> L449
        r211.onException(r118);     // Catch: Throwable -> L449
        if (r105 != 0) goto L505;
    L400:
        if (r112 != null) goto L503;
    L405:
        if (r113 == 0) goto L486;
    L503:
        r112.disconnect();     // Catch: Throwable -> L403
    L403:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L405
    L505:
        r105.close();     // Catch: Throwable -> L396 IOException -> L398
    L398:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L396:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L44:
        e = move-exception;
        IOException r119 = e;
        r113 = r101;
        r105 = 0;
    L284:
        this.f28215r.a(7);     // Catch: Throwable -> L449
        r211.onException(r119);     // Catch: Throwable -> L449
        if (r105 != 0) goto L521;
    L292:
        if (r112 != null) goto L497;
    L297:
        if (r113 == 0) goto L486;
    L497:
        r112.disconnect();     // Catch: Throwable -> L295
    L295:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L297
    L521:
        r105.close();     // Catch: Throwable -> L288 IOException -> L290
    L290:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L288:
        th = move-exception;
        p6.a(th, "ht", "mdr");
    L40:
        th = move-exception;
        Throwable r120 = th;
        r113 = r101;
        r105 = 0;
    L248:
        this.f28215r.a(9);     // Catch: Throwable -> L449
        r211.onException(r120);     // Catch: Throwable -> L449
        if (r105 != 0) goto L511;
    L256:
        if (r112 != null) goto L476;
    L261:
        if (r113 == 0) goto L486;
    L476:
        r112.disconnect();     // Catch: Throwable -> L259
    L259:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L261
    L511:
        r105.close();     // Catch: Throwable -> L252 IOException -> L254
    L254:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L252:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L256
    L103:
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L201 k5 -> L203 IOException -> L205 InterruptedIOException -> L207 SocketTimeoutException -> L209 SocketException -> L211 UnknownHostException -> L213 MalformedURLException -> L215 ConnectTimeoutException -> L217 SSLException -> L219 ConnectException -> L221
        InputStream r121 = r112.getInputStream();     // Catch: Throwable -> L201 k5 -> L203 IOException -> L205 InterruptedIOException -> L207 SocketTimeoutException -> L209 SocketException -> L211 UnknownHostException -> L213 MalformedURLException -> L215 ConnectTimeoutException -> L217 SSLException -> L219 ConnectException -> L221
        r105 = 1024(0x400, float:1.435E-42);
        byte[] r122 = new byte[1024];     // Catch: Throwable -> L168 k5 -> L171 IOException -> L174 InterruptedIOException -> L177 SocketTimeoutException -> L180 SocketException -> L183 UnknownHostException -> L186 MalformedURLException -> L189 ConnectTimeoutException -> L192 SSLException -> L195 ConnectException -> L198
        int r123 = 0;
        r101 = r101;
    L107:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L124;
        if (this.f28201d == true) goto L124;
        int r124 = r121.read(r122, 0, 1024);     // Catch: Throwable -> L168 k5 -> L171 IOException -> L174 InterruptedIOException -> L177 SocketTimeoutException -> L180 SocketException -> L183 UnknownHostException -> L186 MalformedURLException -> L189 ConnectTimeoutException -> L192 SSLException -> L195 ConnectException -> L198
        if (r124 <= 0) goto L124;
        long r125 = this.f28202e;     // Catch: Throwable -> L168 k5 -> L171 IOException -> L174 InterruptedIOException -> L177 SocketTimeoutException -> L180 SocketException -> L183 UnknownHostException -> L186 MalformedURLException -> L189 ConnectTimeoutException -> L192 SSLException -> L195 ConnectException -> L198
    L114:
        if (r125 == (-1)) goto L119;
        r113 = r101;
    L148:
        e = e;
    L173:
        r105 = r121;
        r106 = e;
        r113 = r113;
    L152:
        e = e;
    L179:
        r105 = r121;
        r108 = e;
        r113 = r113;
    L166:
        e = e;
    L200:
        r105 = r121;
        r109 = e;
        r113 = r113;
    L160:
        e = e;
    L191:
        r105 = r121;
        r114 = e;
        r113 = r113;
    L156:
        e = e;
    L185:
        r105 = r121;
        r115 = e;
        r113 = r113;
    L154:
        e = e;
    L182:
        r105 = r121;
        r107 = e;
        r113 = r113;
    L158:
        e = e;
    L188:
        r105 = r121;
        r116 = e;
        r113 = r113;
    L164:
        e = e;
    L197:
        r105 = r121;
        r117 = e;
        r113 = r113;
    L162:
        e = e;
    L194:
        r105 = r121;
        r118 = e;
        r113 = r113;
    L150:
        e = e;
    L176:
        r105 = r121;
        r119 = e;
        r113 = r113;
    L146:
        th = th;
    L170:
        r105 = r121;
        r120 = th;
        r113 = r113;
        goto L248
    L117:
        if (this.f28203f >= r125) goto L125;
        ?? r126 = r113;
    L120:
        if (r124 != 1024) goto L122;
        r211.onDownload(r122, this.f28203f);     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
    L123:
        this.f28203f += (long) r124;     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        r123 = r123 + r124;     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        r101 = r126;
        goto L107
    L122:
        byte[] r127 = new byte[r124];     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        System.arraycopy(r122, 0, r127, 0, r124);     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        r211.onDownload(r127, this.f28203f);     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
    L125:
        this.f28215r.a(r123);     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        this.f28215r.c();     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L128;
    L131:
        r211.onStop();     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
    L132:
        this.f28215r.a(null);     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        if (r121 != null) goto L507;
    L472:
        r112.disconnect();     // Catch: Throwable -> L142
    L144:
        if (r113 == 0) goto L447;
    L142:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L144
    L507:
        r121.close();     // Catch: Throwable -> L136 IOException -> L138
    L138:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L136:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L472
    L128:
        if (this.f28201d == true) goto L131;
        r211.onFinish();     // Catch: Throwable -> L146 k5 -> L148 IOException -> L150 InterruptedIOException -> L152 SocketTimeoutException -> L154 SocketException -> L156 UnknownHostException -> L158 MalformedURLException -> L160 ConnectTimeoutException -> L162 SSLException -> L164 ConnectException -> L166
        goto L132
    L119:
        r126 = r101;
    L124:
        r113 = r101;
    L171:
        e = e;
        r113 = r101;
    L177:
        e = e;
        r113 = r101;
    L198:
        e = e;
        r113 = r101;
    L189:
        e = e;
        r113 = r101;
    L183:
        e = e;
        r113 = r101;
    L180:
        e = e;
        r113 = r101;
    L186:
        e = e;
        r113 = r101;
    L195:
        e = e;
        r113 = r101;
    L192:
        e = e;
        r113 = r101;
    L174:
        e = e;
        r113 = r101;
    L168:
        th = th;
        r113 = r101;
        goto L170
    L89:
        r104 = false;
    L203:
        e = move-exception;
        r113 = r101;
        r106 = e;
        r105 = 0;
    L209:
        e = move-exception;
        r113 = r101;
        r107 = e;
        r105 = 0;
    L207:
        e = move-exception;
        r113 = r101;
        r108 = e;
        r105 = 0;
    L221:
        e = move-exception;
        r113 = r101;
        r109 = e;
        r105 = 0;
    L215:
        e = move-exception;
        r113 = r101;
        r114 = e;
        r105 = 0;
    L211:
        e = move-exception;
        r113 = r101;
        r115 = e;
        r105 = 0;
    L213:
        e = move-exception;
        r113 = r101;
        r116 = e;
        r105 = 0;
    L219:
        e = move-exception;
        r113 = r101;
        r117 = e;
        r105 = 0;
    L217:
        e = move-exception;
        r113 = r101;
        r118 = e;
        r105 = 0;
    L205:
        e = move-exception;
        r113 = r101;
        r119 = e;
        r105 = 0;
    L201:
        th = move-exception;
        r113 = r101;
        r120 = th;
        r105 = 0;
        goto L248
    L533:
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62 k5 -> L64 IOException -> L66 InterruptedIOException -> L68 SocketTimeoutException -> L70 SocketException -> L72 UnknownHostException -> L74 MalformedURLException -> L76 ConnectTimeoutException -> L78 SSLException -> L80 ConnectException -> L82
        OutputStream r128 = r112.getOutputStream();     // Catch: Throwable -> L62 k5 -> L64 IOException -> L66 InterruptedIOException -> L68 SocketTimeoutException -> L70 SocketException -> L72 UnknownHostException -> L74 MalformedURLException -> L76 ConnectTimeoutException -> L78 SSLException -> L80 ConnectException -> L82
        r101 = new DataOutputStream(r128);     // Catch: Throwable -> L62 k5 -> L64 IOException -> L66 InterruptedIOException -> L68 SocketTimeoutException -> L70 SocketException -> L72 UnknownHostException -> L74 MalformedURLException -> L76 ConnectTimeoutException -> L78 SSLException -> L80 ConnectException -> L82
    L537:
        r101.write(r100);     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        r101.close();     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        r128.close();     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        this.f28215r.b();     // Catch: Throwable -> L40 k5 -> L42 IOException -> L44 InterruptedIOException -> L46 SocketTimeoutException -> L48 SocketException -> L50 UnknownHostException -> L52 MalformedURLException -> L54 ConnectTimeoutException -> L56 SSLException -> L58 ConnectException -> L60
        r101 = r101;
    L64:
        e = move-exception;
        r106 = e;
        Object r129 = null;
    L265:
        Object r130 = r129;
        r113 = r130;
        r105 = r130;
    L70:
        e = move-exception;
        r107 = e;
        Object r131 = null;
    L319:
        Object r132 = r131;
        r113 = r132;
        r105 = r132;
    L68:
        e = move-exception;
        r108 = e;
        Object r133 = null;
    L301:
        Object r134 = r133;
        r113 = r134;
        r105 = r134;
    L82:
        e = move-exception;
        r109 = e;
        Object r135 = null;
    L427:
        Object r136 = r135;
        r113 = r136;
        r105 = r136;
    L76:
        e = move-exception;
        r114 = e;
        Object r137 = null;
    L373:
        Object r138 = r137;
        r113 = r138;
        r105 = r138;
    L72:
        e = move-exception;
        r115 = e;
        Object r139 = null;
    L337:
        Object r140 = r139;
        r113 = r140;
        r105 = r140;
    L74:
        e = move-exception;
        r116 = e;
        Object r141 = null;
    L355:
        Object r142 = r141;
        r113 = r142;
        r105 = r142;
    L80:
        e = move-exception;
        r117 = e;
        Object r143 = null;
    L409:
        Object r144 = r143;
        r113 = r144;
        r105 = r144;
    L78:
        e = move-exception;
        r118 = e;
        Object r145 = null;
    L391:
        Object r146 = r145;
        r113 = r146;
        r105 = r146;
    L66:
        e = move-exception;
        r119 = e;
        Object r147 = null;
    L283:
        Object r148 = r147;
        r113 = r148;
        r105 = r148;
    L62:
        th = move-exception;
        r120 = th;
        Object r149 = null;
    L247:
        Object r150 = r149;
        r113 = r150;
        r105 = r150;
        goto L248
    L225:
        e = move-exception;
        r129 = null;
        r106 = e;
    L243:
        e = move-exception;
        r135 = null;
        r109 = e;
    L237:
        e = move-exception;
        r137 = null;
        r114 = e;
    L233:
        e = move-exception;
        r139 = null;
        r115 = e;
    L231:
        e = move-exception;
        r131 = null;
        r107 = e;
    L239:
        e = move-exception;
        r145 = null;
        r118 = e;
    L229:
        e = move-exception;
        r133 = null;
        r108 = e;
    L235:
        e = move-exception;
        r141 = null;
        r116 = e;
    L241:
        e = move-exception;
        r143 = null;
        r117 = e;
    L227:
        e = move-exception;
        r147 = null;
        r119 = e;
    L223:
        th = move-exception;
        r149 = null;
        r120 = th;
        goto L247
    L545:
        if (r100.length <= 0) goto L33;
        r111 = true;
        goto L34
    L13:
        e = move-exception;
        r106 = e;
        r129 = null;
        r112 = null;
    L17:
        e = move-exception;
        r108 = e;
        r133 = null;
        r112 = null;
    L31:
        e = move-exception;
        r109 = e;
        r135 = null;
        r112 = null;
    L25:
        e = move-exception;
        r114 = e;
        r137 = null;
        r112 = null;
    L21:
        e = move-exception;
        r115 = e;
        r139 = null;
        r112 = null;
    L19:
        e = move-exception;
        r107 = e;
        r131 = null;
        r112 = null;
    L23:
        e = move-exception;
        r116 = e;
        r141 = null;
        r112 = null;
    L29:
        e = move-exception;
        r117 = e;
        r143 = null;
        r112 = null;
    L27:
        e = move-exception;
        r118 = e;
        r145 = null;
        r112 = null;
    L15:
        e = move-exception;
        r119 = e;
        r147 = null;
        r112 = null;
    L11:
        th = move-exception;
        r120 = th;
        r149 = null;
        r112 = null;
    L263:
        e = move-exception;
        r129 = null;
        r106 = e;
        r112 = null;
    L425:
        e = move-exception;
        r135 = null;
        r109 = e;
        r112 = null;
    L371:
        e = move-exception;
        r137 = null;
        r114 = e;
        r112 = null;
    L335:
        e = move-exception;
        r139 = null;
        r115 = e;
        r112 = null;
    L317:
        e = move-exception;
        r131 = null;
        r107 = e;
        r112 = null;
    L353:
        e = move-exception;
        r141 = null;
        r116 = e;
        r112 = null;
    L389:
        e = move-exception;
        r145 = null;
        r118 = e;
        r112 = null;
    L299:
        e = move-exception;
        r133 = null;
        r108 = e;
        r112 = null;
    L407:
        e = move-exception;
        r143 = null;
        r117 = e;
        r112 = null;
    L281:
        e = move-exception;
        r147 = null;
        r119 = e;
        r112 = null;
    L245:
        th = move-exception;
        r149 = null;
        r120 = th;
        r112 = null;
    L449:
        th = move-exception;
        if (r105 != 0) goto L529;
    L458:
        if (r112 != null) goto L493;
    L463:
        if (r113 != 0) goto L495;
    L468:
        this.f28215r.d();
        throw th;
    L495:
        r113.close();     // Catch: Throwable -> L466
    L466:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L468
    L493:
        r112.disconnect();     // Catch: Throwable -> L461
    L461:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L463
    L529:
        r105.close();     // Catch: Throwable -> L454 IOException -> L456
    L456:
        e = move-exception;
        p6.a(e, "ht", "mdr");
    L454:
        th = move-exception;
        p6.a(th, "ht", "mdr");
        goto L458
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v9 */
    private z7 a(b r110, boolean r111) throws k5, IOException {
        String r100 = "";
        ByteArrayOutputStream r101 = null;
        InputStream r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        u7.a();     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        HttpURLConnection r112 = r110.f28225a;     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        Map<String, List<String>> r103 = r112.getHeaderFields();     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        int r104 = r112.getResponseCode();     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        if (r103 == null) goto L48;
        List<String> r105 = r103.get("gsid");     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        if (r105 != null) goto L8;
    L10:
        this.f28215r.f28247c.f28237k = b(r103);     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        if (TextUtils.isEmpty(this.f28207j) == true) goto L48;
        if (this.f28211n == true) goto L16;
        boolean r106 = a(r103, true);     // Catch: Throwable -> L46
        char r107 = 2;
    L20:
        if (r106 == true) goto L22;
        if (r107 != 1) goto L48;
        u7.a(false, this.f28207j);     // Catch: Throwable -> L46
        goto L48
    L22:
        if (this.f28207j.equals("loc") == false) goto L31;
        String r108 = this.f28214q;     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r108) == false) goto L26;
        r108 = r112.getURL().getHost();     // Catch: Throwable -> L46
    L26:
        String r109 = this.f28207j;     // Catch: Throwable -> L46
        if (r107 != 2) goto L29;
        boolean r113 = true;
    L30:
        m5.a(r109, r113, r108, r108, this.f28210m);     // Catch: Throwable -> L46
        goto L48
    L29:
        r113 = false;
        goto L30
    L31:
        String r114 = this.f28207j;     // Catch: Throwable -> L46
        if (r107 != 2) goto L34;
        boolean r115 = true;
    L36:
        monitor-enter(m5.class);     // Catch: Throwable -> L46
        m5.a(r114, r115, null, null, null);     // Catch: Throwable -> L40
        monitor-exit(m5.class);     // Catch: Throwable -> L46
        goto L48
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L34:
        r115 = false;
        goto L36
    L16:
        if (r103.containsKey(SRStrategy.KEY_SR_STRATEGY_CONFIG) == false) goto L18;
        r106 = a(r103, false);     // Catch: Throwable -> L46
        r107 = 1;
        goto L20
    L18:
        m5.d(this.f28207j);     // Catch: Throwable -> L46
        r106 = false;
        r107 = 0;
        goto L20
    L8:
        if (r105.size() <= 0) goto L10;
        r100 = r105.get(0);     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
    L48:
        if (r104 != 200) goto L110;
        ByteArrayOutputStream r116 = new ByteArrayOutputStream();     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L98 IOException -> L101 SocketTimeoutException -> L104 ConnectTimeoutException -> L107
        InputStream r117 = r112.getInputStream();     // Catch: Throwable -> L98 IOException -> L101 SocketTimeoutException -> L104 ConnectTimeoutException -> L107
    L181:
        PushbackInputStream r118 = new PushbackInputStream(r117, 2);     // Catch: Throwable -> L90 IOException -> L92 SocketTimeoutException -> L94 ConnectTimeoutException -> L96
        byte[] r119 = new byte[2];     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r118.read(r119);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r118.unread(r119);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        if (r119[0] == 31) goto L55;
    L58:
        r102 = r118;
    L59:
        byte[] r120 = new byte[1024];     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
    L60:
        int r121 = r102.read(r120);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        if (r121 == (-1)) goto L63;
        r116.write(r120, 0, r121);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        goto L60
    L63:
        this.f28215r.c();     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        t6.c();     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        z7 r122 = new z7();     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r122.f28591a = r116.toByteArray();     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r122.f28592b = r103;     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r122.f28593c = this.f28204g;     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r122.f28594d = r100;     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        u7.a(r112.getURL(), r122);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        this.f28215r.a(r122.f28591a.length);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
        r116.close();     // Catch: Throwable -> L66
    L68:
        if (r117 == null) goto L162;
        r117.close();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        p6.a(th, "ht", "par");
    L162:
        r118.close();     // Catch: Throwable -> L75
    L165:
        r102.close();     // Catch: Throwable -> L79
    L81:
        return r122;
    L79:
        th = move-exception;
        p6.a(th, "ht", "par");
    L75:
        th = move-exception;
        p6.a(th, "ht", "par");
    L66:
        th = move-exception;
        p6.a(th, "ht", "par");
        goto L68
    L55:
        if (r119[1] != (-117)) goto L58;
        if (r111 == true) goto L58;
        r102 = new GZIPInputStream(r118);     // Catch: Throwable -> L82 IOException -> L84 SocketTimeoutException -> L86 ConnectTimeoutException -> L88
    L86:
        e = move-exception;
        throw e;     // Catch: Throwable -> L133
    L88:
        e = move-exception;
        throw e;     // Catch: Throwable -> L133
    L84:
        e = e;
    L117:
        if ((e instanceof InterruptedIOException) == true) goto L120;
        throw e;     // Catch: Throwable -> L133
    L120:
        k5 r123 = new k5(AMapException.AMAP_CLIENT_IO_EXCEPTION, r100, this.f28204g);     // Catch: Throwable -> L133
        if (TextUtils.isEmpty(e.getMessage()) == false) goto L123;
        throw r123;     // Catch: Throwable -> L133
    L123:
        if (e.getMessage().equals("thread interrupted") == false) goto L185;
        r123.a(true);     // Catch: Throwable -> L133
        throw r123;     // Catch: Throwable -> L133
    L185:
        throw r123;     // Catch: Throwable -> L133
    L82:
        th = th;
        ?? r124 = r102;
    L135:
        r101 = r116;
        ?? r125 = r124;
    L136:
        if (r101 != null) goto L167;
    L141:
        if (r117 != null) goto L169;
    L146:
        if (r118 != null) goto L175;
    L151:
        if (r125 == 0) goto L190;
        r125.close();     // Catch: Throwable -> L154
        throw th;
    L154:
        th = move-exception;
        p6.a(th, "ht", "par");
        throw th;
    L190:
        throw th;
    L175:
        r118.close();     // Catch: Throwable -> L149
    L149:
        th = move-exception;
        p6.a(th, "ht", "par");
        goto L151
    L169:
        r117.close();     // Catch: Throwable -> L144
    L144:
        th = move-exception;
        p6.a(th, "ht", "par");
        goto L146
    L167:
        r101.close();     // Catch: Throwable -> L139
    L139:
        th = move-exception;
        p6.a(th, "ht", "par");
        goto L141
    L94:
        e = e;
    L187:
        throw e;     // Catch: Throwable -> L133
    L96:
        e = e;
    L189:
        throw e;     // Catch: Throwable -> L133
    L92:
        e = e;
    L90:
        th = th;
    L100:
        r124 = 0;
        r118 = null;
    L104:
        e = e;
    L107:
        e = e;
    L101:
        e = e;
    L98:
        th = th;
        r117 = null;
        goto L100
    L110:
        k5 r126 = new k5("网络异常原因：" + r112.getResponseMessage() + " 网络异常状态码：" + r104 + tb2.c.DEFAULT_TEXT + r100 + " " + this.f28204g, r100, this.f28204g);     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        r112.getResponseMessage();     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        f r127 = this.f28215r;     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        r127.f28247c.f28240n = r104;     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        r127.a(10);     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        r126.a(10);     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
        throw r126;     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L127 ConnectTimeoutException -> L130
    L133:
        th = th;
        r118 = null;
        r124 = r111;
    L127:
        e = move-exception;
        throw e;     // Catch: Throwable -> L133
    L130:
        e = move-exception;
        throw e;     // Catch: Throwable -> L133
    L114:
        e = e;
    L112:
        th = th;
        r125 = 0;
        r117 = null;
        r118 = null;
        goto L136
    }

    private static String a(String r100, Map<String, String> r110) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r110 != null) goto L7;
        return r100;
    L7:
        if (r110.size() <= 0) goto L42;
        int r101 = r100.indexOf("?");
        if (r101 < 0) goto L22;
        HashMap r102 = new HashMap();
        String r103 = r100.substring(r101);
        Iterator<Map.Entry<String, String>> r111 = r110.entrySet().iterator();
    L13:
        if (r111.hasNext() == false) goto L20;
        Map.Entry<String, String> r104 = r111.next();
        String r105 = r104.getKey();
        String r106 = r104.getValue();
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        if (r103.matches(".*[\\?\\&]" + URLEncoder.encode(r105) + "=.*") == true) goto L13;
        r102.put(r105, r106);
        goto L13
    L20:
        r110 = r102;
    L22:
        if (r110.size() != 0) goto L24;
        return r100;
    L24:
        String r112 = a(r110);
        StringBuffer r107 = new StringBuffer();
        r107.append(r100);
        if (r101 >= 0) goto L27;
        r107.append("?");
    L32:
        if (r112 == null) goto L35;
        r107.append(r112);
    L35:
        return r107.toString();
    L27:
        if (r100.endsWith("?") == true) goto L32;
        if (r100.endsWith("&") == true) goto L32;
        r107.append("&");
        goto L32
    L42:
        return r100;
    }

    private boolean a(Map<String, List<String>> r100, boolean r101) {
        List<String> r102 = r100.get(SRStrategy.KEY_SR_STRATEGY_CONFIG);     // Catch: Throwable -> L32
        if (r102 != null) goto L6;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (r101 == true) goto L23;
        return true;
    L23:
        if (r100.containsKey("lct") == false) goto L35;
        List<String> r104 = r100.get("lct");     // Catch: Throwable -> L32
        if (r104 != null) goto L27;
        return false;
    L27:
        if (r104.size() <= 0) goto L37;
        long r105 = m5.a(r104);     // Catch: Throwable -> L32
        return m5.a(this.f28207j, r105);
    L37:
        return false;
    L35:
        return false;
    L6:
        if (r102.size() <= 0) goto L18;
        String r106 = r102.get(0);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r106) == true) goto L18;
        if (r106.contains("#") == false) goto L17;
        String[] r107 = r106.split("#");     // Catch: Throwable -> L32
        if (r107.length <= 1) goto L18;
        if ("1".equals(r107[1]) == false) goto L18;
    L17:
        r103 = true;
    L39:
        return false;
    }

    public static /* synthetic */ boolean a(v7 r100, String r101) {
        return r100.b(r101);
    }

    private b a(y7 r110, boolean r210, boolean r211) throws IOException, k5 {
        f r100 = this.f28215r;
        y7.b r101 = r110.getDegradeType();
        c r102 = r100.f28247c;
        r102.f28227a = r100.f28252h.f28204g;
        r102.f28228b = r101;
        r100.f28245a = SystemClock.elapsedRealtime();
        Map<String, String> r103 = r110.getRequestHead();
        if (r103 != null) goto L5;
        r103 = new HashMap();
    L5:
        e r104 = this.f28206i.a(this.f28210m);
        int r105 = r7.f27936a;
        String r106 = this.f28209l;
        Uri r107 = UriProtector.parse(r106);
        String r108 = r107.getHost();
        if (r105 == 1) goto L10;
        if (r105 == 2) goto L9;
        String r109 = "";
    L11:
        boolean r111 = true;
    L13:
        if (TextUtils.isEmpty(r109) == true) goto L21;
        r110.setHostToIP(false);
        r106 = r107.buildUpon().encodedAuthority(r109).build().toString();
        if (r111 == false) goto L17;
        r103.put("targetHost", r108);
        this.f28214q = r108;
    L17:
        if (r111 == false) goto L21;
        if (this.f28198a == false) goto L21;
        r104.a(r109);
    L21:
        this.f28209l = r106;
        URL r112 = new URL(this.f28209l);
        f r113 = this.f28215r;
        r113.f28251g = r112;
        r113.f28247c.f28230d = r112.getPath();
        r113.f28247c.f28231e = r112.getHost();
        if (TextUtils.isEmpty(r113.f28252h.f28210m) == true) goto L27;
        if (r110.getDegradeType().e() == false) goto L27;
        c r114 = r113.f28247c;
        r114.f28229c = r114.f28231e.replace("[", "").replace("]", "");
        r113.f28247c.f28231e = r113.f28252h.f28210m;
    L27:
        if (r110.getDegradeType().e() == false) goto L30;
        r110.setNon_degrade_final_Host(r113.f28247c.f28231e);
    L30:
        if (r110.getDegradeType().c() == false) goto L33;
        r113.f28250f = r110.getNon_degrade_final_Host();
    L33:
        if (c(r112.getHost()) == true) goto L35;
    L101:
        String r115 = "";
    L103:
        if (this.f28198a == false) goto L111;
        String r116 = this.f28209l;
        if (TextUtils.isEmpty(r116) == false) goto L107;
    L110:
        this.f28209l = r116;
        goto L111
    L107:
        if (r116.startsWith("https") == true) goto L110;
        Uri.Builder r117 = Uri.parse(r116).buildUpon();     // Catch: Throwable -> L232
        r117.scheme("https");     // Catch: Throwable -> L232
        r116 = r117.build().toString();     // Catch: Throwable -> L232
    L111:
        a("是否降级=" + r110.getDegradeType() + "-最终url=" + this.f28209l);
        URL r118 = new URL(this.f28209l);
        r7.a r119 = this.f28205h;
        w7 r120 = null;
        if (r119 == null) goto L114;
        URLConnection r121 = r119.a(this.f28200c, r118);
    L115:
        if (r121 != null) goto L121;
        Proxy r122 = this.f28200c;
        if (r122 == null) goto L119;
        r121 = r118.openConnection(r122);
        goto L121
    L119:
        r121 = INVOKEVIRTUAL_com_amap_api_mapcore_util_v7_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r118);
    L121:
        if (this.f28198a == true) goto L234;
        HttpURLConnection r123 = (HttpURLConnection) r121;
    L163:
        if (r110.isKeepAlive() == false) goto L166;
        r123.setRequestProperty("Connection", "keep-alive");
    L168:
        int r124 = (int) (((long) r110.getReal_max_timeout()) - (this.f28215r.f28247c.f28233g / 1000));
        a("----addHeaders----------");     // Catch: Throwable -> L224
        Iterator<String> r125 = r103.keySet().iterator();     // Catch: Throwable -> L224
    L171:
        if (r125.hasNext() == false) goto L173;
        String r126 = r125.next();     // Catch: Throwable -> L224
        r123.addRequestProperty(r126, r103.get(r126));     // Catch: Throwable -> L224
        goto L171
    L173:
        if (r211 == false) goto L201;
        if (this.f28209l.contains("/v3/iasdkauth") == true) goto L201;
        if (TextUtils.isEmpty(this.f28207j) == true) goto L201;
        if (m5.f(this.f28207j) == false) goto L201;
        this.f28211n = true;     // Catch: Throwable -> L224
        m5.g r127 = m5.b(this.f28207j);     // Catch: Throwable -> L224
        r123.addRequestProperty("lct", String.valueOf(r127.f27611a));     // Catch: Throwable -> L224
        r123.addRequestProperty("lct-info", r127.f27612b);     // Catch: Throwable -> L224
        String r128 = m5.a(this.f28207j);     // Catch: Throwable -> L224
        if (TextUtils.isEmpty(r128) == true) goto L189;
        r128 = r128 + ";15K;16H;17I;1A4;17S;183";     // Catch: Throwable -> L224
    L189:
        r123.addRequestProperty("aks", r128);     // Catch: Throwable -> L224
        if (m5.c(this.f28207j) == null) goto L193;
        String r129 = m5.c(this.f28207j).e();     // Catch: Throwable -> L224
    L195:
        String r130 = this.f28207j;     // Catch: Throwable -> L224
        String r131 = Build.MANUFACTURER;     // Catch: Throwable -> L224
        Context r132 = m5.f27564c;     // Catch: Throwable -> L224
        if (r132 == null) goto L198;
        String r133 = x5.a(r132);     // Catch: Throwable -> L224
    L199:
        r123.addRequestProperty("lct-args", String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", new Object[]{r129, r130, r131, r133}));     // Catch: Throwable -> L224
        goto L201
    L198:
        r133 = r115;
        goto L199
    L193:
        r129 = r115;
    L201:
        r123.addRequestProperty("csid", this.f28204g);     // Catch: Throwable -> L224
        String r134 = l5.b();     // Catch: Throwable -> L224
        if (TextUtils.isEmpty(r134) == true) goto L205;
        r123.addRequestProperty("CountryCode", r134);     // Catch: Throwable -> L224
    L205:
        if (b(this.f28215r.f28247c.f28231e) == false) goto L226;
        f r135 = this.f28215r;     // Catch: Throwable -> L224
        if (TextUtils.isEmpty(r135.f28247c.f28229c) == false) goto L209;
        String r136 = r115;
    L211:
        if (TextUtils.isEmpty(r136) == true) goto L214;
        r123.addRequestProperty("sip", r136);     // Catch: Throwable -> L224
    L214:
        if (m5.f27583v == false) goto L219;
        c r137 = m5.d();     // Catch: Throwable -> L224
        if (r137 == null) goto L219;
        r123.addRequestProperty("nls", r137.b());     // Catch: Throwable -> L224
        this.f28215r.f28249e = r137;     // Catch: Throwable -> L224
    L219:
        a r138 = m5.e();     // Catch: Throwable -> L224
        if (r138 == null) goto L226;
        r123.addRequestProperty("nlf", r138.b());     // Catch: Throwable -> L224
        this.f28215r.f28248d = r138;     // Catch: Throwable -> L224
        goto L226
    L209:
        r136 = q5.c(n7.a(r135.f28247c.f28229c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Throwable -> L224
        a("上报本次请求serverIp:" + r135.f28247c.f28229c + "加密后：" + r136);     // Catch: Throwable -> L224
    L226:
        r123.setConnectTimeout(r124);
        r123.setReadTimeout(r124);
        if (r210 == false) goto L229;
        r123.setRequestMethod("POST");
        r123.setUseCaches(false);
        r123.setDoInput(true);
        r123.setDoOutput(true);
    L231:
        return new b(r123);
    L229:
        r123.setRequestMethod("GET");
        r123.setDoInput(true);
    L224:
        th = move-exception;
        p6.a(th, "ht", "adh");
        goto L226
    L166:
        if (Build.VERSION.SDK == null) goto L168;
        r123.setRequestProperty("Connection", "close");
        goto L168
    L234:
        SoftReference<SSLContext> r139 = f28196s;     // Catch: Throwable -> L131
        if (r139 != null) goto L125;
    L126:
        f28196s = new SoftReference(SSLContext.getInstance("TLS"));     // Catch: Throwable -> L131
    L127:
        SoftReference<SSLContext> r140 = f28196s;     // Catch: Throwable -> L131
        if (r140 == null) goto L132;
        SSLContext r141 = r140.get();     // Catch: Throwable -> L131
    L133:
        if (r141 == null) goto L246;
    L135:
        r141.init(null, null, null);     // Catch: Throwable -> L137
        this.f28199b = r141;     // Catch: Throwable -> L137
    L139:
        HttpsURLConnection r142 = (HttpsURLConnection) r121;
        if (m5.f.f27605a == true) goto L238;
        r142.setSSLSocketFactory(this.f28199b.getSocketFactory());
    L160:
        r142.setHostnameVerifier(r104);
        r123 = r142;
        goto L163
    L238:
        SoftReference<w7> r143 = f28197t;     // Catch: Throwable -> L154
        if (r143 != null) goto L144;
    L145:
        f28197t = new SoftReference(new w7(m5.f27564c, this.f28199b));     // Catch: Throwable -> L154
    L147:
        if (f28196s == null) goto L149;
        w7 r144 = f28197t.get();     // Catch: Throwable -> L154
    L150:
        if (r144 != null) goto L152;
        r144 = new w7(m5.f27564c, this.f28199b);     // Catch: Throwable -> L154
    L152:
        r144.a(this.f28213p);     // Catch: Throwable -> L154
        r120 = r144;
    L156:
        if (r120 == null) goto L158;
        r142.setSSLSocketFactory(r120);
        r120.a();
        goto L160
    L158:
        r142.setSSLSocketFactory(this.f28199b.getSocketFactory());
        goto L160
    L149:
        r144 = null;
        goto L150
    L144:
        if (r143.get() != null) goto L147;
    L154:
        th = move-exception;
        t6.a(th, "ht", "gsf");
    L137:
        th = move-exception;
        p6.a(th, "ht", "ne");
        goto L139
    L246:
        r141 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L137
        goto L135
    L125:
        if (r139.get() != null) goto L127;
    L132:
        r141 = null;
        goto L133
    L114:
        r121 = null;
        goto L115
    L35:
        if (r110.isHostToIP() == false) goto L101;
        y7.b r145 = r110.getDegradeType();
        String r146 = this.f28215r.f28247c.f28231e;
        if (b(r146) == true) goto L39;
    L48:
        boolean r147 = false;
    L49:
        if (r147 == false) goto L101;
        this.f28215r.f28246b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L99
        InetAddress[] r148 = InetAddress.getAllByName(this.f28215r.f28247c.f28231e);     // Catch: Throwable -> L99
        if (r148 != null) goto L248;
    L87:
        String r149 = "";
    L88:
        f r150 = this.f28215r;     // Catch: Throwable -> L99
        a("---onDNSEnd---ip=".concat(String.valueOf(r149)));     // Catch: Throwable -> L99
        r150.f28247c.f28229c = r149.replace("[", "").replace("]", "");     // Catch: Throwable -> L99
        r115 = "";
        r150.f28247c.f28233g = SystemClock.elapsedRealtime() - r150.f28246b;     // Catch: Throwable -> L233
        if (TextUtils.isEmpty(r149) == true) goto L103;
        Uri r151 = Uri.parse(this.f28209l);     // Catch: Throwable -> L233
        String r152 = r151.getHost();     // Catch: Throwable -> L233
        Uri r153 = r151.buildUpon().encodedAuthority(r149).build();     // Catch: Throwable -> L233
        this.f28210m = r152;     // Catch: Throwable -> L233
        r103.put("host", r152);     // Catch: Throwable -> L233
        if (this.f28198a == false) goto L97;
        r104.b(r152);     // Catch: Throwable -> L233
    L97:
        this.f28209l = r153.toString();     // Catch: Throwable -> L233
        goto L103
    L248:
        if (r148.length <= 0) goto L87;
        if (r148[0] == null) goto L87;
        if (m5.f() == true) goto L59;
    L61:
        boolean r154 = false;
    L63:
        a("---canUseIpv6---".concat(String.valueOf(r154)));     // Catch: Throwable -> L86
        if (r154 == false) goto L72;
        int r155 = 0;
    L67:
        if (r155 >= r148.length) goto L79;
        if ((r148[r155] instanceof Inet6Address) == true) goto L70;
        r155 = r155 + 1;     // Catch: Throwable -> L86
        goto L67
    L70:
        r149 = "[" + r148[r155].getHostAddress() + "]";     // Catch: Throwable -> L86
    L81:
        if (TextUtils.isEmpty(r149) == false) goto L88;
        InetAddress r156 = r148[0];     // Catch: Throwable -> L86
        r149 = r156.getHostAddress();     // Catch: Throwable -> L86
        if ((r156 instanceof Inet6Address) == false) goto L88;
        r149 = "[" + r149 + "]";     // Catch: Throwable -> L86
    L79:
        r149 = "";
        goto L81
    L72:
        int r157 = 0;
    L74:
        if (r157 >= r148.length) goto L79;
        InetAddress r158 = r148[r157];     // Catch: Throwable -> L86
        if ((r158 instanceof Inet4Address) == true) goto L77;
        r157 = r157 + 1;     // Catch: Throwable -> L86
        goto L74
    L77:
        r149 = r158.getHostAddress();     // Catch: Throwable -> L86
        goto L81
    L59:
        if (m5.c() == false) goto L61;
        r154 = true;
    L99:
        r115 = "";
        goto L103
    L39:
        if (r145.e() == false) goto L44;
        if (m5.f27578q == false) goto L44;
    L47:
        r147 = true;
    L44:
        if (r145.b() == false) goto L48;
        if (m5.e(r146) == false) goto L48;
    L9:
        r109 = "";
        r111 = false;
        goto L13
    L10:
        r109 = r7.f27937b;
        goto L11
    }
}
