package com.bytedanceos.common.network.error;

import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;

/* JADX INFO: loaded from: classes2.dex */
public class ClientVersionLowError extends NetworkError {
    public ClientVersionLowError() {
    }

    public ClientVersionLowError(Throwable r10) {
        super(r10);
    }

    public ClientVersionLowError(NetworkResponse r10) {
        super(r10);
    }
}
