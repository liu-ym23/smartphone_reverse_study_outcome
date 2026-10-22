package com.bytedance.common.wschannel.channel;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IMessageHandler {
    void onConnection(IWsChannelClient r10, int r11, JSONObject r12);

    void onMessage(int r10, byte[] r11);
}
