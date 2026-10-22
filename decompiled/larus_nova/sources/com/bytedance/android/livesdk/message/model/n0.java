package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;

/* JADX INFO: loaded from: classes11.dex */
public abstract class n0 extends o0 {

    @IgnoreProtoFieldCheck
    private transient MessageIdentity messageIdentity;

    public n0() {
    }

    public MessageIdentity getMessageIdentity() {
        return this.messageIdentity;
    }

    public void setMessageIdentity(MessageIdentity r100) {
        this.messageIdentity = r100;
    }
}
