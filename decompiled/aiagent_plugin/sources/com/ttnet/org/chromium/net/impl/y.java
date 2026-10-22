package com.ttnet.org.chromium.net.impl;

/* JADX INFO: compiled from: QuicExceptionImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class y extends com.ttnet.org.chromium.net.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NetworkExceptionImpl f38242b;

    public y(String r2, int r3, int r4, int r5) {
        super(r2, null);
        this.f38242b = new NetworkExceptionImpl(r2, r3, r4);
        this.f38241a = r5;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(this.f38242b.getMessage());
        r0.append(", QuicDetailedErrorCode=").append(this.f38241a);
        return r0.toString();
    }

    @Override // com.ttnet.org.chromium.net.o
    public int getErrorCode() {
        return this.f38242b.getErrorCode();
    }

    @Override // com.ttnet.org.chromium.net.o
    public int getCronetInternalErrorCode() {
        return this.f38242b.getCronetInternalErrorCode();
    }

    @Override // com.ttnet.org.chromium.net.o
    public boolean immediatelyRetryable() {
        return this.f38242b.immediatelyRetryable();
    }
}
