package org.apache.http.impl.io;

import org.apache.http.io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes4.dex */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred;

    public HttpTransportMetricsImpl() {
        this.bytesTransferred = 0;
    }

    @Override // org.apache.http.io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void incrementBytesTransferred(long r10) {
        this.bytesTransferred += r10;
    }

    @Override // org.apache.http.io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0;
    }

    public void setBytesTransferred(long r10) {
        this.bytesTransferred = r10;
    }
}
