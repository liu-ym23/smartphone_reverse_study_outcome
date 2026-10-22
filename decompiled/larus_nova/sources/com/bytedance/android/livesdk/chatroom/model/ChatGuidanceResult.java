package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdk.message.model.rj;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ChatGuidanceResult {

    @SerializedName("message")
    private rj message;

    public ChatGuidanceResult() {
    }

    public rj getMessage() {
        return this.message;
    }

    @SerializedName("message")
    public void setMessage(rj r100) {
        this.message = r100;
    }
}
