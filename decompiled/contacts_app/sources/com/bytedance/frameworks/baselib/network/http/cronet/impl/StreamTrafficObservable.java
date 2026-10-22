package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class StreamTrafficObservable extends Observable {
    public static final String STREAM_CONTENTTYPE = "content_type";
    public static final String STREAM_RECEIVEDBYTES = "received_bytes";
    public static final String STREAM_REQUESTLOG = "request_log";
    public static final String STREAM_SENTBYTES = "sent_bytes";
    public static final String STREAM_URL = "url";
    private static volatile StreamTrafficObservable sInstance;

    public StreamTrafficObservable() {
    }

    public static StreamTrafficObservable inst() {
        if (sInstance != null) goto L15;
        monitor-enter(StreamTrafficObservable.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StreamTrafficObservable();     // Catch: Throwable -> L11
    L9:
        monitor-exit(StreamTrafficObservable.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void onStreamTrafficChanged(String r3, long r4, long r6, String r8, String r9) {
        HashMap r0 = new HashMap();
        r0.put("url", r3);
        r0.put("sent_bytes", Long.valueOf(r4));
        r0.put("received_bytes", Long.valueOf(r6));
        r0.put(STREAM_CONTENTTYPE, r8);
        r0.put("request_log", r9);
        notifyTrafficChangedObservers(r0);
    }

    private void notifyTrafficChangedObservers(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }
}
