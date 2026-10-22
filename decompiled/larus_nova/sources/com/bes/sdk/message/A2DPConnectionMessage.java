package com.bes.sdk.message;

import com.bes.sdk.utils.MessageID;

/* JADX INFO: loaded from: classes39.dex */
public class A2DPConnectionMessage extends BaseMessage {
    private A2DPConnection a2dpConnection;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MessageID getMsgID() {
        return MessageID.A2DP_STATUS;
    }

    @Override // com.bes.sdk.message.BaseMessage
    public A2DPConnection getMsgContent() {
        return this.a2dpConnection;
    }

    public A2DPConnectionMessage(A2DPConnection r100) {
        this.a2dpConnection = r100;
    }
}
