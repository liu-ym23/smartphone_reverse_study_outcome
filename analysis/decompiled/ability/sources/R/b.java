package R;

import H.h;
import U.i;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends HttpURLConnection {
    public static final h2.d c = W.a.f1470a;

    /* renamed from: a, reason: collision with root package name */
    public final HttpURLConnection f1133a;
    public V.a b;

    public b(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.f1133a = httpURLConnection;
    }

    public final void a() throws IOException {
        if (e().b()) {
            return;
        }
        e.b(e(), this.f1133a);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.f1133a.addRequestProperty(str, str2);
    }

    public final void b(V.a aVar) {
        if (aVar != null) {
            try {
                aVar.b.e.d = this.f1133a.usingProxy();
                a();
                S0.b.A(aVar);
            } catch (Exception unused) {
            }
        }
    }

    public final void c(Exception exc) {
        V.a aVarE = e();
        e.a(aVarE, exc);
        if (aVarE.b()) {
            return;
        }
        HttpURLConnection httpURLConnection = this.f1133a;
        e.b(aVarE, httpURLConnection);
        aVarE.b.e.d = httpURLConnection.usingProxy();
        S0.b.A(aVarE);
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        HttpURLConnection httpURLConnection = this.f1133a;
        e();
        try {
            V.a aVar = this.b;
            if (aVar != null) {
                i iVar = aVar.b;
                JSONObject jSONObject = iVar.f;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String requestProperty = httpURLConnection.getRequestProperty("Host");
                if (!TextUtils.isEmpty(requestProperty)) {
                    try {
                        jSONObject.put("Host", requestProperty);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                iVar.f = jSONObject;
            }
            d();
        } catch (Exception unused) {
        }
        try {
            httpURLConnection.connect();
        } catch (IOException e6) {
            c(e6);
            throw e6;
        }
    }

    public final void d() {
        HttpURLConnection httpURLConnection = this.f1133a;
        try {
            if (h.u) {
                if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("x-rum-traceparent"))) {
                    String strP0 = S0.b.P0();
                    httpURLConnection.setRequestProperty("x-rum-traceparent", strP0);
                    if (h.b) {
                        Log.d("ApmInsight", U7.a.e(new String[]{"x-rum-traceparent:" + strP0}));
                    }
                }
                if (!TextUtils.isEmpty(httpURLConnection.getRequestProperty("x-rum-tracestate")) || TextUtils.isEmpty(h.a())) {
                    return;
                }
                httpURLConnection.setRequestProperty("x-rum-tracestate", "app_id=" + h.a() + ",origin=rum");
                if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"x-rum-tracestate:app_id=" + h.a() + ",origin=rum"}));
                }
            }
        } catch (Throwable th) {
            if (h.b) {
                th.printStackTrace();
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        V.a aVar = this.b;
        if (aVar != null && !aVar.b()) {
            b(this.b);
        }
        this.f1133a.disconnect();
    }

    public final V.a e() {
        if (this.b == null) {
            V.a aVar = new V.a();
            this.b = aVar;
            int i = e.f1136a;
            String string = this.f1133a.getURL().toString();
            i iVar = aVar.b;
            iVar.i.c = string;
            iVar.g.f1247a = System.currentTimeMillis();
        }
        return this.b;
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.f1133a.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.f1133a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        HttpURLConnection httpURLConnection = this.f1133a;
        e();
        try {
            Object content = httpURLConnection.getContent();
            int contentLength = httpURLConnection.getContentLength();
            if (contentLength >= 0) {
                V.a aVarE = e();
                if (!aVarE.b()) {
                    aVarE.a(contentLength);
                    b(aVarE);
                }
            }
            return content;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() throws IOException {
        e();
        String contentEncoding = this.f1133a.getContentEncoding();
        a();
        return contentEncoding;
    }

    @Override // java.net.URLConnection
    public final int getContentLength() throws IOException {
        e();
        int contentLength = this.f1133a.getContentLength();
        a();
        return contentLength;
    }

    @Override // java.net.URLConnection
    public final String getContentType() throws IOException {
        e();
        String contentType = this.f1133a.getContentType();
        a();
        return contentType;
    }

    @Override // java.net.URLConnection
    public final long getDate() throws IOException {
        e();
        long date = this.f1133a.getDate();
        a();
        return date;
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.f1133a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.f1133a.getDoInput();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.f1133a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        HttpURLConnection httpURLConnection = this.f1133a;
        e();
        try {
            return new T.a(httpURLConnection.getErrorStream(), 0);
        } catch (Exception e) {
            e.toString();
            c.t();
            return httpURLConnection.getErrorStream();
        }
    }

    @Override // java.net.URLConnection
    public final long getExpiration() throws IOException {
        e();
        long expiration = this.f1133a.getExpiration();
        a();
        return expiration;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) throws IOException {
        e();
        String headerField = this.f1133a.getHeaderField(i);
        a();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j5) throws IOException {
        e();
        long headerFieldDate = this.f1133a.getHeaderFieldDate(str, j5);
        a();
        return headerFieldDate;
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i) throws IOException {
        e();
        int headerFieldInt = this.f1133a.getHeaderFieldInt(str, i);
        a();
        return headerFieldInt;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) throws IOException {
        e();
        String headerFieldKey = this.f1133a.getHeaderFieldKey(i);
        a();
        return headerFieldKey;
    }

    @Override // java.net.URLConnection
    public final Map getHeaderFields() throws IOException {
        e();
        Map<String, List<String>> headerFields = this.f1133a.getHeaderFields();
        a();
        return headerFields;
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() throws IOException {
        e();
        long ifModifiedSince = this.f1133a.getIfModifiedSince();
        a();
        return ifModifiedSince;
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        V.a aVarE = e();
        try {
            T.a aVar = new T.a(this.f1133a.getInputStream());
            e.b(aVarE, this.f1133a);
            a aVar2 = new a(this, aVarE, 0);
            C4.a aVar3 = aVar.c;
            synchronized (((ArrayList) aVar3.c)) {
                ((ArrayList) aVar3.c).add(aVar2);
            }
            return aVar;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.f1133a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() throws IOException {
        e();
        long lastModified = this.f1133a.getLastModified();
        a();
        return lastModified;
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        V.a aVarE = e();
        try {
            T.b bVar = new T.b(this.f1133a.getOutputStream());
            a aVar = new a(this, aVarE, 1);
            C4.a aVar2 = bVar.c;
            synchronized (((ArrayList) aVar2.c)) {
                ((ArrayList) aVar2.c).add(aVar);
            }
            return bVar;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() {
        return this.f1133a.getPermission();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.f1133a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.f1133a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public final Map getRequestProperties() {
        return this.f1133a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.f1133a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        e();
        try {
            int responseCode = this.f1133a.getResponseCode();
            a();
            return responseCode;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        e();
        try {
            String responseMessage = this.f1133a.getResponseMessage();
            a();
            return responseMessage;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.f1133a.getURL();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.f1133a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z10) {
        this.f1133a.setAllowUserInteraction(z10);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i) {
        this.f1133a.setChunkedStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i) {
        this.f1133a.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z10) {
        this.f1133a.setDefaultUseCaches(z10);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z10) {
        this.f1133a.setDoInput(z10);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z10) {
        this.f1133a.setDoOutput(z10);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i) {
        this.f1133a.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j5) {
        this.f1133a.setIfModifiedSince(j5);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z10) {
        this.f1133a.setInstanceFollowRedirects(z10);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i) {
        this.f1133a.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        e();
        try {
            this.f1133a.setRequestMethod(str);
            e().b.i.b = str;
        } catch (ProtocolException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.f1133a.setRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z10) {
        this.f1133a.setUseCaches(z10);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.f1133a.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.f1133a.usingProxy();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) throws IOException {
        e();
        String headerField = this.f1133a.getHeaderField(str);
        a();
        return headerField;
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        e();
        try {
            Object content = this.f1133a.getContent(clsArr);
            a();
            return content;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }
}
