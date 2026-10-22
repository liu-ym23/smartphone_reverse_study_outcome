package com.jeffmony.async.http.callback;

import com.jeffmony.async.callback.ResultCallback;
import com.jeffmony.async.http.AsyncHttpResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface RequestCallback<T> extends ResultCallback<AsyncHttpResponse, T> {
    void onConnect(AsyncHttpResponse r10);

    void onProgress(AsyncHttpResponse r10, long r11, long r12);
}
