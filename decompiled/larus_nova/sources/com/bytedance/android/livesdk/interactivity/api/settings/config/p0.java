package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/p0;", "", "", "level", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "updateInterval", "J", "d", "()J", "updateScrollSize", "e", "updateFoldSize", "c", "msPerInch", "b", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("level")
    private final int level;

    @SerializedName("ms_per_inch")
    private final int msPerInch;

    @SerializedName("fold_size")
    private final int updateFoldSize;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long updateInterval;

    @SerializedName("scroll_size")
    private final int updateScrollSize;

    public p0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == false) goto L16;
        p0 r101 = (p0) r100;
        if (this.level == r101.level) goto L8;
        return false;
    L8:
        if (this.updateInterval == r101.updateInterval) goto L10;
        return false;
    L10:
        if (this.updateScrollSize == r101.updateScrollSize) goto L12;
        return false;
    L12:
        if (this.updateFoldSize == r101.updateFoldSize) goto L14;
        return false;
    L14:
        if (this.msPerInch == r101.msPerInch) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.level * 31;
        long r101 = this.updateInterval;
        return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.updateScrollSize) * 31) + this.updateFoldSize) * 31) + this.msPerInch;
    }

    public final String toString() {
        return "PublicScreenSpeedConfigV2(level=" + this.level + ", updateInterval=" + this.updateInterval + ", updateScrollSize=" + this.updateScrollSize + ", updateFoldSize=" + this.updateFoldSize + ", msPerInch=" + this.msPerInch + ")";
    }

    public final int a() {
        return this.level;
    }

    public final int b() {
        return this.msPerInch;
    }

    public final int c() {
        return this.updateFoldSize;
    }

    public final long d() {
        return this.updateInterval;
    }

    public final int e() {
        return this.updateScrollSize;
    }

    public /* synthetic */ p0(int r100) {
        this(2, 1000, 2, 1, 550);
    }

    public p0(int r100, long r101, int r102, int r103, int r104) {
        this.level = r100;
        this.updateInterval = r101;
        this.updateScrollSize = r102;
        this.updateFoldSize = r103;
        this.msPerInch = r104;
    }
}
