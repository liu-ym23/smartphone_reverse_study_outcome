package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/performance/p0;", "", "", "time", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "stallUiSeriousRate", FaceService.girlLabel, "c", "()F", "stallUiModerateRate", "b", "stallUiSlightRate", "d", "fps", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "stallVideoRate", "e", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("fps")
    private final float fps;

    @SerializedName(IPerformanceManager.Stall.stall_ui_moderate_rate)
    private final float stallUiModerateRate;

    @SerializedName(IPerformanceManager.Stall.stall_ui_serious_rate)
    private final float stallUiSeriousRate;

    @SerializedName(IPerformanceManager.Stall.stall_ui_slight_rate)
    private final float stallUiSlightRate;

    @SerializedName(IPerformanceManager.Stall.stall_video_rate)
    private final float stallVideoRate;

    @SerializedName("time")
    private final String time;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == false) goto L18;
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.stallUiSeriousRate, r101.stallUiSeriousRate) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.stallUiModerateRate, r101.stallUiModerateRate) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.stallUiSlightRate, r101.stallUiSlightRate) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.fps, r101.fps) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.stallVideoRate, r101.stallVideoRate) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.time;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((((r101 * 31) + Float.floatToIntBits(this.stallUiSeriousRate)) * 31) + Float.floatToIntBits(this.stallUiModerateRate)) * 31) + Float.floatToIntBits(this.stallUiSlightRate)) * 31) + Float.floatToIntBits(this.fps)) * 31) + Float.floatToIntBits(this.stallVideoRate);
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "PerformanceLog(time=" + this.time + ", stallUiSeriousRate=" + this.stallUiSeriousRate + ", stallUiModerateRate=" + this.stallUiModerateRate + ", stallUiSlightRate=" + this.stallUiSlightRate + ", fps=" + this.fps + ", stallVideoRate=" + this.stallVideoRate + ")";
    }

    public final float a() {
        return this.fps;
    }

    public final float b() {
        return this.stallUiModerateRate;
    }

    public final float c() {
        return this.stallUiSeriousRate;
    }

    public final float d() {
        return this.stallUiSlightRate;
    }

    public final float e() {
        return this.stallVideoRate;
    }

    public final String f() {
        return this.time;
    }

    public p0(String r100, float r101, float r102, float r103, float r104, float r105) {
        Intrinsics.checkNotNullParameter(r100, "time");
        this.time = r100;
        this.stallUiSeriousRate = r101;
        this.stallUiModerateRate = r102;
        this.stallUiSlightRate = r103;
        this.fps = r104;
        this.stallVideoRate = r105;
    }
}
