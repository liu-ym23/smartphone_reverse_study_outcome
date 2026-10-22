package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.connectionclass.DeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.RotationHostRetryHandler;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.SsCallTTNetExtend;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSsCall implements SsCall, SsCallTTNetExtend, IRequestInfo, HttpResponseProvider, RequestLogProvider {
    private static volatile boolean TNC_USE_OKIO_READ = true;
    private static volatile boolean USER_USE_OKIO_READ = false;
    protected boolean bypassNetworkStatusCheck;
    protected volatile boolean canceled;
    protected BaseHttpRequestInfo requestInfo;
    protected Request retrofitRequest;

    static {
    }

    protected boolean bypassNetworkStatusCheck() {
        return false;
    }

    protected void checkNetworkAvailableAfterRequest(Request r1, Exception r2) throws NetworkNotAvailabeException {
    }

    protected abstract void executeNetworkRequest() throws IOException;

    protected abstract Context getContext();

    protected int getStatusCodeFromException(IOException r1) {
        return -1;
    }

    protected void onExecuteStart() throws IOException {
    }

    protected void onProcessExceptionStart(Exception r1) {
    }

    protected void onResponseBodyProcessed(TypedInput r1) {
    }

    protected abstract void prepareNetworkRequest(String r1, Request r2, BaseHttpRequestInfo r3, Map<String, String> r4) throws IOException;

    public static void setTncUseOkioRead(boolean r0) {
        TNC_USE_OKIO_READ = r0;
    }

    public static void setUseOkioRead(boolean r0) {
        USER_USE_OKIO_READ = r0;
    }

    protected BaseSsCall(Request r4) {
        this.bypassNetworkStatusCheck = false;
        this.canceled = false;
        this.retrofitRequest = r4;
        BaseHttpRequestInfo r1 = BaseHttpRequestInfo.createHttpRequestInfo();
        this.requestInfo = r1;
        r1.metrics = r4.getMetrics();
        if (this.requestInfo.metrics == null) goto L5;
        BaseHttpRequestInfo r5 = this.requestInfo;
        r5.appLevelRequestStart = r5.metrics.appLevelRequestStart;
        BaseHttpRequestInfo r6 = this.requestInfo;
        r6.beforeAllInterceptors = r6.metrics.beforeAllInterceptors;
    L5:
        BaseHttpRequestInfo r7 = this.requestInfo;
        r7.requestStart = System.currentTimeMillis();
        if (this.retrofitRequest.isResponseStreaming() == false) goto L8;
        this.requestInfo.downloadFile = true;
    L10:
        if ((this.retrofitRequest.getExtraInfo() instanceof BaseRequestContext) == false) goto L19;
        BaseHttpRequestInfo r8 = this.requestInfo;
        r8.reqContext = (T) this.retrofitRequest.getExtraInfo();
        this.bypassNetworkStatusCheck = this.requestInfo.reqContext.bypass_network_status_check;
        List<BaseRequestContext.RotationHostRetryInfo> r9 = this.requestInfo.reqContext.rotationHostRetryInfoList;
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.size() > 0) goto L16;
        return;
    L16:
        if (r9.size() > 3) goto L22;
        BaseHttpRequestInfo r3 = this.requestInfo;
        r3.rotationHostPathRetryHandler = new RotationHostRetryHandler(r9);
        return;
    L22:
        return;
    L19:
        return;
    L8:
        this.requestInfo.downloadFile = false;
        goto L10
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Request getRequest() {
        return this.retrofitRequest;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.requestInfo;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Response execute() throws IOException {
        if (this.requestInfo.metrics == null) goto L6;
        this.requestInfo.metrics.callExecuteStartTime = System.currentTimeMillis();
    L6:
        if (this.canceled == true) goto L69;
        onExecuteStart();
        tryNecessaryInit(this.retrofitRequest, this.requestInfo);
        checkNetworkAvailableBeforeRequest(bypassNetworkStatusCheck(), getContext(), this.retrofitRequest.getPath());
        prepareNetworkRequest(this.retrofitRequest.getUrl(), this.retrofitRequest, this.requestInfo, null);
        boolean r9 = false;
    L39:
        e = e;
    L70:
        onProcessExceptionStart(e);     // Catch: Throwable -> L57
        if ((e instanceof HttpResponseException) == false) goto L47;
        if (((HttpResponseException) e).getStatusCode() != 304) goto L47;
        throw e;     // Catch: Throwable -> L57
    L47:
        if ((e instanceof IOException) == true) goto L49;
    L52:
        updateRequestInfoWithException(this.retrofitRequest.getUrl(), this.requestInfo, this, this, e);     // Catch: Throwable -> L57
        checkNetworkAvailableAfterRequest(this.retrofitRequest, e);     // Catch: Throwable -> L57
        if (this.retrofitRequest.isResponseStreaming() == false) goto L56;
        this.requestInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L57
    L56:
        throw convertException(e);     // Catch: Throwable -> L57
    L49:
        if ("Canceled".equals(e.getMessage()) == false) goto L52;
        throw e;     // Catch: Throwable -> L57
    L57:
        th = th;
        boolean r11 = r9;
        r9 = true;
    L60:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L62;
        if (r9 == true) goto L62;
    L64:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L67;
        if (r11 == false) goto L67;
        DeviceBandwidthSampler.getInstance().stopSampling();
    L67:
        throw th;
    L62:
        safeClose();
    L37:
        th = th;
        r11 = false;
        goto L60
    L9:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L16;
        NetworkParams.ConnectionQualitySamplerHook r0 = NetworkParams.getConnectionQualitySamplerHook();     // Catch: Throwable -> L37 Exception -> L39
        if (r0 == null) goto L16;
        if (r0.shouldSampling(this.retrofitRequest.getUrl()) == false) goto L16;
        DeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L37 Exception -> L39
        r11 = true;
    L73:
        List<String> r12 = new ArrayList();     // Catch: Throwable -> L33 Exception -> L35
        executeNetworkRequest();     // Catch: IOException -> L20 Throwable -> L33 Exception -> L35
        r12 = retryRequestOnceIfNeeded(this.retrofitRequest, this.requestInfo, this, true, false);     // Catch: IOException -> L20 Throwable -> L33 Exception -> L35
    L23:
        onFinalResponseReceived(this.requestInfo, this);     // Catch: Throwable -> L33 Exception -> L35
        String r1 = this.retrofitRequest.getUrl();     // Catch: Throwable -> L33 Exception -> L35
        Request r2 = this.retrofitRequest;     // Catch: Throwable -> L33 Exception -> L35
        BaseHttpRequestInfo r3 = this.requestInfo;     // Catch: Throwable -> L33 Exception -> L35
        TypedInput r4 = processResponseBody(r1, r2, r3, this, this, this, isForceConstructResponse(r3));     // Catch: Throwable -> L33 Exception -> L35
        onResponseBodyProcessed(r4);     // Catch: Throwable -> L33 Exception -> L35
        Response r5 = new Response(this.retrofitRequest.getUrl(), responseCode(), responseMessage(), createHeaders(this, r12), r4);     // Catch: Throwable -> L33 Exception -> L35
        r5.setExtraInfo(this.requestInfo);     // Catch: Throwable -> L33 Exception -> L35
        r5.setTraceCode(this.requestInfo.traceCode);     // Catch: Throwable -> L33 Exception -> L35
    L25:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L29;
        safeClose();
    L29:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L32;
        if (r11 == false) goto L32;
        DeviceBandwidthSampler.getInstance().stopSampling();
    L32:
        return r5;
    L20:
        e = move-exception;
        tryRotationHostRetryOnGetResponseCodeException(this.retrofitRequest, getStatusCodeFromException(e), this.requestInfo, this, e, true);     // Catch: Throwable -> L33 Exception -> L35
    L35:
        e = e;
        r9 = r11;
    L33:
        th = th;
        goto L60
    L16:
        r11 = false;
        goto L73
    L69:
        throw new IOException("request canceled");
    }

    private static boolean isForceConstructResponse(BaseHttpRequestInfo r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.reqContext == 0) goto L8;
        if (r1.reqContext.streaming_force_return_response == false) goto L8;
        return true;
    }

    protected static void tryNecessaryInit(Request r4, BaseHttpRequestInfo r5) {
        long r0 = SystemClock.uptimeMillis();
        NetworkParams.tryApiProcessHookInit();
        if (NetworkParams.interceptCookie(r4.getExtraInfo()) == true) goto L6;
        NetworkParams.tryCookieManagerInit();
    L6:
        if (r5.metrics == null) goto L9;
        RetrofitMetrics r6 = r5.metrics;
        r6.tryNecessaryInitDuration = SystemClock.uptimeMillis() - r0;
        return;
    }

    protected static void checkNetworkAvailableBeforeRequest(boolean r1, Context r2, String r3) throws NetworkNotAvailabeException {
        if (r1 == true) goto L9;
        if (r2 != null) goto L5;
        return;
    L5:
        if (NetworkUtils.isNetworkAvailable(r2) == false) goto L8;
        return;
    L8:
        throw new NetworkNotAvailabeException("network not available for " + r3);
    }

    protected List<String> retryRequestOnceIfNeeded(Request r8, BaseHttpRequestInfo r9, HttpResponseProvider r10, boolean r11, boolean r12) throws IOException {
        RequestRetryResult r13 = NetworkParams.shouldRetryRequestOnceTime(r8, r10.responseCode(), r9, r8.getHeaders(), r10.responseHeaders(), r11, r12);
        ArrayList r14 = null;
        if (r13 == null) goto L12;
        if (r13.isRequestRetryEnabled() == false) goto L12;
        if (r9.rotationHostRetry == false) goto L9;
        r8 = r8.newBuilder().url(r13.getNextRetryUrl()).build();
    L9:
        retryCurrentRequestOneTime(r8, r9, r10, r13.getAddRequestHeaders());
        return null;
    L12:
        if (StringUtils.isEmpty(r9.retryByHeaderFilterKey) == true) goto L19;
        if (r13 != null) goto L15;
    L16:
        r14 = new ArrayList();
        if (StringUtils.isEmpty(r9.retryByHeaderFilterKey) == true) goto L19;
        r14.add(r9.retryByHeaderFilterKey);
        goto L19
    L15:
        if (r13.isRemoveHitResponseHeaderIfNotRetry() == true) goto L16;
    L19:
        return r14;
    }

    protected void retryCurrentRequestOneTime(Request r8, BaseHttpRequestInfo r9, HttpResponseProvider r10, Map<String, String> r11) throws IOException {
        r10.safeClose();
        r9.requestRetryStart = System.currentTimeMillis();
        prepareNetworkRequest(r8.getUrl(), r8, r9, r11);
        executeNetworkRequest();     // Catch: IOException -> L5
        retryRequestOnceIfNeeded(r8, r9, this, false, false);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        tryRotationHostRetryOnGetResponseCodeException(r8, getStatusCodeFromException(e), r9, r10, e, false);
    }

    private void tryRotationHostRetryOnGetResponseCodeException(Request r8, int r9, BaseHttpRequestInfo r10, HttpResponseProvider r11, IOException r12, boolean r13) throws IOException {
        RequestRetryResult r14 = NetworkParams.shouldRetryRequestOnceTime(r8, r9, r10, r8.getHeaders(), null, r13, false);
        if (r14 != null) goto L5;
        throw r12;
    L5:
        if (r14.isRequestRetryEnabled() == true) goto L7;
        throw r12;
    L7:
        if (r10.rotationHostRetry == false) goto L12;
        retryCurrentRequestOneTime(r8.newBuilder().url(r14.getNextRetryUrl()).build(), r10, r11, r14.getAddRequestHeaders());
        return;
    L12:
        throw r12;
    }

    protected void onFinalResponseReceived(BaseHttpRequestInfo r3, HttpResponseProvider r4) {
        r3.responseBack = System.currentTimeMillis();
        r3.contentType = BaseHttpClient.getContentBaseType(r4.contentType());
        getRemoteIp(r4.responseHeaderValue("x-net-info.remoteaddr"), r3);
        if (r3.reqContext == 0) goto L5;
        T r2 = r3.reqContext;
        r2.status = r4.responseCode();
    L5:
        r3.traceCode = r4.responseHeaderValue("X-TT-LOGID");
        if (r3.traceCode != null) goto L9;
        r3.traceCode = "";
    L9:
        if (r3.metrics == null) goto L11;
        RetrofitMetrics r5 = r3.metrics;
        r5.traceCode = r3.traceCode;
    L11:
        r3.fromCache = r4.fromCache();
    }

    private static void getRemoteIp(String r1, BaseHttpRequestInfo r2) {
        if (StringUtils.isEmpty(r1) == false) goto L10;
        return;
    L10:
        r2.remoteIp = r1;     // Catch: Throwable -> L9
        if (r2.reqContext == 0) goto L12;
        r2.reqContext.remoteIp = r1;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    protected static TypedInput processResponseBody(String r7, Request r8, BaseHttpRequestInfo r9, HttpResponseProvider r10, RequestLogProvider r11, SsCall r12, boolean r13) throws IOException {
        if (r8.isResponseStreaming() == false) goto L30;
        boolean r14 = isForceHandleResponse(r9);
        if (r10.responseCode() >= 200) goto L7;
    L8:
        if (r14 == false) goto L13;
    L9:
        TypedInput r15 = createStreamingResponseBody(r8, r9, r10, r12, r14);
        if (r15 != null) goto L36;
        if (r13 == true) goto L38;
        return r15;
    L38:
        return new TypedByteArray(r10.contentType(), new byte[0], new String[0]);
    L36:
        return r15;
    L13:
        String r16 = null;
        InputStream r17 = r10.inputStream();     // Catch: Throwable -> L16 Exception -> L18
    L15:
        InputStream r4 = r17;
        if (r4 == null) goto L21;
        r16 = processHttpErrorResponse(r9, r10.responseHeaders(), r8.getMaxLength(), r4, r10.contentType(), r10.isGzip());     // Catch: Throwable -> L16
    L21:
        r10.safeClose();
        String r18 = "";
    L24:
        HttpResponseException r19 = new HttpResponseException(r10.responseCode(), r18, r8.getPath(), r16);
        r9.hasReportStreamingApiAll.set(true);
        r19.setInfo(true, true, false, r7, r9.traceCode, r9);
        throw r19;
    L18:
        r17 = r10.errorStream();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        r18 = "reason = " + r10.responseMessage() + "  exception = " + th.getMessage();     // Catch: Throwable -> L26
        r10.safeClose();
    L26:
        th = move-exception;
        r10.safeClose();
        throw th;
    L7:
        if (r10.responseCode() < 300) goto L9;
    L30:
        return new TypedByteArray(r10.contentType(), processNonStreamingResponse(r7, r8.getMaxLength(), r9, r10, r11), new String[0]);
    }

    protected static String processHttpErrorResponse(BaseHttpRequestInfo r8, Map<String, List<String>> r9, int r10, InputStream r11, String r12, boolean r13) throws IOException {
        if (r11 != null) goto L45;
        return null;
    L45:
    L37:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L35
    L6:
        if (r8.useCronetInputStreamWithTTBuffer == false) goto L8;
        byte[] r14 = StreamParser.readResponseWithZeroCopy(r13, r9, r10, r11, r8.metrics);     // Catch: Throwable -> L35 Exception -> L37
    L13:
        StreamParser.safeClose(r11);
        if (r14.length > 0) goto L16;
        return null;
    L16:
        if (StringUtils.isEmpty(r12) == false) goto L18;
        return null;
    L18:
        if (Logger.debug() == false) goto L20;
    L43:
        MimeType r15 = new MimeType(r12);     // Catch: Throwable -> L32
        if ("text".equalsIgnoreCase(r15.getPrimaryType()) == false) goto L24;
    L25:
        String r16 = r15.getParameter("charset");     // Catch: Throwable -> L32
        if (StringUtils.isEmpty(r16) == false) goto L29;
        r16 = Constant.CHARSET_UTF_8;
    L29:
        if (shouldReadErrorResponse(r8) == false) goto L50;
        return new String(r14, r16);
    L50:
        return null;
    L24:
        if ("application/json".equalsIgnoreCase(r15.getBaseType()) == true) goto L25;
        return null;
    L32:
        th = move-exception;
        th.printStackTrace();
        return null;
    L20:
        if (shouldReadErrorResponse(r8) == true) goto L43;
        return null;
    L8:
        int[] r1 = new int[1];     // Catch: Throwable -> L35 Exception -> L37
        byte[] r17 = StreamParser.readResponse(r13, r9, r10, r11, r1, r8.metrics);     // Catch: Throwable -> L35 Exception -> L37
        int r18 = r1[0];     // Catch: Throwable -> L35 Exception -> L37
        byte[] r2 = new byte[r18];     // Catch: Throwable -> L35 Exception -> L37
        if (r17 == null) goto L12;
        if (r18 <= 0) goto L12;
        System.arraycopy(r17, 0, r2, 0, r18);     // Catch: Throwable -> L35 Exception -> L37
    L12:
        r14 = r2;
    L35:
        th = move-exception;
        StreamParser.safeClose(r11);
        throw th;
    }

    private static boolean shouldReadErrorResponse(BaseHttpRequestInfo r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.reqContext == 0) goto L8;
        if (r1.reqContext.read_error_response == false) goto L8;
        return true;
    }

    protected static TypedInput createStreamingResponseBody(final Request r7, final BaseHttpRequestInfo r8, final HttpResponseProvider r9, final SsCall r10, final boolean r11) throws IOException {
        if (r9.contentLength() != 0) goto L7;
        r10.cancel();
        return null;
    L7:
        return new AnonymousClass1(r9, r8, r11, r7, r10);
    }

    protected static byte[] processNonStreamingResponse(String r9, int r10, BaseHttpRequestInfo r11, HttpResponseProvider r12, RequestLogProvider r13) throws IOException {
        if (r12.responseCode() != 200) goto L5;
    L25:
        r11.completeReadResponse = System.currentTimeMillis();
        InputStream r0 = r12.inputStream();     // Catch: Exception -> L28
    L58:
    L50:
        th = move-exception;
        StreamParser.safeClose(r0);
        throw th;
    L52:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L50
    L33:
        if (r11.useCronetInputStreamWithTTBuffer == false) goto L36;
        byte[] r14 = StreamParser.readResponseWithZeroCopy(r12.isGzip(), r12.responseHeaders(), r10, r0, r11.metrics);     // Catch: Throwable -> L50 Exception -> L52
    L45:
        StreamParser.safeClose(r0);
        if (StreamParser.testIsSSBinary(r12.contentType()) == false) goto L48;
        StreamParser.decodeSSBinary(r14, r14.length);
    L48:
        r11.requestEnd = System.currentTimeMillis();
        r11.requestEndAppResumeState = BaseHttpClient.GetAppActivityResumeState();
        getRequestMetrics(r11, r13);
        NetworkParams.handleApiOk(r9, r11);
        return r14;
    L36:
        if (TNC_USE_OKIO_READ == true) goto L38;
    L40:
        int[] r7 = new int[1];     // Catch: Throwable -> L50 Exception -> L52
        byte[] r15 = StreamParser.readResponse(r12.isGzip(), r12.responseHeaders(), r10, r0, r7, r11.metrics);     // Catch: Throwable -> L50 Exception -> L52
        int r2 = r7[0];     // Catch: Throwable -> L50 Exception -> L52
        byte[] r3 = new byte[r2];     // Catch: Throwable -> L50 Exception -> L52
        if (r15 == null) goto L44;
        if (r2 <= 0) goto L44;
        System.arraycopy(r15, 0, r3, 0, r2);     // Catch: Throwable -> L50 Exception -> L52
    L44:
        r14 = r3;
        goto L45
    L38:
        if (USER_USE_OKIO_READ == false) goto L40;
        r14 = StreamParser.readResponseWithOkio(r12.isGzip(), r12.responseHeaders(), r10, r0, r11.metrics);     // Catch: Throwable -> L50 Exception -> L52
    L28:
        e = move-exception;
        if (isForceHandleResponse(r11) == false) goto L57;
        r0 = r12.errorStream();
        goto L58
    L57:
        throw e;
    L5:
        if (isForceHandleResponse(r11) == true) goto L25;
        if (r12.responseCode() != 304) goto L10;
        r11.completeReadResponse = System.currentTimeMillis();
        r11.requestEnd = System.currentTimeMillis();
        r11.requestEndAppResumeState = BaseHttpClient.GetAppActivityResumeState();
        getRequestMetrics(r11, r13);
        NetworkParams.handleApiOk(r9, r11);
    L10:
        String r16 = null;
        InputStream r1 = r12.inputStream();     // Catch: Throwable -> L13 Exception -> L15
    L12:
        InputStream r5 = r1;
        if (r5 == null) goto L18;
        r16 = processHttpErrorResponse(r11, r12.responseHeaders(), r10, r5, r12.contentType(), r12.isGzip());     // Catch: Throwable -> L13
    L18:
        r12.safeClose();     // Catch: Throwable -> L13
        String r17 = "";
    L21:
        HttpResponseException r4 = new HttpResponseException(r12.responseCode(), r17, HttpResponseException.getPathFromUrlString(r9), r16);
        if (r12.responseCode() != 304) goto L64;
        r4.setInfo(true, true, false, r9, r11.traceCode, r11);
        throw r4;
    L64:
        throw r4;
    L15:
        r1 = r12.errorStream();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        r17 = "reason = " + r12.responseMessage() + "  exception = " + th.getMessage();
        goto L21
    }

    private static boolean isForceHandleResponse(BaseHttpRequestInfo r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.reqContext == 0) goto L8;
        if (r1.reqContext.force_handle_response == false) goto L8;
        return true;
    }

    protected static void getRequestMetrics(BaseHttpRequestInfo r6, RequestLogProvider r7) {
        if (r7 == null) goto L5;
        r7.updateRequestInfoWithRequestLog(r6);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r6.metrics == null) goto L36;
        RetrofitMetrics r8 = r6.metrics;     // Catch: Throwable -> L31
        r8.cronetInitStart = TTNetInitMetrics.inst().createEngineStart;     // Catch: Throwable -> L31
        RetrofitMetrics r9 = r6.metrics;     // Catch: Throwable -> L31
        r9.cronetInitEnd = TTNetInitMetrics.inst().cronetInitEnd;     // Catch: Throwable -> L31
        RetrofitMetrics r10 = r6.metrics;     // Catch: Throwable -> L31
        r10.executeCallEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L31
        RetrofitMetrics r11 = r6.metrics;     // Catch: Throwable -> L31
        r11.retrofitLogReportTime = System.currentTimeMillis();     // Catch: Throwable -> L31
        r6.metrics.ttnetVersion = "4.2.228.16-pico";     // Catch: Throwable -> L31
        r6.metrics.extra.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(r6.sentByteCount));     // Catch: Throwable -> L31
        r6.metrics.extra.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(r6.receivedByteCount));     // Catch: Throwable -> L31
        JSONObject r12 = r6.extraInfo;     // Catch: Throwable -> L31
        if (r6.turingCallbackDuration < 0) goto L10;
        r12.put("turing_callback", r6.turingCallbackDuration);     // Catch: Throwable -> L31
    L10:
        if (r6.retryForAccountCallbackDuration < 0) goto L14;
        r12.put("retry_for_account_cost", r6.retryForAccountCallbackDuration);     // Catch: Throwable -> L31
    L14:
        if (r6.bdTuringRetry == false) goto L17;
        r12.put("turing_retry", "1");     // Catch: Throwable -> L31
    L17:
        if (r6.accountRetry == false) goto L20;
        r12.put("account_retry", "1");     // Catch: Throwable -> L31
    L20:
        if (r6.retryByHeaderFilterKey == null) goto L23;
        r12.put("retry_by_header", r6.retryByHeaderFilterKey);     // Catch: Throwable -> L31
    L23:
        if (r6.rotationHostPathRetryHandler == null) goto L29;
        JSONObject r0 = r6.rotationHostPathRetryHandler.constructJsonLog();     // Catch: Throwable -> L31
        if (r0 == null) goto L29;
        if (r0.length() <= 0) goto L29;
        r12.put("rotation_host_retry", r0);     // Catch: Throwable -> L31
        r6.metrics.rotationHostRetryInfo = r0;     // Catch: Throwable -> L31
    L29:
        r12.put("retrofit", r6.metrics.getRetrofitLog());     // Catch: Throwable -> L31
        return;
    }

    protected static List<Header> createHeaders(HttpResponseProvider r5, List<String> r6) {
        Map<String, List<String>> r7 = r5.responseHeaders();
        if (r7 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L27;
        Map.Entry<String, List<String>> r1 = r8.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L23;
        if (r6 == null) goto L23;
        if (r6.isEmpty() == true) goto L23;
        Iterator<String> r3 = r6.iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        if (r2.equalsIgnoreCase(r3.next()) == false) goto L16;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
    L20:
        r4 = false;
    L23:
        Iterator<String> r9 = r1.getValue().iterator();
    L25:
        if (r9.hasNext() == false) goto L8;
        r0.add(new Header(r2, r9.next()));
        goto L25
    L27:
        return r0;
    }

    protected static void updateRequestInfoWithException(String r3, BaseHttpRequestInfo r4, HttpResponseProvider r5, RequestLogProvider r6, Exception r7) {
        String r0 = getAllHeaderFieldsString(r5.responseHeaders());     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r0) == true) goto L5;
        r4.extraInfo.put("response-headers", r0);     // Catch: Throwable -> L13
    L5:
        String r1 = r7.getMessage();     // Catch: Throwable -> L13
        Throwable r2 = r7.getCause();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (r2 == null) goto L11;
        if (TextUtils.isEmpty(r2.getMessage()) == true) goto L11;
        r1 = r1 + ", cause = " + r2.getMessage();     // Catch: Throwable -> L13
    L11:
        r4.extraInfo.put(BaseHttpRequestInfo.KEY_EXCEPTION, r1);     // Catch: Throwable -> L13
    L15:
        r5.safeClose();
        if (StringUtils.isEmpty(r4.remoteIp) == false) goto L18;
        getRemoteIp(getHostAddress(r7), r4);
    L18:
        r4.requestEnd = System.currentTimeMillis();
        if (r4.downloadFile == false) goto L21;
        r4.hasReportStreamingApiAll.set(true);
    L21:
        getRequestMetrics(r4, r6);
        NetworkParams.handleApiError(r3, r7, r4);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r5.safeClose();
        throw th;
    }

    private static String getAllHeaderFieldsString(Map<String, List<String>> r8) {
        if (r8 != null) goto L37;
    L36:
        return "";
    L37:
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L5:
        if (r8.isEmpty() == true) goto L36;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L34
        Iterator<Map.Entry<String, List<String>>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L34
    L9:
        if (r9.hasNext() == false) goto L32;
        Map.Entry<String, List<String>> r2 = r9.next();     // Catch: Throwable -> L34
        if (r2 == null) goto L9;
        String r3 = r2.getKey();     // Catch: Throwable -> L34
        if (StringUtils.isEmpty(r3) == true) goto L9;
        List<String> r4 = r2.getValue();     // Catch: Throwable -> L34
        if (r4 == null) goto L9;
        if (r4.isEmpty() == true) goto L9;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L34
        Iterator<String> r6 = r4.iterator();     // Catch: Throwable -> L34
        int r7 = 0;
    L23:
        if (r6.hasNext() == false) goto L31;
        String r10 = r6.next();     // Catch: Throwable -> L34
        if (StringUtils.isEmpty(r10) == true) goto L23;
        if (r7 != 0) goto L29;
        r5.append(r10);     // Catch: Throwable -> L34
    L30:
        r7 = r7 + 1;     // Catch: Throwable -> L34
        goto L23
    L29:
        r5.append("; ").append(r10);     // Catch: Throwable -> L34
        goto L30
    L31:
        r1.put(r3, r5.toString());     // Catch: Throwable -> L34
        goto L9
    L32:
        return r1.toString();
    }

    private static String getHostAddress(Exception r3) {
        if (r3 != null) goto L18;
        return "";
    L18:
        String r1 = r3.getMessage();     // Catch: Throwable -> L15
        if (r1 != null) goto L8;
    L14:
        return "";
    L8:
        if (TextUtils.isEmpty(r3.getMessage()) == true) goto L14;
        String[] r4 = r1.split("\\|");     // Catch: Throwable -> L15
        if (r4.length < 2) goto L17;
        return r4[0];
    L17:
        return "";
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    protected IOException convertException(Exception r2) {
        return new IOException(r2.getMessage(), r2.getCause());
    }
}
