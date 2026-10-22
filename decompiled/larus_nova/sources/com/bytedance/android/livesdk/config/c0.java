package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/c0;", "", "", "liveFirstDuration", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "liveSecondDuration", "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName(IPerformanceManager.MODULE_LIVE_FIRST_DURATION)
    private final long liveFirstDuration;

    @SerializedName(IPerformanceManager.MODULE_LIVE_SECOND_DURATION)
    private final long liveSecondDuration;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L10;
        c0 r101 = (c0) r100;
        if (this.liveFirstDuration == r101.liveFirstDuration) goto L8;
        return false;
    L8:
        if (this.liveSecondDuration == r101.liveSecondDuration) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.liveFirstDuration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.liveSecondDuration;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "AnchorRoomPerfConfig(liveFirstDuration=" + this.liveFirstDuration + ", liveSecondDuration=" + this.liveSecondDuration + ")";
    }

    public final long a() {
        return this.liveFirstDuration;
    }

    public final long b() {
        return this.liveSecondDuration;
    }

    public c0(int r100) {
        this.liveFirstDuration = 5;
        this.liveSecondDuration = 120;
    }
}
