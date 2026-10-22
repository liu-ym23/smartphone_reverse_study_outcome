package com.bytedance.common.wschannel.app;

import com.bytedance.common.wschannel.event.a;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface OnMessageReceiveListener {
    void onReceiveConnectEvent(a r10, JSONObject r11);

    void onReceiveMsg(WsChannelMsg r10);
}
