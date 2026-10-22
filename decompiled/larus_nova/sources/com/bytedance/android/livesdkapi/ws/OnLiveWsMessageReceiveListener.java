package com.bytedance.android.livesdkapi.ws;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface OnLiveWsMessageReceiveListener {
    void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r101);

    void onReceiveMsg(LiveWsMessage r100);
}
