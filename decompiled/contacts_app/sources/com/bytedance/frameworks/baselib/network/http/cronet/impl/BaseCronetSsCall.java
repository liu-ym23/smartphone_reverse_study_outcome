package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.parser.RequestTimeoutParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseCronetSsCall extends BaseSsCall implements IMetricsCollect {
    private static final String BODY_CONTENT_ENCODING = "x-bd-content-encoding";
    private static final int CHUNK_SIZE = 4096;
    private static final String INTERNET_DISCONNECTED = "net::ERR_INTERNET_DISCONNECTED";
    private static final String TAG = "BaseCronetSsCall";
    protected static volatile boolean TNC_USE_ZERO_COPY_READ = true;
    protected static volatile boolean USER_USE_ZERO_COPY_READ = false;
    private static final String USE_TTNET_CONTENT_ENCODING = "x-metasec-content-encoding";
    protected volatile int responseCode;
    private volatile long throttleNetSpeed;

    static {
    }

    abstract HttpURLConnection connection();

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean fromCache() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean isGzip() {
        return false;
    }

    void setConnection(HttpURLConnection r1) {
    }

    public static void setTncUseZeroCopyRead(boolean r0) {
        TNC_USE_ZERO_COPY_READ = r0;
    }

    public static void setUseZeroCopyRead(boolean r0) {
        USER_USE_ZERO_COPY_READ = r0;
    }

    BaseCronetSsCall(Request r3) {
        super(r3);
        this.responseCode = 0;
        this.throttleNetSpeed = 0;
        this.requestInfo.httpClientType = 0;     // Catch: Exception -> L5
        BaseHttpRequestInfo r4 = this.requestInfo;     // Catch: Exception -> L5
        r4.requestStartAppResumeState = SsCronetHttpClient.GetAppActivityResumeState();     // Catch: Exception -> L5
        this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, SsCronetHttpClient.TAG);     // Catch: Exception -> L5
        this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, SsCronetHttpClient.getCronetVersion());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r1) {
        this.throttleNetSpeed = r1;
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public int responseCode() {
        return this.responseCode;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public long contentLength() {
        if (connection() != null) goto L7;
        return 0;
    L7:
        return connection().getContentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String contentType() {
        return responseHeaderValue("Content-Type");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public Map<String, List<String>> responseHeaders() {
        if (connection() != null) goto L7;
        return null;
    L7:
        return connection().getHeaderFields();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseHeaderValue(String r3) {
        if (connection() != null) goto L6;
        return null;
    L6:
        String r0 = connection().getHeaderField(r3);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return connection().getHeaderField(r3.toLowerCase());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream inputStream() throws IOException {
        if (connection() != null) goto L7;
        return null;
    L7:
        return connection().getInputStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream errorStream() {
        if (connection() != null) goto L7;
        return null;
    L7:
        return connection().getErrorStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseMessage() throws IOException {
        if (connection() != null) goto L7;
        return "";
    L7:
        return connection().getResponseMessage();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public void safeClose() {
        if (connection() == null) goto L6;
        connection().disconnect();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.RequestLogProvider
    public void updateRequestInfoWithRequestLog(BaseHttpRequestInfo r8) {
        Map<String, Object> r7 = SsCronetHttpClient.getRequestMetricsMap(connection());
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L16;
        r8.remoteIp = (String) getValue(r7.get(ICronetClient.KEY_REMOTE_IP), String.class, "");
        r8.dnsTime = ((Long) getValue(r7.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();
        r8.connectTime = ((Long) getValue(r7.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();
        r8.sslTime = ((Long) getValue(r7.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();
        r8.sendTime = ((Long) getValue(r7.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();
        r8.pushTime = ((Long) getValue(r7.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L)).longValue();
        r8.receiveTime = ((Long) getValue(r7.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();
        r8.isSocketReused = ((Boolean) getValue(r7.get(ICronetClient.KEY_SOCKET_REUSED), Boolean.class, false)).booleanValue();
        r8.ttfbMs = ((Long) getValue(r7.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();
        r8.totalTime = ((Long) getValue(r7.get(ICronetClient.KEY_TOTAL_TIME), Long.class, -1L)).longValue();
        r8.sentByteCount = ((Long) getValue(r7.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();
        r8.receivedByteCount = ((Long) getValue(r7.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();
        r8.requestLog = (String) getValue(r7.get("request_log"), String.class, "");
        r8.retryAttempts = ((Long) getValue(r7.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L)).longValue();
        r8.requestHeaders = (String) getValue(r7.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");
        r8.responseHeaders = (String) getValue(r7.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");
        r8.nativePostTaskStartTime = ((Long) getValue(r7.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L)).longValue();
        r8.nativeRequestStartTime = ((Long) getValue(r7.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L)).longValue();
        r8.nativeWaitContext = ((Long) getValue(r7.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L)).longValue();
        r8.hasSampled = ((Boolean) getValue(r7.get(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE), Boolean.class, false)).booleanValue();
        r8.bypassApiReport = ((Boolean) getValue(r7.get(ICronetClient.KEY_BYPASS_API_REPORT), Boolean.class, false)).booleanValue();
        if (r8.metrics == null) goto L11;
        RetrofitMetrics r0 = r8.metrics;
        r0.upperAddCookieDurationUs = ((Long) getValue(r7.get(ICronetClient.KEY_UPPER_ADD_COOKIE_US), Long.class, -1L)).longValue();
        RetrofitMetrics r1 = r8.metrics;
        r1.upperSaveCookieDurationUs = ((Long) getValue(r7.get(ICronetClient.KEY_UPPER_SAVE_COOKIE_US), Long.class, -1L)).longValue();
        RetrofitMetrics r2 = r8.metrics;
        r2.requestCookieSourceType = ((Integer) getValue(r7.get(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE), Integer.class, -1)).intValue();
    L11:
        if (TextUtils.isEmpty(r8.requestLog) == false) goto L15;
        addABTestInfo(r8.extraInfo);
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T getValue(Object r1, Class<T> r2, T r3) {
        if (r1 != 0) goto L4;
    L6:
        return r3;
    L4:
        if (r1.getClass().equals(r2) == false) goto L6;
        return r1;
    }

    private static void addABTestInfo(JSONObject r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (SsCronetHttpClient.getCronetTncInfoGet() == null) goto L7;
        JSONObject r0 = SsCronetHttpClient.getCronetTncInfoGet().getABTest();
    L8:
        if (r0 == null) goto L16;
        r2.put(BaseHttpRequestInfo.KEY_ABTEST, r0);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r0 = null;
        goto L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected boolean bypassNetworkStatusCheck() {
        if (this.bypassNetworkStatusCheck == false) goto L5;
    L8:
        return true;
    L5:
        if (SsCronetHttpClient.getGlobalBypassOfflineCheck() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected Context getContext() {
        return SsCronetHttpClient.getContext();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void prepareNetworkRequest(String r8, Request r9, BaseHttpRequestInfo r10, Map<String, String> r11) throws IOException {
        r10.customInputStreamSize = getCustomInputStreamBufferSize(r9);     // Catch: Exception -> L18
        if (TNC_USE_ZERO_COPY_READ == true) goto L6;
    L12:
        boolean r2 = false;
    L13:
        r10.useCronetInputStreamWithTTBuffer = r2;     // Catch: Exception -> L18
        if (Logger.debug() == false) goto L16;
        Logger.e(TAG, "url is " + r8 + " useCronetInputStreamWithTTBuffer: " + r10.useCronetInputStreamWithTTBuffer);     // Catch: Exception -> L18
    L16:
        HttpURLConnection r0 = constructConnection(r8, r10);     // Catch: Exception -> L18
        configureConnection(r9, r10, r0, r11);     // Catch: Exception -> L18
        setConnection(r0);     // Catch: Exception -> L18
        return;
    L6:
        if (USER_USE_ZERO_COPY_READ == false) goto L12;
        if (r10.customInputStreamSize > 0) goto L12;
        if (r10.downloadFile == true) goto L12;
        r2 = true;
    L18:
        e = move-exception;
        updateRequestInfoWithException(r8, r10, this, this, e);
        this.canceled = true;
        if ((e instanceof TTNetExceptionStorage) == false) goto L22;
        throw e;
    L22:
        TTNetExceptionStorage r7 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r7.setInfo(true, false, true, r8, r10.traceCode, r10);
        throw r7;
    }

    protected HttpURLConnection constructConnection(String r5, BaseHttpRequestInfo r6) throws IOException {
        long r0 = SystemClock.uptimeMillis();
        HttpURLConnection r4 = SsCronetHttpClient.openConnection(r5, r6);
        if (r6.metrics == null) goto L5;
        RetrofitMetrics r7 = r6.metrics;
        r7.openConnectionDuration = SystemClock.uptimeMillis() - r0;
    L5:
        return r4;
    }

    protected void configureConnection(Request r19, BaseHttpRequestInfo r20, HttpURLConnection r21, Map<String, String> r22) throws IOException {
        long r3 = SystemClock.uptimeMillis();
        r21.setRequestMethod(r19.getMethod());
        r21.setDoInput(true);
        r21.setInstanceFollowRedirects(true);
        if (r20.reqContext == 0) goto L5;
        r21.setInstanceFollowRedirects(r20.reqContext.followRedirectInternal);
    L5:
        String r0 = r19.getPath();
        if (r20.reqContext != 0) goto L8;
        int r6 = 0;
    L9:
        int r1 = SsCronetHttpClient.getCronetOutputStreamBufferSize(r0, r6);
        if (r1 <= 0) goto L18;
        Reflect.on(r21).call("setOutputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r1)});     // Catch: Throwable -> L15
        if (r19.getMetrics() == null) goto L18;
        r19.getMetrics().postBodyBufferSize = r1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        if (r20.customInputStreamSize <= 0) goto L24;
        Reflect.on(r21).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r20.customInputStreamSize)});     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        if (r20.reqContext == 0) goto L86;
        T r13 = r20.reqContext;
        if (r13.timeout_connect <= 0) goto L29;
        r21.setConnectTimeout((int) r13.timeout_connect);
    L29:
        if (r13.timeout_read <= 0) goto L32;
        r21.setReadTimeout((int) r13.timeout_read);
    L32:
        if (r13.protect_timeout > 0) goto L198;
        String r5 = "setSocketWriteTimeout";
    L55:
        int r7 = r13.request_type_flags;
        int r2 = r13.request_flag;
        if (r13.enable_http_cache == true) goto L58;
    L59:
        r2 = r2 | 16;
    L61:
        if (r13.byPassProxy == false) goto L63;
        r2 = r2 | 128;
    L63:
        if (r2 <= 0) goto L69;
        Reflect.on(r21).call("setRequestFlag", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r2)});     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    L69:
        if (r13.isCustomizedCookie == false) goto L71;
        r7 = r7 | 2;
    L71:
        if (r7 > 0) goto L190;
    L76:
        BaseRequestContext.AuthCredentials r4 = r13.authCredentials;
        if (r4 == null) goto L88;
        if (r4.username == null) goto L88;
        if (r4.password == null) goto L88;
        Reflect.on(r21).call("setAuthCredentials", new Class[]{String.class, String.class}, new Object[]{r4.username, r4.password});     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        th.printStackTrace();
    L88:
        if (r20.reqContext != 0) goto L90;
    L91:
        RequestTimeoutParser.SocketTimeoutParam r8 = new RequestTimeoutParser.SocketTimeoutParam();
        int r9 = RequestTimeoutParser.getRequestTimeout(r21.getURL(), r8);
        r21.addRequestProperty("x-ttnet-bypass-to", Integer.toString(r9));
        if (r9 <= 0) goto L186;
        Reflect.on(r21).call("setRequestTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9 * 1000)});     // Catch: Throwable -> L103
        r21.setConnectTimeout(0);     // Catch: Throwable -> L103
        r21.setReadTimeout(0);     // Catch: Throwable -> L103
        if (r8.connectTimeout <= 0) goto L97;
        Reflect.on(r21).call("setSocketConnectTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8.connectTimeout * 1000)});     // Catch: Throwable -> L103
    L97:
        if (r8.readTimeout <= 0) goto L100;
        Reflect.on(r21).call("setSocketReadTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8.readTimeout * 1000)});     // Catch: Throwable -> L103
    L100:
        if (r8.writeTimeout <= 0) goto L186;
        Reflect.on(r21).call(r5, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8.writeTimeout * 1000)});     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        th.printStackTrace();
    L186:
        Reflect.on(r21).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r19.getRequestPriorityLevel())});     // Catch: Throwable -> L107
    L110:
        if (r20.reqContext == 0) goto L114;
        long r10 = 0;
        if (r20.reqContext.throttle_net_speed <= 0) goto L115;
        long r11 = r20.reqContext.throttle_net_speed;
    L117:
        if (r11 > r10) goto L204;
    L122:
        Iterator<Header> r12 = r19.getHeaders().iterator();
        String r14 = "";
    L124:
        if (r12.hasNext() == false) goto L140;
        Header r15 = r12.next();
        if (StringUtils.isEmpty(r15.getName()) == true) goto L124;
        if (StringUtils.isEmpty(r15.getValue()) == true) goto L124;
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L136;
        if (BODY_CONTENT_ENCODING.equalsIgnoreCase(r15.getName()) == true) goto L124;
    L136:
        if ("User-Agent".equalsIgnoreCase(r15.getName()) == false) goto L138;
        r14 = r15.getValue();
    L138:
        r21.setRequestProperty(r15.getName(), r15.getValue());
        goto L124
    L140:
        if (StringUtils.isEmpty(r14) == false) goto L194;
        r14 = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(r14) == true) goto L194;
        r14 = r14 + " cronet/" + SsCronetHttpClient.getCronetVersion();     // Catch: Exception -> L145
    L147:
        r21.setRequestProperty("User-Agent", r14);
    L145:
        e = move-exception;
        e.printStackTrace();
    L194:
        r20.extraInfo.put(BaseHttpRequestInfo.KEY_USER_AGENT, r14);     // Catch: Exception -> L150
    L152:
        TypedOutput r16 = r19.getBody();
        if (r16 == null) goto L167;
        r21.setDoOutput(true);
        r21.setRequestProperty("Content-Type", r16.mimeType());
        String r17 = getRequestBodyStub(r16);
        if (r17 == null) goto L157;
        r21.setRequestProperty("X-SS-STUB", r17);
    L157:
        String r18 = tryCompressRequestBody(r16, r19);
        if (TextUtils.isEmpty(r18) == true) goto L161;
        r21.setRequestProperty(BODY_CONTENT_ENCODING, r18);
    L163:
        long r23 = r16.length();
        if (r23 == (-1)) goto L166;
        r21.setFixedLengthStreamingMode((int) r23);
        r21.setRequestProperty("Content-Length", String.valueOf(r23));
        goto L167
    L166:
        r21.setChunkedStreamingMode(4096);
        goto L167
    L161:
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L163;
        recordContentEncodingError(r19);
    L167:
        if (r22 != null) goto L169;
    L178:
        r20.url = r21.getURL();
        if (r20.metrics == null) goto L225;
        r20.metrics.prepareRequestDuration = SystemClock.uptimeMillis() - r3;
        r20.metrics.url = r20.url;
        return;
    L225:
        return;
    L169:
        if (r22.isEmpty() == true) goto L178;
        Iterator<Map.Entry<String, String>> r24 = r22.entrySet().iterator();
    L172:
        if (r24.hasNext() == false) goto L178;
        Map.Entry<String, String> r25 = r24.next();
        String r26 = r25.getKey();
        String r27 = r25.getValue();
        if (TextUtils.isEmpty(r26) == true) goto L172;
        if (TextUtils.isEmpty(r27) == true) goto L172;
        r21.setRequestProperty(r26, r27);
    L150:
        e = move-exception;
        e.printStackTrace();
        goto L152
    L204:
        Reflect.on(r21).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r11)});     // Catch: Throwable -> L120
    L120:
        th = move-exception;
        th.printStackTrace();
    L115:
        r11 = this.throttleNetSpeed;
        goto L117
    L114:
        r10 = 0;
    L107:
        th = move-exception;
        th.printStackTrace();
        goto L110
    L90:
        if (r20.reqContext.protect_timeout > 0) goto L186;
    L190:
        Reflect.on(r21).call("setRequestTypeFlags", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        th.printStackTrace();
        goto L76
    L58:
        if ((r7 & 1) > 0) goto L61;
    L198:
        Reflect r28 = Reflect.on(r21);     // Catch: Throwable -> L51
        Class<?>[] r110 = {Integer.TYPE};     // Catch: Throwable -> L51
        Object[] r111 = new Object[1];     // Catch: Throwable -> L51
        r111[0] = Integer.valueOf((int) r13.protect_timeout);     // Catch: Throwable -> L49
        r28.call("setRequestTimeout", r110, r111);     // Catch: Throwable -> L49
        r21.setConnectTimeout(0);     // Catch: Throwable -> L49
        r21.setReadTimeout(0);     // Catch: Throwable -> L49
        if (r13.socket_connect_timeout <= 0) goto L38;
    L43:
        Reflect.on(r21).call("setSocketConnectTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) r13.socket_connect_timeout)});     // Catch: Throwable -> L49
        Reflect.on(r21).call("setSocketReadTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) r13.socket_read_timeout)});     // Catch: Throwable -> L49
        r5 = "setSocketWriteTimeout";
        Reflect.on(r21).call(r5, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) r13.socket_write_timeout)});     // Catch: Throwable -> L47
    L47:
        th = th;
    L53:
        th.printStackTrace();
        goto L55
    L38:
        if (r13.socket_read_timeout > 0) goto L43;
        if (r13.socket_write_timeout > 0) goto L43;
        r5 = "setSocketWriteTimeout";
    L49:
        th = th;
        r5 = "setSocketWriteTimeout";
    L51:
        th = th;
        r5 = "setSocketWriteTimeout";
        goto L53
    L86:
        r5 = "setSocketWriteTimeout";
        goto L88
    L8:
        r6 = r20.reqContext.output_stream_buffer_size;
        goto L9
    }

    private static String getRequestBodyStub(TypedOutput r2) {
        if ((r2 instanceof AbsTypedOutput) == false) goto L5;
        AbsTypedOutput r0 = (AbsTypedOutput) r2;
        if (TextUtils.isEmpty(r0.bodyCompressType()) == true) goto L9;
        String r3 = r0.getBodyMd5Stub();
        if (TextUtils.isEmpty(r3) == false) goto L13;
        Logger.e(TAG, "Request compress body md5 shouldn't be null.");
    L13:
        return r3;
    L9:
        return r2.md5Stub();
    L5:
        return r2.md5Stub();
    }

    private static void recordContentEncodingError(Request r2) {
        if (r2.getMetrics() != null) goto L5;
        return;
    L5:
        Header r0 = r2.getFirstHeader(BODY_CONTENT_ENCODING);
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r0.getValue()) == true) goto L19;
        JSONObject r3 = r2.getMetrics().requestCompressInfo;
        if (r3 != null) goto L16;
        return;
    L16:
        r3.put("encode", r0.getValue());     // Catch: JSONException -> L15
        r3.put("disableReason", TTRequestCompressManager.DisableCompress.REMOVE_ENCODING.getReason());     // Catch: JSONException -> L15
        return;
    L20:
        return;
    }

    private static void recordRequestCompressInfo(long r3, long r5, int r7, long r8, Request r10, TTRequestCompressManager.CompressData r11) {
        if (r10.getMetrics() != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("beforeSize", r3);     // Catch: JSONException -> L10
        if (r7 == 0) goto L12;
        r1.put("disableReason", r7);     // Catch: JSONException -> L10
    L12:
        if (r11 != null) goto L33;
        r10.getMetrics().requestCompressInfo = r1;
        return;
    L33:
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        r10.getMetrics().requestCompressInfo = r1;
        return;
    L16:
        if (TextUtils.isEmpty(r11.contentEncoding) == true) goto L19;
        r1.put("type", r11.contentEncoding);     // Catch: JSONException -> L29
        r1.put("afterSize", r5);     // Catch: JSONException -> L29
    L19:
        if (r11.failedCode == 0) goto L27;
        r1.put("disableReason", r11.failedCode);     // Catch: JSONException -> L29
        if (r11.failedCode == TTRequestCompressManager.DisableCompress.GZIP_PREFIX_MISMATCH.getReason()) goto L25;
        if (r11.failedCode != TTRequestCompressManager.DisableCompress.ZSTD_PREFIX_MISMATCH.getReason()) goto L27;
    L25:
        if (TextUtils.isEmpty(r11.failedPrefixData) == true) goto L27;
        r1.put("prefix", r11.failedPrefixData);     // Catch: JSONException -> L29
    L27:
        r1.put("duration", System.currentTimeMillis() - r8);     // Catch: JSONException -> L29
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static String tryCompressRequestBody(TypedOutput r11, Request r12) {
        if ((r11 instanceof AbsTypedOutput) == false) goto L22;
        if (r12 == null) goto L22;
        AbsTypedOutput r0 = (AbsTypedOutput) r11;
        if (TextUtils.isEmpty(r0.bodyCompressType()) == false) goto L9;
        long r2 = r11.length();
        long r7 = System.currentTimeMillis();
        if (r0.isBodyEncrypted() == true) goto L13;
    L16:
        TTRequestCompressManager.CompressData r9 = r0.compressRequestBody(r12.getHost(), r12.getPath(), shouldUseTTNetContentEncoding(r12));
        if (r9 != null) goto L20;
        recordRequestCompressInfo(r2, 0, TTRequestCompressManager.DisableCompress.DATA_NULL.getReason(), r7, r12, null);
        return null;
    L20:
        recordRequestCompressInfo(r2, r11.length(), 0, r7, r12, r9);
        return r9.contentEncoding;
    L13:
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L16;
        recordRequestCompressInfo(r2, 0, TTRequestCompressManager.DisableCompress.BODY_ENCRYPTED.getReason(), r7, r12, null);
        return null;
    L9:
        return r0.bodyCompressType();
    L22:
        return null;
    }

    private static boolean shouldUseTTNetContentEncoding(Request r1) {
        Header r2 = r1.getFirstHeader(USE_TTNET_CONTENT_ENCODING);
        if (r2 != null) goto L7;
        return false;
    L7:
        return "1".equals(r2.getValue());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void executeNetworkRequest() throws IOException {
        this.responseCode = executeConnection(connection());
    }

    protected int executeConnection(HttpURLConnection r2) throws IOException {
        TypedOutput r1 = this.retrofitRequest.getBody();
        if (r1 == null) goto L6;
        r1.writeTo(r2.getOutputStream());
    L6:
        return r2.getResponseCode();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void onResponseBodyProcessed(TypedInput r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L6;
        return;
    L6:
        if ((r3 instanceof TypedByteArray) == false) goto L14;
        StoreRegionManager.inst().updateStoreRegionForCronet(connection(), ((TypedByteArray) r3).getBytes(), new BaseCronetSsCall$$ExternalSyntheticLambda0());     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    static /* synthetic */ void lambda$onResponseBodyProcessed$0(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        SsCronetHttpClient.notifyStoreRegionUpdated(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void checkNetworkAvailableAfterRequest(Request r2, Exception r3) throws NetworkNotAvailabeException {
        checkCronetNetworkAvailableAfterRequest(SsCronetHttpClient.getGlobalBypassOfflineCheck(), r3.getMessage(), this.retrofitRequest.getPath());
    }

    private void checkCronetNetworkAvailableAfterRequest(boolean r2, String r3, String r4) throws NetworkNotAvailabeException {
        if (r2 == true) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (r3.contains(INTERNET_DISCONNECTED) == false) goto L12;
        NetworkNotAvailabeException r1 = new NetworkNotAvailabeException("network not available for " + r4 + ", message:" + r3);
        r1.setShouldReport(true);
        throw r1;
    }

    protected void cancelNormalRequestInner(HttpURLConnection r9, Throwable r10, boolean r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (this.canceled == true) goto L17;
        r9.disconnect();
        this.canceled = true;
        doCollect();
        BaseHttpRequestInfo r12 = this.requestInfo;
        r12.requestEnd = System.currentTimeMillis();
        BaseHttpRequestInfo r13 = this.requestInfo;
        r13.requestStartAppResumeState = SsCronetHttpClient.GetAppActivityResumeState();
        if (this.requestInfo.reqContext != 0) goto L9;
    L10:
        NetworkParams.reportOneNormalRequest(this.retrofitRequest, this.requestInfo, r10, Boolean.valueOf(r11));
    L12:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L16;
        StreamTrafficObservable.inst().onStreamTrafficChanged(this.retrofitRequest.getUrl(), this.requestInfo.sentByteCount, this.requestInfo.receivedByteCount, this.requestInfo.contentType, this.requestInfo.requestLog);
        return;
    L16:
        return;
    L9:
        if (this.requestInfo.reqContext.is_need_monitor_in_cancel == false) goto L12;
    }

    protected void cancelInner(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.canceled == true) goto L17;
        r10.disconnect();
        this.canceled = true;
        if (this.retrofitRequest.isResponseStreaming() == false) goto L16;
        doCollect();
        BaseHttpRequestInfo r11 = this.requestInfo;
        r11.requestEnd = System.currentTimeMillis();
        BaseHttpRequestInfo r12 = this.requestInfo;
        r12.requestStartAppResumeState = SsCronetHttpClient.GetAppActivityResumeState();
        if (this.requestInfo.reqContext != 0) goto L11;
    L12:
        NetworkParams.monitorApiOk(this.retrofitRequest.getUrl(), this.requestInfo);
    L13:
        StreamTrafficObservable.inst().onStreamTrafficChanged(this.retrofitRequest.getUrl(), this.requestInfo.sentByteCount, this.requestInfo.receivedByteCount, this.requestInfo.contentType, this.requestInfo.requestLog);
        return;
    L11:
        if (this.requestInfo.reqContext.is_need_monitor_in_cancel == false) goto L13;
    L16:
        return;
    }

    private int getCustomInputStreamBufferSize(Request r1) {
        return SsCronetHttpClient.getCronetInputstreamBuffSize(r1.getPath(), this.requestInfo);
    }
}
