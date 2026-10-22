package com.bes.sdk.message;

import com.bes.sdk.device.HmDevice;
import com.bes.sdk.utils.MessageID;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes39.dex */
public class DeviceInfoMessage extends BaseMessage {
    private LinkedList<? extends HmDevice> deviceList;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public MessageID getMsgID() {
        return MessageID.DEVICE_INFO;
    }

    @Override // com.bes.sdk.message.BaseMessage
    public LinkedList<? extends HmDevice> getMsgContent() {
        return this.deviceList;
    }

    public DeviceInfoMessage(LinkedList<? extends HmDevice> r100) {
        this.deviceList = r100;
    }
}
