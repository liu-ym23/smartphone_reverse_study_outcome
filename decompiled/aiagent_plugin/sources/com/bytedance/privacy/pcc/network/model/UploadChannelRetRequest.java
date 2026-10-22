package com.bytedance.privacy.pcc.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class UploadChannelRetRequest {

    @SerializedName("payload")
    private final String payloadBase64;

    @SerializedName("signature")
    private final String signature;

    public static class Payload {

        @SerializedName("app_info")
        private final AppInfoPayload appInfo;

        @SerializedName(WsConstants.KEY_CHANNEL_ID)
        private final String channelId;

        @SerializedName("channel_ret")
        private final String channelRet;

        @SerializedName("client_version")
        private final String clientVersion;

        private static class AppInfoPayload {

            @SerializedName("app_id")
            private final String appId;

            @SerializedName("app_svc_id")
            private final String appSvcId;

            AppInfoPayload(String r1, String r2) {
                this.appId = r1;
                this.appSvcId = r2;
            }
        }

        public Payload(String r2, AppInfo r3, String r4, String r5) {
            this.clientVersion = r2;
            this.appInfo = new AppInfoPayload(r3.appId, r3.appSvcId);
            this.channelId = r4;
            this.channelRet = r5;
        }

        public String toJsonString() {
            return new Gson().toJson(this);
        }

        public String toString() {
            return toJsonString();
        }
    }

    public UploadChannelRetRequest(String r1, String r2) {
        this.payloadBase64 = r1;
        this.signature = r2;
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }

    public String toString() {
        return toJsonString();
    }
}
