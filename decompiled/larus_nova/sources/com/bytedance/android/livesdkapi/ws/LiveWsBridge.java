package com.bytedance.android.livesdkapi.ws;

/* JADX INFO: loaded from: classes12.dex */
public interface LiveWsBridge {
    int getWsChannelId();

    boolean isConnected();

    void sendMessage(LiveWsMessage r100, OnLiveWsMessageSendListener r101);

    void unregisterChannel();
}
