package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: loaded from: classes.dex */
public class HurlStack implements HttpStack {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    public interface UrlRewriter {
        String rewriteUrl(String r10);
    }

    public HurlStack() {
        this(null);
    }

    private static void addBodyIfExists(HttpURLConnection r10, Request<?> r11) throws IOException, AuthFailureError {
        byte[] r12 = r11.getBody();
        if (r12 == null) goto L6;
        r10.setDoOutput(true);
        r10.addRequestProperty("Content-Type", r11.getBodyContentType());
        DataOutputStream r13 = new DataOutputStream(r10.getOutputStream());
        r13.write(r12);
        r13.close();
        return;
    }

    private static HttpEntity entityFromConnection(HttpURLConnection r10) {
        BasicHttpEntity r11 = new BasicHttpEntity();
        InputStream r12 = r10.getInputStream();     // Catch: IOException -> L5
    L6:
        r11.setContent(r12);
        r11.setContentLength(r10.getContentLength());
        r11.setContentEncoding(r10.getContentEncoding());
        r11.setContentType(r10.getContentType());
        return r11;
    L5:
        r12 = r10.getErrorStream();
        goto L6
    }

    private static boolean hasResponseBody(int r10, int r11) {
        if (r10 != 4) goto L5;
    L13:
        return false;
    L5:
        if (100 > r11) goto L9;
        if (r11 < 200) goto L13;
    L9:
        if (r11 == 204) goto L13;
        if (r11 == 304) goto L13;
        return true;
    }

    private HttpURLConnection openConnection(URL r10, Request<?> r11) throws IOException {
        HttpURLConnection r12 = createConnection(r10);
        int r13 = r11.getTimeoutMs();
        r12.setConnectTimeout(r13);
        r12.setReadTimeout(r13);
        r12.setUseCaches(false);
        r12.setDoInput(true);
        if ("https".equals(r10.getProtocol()) == false) goto L7;
        SSLSocketFactory r14 = this.mSslSocketFactory;
        if (r14 == null) goto L7;
        ((HttpsURLConnection) r12).setSSLSocketFactory(r14);
    L7:
        return r12;
    }

    public static void setConnectionParametersForRequest(HttpURLConnection r10, Request<?> r11) throws IOException, AuthFailureError {
        switch(r11.getMethod()) {
            case -1: goto L14;
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r10.setRequestMethod(HttpClientStack.HttpPatch.METHOD_NAME);
        addBodyIfExists(r10, r11);
        return;
    L7:
        r10.setRequestMethod("TRACE");
        return;
    L8:
        r10.setRequestMethod("OPTIONS");
        return;
    L9:
        r10.setRequestMethod("HEAD");
        return;
    L10:
        r10.setRequestMethod("DELETE");
        return;
    L11:
        r10.setRequestMethod("PUT");
        addBodyIfExists(r10, r11);
        return;
    L12:
        r10.setRequestMethod("POST");
        addBodyIfExists(r10, r11);
        return;
    L13:
        r10.setRequestMethod("GET");
        return;
    L14:
        byte[] r12 = r11.getPostBody();
        if (r12 == null) goto L26;
        r10.setDoOutput(true);
        r10.setRequestMethod("POST");
        r10.addRequestProperty("Content-Type", r11.getPostBodyContentType());
        DataOutputStream r13 = new DataOutputStream(r10.getOutputStream());
        r13.write(r12);
        r13.close();
        return;
    L26:
        return;
    L5:
        throw new IllegalStateException("Unknown method type.");
    }

    public HttpURLConnection createConnection(URL r10) throws IOException {
        HttpURLConnection r11 = (HttpURLConnection) r10.openConnection();
        r11.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return r11;
    }

    @Override // com.android.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> r10, Map<String, String> r11) throws IOException, AuthFailureError {
        String r12 = r10.getUrl();
        HashMap r13 = new HashMap();
        r13.putAll(r10.getHeaders());
        r13.putAll(r11);
        UrlRewriter r14 = this.mUrlRewriter;
        if (r14 == null) goto L13;
        String r15 = r14.rewriteUrl(r12);
        if (r15 != null) goto L12;
        String r16 = String.valueOf(r12);
        if (r16.length() == 0) goto L9;
        String r17 = "URL blocked by rewriter: ".concat(r16);
    L11:
        throw new IOException(r17);
    L9:
        r17 = new String("URL blocked by rewriter: ");
        goto L11
    L12:
        r12 = r15;
    L13:
        HttpURLConnection r18 = openConnection(new URL(r12), r10);
        Iterator r19 = r13.keySet().iterator();
    L15:
        if (r19.hasNext() == false) goto L17;
        String r20 = (String) r19.next();
        r18.addRequestProperty(r20, (String) r13.get(r20));
        goto L15
    L17:
        setConnectionParametersForRequest(r18, r10);
        ProtocolVersion r21 = new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        if (r18.getResponseCode() == (-1)) goto L30;
        BasicStatusLine r22 = new BasicStatusLine(r21, r18.getResponseCode(), r18.getResponseMessage());
        BasicHttpResponse r23 = new BasicHttpResponse(r22);
        if (hasResponseBody(r10.getMethod(), r22.getStatusCode()) == false) goto L22;
        r23.setEntity(entityFromConnection(r18));
    L22:
        Iterator<Map.Entry<String, List<String>>> r24 = r18.getHeaderFields().entrySet().iterator();
    L24:
        if (r24.hasNext() == false) goto L28;
        Map.Entry<String, List<String>> r25 = r24.next();
        if (r25.getKey() == null) goto L24;
        r23.addHeader(new BasicHeader(r25.getKey(), r25.getValue().get(0)));
        goto L24
    L28:
        return r23;
    L30:
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    public HurlStack(UrlRewriter r10) {
        this(r10, null);
    }

    public HurlStack(UrlRewriter r10, SSLSocketFactory r11) {
        this.mUrlRewriter = r10;
        this.mSslSocketFactory = r11;
    }
}
