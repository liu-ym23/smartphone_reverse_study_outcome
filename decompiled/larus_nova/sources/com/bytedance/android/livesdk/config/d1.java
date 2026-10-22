package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/d1;", "", "", "enable", "Z", "getEnable", "()Z", "", VideoThumbInfo.KEY_INTERVAL, "J", "getInterval", "()J", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long interval;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d1) == false) goto L10;
        d1 r101 = (d1) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.interval == r101.interval) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.interval;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "CameraDirtyDetectConfig(enable=" + this.enable + ", interval=" + this.interval + ")";
    }

    public d1() {
        this.enable = false;
        this.interval = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    }
}
