package com.bes.sdk.message;

import com.bes.sdk.utils.MessageID;

/* JADX INFO: loaded from: classes39.dex */
public class MyBudsMessage extends BaseMessage {
    private MyBudsInfo budsInfo;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MessageID getMsgID() {
        return MessageID.FIND_ME_STATUS;
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MyBudsInfo getMsgContent() {
        return this.budsInfo;
    }

    public MyBudsMessage(MyBudsInfo r100) {
        this.budsInfo = r100;
    }
}
