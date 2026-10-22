package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String r10) {
        super(r10);
    }

    public ClientProtocolException(Throwable r10) {
        initCause(r10);
    }

    public ClientProtocolException(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
    }
}
