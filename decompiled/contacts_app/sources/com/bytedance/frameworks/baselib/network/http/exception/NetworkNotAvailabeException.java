package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.retrofit2.ttnet.ExceptionReportable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkNotAvailabeException extends IOException implements ExceptionReportable {
    private static final int INTERNET_DISCONNECTED = -106;
    private static final long serialVersionUID = -7281385706782665299L;
    private boolean shouldReport;

    public int getCronetInternalErrorCode() {
        return -106;
    }

    public NetworkNotAvailabeException() {
        this.shouldReport = false;
    }

    public NetworkNotAvailabeException(String r1) {
        super(r1);
        this.shouldReport = false;
    }

    public NetworkNotAvailabeException(Throwable r2) {
        this.shouldReport = false;
        initCause(r2);
    }

    public NetworkNotAvailabeException(String r1, Throwable r2) {
        super(r1);
        this.shouldReport = false;
        initCause(r2);
    }

    public void setShouldReport(boolean r1) {
        this.shouldReport = r1;
    }

    @Override // com.bytedance.retrofit2.ttnet.ExceptionReportable
    public boolean shouldReport() {
        return this.shouldReport;
    }
}
