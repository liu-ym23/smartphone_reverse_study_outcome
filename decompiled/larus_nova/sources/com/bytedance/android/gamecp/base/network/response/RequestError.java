package com.bytedance.android.gamecp.base.network.response;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public class RequestError {

    @SerializedName("alert")
    public String alert;
    private transient boolean blockNotice;

    @SerializedName("message")
    public String message;

    @SerializedName("prompts")
    public String prompts;
    public transient String url;

    public RequestError() {
        this.prompts = "操作失败, 请稍后重试";
    }

    public boolean isBlockNotice() {
        return this.blockNotice;
    }

    public void setBlockNotice(boolean r100) {
        this.blockNotice = r100;
    }
}
