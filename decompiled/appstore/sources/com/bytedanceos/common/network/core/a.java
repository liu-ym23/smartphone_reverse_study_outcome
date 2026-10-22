package com.bytedanceos.common.network.core;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ByteArrayPool;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.PoolingByteArrayOutputStream;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.network.error.ClientVersionLowError;
import com.bytedanceos.common.network.error.HttpServerError;
import com.bytedanceos.common.network.error.SSLNetworkError;
import com.bytedanceos.common.network.error.ServerSafeguardError;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.utils.q;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.message.BasicHeader;
import y8.g;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Network {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f9875c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f9876d = 3000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f9877e = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpStack f9878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteArrayPool f9879b;

    static {
        f9875c = VolleyLog.DEBUG;
    }

    public a(HttpStack r10) {
        this(r10, new ByteArrayPool(f9877e));
    }

    public static void c(String r10, Request r11, VolleyError r12) {
        RetryPolicy r13 = r11.getRetryPolicy();
        int r14 = r11.getTimeoutMs();
        r13.retry(r12);     // Catch: VolleyError -> L6
        r11.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{r10, Integer.valueOf(r14)}));
        return;
    L6:
        e = move-exception;
        r11.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{r10, Integer.valueOf(r14)}));
        throw e;
    }

    private static Map d(Header[] r10) {
        HashMap r11 = new HashMap();
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        Header r13 = r10[r12];
        if ((r13 instanceof BasicHeader) == false) goto L8;
        BasicHeader r14 = (BasicHeader) r13;
        r11.put(r14.getName(), r14.getValue());
    L9:
        r12 = r12 + 1;
        goto L4
    L8:
        r11.put(r13.getName(), r13.getValue());
        goto L9
    L10:
        return r11;
    }

    public final void a(Map r12, Request r13) {
        String r10 = (String) r12.get("Cache-Control");
        StringBuilder r11 = new StringBuilder();
        if (r10 == null) goto L17;
        String[] r14 = r10.split(",");
        int r15 = 0;
        long r16 = 0;
    L6:
        if (r15 >= r14.length) goto L19;
        String r17 = r14[r15].trim();
        if (r17.startsWith("max-age=") == false) goto L13;
        r16 = Long.parseLong(r17.substring(8));     // Catch: Exception -> L36
    L16:
        r15 = r15 + 1;
        goto L6
    L13:
        if (r11.length() == 0) goto L15;
        r11.append(",");
    L15:
        r11.append(r17);
    L19:
        if ((r13 instanceof g) == false) goto L24;
        if (r16 >= 300) goto L24;
        long r18 = ((g) r13).b();
    L30:
        if (r18 > 0) goto L32;
        return;
    L32:
        if (r11.length() == 0) goto L34;
        r11.append(",");
    L34:
        r11.append("max-age=" + r18);
        r12.put("Cache-Control", r11.toString());
        return;
    L24:
        if ((r13 instanceof ImageRequest) == true) goto L26;
    L28:
        r18 = 0;
        goto L30
    L26:
        if (r16 >= 7776000) goto L28;
        r18 = 7776000;
        goto L30
    L17:
        r16 = 0;
        goto L19
    }

    public final void b(Map r10, Cache.Entry r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        String r12 = r11.etag;
        if (r12 == null) goto L8;
        r10.put("If-None-Match", r12);
        return;
    }

    public final byte[] e(HttpEntity r10) {
        PoolingByteArrayOutputStream r11 = new PoolingByteArrayOutputStream(this.f9879b, (int) r10.getContentLength());
        InputStream r12 = r10.getContent();     // Catch: Throwable -> L9
        if (r12 == null) goto L18;
        byte[] r13 = this.f9879b.getBuf(1024);     // Catch: Throwable -> L9
    L6:
        int r14 = r12.read(r13);     // Catch: Throwable -> L9
        if (r14 == (-1)) goto L11;
        r11.write(r13, 0, r14);     // Catch: Throwable -> L9
        goto L6
    L11:
        byte[] r15 = r11.toByteArray();     // Catch: Throwable -> L9
        r10.consumeContent();     // Catch: IOException -> L14
    L15:
        this.f9879b.returnBuf(r13);
        r11.close();
        return r15;
    L14:
        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
        goto L15
    L18:
        throw new ServerError();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r10.consumeContent();     // Catch: IOException -> L21
    L22:
        this.f9879b.returnBuf(null);
        r11.close();
        throw th;
    L21:
        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
        goto L22
    }

    public final void f(long r10, Request r11, byte[] r12, StatusLine r13) {
        if (f9875c == false) goto L5;
    L6:
        Long r14 = Long.valueOf(r10);
        if (r12 == null) goto L9;
        Object r15 = Integer.valueOf(r12.length);
    L10:
        VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[]{r11, r14, r15, Integer.valueOf(r13.getStatusCode()), Integer.valueOf(r11.getRetryPolicy().getCurrentRetryCount())});
        return;
    L9:
        r15 = "null";
        goto L10
    L5:
        if (r10 > f9876d) goto L6;
    }

    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request r13) {
        if ((r13 instanceof ImageLoader.d) == true) goto L5;
    L11:
        long r10 = SystemClock.elapsedRealtime();
    L12:
        new HashMap();
        HashMap r11 = new HashMap();     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        b(r11, r13.getCacheEntry());     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        HttpResponse r12 = this.f9878a.performRequest(r13, r11);     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        StatusLine r14 = r12.getStatusLine();     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        int r15 = r14.getStatusCode();     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        Map r16 = d(r12.getAllHeaders());     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        a(r16, r13);     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        if (r15 == 304) goto L16;
        byte[] r17 = e(r12.getEntity());     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        f(SystemClock.elapsedRealtime() - r10, r13, r17, r14);     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
        if (r15 < 400) goto L53;
        if (r15 == 500) goto L51;
        if (r15 == 800) goto L49;
        if (r15 != 900) goto L47;
        throw new ServerSafeguardError(new IOException("http status code is " + r15));     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
    L47:
        throw new NetworkError(new IOException("http status code is " + r15));     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
    L49:
        throw new ClientVersionLowError(new IOException("http status code is " + r15));     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
    L51:
        throw new HttpServerError(new IOException("http status code is " + r15));     // Catch: IOException -> L17 MalformedURLException -> L19 ConnectTimeoutException -> L21 SocketTimeoutException -> L23 UnknownHostException -> L25 SSLException -> L27 SSLPeerUnverifiedException -> L29 SSLHandshakeException -> L31 OutOfMemoryError -> L33
    L53:
        return new NetworkResponse(r15, r17, r16, false);
    L16:
        return new NetworkResponse(304, r13.getCacheEntry().data, r16, true);
    L33:
        e = move-exception;
        e.P0(r13.getUrl(), true);
        throw new NetworkError(e);
    L19:
        e = move-exception;
        throw new RuntimeException("Bad URL " + r13.getUrl(), e);
    L23:
        e = move-exception;
        q.b();
        c("socket", r13, new NetworkError(e));
    L25:
        e = move-exception;
        q.b();
        throw new NetworkError(e);
    L31:
        e = move-exception;
        throw new SSLNetworkError(e);
    L29:
        e = move-exception;
        throw new SSLNetworkError(e);
    L27:
        e = move-exception;
        throw new SSLNetworkError(e);
    L21:
        e = move-exception;
        q.b();
        c(WsConstants.KEY_CONNECTION, r13, new NetworkError(e));
    L17:
        e = move-exception;
        throw new NetworkError(e);
    L5:
        if (((ImageLoader.d) r13).a() == false) goto L11;
        if (e.o0() == true) goto L11;
        throw new HttpServerError(new IOException("forbid to load big image"));
    }

    public a(HttpStack r10, ByteArrayPool r11) {
        this.f9878a = r10;
        this.f9879b = r11;
    }
}
