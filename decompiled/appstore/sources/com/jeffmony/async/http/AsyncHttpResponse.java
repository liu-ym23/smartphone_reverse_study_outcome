package com.jeffmony.async.http;

import com.jeffmony.async.AsyncSocket;
import com.jeffmony.async.DataEmitter;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncHttpResponse extends DataEmitter {
    int code();

    AsyncSocket detachSocket();

    a getRequest();

    Headers headers();

    String message();

    String protocol();
}
