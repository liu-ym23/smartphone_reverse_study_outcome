package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class NetworkNotAvailabeException extends IOException {
    private static final int INTERNET_DISCONNECTED = -106;
    private static final long serialVersionUID = -7281385706782665299L;

    public NetworkNotAvailabeException() {
    }

    public int getCronetInternalErrorCode() {
        return -106;
    }

    public NetworkNotAvailabeException(String r10) {
        super(r10);
    }

    public NetworkNotAvailabeException(Throwable r10) {
        initCause(r10);
    }

    public NetworkNotAvailabeException(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
    }
}
