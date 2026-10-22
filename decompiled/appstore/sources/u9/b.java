package u9;

import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f24899a = 5;

    public static class a implements X509TrustManager {
        public a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] r10, String r11) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] r10, String r11) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    /* JADX INFO: renamed from: u9.b$b, reason: collision with other inner class name */
    public static class C0388b implements HostnameVerifier {
        public C0388b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String r10, SSLSession r11) {
            return true;
        }
    }

    static {
    }

    public static void a(HttpURLConnection r10) {
        if (r10 == null) goto L5;
        r10.disconnect();
        return;
    }

    public static String b(p9.a r10, String r11, HashMap r12) {
        return e(r10, new URL(r11), r12).toString();
    L5:
        e = move-exception;
        o0.a.d("VideoUrl(" + r11 + ") packages error, exception = " + e.getMessage());
        throw new MalformedURLException("URL parse error.");
    }

    public static String c(p9.a r10, String r11, HashMap r12) {
        HttpURLConnection r13 = f(r10, new URL(r11), r12);     // Catch: IOException -> L16
        if (r13 != null) goto L26;
    L15:
        return null;
    L26:
        if (r13.getResponseCode() != 200) goto L15;
        String r14 = r13.getContentType();
        o0.a.c("contentType = " + r14);
        return r14;
    L12:
        e = move-exception;
        o0.a.d("Unable to Get reponseCode videoUrl(" + r11 + "), exception = " + e.getMessage());
        a(r13);
        throw new IOException("getMimeType get responseCode failed.");
    L16:
        e = move-exception;
        o0.a.d("Unable to connect videoUrl(" + r11 + "), exception = " + e.getMessage());
        a(null);
        throw new IOException("getMimeType connect failed.");
    L19:
        e = move-exception;
        o0.a.d("VideoUrl(" + r11 + ") packages error, exception = " + e.getMessage());
        throw new MalformedURLException("URL parse error.");
    }

    public static URL d(URL r10, String r11) {
        if (r11 == null) goto L12;
        URL r12 = new URL(r10, r11);
        String r13 = r12.getProtocol();
        if ("https".equals(r13) == false) goto L6;
    L10:
        return r12;
    L6:
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r13) == true) goto L10;
        throw new ProtocolException("Unsupported protocol redirect: " + r13);
    L12:
        throw new ProtocolException("Null location redirect");
    }

    public static URL e(p9.a r10, URL r11, HashMap r12) {
        if (f24899a <= 0) goto L21;
        HttpURLConnection r13 = f(r10, r11, r12);
        int r14 = r13.getResponseCode();
        if (r14 != 300) goto L7;
    L18:
        String r15 = r13.getHeaderField("Location");
        r13.disconnect();
        return e(r10, d(r11, r15), r12);
    L7:
        if (r14 == 301) goto L18;
        if (r14 == 302) goto L18;
        if (r14 == 303) goto L13;
    L17:
        return r11;
    L13:
        if (r14 == 307) goto L18;
        if (r14 != 308) goto L17;
    L21:
        throw new NoRouteToHostException("Too many redirects: 1");
    }

    public static HttpURLConnection f(p9.a r10, URL r11, HashMap r12) {
        HttpURLConnection r13 = (HttpURLConnection) r11.openConnection();
        if (r10.k() == true) goto L5;
    L7:
        r13.setConnectTimeout(r10.d());
        r13.setReadTimeout(r10.h());
        if (r12 == null) goto L13;
        Iterator r14 = r12.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.setRequestProperty((String) r15.getKey(), (String) r15.getValue());
    L13:
        r13.connect();
        return r13;
    L5:
        if ((r13 instanceof HttpsURLConnection) == false) goto L7;
        h((HttpsURLConnection) r13);
        goto L7
    }

    public static boolean g(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        String r11 = Uri.parse(r10).getScheme();
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r11) == false) goto L8;
    L9:
        return true;
    L8:
        if ("https".equals(r11) == true) goto L9;
        return false;
    }

    public static void h(HttpsURLConnection r10) {
        SSLContext r11 = null;
        SSLContext r12 = SSLContext.getInstance("TLS");     // Catch: Exception -> L13
        if (r12 != null) goto L16;
    L9:
        if (r12 == null) goto L11;
        r10.setSSLSocketFactory(r12.getSocketFactory());
    L11:
        r10.setHostnameVerifier(new C0388b());
        return;
    L16:
        r12.init(null, new TrustManager[]{new a()}, null);     // Catch: Exception -> L7
    L7:
        r11 = r12;
    L8:
        o0.a.d("SSLContext init failed");
        r12 = r11;
        goto L9
    }
}
