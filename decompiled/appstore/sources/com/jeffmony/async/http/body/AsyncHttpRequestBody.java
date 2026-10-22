package com.jeffmony.async.http.body;

import com.jeffmony.async.DataEmitter;
import com.jeffmony.async.DataSink;
import com.jeffmony.async.callback.CompletedCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncHttpRequestBody<T> {
    T get();

    String getContentType();

    int length();

    void parse(DataEmitter r10, CompletedCallback r11);

    boolean readFullyOnRequest();

    void write(com.jeffmony.async.http.a r10, DataSink r11, CompletedCallback r12);
}
