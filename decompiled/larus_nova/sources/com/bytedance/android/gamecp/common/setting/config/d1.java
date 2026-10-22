package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/d1;", "", "", "enablePreload", "I", "getEnablePreload", "()I", "enableAI", "getEnableAI", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "J", "getExpireTime", "()J", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 {

    @SerializedName("ai_enable_preload")
    private final int enableAI;

    @SerializedName("targeted_crowd_enable_preload")
    private final int enablePreload;

    @SerializedName("expire_time")
    private final long expireTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d1) == false) goto L12;
        d1 r101 = (d1) r100;
        if (this.enablePreload == r101.enablePreload) goto L8;
        return false;
    L8:
        if (this.enableAI == r101.enableAI) goto L10;
        return false;
    L10:
        if (this.expireTime == r101.expireTime) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.enablePreload * 31) + this.enableAI) * 31;
        long r101 = this.expireTime;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GameCpDetailAIPreloadConfig(enablePreload=" + this.enablePreload + ", enableAI=" + this.enableAI + ", expireTime=" + this.expireTime + ")";
    }

    public d1() {
        this.enablePreload = 0;
        this.enableAI = 0;
        this.expireTime = 86400000;
    }
}
