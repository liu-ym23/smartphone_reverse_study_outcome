package com.android.server.hdmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class CecMessageBuffer {
    private List<HdmiCecMessage> mBuffer;
    private HdmiControlService mHdmiControlService;

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiControlService, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiControlService m4261$$Nest$fgetmHdmiControlService(CecMessageBuffer r0) {
        return r0.mHdmiControlService;
    }

    CecMessageBuffer(HdmiControlService hdmiControlService) {
        this.mBuffer = new ArrayList();
        this.mHdmiControlService = hdmiControlService;
    }

    public boolean bufferMessage(HdmiCecMessage message) {
        switch(message.getOpcode()) {
            case 4: goto L14;
            case 13: goto L14;
            case 112: goto L12;
            case 128: goto L10;
            case 130: goto L8;
            case 134: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        bufferSetStreamPath(message);
        return true;
    L8:
        bufferActiveSource(message);
        return true;
    L10:
        bufferRoutingChange(message);
        return true;
    L12:
        bufferSystemAudioModeRequest(message);
        return true;
    L14:
        bufferImageOrTextViewOn(message);
        return true;
    }

    public void processMessages() {
        Iterator<HdmiCecMessage> r0 = this.mBuffer.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final HdmiCecMessage message = r0.next();
        this.mHdmiControlService.runOnServiceThread(new AnonymousClass1(this, message));
        goto L4
    L6:
        this.mBuffer.clear();
    }

    private void bufferActiveSource(HdmiCecMessage message) {
        if (replaceMessageIfBuffered(message, 130) == true) goto L6;
        this.mBuffer.add(message);
        return;
    }

    private void bufferImageOrTextViewOn(HdmiCecMessage message) {
        if (replaceMessageIfBuffered(message, 4) == false) goto L5;
        return;
    L5:
        if (replaceMessageIfBuffered(message, 13) == true) goto L9;
        this.mBuffer.add(message);
        return;
    }

    private void bufferSystemAudioModeRequest(HdmiCecMessage message) {
        if (replaceMessageIfBuffered(message, 112) == true) goto L6;
        this.mBuffer.add(message);
        return;
    }

    private void bufferRoutingChange(HdmiCecMessage message) {
        if (replaceMessageIfBuffered(message, 128) == true) goto L6;
        this.mBuffer.add(message);
        return;
    }

    private void bufferSetStreamPath(HdmiCecMessage message) {
        if (replaceMessageIfBuffered(message, 134) == true) goto L6;
        this.mBuffer.add(message);
        return;
    }

    public List<HdmiCecMessage> getBuffer() {
        return new ArrayList(this.mBuffer);
    }

    private boolean replaceMessageIfBuffered(HdmiCecMessage message, int opcode) {
        int i = 0;
    L4:
        if (i >= this.mBuffer.size()) goto L10;
        HdmiCecMessage bufferedMessage = this.mBuffer.get(i);
        if (bufferedMessage.getOpcode() == opcode) goto L7;
        i = i + 1;
        goto L4
    L7:
        this.mBuffer.set(i, message);
        return true;
    L10:
        return false;
    }
}
