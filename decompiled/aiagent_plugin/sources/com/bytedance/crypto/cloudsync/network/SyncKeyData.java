package com.bytedance.crypto.cloudsync.network;

/* JADX INFO: loaded from: classes.dex */
public class SyncKeyData {
    private String appId;
    private int keyVersion;
    private String syncKeyCipher;

    public SyncKeyData(String r1, String r2, int r3) {
        this.appId = r1;
        this.syncKeyCipher = r2;
        this.keyVersion = r3;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public String getSyncKeyCipher() {
        return this.syncKeyCipher;
    }
}
