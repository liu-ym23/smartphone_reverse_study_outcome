package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class OpenPlatformRespExtra extends Extra {

    @SerializedName("control_content_msg")
    public String controlContentMsg;

    @SerializedName("errcode")
    public int errorCode;

    @SerializedName(ITTReaderViewWrapper.ERROR_MSG_KEY)
    public String errorMsg;
    public String requestUrl;

    @SerializedName("shark_code")
    public int sharkCode;

    public OpenPlatformRespExtra() {
        this.errorCode = 0;
        this.errorMsg = "";
        this.sharkCode = 0;
    }
}
