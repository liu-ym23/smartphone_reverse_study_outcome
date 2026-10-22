package com.bytedance.android.livesdkapi.message;

import com.alipay.sdk.m.p.e;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class MessageJsonPassThroughModel {

    @SerializedName(e.f25671s)
    public String method;

    @SerializedName("json_msg")
    public JsonObject msg;

    public MessageJsonPassThroughModel(String r100, JsonObject r101) {
        this.method = r100;
        this.msg = r101;
    }
}
