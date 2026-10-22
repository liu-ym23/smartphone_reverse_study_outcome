package com.bytedanceos.common.network.error;

import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;

/* JADX INFO: loaded from: classes2.dex */
public class HttpServerError extends NetworkError {
    public HttpServerError() {
    }

    public HttpServerError(Throwable r10) {
        super(r10);
    }

    public HttpServerError(NetworkResponse r10) {
        super(r10);
    }
}
