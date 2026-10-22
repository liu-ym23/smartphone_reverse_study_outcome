package com.bes.sdk.message;

import com.bes.sdk.utils.MessageID;

/* JADX INFO: loaded from: classes39.dex */
public class OTAInfoMessage extends BaseMessage {
    private OTAInfo otaInfo;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MessageID getMsgID() {
        return MessageID.OTA_STATUS;
    }

    @Override // com.bes.sdk.message.BaseMessage
    public OTAInfo getMsgContent() {
        return this.otaInfo;
    }

    public OTAInfoMessage(OTAInfo r100) {
        this.otaInfo = r100;
    }
}
