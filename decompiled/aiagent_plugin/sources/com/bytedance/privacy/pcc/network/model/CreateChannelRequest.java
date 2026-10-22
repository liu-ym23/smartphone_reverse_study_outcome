package com.bytedance.privacy.pcc.network.model;

import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class CreateChannelRequest {

    @SerializedName("att_cert_chain")
    private final String attCertChain;

    @SerializedName("payload")
    private final String payload;

    @SerializedName("signature")
    private final String signature;

    public static class Payload {

        @SerializedName("app_info")
        private final AppInfoPayload appInfo;

        @SerializedName("client_nonce")
        private final String clientNonce;

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

        public Payload(String r1, String r2, AppInfo r3) {
            this.clientVersion = r1;
            this.clientNonce = r2;
            this.appInfo = new AppInfoPayload(r3.appId, r3.appSvcId);
        }

        public String toJsonString() {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
        }

        public String toString() {
            return toJsonString();
        }
    }

    public CreateChannelRequest(String r1, String r2, String r3) {
        this.attCertChain = r1;
        this.payload = r2;
        this.signature = r3;
    }

    public String toJsonString() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }

    public String toString() {
        return toJsonString();
    }
}
