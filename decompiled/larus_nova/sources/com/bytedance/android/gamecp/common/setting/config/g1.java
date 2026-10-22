package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/g1;", "", "", "frameType", "I", "getFrameType", "()I", "insertTimePoint", "getInsertTimePoint", "Lcom/bytedance/android/gamecp/common/setting/config/u0;", "durationConfig", "Lcom/bytedance/android/gamecp/common/setting/config/u0;", "getDurationConfig", "()Lcom/bytedance/android/gamecp/common/setting/config/u0;", "timeOutThreshold", "getTimeOutThreshold", "extractFrameIndex", "getExtractFrameIndex", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g1 {

    @SerializedName("duration_config")
    private final u0 durationConfig;

    @SerializedName("extract_frame_index")
    private final int extractFrameIndex;

    @SerializedName("frame_type")
    private final int frameType;

    @SerializedName("insert_time_point")
    private final int insertTimePoint;

    @SerializedName("timeout_threshold")
    private final int timeOutThreshold;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g1) == false) goto L16;
        g1 r101 = (g1) r100;
        if (this.frameType == r101.frameType) goto L8;
        return false;
    L8:
        if (this.insertTimePoint == r101.insertTimePoint) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.durationConfig, r101.durationConfig) == true) goto L12;
        return false;
    L12:
        if (this.timeOutThreshold == r101.timeOutThreshold) goto L14;
        return false;
    L14:
        if (this.extractFrameIndex == r101.extractFrameIndex) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.frameType * 31) + this.insertTimePoint) * 31;
        u0 r101 = this.durationConfig;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((r100 + r102) * 31) + this.timeOutThreshold) * 31) + this.extractFrameIndex;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "GameCpVideoProcessingConfig(frameType=" + this.frameType + ", insertTimePoint=" + this.insertTimePoint + ", durationConfig=" + this.durationConfig + ", timeOutThreshold=" + this.timeOutThreshold + ", extractFrameIndex=" + this.extractFrameIndex + ")";
    }

    public g1() {
        u0 r100 = new u0(0);
        this.frameType = 0;
        this.insertTimePoint = 0;
        this.durationConfig = r100;
        this.timeOutThreshold = 20;
        this.extractFrameIndex = 150;
    }
}
