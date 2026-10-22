package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.websocket.IWSMessage;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes11.dex */
public abstract class o0 extends BaseMessage implements IWSMessage {
    public static final int MESSAGE_FROM_HOST_FRONTIER = 2;
    public static final int MESSAGE_FROM_HTTP_POLLING = 0;
    public static final int MESSAGE_FROM_ROOM_WS = 1;
    private boolean isFirstHistoryMessage;
    public boolean isLocalInsertMsg2;
    private boolean isTooMuchMsg;

    @Expose
    protected transient py.m type;

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean supportDisplayText() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public int getIntType() {
        return this.type.getIntTypeExt();
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d
    public String getMessageMethod() {
        return this.type.getWsMethod();
    }

    public o0() {
        this.isTooMuchMsg = false;
        this.type = MessageType.DEFAULT;
    }

    @Override // com.bytedance.android.livesdkapi.depend.websocket.IWSMessage
    public py.m getMessageType() {
        return this.type;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean isFirstHistoryMessage() {
        return this.isFirstHistoryMessage;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean isTooMuchMsg() {
        return this.isTooMuchMsg;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public void setIsFirstHistoryMessage(boolean r100) {
        this.isFirstHistoryMessage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.livesdk.message.model.o7
    public void setLocalInsertMsg(boolean r100) {
        this.isLocalInsertMsg2 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public void setTooMuchMsg(boolean r100) {
        this.isTooMuchMsg = r100;
    }

    public void setType(py.m r100) {
        this.type = r100;
    }
}
