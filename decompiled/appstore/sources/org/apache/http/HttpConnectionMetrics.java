package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpConnectionMetrics {
    Object getMetric(String r10);

    long getReceivedBytesCount();

    long getRequestCount();

    long getResponseCount();

    long getSentBytesCount();

    void reset();
}
