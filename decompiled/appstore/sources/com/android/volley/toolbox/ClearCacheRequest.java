package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/* JADX INFO: loaded from: classes.dex */
public class ClearCacheRequest extends Request<Object> {
    private final Cache mCache;
    private final Runnable mCallback;

    public ClearCacheRequest(Cache r10, Runnable r11) {
        super(0, null, null);
        this.mCache = r10;
        this.mCallback = r11;
    }

    @Override // com.android.volley.Request
    public void deliverResponse(Object r10) {
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // com.android.volley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if (this.mCallback == null) goto L7;
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.mCallback);
        return true;
    L7:
        return true;
    }

    @Override // com.android.volley.Request
    public Response<Object> parseNetworkResponse(NetworkResponse r10) {
        return null;
    }
}
