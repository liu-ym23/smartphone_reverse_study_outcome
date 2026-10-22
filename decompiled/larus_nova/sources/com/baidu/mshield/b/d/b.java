package com.baidu.mshield.b.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.b.f.e;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, SSLSocketFactory> f32368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f32369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f32370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpURLConnection f32371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f32372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f32374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f32375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f32377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f32378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f32379l;

    public class a implements HostnameVerifier {
        public a(b r100) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String r100, SSLSession r101) {
            if ("mshield.baidu.com".equals(r100) == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.baidu.mshield.b.d.b$b, reason: collision with other inner class name */
    public class C0651b implements X509TrustManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public X509TrustManager f32380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public X509TrustManagerExtensions f32381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f32382c;

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f32380a.getAcceptedIssuers();
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] r100, String r101) throws CertificateException {
            this.f32380a.checkClientTrusted(r100, r101);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] r100, String r101) throws CertificateException {
            com.baidu.mshield.b.c.a.b("... checkServerTrusted ...");
        L11:
            th = move-exception;
            com.baidu.mshield.b.c.a.b("... checkServerTrusted .error ...");
            com.baidu.mshield.b.c.a.a(th);
            Throwable r102 = th;
        L13:
            if (r102 == null) goto L27;
            if ((r102 instanceof CertificateExpiredException) == true) goto L20;
            if ((r102 instanceof CertificateNotYetValidException) == true) goto L20;
            r102 = r102.getCause();
        L20:
            com.baidu.mshield.b.c.a.b("certificate time invalid -> throw");
            if ((r102 instanceof CertificateException) == false) goto L25;
            throw ((CertificateException) r102);
        L25:
            throw new CertificateException("Certificate time invalid", r102);
        L27:
            if ((th instanceof CertificateException) == false) goto L30;
            com.baidu.mshield.b.c.a.b("  throw e;");
            throw th;
        L30:
            com.baidu.mshield.b.c.a.b("  throw new CertificateException();...");
            throw new CertificateException();
        L4:
            if (Build.VERSION.SDK_INT < 24) goto L9;
            com.baidu.mshield.b.c.a.b("checkServerTrusted host=" + this.f32382c);     // Catch: Throwable -> L11
            if (this.f32381b != null) goto L8;
            this.f32381b = new X509TrustManagerExtensions(this.f32380a);     // Catch: Throwable -> L11
        L8:
            this.f32381b.checkServerTrusted(r100, r101, this.f32382c);     // Catch: Throwable -> L11
            return;
        L9:
            this.f32380a.checkServerTrusted(r100, r101);     // Catch: Throwable -> L11
        }

        public C0651b(b r100, X509TrustManager r101, String r102) {
            this.f32381b = null;
            this.f32380a = r101;
            this.f32382c = r102;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f32368a = new HashMap();
    }

    public final String b() {
        Class r100 = INVOKESTATIC_com_baidu_mshield_b_d_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.baidu.mshield.ac.F");     // Catch: Throwable -> L8
        Method r101 = r100.getDeclaredMethod("getInstance", new Class[0]);     // Catch: Throwable -> L8
        r101.setAccessible(true);     // Catch: Throwable -> L8
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        Method r103 = r100.getDeclaredMethod("gzd", new Class[]{Context.class});     // Catch: Throwable -> L8
        r103.setAccessible(true);     // Catch: Throwable -> L8
        return (String) r103.invoke(r102, new Object[]{this.f32369b});
    L8:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    }

    public String a() {
        return this.f32374g;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_b_d_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_mshield_b_d_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public final byte[] a(InputStream r100) throws Throwable {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
    L3:
        int r102 = r100.read(this.f32370c);
        if (r102 == (-1)) goto L6;
        r101.write(this.f32370c, 0, r102);
        goto L3
    L6:
        byte[] r103 = r101.toByteArray();
        r101.close();
        return r103;
    }

    public final String b(InputStream r100) throws Throwable {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[] r101 = a(r100);
        if (r101 != null) goto L9;
        return null;
    L9:
        if (this.f32377j == false) goto L11;
        r101 = com.baidu.mshield.b.a.c.b(r101);
    L11:
        if (r101 != null) goto L14;
        return null;
    L14:
        return new String(r101);
    }

    public String a(String r100) throws Throwable {
        return b(r100, "");
    }

    public b(Context r100, Handler r101) {
        this.f32370c = new byte[1024];
        this.f32375h = 120000;
        this.f32376i = 120000;
        this.f32377j = false;
        this.f32378k = false;
        this.f32379l = "";
        this.f32369b = r100.getApplicationContext();
    }

    public final HttpURLConnection a(Map<String, String> r100, String r101) throws Throwable {
        HttpURLConnection r102 = null;
        String r103 = null;
        r102 = null;
        if (this.f32378k == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(this.f32372e) == false) goto L8;
    L43:
        return r102;
    L8:
        if (TextUtils.isEmpty(this.f32373f) == true) goto L43;
        if (this.f32372e.equals("POST") == false) goto L13;
    L15:
        URL r104 = new URL(this.f32373f);
        if (com.baidu.mshield.b.a.d.c(this.f32369b) == true) goto L23;
        r103 = System.getProperties().getProperty("http.proxyHost");
        String r105 = System.getProperties().getProperty("http.proxyPort");
        if (TextUtils.isEmpty(r105) == false) goto L45;
    L22:
        int r106 = -1;
    L24:
        if (r103 == null) goto L27;
        if (r106 <= 0) goto L27;
        r102 = (HttpURLConnection) r104.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(r103, r106)));
    L29:
        if ("https".equals(r104.getProtocol()) == false) goto L31;
        a((HttpsURLConnection) r102, r101);
    L31:
        r102.setRequestMethod(this.f32372e);
        r102.setDoInput(true);
        if ("POST".equals(this.f32372e) == false) goto L34;
        r102.setDoOutput(true);
    L34:
        this.f32374g = e.a(b());
        com.baidu.mshield.b.c.a.a("sdkhttputilcuid====" + this.f32374g);
        r102.setInstanceFollowRedirects(true);
        r102.setConnectTimeout(this.f32375h);
        r102.setReadTimeout(this.f32376i);
        r102.setRequestProperty("x-device-id", this.f32374g);
        String r107 = com.baidu.mshield.b.a.a.f32360a;
        String r108 = com.baidu.mshield.b.a.d.a(this.f32369b);
        if (TextUtils.isEmpty(r101) == true) goto L37;
        r102.setRequestProperty("Host", r101);
    L37:
        String r109 = "mshield/" + r107 + HTTP.URL_DEFAULT + r108 + "/4.2.9";
        com.baidu.mshield.b.c.a.a("useragent==" + r109);
        r102.setRequestProperty("User-Agent", r109);
        r102.setRequestProperty("Pragma", HTTP.NO_CACHE);
        r102.setRequestProperty("Accept", "*/*");
        r102.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        r102.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);
        r102.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        r102.setRequestProperty("x-sdk-ver", "mshield/4.2.9");
        r102.setRequestProperty("x-plu-ver", "x0/4.2.9");
        r102.setRequestProperty("x-app-ver", this.f32369b.getPackageName() + HTTP.URL_DEFAULT + r108);
        StringBuilder r110 = new StringBuilder("android/");
        r110.append(g.b());
        r102.setRequestProperty("x-sys-ver", r110.toString());
        r102.setRequestProperty("x-sys-dev", g.a(this.f32369b) + HTTP.URL_DEFAULT + g.a());
        r102.setRequestProperty("x-api-ver", String.valueOf(Build.VERSION.SDK_INT));
        if (r100 == null) goto L43;
        Iterator<String> r111 = r100.keySet().iterator();
    L41:
        if (r111.hasNext() == false) goto L43;
        String r112 = r111.next();
        r102.setRequestProperty(r112, r100.get(r112));
    L27:
        r102 = (HttpURLConnection) INVOKEVIRTUAL_com_baidu_mshield_b_d_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r104);
        goto L29
    L45:
        r106 = Integer.parseInt(r105);     // Catch: Throwable -> L44
    L23:
        r106 = 80;
        goto L24
    L13:
        if (this.f32372e.equals("GET") == true) goto L15;
        this.f32372e = "POST";
        goto L15
    }

    public String b(String r100, String r101) throws Throwable {
        d.b();
        a("GET", r100);     // Catch: Throwable -> L26
        InputStream r102 = c(null, r101);     // Catch: Throwable -> L26
        if (r102 != null) goto L55;
        if (r102 != null) goto L53;
    L7:
        HttpURLConnection r103 = this.f32371d;     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        r103.disconnect();     // Catch: Throwable -> L11
        this.f32371d = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L37
    L13:
        d.a();
        return null;
    L53:
        r102.close();     // Catch: Throwable -> L11
        goto L7
    L55:
        String r104 = b(r102);     // Catch: Throwable -> L24
        r102.close();     // Catch: Throwable -> L20
        HttpURLConnection r105 = this.f32371d;     // Catch: Throwable -> L20
        if (r105 == null) goto L22;
        r105.disconnect();     // Catch: Throwable -> L20
        this.f32371d = null;     // Catch: Throwable -> L20
    L22:
        d.a();
        return r104;
    L20:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L37
    L24:
        th = th;
    L28:
        if (r102 != null) goto L48;
    L30:
        HttpURLConnection r106 = this.f32371d;     // Catch: Throwable -> L34
        if (r106 == null) goto L36;
        r106.disconnect();     // Catch: Throwable -> L34
        this.f32371d = null;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L37
    L36:
        throw th;     // Catch: Throwable -> L37
    L48:
        r102.close();     // Catch: Throwable -> L34
    L26:
        th = th;
        r102 = null;
    L37:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L41
        d.a();
        return "";
    L41:
        th = move-exception;
        d.a();
        throw th;
    }

    public final InputStream c(String r100, String r101) throws Throwable {
        if (com.baidu.mshield.b.a.d.b(this.f32369b) == false) goto L25;
        HttpURLConnection r102 = a(null, r101);
        this.f32371d = r102;
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.getResponseCode() == 200) goto L11;
        return null;
    L11:
        if (r100 == null) goto L13;
        BufferedOutputStream r103 = new BufferedOutputStream(this.f32371d.getOutputStream());
        r103.write(com.baidu.mshield.b.a.c.a(r100.getBytes()));
        r103.flush();
        r103.close();
        if (DownloadHelper.GZIP.equalsIgnoreCase(this.f32371d.getContentEncoding()) == false) goto L21;
        this.f32377j = true;
    L23:
        return this.f32371d.getInputStream();
    L21:
        this.f32377j = false;
        goto L23
    L13:
        if (DownloadHelper.GZIP.equalsIgnoreCase(this.f32371d.getContentEncoding()) == false) goto L15;
        this.f32377j = true;
    L17:
        return this.f32371d.getInputStream();
    L15:
        this.f32377j = false;
        goto L17
    L25:
        throw new NetworkErrorException("requestFromServerStream no network");
    }

    public final InputStream a(byte[] r100, String r101) throws Throwable {
        if (com.baidu.mshield.b.a.d.b(this.f32369b) == false) goto L31;
        HttpURLConnection r102 = a(null, r101);
        this.f32371d = r102;
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r100 == null) goto L10;
        BufferedOutputStream r103 = new BufferedOutputStream(this.f32371d.getOutputStream());
        r103.write(r100);
        r103.flush();
        r103.close();
        int r104 = this.f32371d.getResponseCode();
        com.baidu.mshield.b.c.a.b("httpcode:" + r104);     // Catch: Throwable -> L18
        com.baidu.mshield.b.c.a.b("httpcontent:" + this.f32371d.getContent());     // Catch: Throwable -> L18
        com.baidu.mshield.b.c.a.b("httpresponse:" + this.f32371d.getResponseMessage());     // Catch: Throwable -> L18
    L21:
        if (DownloadHelper.GZIP.equalsIgnoreCase(this.f32371d.getContentEncoding()) == false) goto L23;
        this.f32377j = true;
    L25:
        if (r104 != 200) goto L29;
        return this.f32371d.getInputStream();
    L29:
        throw new c(r104);
    L23:
        this.f32377j = false;
    L18:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        goto L21
    L10:
        if (DownloadHelper.GZIP.equalsIgnoreCase(r102.getContentEncoding()) == false) goto L12;
        this.f32377j = true;
    L14:
        return this.f32371d.getInputStream();
    L12:
        this.f32377j = false;
        goto L14
    L31:
        throw new NetworkErrorException("requestFromServerStreamByte no network");
    }

    public final void a(HttpsURLConnection r100, String r110) {
    L21:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return;
    L4:
        if (TextUtils.isEmpty(r110) == true) goto L6;
        this.f32379l = r110;     // Catch: Throwable -> L21
    L6:
        Map<String, SSLSocketFactory> r111 = f32368a;     // Catch: Throwable -> L21
        SSLSocketFactory r101 = r111.get(this.f32379l);     // Catch: Throwable -> L21
        if (r101 == null) goto L10;
        r100.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);     // Catch: Throwable -> L21
        r100.setSSLSocketFactory(r101);     // Catch: Throwable -> L21
        return;
    L10:
        SSLContext r102 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L21
        TrustManagerFactory r103 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: Throwable -> L21
        r103.init(null);     // Catch: Throwable -> L21
        TrustManager[] r104 = r103.getTrustManagers();     // Catch: Throwable -> L21
        if (r104.length < 1) goto L20;
        TrustManager r105 = r104[0];     // Catch: Throwable -> L21
        if ((r105 instanceof X509TrustManager) == false) goto L20;
        r102.init(null, new TrustManager[]{new C0651b(this, (X509TrustManager) r105, this.f32379l)}, new SecureRandom());     // Catch: Throwable -> L21
        SSLSocketFactory r106 = r102.getSocketFactory();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(this.f32379l) == true) goto L17;
        r111.put(this.f32379l, r106);     // Catch: Throwable -> L21
        r100.setHostnameVerifier(new a(this));     // Catch: Throwable -> L21
    L18:
        r100.setSSLSocketFactory(r106);     // Catch: Throwable -> L21
        return;
    L17:
        r100.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r104));     // Catch: Throwable -> L21
    }

    public final void a(String r100, String r101) {
        this.f32372e = r100;
        this.f32373f = r101;
        this.f32379l = new URL(r101).getHost();     // Catch: MalformedURLException -> L5
        return;
    L5:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
    }

    public String a(String r100, byte[] r101) throws Throwable {
        return a(r100, "", r101);
    }

    public String a(String r100, String r101, byte[] r102) throws Throwable {
        d.b();
        a("POST", r100);     // Catch: Throwable -> L30
        InputStream r103 = a(r102, r101);     // Catch: Throwable -> L22
        if (r103 != null) goto L33;
        if (r103 == null) goto L9;
        r103.close();     // Catch: Throwable -> L30
    L9:
        HttpURLConnection r104 = this.f32371d;     // Catch: Throwable -> L30
        if (r104 == null) goto L12;
        r104.disconnect();     // Catch: Throwable -> L30
        this.f32371d = null;     // Catch: Throwable -> L30
    L12:
        d.a();
        return null;
    L33:
        String r105 = b(r103);     // Catch: Throwable -> L20
        r103.close();     // Catch: Throwable -> L30
        HttpURLConnection r106 = this.f32371d;     // Catch: Throwable -> L30
        if (r106 == null) goto L18;
        r106.disconnect();     // Catch: Throwable -> L30
        this.f32371d = null;     // Catch: Throwable -> L30
    L18:
        d.a();
        return r105;
    L20:
        th = th;
    L24:
        if (r103 == null) goto L26;
        r103.close();     // Catch: Throwable -> L30
    L26:
        HttpURLConnection r107 = this.f32371d;     // Catch: Throwable -> L30
        if (r107 == null) goto L29;
        r107.disconnect();     // Catch: Throwable -> L30
        this.f32371d = null;     // Catch: Throwable -> L30
    L29:
        throw th;     // Catch: Throwable -> L30
    L22:
        th = th;
        r103 = null;
    L30:
        th = move-exception;
        d.a();
        throw th;
    }
}
