package com.bytedance.android.annie.websocket;

/* JADX INFO: loaded from: classes43.dex */
public interface j {
    void onClosed();

    void onConnected();

    void onFailed(String r100);

    void onMessage(String r100);

    void onMessage(byte[] r100);
}
