package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes4.dex */
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    private final HttpTransportMetrics inTransportMetric;
    private Map<String, Object> metricsCache;
    private final HttpTransportMetrics outTransportMetric;
    private long requestCount;
    private long responseCount;

    public HttpConnectionMetricsImpl(HttpTransportMetrics r10, HttpTransportMetrics r11) {
        this.requestCount = 0;
        this.responseCount = 0;
        this.inTransportMetric = r10;
        this.outTransportMetric = r11;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public Object getMetric(String r10) {
        Map<String, Object> r11 = this.metricsCache;
        if (r11 == null) goto L5;
        Object r12 = r11.get(r10);
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        if (REQUEST_COUNT.equals(r10) == false) goto L11;
        return Long.valueOf(this.requestCount);
    L11:
        if (RESPONSE_COUNT.equals(r10) == false) goto L14;
        return Long.valueOf(this.responseCount);
    L14:
        if (RECEIVED_BYTES_COUNT.equals(r10) == false) goto L20;
        HttpTransportMetrics r13 = this.inTransportMetric;
        if (r13 != null) goto L18;
        return null;
    L18:
        return Long.valueOf(r13.getBytesTransferred());
    L20:
        if (SENT_BYTES_COUNT.equals(r10) == false) goto L30;
        HttpTransportMetrics r14 = this.outTransportMetric;
        if (r14 != null) goto L24;
        return null;
    L24:
        return Long.valueOf(r14.getBytesTransferred());
    L30:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getReceivedBytesCount() {
        HttpTransportMetrics r10 = this.inTransportMetric;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getBytesTransferred();
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getRequestCount() {
        return this.requestCount;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getResponseCount() {
        return this.responseCount;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getSentBytesCount() {
        HttpTransportMetrics r10 = this.outTransportMetric;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getBytesTransferred();
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }

    public void incrementResponseCount() {
        this.responseCount++;
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public void reset() {
        HttpTransportMetrics r10 = this.outTransportMetric;
        if (r10 == null) goto L5;
        r10.reset();
    L5:
        HttpTransportMetrics r11 = this.inTransportMetric;
        if (r11 == null) goto L8;
        r11.reset();
    L8:
        this.requestCount = 0;
        this.responseCount = 0;
        this.metricsCache = null;
    }

    public void setMetric(String r10, Object r11) {
        if (this.metricsCache != null) goto L5;
        this.metricsCache = new HashMap();
    L5:
        this.metricsCache.put(r10, r11);
    }
}
