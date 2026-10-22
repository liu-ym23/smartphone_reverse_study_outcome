package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class h {

    @SerializedName("bg_image")
    public ImageModel backgroundImage;

    @SerializedName("content")
    public String content;

    public h() {
        this.content = "";
    }
}
