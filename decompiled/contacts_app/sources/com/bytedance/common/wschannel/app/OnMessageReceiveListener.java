package com.bytedance.common.wschannel.app;

import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface OnMessageReceiveListener {
    void onReceiveConnectEvent(ConnectEvent r1, JSONObject r2);

    void onReceiveMsg(WsChannelMsg r1);
}
