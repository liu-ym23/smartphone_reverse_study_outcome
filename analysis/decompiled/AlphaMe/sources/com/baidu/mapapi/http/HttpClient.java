package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.http.wrapper.FileWrapper;
import com.baidu.mapsdkplatform.comapi.util.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class HttpClient {
    public static final String BOUNDRYSTR = "bd_map_sdk_cc";
    public static final String ENDFLAG = "--";
    public static final String FILE_TEMPLATE = "Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"";
    public static final String NEWLINE = "\r\n";
    public static final String PARAM_TEMPLATE = "Content-Disposition: form-data; name=\"%s\"";
    public static boolean isHttpsEnable = true;

    /* renamed from: c, reason: collision with root package name */
    private HttpURLConnection f6020c;

    /* renamed from: f, reason: collision with root package name */
    private final String f6023f;

    /* renamed from: g, reason: collision with root package name */
    private ProtoResultCallback f6024g;

    /* renamed from: h, reason: collision with root package name */
    private HttpHeader f6025h;

    /* renamed from: a, reason: collision with root package name */
    private String f6018a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f6019b = null;

    /* renamed from: d, reason: collision with root package name */
    private int f6021d = 10000;

    /* renamed from: e, reason: collision with root package name */
    private int f6022e = 10000;

    public static class HttpHeader {

        /* renamed from: a, reason: collision with root package name */
        private String f6026a;

        /* renamed from: b, reason: collision with root package name */
        private String f6027b;

        /* renamed from: c, reason: collision with root package name */
        private String f6028c;

        /* renamed from: d, reason: collision with root package name */
        private String f6029d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, Object> f6030e;

        public HttpHeader() {
        }

        public String getAccept() {
            return this.f6029d;
        }

        public String getCharset() {
            return this.f6027b;
        }

        public String getConnection() {
            return this.f6026a;
        }

        public String getContentType() {
            return this.f6028c;
        }

        public Map<String, Object> getCustom() {
            return this.f6030e;
        }

        public HttpHeader setAccept(String str) {
            this.f6029d = str;
            return this;
        }

        public HttpHeader setCharset(String str) {
            this.f6027b = str;
            return this;
        }

        public HttpHeader setConnection(String str) {
            this.f6026a = str;
            return this;
        }

        public HttpHeader setContentType(String str) {
            this.f6028c = str;
            return this;
        }

        public HttpHeader setCustom(Map<String, Object> map) {
            this.f6030e = map;
            return this;
        }

        public HttpHeader(String str, String str2, String str3, String str4) {
            this.f6026a = str;
            this.f6027b = str2;
            this.f6028c = str3;
            this.f6029d = str4;
        }
    }

    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public static class b implements HostnameVerifier {
        private b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public HttpClient(String str) {
        this.f6023f = str;
    }

    private HttpURLConnection a() throws ProtocolException {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f6018a);
            if (isHttpsEnable) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new b());
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f6023f);
            httpURLConnection.setDoOutput(!"GET".equalsIgnoreCase(this.f6023f));
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.f6021d);
            httpURLConnection.setReadTimeout(this.f6022e);
            a(httpURLConnection);
            return httpURLConnection;
        } catch (Exception e4) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e4.printStackTrace();
            } else {
                Logger.logW("HttpClient", e4.getMessage());
            }
            return null;
        }
    }

    public static String getAuthToken() {
        return f.f8229F;
    }

    public static String getPhoneInfo() {
        return f.h();
    }

    public boolean checkNetwork() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                if (networkCapabilities.hasCapability(12)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            if (Logger.debugEnable()) {
                e4.printStackTrace();
            } else {
                Logger.logW("HttpClient", e4.getMessage());
            }
            e4.printStackTrace();
            return false;
        }
    }

    public void request(String str) throws Throwable {
        request(str, null, null, null);
    }

    public void setHeader(HttpHeader httpHeader) {
        this.f6025h = httpHeader;
    }

    public void setMaxTimeOut(int i4) {
        this.f6021d = i4;
    }

    public void setReadTimeOut(int i4) {
        this.f6022e = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015c A[Catch: all -> 0x00ae, TryCatch #4 {all -> 0x00ae, blocks: (B:34:0x009d, B:35:0x00a2, B:37:0x00a9, B:42:0x00b4, B:86:0x0156, B:88:0x015c, B:90:0x0167, B:92:0x0170, B:93:0x0175, B:89:0x0160), top: B:118:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160 A[Catch: all -> 0x00ae, TryCatch #4 {all -> 0x00ae, blocks: (B:34:0x009d, B:35:0x00a2, B:37:0x00a9, B:42:0x00b4, B:86:0x0156, B:88:0x015c, B:90:0x0167, B:92:0x0170, B:93:0x0175, B:89:0x0160), top: B:118:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0170 A[Catch: all -> 0x00ae, TryCatch #4 {all -> 0x00ae, blocks: (B:34:0x009d, B:35:0x00a2, B:37:0x00a9, B:42:0x00b4, B:86:0x0156, B:88:0x015c, B:90:0x0167, B:92:0x0170, B:93:0x0175, B:89:0x0160), top: B:118:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x018a A[Catch: Exception -> 0x00c3, TryCatch #3 {Exception -> 0x00c3, blocks: (B:28:0x0076, B:44:0x00bc, B:47:0x00c6, B:49:0x00ca, B:103:0x0192, B:104:0x0198, B:106:0x019c, B:107:0x019f, B:96:0x0180, B:97:0x0186, B:99:0x018a, B:81:0x014a, B:83:0x014e), top: B:117:0x0076 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v14, types: [int] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.mapapi.http.HttpClient.HttpResponse request(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.util.List<com.baidu.mapapi.http.wrapper.FileWrapper>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.http.HttpClient.request(java.lang.String, java.lang.String, java.lang.String, java.util.Map):com.baidu.mapapi.http.HttpClient$HttpResponse");
    }

    public static class HttpResponse {

        /* renamed from: a, reason: collision with root package name */
        private String f6031a;

        /* renamed from: b, reason: collision with root package name */
        private HttpStateError f6032b;

        public HttpResponse(String str) {
            this.f6031a = str;
            this.f6032b = HttpStateError.NO_ERROR;
        }

        public String getData() {
            return this.f6031a;
        }

        public HttpStateError getError() {
            return this.f6032b;
        }

        public void setData(String str) {
            this.f6031a = str;
        }

        public void setError(HttpStateError httpStateError) {
            this.f6032b = httpStateError;
        }

        public HttpResponse(HttpStateError httpStateError) {
            this.f6032b = httpStateError;
        }
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f6023f = str;
        this.f6024g = protoResultCallback;
    }

    private void a(HttpURLConnection httpURLConnection) {
        HttpHeader httpHeader = this.f6025h;
        if (httpHeader == null || httpURLConnection == null) {
            return;
        }
        if (httpHeader.getConnection() != null && !this.f6025h.getConnection().isEmpty()) {
            httpURLConnection.setRequestProperty("Connection", this.f6025h.getConnection());
        }
        if (this.f6025h.getCharset() != null && !this.f6025h.getCharset().isEmpty()) {
            httpURLConnection.setRequestProperty("Charset", this.f6025h.getCharset());
        }
        if (this.f6025h.getContentType() != null && !this.f6025h.getContentType().isEmpty()) {
            httpURLConnection.setRequestProperty("Content-Type", this.f6025h.getContentType());
        }
        if (this.f6025h.getAccept() != null && !this.f6025h.getAccept().isEmpty()) {
            httpURLConnection.setRequestProperty("accept", this.f6025h.getAccept());
        }
        Map<String, Object> custom = this.f6025h.getCustom();
        if (custom == null || custom.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : custom.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    private void a(HttpURLConnection httpURLConnection, String str, Map<String, List<FileWrapper>> map) throws IOException {
        if ("GET".equalsIgnoreCase(this.f6023f)) {
            return;
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            a(str, outputStream);
            a(map, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    private void a(String str, OutputStream outputStream) throws IOException {
        if (str == null || str.isEmpty()) {
            return;
        }
        outputStream.write(str.getBytes());
    }

    private void a(Map<String, List<FileWrapper>> map, OutputStream outputStream) throws IOException {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, List<FileWrapper>> entry : map.entrySet()) {
                for (FileWrapper fileWrapper : entry.getValue()) {
                    if (fileWrapper.getRawFile() != null) {
                        File rawFile = fileWrapper.getRawFile();
                        StringBuilder sb = new StringBuilder("--bd_map_sdk_cc\r\n");
                        sb.append(String.format(FILE_TEMPLATE, entry.getKey(), rawFile.getName()));
                        sb.append(NEWLINE);
                        sb.append("Content-Type: " + URLConnection.getFileNameMap().getContentTypeFor(rawFile.getName()));
                        sb.append("\r\n\r\n");
                        outputStream.write(sb.toString().getBytes());
                        a(rawFile, outputStream);
                        outputStream.write(NEWLINE.getBytes());
                    } else {
                        byte[] file = fileWrapper.getFile();
                        String mimeType = fileWrapper.getMimeType();
                        String name = fileWrapper.getName();
                        if (file != null && file.length > 0 && !TextUtils.isEmpty(mimeType) && !TextUtils.isEmpty(name)) {
                            StringBuilder sb2 = new StringBuilder("--bd_map_sdk_cc\r\n");
                            sb2.append(String.format(FILE_TEMPLATE, entry.getKey(), name));
                            sb2.append(NEWLINE);
                            sb2.append("Content-Type: " + mimeType);
                            sb2.append("\r\n\r\n");
                            outputStream.write(sb2.toString().getBytes());
                            outputStream.write(file);
                            outputStream.write(NEWLINE.getBytes());
                        }
                    }
                }
            }
        }
        outputStream.write("--bd_map_sdk_cc--\r\n".getBytes());
    }

    private void a(File file, OutputStream outputStream) throws IOException {
        int i4;
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        do {
            i4 = fileInputStream.read(bArr);
            if (i4 > 0) {
                outputStream.write(bArr, 0, i4);
            }
        } while (i4 > 0);
        fileInputStream.close();
    }
}
