package com.bytedanceos.common.network.error;

import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;

/* JADX INFO: loaded from: classes2.dex */
public class SSLNetworkError extends NetworkError {
    public SSLNetworkError() {
    }

    public SSLNetworkError(Throwable r10) {
        super(r10);
    }

    public SSLNetworkError(NetworkResponse r10) {
        super(r10);
    }
}
