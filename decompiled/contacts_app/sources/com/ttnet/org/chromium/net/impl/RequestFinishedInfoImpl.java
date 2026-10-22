package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    private final Collection<Object> mAnnotations;
    private final CronetException mException;
    private final int mFinishedReason;
    private final RequestFinishedInfo.Metrics mMetrics;
    private final UrlResponseInfo mResponseInfo;
    private final String mUrl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    public RequestFinishedInfoImpl(String r1, Collection<Object> r2, RequestFinishedInfo.Metrics r3, int r4, UrlResponseInfo r5, CronetException r6) {
        this.mUrl = r1;
        this.mAnnotations = r2;
        this.mMetrics = r3;
        this.mFinishedReason = r4;
        this.mResponseInfo = r5;
        this.mException = r6;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public Collection<Object> getAnnotations() {
        Collection<Object> r0 = this.mAnnotations;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Collections.emptyList();
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public RequestFinishedInfo.Metrics getMetrics() {
        return this.mMetrics;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public int getFinishedReason() {
        return this.mFinishedReason;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public UrlResponseInfo getResponseInfo() {
        return this.mResponseInfo;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public CronetException getException() {
        return this.mException;
    }
}
