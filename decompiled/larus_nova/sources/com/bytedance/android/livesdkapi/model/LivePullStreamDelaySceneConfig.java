package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePullStreamDelaySceneConfig;", "", "enable", "", "delayDuration", "", "(IF)V", "getDelayDuration", "()F", "getEnable", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePullStreamDelaySceneConfig {

    @SerializedName("duration")
    private final float delayDuration;

    @SerializedName("enable")
    private final int enable;

    public static /* synthetic */ LivePullStreamDelaySceneConfig copy$default(LivePullStreamDelaySceneConfig r100, int r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.delayDuration;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.enable;
    }

    public final float component2() {
        return this.delayDuration;
    }

    public final LivePullStreamDelaySceneConfig copy(int r100, float r101) {
        return new LivePullStreamDelaySceneConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LivePullStreamDelaySceneConfig) == false) goto L10;
        LivePullStreamDelaySceneConfig r101 = (LivePullStreamDelaySceneConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Float.compare(this.delayDuration, r101.delayDuration) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.enable * 31) + Float.floatToIntBits(this.delayDuration);
    }

    public String toString() {
        return "LivePullStreamDelaySceneConfig(enable=" + this.enable + ", delayDuration=" + this.delayDuration + ")";
    }

    public final float getDelayDuration() {
        return this.delayDuration;
    }

    public final int getEnable() {
        return this.enable;
    }

    public LivePullStreamDelaySceneConfig(int r100, float r101) {
        this.enable = r100;
        this.delayDuration = r101;
    }
}
