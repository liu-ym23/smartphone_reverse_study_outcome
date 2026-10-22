package com.jeffmony.async.callback;

import com.jeffmony.async.AsyncServerSocket;
import com.jeffmony.async.AsyncSocket;

/* JADX INFO: loaded from: classes3.dex */
public interface ListenCallback extends CompletedCallback {
    void onAccepted(AsyncSocket r10);

    void onListening(AsyncServerSocket r10);
}
