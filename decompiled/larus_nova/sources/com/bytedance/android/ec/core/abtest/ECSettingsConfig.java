package com.bytedance.android.ec.core.abtest;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/ECSettingsConfig;", "Ljava/io/Serializable;", "preloadEnable", "", "cacheEnable", "delayInitDuration", "", "batchSize", "", "sleepTime", "(ZZJIJ)V", "getBatchSize", "()I", "getCacheEnable", "()Z", "getDelayInitDuration", "()J", "getPreloadEnable", "getSleepTime", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSettingsConfig implements Serializable {

    @SerializedName("batch_size")
    private final int batchSize;

    @SerializedName("cache_enable")
    private final boolean cacheEnable;

    @SerializedName("delay_init_duration")
    private final long delayInitDuration;

    @SerializedName("preload_enable")
    private final boolean preloadEnable;

    @SerializedName(MonitorConstants.EXTRA_TASK_SLEEP_TIME)
    private final long sleepTime;

    public ECSettingsConfig() {
        this(false, false, 0, 0, 0, 31, null);
    }

    public final int getBatchSize() {
        return this.batchSize;
    }

    public final boolean getCacheEnable() {
        return this.cacheEnable;
    }

    public final long getDelayInitDuration() {
        return this.delayInitDuration;
    }

    public final boolean getPreloadEnable() {
        return this.preloadEnable;
    }

    public final long getSleepTime() {
        return this.sleepTime;
    }

    public ECSettingsConfig(boolean r100, boolean r101, long r102, int r103, long r104) {
        this.preloadEnable = r100;
        this.cacheEnable = r101;
        this.delayInitDuration = r102;
        this.batchSize = r103;
        this.sleepTime = r104;
    }

    public /* synthetic */ ECSettingsConfig(boolean r100, boolean r101, long r102, int r103, long r110, int r111, DefaultConstructorMarker r112) {
        int r104 = 0;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r106 = r102;
        if ((r111 & 8) != 0) goto L18;
        r104 = r103;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r110 = 200;
    L20:
        long r114 = r110;
        this(r113, r105, r106, r104, r114);
        return;
    L9:
        r105 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
