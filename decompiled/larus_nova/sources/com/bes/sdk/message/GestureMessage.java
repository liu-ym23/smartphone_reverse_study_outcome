package com.bes.sdk.message;

import com.bes.sdk.utils.MessageID;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GestureMessage extends BaseMessage {
    private List<GestureInfo> gestureInfoList;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MessageID getMsgID() {
        return MessageID.GESTURE_STATUS;
    }

    @Override // com.bes.sdk.message.BaseMessage
    public List<GestureInfo> getMsgContent() {
        return this.gestureInfoList;
    }

    public GestureMessage(List<GestureInfo> r100) {
        this.gestureInfoList = r100;
    }
}
