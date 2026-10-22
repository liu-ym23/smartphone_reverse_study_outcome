package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private Cache.Entry mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private final Response.ErrorListener mErrorListener;
    private final VolleyLog.MarkerLog mEventLog;
    private final int mMethod;
    private RequestQueue mRequestQueue;
    private boolean mResponseDelivered;
    private RetryPolicy mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private Object mTag;
    private final String mUrl;

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority NORMAL = null;

        static {
            Priority r10 = new Priority("LOW", 0);
            LOW = r10;
            Priority r11 = new Priority("NORMAL", 1);
            NORMAL = r11;
            Priority r12 = new Priority("HIGH", 2);
            HIGH = r12;
            Priority r13 = new Priority("IMMEDIATE", 3);
            IMMEDIATE = r13;
            $VALUES = new Priority[]{r10, r11, r12, r13};
        }

        private Priority(String r10, int r11) {
            super(r10, r11);
        }

        public static Priority valueOf(String r10) {
            return (Priority) Enum.valueOf(Priority.class, r10);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }
    }

    @Deprecated
    public Request(String r10, Response.ErrorListener r11) {
        this(-1, r10, r11);
    }

    public static /* synthetic */ VolleyLog.MarkerLog access$000(Request r10) {
        return r10.mEventLog;
    }

    private byte[] encodeParameters(Map<String, String> r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r13 = r10.entrySet().iterator();     // Catch: UnsupportedEncodingException -> L7
    L5:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, String> r14 = r13.next();     // Catch: UnsupportedEncodingException -> L7
        r12.append(URLEncoder.encode(r14.getKey(), r11));     // Catch: UnsupportedEncodingException -> L7
        r12.append('=');     // Catch: UnsupportedEncodingException -> L7
        r12.append(URLEncoder.encode(r14.getValue(), r11));     // Catch: UnsupportedEncodingException -> L7
        r12.append('&');     // Catch: UnsupportedEncodingException -> L7
        goto L5
    L9:
        return r12.toString().getBytes(r11);
    L7:
        e = move-exception;
        String r15 = String.valueOf(r11);
        if (r15.length() == 0) goto L14;
        String r16 = "Encoding not supported: ".concat(r15);
    L16:
        throw new RuntimeException(r16, e);
    L14:
        r16 = new String("Encoding not supported: ");
        goto L16
    }

    private static int findDefaultTrafficStatsTag(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        Uri r11 = Uri.parse(r10);
        if (r11 == null) goto L12;
        String r12 = r11.getHost();
        if (r12 != null) goto L9;
        return 0;
    L9:
        return r12.hashCode();
    L12:
        return 0;
    L10:
        return 0;
    }

    public void addMarker(String r10) {
        if (VolleyLog.MarkerLog.ENABLED == false) goto L6;
        this.mEventLog.add(r10, Thread.currentThread().getId());
        return;
    }

    public void cancel() {
        this.mCanceled = true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((Request) r10);
    }

    public void deliverError(VolleyError r10) {
        Response.ErrorListener r11 = this.mErrorListener;
        if (r11 == null) goto L6;
        r11.onErrorResponse(r10);
        return;
    }

    public abstract void deliverResponse(T r10);

    public void finish(final String r10) {
        RequestQueue r11 = this.mRequestQueue;
        if (r11 == null) goto L6;
        r11.finish(this);
    L6:
        if (VolleyLog.MarkerLog.ENABLED == false) goto L13;
        final long r12 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto L11;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r10, r12));
        return;
    L11:
        this.mEventLog.add(r10, r12);
        this.mEventLog.finish(toString());
        return;
    }

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> r10 = getParams();
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.size() > 0) goto L7;
        return null;
    L7:
        return encodeParameters(r10, getParamsEncoding());
    }

    public String getBodyContentType() {
        String r10 = String.valueOf(getParamsEncoding());
        if (r10.length() == 0) goto L6;
        return "application/x-www-form-urlencoded; charset=".concat(r10);
    L6:
        return new String("application/x-www-form-urlencoded; charset=");
    }

    public Cache.Entry getCacheEntry() {
        return this.mCacheEntry;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public Response.ErrorListener getErrorListener() {
        return this.mErrorListener;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.mMethod;
    }

    public Map<String, String> getParams() throws AuthFailureError {
        return null;
    }

    public String getParamsEncoding() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> r10 = getPostParams();
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.size() > 0) goto L7;
        return null;
    L7:
        return encodeParameters(r10, getPostParamsEncoding());
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public Map<String, String> getPostParams() throws AuthFailureError {
        return getParams();
    }

    @Deprecated
    public String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public RetryPolicy getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public final int getSequence() {
        Integer r10 = this.mSequence;
        if (r10 == null) goto L7;
        return r10.intValue();
    L7:
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public Object getTag() {
        return this.mTag;
    }

    public final int getTimeoutMs() {
        return this.mRetryPolicy.getCurrentTimeout();
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean hasHadResponseDelivered() {
        return this.mResponseDelivered;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public void markDelivered() {
        this.mResponseDelivered = true;
    }

    public VolleyError parseNetworkError(VolleyError r10) {
        return r10;
    }

    public abstract Response<T> parseNetworkResponse(NetworkResponse r10);

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(Cache.Entry r10) {
        this.mCacheEntry = r10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(RequestQueue r10) {
        this.mRequestQueue = r10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(RetryPolicy r10) {
        this.mRetryPolicy = r10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int r10) {
        this.mSequence = Integer.valueOf(r10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean r10) {
        this.mShouldCache = r10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object r10) {
        this.mTag = r10;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public String toString() {
        String r10 = String.valueOf(Integer.toHexString(getTrafficStatsTag()));
        if (r10.length() == 0) goto L5;
        String r11 = "0x".concat(r10);
    L7:
        if (this.mCanceled == false) goto L9;
        String r12 = "[X] ";
    L10:
        String r13 = String.valueOf(getUrl());
        String r14 = String.valueOf(r11);
        String r15 = String.valueOf(getPriority());
        String r16 = String.valueOf(this.mSequence);
        StringBuilder r17 = new StringBuilder(((((r12.length() + 3) + r13.length()) + r14.length()) + r15.length()) + r16.length());
        r17.append(r12);
        r17.append(r13);
        r17.append(" ");
        r17.append(r14);
        r17.append(" ");
        r17.append(r15);
        r17.append(" ");
        r17.append(r16);
        return r17.toString();
    L9:
        r12 = "[ ] ";
        goto L10
    L5:
        r11 = new String("0x");
        goto L7
    }

    public Request(int r10, String r11, Response.ErrorListener r12) {
        if (VolleyLog.MarkerLog.ENABLED == false) goto L5;
        VolleyLog.MarkerLog r13 = new VolleyLog.MarkerLog();
    L6:
        this.mEventLog = r13;
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mCacheEntry = null;
        this.mMethod = r10;
        this.mUrl = r11;
        this.mErrorListener = r12;
        setRetryPolicy(new DefaultRetryPolicy());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(r11);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public int compareTo(Request<T> r10) {
        Priority r11 = getPriority();
        Priority r12 = r10.getPriority();
        if (r11 != r12) goto L6;
        int r13 = this.mSequence.intValue();
        int r14 = r10.mSequence.intValue();
    L7:
        return r13 - r14;
    L6:
        r13 = r12.ordinal();
        r14 = r11.ordinal();
        goto L7
    }
}
