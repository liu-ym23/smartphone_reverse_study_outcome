package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes2.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final MsgSendListener mListener;
    private final WsChannelMsg origin;

    MainProcessMsg(WsChannelMsg r1, MsgSendListener r2) {
        super(r1);
        this.origin = r1;
        this.mListener = r2;
    }

    WsChannelMsg getOrigin() {
        return this.origin;
    }

    public MsgSendListener getListener() {
        return this.mListener;
    }
}
