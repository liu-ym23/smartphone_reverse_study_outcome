package com.bes.sdk.message;

import com.bes.sdk.utils.MessageID;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class BaseMessage implements Serializable {
    private boolean isPush;
    private MessageID messageId;
    private Object msgContent;

    public BaseMessage() {
    }

    public Object getMsgContent() {
        return this.msgContent;
    }

    public MessageID getMsgID() {
        return this.messageId;
    }

    public boolean isPush() {
        return this.isPush;
    }

    public void setMessageId(MessageID r100) {
        this.messageId = r100;
    }

    public void setMsgContent(Object r100) {
        this.msgContent = r100;
    }

    public void setPush(boolean r100) {
        this.isPush = r100;
    }
}
