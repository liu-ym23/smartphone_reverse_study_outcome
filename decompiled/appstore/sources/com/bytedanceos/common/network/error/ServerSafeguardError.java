package com.bytedanceos.common.network.error;

import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;

/* JADX INFO: loaded from: classes2.dex */
public class ServerSafeguardError extends NetworkError {
    public ServerSafeguardError() {
    }

    public ServerSafeguardError(Throwable r10) {
        super(r10);
    }

    public ServerSafeguardError(NetworkResponse r10) {
        super(r10);
    }
}
