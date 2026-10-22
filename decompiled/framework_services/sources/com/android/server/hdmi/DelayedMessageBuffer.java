package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class DelayedMessageBuffer {
    private final ArrayList<HdmiCecMessage> mBuffer;
    private final HdmiCecLocalDevice mDevice;

    DelayedMessageBuffer(HdmiCecLocalDevice device) {
        this.mBuffer = new ArrayList();
        this.mDevice = device;
    }

    void add(HdmiCecMessage message) {
        boolean buffered = true;
        switch(message.getOpcode()) {
            case 114: goto L6;
            case 130: goto L5;
            case 192: goto L6;
            default: goto L4;
        };
    L4:
        buffered = false;
    L7:
        if (buffered == false) goto L10;
        HdmiLogger.debug("Buffering message:" + message, new Object[0]);
        return;
    L10:
        return;
    L5:
        removeActiveSource();
        this.mBuffer.add(message);
        goto L7
    L6:
        this.mBuffer.add(message);
        goto L7
    }

    protected void removeActiveSource() {
        Iterator<HdmiCecMessage> iter = this.mBuffer.iterator();
    L4:
        if (iter.hasNext() == false) goto L10;
        HdmiCecMessage message = iter.next();
        if (message.getOpcode() != 130) goto L4;
        iter.remove();
        goto L4
    }

    boolean isBuffered(int opcode) {
        Iterator<HdmiCecMessage> r0 = this.mBuffer.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        HdmiCecMessage message = r0.next();
        if (message.getOpcode() != opcode) goto L4;
        return true;
    L10:
        return false;
    }

    List<HdmiCecMessage> getBufferedMessagesWithOpcode(int opcode) {
        List<HdmiCecMessage> messages = new ArrayList();
        Iterator<HdmiCecMessage> r1 = this.mBuffer.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        HdmiCecMessage message = r1.next();
        if (message.getOpcode() != opcode) goto L4;
        messages.add(message);
        goto L4
    L9:
        return messages;
    }

    void processAllMessages() {
        ArrayList<HdmiCecMessage> copiedBuffer = new ArrayList(this.mBuffer);
        this.mBuffer.clear();
        Iterator<HdmiCecMessage> r1 = copiedBuffer.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        HdmiCecMessage message = r1.next();
        this.mDevice.onMessage(message);
        HdmiLogger.debug("Processing message:" + message, new Object[0]);
        goto L4
    }

    void processMessagesForDevice(int address) {
        ArrayList<HdmiCecMessage> copiedBuffer = new ArrayList(this.mBuffer);
        this.mBuffer.clear();
        HdmiLogger.debug("Checking message for address:" + address, new Object[0]);
        Iterator<HdmiCecMessage> r1 = copiedBuffer.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        HdmiCecMessage message = r1.next();
        if (message.getSource() != address) goto L7;
        if (message.getOpcode() != 130) goto L13;
        if (this.mDevice.isInputReady(HdmiDeviceInfo.idForCecDevice(address)) == true) goto L13;
        this.mBuffer.add(message);
    L13:
        this.mDevice.onMessage(message);
        HdmiLogger.debug("Processing message:" + message, new Object[0]);
        goto L4
    L7:
        this.mBuffer.add(message);
        goto L4
    }

    void processActiveSource(int address) {
        ArrayList<HdmiCecMessage> copiedBuffer = new ArrayList(this.mBuffer);
        this.mBuffer.clear();
        Iterator<HdmiCecMessage> r1 = copiedBuffer.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        HdmiCecMessage message = r1.next();
        if (message.getOpcode() != 130) goto L10;
        if (message.getSource() != address) goto L10;
        this.mDevice.onMessage(message);
        HdmiLogger.debug("Processing message:" + message, new Object[0]);
    L10:
        this.mBuffer.add(message);
        goto L4
    }
}
