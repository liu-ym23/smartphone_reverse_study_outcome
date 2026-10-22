package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AesBoostConfig;", "", "()V", "brightnessMean", "", "getBrightnessMean", "()D", "setBrightnessMean", "(D)V", "enable", "", "getEnable", "()I", "setEnable", "(I)V", "groupId", "getGroupId", "setGroupId", "operateReason", "", "getOperateReason", "()Ljava/lang/String;", "setOperateReason", "(Ljava/lang/String;)V", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AesBoostConfig {
    private double brightnessMean;
    private int enable;
    private int groupId;
    private String operateReason;

    public String toString() {
        return "AesBoostConfig(enable=" + this.enable + ", groupId=" + this.groupId + ", operatReason=" + this.operateReason + ", brightnessMean=" + this.brightnessMean + ')';
    }

    public AesBoostConfig() {
        this.enable = -1;
        this.groupId = -1;
        this.operateReason = "";
        this.brightnessMean = -1.0d;
    }

    public final double getBrightnessMean() {
        return this.brightnessMean;
    }

    public final int getEnable() {
        return this.enable;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final String getOperateReason() {
        return this.operateReason;
    }

    public final void setBrightnessMean(double r100) {
        this.brightnessMean = r100;
    }

    public final void setEnable(int r100) {
        this.enable = r100;
    }

    public final void setGroupId(int r100) {
        this.groupId = r100;
    }

    public final void setOperateReason(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.operateReason = r100;
    }
}
