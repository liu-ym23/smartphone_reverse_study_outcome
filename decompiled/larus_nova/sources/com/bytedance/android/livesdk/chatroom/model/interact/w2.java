package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: classes7.dex */
public class w2<T, R extends Extra> {

    @SerializedName("data")
    public T data;

    @SerializedName(LKBaseResponseModel.ERROR_NO_KEY)
    public String errno;

    @SerializedName("extra")
    public R extra;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("msg")
    public String msg;

    public w2() {
    }
}
