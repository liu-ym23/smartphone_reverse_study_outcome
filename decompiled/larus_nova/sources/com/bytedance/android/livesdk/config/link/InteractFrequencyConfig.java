package com.bytedance.android.livesdk.config.link;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: loaded from: classes8.dex */
public class InteractFrequencyConfig {

    @SerializedName("cd_time")
    public int cdTime;

    @SerializedName("gap_time")
    public int gapTime;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    public int maxCount;

    public InteractFrequencyConfig() {
        this.maxCount = 4;
        this.gapTime = 30;
        this.cdTime = 30;
    }
}
