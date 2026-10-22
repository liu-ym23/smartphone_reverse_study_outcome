package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "Ljava/io/Serializable;", "()V", "backupUrl", "", "getBackupUrl", "()Ljava/lang/String;", "duration", "", "getDuration", "()J", "height", "getHeight", "mainUrl", "getMainUrl", "posterUrl", "getPosterUrl", "videoId", "getVideoId", "width", "getWidth", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionVideoInfo implements Serializable {

    @SerializedName(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL)
    private final String backupUrl;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("height")
    private final long height;

    @SerializedName("main_url")
    private final String mainUrl;

    @SerializedName("poster_url")
    private final String posterUrl;

    @SerializedName("vid")
    private final String videoId;

    @SerializedName("width")
    private final long width;

    public PromotionVideoInfo() {
        this.videoId = "";
        this.mainUrl = "";
        this.backupUrl = "";
        this.posterUrl = "";
    }

    public final String getBackupUrl() {
        return this.backupUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final long getWidth() {
        return this.width;
    }
}
