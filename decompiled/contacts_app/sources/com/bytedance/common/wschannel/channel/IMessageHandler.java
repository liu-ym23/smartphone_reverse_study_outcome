package com.bytedance.common.wschannel.channel;

import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IMessageHandler {
    void onConnection(IWsChannelClient r1, int r2, JSONObject r3);

    void onConnection(IWsChannelClient r1, SocketState r2);

    void onLinkProgress(String r1, JSONObject r2);

    void onMessage(int r1, WsChannelMsg r2);

    void onMessage(int r1, byte[] r2);

    void onServiceConnectEvent(ServiceConnectEvent r1);

    void replySendMsgResult(WsChannelMsg r1, boolean r2);

    void syncSocketState();

    void tryResendMsg();
}
