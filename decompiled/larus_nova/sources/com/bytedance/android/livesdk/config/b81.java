package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/config/b81;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "interpolator", "I", "d", "()I", "setInterpolator", "(I)V", "", "durationFactor", FaceService.girlLabel, "b", "()F", "setDurationFactor", "(F)V", "maxDuration", "e", "setMaxDuration", "switchRoom", "f", "setSwitchRoom", "filterVideo", "getFilterVideo", "setFilterVideo", "downDistance", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDownDistance", "upDistance", com.amap.api.col.s.ce.f26391f, "setUpDistance", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b81 {

    @SerializedName("down_distance")
    private float downDistance;

    @SerializedName("duration_factor")
    private float durationFactor;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("filter_video")
    private boolean filterVideo;

    @SerializedName("interpolator")
    private int interpolator;

    @SerializedName("max_duration")
    private int maxDuration;

    @SerializedName("switch_room")
    private boolean switchRoom;

    @SerializedName("up_distance")
    private float upDistance;

    public final String toString() {
        return "[enable:" + this.enable + ",interpolator:" + this.interpolator + ",switchRoom:" + this.switchRoom + ",filterVideo:" + this.filterVideo + ']';
    }

    public b81() {
        this.durationFactor = 1.0f;
        this.maxDuration = 600;
        this.downDistance = 0.6f;
        this.upDistance = 0.4f;
    }

    public final float a() {
        return this.downDistance;
    }

    public final float b() {
        return this.durationFactor;
    }

    public final boolean c() {
        return this.enable;
    }

    public final int d() {
        return this.interpolator;
    }

    public final int e() {
        return this.maxDuration;
    }

    public final boolean f() {
        return this.switchRoom;
    }

    public final float g() {
        return this.upDistance;
    }
}
