package com.baidu.mshield.b.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.b.f.e;
import com.stepos.alphame.app.AppStateEngine;
import com.stepos.alphame.common.CommonContractKt;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, SSLSocketFactory> f8269a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Context f8270b;

    /* renamed from: d, reason: collision with root package name */
    public HttpURLConnection f8272d;

    /* renamed from: e, reason: collision with root package name */
    public String f8273e;

    /* renamed from: f, reason: collision with root package name */
    public String f8274f;

    /* renamed from: g, reason: collision with root package name */
    public String f8275g;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f8271c = new byte[1024];

    /* renamed from: h, reason: collision with root package name */
    public int f8276h = AppStateEngine.DATA_EFFECTIVE_TIME;

    /* renamed from: i, reason: collision with root package name */
    public int f8277i = AppStateEngine.DATA_EFFECTIVE_TIME;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8278j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8279k = false;

    /* renamed from: l, reason: collision with root package name */
    public String f8280l = "";

    public class a implements HostnameVerifier {
        public a(b bVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return "mshield.baidu.com".equals(str);
        }
    }

    /* renamed from: com.baidu.mshield.b.d.b$b, reason: collision with other inner class name */
    public class C0034b implements X509TrustManager {

        /* renamed from: a, reason: collision with root package name */
        public X509TrustManager f8281a;

        /* renamed from: b, reason: collision with root package name */
        public X509TrustManagerExtensions f8282b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f8283c;

        public C0034b(b bVar, X509TrustManager x509TrustManager, String str) {
            this.f8281a = x509TrustManager;
            this.f8283c = str;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.f8281a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.mshield.b.c.a.b("... checkServerTrusted ...");
            try {
                com.baidu.mshield.b.c.a.b("checkServerTrusted host=" + this.f8283c);
                if (this.f8282b == null) {
                    this.f8282b = new X509TrustManagerExtensions(this.f8281a);
                }
                this.f8282b.checkServerTrusted(x509CertificateArr, str, this.f8283c);
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.b("... checkServerTrusted .error ...");
                com.baidu.mshield.b.c.a.a(th);
                for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                    if ((cause instanceof CertificateExpiredException) || (cause instanceof CertificateNotYetValidException)) {
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    com.baidu.mshield.b.c.a.b("  throw e;");
                    throw th;
                }
                com.baidu.mshield.b.c.a.b("  throw new CertificateException();...");
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f8281a.getAcceptedIssuers();
        }
    }

    public b(Context context, Handler handler) {
        this.f8270b = context.getApplicationContext();
    }

    public final void a(String str, String str2) {
        this.f8273e = str;
        this.f8274f = str2;
        try {
            this.f8280l = new URL(str2).getHost();
        } catch (MalformedURLException e4) {
            com.baidu.mshield.b.c.a.a(e4);
        }
    }

    public final String b() {
        try {
            Method declaredMethod = F.class.getDeclaredMethod(CommonContractKt.METHOD_NAME_GET_INSTANCE, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = F.class.getDeclaredMethod("gzd", Context.class);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(objInvoke, this.f8270b);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public final InputStream c(String str, String str2) throws Throwable {
        if (!com.baidu.mshield.b.a.d.b(this.f8270b)) {
            throw new NetworkErrorException("requestFromServerStream no network");
        }
        HttpURLConnection httpURLConnectionA = a((Map<String, String>) null, str2);
        this.f8272d = httpURLConnectionA;
        if (httpURLConnectionA == null || httpURLConnectionA.getResponseCode() != 200) {
            return null;
        }
        if (str == null) {
            if ("gzip".equalsIgnoreCase(this.f8272d.getContentEncoding())) {
                this.f8278j = true;
            } else {
                this.f8278j = false;
            }
            return this.f8272d.getInputStream();
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.f8272d.getOutputStream());
        bufferedOutputStream.write(com.baidu.mshield.b.a.c.a(str.getBytes()));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        if ("gzip".equalsIgnoreCase(this.f8272d.getContentEncoding())) {
            this.f8278j = true;
        } else {
            this.f8278j = false;
        }
        return this.f8272d.getInputStream();
    }

    public final void a(HttpsURLConnection httpsURLConnection, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f8280l = str;
            }
            Map<String, SSLSocketFactory> map = f8269a;
            SSLSocketFactory sSLSocketFactory = map.get(this.f8280l);
            if (sSLSocketFactory != null) {
                httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                return;
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length >= 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    sSLContext.init(null, new TrustManager[]{new C0034b(this, (X509TrustManager) trustManager, this.f8280l)}, new SecureRandom());
                    SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                    if (!TextUtils.isEmpty(this.f8280l)) {
                        map.put(this.f8280l, socketFactory);
                        httpsURLConnection.setHostnameVerifier(new a(this));
                    } else {
                        httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    }
                    httpsURLConnection.setSSLSocketFactory(socketFactory);
                    return;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    public final String b(InputStream inputStream) throws Throwable {
        byte[] bArrA;
        if (inputStream == null || (bArrA = a(inputStream)) == null) {
            return null;
        }
        if (this.f8278j) {
            bArrA = com.baidu.mshield.b.a.c.b(bArrA);
        }
        if (bArrA == null) {
            return null;
        }
        return new String(bArrA);
    }

    public String b(String str, String str2) throws Throwable {
        InputStream inputStreamC;
        d.b();
        try {
            try {
                try {
                    a("GET", str);
                    inputStreamC = c(null, str2);
                    if (inputStreamC == null) {
                        if (inputStreamC != null) {
                            try {
                                inputStreamC.close();
                            } catch (Throwable th) {
                                com.baidu.mshield.b.c.a.a(th);
                            }
                        }
                        HttpURLConnection httpURLConnection = this.f8272d;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            this.f8272d = null;
                        }
                        return null;
                    }
                    try {
                        String strB = b(inputStreamC);
                        try {
                            inputStreamC.close();
                            HttpURLConnection httpURLConnection2 = this.f8272d;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                this.f8272d = null;
                            }
                        } catch (Throwable th2) {
                            com.baidu.mshield.b.c.a.a(th2);
                        }
                        return strB;
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStreamC != null) {
                            try {
                                inputStreamC.close();
                            } catch (Throwable th4) {
                                com.baidu.mshield.b.c.a.a(th4);
                                throw th;
                            }
                        }
                        HttpURLConnection httpURLConnection3 = this.f8272d;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                            this.f8272d = null;
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamC = null;
                }
            } catch (Throwable th6) {
                com.baidu.mshield.b.c.a.a(th6);
                d.a();
                return "";
            }
            com.baidu.mshield.b.c.a.a(th6);
            d.a();
            return "";
        } finally {
            d.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.net.HttpURLConnection] */
    public final HttpURLConnection a(Map<String, String> map, String str) throws Throwable {
        int i4;
        HttpsURLConnection httpsURLConnection = null;
        String property = null;
        httpsURLConnection = null;
        if (this.f8279k) {
            return null;
        }
        if (!TextUtils.isEmpty(this.f8273e) && !TextUtils.isEmpty(this.f8274f)) {
            if (!this.f8273e.equals("POST") && !this.f8273e.equals("GET")) {
                this.f8273e = "POST";
            }
            URL url = new URL(this.f8274f);
            if (com.baidu.mshield.b.a.d.c(this.f8270b)) {
                i4 = 80;
            } else {
                property = System.getProperties().getProperty("http.proxyHost");
                String property2 = System.getProperties().getProperty("http.proxyPort");
                if (TextUtils.isEmpty(property2)) {
                    i4 = -1;
                } else {
                    try {
                        i4 = Integer.parseInt(property2);
                    } catch (Throwable unused) {
                    }
                }
            }
            if (property != null && i4 > 0) {
                httpsURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(property, i4)));
            } else {
                httpsURLConnection = (HttpURLConnection) url.openConnection();
            }
            if ("https".equals(url.getProtocol())) {
                a(httpsURLConnection, str);
            }
            httpsURLConnection.setRequestMethod(this.f8273e);
            httpsURLConnection.setDoInput(true);
            if ("POST".equals(this.f8273e)) {
                httpsURLConnection.setDoOutput(true);
            }
            this.f8275g = e.a(b());
            com.baidu.mshield.b.c.a.a("sdkhttputilcuid====" + this.f8275g);
            httpsURLConnection.setInstanceFollowRedirects(true);
            httpsURLConnection.setConnectTimeout(this.f8276h);
            httpsURLConnection.setReadTimeout(this.f8277i);
            httpsURLConnection.setRequestProperty("x-device-id", this.f8275g);
            String str2 = com.baidu.mshield.b.a.a.f8261a;
            String strA = com.baidu.mshield.b.a.d.a(this.f8270b);
            if (!TextUtils.isEmpty(str)) {
                httpsURLConnection.setRequestProperty("Host", str);
            }
            String str3 = "mshield/" + str2 + "/" + strA + "/4.2.6";
            com.baidu.mshield.b.c.a.a("useragent==" + str3);
            httpsURLConnection.setRequestProperty("User-Agent", str3);
            httpsURLConnection.setRequestProperty("Pragma", "no-cache");
            httpsURLConnection.setRequestProperty("Accept", "*/*");
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpsURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
            httpsURLConnection.setRequestProperty("x-sdk-ver", "mshield/4.2.6");
            httpsURLConnection.setRequestProperty("x-plu-ver", "x0/4.2.6");
            httpsURLConnection.setRequestProperty("x-app-ver", this.f8270b.getPackageName() + "/" + strA);
            StringBuilder sb = new StringBuilder("android/");
            sb.append(g.b());
            httpsURLConnection.setRequestProperty("x-sys-ver", sb.toString());
            httpsURLConnection.setRequestProperty("x-sys-dev", g.a(this.f8270b) + "/" + g.a());
            httpsURLConnection.setRequestProperty("x-api-ver", String.valueOf(Build.VERSION.SDK_INT));
            if (map != null) {
                for (String str4 : map.keySet()) {
                    httpsURLConnection.setRequestProperty(str4, map.get(str4));
                }
            }
        }
        return httpsURLConnection;
    }

    public String a(String str) throws Throwable {
        return b(str, "");
    }

    public String a(String str, byte[] bArr) throws Throwable {
        return a(str, "", bArr);
    }

    public String a(String str, String str2, byte[] bArr) throws Throwable {
        InputStream inputStreamA;
        d.b();
        try {
            a("POST", str);
            try {
                inputStreamA = a(bArr, str2);
                if (inputStreamA == null) {
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                    HttpURLConnection httpURLConnection = this.f8272d;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        this.f8272d = null;
                    }
                    d.a();
                    return null;
                }
                try {
                    String strB = b(inputStreamA);
                    inputStreamA.close();
                    HttpURLConnection httpURLConnection2 = this.f8272d;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        this.f8272d = null;
                    }
                    d.a();
                    return strB;
                } catch (Throwable th) {
                    th = th;
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                    HttpURLConnection httpURLConnection3 = this.f8272d;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                        this.f8272d = null;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamA = null;
            }
        } catch (Throwable th3) {
            d.a();
            throw th3;
        }
    }

    public final InputStream a(byte[] bArr, String str) throws Throwable {
        if (com.baidu.mshield.b.a.d.b(this.f8270b)) {
            HttpURLConnection httpURLConnectionA = a((Map<String, String>) null, str);
            this.f8272d = httpURLConnectionA;
            if (httpURLConnectionA == null) {
                return null;
            }
            if (bArr == null) {
                if ("gzip".equalsIgnoreCase(httpURLConnectionA.getContentEncoding())) {
                    this.f8278j = true;
                } else {
                    this.f8278j = false;
                }
                return this.f8272d.getInputStream();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.f8272d.getOutputStream());
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            int responseCode = this.f8272d.getResponseCode();
            try {
                com.baidu.mshield.b.c.a.b("httpcode:" + responseCode);
                com.baidu.mshield.b.c.a.b("httpcontent:" + this.f8272d.getContent());
                com.baidu.mshield.b.c.a.b("httpresponse:" + this.f8272d.getResponseMessage());
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
            if ("gzip".equalsIgnoreCase(this.f8272d.getContentEncoding())) {
                this.f8278j = true;
            } else {
                this.f8278j = false;
            }
            if (responseCode == 200) {
                return this.f8272d.getInputStream();
            }
            throw new c(responseCode);
        }
        throw new NetworkErrorException("requestFromServerStreamByte no network");
    }

    public final byte[] a(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i4 = inputStream.read(this.f8271c);
            if (i4 != -1) {
                byteArrayOutputStream.write(this.f8271c, 0, i4);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public String a() {
        return this.f8275g;
    }
}
