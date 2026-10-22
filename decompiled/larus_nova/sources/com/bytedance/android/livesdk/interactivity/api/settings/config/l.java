package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/l;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "duration", "J", "b", "()J", "setDuration", "(J)V", "acuThreshold", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAcuThreshold", "", "rateThredhold", FaceService.girlLabel, "d", "()F", "setRateThredhold", "(F)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("acu_threshold")
    private long acuThreshold;

    @SerializedName("duration")
    private long duration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("rate_threshold")
    private float rateThredhold;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L14;
        l r101 = (l) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.duration == r101.duration) goto L10;
        return false;
    L10:
        if (this.acuThreshold == r101.acuThreshold) goto L12;
        return false;
    L12:
        if (Float.compare(this.rateThredhold, r101.rateThredhold) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.duration;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.acuThreshold;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + Float.floatToIntBits(this.rateThredhold);
    }

    public final String toString() {
        return "HighlevelNoMessageMonitorConfig(enable=" + this.enable + ", duration=" + this.duration + ", acuThreshold=" + this.acuThreshold + ", rateThredhold=" + this.rateThredhold + ")";
    }

    public final long a() {
        return this.acuThreshold;
    }

    public final long b() {
        return this.duration;
    }

    public final boolean c() {
        return this.enable;
    }

    public final float d() {
        return this.rateThredhold;
    }

    public l(int r100) {
        this.enable = true;
        this.duration = 40;
        this.acuThreshold = 5000;
        this.rateThredhold = 0.5f;
    }
}
