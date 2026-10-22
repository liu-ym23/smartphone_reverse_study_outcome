package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/t;", "", "", "firstShowDelay", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setFirstShowDelay", "(J)V", "", "messageShowRate", FaceService.girlLabel, "b", "()F", "setMessageShowRate", "(F)V", "danmakuShowRate", "getDanmakuShowRate", "setDanmakuShowRate", "privilegeDanmakuShowRate", "getPrivilegeDanmakuShowRate", "setPrivilegeDanmakuShowRate", "messageShowRateSlice", "c", "setMessageShowRateSlice", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("danmaku_show_rate")
    private float danmakuShowRate;

    @SerializedName("first_show_delay")
    private long firstShowDelay;

    @SerializedName("message_show_rate")
    private float messageShowRate;

    @SerializedName("message_show_rate_slice")
    private float messageShowRateSlice;

    @SerializedName("privilege_danmaku_show_rate")
    private float privilegeDanmakuShowRate;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L16;
        t r101 = (t) r100;
        if (this.firstShowDelay == r101.firstShowDelay) goto L8;
        return false;
    L8:
        if (Float.compare(this.messageShowRate, r101.messageShowRate) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.danmakuShowRate, r101.danmakuShowRate) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.privilegeDanmakuShowRate, r101.privilegeDanmakuShowRate) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.messageShowRateSlice, r101.messageShowRateSlice) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.firstShowDelay;
        return (((((((((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.messageShowRate)) * 31) + Float.floatToIntBits(this.danmakuShowRate)) * 31) + Float.floatToIntBits(this.privilegeDanmakuShowRate)) * 31) + Float.floatToIntBits(this.messageShowRateSlice);
    }

    public final String toString() {
        return "LivePSMonitorAlarmThreshold(firstShowDelay=" + this.firstShowDelay + ", messageShowRate=" + this.messageShowRate + ", danmakuShowRate=" + this.danmakuShowRate + ", privilegeDanmakuShowRate=" + this.privilegeDanmakuShowRate + ", messageShowRateSlice=" + this.messageShowRateSlice + ")";
    }

    public final long a() {
        return this.firstShowDelay;
    }

    public final float b() {
        return this.messageShowRate;
    }

    public final float c() {
        return this.messageShowRateSlice;
    }

    public t(int r100) {
        this.firstShowDelay = 3000;
        this.messageShowRate = 0.4f;
        this.danmakuShowRate = 0.5f;
        this.privilegeDanmakuShowRate = 0.9f;
        this.messageShowRateSlice = 0.1f;
    }
}
