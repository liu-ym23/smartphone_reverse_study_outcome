package com.alipay.android.phone.mrpc.core;

import android.net.SSLCertificateSocketFactory;
import android.util.Base64;
import android.util.Log;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.bduploader.UploadKeys;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes28.dex */
public final class b implements HttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f25005a = 160;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String[] f25006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HttpRequestInterceptor f25007c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HttpClient f25008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RuntimeException f25009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile C0476b f25010f;

    public class a implements HttpRequestInterceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25011a;

        public a(b r100) {
            this.f25011a = r100;
        }

        public /* synthetic */ a(b r100, byte r101) {
            this(r100);
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public final void process(HttpRequest r100, HttpContext r101) {
            C0476b r102 = b.a(this.f25011a);
            if (r102 != null) goto L5;
            return;
        L5:
            if (C0476b.a(r102) == true) goto L7;
            return;
        L7:
            if ((r100 instanceof HttpUriRequest) == false) goto L12;
            C0476b.a(r102, b.a((HttpUriRequest) r100));
            return;
        }
    }

    /* JADX INFO: renamed from: com.alipay.android.phone.mrpc.core.b$b, reason: collision with other inner class name */
    public static class C0476b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f25013b;

        public static /* synthetic */ void a(C0476b r100, String r101) {
            int r102 = r100.f25013b;
        }

        public static /* synthetic */ boolean a(C0476b r100) {
            return Log.isLoggable(r100.f25012a, r100.f25013b);
        }
    }

    static {
        f25006b = new String[]{"text/", "application/xml", "application/json"};
        f25007c = new c();
    }

    public b(ClientConnectionManager r100, HttpParams r101) {
        this.f25009e = new IllegalStateException("AndroidHttpClient created and never closed");
        this.f25008d = new d(this, r100, r101);
    }

    public static /* synthetic */ C0476b a(b r100) {
        return r100.f25010f;
    }

    public static b a(String r100) {
        BasicHttpParams r101 = new BasicHttpParams();
        HttpProtocolParams.setVersion(r101, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(r101, false);
        HttpConnectionParams.setStaleCheckingEnabled(r101, true);
        HttpConnectionParams.setConnectionTimeout(r101, 20000);
        HttpConnectionParams.setSoTimeout(r101, 30000);
        HttpConnectionParams.setSocketBufferSize(r101, 8192);
        HttpClientParams.setRedirecting(r101, true);
        HttpClientParams.setAuthenticating(r101, false);
        HttpProtocolParams.setUserAgent(r101, r100);
        SchemeRegistry r102 = new SchemeRegistry();
        r102.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        r102.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(30000, null), UploadKeys.KeyIsGetVideoMeta));
        ThreadSafeClientConnManager r103 = new ThreadSafeClientConnManager(r101, r102);
        ConnManagerParams.setTimeout(r101, 60000);
        ConnManagerParams.setMaxConnectionsPerRoute(r101, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(r101, 50);
        Security.setProperty("networkaddress.cache.ttl", "-1");
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return new b(r103, r101);
    }

    public static InputStream a(HttpEntity r100) {
        InputStream r101 = r100.getContent();
        if (r101 != null) goto L5;
        return r101;
    L5:
        Header r102 = r100.getContentEncoding();
        if (r102 != null) goto L8;
        return r101;
    L8:
        String r103 = r102.getValue();
        if (r103 != null) goto L12;
        return r101;
    L12:
        if (r103.contains(DownloadHelper.GZIP) == true) goto L14;
        return r101;
    L14:
        return new GZIPInputStream(r101);
    }

    public static /* synthetic */ String a(HttpUriRequest r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("curl ");
        Header[] r102 = r100.getAllHeaders();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        Header r105 = r102[r104];
        if (r105.getName().equals("Authorization") == true) goto L9;
        if (r105.getName().equals("Cookie") == true) goto L9;
        r101.append("--header \"");
        r101.append(r105.toString().trim());
        r101.append("\" ");
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        URI r106 = r100.getURI();
        if ((r100 instanceof RequestWrapper) == false) goto L15;
        HttpRequest r107 = ((RequestWrapper) r100).getOriginal();
        if ((r107 instanceof HttpUriRequest) == false) goto L15;
        r106 = ((HttpUriRequest) r107).getURI();
    L15:
        r101.append("\"");
        r101.append(r106);
        r101.append("\"");
        if ((r100 instanceof HttpEntityEnclosingRequest) == false) goto L30;
        HttpEntity r108 = ((HttpEntityEnclosingRequest) r100).getEntity();
        if (r108 == null) goto L30;
        if (r108.isRepeatable() == false) goto L30;
        if (r108.getContentLength() >= 1024) goto L27;
        ByteArrayOutputStream r109 = new ByteArrayOutputStream();
        r108.writeTo(r109);
        if (b(r100) == false) goto L26;
        r101.insert(0, "echo '" + Base64.encodeToString(r109.toByteArray(), 2) + "' | base64 -d > /tmp/$$.bin; ");
        String r110 = " --data-binary @/tmp/$$.bin";
    L28:
        r101.append(r110);
        goto L30
    L26:
        String r111 = r109.toString();
        r101.append(" --data-ascii \"");
        r101.append(r111);
        r101.append("\"");
        goto L30
    L27:
        r110 = " [TOO MUCH DATA TO INCLUDE]";
    L30:
        return r101.toString();
    }

    public static /* synthetic */ HttpRequestInterceptor a() {
        return f25007c;
    }

    public static AbstractHttpEntity a(byte[] r100) {
        if (r100.length < f25005a) goto L7;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        GZIPOutputStream r102 = new GZIPOutputStream(r101);
        r102.write(r100);
        r102.close();
        ByteArrayEntity r103 = new ByteArrayEntity(r101.toByteArray());
        r103.setContentEncoding(DownloadHelper.GZIP);
        r103.getContentLength();
        return r103;
    L7:
        return new ByteArrayEntity(r100);
    }

    public static void a(HttpRequest r100) {
        r100.addHeader("Accept-Encoding", DownloadHelper.GZIP);
    }

    public static long b(String r100) {
        return k.a(r100);
    }

    public static void b(HttpRequest r100) {
        r100.addHeader("Connection", HTTP.KEEP_ALIVE);
    }

    public static boolean b(HttpUriRequest r110) {
        Header[] r100 = r110.getHeaders("content-encoding");
        if (r100 == null) goto L10;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        if (DownloadHelper.GZIP.equalsIgnoreCase(r100[r102].getValue()) == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        return true;
    L10:
        Header[] r111 = r110.getHeaders(com.alipay.sdk.m.p.e.f25658f);
        if (r111 == null) goto L21;
        int r103 = r111.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L21;
        Header r105 = r111[r104];
        String[] r106 = f25006b;
        int r107 = r106.length;
        int r108 = 0;
    L15:
        if (r108 >= r107) goto L20;
        String r109 = r106[r108];
        if (r105.getValue().startsWith(r109) == true) goto L18;
        r108 = r108 + 1;
        goto L15
    L18:
        return false;
    L20:
        r104 = r104 + 1;
    L21:
        return true;
    }

    public final void a(HttpRequestRetryHandler r100) {
        ((DefaultHttpClient) this.f25008d).setHttpRequestRetryHandler(r100);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpHost r100, HttpRequest r101, ResponseHandler<? extends T> r102) {
        return (T) this.f25008d.execute(r100, r101, r102);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpHost r100, HttpRequest r101, ResponseHandler<? extends T> r102, HttpContext r103) {
        return (T) this.f25008d.execute(r100, r101, r102, r103);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpUriRequest r100, ResponseHandler<? extends T> r101) {
        return (T) this.f25008d.execute(r100, r101);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpUriRequest r100, ResponseHandler<? extends T> r101, HttpContext r102) {
        return (T) this.f25008d.execute(r100, r101, r102);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost r100, HttpRequest r101) {
        return this.f25008d.execute(r100, r101);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost r100, HttpRequest r101, HttpContext r102) {
        return this.f25008d.execute(r100, r101, r102);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest r100) {
        return this.f25008d.execute(r100);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest r100, HttpContext r101) {
        return this.f25008d.execute(r100, r101);
    }

    @Override // org.apache.http.client.HttpClient
    public final ClientConnectionManager getConnectionManager() {
        return this.f25008d.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpParams getParams() {
        return this.f25008d.getParams();
    }
}
