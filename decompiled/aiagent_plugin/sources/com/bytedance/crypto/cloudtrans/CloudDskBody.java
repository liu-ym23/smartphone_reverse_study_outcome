package com.bytedance.crypto.cloudtrans;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes.dex */
public class CloudDskBody {
    public String bodyJson;
    public int code;
    public Data data;
    public PrivateKey deviceTempPriKey;
    public String logId;
    public String msg;

    public static class Data {
        public String cloudPublicKey;
        public long expectExpiryTime;
        public long keyVersion;
        public String sharedKeyHash;
        public String signature;

        public Data() {
        }
    }

    public CloudDskBody() {
        this.data = new Data();
    }
}
