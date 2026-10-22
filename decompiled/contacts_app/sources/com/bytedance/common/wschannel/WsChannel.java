package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes2.dex */
public interface WsChannel {
    int getChannelId();

    boolean isConnected();

    boolean isPrivateProtocolEnabled();

    boolean isServiceConnected(int r1);

    void onParamChanged(ChannelInfo r1);

    void registerService(int r1);

    void sendMsg(WsChannelMsg r1, MsgSendListener r2);

    String sendMsgWithAck(WsChannelMsg r1, MsgSendListener r2);

    void unregister();

    void unregisterService(int r1);
}
