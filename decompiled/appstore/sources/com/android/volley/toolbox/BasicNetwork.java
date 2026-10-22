package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = false;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    static {
        DEBUG = VolleyLog.DEBUG;
    }

    public BasicNetwork(HttpStack r10) {
        this(r10, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    private void addCacheHeaders(Map<String, String> r10, Cache.Entry r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        String r12 = r11.etag;
        if (r12 == null) goto L8;
        r10.put("If-None-Match", r12);
    L8:
        if (r11.lastModified <= 0) goto L11;
        r10.put("If-Modified-Since", DateUtils.formatDate(new Date(r11.lastModified)));
        return;
    }

    private static void attemptRetryOnException(String r10, Request<?> r11, VolleyError r12) throws VolleyError {
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

    public static Map<String, String> convertHeaders(Header[] r10) {
        TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11.put(r10[r12].getName(), r10[r12].getValue());
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private byte[] entityToBytes(HttpEntity r10) throws IOException, ServerError {
        PoolingByteArrayOutputStream r11 = new PoolingByteArrayOutputStream(this.mPool, (int) r10.getContentLength());
        InputStream r12 = r10.getContent();     // Catch: Throwable -> L9
        if (r12 == null) goto L18;
        byte[] r13 = this.mPool.getBuf(1024);     // Catch: Throwable -> L9
    L6:
        int r14 = r12.read(r13);     // Catch: Throwable -> L9
        if (r14 == (-1)) goto L11;
        r11.write(r13, 0, r14);     // Catch: Throwable -> L9
        goto L6
    L11:
        byte[] r15 = r11.toByteArray();     // Catch: Throwable -> L9
        r10.consumeContent();     // Catch: IOException -> L14
    L15:
        this.mPool.returnBuf(r13);
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
        this.mPool.returnBuf(null);
        r11.close();
        throw th;
    L21:
        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
        goto L22
    }

    private void logSlowRequests(long r10, Request<?> r11, byte[] r12, StatusLine r13) {
        if (DEBUG == false) goto L5;
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
        if (r10 > SLOW_REQUEST_THRESHOLD_MS) goto L6;
    }

    public void logError(String r10, String r11, long r12) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[]{r10, Long.valueOf(SystemClock.elapsedRealtime() - r12), r11});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.android.volley.toolbox.BasicNetwork] */
    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> r23) throws VolleyError {
        long r10 = SystemClock.elapsedRealtime();
    L3:
        Map<String, String> r11 = Collections.emptyMap();
        HashMap r12 = new HashMap();     // Catch: MalformedURLException -> L14 IOException -> L44 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        addCacheHeaders(r12, r23.getCacheEntry());     // Catch: MalformedURLException -> L14 IOException -> L44 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        HttpResponse r13 = this.mHttpStack.performRequest(r23, r12);     // Catch: MalformedURLException -> L14 IOException -> L44 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        StatusLine r14 = r13.getStatusLine();     // Catch: MalformedURLException -> L14 IOException -> L42 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        int r15 = r14.getStatusCode();     // Catch: MalformedURLException -> L14 IOException -> L42 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        Map<String, String> r16 = convertHeaders(r13.getAllHeaders());     // Catch: MalformedURLException -> L14 IOException -> L42 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        if (r15 == 304) goto L8;
    L39:
        e = e;
        r11 = r16;
    L41:
        ?? r17 = r11;
        byte[] r18 = null;
    L46:
        if (r13 == null) goto L60;
        int r19 = r13.getStatusLine().getStatusCode();
        VolleyLog.e("Unexpected response code %d for %s", new Object[]{Integer.valueOf(r19), r23.getUrl()});
        if (r18 == null) goto L58;
        NetworkResponse r20 = new NetworkResponse(r19, r18, r17, false, SystemClock.elapsedRealtime() - r10);
        if (r19 != 401) goto L52;
    L56:
        attemptRetryOnException("auth", r23, new AuthFailureError(r20));
        goto L3
    L52:
        if (r19 == 403) goto L56;
        throw new ServerError(r20);
    L58:
        throw new NetworkError(null);
    L60:
        throw new NoConnectionError(e);
    L19:
        if (r13.getEntity() == null) goto L23;
        byte[] r21 = entityToBytes(r13.getEntity());     // Catch: IOException -> L12 MalformedURLException -> L14 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
    L21:
        byte[] r22 = r21;
        ?? r24 = this;
        r24.logSlowRequests(SystemClock.elapsedRealtime() - r10, r23, r22, r14);     // Catch: MalformedURLException -> L14 IOException -> L35 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        if (r15 < 200) goto L38;
        if (r15 > 299) goto L38;
        return new NetworkResponse(r15, r22, r16, false, SystemClock.elapsedRealtime() - r10);
    L38:
        throw new IOException();     // Catch: MalformedURLException -> L14 IOException -> L33 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
    L33:
        e = e;
    L34:
        r17 = r24;
        r18 = r22;
    L35:
        e = e;
        r24 = r16;
    L12:
        e = e;
        r18 = null;
        r17 = r16;
        goto L46
    L23:
        r21 = new byte[0];     // Catch: MalformedURLException -> L14 IOException -> L39 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        goto L21
    L8:
        Cache.Entry r25 = r23.getCacheEntry();     // Catch: IOException -> L12 MalformedURLException -> L14 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        if (r25 == null) goto L11;
        r25.responseHeaders.putAll(r16);     // Catch: IOException -> L12 MalformedURLException -> L14 ConnectTimeoutException -> L67 SocketTimeoutException -> L68
        return new NetworkResponse(304, r25.data, r25.responseHeaders, true, SystemClock.elapsedRealtime() - r10);
    L11:
        return new NetworkResponse(304, null, r16, true, SystemClock.elapsedRealtime() - r10);
    L42:
        e = e;
    L44:
        e = e;
        r17 = r11;
        r13 = null;
        r18 = null;
    L14:
        e = move-exception;
        String r26 = String.valueOf(r23.getUrl());
        if (r26.length() == 0) goto L64;
        String r27 = "Bad URL ".concat(r26);
    L66:
        throw new RuntimeException(r27, e);
    L64:
        r27 = new String("Bad URL ");
    L68:
        attemptRetryOnException("socket", r23, new TimeoutError());
    L67:
        attemptRetryOnException(WsConstants.KEY_CONNECTION, r23, new TimeoutError());
        goto L3
    }

    public BasicNetwork(HttpStack r10, ByteArrayPool r11) {
        this.mHttpStack = r10;
        this.mPool = r11;
    }
}
