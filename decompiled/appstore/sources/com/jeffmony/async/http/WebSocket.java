package com.jeffmony.async.http;

import com.jeffmony.async.AsyncSocket;

/* JADX INFO: loaded from: classes3.dex */
public interface WebSocket extends AsyncSocket {

    public interface PingCallback {
        void onPingReceived(String r10);
    }

    public interface PongCallback {
        void onPongReceived(String r10);
    }

    public interface StringCallback {
        void onStringAvailable(String r10);
    }

    PongCallback getPongCallback();

    String getProtocol();

    AsyncSocket getSocket();

    StringCallback getStringCallback();

    boolean isBuffering();

    void ping(String r10);

    void pong(String r10);

    void send(String r10);

    void send(byte[] r10);

    void send(byte[] r10, int r11, int r12);

    void setPingCallback(PingCallback r10);

    void setPongCallback(PongCallback r10);

    void setStringCallback(StringCallback r10);
}
