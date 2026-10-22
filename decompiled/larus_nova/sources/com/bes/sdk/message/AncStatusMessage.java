package com.bes.sdk.message;

import com.bes.sdk.utils.MessageID;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes39.dex */
public class AncStatusMessage extends BaseMessage {
    private LinkedList<AncSettings> ancSettingsList;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MessageID getMsgID() {
        return MessageID.ANC_STATUS;
    }

    @Override // com.bes.sdk.message.BaseMessage
    public LinkedList<AncSettings> getMsgContent() {
        return this.ancSettingsList;
    }

    public AncStatusMessage(LinkedList<AncSettings> r100) {
        this.ancSettingsList = r100;
    }
}
