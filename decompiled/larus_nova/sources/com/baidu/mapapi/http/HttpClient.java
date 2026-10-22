package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.http.wrapper.FileWrapper;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class HttpClient {
    public static final String BOUNDRYSTR = "bd_map_sdk_cc";
    public static final String ENDFLAG = "--";
    public static final String FILE_TEMPLATE = "Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"";
    public static final String NEWLINE = "\r\n";
    public static final String PARAM_TEMPLATE = "Content-Disposition: form-data; name=\"%s\"";
    public static boolean isHttpsEnable = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HttpURLConnection f30563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f30566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProtoResultCallback f30567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HttpHeader f30568h;

    public static class HttpHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f30572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, Object> f30573e;

        public HttpHeader() {
        }

        public String getAccept() {
            return this.f30572d;
        }

        public String getCharset() {
            return this.f30570b;
        }

        public String getConnection() {
            return this.f30569a;
        }

        public String getContentType() {
            return this.f30571c;
        }

        public Map<String, Object> getCustom() {
            return this.f30573e;
        }

        public HttpHeader setAccept(String r100) {
            this.f30572d = r100;
            return this;
        }

        public HttpHeader setCharset(String r100) {
            this.f30570b = r100;
            return this;
        }

        public HttpHeader setConnection(String r100) {
            this.f30569a = r100;
            return this;
        }

        public HttpHeader setContentType(String r100) {
            this.f30571c = r100;
            return this;
        }

        public HttpHeader setCustom(Map<String, Object> r100) {
            this.f30573e = r100;
            return this;
        }

        public HttpHeader(String r100, String r101, String r102, String r103) {
            this.f30569a = r100;
            this.f30570b = r101;
            this.f30571c = r102;
            this.f30572d = r103;
        }
    }

    public static class HttpResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private HttpStateError f30575b;

        public String getData() {
            return this.f30574a;
        }

        public HttpStateError getError() {
            return this.f30575b;
        }

        public HttpResponse(String r100) {
            this.f30574a = r100;
            this.f30575b = HttpStateError.NO_ERROR;
        }

        public void setData(String r100) {
            this.f30574a = r100;
        }

        public void setError(HttpStateError r100) {
            this.f30575b = r100;
        }

        public HttpResponse(HttpStateError r100) {
            this.f30575b = r100;
        }
    }

    public static final enum HttpStateError extends Enum<HttpStateError> {
        private static final /* synthetic */ HttpStateError[] $VALUES = null;
        public static final HttpStateError INNER_ERROR = null;
        public static final HttpStateError NETWORK_ERROR = null;
        public static final HttpStateError NO_ERROR = null;
        public static final HttpStateError REQUEST_ERROR = null;
        public static final HttpStateError SERVER_ERROR = null;

        static {
            HttpStateError r100 = new HttpStateError("NO_ERROR", 0);
            NO_ERROR = r100;
            HttpStateError r101 = new HttpStateError("NETWORK_ERROR", 1);
            NETWORK_ERROR = r101;
            HttpStateError r102 = new HttpStateError("INNER_ERROR", 2);
            INNER_ERROR = r102;
            HttpStateError r103 = new HttpStateError("REQUEST_ERROR", 3);
            REQUEST_ERROR = r103;
            HttpStateError r104 = new HttpStateError("SERVER_ERROR", 4);
            SERVER_ERROR = r104;
            $VALUES = new HttpStateError[]{r100, r101, r102, r103, r104};
        }

        public static HttpStateError[] values() {
            return (HttpStateError[]) $VALUES.clone();
        }

        public static HttpStateError valueOf(String r100) {
            return (HttpStateError) r27.a.a(HttpStateError.class, r100);
        }

        private HttpStateError(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError r100);

        public abstract void onSuccess(String r100);

        public ProtoResultCallback() {
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b implements HostnameVerifier {
        private b() {
        }

        public /* synthetic */ b(a r100) {
            this();
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String r100, SSLSession r101) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(r100, r101);
        }
    }

    private HttpURLConnection a() {
        a r100 = null;
        URL r101 = new URL(this.f30561a);     // Catch: Exception -> L11
        if (isHttpsEnable == false) goto L6;
        HttpsURLConnection r102 = (HttpsURLConnection) INVOKEVIRTUAL_com_baidu_mapapi_http_HttpClient_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);     // Catch: Exception -> L11
        r102.setHostnameVerifier(new b(r100));     // Catch: Exception -> L11
        HttpURLConnection r103 = r102;
    L7:
        r103.setRequestMethod(this.f30566f);     // Catch: Exception -> L11
        r103.setDoOutput(!"GET".equalsIgnoreCase(this.f30566f));     // Catch: Exception -> L11
        r103.setDoInput(true);     // Catch: Exception -> L11
        r103.setConnectTimeout(this.f30564d);     // Catch: Exception -> L11
        r103.setReadTimeout(this.f30565e);     // Catch: Exception -> L11
        a(r103);     // Catch: Exception -> L11
        return r103;
    L6:
        r103 = (HttpURLConnection) INVOKEVIRTUAL_com_baidu_mapapi_http_HttpClient_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        if (Logger.debugEnable() == false) goto L15;
        e.printStackTrace();
    L16:
        return null;
    L15:
        Logger.logW("HttpClient", e.getMessage());
        goto L16
    }

    public boolean checkNetwork() {
        ConnectivityManager r100 = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");     // Catch: Exception -> L26
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Network[] r101 = r100.getAllNetworks();     // Catch: Exception -> L26
        int r102 = r101.length;     // Catch: Exception -> L26
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L18;
        NetworkCapabilities r104 = r100.getNetworkCapabilities(r101[r103]);     // Catch: Exception -> L26
        if (r104 == null) goto L17;
        if (r104.hasCapability(12) == false) goto L17;
        if (r104.hasCapability(16) == false) goto L17;
        return true;
    L17:
        r103 = r103 + 1;     // Catch: Exception -> L26
        goto L9
    L18:
        return false;
    L19:
        NetworkInfo r105 = r100.getActiveNetworkInfo();     // Catch: Exception -> L26
        if (r105 != null) goto L22;
    L25:
        return false;
    L22:
        if (r105.isAvailable() == false) goto L25;
        return true;
    L26:
        e = move-exception;
        if (Logger.debugEnable() == false) goto L30;
        e.printStackTrace();
    L31:
        e.printStackTrace();
        return false;
    L30:
        Logger.logW("HttpClient", e.getMessage());
        goto L31
    }

    public static String getPhoneInfo() {
        return g.h();
    }

    public static Map<String, String> getPhoneInfoRaw() {
        return g.j();
    }

    public static String getAuthToken() {
        return g.F;
    }

    public HttpClient(String r100) {
        this.f30561a = null;
        this.f30562b = null;
        this.f30564d = 10000;
        this.f30565e = 10000;
        this.f30566f = r100;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_mapapi_http_HttpClient_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    private void a(HttpURLConnection r100) {
        HttpHeader r101 = this.f30568h;
        if (r101 == null) goto L33;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101.getConnection() == null) goto L11;
        if (this.f30568h.getConnection().isEmpty() == true) goto L11;
        r100.setRequestProperty("Connection", this.f30568h.getConnection());
    L11:
        if (this.f30568h.getCharset() == null) goto L16;
        if (this.f30568h.getCharset().isEmpty() == true) goto L16;
        r100.setRequestProperty("Charset", this.f30568h.getCharset());
    L16:
        if (this.f30568h.getContentType() == null) goto L21;
        if (this.f30568h.getContentType().isEmpty() == true) goto L21;
        r100.setRequestProperty("Content-Type", this.f30568h.getContentType());
    L21:
        if (this.f30568h.getAccept() != null) goto L23;
    L25:
        Map<String, Object> r102 = this.f30568h.getCustom();
        if (r102 != null) goto L28;
        return;
    L28:
        if (r102.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L31:
        if (r103.hasNext() == false) goto L38;
        Map.Entry<String, Object> r104 = r103.next();
        r100.setRequestProperty(r104.getKey(), String.valueOf(r104.getValue()));
        goto L31
    L38:
        return;
    L37:
        return;
    L23:
        if (this.f30568h.getAccept().isEmpty() == true) goto L25;
        r100.setRequestProperty("accept", this.f30568h.getAccept());
        goto L25
    }

    public void request(String r100) {
        request(r100, null, null, null);
    }

    public void setHeader(HttpHeader r100) {
        this.f30568h = r100;
    }

    public void setMaxTimeOut(int r100) {
        this.f30564d = r100;
    }

    public void setReadTimeOut(int r100) {
        this.f30565e = r100;
    }

    public HttpClient(String r100, ProtoResultCallback r101) {
        this.f30561a = null;
        this.f30562b = null;
        this.f30564d = 10000;
        this.f30565e = 10000;
        this.f30566f = r100;
        this.f30567g = r101;
    }

    private void a(Map<String, List<FileWrapper>> r110, OutputStream r111) throws IOException {
        if (r110 == null) goto L26;
        if (r110.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, List<FileWrapper>>> r100 = r110.entrySet().iterator();
    L8:
        if (r100.hasNext() == false) goto L26;
        Map.Entry<String, List<FileWrapper>> r101 = r100.next();
        Iterator<FileWrapper> r102 = r101.getValue().iterator();
    L11:
        if (r102.hasNext() == false) goto L8;
        FileWrapper r103 = r102.next();
        if (r103.getRawFile() != null) goto L14;
        byte[] r112 = r103.getFile();
        String r113 = r103.getMimeType();
        String r104 = r103.getName();
        if (r112 == null) goto L11;
        if (r112.length <= 0) goto L11;
        if (TextUtils.isEmpty(r113) == true) goto L11;
        if (TextUtils.isEmpty(r104) == true) goto L11;
        r111.write(("--bd_map_sdk_cc\r\n" + String.format(FILE_TEMPLATE, new Object[]{r101.getKey(), r104}) + "\r\n" + String.format("Content-Type: %s", new Object[]{r113}) + "\r\n\r\n").getBytes());
        r111.write(r112);
        r111.write("\r\n".getBytes());
        goto L11
    L14:
        File r105 = r103.getRawFile();
        r111.write(("--bd_map_sdk_cc\r\n" + String.format(FILE_TEMPLATE, new Object[]{r101.getKey(), r105.getName()}) + "\r\n" + String.format("Content-Type: %s", new Object[]{URLConnection.getFileNameMap().getContentTypeFor(r105.getName())}) + "\r\n\r\n").getBytes());
        a(r105, r111);
        r111.write("\r\n".getBytes());
    }

    private void a(File r100, OutputStream r101) throws IOException {
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        byte[] r103 = new byte[1024];
    L3:
        int r104 = r102.read(r103);
        if (r104 <= 0) goto L6;
        r101.write(r103, 0, r104);
    L6:
        if (r104 > 0) goto L3;
        r102.close();
    }

    private void a(String r100, OutputStream r101) throws IOException {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        r101.write(r100.getBytes());
        return;
    }

    private void a(HttpURLConnection r100, String r101, Map<String, List<FileWrapper>> r102) {
        if ("GET".equalsIgnoreCase(this.f30566f) == false) goto L13;
        return;
    L13:
        OutputStream r103 = r100.getOutputStream();     // Catch: IOException -> L9
        a(r101, r103);     // Catch: IOException -> L9
        a(r102, r103);     // Catch: IOException -> L9
        if (TextUtils.equals(this.f30568h.getContentType(), "multipart/form-data;boundary=bd_map_sdk_cc") == false) goto L7;
        r103.write("--bd_map_sdk_cc--\r\n".getBytes());     // Catch: IOException -> L9
    L7:
        r103.flush();     // Catch: IOException -> L9
        r103.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v15, types: [int] */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.StringBuilder] */
    public HttpResponse request(String r100, String r101, String r102, Map<String, List<FileWrapper>> r103) {
        this.f30561a = r100;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        this.f30561a += "?" + r101;
    L8:
        if (checkNetwork() == true) goto L14;
        ProtoResultCallback r104 = this.f30567g;
        if (r104 == null) goto L13;
        r104.onFailed(HttpStateError.NETWORK_ERROR);
    L13:
        return new HttpResponse(HttpStateError.NETWORK_ERROR);
    L14:
        HttpURLConnection r105 = a();
        this.f30563c = r105;
        if (r105 != null) goto L22;
        ProtoResultCallback r106 = this.f30567g;
        if (r106 == null) goto L20;
        r106.onFailed(HttpStateError.INNER_ERROR);
    L20:
        return new HttpResponse(HttpStateError.INNER_ERROR);
    L22:
        if (TextUtils.isEmpty(this.f30561a) == false) goto L118;
        ProtoResultCallback r107 = this.f30567g;
        if (r107 == null) goto L27;
        r107.onFailed(HttpStateError.REQUEST_ERROR);
    L27:
        return new HttpResponse(HttpStateError.REQUEST_ERROR);
    L118:
        this.f30563c.connect();     // Catch: Exception -> L106
        a(this.f30563c, r102, r103);     // Catch: Exception -> L106
        ?? r108 = this.f30563c.getResponseCode();     // Catch: Throwable -> L79 Exception -> L81
        if (200(0xc8, float:2.8E-43) != r108) goto L58;
        r108 = this.f30563c.getInputStream();     // Catch: Throwable -> L79 Exception -> L81
        BufferedReader r109 = new BufferedReader(new InputStreamReader(r108, "UTF-8"));     // Catch: Throwable -> L53 Exception -> L55
        StringBuffer r110 = new StringBuffer();     // Catch: Throwable -> L49 Exception -> L51
    L35:
        int r111 = r109.read();     // Catch: Throwable -> L49 Exception -> L51
        if (r111 == (-1)) goto L38;
        r110.append((char) r111);     // Catch: Throwable -> L49 Exception -> L51
        goto L35
    L38:
        this.f30562b = r110.toString();     // Catch: Throwable -> L49 Exception -> L51
        if (r108 == 0) goto L41;
        r109.close();     // Catch: Exception -> L106
        r108.close();     // Catch: Exception -> L106
    L41:
        HttpURLConnection r112 = this.f30563c;     // Catch: Exception -> L106
        if (r112 == null) goto L44;
        r112.disconnect();     // Catch: Exception -> L106
    L44:
        ProtoResultCallback r113 = this.f30567g;
        if (r113 == null) goto L48;
        r113.onSuccess(this.f30562b);
    L48:
        return new HttpResponse(this.f30562b);
    L51:
        Exception e100 = e;
    L85:
        if (Logger.debugEnable() == false) goto L87;
        e100.printStackTrace();     // Catch: Throwable -> L49
    L88:
        ProtoResultCallback r114 = this.f30567g;     // Catch: Throwable -> L49
        if (r114 == null) goto L91;
        r114.onFailed(HttpStateError.INNER_ERROR);     // Catch: Throwable -> L49
    L91:
        HttpResponse r115 = new HttpResponse(HttpStateError.INNER_ERROR);     // Catch: Throwable -> L49
        if (r108 == 0) goto L95;
        if (r109 == null) goto L95;
        r109.close();     // Catch: Exception -> L106
        r108.close();     // Catch: Exception -> L106
    L95:
        HttpURLConnection r116 = this.f30563c;     // Catch: Exception -> L106
        if (r116 == null) goto L98;
        r116.disconnect();     // Catch: Exception -> L106
    L98:
        return r115;
    L87:
        Logger.logW("HttpClient", e100.getMessage());     // Catch: Throwable -> L49
    L49:
        Throwable th10 = th;
    L99:
        if (r108 == 0) goto L102;
        if (r109 == null) goto L102;
        r109.close();     // Catch: Exception -> L106
        r108.close();     // Catch: Exception -> L106
    L102:
        HttpURLConnection r117 = this.f30563c;     // Catch: Exception -> L106
        if (r117 == null) goto L105;
        r117.disconnect();     // Catch: Exception -> L106
    L105:
        throw th10;     // Catch: Exception -> L106
    L58:
        if (r108 < 500(0x1f4, float:7.0E-43)) goto L61;
        HttpStateError r118 = HttpStateError.SERVER_ERROR;     // Catch: Throwable -> L79 Exception -> L81
    L65:
        if (Logger.debugEnable() == true) goto L67;
        Logger.logW("HttpClient", "Get response from server failed, http response code=" + r108 + ", error=" + r118);     // Catch: Throwable -> L79 Exception -> L81
    L71:
        ProtoResultCallback r119 = this.f30567g;     // Catch: Throwable -> L53 Exception -> L55
        if (r119 == null) goto L74;
        r119.onFailed(r118);     // Catch: Throwable -> L53 Exception -> L55
    L74:
        HttpResponse r120 = new HttpResponse(r118);     // Catch: Throwable -> L53 Exception -> L55
        HttpURLConnection r121 = this.f30563c;     // Catch: Exception -> L106
        if (r121 == null) goto L78;
        r121.disconnect();     // Catch: Exception -> L106
    L78:
        return r120;
    L67:
        Logger.logW("HttpClient", this.f30563c.getErrorStream().toString());     // Catch: Throwable -> L53 Exception -> L55
        goto L71
    L61:
        if (r108 < 400(0x190, float:5.6E-43)) goto L63;
        r118 = HttpStateError.REQUEST_ERROR;     // Catch: Throwable -> L79 Exception -> L81
        goto L65
    L63:
        r118 = HttpStateError.INNER_ERROR;     // Catch: Throwable -> L79 Exception -> L81
    L55:
        e = move-exception;
        ?? r122 = r108;
        e = e;
    L83:
        ?? r123 = r122;
        r109 = null;
        e100 = e;
        r108 = r123;
    L53:
        th = move-exception;
        r109 = null;
        th10 = th;
    L81:
        e = e;
        r122 = 0;
    L79:
        th = move-exception;
        r109 = null;
        th10 = th;
        r108 = 0;
    L106:
        e = move-exception;
        if (Logger.debugEnable() == false) goto L110;
        e.printStackTrace();
    L111:
        ProtoResultCallback r124 = this.f30567g;
        if (r124 == null) goto L115;
        r124.onFailed(HttpStateError.INNER_ERROR);
    L115:
        return new HttpResponse(HttpStateError.INNER_ERROR);
    L110:
        Logger.logW("HttpClient", e.getMessage());
        goto L111
    }
}
