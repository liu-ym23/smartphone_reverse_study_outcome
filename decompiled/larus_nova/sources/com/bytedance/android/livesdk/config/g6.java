package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/g6;", "", "", "enable", "Z", "getEnable", "()Z", "", "headPlug", FaceService.girlLabel, "getHeadPlug", "()F", "unHeadPlug", "getUnHeadPlug", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g6 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("head_plug")
    private final float headPlug;

    @SerializedName("un_head_plug")
    private final float unHeadPlug;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g6) == false) goto L12;
        g6 r101 = (g6) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Float.compare(this.headPlug, r101.headPlug) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.unHeadPlug, r101.unHeadPlug) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((r101 * 31) + Float.floatToIntBits(this.headPlug)) * 31) + Float.floatToIntBits(this.unHeadPlug);
    }

    public final String toString() {
        return "GameLiveAudioVolumeConfig(enable=" + this.enable + ", headPlug=" + this.headPlug + ", unHeadPlug=" + this.unHeadPlug + ")";
    }

    public g6() {
        this.enable = false;
        this.headPlug = 0.5f;
        this.unHeadPlug = 0.01f;
    }
}
