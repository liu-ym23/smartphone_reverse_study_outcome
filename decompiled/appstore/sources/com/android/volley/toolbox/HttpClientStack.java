package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes.dex */
public class HttpClientStack implements HttpStack {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    protected final HttpClient mClient;

    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "PATCH";

        public HttpPatch() {
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return METHOD_NAME;
        }

        public HttpPatch(URI r10) {
            setURI(r10);
        }

        public HttpPatch(String r10) {
            setURI(URI.create(r10));
        }
    }

    public HttpClientStack(HttpClient r10) {
        this.mClient = r10;
    }

    private static void addHeaders(HttpUriRequest r10, Map<String, String> r11) {
        Iterator<String> r12 = r11.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = r12.next();
        r10.setHeader(r13, r11.get(r13));
        goto L4
    }

    public static HttpUriRequest createHttpRequest(Request<?> r10, Map<String, String> r11) throws AuthFailureError {
        switch(r10.getMethod()) {
            case -1: goto L22;
            case 0: goto L21;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        HttpPatch r12 = new HttpPatch(r10.getUrl());
        r12.addHeader("Content-Type", r10.getBodyContentType());
        setEntityIfNonEmptyBody(r12, r10);
        return r12;
    L16:
        HttpPut r13 = new HttpPut(r10.getUrl());
        r13.addHeader("Content-Type", r10.getBodyContentType());
        setEntityIfNonEmptyBody(r13, r10);
        return r13;
    L18:
        HttpPost r14 = new HttpPost(r10.getUrl());
        r14.addHeader("Content-Type", r10.getBodyContentType());
        setEntityIfNonEmptyBody(r14, r10);
        return r14;
    L22:
        byte[] r15 = r10.getPostBody();
        if (r15 == null) goto L27;
        HttpPost r16 = new HttpPost(r10.getUrl());
        r16.addHeader("Content-Type", r10.getPostBodyContentType());
        r16.setEntity(new ByteArrayEntity(r15));
        return r16;
    L27:
        return new HttpGet(r10.getUrl());
    L5:
        throw new IllegalStateException("Unknown request method.");
    L9:
        return new HttpTrace(r10.getUrl());
    L11:
        return new HttpOptions(r10.getUrl());
    L13:
        return new HttpHead(r10.getUrl());
    L15:
        return new HttpDelete(r10.getUrl());
    L21:
        return new HttpGet(r10.getUrl());
    }

    private static List<NameValuePair> getPostParameterPairs(Map<String, String> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<String> r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = r12.next();
        r11.add(new BasicNameValuePair(r13, r10.get(r13)));
        goto L4
    L6:
        return r11;
    }

    private static void setEntityIfNonEmptyBody(HttpEntityEnclosingRequestBase r10, Request<?> r11) throws AuthFailureError {
        byte[] r12 = r11.getBody();
        if (r12 == null) goto L6;
        r10.setEntity(new ByteArrayEntity(r12));
        return;
    }

    public void onPrepareRequest(HttpUriRequest r10) throws IOException {
    }

    @Override // com.android.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> r10, Map<String, String> r11) throws IOException, AuthFailureError {
        HttpUriRequest r12 = createHttpRequest(r10, r11);
        addHeaders(r12, r11);
        addHeaders(r12, r10.getHeaders());
        onPrepareRequest(r12);
        HttpParams r13 = r12.getParams();
        int r14 = r10.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(r13, 5000);
        HttpConnectionParams.setSoTimeout(r13, r14);
        return this.mClient.execute(r12);
    }
}
