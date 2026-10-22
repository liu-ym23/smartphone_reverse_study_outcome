package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h3;", "", "", "wxExpirationTime", FaceService.girlLabel, "getWxExpirationTime", "()F", "qqExpirationTime", "getQqExpirationTime", "", "enable", "Z", "getEnable", "()Z", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h3 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("qq_expiration_time")
    private final float qqExpirationTime;

    @SerializedName("wx_expiration_time")
    private final float wxExpirationTime;

    public h3() {
        this.wxExpirationTime = 24.0f;
        this.qqExpirationTime = 24.0f;
        this.enable = true;
    }
}
