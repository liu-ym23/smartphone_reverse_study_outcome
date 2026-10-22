package com.bytedance.android.livesdk.message.model;

import com.ss.ugc.live.sdk.message.stream.IStreamMessage;

/* JADX INFO: loaded from: classes11.dex */
public abstract class tb implements IStreamMessage {
    public tb() {
    }

    @Override // tlc.d
    public long getDelayDispatchMs() {
        return 0;
    }

    @Override // tlc.d
    public int getGeneralMessageType() {
        return 0;
    }

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public int getIntType() {
        return 0;
    }

    @Override // tlc.d
    public int getMessageFrom() {
        return 0;
    }

    @Override // tlc.d
    public long getMessageId() {
        return 0;
    }

    @Override // tlc.d
    public String getMessageMethod() {
        return "";
    }

    public int getPriority() {
        return 0;
    }

    @Override // tlc.d
    public long getRoomId() {
        return 0;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public long getTargetSei() {
        return 0;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public boolean ignoreCondition() {
        return false;
    }

    @Override // tlc.d
    public boolean isFromFirstRequest() {
        return false;
    }

    @Override // tlc.d
    public boolean isGlobalMessage() {
        return false;
    }

    @Override // tlc.d
    public boolean needMonitor() {
        return false;
    }

    @Override // tlc.d
    public void setConsumeTime(long r100) {
    }

    @Override // tlc.d
    public void setDecodeEndTime(long r100) {
    }

    @Override // tlc.d
    public void setDecodeStartTime(long r100) {
    }

    @Override // tlc.d
    public void setEnqueueDispatchTime(long r100) {
    }

    @Override // tlc.d
    public void setHttpSendTime(long r100) {
    }

    @Override // tlc.d
    public void setIsFromFirstRequest(boolean r100) {
    }

    @Override // tlc.d
    public void setIsInsert(boolean r100) {
    }

    @Override // tlc.d
    public void setMessageMethod(String r100) {
    }

    @Override // tlc.d
    public void setReceiveTime(long r100) {
    }
}
