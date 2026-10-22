package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class ConcurrentCronetSsCall extends BaseCronetSsCall implements WeakHandler.IHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String API_SOURCE_5XX_CODE = "tt-api-source-5xx";
    private static final String CANCELED_EXCEPTION_MESSAGE = "request canceled";
    private static final int CANCELED_INTERNAL = -999;
    private static final String CRONET_EXCEPTION_CLASS_NAME = "com.ttnet.org.chromium.net.impl.NetworkExceptionImpl";
    private static final int MSG_API_DELAY = 0;
    private static final int MSG_API_IMMEDIATE = 1;
    private static final String REQUEST_HEADERS_BYPASS_ROUTE_SELECTION = "x-tt-bp-rs";
    private static final String REQUEST_HEADERS_TRANSACTION_ID = "transaction-id";
    private static final String TAG = "ConcurrentCronetSsCall";
    private static final int TIME_DELTA = 1;
    private static String mCallFailureMessage;
    private static HandlerThread mHandlerThread;
    private static boolean mRetryForNot2xxCode;
    private static Class sCronetExceptionCls;
    private boolean mBypassRouteSelectionEnabled;
    private CountDownLatch mCallExecuteLatch;
    private volatile boolean mCleanUpDone;
    private long mConnectTimeInterval;
    private List<ConnectionAttempts> mConnectionAttempts;
    private final Object mConnectionLock;
    private volatile AtomicInteger mCurrentUrlIndex;
    private boolean mEnableRequestReportFix;
    private volatile int mFailedTimes;
    private ConnectionAttempts mFirstAttempt;
    private volatile HttpURLConnection mFirstFailedConnection;
    private String mFirstUrl;
    private WeakHandler mHandler;
    private String mOriginUrl;
    private List<HttpURLConnection> mPendingURLConnections;
    private long mRequestMaxWaitTime;
    private String mRsName;
    private String mRuleId;
    private Set<String> mSentHosts;
    private long mTNCRequestMaxWaitTime;
    private String mTransactionId;
    private List<String> mUrlList;
    private volatile HttpURLConnection mWinnerConnection;
    private volatile int mWinnerIndex;

    static class ConnectionAttempts {
        long mCleanUpTime;
        long mDispatchTime;
        String mDispatchedHost;
        String mDomain;
        long mEndTime;
        IOException mException;
        int mId;
        int mNetError;
        int mResponseCode;
        long mStartTime;
        Boolean sentAlready;

        ConnectionAttempts(String r4) {
            this.mId = -1;
            this.mDomain = r4;
            this.mStartTime = System.currentTimeMillis();
            this.mNetError = 0;
            this.mResponseCode = -1;
            this.mDispatchedHost = "";
            this.mDispatchTime = -1;
            this.sentAlready = false;
            this.mCleanUpTime = -1;
        }

        JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put("host", this.mDomain);     // Catch: JSONException -> L18
            r0.put("start", this.mStartTime);     // Catch: JSONException -> L18
            r0.put(TraceStatsConsts.STATS_KEY_END, this.mEndTime);     // Catch: JSONException -> L18
            r0.put("net_error", this.mNetError);     // Catch: JSONException -> L18
            r0.put("code", this.mResponseCode);     // Catch: JSONException -> L18
            IOException r1 = this.mException;     // Catch: JSONException -> L18
            if (r1 == null) goto L11;
            String r2 = r1.getMessage();     // Catch: JSONException -> L18
            if (TextUtils.isEmpty(r2) == false) goto L8;
        L10:
            r0.put("exception", r2);     // Catch: JSONException -> L18
            goto L11
        L8:
            if (r2.length() <= 64) goto L10;
            r2 = r2.substring(0, 64);     // Catch: JSONException -> L18
        L11:
            r0.put("dispatch", this.mDispatchTime);     // Catch: JSONException -> L18
            r0.put("dpHost", this.mDispatchedHost);     // Catch: JSONException -> L18
            if (this.sentAlready.booleanValue() == false) goto L14;
            r0.put("sentAlready", true);     // Catch: JSONException -> L18
        L14:
            long r3 = this.mCleanUpTime;     // Catch: JSONException -> L18
            if (r3 <= 0) goto L17;
            r0.put("cleanUpTime", r3);     // Catch: JSONException -> L18
        L17:
            return r0;
        }
    }

    static {
        mHandlerThread = new HandlerThread("Concurrent-Handler");
        mCallFailureMessage = null;
        sCronetExceptionCls = Class.forName(CRONET_EXCEPTION_CLASS_NAME);     // Catch: ClassNotFoundException -> L5
    L7:
        mHandlerThread.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public ConcurrentCronetSsCall(Request r10, CronetSsCallConfig.UrlMatchRule r11) {
        super(r10);
        this.mSentHosts = new CopyOnWriteArraySet();
        this.mFirstUrl = "";
        this.mFirstAttempt = null;
        this.mUrlList = new ArrayList();
        this.mConnectionLock = new Object();
        int r2 = 0;
        this.mCurrentUrlIndex = new AtomicInteger(0);
        this.mPendingURLConnections = new CopyOnWriteArrayList();
        this.mCleanUpDone = false;
        this.mWinnerConnection = null;
        this.mWinnerIndex = -1;
        this.mFirstFailedConnection = null;
        this.mConnectionAttempts = new CopyOnWriteArrayList();
        this.mFailedTimes = 0;
        this.mCallExecuteLatch = new CountDownLatch(1);
        this.mHandler = new WeakHandler(mHandlerThread.getLooper(), this);
        this.mEnableRequestReportFix = false;
        this.mTNCRequestMaxWaitTime = 0;
        String r0 = r10.getUrl();
        this.mOriginUrl = r0;
        Uri r1 = Uri.parse(r0);
        String r3 = r1.getScheme();
        String r4 = r3 + "://" + r1.getHost();
        String r5 = r1.getQuery();
        Iterator<String> r6 = r11.getDomainList().iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        String r7 = this.mOriginUrl.replaceFirst(r4, r3 + "://" + r6.next());
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (r5.contains("concurrent=") == true) goto L10;
        r7 = r7 + "&concurrent=" + r2;
    L10:
        if (r2 <= 0) goto L14;
        if (r5.contains("is_retry=") == true) goto L14;
        r7 = r7 + "&is_retry=1";
    L14:
        r2 = r2 + 1;
        this.mUrlList.add(r7);
        goto L4
    L15:
        this.mTransactionId = UUID.randomUUID().toString();
        this.mRuleId = r11.mRuleId;
        this.mRsName = r11.mRefineRsName;
        this.mConnectTimeInterval = r11.mConnectTimeInterval;
        mRetryForNot2xxCode = r11.mRetryForNot2xxCode;
        this.mBypassRouteSelectionEnabled = r11.mBypassRouteSelectionEnabled;
        this.mTNCRequestMaxWaitTime = r11.mTNCRequestMaxWaitTime;
        this.mEnableRequestReportFix = r11.mEnableRequestReportFix;
        computeRequestMaxWaitTime(r10);
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "Request max wait time milliseconds: " + this.mRequestMaxWaitTime + ", user max wait time: " + this.mTNCRequestMaxWaitTime + ", connect interval milliseconds: " + this.mConnectTimeInterval);
    L19:
        if (this.requestInfo.metrics == null) goto L27;
        this.requestInfo.metrics.transactionId = this.mTransactionId;
        this.requestInfo.metrics.isConcurrent = true;
        return;
    }

    private void computeRequestMaxWaitTime(Request r5) {
        this.mRequestMaxWaitTime = NetworkParams.getConnectTimeout() + NetworkParams.getIoTimeout();
        if ((r5.getExtraInfo() instanceof BaseRequestContext) == false) goto L12;
        BaseRequestContext r6 = (BaseRequestContext) r5.getExtraInfo();
        if (r6.protect_timeout <= 0) goto L8;
        this.mRequestMaxWaitTime = r6.protect_timeout;
        goto L12
    L8:
        if (r6.timeout_connect <= 0) goto L12;
        if (r6.timeout_read <= 0) goto L12;
        this.mRequestMaxWaitTime = r6.timeout_connect + r6.timeout_read;
    L12:
        this.mRequestMaxWaitTime += 1000;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public HttpURLConnection connection() {
        if (this.mWinnerConnection == null) goto L6;
        return this.mWinnerConnection;
    L6:
        return this.mFirstFailedConnection;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2.obj instanceof ConcurrentCronetSsCall) == false) goto L22;
        int r1 = r2.what;     // Catch: Throwable -> L14
        if (r1 != 0) goto L9;
        ((ConcurrentCronetSsCall) r2.obj).doApiTask();     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        if (r1 != 1) goto L17;
        ((ConcurrentCronetSsCall) r2.obj).doApiTaskAndCancelDelayedTask();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static boolean shouldRetryApiTaskFromHttpCode(int r3, String r4, String r5) {
        if (r3 < 200) goto L6;
        if (r3 >= 300) goto L6;
        return false;
    L6:
        if (r4 != null) goto L8;
    L10:
        if (r3 < 300) goto L17;
        if (r3 >= 600) goto L17;
        if (mRetryForNot2xxCode == true) goto L17;
        return false;
    L17:
        if (CronetSsCallConfig.inst().inBlockErrorCode(r3, r5) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (r4.equals("1") == false) goto L10;
        return false;
    }

    private void doApiTask() {
        ApiTask r6 = new ApiTask("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new ConcurrentCronetSsCall$$ExternalSyntheticLambda0(this), this.requestInfo.downloadFile);
        RequestQueue.getDefaultRequestQueue().add(r6);
        scheduleApiTask(this.mConnectTimeInterval);
    }

    /* JADX INFO: renamed from: lambda$doApiTask$0$com-bytedance-frameworks-baselib-network-http-cronet-impl-ConcurrentCronetSsCall, reason: not valid java name */
    /* synthetic */ void m234x9b991af3() {
        long r4 = SystemClock.uptimeMillis();
        HttpURLConnection r6 = null;
        String r7 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        Object r8 = this.mConnectionLock;     // Catch: IOException -> L98
        monitor-enter(r8);     // Catch: IOException -> L98
    L90:
        th = th;
        String r9 = null;
        ConnectionAttempts r10 = null;
    L92:
        monitor-exit(r8);     // Catch: Throwable -> L96
        throw th;     // Catch: IOException -> L94
    L94:
        e = e;
    L100:
        Object r2 = this.mConnectionLock;
        monitor-enter(r2);
        int r3 = -1;
        Class r11 = sCronetExceptionCls;     // Catch: Throwable -> L158
        if (r11 == null) goto L171;
        if (r11.isInstance(e) == false) goto L171;
        r3 = ((Integer) Reflect.on(e).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L158
        if (Logger.debug() == false) goto L171;
        Logger.d(TAG, "cronet error code: " + r3);     // Catch: Throwable -> L158
    L171:
    L155:
        th = move-exception;
        throw th;
    L111:
        if (this.mFirstFailedConnection != null) goto L117;
        if (Logger.debug() == false) goto L115;
        Logger.d(TAG, "Get first failed connection " + r6.getURL().toString());     // Catch: Throwable -> L155
    L115:
        this.mFirstFailedConnection = r6;     // Catch: Throwable -> L155
    L119:
        if (r6 == null) goto L124;
        r6.disconnect();     // Catch: Throwable -> L155
        if (r10 == null) goto L123;
        r10.mException = handleException(e, r9, r6, false);     // Catch: Throwable -> L155
        r10.mNetError = r3;     // Catch: Throwable -> L155
        r10.mEndTime = System.currentTimeMillis();     // Catch: Throwable -> L155
    L123:
        this.mPendingURLConnections.remove(r6);     // Catch: Throwable -> L155
    L124:
        int r0 = this.mFailedTimes + 1;     // Catch: Throwable -> L155
        this.mFailedTimes = r0;     // Catch: Throwable -> L155
        if (r0 < this.mUrlList.size()) goto L133;
        if (Logger.debug() == false) goto L129;
        Logger.d(TAG, "Try all urls failed countdown.");     // Catch: Throwable -> L155
    L129:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L155
        monitor-exit(r2);     // Catch: Throwable -> L155
        return;
    L133:
        if (this.mEnableRequestReportFix == false) goto L143;
        if (this.canceled == false) goto L143;
        if (Logger.debug() == false) goto L139;
        Logger.d(TAG, "User canceled.");     // Catch: Throwable -> L155
    L139:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L155
        monitor-exit(r2);     // Catch: Throwable -> L155
        return;
    L143:
        if (CronetSsCallConfig.inst().inBlockErrorCode(r3, this.mRuleId) == false) goto L151;
        if (Logger.debug() == false) goto L147;
        Logger.d(TAG, "inBlockErrorCode countdown.");     // Catch: Throwable -> L155
    L147:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L155
        monitor-exit(r2);     // Catch: Throwable -> L155
        return;
    L151:
        if ((SystemClock.uptimeMillis() - r4) >= this.mConnectTimeInterval) goto L153;
        accelerateNextTaskWhenFailed();     // Catch: Throwable -> L155
    L153:
        monitor-exit(r2);     // Catch: Throwable -> L155
        return;
    L117:
        if (Logger.debug() == false) goto L119;
        Logger.d(TAG, "Get non first failed connection " + r6.getURL().toString());     // Catch: Throwable -> L155
        goto L119
    L6:
        if (this.mCurrentUrlIndex.get() < this.mUrlList.size()) goto L8;
    L87:
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L90
        monitor-exit(r8);     // Catch: Throwable -> L90
        return;
    L8:
        if (this.mWinnerConnection != null) goto L87;
        if (this.mCallExecuteLatch.getCount() == 0) goto L87;
        if (this.canceled == true) goto L87;
        int r12 = this.mCurrentUrlIndex.get();     // Catch: Throwable -> L90
        r9 = this.mUrlList.get(r12);     // Catch: Throwable -> L90
    L85:
        th = th;
        r10 = null;
        goto L92
    L16:
        if (this.mRsName == null) goto L19;
        if (r12 <= 0) goto L19;
        UrlBuilder r13 = new UrlBuilder(r9);     // Catch: Throwable -> L85
        r13.addParam("bypass_rs", "1");     // Catch: Throwable -> L85
        r9 = r13.build();     // Catch: Throwable -> L85
    L19:
        r10 = new ConnectionAttempts(new URL(r9).getHost());     // Catch: Throwable -> L85
        this.mConnectionAttempts.add(r10);     // Catch: Throwable -> L96
        if (this.mRsName == null) goto L37;
        if (dropIfDuplicate(r9, r10).booleanValue() == false) goto L37;
        if (r12 <= 0) goto L37;
        this.mFailedTimes++;     // Catch: Throwable -> L96
        if (this.mFailedTimes >= this.mUrlList.size()) goto L28;
        this.mCurrentUrlIndex.incrementAndGet();     // Catch: Throwable -> L96
        accelerateNextTaskWhenFailed();     // Catch: Throwable -> L96
        monitor-exit(r8);     // Catch: Throwable -> L96
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "Try all urls failed countdown.");     // Catch: Throwable -> L96
    L30:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L96
        monitor-exit(r8);     // Catch: Throwable -> L96
        return;
    L37:
        if (Logger.debug() == false) goto L39;
        Logger.d(TAG, "ConstructURLConnection and execute index: " + this.mCurrentUrlIndex.get() + " url: " + r9);     // Catch: Throwable -> L96
    L39:
        HttpURLConnection r5 = constructConnection(r9, this.requestInfo);     // Catch: Throwable -> L96
        configureConnection(this.retrofitRequest, this.requestInfo, r5, null);     // Catch: Throwable -> L83
        if (this.mBypassRouteSelectionEnabled == true) goto L43;
    L45:
        r5.setRequestProperty(REQUEST_HEADERS_TRANSACTION_ID, this.mTransactionId);     // Catch: Throwable -> L83
        this.mCurrentUrlIndex.incrementAndGet();     // Catch: Throwable -> L83
        this.mPendingURLConnections.add(r5);     // Catch: Throwable -> L83
        r10.mId = r5.hashCode();     // Catch: Throwable -> L83
        monitor-exit(r8);     // Catch: Throwable -> L83
        this.responseCode = executeConnection(r5);     // Catch: IOException -> L81
        r10.mResponseCode = this.responseCode;     // Catch: IOException -> L81
        r10.mEndTime = System.currentTimeMillis();     // Catch: IOException -> L81
        if (shouldRetryApiTaskFromHttpCode(this.responseCode, r5.getHeaderField(API_SOURCE_5XX_CODE), this.mRuleId) == true) goto L64;
        Object r14 = this.mConnectionLock;     // Catch: IOException -> L81
        monitor-enter(r14);     // Catch: IOException -> L81
    L61:
        th = move-exception;
        throw th;     // Catch: IOException -> L81
    L52:
        if (this.mWinnerConnection != null) goto L57;
        this.mWinnerConnection = r5;     // Catch: Throwable -> L61
        this.mWinnerIndex = r12;     // Catch: Throwable -> L61
        this.mOriginUrl = r9;     // Catch: Throwable -> L61
        if (Logger.debug() == false) goto L56;
        Logger.d(TAG, "winnerindex is " + this.mWinnerIndex);     // Catch: Throwable -> L61
    L56:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L61
    L59:
        monitor-exit(r14);     // Catch: Throwable -> L61
    L179:
        return;
    L57:
        if (r5 == null) goto L59;
        r5.disconnect();     // Catch: Throwable -> L61
        this.mPendingURLConnections.remove(r5);     // Catch: Throwable -> L61
        goto L59
    L64:
        String r15 = r5.getResponseMessage();     // Catch: IOException -> L81
        int r16 = this.retrofitRequest.getMaxLength();     // Catch: Throwable -> L74
        InputStream r1 = r5.getInputStream();     // Catch: Exception -> L68 Throwable -> L74
    L67:
        InputStream r17 = r1;
        String r18 = r5.getHeaderField("Content-Type");     // Catch: Throwable -> L74
        if (TextUtils.isEmpty(r18) == false) goto L72;
        r18 = r5.getHeaderField("Content-Type".toLowerCase());     // Catch: Throwable -> L74
    L72:
        r7 = processHttpErrorResponse(this.requestInfo, r5.getHeaderFields(), r16, r17, r18, false);     // Catch: Throwable -> L74
    L80:
        throw new HttpResponseException(this.responseCode, r15, this.retrofitRequest.getPath(), r7);     // Catch: IOException -> L81
    L68:
        r1 = r5.getErrorStream();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        th.printStackTrace();     // Catch: IOException -> L81
        StringBuilder r19 = new StringBuilder("reason = ");     // Catch: IOException -> L81
        if (r15 != null) goto L78;
        r15 = "";
    L78:
        r15 = r19.append(r15).append("  exception = ").append(th.getMessage()).toString();     // Catch: IOException -> L81
    L81:
        e = e;
        r6 = r5;
        goto L100
    L43:
        if (this.mRsName != null) goto L45;
        r5.setRequestProperty(REQUEST_HEADERS_BYPASS_ROUTE_SELECTION, "1");     // Catch: Throwable -> L83
    L83:
        th = th;
        r6 = r5;
    L96:
        th = th;
    L98:
        e = e;
        r9 = null;
        r10 = null;
        goto L100
    }

    private void accelerateNextTaskWhenFailed() {
        Message r0 = Message.obtain();
        r0.what = 1;
        r0.obj = this;
        this.mHandler.sendMessage(r0);
    }

    private void doApiTaskAndCancelDelayedTask() {
        if (this.mHandler.obtainMessage(0) == null) goto L6;
        this.mHandler.removeMessages(0);
        doApiTask();
        return;
    }

    private void scheduleApiTask(long r3) {
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = this;
        this.mHandler.sendMessageDelayed(r0, r3);
    }

    private void cleanupMessagesAndPendingConnections() {
        this.mHandler.removeCallbacksAndMessages(null);
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.mCleanUpDone == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L8:
        Iterator<HttpURLConnection> r1 = this.mPendingURLConnections.iterator();     // Catch: Throwable -> L29
    L10:
        if (r1.hasNext() == false) goto L24;
        HttpURLConnection r2 = r1.next();     // Catch: Throwable -> L29
        if (r2 == null) goto L10;
        Iterator<ConnectionAttempts> r3 = this.mConnectionAttempts.iterator();     // Catch: Throwable -> L29
    L15:
        if (r3.hasNext() == false) goto L22;
        ConnectionAttempts r4 = r3.next();     // Catch: Throwable -> L29
        if (r4.mId != r2.hashCode()) goto L15;
        r4.mEndTime = System.currentTimeMillis();     // Catch: Throwable -> L29
        if (this.mEnableRequestReportFix == false) goto L21;
        r4.mCleanUpTime = System.currentTimeMillis();     // Catch: Throwable -> L29
        goto L22
    L21:
        r4.mNetError = CANCELED_INTERNAL;     // Catch: Throwable -> L29
        r4.mException = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L29
    L22:
        r2.disconnect();     // Catch: Throwable -> L29
        this.mPendingURLConnections.remove(r2);     // Catch: Throwable -> L29
        goto L10
    L24:
        if (this.requestInfo.metrics == null) goto L26;
        RetrofitMetrics r5 = this.requestInfo.metrics;     // Catch: Throwable -> L29
        r5.concurrentRequest = reportConcurrentRequestMetrics();     // Catch: Throwable -> L29
    L26:
        this.mCleanUpDone = true;     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
    }

    private JSONObject reportConcurrentRequestMetrics() {
        JSONObject r0 = new JSONObject();
        r0.put("concurrent", this.mConnectionAttempts.size() - 1);     // Catch: JSONException -> L14
        r0.put("duration", System.currentTimeMillis() - this.requestInfo.requestStart);     // Catch: JSONException -> L14
        if (this.mEnableRequestReportFix == true) goto L6;
    L8:
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L14
        Iterator<ConnectionAttempts> r6 = this.mConnectionAttempts.iterator();     // Catch: JSONException -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        r1.put(r6.next().toJson());     // Catch: JSONException -> L14
        goto L10
    L12:
        r0.put("tasks", r1);     // Catch: JSONException -> L14
    L16:
        return r0;
    L6:
        if (TextUtils.isEmpty(mCallFailureMessage) == true) goto L8;
        r0.put("call_msg", mCallFailureMessage);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall, com.bytedance.retrofit2.client.SsCall
    public Response execute() throws IOException {
        if (this.requestInfo.metrics == null) goto L6;
        this.requestInfo.metrics.callExecuteStartTime = System.currentTimeMillis();
    L6:
        if (this.canceled == true) goto L75;
        tryNecessaryInit(this.retrofitRequest, this.requestInfo);
        checkNetworkAvailableBeforeRequest(bypassNetworkStatusCheck(), getContext(), this.retrofitRequest.getPath());
        doApiTask();
        boolean r9 = true;
        long r1 = this.mRequestMaxWaitTime;     // Catch: Exception -> L65
        if (this.mEnableRequestReportFix == false) goto L11;
        r1 = Math.max(r1, this.mTNCRequestMaxWaitTime);     // Catch: Exception -> L65
    L11:
        this.mCallExecuteLatch.await(r1, TimeUnit.MILLISECONDS);     // Catch: Exception -> L65
        this.mCallExecuteLatch.countDown();     // Catch: Exception -> L65
        Object r2 = this.mConnectionLock;     // Catch: Exception -> L65
        monitor-enter(r2);     // Catch: Exception -> L65
    L62:
        th = move-exception;
        throw th;     // Catch: Exception -> L65
    L14:
        if (this.mEnableRequestReportFix == true) goto L21;
        if (this.canceled == false) goto L21;
        throw new IOException(CANCELED_EXCEPTION_MESSAGE);     // Catch: Throwable -> L62
    L21:
        if (this.mWinnerConnection != null) goto L34;
        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, false);     // Catch: Throwable -> L62
        if (this.mConnectionAttempts.size() <= 0) goto L30;
        if (this.mConnectionAttempts.get(0).mException == null) goto L30;
        throw this.mConnectionAttempts.get(0).mException;     // Catch: Throwable -> L62
    L30:
        if (this.mEnableRequestReportFix == false) goto L33;
        mCallFailureMessage = "All urls have been tried and timed out by max wait time.";     // Catch: Throwable -> L62
    L35:
        monitor-exit(r2);     // Catch: Throwable -> L62
        cleanupMessagesAndPendingConnections();
    L53:
        e = move-exception;
    L56:
        th = th;
    L58:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L60;
        if (r9 == true) goto L60;
    L61:
        throw th;
    L60:
        safeClose();
        goto L61
    L55:
        throw handleException(e, this.mOriginUrl, this.mWinnerConnection, true);     // Catch: Throwable -> L56
    L51:
        th = th;
        r9 = false;
        goto L58
    L38:
        if (this.mWinnerIndex > 0) goto L40;
    L45:
        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, true);     // Catch: Throwable -> L51 Exception -> L53
        List<String> r0 = retryRequestOnceIfNeeded(this.retrofitRequest, this.requestInfo, this, true, true);     // Catch: Throwable -> L51 Exception -> L53
        onFinalResponseReceived(this.requestInfo, this);     // Catch: Throwable -> L51 Exception -> L53
        TypedInput r3 = processResponseBody(this.mOriginUrl, this.retrofitRequest, this.requestInfo, this, this, this, false);     // Catch: Throwable -> L51 Exception -> L53
        onResponseBodyProcessed(r3);     // Catch: Throwable -> L51 Exception -> L53
        Response r4 = new Response(this.mOriginUrl, this.responseCode, this.mWinnerConnection.getResponseMessage(), createHeaders(this, r0), r3);     // Catch: Throwable -> L51 Exception -> L53
        r4.setExtraInfo(this.requestInfo);     // Catch: Throwable -> L51 Exception -> L53
    L47:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L50;
        safeClose();
    L50:
        return r4;
    L40:
        if (TextUtils.isEmpty(this.mRsName) == true) goto L45;
        if (Logger.debug() == false) goto L44;
        Logger.e(TAG, "winner is " + this.mWinnerIndex + " url is " + this.mWinnerConnection.getURL().getHost());     // Catch: Throwable -> L51 Exception -> L53
    L44:
        setRouteSelectionBestHost(new URL(this.mUrlList.get(this.mWinnerIndex)).getHost(), this.mRsName);     // Catch: Throwable -> L51 Exception -> L53
        goto L45
    L33:
        throw handleException(new IOException("All urls have been tried and timed out by max wait time."), this.mOriginUrl, this.mWinnerConnection, false);     // Catch: Throwable -> L62
    L34:
        this.mPendingURLConnections.remove(this.mWinnerConnection);     // Catch: Throwable -> L62
    L65:
        e = move-exception;
        cleanupMessagesAndPendingConnections();
        if (this.mWinnerConnection != null) goto L73;
        if (this.mFirstFailedConnection == null) goto L73;
        throw handleException(e, this.mOriginUrl, this.mFirstFailedConnection, true);
    L73:
        throw handleException(e, this.mOriginUrl, this.mWinnerConnection, true);
    L75:
        throw new IOException(CANCELED_EXCEPTION_MESSAGE);
    }

    private IOException handleException(Exception r9, String r10, HttpURLConnection r11, boolean r12) {
        if (this.mEnableRequestReportFix == true) goto L13;
        if ((r9 instanceof IOException) == false) goto L13;
        if (r9.getMessage() == null) goto L13;
        if (r9.getMessage().startsWith(CANCELED_EXCEPTION_MESSAGE) == false) goto L13;
        return (IOException) r9;
    L13:
        if (CRONET_EXCEPTION_CLASS_NAME.equals(r9.getClass().getName()) == false) goto L15;
    L18:
        int r0 = SsCronetHttpClient.getCronetInternalErrorCode(r11);
    L20:
        if (TextUtils.isEmpty(r10) == false) goto L22;
        r10 = this.mOriginUrl;
    L22:
        String r5 = r10;
        if (r12 == false) goto L25;
        updateRequestInfoWithException(r5, this.requestInfo, this, this, r9);
    L38:
        checkNetworkAvailableAfterRequest(this.retrofitRequest, r9);     // Catch: NetworkNotAvailabeException -> L36
        CronetIOException r13 = new CronetIOException(r9, this.requestInfo, r0);
        if (r12 == true) goto L31;
        r13.setInfo(false, false, false, r5, this.requestInfo.traceCode, this.requestInfo);
    L35:
        return r13;
    L31:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L33;
        this.requestInfo.hasReportStreamingApiAll.set(true);
    L33:
        r13.setInfo(true, false, true, r5, this.requestInfo.traceCode, this.requestInfo);
    L36:
        e = move-exception;
        return e;
    L25:
        if (r11 == null) goto L38;
        r11.disconnect();
        goto L38
    L15:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r9.getClass().getName()) == true) goto L18;
        r0 = 0;
        goto L20
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "cancel countdown.");
    L5:
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mEnableRequestReportFix == true) goto L10;
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L13
    L10:
        cleanupMessagesAndPendingConnections();     // Catch: Throwable -> L13
        cancelInner(this.mWinnerConnection);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r3, boolean r4) {
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L7
        cleanupMessagesAndPendingConnections();     // Catch: Throwable -> L7
        cancelNormalRequestInner(this.mWinnerConnection, r3, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall, com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r6) {
        super.setThrottleNetSpeed(r6);
        if (this.mWinnerConnection != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(this.mWinnerConnection).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        getRequestMetrics(this.requestInfo, this);
    }

    public Boolean dropIfDuplicate(String r6, ConnectionAttempts r7) {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L23;
        if (r7 == null) goto L23;
        new URL(r6).toURI();     // Catch: Exception -> L19
        if (this.mCurrentUrlIndex.get() != 0) goto L11;
        this.mFirstUrl = r6;     // Catch: Exception -> L19
        this.mFirstAttempt = r7;     // Catch: Exception -> L19
        return false;
    L11:
        if (this.mCurrentUrlIndex.get() != 1) goto L13;
        this.mSentHosts.add(dispatch(this.mFirstUrl, this.mFirstAttempt));     // Catch: Exception -> L19
    L13:
        dispatch(r6, r7);     // Catch: Exception -> L19
        if (this.mSentHosts.contains(r7.mDispatchedHost) == false) goto L17;
        r7.sentAlready = true;     // Catch: Exception -> L19
        return true;
    L17:
        this.mSentHosts.add(r7.mDispatchedHost);     // Catch: Exception -> L19
        return false;
    L19:
        e = move-exception;
        e.printStackTrace();
        return true;
    L23:
        if (Logger.debug() == false) goto L25;
        Logger.e(TAG, "cronet did not init, dispatch fail");
    L25:
        return true;
    }

    private String dispatch(String r5, ConnectionAttempts r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        long r0 = System.currentTimeMillis();
        String r4 = SsCronetHttpClient.ttUrlDispatch(r5, -1, true).getFinalUrl();     // Catch: Exception -> L17
        r6.mDispatchTime = System.currentTimeMillis() - r0;
        r6.mDispatchedHost = new URI(r4).getHost();     // Catch: URISyntaxException -> L14
        if (Logger.debug() == false) goto L13;
        Logger.e(TAG, "url is " + r5 + " dispatchedUrl is " + r4);
    L13:
        return r6.mDispatchedHost;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void setRouteSelectionBestHost(String r1, String r2) {
        SsCronetHttpClient.setBestHostWithRouteSelectionName(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
