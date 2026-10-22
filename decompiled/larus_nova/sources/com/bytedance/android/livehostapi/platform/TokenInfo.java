package com.bytedance.android.livehostapi.platform;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
public class TokenInfo {
    public String accessToken;
    private long expireAt;
    private String name;
    private String openId;

    @Nullable
    public String getAccessToken() {
        return this.accessToken;
    }

    public long getExpireAt() {
        return this.expireAt;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getOpenId() {
        return this.openId;
    }

    public TokenInfo(String r100, String r101, String r102, long r103) {
        this.name = r100;
        this.openId = r101;
        this.accessToken = r102;
        this.expireAt = r103;
    }
}
