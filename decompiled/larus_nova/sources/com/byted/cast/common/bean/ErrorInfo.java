package com.byted.cast.common.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes39.dex */
public class ErrorInfo {

    @SerializedName("code")
    private int code;

    @SerializedName("messageId")
    private String messageId;

    @SerializedName("msg")
    private String msg;

    @SerializedName("type")
    private String type;

    public ErrorInfo() {
    }

    public String toString() {
        return "ErrorInfo{type=" + this.type + ", code=" + this.code + ", msg=" + this.msg + ", messageId=" + this.messageId + '}';
    }

    public int getCode() {
        return this.code;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getType() {
        return this.type;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
