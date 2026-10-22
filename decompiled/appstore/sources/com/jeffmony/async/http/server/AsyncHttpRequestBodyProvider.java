package com.jeffmony.async.http.server;

import com.jeffmony.async.http.Headers;
import com.jeffmony.async.http.body.AsyncHttpRequestBody;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncHttpRequestBodyProvider {
    AsyncHttpRequestBody getBody(Headers r10);
}
