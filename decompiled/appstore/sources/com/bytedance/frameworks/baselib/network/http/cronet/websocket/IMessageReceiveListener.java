package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IMessageReceiveListener {
    void onConnection(int r10, String r11, JSONObject r12);

    void onFeedBackLog(String r10);

    void onMessage(byte[] r10, int r11);
}
